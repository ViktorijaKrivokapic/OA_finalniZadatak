package AutomationPractice.src.main.automationPractice.tests.java;

import AutomationPractice.src.main.automationPractice.pages.HomePage;
import AutomationPractice.src.main.automationPractice.pages.ProductsPage;
import AutomationPractice.src.main.selenium_core.DriverManager;
import AutomationPractice.src.main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import AutomationPractice.src.main.automationPractice.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Test009SearchProduct {

    DriverManager driverManager;
    WebDriver driver = null;

    String searchFieldText = "dress";


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


        // 4. Click on 'Products' button
        homePage.clickProductButton();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        homePage.waitForAllProductsPageText();

        // 6. Enter product name in search input and click search button
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.populateSearchFieldonProductsPage("dress");

        // 7. Verify 'SEARCHED PRODUCTS' is visible
        productsPage.waitForSearchedProducts();

        //  8. Verify all the products related to search are visible
        productsPage.waitForSearchedProduct1();
        productsPage.waitForSearchedProduct2();

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
