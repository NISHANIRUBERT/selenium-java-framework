package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;

import base.BasePage;

public class ProductsPage extends BasePage {


    private By backpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartIcon = By.className("shopping_cart_link");
            

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add product '{productName}' to cart")
    public void addBackpackToCart() {
        click(backpackAddToCart);
    }

    @Step("Verify cart item count")
    public String getCartItemCount() {
        return getText(cartBadge);
    }


    @Step("Open shopping cart")
    public void clickCart() {
        click(cartIcon);
    }
  }