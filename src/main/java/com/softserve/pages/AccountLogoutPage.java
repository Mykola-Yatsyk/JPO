package com.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountLogoutPage extends AccountSidebarGuestPart {

	private WebElement continueButton;

	public AccountLogoutPage(WebDriver driver) {
		super(driver);
		continueButton = driver.findElement(By.cssSelector("a.btn.btn-primary[href*='common/home']"));
	}

	public WebElement getContinueButton() {
		return continueButton;
	}

	public String getContinueButtonText() {
		return getContinueButton().getText();
	}

	public void clickContinueButton() {
		getContinueButton().click();
	}

	public HomePage gotoContinue() {
		clickContinueButton();
		return new HomePage(driver);
	}
}