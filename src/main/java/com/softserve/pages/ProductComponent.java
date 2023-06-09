package com.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductComponent {

	private WebElement productLayout;
	private WebElement name;
	private WebElement partialDescription;
	private WebElement price;
	private WebElement addToCartButton;
	private WebElement addToWishButton;
	private WebElement addToCompareButton;

	public ProductComponent(WebElement productLayout) {
		this.productLayout = productLayout;
		name = productLayout.findElement(By.cssSelector("h4 a"));
		partialDescription = productLayout.findElement(By.cssSelector("h4 + p"));
		price = productLayout.findElement(By.cssSelector(".price"));
		addToCartButton = productLayout.findElement(By.cssSelector(".fa.fa-shopping-cart"));
		addToWishButton = productLayout.findElement(By.cssSelector(".fa.fa-heart"));
		addToCompareButton = productLayout.findElement(By.cssSelector(".fa.fa-exchange"));
	}

	public WebElement getProductLayout() {
		return productLayout;
	}

	public WebElement getName() {
		return name;
	}

	public String getNameText() {
		return getName().getText();
	}

	public void clickName() {
		getName().click();
	}

	public WebElement getPartialDescription() {
		return partialDescription;
	}

	public String getPartialDescriptionText() {
		return getPartialDescription().getText();
	}

	public WebElement getPrice() {
		return price;
	}

	public String getPriceText() {
		return getPrice().getText();
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public void clickAddToCartButton() {
		getAddToCartButton().click();
	}

	public WebElement getAddToWishButton() {
		return addToWishButton;
	}

	public void clickAddToWishButton() {
		getAddToWishButton().click();
	}

	public WebElement getAddToCompareButton() {
		return addToCompareButton;
	}

	public void clickAddToCompareButton() {
		getAddToCompareButton().click();
	}
}