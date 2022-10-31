package org.interview.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    List<WebElement> products = driver.findElements(By.xpath("//tbody//tr/td[2]/a/img"));
    List<WebElement> priceList = driver.findElements(By.xpath("//tbody//tr/td[4]/span"));
    List<WebElement> productRows = driver.findElements(By.xpath("//tbody/tr[@class='woocommerce-cart-form__cart-item cart_item']"));

    @Step("Check how many products are in the cart...")
    public int productsInCart() {
        return products.size()+1; //there is always one hidden element in the cart
    }

    @Step("Identity the lowest price in the cart...")
    public float findLowestPrice() {
        ArrayList<Float> prices = new ArrayList<>();
        for (WebElement element : priceList) {
            Float priceInt = Float.valueOf(element.getText().replace("$", ""));
            prices.add(priceInt);
        }

        return Collections.min(prices);
    }

    int i = 1;

    @Step("Remove element with lowest price...")
    public void removeElementWithLowestPrice(float price) {
        for (WebElement element : productRows) {
            Float priceToCheck = Float.valueOf(element.findElement(By.xpath("//tbody/tr[" + i + "]//td[@class='product-price']/span")).getText().replace("$", ""));
            if (priceToCheck.equals(price)) {
                WebElement toRemove = element.findElement(By.xpath("//tbody/tr[" + i + "]//td[@class='product-remove']/a"));
                wait.until(ExpectedConditions.elementToBeClickable(toRemove));
                toRemove.click();

                WebElement undo = driver.findElement(By.xpath("//div[@class='woocommerce-message']/a[@class='restore-item']"));
                wait.until(ExpectedConditions.visibilityOf(undo));
                Assert.assertEquals("Undo?", undo.getText());
                break;
            }
            i++;
        }
    }
}