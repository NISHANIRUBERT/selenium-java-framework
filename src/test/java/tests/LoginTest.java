package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataProviders.LoginDataProvider;
import factory.DriverFactory;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
	

    @Test(dataProvider = "loginOneData", dataProviderClass = LoginDataProvider.class)
    public void verifySuccessfulLogin(HashMap<String, String> data) {

        DriverFactory.getDriver().get(ConfigReader.get("url"));

        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
 
        loginPage.login(data.get("username"), data.get("password"));

        String currentUrl = DriverFactory.getDriver().getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("inventory"),"User was not redirected to the Products page");
   
        
    }
    
 
}