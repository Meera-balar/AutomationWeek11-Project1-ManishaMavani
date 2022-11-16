package nopcommercetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTesting {

    //main method declaration
    public static void main(String[] args) {
        // nop-commerce URL stored in variable baseUrl
        String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        // setup key-value of Chrome browser
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); //object creation for ChromeDriver class which contain implementation of Webdriver interface
        //Launch the URL or Get the URL
        driver.get(baseUrl);
        //Maximise Window
        driver.manage().window().maximize();
        //We give implicit time to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));


        //Get the title of page by using getTitle method
        System.out.println("Page title is : " + driver.getTitle());

        //Get the current Url
        System.out.println("Current URL is : " + driver.getCurrentUrl());

        //Get the page source
        System.out.println("Page source is : " + driver.getPageSource());

        //Find the email field element
        WebElement emailField = driver.findElement(By.id("Email"));
        //Enter email to email field
        emailField.sendKeys("Manisha25@gmail.com");

        //Find the password field element
        WebElement passwordField = driver.findElement(By.id("Password"));
        //Enter password to password field
        passwordField.sendKeys("Abcd123");

        //Close the browser
       driver.quit();

    }
}
