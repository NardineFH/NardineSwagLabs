package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    private By ProductText = new By.ByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView");
    private By AddToCartBtn = new By.ByXPath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView");

    private By CartItemBtn_NotEmpty = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");

    private By productPrice = new By.ByXPath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]");
    private By productName = new By.ByXPath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");
    private By CartItem_Empty = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]// /android.view.ViewGroup/android.widget.ImageView");

    public String getProductText()

    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return   driver.findElement(ProductText).getText();
    }

    public ProductPage clickAddToCart()
    {   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(AddToCartBtn).click();
        return new ProductPage(driver);
    }
    public CartPage clickCartPageBtn()
    {   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(CartItemBtn_NotEmpty).click();
        return new CartPage(driver);
    }

    public String getproductPrice()

    {   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return   driver.findElement(productPrice).getText();
    }
    public String getproductName()

    {   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return   driver.findElement(productName).getText();
    }
    public CartPage clickEmptyCartPageBtn()
    {   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(CartItem_Empty).click();
        return new CartPage(driver);
    }

    }


