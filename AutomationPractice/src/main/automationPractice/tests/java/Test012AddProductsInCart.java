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



public class Test012AddProductsInCart {

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
        // 4. Click 'Products' button
        homePage.clickProductButton();
        // 5. Hover over first product and click 'Add to cart'

        // 6. Click 'Continue Shopping' button
        CartPage cartPage = new CartPage(driver);
        cartPage.clickContinueShoppingButton();
        //  7. Hover over second product and click 'Add to cart'

        //   8. Click 'View Cart' button
        cartPage.clickViewCartButton();

        //   9. Verify both products are added to Cart
        cartPage.waitForFirstProductInCart();
        cartPage.waitForSecondProductInCart();

        // 10. Verify their prices, quantity and total price
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
