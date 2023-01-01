package pages;

import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CartPage {
        WebDriver driver;

        public CartPage(WebDriver driver) {
            this.driver = driver;
        }
    private By productPrice = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By productName = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    private By removeBtn = AppiumBy.accessibilityId("test-REMOVE");

    private By ContinueShoppingBtn = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE SHOPPING\"]");
    private By CartItemBtn_NotEmpty = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView");

    private By CartItem_Empty = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");

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
        driver.findElement(removeBtn).click();
        return new CartPage(driver);
    }

    public ProductPage clickContinueShoppingBtn() {
        driver.findElement(ContinueShoppingBtn).click();
        return new ProductPage(driver);
    }
    public String getItems  ()
    {  String items;
        try {
            items = driver.findElement(CartItemBtn_NotEmpty).getAttribute("text");
        } catch (Exception e){

            items = "Empty";

        }


          return  items;
    }
    public String getEmptyItems()
    {

        return   driver.findElement(CartItem_Empty).getAttribute("text");
    }
    public CheckOutPage clickCheckOutBtn() {
        driver.findElement(CheckOutBtn).click();
        return new CheckOutPage (driver);
    }
    public CartPage Wait(){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    return this;
    }
    }
