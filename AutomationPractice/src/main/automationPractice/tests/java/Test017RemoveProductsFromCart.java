package AutomationPractice.src.main.automationPractice.tests.java;

import AutomationPractice.src.main.automationPractice.pages.*;
import AutomationPractice.src.main.selenium_core.DriverManager;
import AutomationPractice.src.main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import AutomationPractice.src.main.automationPractice.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test017RemoveProductsFromCart {
    DriverManager driverManager;
    WebDriver driver = null;


    @BeforeMethod
    public void setup() {


        driverManager = DriverManagerFactory.getDriverManager("CHROME");
        // 1. Launch browser
        driver = driverManager.getWebDriver();
        //2. Navigate to url 'http://automationexercise.com'
        driver.get(Constants.URL);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test002() {
        HomePage homePage = new HomePage(driver);


      //  3. Verify that home page is visible successfully
        homePage.waitForGirlImage();
      //  4. Add products to cart
        homePage.clickProductButton();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart();
      //  5. Click 'Cart' button
        CartPage cartPage = new CartPage(driver);
        cartPage.clickViewCartButton();
      //  6. Verify that cart page is displayed
        cartPage.waitForShoppingCart();
      //  7. Click 'X' button corresponding to particular product

      //  8. Verify that product is removed from the cart

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
