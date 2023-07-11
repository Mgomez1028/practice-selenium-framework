package com.lilo.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StorePage extends BasePage {

    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.className("woocommerce-products-header__title");
    //private final By addToCartBtn= By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");


    public StorePage(WebDriver webDriver) {
        super(webDriver);
    }

    private StorePage enterTextSearchFld(String txt) {
        driver.findElement(searchFld).clear();
        driver.findElement(searchFld).sendKeys(txt);
        return this;
    }

    private StorePage clickearchBtn() {
        driver.findElement(searchBtn).click();
        return this;
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    private By getAddToCartBtnElement(String productName){
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    public void clickAddToCartBtn(String productName) {
        By addToCartBtn = getAddToCartBtnElement(productName);
        driver.findElement(addToCartBtn).click();
    }

    public StorePage searchItem(String txt) {
        enterTextSearchFld(txt).clickearchBtn();
        return this;
    }

    public CartPage clickViewCart(){
        driver.findElement(viewCartLink).click();
        return new CartPage(driver);
    }


}
