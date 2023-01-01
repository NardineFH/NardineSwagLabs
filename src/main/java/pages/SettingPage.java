package pages;

import Actions.MobileActions;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Text;

public class SettingPage {
    WebDriver driver;

    public SettingPage(WebDriver driver) {
        this.driver = driver;
    }
    public SettingPage LogOut(){
        MobileActions.scrollDownToSpecificText("LOGOUT" , driver);
        return this;
    }
  /*  public HomePage LogOutBtn() {
        driver.findElement(LogOut(), ).click();
        return new HomePage(driver);
    }*/
    }
