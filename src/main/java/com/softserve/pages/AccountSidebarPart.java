package com.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AccountSidebarPart extends TopPart {

    private WebElement myAccountRight;
    private WebElement addressBookRight;
    private WebElement wishListRight;
    private WebElement orderHistoryRight;
    private WebElement downloadsRight;
    private WebElement recurringpaymentsRight;
    private WebElement rewardPointsRight;
    private WebElement returnsRight;
    private WebElement transactionsRight;
    private WebElement newsletterRight;

    public AccountSidebarPart(WebDriver driver) {
        super(driver);
        myAccountRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/account')]"));
        addressBookRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/address')]"));
        wishListRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/wishlist')]"));
        orderHistoryRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/order')]"));
        downloadsRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/download')]"));
        recurringpaymentsRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/recurring')]"));
        rewardPointsRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/reward')]"));
        returnsRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/return')]"));
        transactionsRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/transaction')]"));
        newsletterRight = driver.findElement(By.xpath("//div[@class='list-group']/a[contains(@href, 'account/newsletter')]"));
    }
    
    public WebElement getMyAccountRight() {
        return myAccountRight;
    }

    public String getMyAccountRightText() {
        return getMyAccountRight().getText();
    }

    public void clickMyAccountRight() {
        getMyAccountRight().click();
    }
    
    public WebElement getAddressBookRight() {
        return addressBookRight;
    }

    public String getAddressBookRightText() {
        return getAddressBookRight().getText();
    }

    public void clickAddressBookRight() {
        getAddressBookRight().click();
    }

    public WebElement getWishListRight() {
        return wishListRight;
    }

    public String getWishListRightText() {
        return getWishListRight().getText();
    }

    public void clickWishListRight() {
        getWishListRight().click();
    }

    public WebElement getOrderHistoryRight() {
        return orderHistoryRight;
    }

    public String getOrderHistoryRightText() {
        return getOrderHistoryRight().getText();
    }

    public void clickOrderHistoryRight() {
        getOrderHistoryRight().click();
    }

    public WebElement getDownloadsRight() {
        return downloadsRight;
    }

    public String getDownloadsRightText() {
        return getDownloadsRight().getText();
    }

    public void clickDownloadsRight() {
        getDownloadsRight().click();
    }

    public WebElement getRecurringpaymentsRight() {
        return recurringpaymentsRight;
    }

    public String getRecurringpaymentsRightText() {
        return getRecurringpaymentsRight().getText();
    }

    public void clickRecurringpaymentsRight() {
        getRecurringpaymentsRight().click();
    }

    public WebElement getRewardPointsRight() {
        return rewardPointsRight;
    }

    public String getRewardPointsRightText() {
        return getRewardPointsRight().getText();
    }

    public void clickRewardPointsRight() {
        getRewardPointsRight().click();
    }

    public WebElement getReturnsRight() {
        return returnsRight;
    }

    public String getReturnsRightText() {
        return getReturnsRight().getText();
    }

    public void clickReturnsRight() {
        getReturnsRight().click();
    }

    public WebElement getTransactionsRight() {
        return transactionsRight;
    }

    public String getTransactionsRightText() {
        return getTransactionsRight().getText();
    }

    public void clickTransactionsRight() {
        getTransactionsRight().click();
    }

    public WebElement getNewsletterRight() {
        return newsletterRight;
    }

    public String getNewsletterRightText() {
        return getNewsletterRight().getText();
    }

    public void clickNewsletterRight() {
        getNewsletterRight().click();
    }
}