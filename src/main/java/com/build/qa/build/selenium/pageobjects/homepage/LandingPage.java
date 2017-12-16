package com.build.qa.build.selenium.pageobjects.homepage;

import java.math.BigDecimal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class LandingPage extends BasePage{

	public LandingPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		
	}
	
	@FindBy(xpath = ".//h1[@id='heading']")
	private WebElement landingPageResultForSearch;

	public String getText() {
		wait.until(ExpectedConditions.textToBePresentInElement(landingPageResultForSearch, "Quoizel MY1613ML"));
		return landingPageResultForSearch.getText();
		
	}
}
