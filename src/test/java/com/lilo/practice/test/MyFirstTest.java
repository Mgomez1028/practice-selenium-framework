package com.lilo.practice.test;

import com.lilo.practice.pages.CartPage;
import com.lilo.practice.pages.CheckoutPage;
import com.lilo.practice.pages.HomePage;
import com.lilo.practice.pages.StorePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class MyFirstTest extends BaseTest {

    @Test
    public void LoginPageSuccess(){
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        driver.findElement(By.id("email-input")).sendKeys("login@codility.com");
        driver.findElement(By.id("password-input")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
        String message = driver.findElement(By.xpath("//div[@class='message success']")).getText();
        assertEquals(message, "Welcome to Codility");
    }

    @Test
    public void LoginPageInvalidEmail(){
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        driver.findElement(By.id("email-input")).sendKeys("login");
        driver.findElement(By.id("password-input")).sendKeys("password");
        driver.findElement(By.id("login-button")).click();
        String message = driver.findElement(By.cssSelector("#messages div")).getText();
        assertEquals(message, "Enter a valid email");
    }

    @Test
    public void LoginPageInvalidPassword(){
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        driver.findElement(By.id("email-input")).sendKeys("login@codility.com");
        driver.findElement(By.id("password-input")).sendKeys("password123");
        driver.findElement(By.id("login-button")).click();
        String message = driver.findElement(By.cssSelector("#messages div")).getText();
        assertEquals(message, "You shall not pass! Arr!");
    }

    @Test
    public void LoginPageEmptyCredentials(){
        driver.get("https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html");
        driver.findElement(By.id("login-button")).click();
        String messageEmail = driver.findElement(By.xpath("//div[@id='messages']/div[1]")).getText();
        String messagePassword = driver.findElement(By.xpath("//div[@id='messages']/div[2]")).getText();
        assertEquals(messageEmail, "Email is required");
        assertEquals(messagePassword, "Password is required");
    }



    @Test
    public void guestCheckoutUsingDirectTransferTest() throws InterruptedException {
        //System.setProperty("Web.driver.chrome.driver","C:\\drivers\\chromedriver.exe");
        System.out.println("imprimiendo guestCheckoutUsingDirectTransferTest ");//You shall not pass! Arr!
        driver.get("https://askomdch.com");
        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.navigateToStoreUsingMenu();
        storePage.searchItem("Blue");
        assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(10000);
        CartPage cartPage = storePage.clickViewCart();

        //TODO Dinamic way

        assertEquals(
                cartPage.getProductName(), "Blue Shoes");
        CheckoutPage checkoutPage= cartPage.checkout();

        //checkout

        driver.findElement(By.id("billing_first_name")).sendKeys("lola");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_company")).sendKeys("epam");
        driver.findElement(By.id("billing_address_1")).sendKeys("lola");
        driver.findElement(By.id("billing_address_2")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_phone")).sendKeys("855147");
        driver.findElement(By.id("billing_email")).sendKeys("marthalgmejia@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.id("place_order")).click();
        //driver.findElement(By.cssSelector("#place_order +input")).click();
        Thread.sleep(5000);
        assertEquals(driver.findElement(By.className("woocommerce-notice")).getText(), "Thank you. Your order has been received.");
    }

    @Test
    public void guestCheckoutUsingDirectTransferBisTest() throws InterruptedException {
        //System.setProperty("Web.driver.chrome.driver","C:\\drivers\\chromedriver.exe");
        System.out.println("imprimiendo guestCheckoutUsingDirectTransferTest ");
        driver.get("https://askomdch.com");
        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.navigateToStoreUsingMenu();
        storePage.searchItem("Blue");
        assertEquals(storePage.getTitle(), "Search results: “Blue”");
        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(10000);
        CartPage cartPage = storePage.clickViewCart();

        //TODO Dinamic way

        assertEquals(
                cartPage.getProductName(), "Blue Shoes");
        CheckoutPage checkoutPage= cartPage.checkout();

        //checkout

        driver.findElement(By.id("billing_first_name")).sendKeys("lola");
        driver.findElement(By.id("billing_last_name")).sendKeys("user");
        driver.findElement(By.id("billing_company")).sendKeys("epam");
        driver.findElement(By.id("billing_address_1")).sendKeys("lola");
        driver.findElement(By.id("billing_address_2")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
        driver.findElement(By.id("billing_phone")).sendKeys("855147");
        driver.findElement(By.id("billing_email")).sendKeys("marthalgmejia@gmail.com");
        Thread.sleep(5000);
        driver.findElement(By.id("place_order")).click();
        //driver.findElement(By.cssSelector("#place_order +input")).click();
        Thread.sleep(5000);
        assertEquals(driver.findElement(By.className("woocommerce-notice")).getText(), "Thank you. Your order has been received.");
    }

//    @Test
//    public void guestCheckoutUsingDirectTransfer2Test() throws InterruptedException {
//        //System.setProperty("Web.driver.chrome.driver","C:\\drivers\\chromedriver.exe");
//        driver.get("https://askomdch.com");
//        driver.findElement(By.cssSelector("#menu-item-1227 >a")).click();
//
//        driver.findElement(By.id("woocommerce-product-search-field-0")).clear();
//        driver.findElement(By.id("woocommerce-product-search-field-0")).sendKeys("Blue");
//        driver.findElement(By.cssSelector("button[value='Search']")).click();
//        assertEquals(
//                driver.findElement(By.className("woocommerce-products-header__title")).getText(), "Search results: “Blue”");
//        //TODO Dinamic way
//        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
//        Thread.sleep(10000);
//        driver.findElement(By.cssSelector("a[title='View cart']")).click();
//        assertEquals(
//                driver.findElement(By.cssSelector("td[class='product-name']")).getText(), "Blue Shoes");
//        driver.findElement(By.className("checkout-button")).click();
//
//        //checkout
//
//        driver.findElement(By.id("billing_first_name")).sendKeys("lola");
//        driver.findElement(By.id("billing_last_name")).sendKeys("user");
//        driver.findElement(By.id("billing_company")).sendKeys("epam");
//        driver.findElement(By.id("billing_address_1")).sendKeys("lola");
//        driver.findElement(By.id("billing_address_2")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
//        driver.findElement(By.id("billing_postcode")).sendKeys("94188");
//        driver.findElement(By.id("billing_phone")).sendKeys("855147");
//        driver.findElement(By.id("billing_email")).sendKeys("marthalgmejia@gmail.com");
//        Thread.sleep(5000);
//        driver.findElement(By.id("place_order")).click();
//        //driver.findElement(By.cssSelector("#place_order +input")).click();
//        Thread.sleep(5000);
//        assertEquals(driver.findElement(By.className("woocommerce-notice")).getText(), "Thank you. Your order has been received.");
//    }
}
