package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class HomePage extends BasePage {
	
	private By buildThemeBody;
	
	
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		buildThemeBody = By.cssSelector("body.build-theme");
		
	}
	
	@FindBy(xpath = ".//input[@id='search_txt']")
	private WebElement searchBar;
	
	@FindBy(xpath = "//div[@class='modal-header table modal-no-title']//button[@class='close js-modal-close ']")
	private WebElement closePopUp;
	
	@FindBy(xpath = "(.//button[@type='submit'])[1]")
	private WebElement clickSearch;
	
	public boolean onBuildTheme() { 
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(buildThemeBody)) != null;
	}
	
	// Closes the subscribe popup
	public void closeEmailSubscription(){
		wait.until(ExpectedConditions.elementToBeClickable(closePopUp));
		closePopUp.click();
	}
	

	public LandingPage searchText(){
		closeEmailSubscription();
		wait.until(ExpectedConditions.visibilityOf(clickSearch));
		searchBar.sendKeys("Quoizel MY1613");
		clickSearch.click();
		return new LandingPage(driver, wait);
	}
}
