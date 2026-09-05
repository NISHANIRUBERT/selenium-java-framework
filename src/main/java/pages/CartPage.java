package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CartPage extends BasePage {


    // Locators
    private By backpackProduct =
            By.className("inventory_item_name");

    // Constructor
    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Actions
    public String getProductName() {
        return getText(backpackProduct);
    }
 }