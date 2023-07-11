package com.lilo.practice.test;

import com.lilo.practice.config.DriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    protected WebDriver driver;


    @BeforeEach
    public void setupDriver() {
        System.out.println("inicia test");
        driver = new DriverManager().initializeDriver();
    }

    @AfterEach
    public void quiteDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
//Note: if a want to execute isolation test and maybe avoid unexpected side effects, and I dont have a lot of test scenarios
// I MUST FOLLOW THIS STESPS:
//1. protected WebDriver driver;
//2. notations beforeeach/aftereach
//3.not static methods

//while if I wanna run with a unique driver instance because I have many scanarios, and it not represent any prroblem  (not unexpected behavor)
// I MUST FOLLOW THIS STESPS:
//1. static WebDriver driver;
//2. notations beforeAll/afterAll
//3. static methods
//4. MyFirstTest class; should have this notation: @TestInstance(Lifecycle.PER_CLASS) ->JUNIT 5 BEHAVOR

//Adding @TestInstance(TestInstance.Lifecycle.PER_CLASS) to your test class will avoid that a new instance of your class is created for every test in the class. This is particulary usefull when you have a lot of tests in the same test class and the instantiation of this class is expensive.
//
// This annotation should be used with caution. All unit tests should be isolated and independent of eachother. If one of the tests changes the state od the test class then you should not use this feature.
//
//Making your fields static to achieve the same effect is not a good idea. It will indeed reduce the number of objects created but they cannot be cleaned up when all tests in the test class are executed. This can cause problems when you have a giant test suite.
