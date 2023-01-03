package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CartPage {
        WebDriver driver;

        public CartPage(WebDriver driver) {
            this.driver = driver;
        }
    private By productPrice = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By productName = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
   // private By removeBtn = AppiumBy.accessibilityId("test-REMOVE");
    private By removeText = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]/android.widget.TextView");
    private By removeBtn = AppiumBy.accessibilityId("test-REMOVE");

    private By ContinueShoppingBtn = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE SHOPPING\"]");


    private By CartItemBtn_NotEmpty = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView");


    private By CartItem_Empty = new By.ByXPath(" //android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup");

    private By CheckOutBtn = AppiumBy.accessibilityId("test-CHECKOUT");
    public String getproductPrice()

    {
        return   driver.findElement(productPrice).getText();
    }
    public String getproductName()

    {
        return   driver.findElement(productName).getText();
    }
    public CartPage clickRemoveBtn() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(removeBtn).click();
        return new CartPage(driver);
    }

    public ProductPage clickContinueShoppingBtn() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.findElement(ContinueShoppingBtn).click();
        return new ProductPage(driver);
    }

    public Boolean checkEmptyCart()
    {   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Boolean items ;

        try {
            driver.findElement(removeText);
            items = Boolean.TRUE;
        } catch (Exception e){

            items = Boolean.FALSE;

        }

        return  items;
    }
    public CheckOutPage clickCheckOutBtn() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(CheckOutBtn).click();
        return new CheckOutPage (driver);
    }
    public CartPage Wait(){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    return this;
    }

    public boolean validateRemovingProduct() {
        //validating the product is removed successfully using boolean method.
        try {
            driver.findElement(CartItemBtn_NotEmpty);
            return true;
        } catch (Exception e) {
            return false;
        }
    }}
