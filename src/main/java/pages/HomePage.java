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
    private By settingBtn = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");
    public HomePage setUserName(String text)
    {
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(text);
        return new HomePage(driver);
    }
    public HomePage setPassWord(String text)
    {
        driver.findElement(passWord).clear();
        driver.findElement(passWord).sendKeys(text);
        return new HomePage(driver);
    }
    public ProductPage clickLoginBtn()
    {
        driver.findElement(loginBtn).click();
        return new ProductPage(driver) ;
    }
    public String getErrorMessage()

    {
        return   driver.findElement(ErrorMessage).getText();
    }

    public SettingPage clicksettingBtn()
    {
        driver.findElement(settingBtn).click();
        return new SettingPage(driver) ;
    }
    public HomePage Wait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return this;
    }
    }

