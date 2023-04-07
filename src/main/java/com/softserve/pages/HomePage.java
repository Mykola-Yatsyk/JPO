package com.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.data.Currencies;

public class HomePage extends TopPart {
	public static final String EXPECTED_IPHONE6 = "iPhone6";
	public static final String EXPECTED_IPHONE_6 = "iPhone 6";
	private WebElement slideshow0;
	private ProductsContainer productsContainer;

	public HomePage(WebDriver driver) {
		super(driver);
		slideshow0 = driver.findElement(By.id("carousel-banner-0"));
		productsContainer = new ProductsContainer(driver);
	}

	public WebElement getSlideshow0() {
		return slideshow0;
	}

	public WebElement getSlideshow0FirstImage() {
		return getSlideshow0().findElement(By.xpath(".//a/img"));
	}

	public String getSlideshow0FirstImageAttributeText(String attribute) {
		return getSlideshow0FirstImage().getAttribute(attribute).trim();
	}

	public String getSlideshow0FirstImageAttributeSrcText() {
		return getSlideshow0FirstImageAttributeText(TAG_ATTRIBUTE_SRC);
	}

	public String getSlideshow0FirstImageAttributeAltText() {
		return getSlideshow0FirstImageAttributeText(TAG_ATTRIBUTE_ALT);
	}

	public ProductsContainer getProductComponentsContainer() {
		return productsContainer;
	}

	public HomePage chooseCurrency(Currencies currency) {
		clickCurrencyByPartialName(currency);
		return new HomePage(driver);
	}
}
