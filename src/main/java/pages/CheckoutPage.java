package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutPage extends BasePage {

    // Locators
    private By checkoutButton = By.id("checkout");
    private By firstNameField =  By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By orderConfirmation = By.className("complete-header");
           

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckout() {
        click(checkoutButton);
    }

    public void enterCustomerDetails(String firstName,String lastName,String postalCode) {
        enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(postalCodeField, postalCode);
    }

    public void clickContinue() {
        click(continueButton);
    }

    public void clickFinish() {
        click(finishButton);
    }

    public String getOrderConfirmation() {
        return getText(orderConfirmation);
    }
}