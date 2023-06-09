package com.softserve.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropdownComponent {

    protected final String OPTIONNAME_NOT_FOUND = "OptionName not Found.";
    protected WebDriver driver;
    private List<WebElement> listOptions;

    public DropdownComponent(WebDriver driver, By searchLocator) {
        this.driver = driver;
        listOptions = driver.findElements(searchLocator);
    }
    
    public List<WebElement> getListOptions() {
        return listOptions;
    }

    public WebElement getDropdownOptionByPartialName(String optionName) {
        WebElement result = null;
        for (WebElement current : getListOptions()) {
            if (current.getText().toLowerCase().contains(optionName.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) throw new RuntimeException(OPTIONNAME_NOT_FOUND);
        return result;
    }

    public List<String> getListOptionsText() {
        List<String> result = new ArrayList<>();
        for (WebElement current : getListOptions()) {
            result.add(current.getText());
        }
        return result;
    }

    public boolean isExistDropdownOptionByPartialName(String optionName) {
        boolean isFound = false;
        for (String current : getListOptionsText()) {
            if (current.toLowerCase().contains(optionName.toLowerCase())) {
                isFound = true;
                break;
            }
        }
        return isFound;
    }

    public void clickDropdownOptionByPartialName(String optionName) {
        getDropdownOptionByPartialName(optionName).click();
    }
}