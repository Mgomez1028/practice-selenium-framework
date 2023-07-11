package com.lilo.practice.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;

import static com.lilo.practice.config.Environment.getEnvVariable;

public class DriverManager {

    private WebDriver driver;

    private Logger log = LogManager.getLogger(this.getClass());

    public WebDriver initializeDriverOLD() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }



    public WebDriver initializeDriver() {
        String browser = getEnvVariable("browser");
        log.debug("Running on browser: " + browser);
        switch (browser) {
            case "chrome":
                SeleniumManager.getInstance();
                driver = new ChromeDriver();
                break;
            case "firefox":
                SeleniumManager.getInstance();
                driver = new FirefoxDriver();
                break;
            case "edge":
                SeleniumManager.getInstance();
                driver = new EdgeDriver();
                break;
            default:
                log.fatal("Invalid browser/browser config doesnt exist");
        }
        log.debug("Driver initialized");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }


}
