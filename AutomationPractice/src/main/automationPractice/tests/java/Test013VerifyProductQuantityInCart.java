package AutomationPractice.src.main.automationPractice.tests.java;


import AutomationPractice.src.main.automationPractice.pages.CartPage;
import AutomationPractice.src.main.automationPractice.pages.HomePage;
import AutomationPractice.src.main.automationPractice.pages.ProductsPage;
import AutomationPractice.src.main.selenium_core.DriverManager;
import AutomationPractice.src.main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import AutomationPractice.src.main.automationPractice.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test013VerifyProductQuantityInCart {

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

       // 3. Verify that home page is visible successfully
        homePage.waitForGirlImage();
       // 4. Click 'View Product' for any product on home page
        homePage.clickProductButton();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickFirstProductViewButton();

        //5. Verify product detail is opened
        productsPage.waitForProductAvailabilityInfo();
        //6. Increase quantity to 4
        //7. Click 'Add to cart' button
        productsPage.addProductToCart();

        //8. Click 'View Cart' button
        productsPage.clickFirstProductViewButton();
        //9. Verify that product is displayed in cart page with exact quantity

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
