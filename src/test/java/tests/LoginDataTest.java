package tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataProviders.LoginDataProvider;
import factory.DriverFactory;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginDataTest extends BaseTest {

	
	@Test(dataProvider = "loginMultipleData", dataProviderClass = LoginDataProvider.class)
    public void verifyLoginWithMultipleUsers(HashMap<String, String> data) {

        DriverFactory.getDriver().get(ConfigReader.get("url"));

        LoginPage loginPage =new LoginPage(DriverFactory.getDriver());

        loginPage.login(data.get("username"), data.get("password"));

        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("inventory"),"Login failed for user: " + data.get("username"));
                
                  
                
        
    }
}