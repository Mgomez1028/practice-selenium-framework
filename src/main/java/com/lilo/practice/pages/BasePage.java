package com.lilo.practice.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
    }
}
