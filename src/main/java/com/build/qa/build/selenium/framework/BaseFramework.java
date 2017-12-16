package com.build.qa.build.selenium.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public abstract class BaseFramework {
	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	private static final Logger LOG = LoggerFactory.getLogger(BaseFramework.class);
	private static final String CONFIG_FILE = "./conf/automation.properties";
	private static final String DRIVER_FIREFOX = "firefox";
	private static final String DRIVER_CHROME = "chrome";
	private static final String DRIVER_SAFARI = "safari";
	private static Properties configuration;
	String currentPath = System.getProperty("user.dir");
	DesiredCapabilities capability = new DesiredCapabilities();
	
	@Rule
	public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

	@BeforeClass
	public static void beforeClass() throws IOException {
		configuration = new Properties();
		FileInputStream input;

		LOG.info("Loading in configuration file.");
		input = new FileInputStream(new File(CONFIG_FILE));
		configuration.loadFromXML(input);
		input.close();
	}

	@Before
	public void setUpBefore() {
		
		System.out.println(System.getProperty("BROWSER"));
		DesiredCapabilities capabilities;
		// Which driver to use? 
		if (DRIVER_CHROME.equalsIgnoreCase(System.getProperty("BROWSER"))) {
			capabilities = DesiredCapabilities.chrome();
			driver = new ChromeDriver(capabilities);
		} else if (DRIVER_FIREFOX.equalsIgnoreCase(System.getProperty("BROWSER"))) {
			capabilities = DesiredCapabilities.firefox();
			driver = new FirefoxDriver(capabilities);
		}else if(DRIVER_FIREFOX.equalsIgnoreCase(configuration.getProperty("BROWSER"))){
			capabilities = DesiredCapabilities.firefox();
			driver = new FirefoxDriver(capabilities);
		}else if(DRIVER_SAFARI.equalsIgnoreCase(System.getProperty("BROWSER"))){
			capabilities = DesiredCapabilities.safari();
			driver = new SafariDriver(capabilities);
		}
		
		else {
			
		
		
		if(!System.getProperty("CONFIG").isEmpty()){
			String configFileName=System.getProperty("CONFIG");
			String platform="";
			if(!configFileName.isEmpty())
			{
				try
				{
					platform = configFileName.split("_")[0].toLowerCase();
					System.out.println("Platform ="+platform);
				}
				catch(Exception e)
				{
					System.out.println("Exception : Invalid config file name "+configFileName+".properties");
					System.out.println("E.g : android_nexus5.properties");
					System.out.println("E.g : ios_iphone6.properties");
					
				}
				
				try {
					InputStream input = new FileInputStream("./conf/"+configFileName);
					capability = getCapability(input);
					if(platform.equalsIgnoreCase("android")){
						driver= androidDriver(capability);
					}else if(platform.equalsIgnoreCase("ios")){
						driver= androidDriver(capability);
					}else{
						System.out.println("Invalid platform");
						System.exit(0);
					}
				}catch (FileNotFoundException e) {
					System.out.println("\nException : Config file not found with name '"+configFileName+".properties'");
					System.exit(0);
				}
			}
		}
		
		}
		
		// Define fluent wait
		wait = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
	}

	private WebDriver androidDriver(DesiredCapabilities capabilities) {
		
		String port = "4723";	
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:"+port+"/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
    }
    
	public DesiredCapabilities getCapability(InputStream input) {
		Properties prop = new Properties();
    	
    	try {
    		prop.load(input);
    		
    		// set capabilities
    		Enumeration<Object> enuKeys = prop.keys();
    		while (enuKeys.hasMoreElements()) {
    			String key = (String) enuKeys.nextElement();
    			String value = prop.getProperty(key);
    			capability.setCapability(key, value);
    		}
    		input.close();
    		prop.clear();
    	}catch(Exception e) {
    		e.printStackTrace();
			System.exit(0);
    	}
    	return capability;
    }
	
	
	
    private WebDriver iosDriver(DesiredCapabilities capabilities)
    {
    	
		String port = "4723";	
		try {
			driver = new IOSDriver(new URL("http://127.0.0.1:"+port+"/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
    }
	
	
	protected WebDriver getDriver() {
		return driver;
	}
	
	protected String getConfiguration(String config) { 
		return configuration.getProperty(config);
	}

	@After
	public void tearDownAfter() {
		LOG.info("Quitting driver.");
		driver.quit();
		driver = null;
	}
}
