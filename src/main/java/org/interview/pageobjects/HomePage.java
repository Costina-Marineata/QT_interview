package org.interview.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage{

    Actions actions = new Actions(driver);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    List<WebElement> hoverItem = driver.findElements(By.xpath("//*[@id='main']/div[2]/ul/li/div/a[1]/img"));
    List<WebElement> items = driver.findElements(By.xpath("//*[@id='main']/div[2]/ul/li/div/a[starts-with(@href, '?add-to-cart=')]"));
    WebElement cart = driver.findElement(By.xpath("//*[@id='primary-menu']/ul/li[1]/a"));

    @Step("Add 4 random items in the cart...")
    public CartPage addRandomItemsToCart(){
        Random rand = new Random();

        for(int i = 1 ; i <= 4; i++){
            int randomIndex = rand.nextInt(items.size());
            actions.moveToElement(items.get(randomIndex)).perform();
            items.get(randomIndex).click();
            items.remove(randomIndex);
        }
        actions.moveToElement(cart);
        cart.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        return new CartPage(driver);
    }
}
