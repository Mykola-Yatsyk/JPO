package com.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestDropdown {

    private WebDriver driver;
    private WebElement register;
    private WebElement login;

    public GuestDropdown(WebDriver driver) {
        this.driver = driver;
        register = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/register')]"));
        login = driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href,'account/login')]"));
    }
    
    public WebElement getRegister() {
        return register;
    }

    public String getRegisterText() {
        return getRegister().getText();
    }

    public void clickRegister() {
        getRegister().click();
    }

    public WebElement getLogin() {
        return login;
    }

    public String getLoginText() {
        return getLogin().getText();
    }

    public void clickLogin() {
        getLogin().click();
    }
}