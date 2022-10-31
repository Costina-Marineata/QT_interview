package org.interview;

import io.qameta.allure.*;
import org.interview.pageobjects.CartPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Epic("Katalon tests")
public class WebSiteTest_e2e extends BaseTest{

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("First point in the acceptance criteria - add random items to cart")
    @Feature("Acceptance Criteria")
    public void check_first_request(){
        homePage.addRandomItemsToCart();
        Assert.assertEquals("https://cms.demo.katalon.com/cart/", driver.getCurrentUrl());
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Second point in the acceptance criteria - check no of products in cart")
    @Feature("Acceptance Criteria")
    public void check_second_request(){
        CartPage cartPage = homePage.addRandomItemsToCart();
        int size = cartPage.productsInCart();
        Assert.assertEquals(size, 4);
        Assert.assertNotEquals("https://cms.demo.katalon.com/cart/",baseURL);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("e2e flow should be successful")
    @Feature("Homework")
    public void validate_full_acceptance_criteria() {
        //step 1
        CartPage cartPage = homePage.addRandomItemsToCart();

        //step 2
        int size = cartPage.productsInCart();

        //step 3
        Assert.assertEquals(size, 4);

        // step 4  - check the min price
        float price = cartPage.findLowestPrice();

        //step 5 - remove the lowest price from the cart & check the new no of items in the list
        cartPage.removeElementWithLowestPrice(price);
        int newSize = cartPage.productsInCart();
        Assert.assertEquals(newSize, size);
    }

    @AfterMethod
    public void closeDriver(){ driver.close();}
}
