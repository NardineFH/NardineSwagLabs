package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SheckOutCompletedPage {
    WebDriver driver;

    public SheckOutCompletedPage(WebDriver driver) {
        this.driver = driver;
    }
    private By FinishedOrderText = new By.ByXPath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]");

    public String getFinishedOrderText()

    {
        return   driver.findElement(FinishedOrderText).getText();
    }
    }
