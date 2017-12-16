package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class BathroomSinksPage extends BasePage{

	public BathroomSinksPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		
	}

	@FindBy(xpath = ".//span[text()=' Archer 19-5/8\" Undermount Bathroom Sink with Overflow']")
	private WebElement secondItem;
	
	@FindBy(xpath = "//button[text()='Add to Cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//button[@href='/index.cfm?page=cart:cart' ]")
	private WebElement goToCartButton;
	
	@FindBy(xpath = "//strong[text()='Free Shipping!']")
	private WebElement freeShipping;
	
	@FindBy(xpath = "(//div[@class='modal-header table modal-no-title']//button[@class='close js-modal-close '])[2]")
	private WebElement closePopUp;
	
	public AddToCartPage addSecondProductToCart() {
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		closeEmailSubscription();
		scrollToAnElement(secondItem);
		secondItem.click();
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		scrollToAnElement(freeShipping);
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		addToCartButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		goToCartButton.click();
		return new AddToCartPage(driver, wait);
		
	}
	
	public void closeEmailSubscription(){
		wait.until(ExpectedConditions.elementToBeClickable(closePopUp));
		closePopUp.click();
	}

	public void scrollToAnElement(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	
}
