package nopcommercetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowserTesting {
    //nop commerce URL stored in variable baseUrl
    static String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
    //driver declaration of type WebDriver
    static WebDriver driver;
    //Main Method declaration
    public static void main(String[] args) {
        //Scanner declaration
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter browser name :  ");
        String browser = scanner.next();
        //Scanner close
        scanner.close();
        //try block
        try{
        if(browser.equalsIgnoreCase("chrome")){
            //setup key-value of Chrome browser
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();  //object creation
        } else if (browser.equalsIgnoreCase("firefox")) {
            //setup key-value for firefox browser
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
            driver = new FirefoxDriver();  //object creation
        } else if (browser.equalsIgnoreCase("edge")) {
            //setup key-value for edge browser
            System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
            driver = new EdgeDriver(); //object creation
        }else{
            System.out.println("Wrong Browser Name");
        }
        //Launch the URL or Get the URL
        driver.get(baseUrl);
        //Maximise Window
        driver.manage().window().maximize();
        //implicit time is given to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Get the title of page by using getTitle method
        System.out.println("Page title is : " + driver.getTitle());

        //Get the current Url
        System.out.println("Current URL is : " + driver.getCurrentUrl());

        //Get the page source
        System.out.println("Page source is : " + driver.getPageSource());

        //Find the email field element
        WebElement emailField = driver.findElement(By.id("Email"));
        //Enter email to email field
        emailField.sendKeys("Mavani25@gmail.com");

        //Find the password field element
        WebElement passwordField = driver.findElement(By.id("Password"));
        //Enter password to password field
        passwordField.sendKeys("123456");
        }catch(Exception e){  // Catch block to handle nullpointerException
            System.out.println("No such browser you can entered please enter correct "+ e);
            System.exit(0);
        }
        //Close the browser
        driver.quit();
    }




}
