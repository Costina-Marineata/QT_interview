package org.interview;

import org.interview.pageobjects.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;

    String baseURL = "https://cms.demo.katalon.com/";

    @BeforeMethod
    public void classSetup () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(baseURL);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void teardown () {
        driver.quit();
    }

}
