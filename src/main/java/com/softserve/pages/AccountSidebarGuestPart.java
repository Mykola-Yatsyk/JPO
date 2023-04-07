package com.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AccountSidebarGuestPart extends AccountSidebarPart {

	private WebElement loginRight;
	private WebElement registerRight;
	private WebElement forgottenPasswordRight;

	public AccountSidebarGuestPart(WebDriver driver) {
		super(driver);
		loginRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/login')]"));
		registerRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/register')]"));
		forgottenPasswordRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/forgotten')]"));
	}

	public WebElement getLoginRight() {
		return loginRight;
	}

	public String getLoginRightText() {
		return getLoginRight().getText();
	}

	public void clickLoginRight() {
		getLoginRight().click();
	}

	public WebElement getRegisterRight() {
		return registerRight;
	}

	public String getRegisterRightText() {
		return getRegisterRight().getText();
	}

	public void clickRegisterRight() {
		getRegisterRight().click();
	}

	public WebElement getForgottenPasswordRight() {
		return forgottenPasswordRight;
	}

	public String getForgottenPasswordRightText() {
		return getForgottenPasswordRight().getText();
	}

	public void clickForgottenPasswordRight() {
		getForgottenPasswordRight().click();
	}

	public LoginPage gotoLoginRight() {
		clickLoginRight();
		return new LoginPage(driver);
	}
}
