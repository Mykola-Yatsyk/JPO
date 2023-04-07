package com.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AccountSidebarGuestPart {

    private WebElement email;
    private WebElement password;
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        email = driver.findElement(By.name("email"));
        password = driver.findElement(By.name("password"));
        loginButton = driver.findElement(By.cssSelector("input.btn.btn-primary"));
    }

    public WebElement getEmail() {
        return email;
    }

    public String getEmailText() {
        return getEmail().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearEmailField() {
        getEmail().clear();
    }

    public void clickEmailField() {
        getEmail().click();
    }

    public void setEmail(String email) {
        getEmail().sendKeys(email);
    }

    public WebElement getPassword() {
        return password;
    }

    public String getPasswordText() {
        return getPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearPasswordField() {
        getPassword().clear();
    }

    public void clickPasswordField() {
        getPassword().click();
    }

    public void setPassword(String password) {
        getPassword().sendKeys(password);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public String getLoginButtonText() {
        return getLoginButton().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }
}