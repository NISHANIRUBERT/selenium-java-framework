package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

import base.BasePage;

public class LoginPage extends BasePage {


    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter username: {username}")
    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    @Step("Click Login")
    public void clickLogin() {
        click(loginButton);
    }

    @Step("Login with username: {username}")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}