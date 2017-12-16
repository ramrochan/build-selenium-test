package com.build.qa.build.selenium.pageobjects.homepage;

import java.math.BigDecimal;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class LightingPage extends BasePage{

	public LightingPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
	}

	@FindBy(xpath = "//button[text()='Add to Cart']")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//img[@alt='Saber 2 Light 20-1/4\" Wide Bath Bar with Etched Opal Shade' ]")
	private WebElement firstItem;
	
	@FindBy(xpath = "//button[@href='/index.cfm?page=cart:cart' ]")
	private WebElement goToCartButton;
	
	@FindBy(xpath = "(//div[@class='modal-header table modal-no-title']//button[@class='close js-modal-close '])[2]")
	private WebElement closePopUp;
	
	@FindBy(xpath = "//label[@class='sub-item qa-facetGroup-Color-facetValue-Blues']")
	private WebElement firstFilterColor;
	
	@FindBy(xpath = "//span[@class='js-num-results']")
	private WebElement resultCount;
	
	@FindBy(xpath = "//label[@class='sub-item qa-facetGroup-Fixture Type-facetValue-Bathroom Sconce']")
	private WebElement secondFilterFixture;
	
	@FindBy(xpath = "//div[@class='text-price' ]")
	private WebElement textPrice;
	
	@FindBy(xpath = "//label[@class='sub-item qa-facetGroup-Color-facetValue-Blues']//span[@class='count']")
	private WebElement secondFilterColorCount;
	
	@FindBy(xpath = "//label[@class='sub-item qa-facetGroup-Color-facetValue-Blues']//span[@class='count']")
	private WebElement firstFilterColorCount;
	
	public AddToCartPage addProductToCart() {
		closeEmailSubscription();
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		scrollToAnElement(firstItem);
		firstItem.click();
		wait.until(ExpectedConditions.visibilityOf(textPrice));
		scrollToAnElement(addToCartButton);
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		addToCartButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		goToCartButton.click();
		return new AddToCartPage(driver,wait);
	}

	public void scrollToAnElement(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	public void closeEmailSubscription(){
		wait.until(ExpectedConditions.elementToBeClickable(closePopUp));
		closePopUp.click();
	}

	public int addFirstFilter() {
		closeEmailSubscription();
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		scrollToAnElement(firstFilterColor);
		firstFilterColor.click();
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		int count=Integer.parseInt(resultCount.getText());
		return count;
	}

	public int addSecondFilter() {
		driver.navigate().to("https://www.build.com/bathroom-lighting/c108533?f19208=blues&r=48&s=SCORE&p=1&categoryId=108533");
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		scrollToAnElement(secondFilterFixture);
		secondFilterFixture.click();
		wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
		int count=Integer.parseInt(resultCount.getText());
		return count;
	}

	public Object getFirstFilteredResultCountFromElement() {
		driver.navigate().to("https://www.build.com/bathroom-lighting/c108533?f19208=blues&r=48&s=SCORE&p=1&categoryId=108533");
		wait.until(ExpectedConditions.visibilityOf(resultCount));
		return Integer.parseInt(resultCount.getText());
	}

	public Object getSecondFilteredResultCountFromElement() {
		driver.navigate().to("https://www.build.com/bathroom-lighting/c108533?f19213=bathroom%20sconce&f19208=blues&r=48&s=SCORE&p=1&categoryId=108533");
		wait.until(ExpectedConditions.visibilityOf(resultCount));
		return Integer.parseInt(resultCount.getText());
	}
	
	
}
