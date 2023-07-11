package com.lilo.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By productName= By.cssSelector("td[class='product-name']");

    private final By checkoutBtn = By.className("checkout-button");
    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }
    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public CheckoutPage checkout(){
        driver.findElement(checkoutBtn).click();
        return new CheckoutPage(driver);
    }
}
