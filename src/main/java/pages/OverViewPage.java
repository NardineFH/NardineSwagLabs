package pages;

import Actions.MobileActions;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverViewPage {
    WebDriver driver;

    public OverViewPage(WebDriver driver) {
        this.driver = driver;
    }
    private By productName1 = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    private By productPrice1 = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By finishBtn = AppiumBy.accessibilityId("test-FINISH");
    private By FinishText = new By.ByXPath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]/android.widget.TextView");
    public String getproductPrice()

    {
        return   driver.findElement(productPrice1).getText();
    }
    public String getproductName()

    {
        return   driver.findElement(productName1).getText();
    }
    public SheckOutCompletedPage clickFinishBtn()
    {
        driver.findElement(finishBtn).click();
        return new SheckOutCompletedPage (driver) ;
    }
    public OverViewPage ScrollDownToFinishBtn(){
        MobileActions.scrollDownToSpecificText("FINISH" , driver);
        return this;
    }
}
