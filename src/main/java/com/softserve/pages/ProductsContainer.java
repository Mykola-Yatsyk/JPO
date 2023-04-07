package com.softserve.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsContainer {

    public final String PRODUCT_NOT_FOUND = "There is no product that matches the search criteria.";
    private final String PRODUCT_COMPONENT_CSSSELECTOR = ".product-layout";

    protected WebDriver driver;

    private List<ProductComponent> productComponents;

    public ProductsContainer(WebDriver driver) {
        this.driver = driver;
        productComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(PRODUCT_COMPONENT_CSSSELECTOR))) {
            productComponents.add(new ProductComponent(current));
        }
    }

    public List<ProductComponent> getProductComponents() {
        return productComponents;
    }

    public int getProductComponentsCount() {
        return getProductComponents().size();
    }

    public List<String> getProductComponentNames() {
        List<String> productComponentNames = new ArrayList<>();
        for (ProductComponent current : getProductComponents()) {
            productComponentNames.add(current.getNameText());
        }
        return productComponentNames;
    }

    public ProductComponent getProductComponentByName(String productName) {
        ProductComponent result = null;
        for (ProductComponent current : getProductComponents()) {
            if (current.getNameText().toLowerCase().equals(productName.toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) throw new RuntimeException("ProductName: " + productName + " not Found.");
        return result;
    }

    public String getProductComponentPriceByName(String productName) {
        return getProductComponentByName(productName).getPriceText();
    }
    
    public String getProductComponentDescriptionByName(String productName) {
        return getProductComponentByName(productName).getPartialDescriptionText();
    }
    
    public void clickProductComponentAddToCartButtonByName(String productName) {
        getProductComponentByName(productName).clickAddToCartButton();
    }
    
    public void clickProductComponentAddToWishButtonByName(String productName) {
        getProductComponentByName(productName).clickAddToWishButton();
    }
}