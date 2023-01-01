import Actions.PropertiesReader;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class Tests {

    // pages
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    OverViewPage overViewPage;
    WebDriver driver;

    // Test data
    String testDataFile = "src/main/resources/TestData.properties";
    String username;
    String password;
    String wrongUserName;
   @BeforeClass
   public void setUpTestData () throws IOException {
       username = PropertiesReader.getProperties(testDataFile,"username");
       password  = PropertiesReader.getProperties(testDataFile,"password");
       wrongUserName = PropertiesReader.getProperties(testDataFile,"wrongUserName");


   }
    @BeforeMethod
    public void setupDevice() throws MalformedURLException {
        String AppName = System.getProperty("user.dir") + "\\src\\test\\resources\\TestDataFiles\\Android.SauceLabs.Mobile.Sample.app.2.2.0.apk";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Demo");
        caps.setCapability("appium:app", AppName);
        caps.setCapability("appium:platformVersion", "11");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appWaitActivity","com.swaglabsmobileapp.MainActivity");
        driver = new AndroidDriver(new URL("http://localhost:4723/"), caps);
        homePage = new HomePage(driver);
        productPage =new ProductPage(driver);
        cartPage= new CartPage(driver);
        overViewPage = new OverViewPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }


    @BeforeMethod(onlyForGroups = "standard_user" , dependsOnMethods = "setupDevice")
    public void standard_userSetupDevice() throws MalformedURLException {
        homePage.setUserName(username).setPassWord(password).clickLoginBtn();
    }
    @BeforeMethod(onlyForGroups = "wrong_user" , dependsOnMethods = "setupDevice")
    public void wrong_userSetupDevice() throws MalformedURLException {
        homePage.setUserName(wrongUserName).setPassWord(password).clickLoginBtn();
    }

    @Test(groups = "standard_user")
    public void TC01_testSuccessLogin()
    {
        homePage.Wait();
        Assert.assertEquals("PRODUCTS",productPage.getProductText());
    }

    @Test(groups = "wrong_user")
    public void TC05_testInValidLogin()
    {
        homePage.setUserName(wrongUserName);
        homePage.setPassWord(password);
        homePage.clickLoginBtn();


        assertEquals("Username and password do not match any user in this service.",homePage.getErrorMessage());
    }
    @Test(groups = "standard_user")
    public void TC02_testAddToCart(){
      String ProductName =  productPage.clickAddToCart().clickCartPageBtn().Wait().getproductName();
      String ProductPrice=  productPage.clickCartPageBtn().getproductPrice();
        assertEquals(ProductName,"Sauce Labs Backpack");
        Assert.assertEquals(ProductPrice,"$29.99");
        Assert.assertEquals("1" , cartPage.getItems());

    }
    @Test(groups = "standard_user")
    //this assertion validate if the product is successfully removed, the locator of the cart page button (in product page)changes when it has product
    // so i used it's  locator when it is empty to validate that the cart is empty, if the cart is not empty clicking 0n it should not direct me to the cart page.
     public void TC03_testRemoveItem(){
        productPage.Wait().clickAddToCart().Wait()
                .clickCartPageBtn().Wait().clickRemoveBtn().clickContinueShoppingBtn();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       Assert.assertEquals("Empty" , cartPage.getItems());

    }
    @Test(groups = "standard_user")
    //test ordering online and assertion by  the final text.
    public void TC04_testOnlineShopping(){

        String productPrice =productPage.Wait().clickAddToCart().clickCartPageBtn()
                .clickCheckOutBtn().setFirstName("Nardine").setLastName("Helal")
                .setzipcode("1111").clickContinueBtn().getproductPrice();

        Assert.assertEquals(productPrice,"$29.99");
        String finishText = overViewPage.ScrollDownToFinishBtn().clickFinishBtn().getFinishedOrderText();
        Assert.assertEquals(finishText,"THANK YOU FOR YOU ORDER" );

    }}
