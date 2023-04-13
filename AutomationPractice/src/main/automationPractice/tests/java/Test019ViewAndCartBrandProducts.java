package AutomationPractice.src.main.automationPractice.tests.java;
import AutomationPractice.src.main.automationPractice.pages.*;
import AutomationPractice.src.main.selenium_core.DriverManager;
import AutomationPractice.src.main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import AutomationPractice.src.main.automationPractice.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test019ViewAndCartBrandProducts {
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


      //  3. Click on 'Products' button
        homePage.clickProductButton();
      //  4. Verify that Brands are visible on left side bar
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.waitForPoloBrand();
        productsPage.waitForBibaBrand();

      //  5. Click on any brand name
        productsPage.clickOnBibaBrand();
      //  6. Verify that user is navigated to brand page and brand products are displayed
        productsPage.waitForBrandBibaProductsPage();
        productsPage.waitForMickeyMouseDressOnBibaProductsPage();
        productsPage.waitForLongTulleDressOnBibaProductsPage();

      //  7. On left side bar, click on any other brand link
        productsPage.clickOnPoloBrand();
      //  8. Verify that user is navigated to that brand page and can see products
        productsPage.waitForBlueTopInPoloBrand();

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
