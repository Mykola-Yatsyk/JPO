package com.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AccountSidebarLoggedPart extends AccountSidebarPart {

    private WebElement editAccountRight;
    private WebElement passwordRight;
    private WebElement logoutRight;

    public AccountSidebarLoggedPart(WebDriver driver) {
        super(driver);
        editAccountRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/edit')]"));
        passwordRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/password')]"));
        logoutRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/logout')]"));
    }

    public WebElement getEditAccountRight() {
        return editAccountRight;
    }

    public String getEditAccountRightText() {
        return getEditAccountRight().getText();
    }

    public void clickEditAccountRight() {
        getEditAccountRight().click();
    }

    public WebElement getPasswordRight() {
        return passwordRight;
    }

    public String getPasswordRightText() {
        return getPasswordRight().getText();
    }

    public void clickPasswordRight() {
        getPasswordRight().click();
    }
    
    public WebElement getLogoutRight() {
        return logoutRight;
    }

    public String getLogoutRightText() {
        return getLogoutRight().getText();
    }

    public void clickLogoutRight() {
        getLogoutRight().click();
    }

    public EditAccountPage gotoEditAccountRight() {
        clickEditAccountRight();
        return new EditAccountPage(driver);
    }

    public AccountLogoutPage gotoLogoutRight() {
        clickLogoutRight();
        return new AccountLogoutPage(driver);
    }

    public MyAccountPage gotoMyAccountRight() {
        clickMyAccountRight();
        return new MyAccountPage(driver);
    }
}