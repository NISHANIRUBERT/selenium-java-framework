package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataProviders.LoginDataProvider;
import factory.DriverFactory;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.ConfigReader;


public class ProductTest extends BaseTest {


    @Test(dataProvider = "loginOneData", dataProviderClass = LoginDataProvider.class)
    public void verifyCompleteOrderFlow(HashMap<String, String> data) {

    	DriverFactory.getDriver().get(ConfigReader.get("url"));

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        loginPage.login(data.get("username"), data.get("password"));

        ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());

        productsPage.addBackpackToCart();

        Assert.assertEquals( productsPage.getCartItemCount(),"1","Cart count is incorrect");

        productsPage.clickCart();

        CartPage cartPage = new CartPage(DriverFactory.getDriver());
                
        Assert.assertEquals( cartPage.getProductName(),"Sauce Labs Backpack","Incorrect product in cart");

        CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());

        checkoutPage.clickCheckout();

        checkoutPage.enterCustomerDetails(data.get("firstName"), data.get("lastName"), data.get("zipCode"));

        checkoutPage.clickContinue();

        checkoutPage.clickFinish();

        Assert.assertEquals( checkoutPage.getOrderConfirmation(),"Thank you for your order!", "Order confirmation message is incorrect");

    }
}