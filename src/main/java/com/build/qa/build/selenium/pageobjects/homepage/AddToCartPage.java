package com.build.qa.build.selenium.pageobjects.homepage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class AddToCartPage extends BasePage {

	public AddToCartPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		
	}
	
	@FindBy(xpath = "(//a[@href='/kohler-k-2355/s560600?uid=165124' ])[2]")
	private WebElement productAddedToCart;
	
	@FindBy(xpath = "//button[@class='btn-standard btn-secondary ch-tools-button']")
	private WebElement dropDownClick;
	
	@FindBy(xpath = "//button[@class='btn-standard btn-secondary js-email-cart-button']")
	private WebElement emailCartClick;
	
	@FindBy(xpath = ".//input[@tabindex='1']")
	private WebElement myName;
	
	@FindBy(xpath = ".//input[@tabindex='2']")
	private WebElement myEmail;
	
	@FindBy(xpath = ".//input[@tabindex='3']")
	private WebElement receiverName;
	
	@FindBy(xpath = ".//input[@tabindex='4']")
	private WebElement receiverEmail;
	
	@FindBy(xpath = ".//textarea[@tabindex='8']")
	private WebElement message;
	
	@FindBy(xpath = ".//li[text()='Cart Sent! The cart has been submitted to the recipient via email.']")
	private WebElement alert;
	
	@FindBy(xpath = ".//button[@class='button-primary button js-email-cart-submit-button']")
	private WebElement sendEmail;
	
	public String getProductText(){
		wait.until(ExpectedConditions.elementToBeClickable(productAddedToCart));
		return productAddedToCart.getText();
	}

	public String emailCart() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownClick));
		dropDownClick.click();
		wait.until(ExpectedConditions.elementToBeClickable(emailCartClick));
		emailCartClick.click();
		wait.until(ExpectedConditions.visibilityOf(myName));
		myName.sendKeys("Ram");
		myEmail.sendKeys("rochanram@gmail.com");
		receiverName.sendKeys("Jared");
		receiverEmail.sendKeys("jgilmore+SeleniumTest@build.com");
		scrollToAnElement(message);
		message.sendKeys("This is Ram, sending you a cart from my automation!");
		scrollToAnElement(sendEmail);
		sendEmail.click();
		wait.until(ExpectedConditions.visibilityOf(alert));
		return alert.getText();
		
	}
	
	public void scrollToAnElement(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
}
