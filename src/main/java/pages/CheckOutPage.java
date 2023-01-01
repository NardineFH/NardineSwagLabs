package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }
    private By firstName = AppiumBy.accessibilityId("test-First Name");
    private By lastName = AppiumBy.accessibilityId("test-Last Name");
    private By zippCode = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private By continueBtn = AppiumBy.accessibilityId("test-CONTINUE");

    public CheckOutPage setFirstName(String text)
    {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(text);
        return new CheckOutPage(driver);
    }
    public CheckOutPage setLastName(String text)
    {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(text);
        return new CheckOutPage(driver);
    }
    public CheckOutPage setzipcode(String text)
    {
        driver.findElement(zippCode).clear();
        driver.findElement(zippCode).sendKeys(text);
        return new CheckOutPage(driver);
    }
    public OverViewPage clickContinueBtn()
    {
        driver.findElement(continueBtn).click();
        return new OverViewPage (driver) ;
    }

}

