package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    private By userName= AppiumBy.accessibilityId("test-Username");
    private By passWord = AppiumBy.accessibilityId("test-Password");
    private By loginBtn =new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView");
    private By ErrorMessage = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView");

   // private By settingBtn = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");
    public HomePage setUserName(String text)
    //including wait method inside each function.
    {   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(text);
        return new HomePage(driver);
    }
    public HomePage setPassWord(String text)
    {   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(passWord).clear();
        driver.findElement(passWord).sendKeys(text);
        return new HomePage(driver);
    }
    public ProductPage clickLoginBtn()
    {   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(loginBtn).click();
        return new ProductPage(driver) ;
    }
    public String getErrorMessage()
    //using error message to validate refusing login with invalid data.
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return   driver.findElement(ErrorMessage).getText();
    }


    public HomePage Wait(){
        // making wait as a separate method to use it in login test.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return this;
    }
    }

