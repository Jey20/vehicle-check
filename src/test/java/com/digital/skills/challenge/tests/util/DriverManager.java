package com.digital.skills.challenge.tests.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {

    private static WebDriver driver;
    public static WebDriverWait webDriverWait;


    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();

//        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver");
//        driver = new FirefoxDriver();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWebDriverWait() {
        webDriverWait = new WebDriverWait(driver, 30);
        return webDriverWait;
    }

    public static void cleanUp() {
        driver.quit();
    }
}