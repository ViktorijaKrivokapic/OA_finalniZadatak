package AutomationPractice.src.main.automationPractice.tests.java;

import AutomationPractice.src.main.automationPractice.pages.*;
import AutomationPractice.src.main.selenium_core.DriverManager;
import AutomationPractice.src.main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import AutomationPractice.src.main.automationPractice.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test018ViewCategoryProducts {

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
    public void test018() {
        HomePage homePage = new HomePage(driver);

      //  3. Verify that categories are visible on left side bar
        homePage.waitForCategoryHeadline();

      //  4. Click on 'Women' category
        homePage.clickWomenSectionInCategory();
      //  5. Click on any category link under 'Women' category, for example: Dress
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnWomenProductsDress();

       // 6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        productsPage.waitForWomenTopsProductsSection();

      //  7. On left side bar, click on any sub-category link of 'Men' category
        productsPage.clickOnTshirtsInMenCategory();

      //  8. Verify that user is navigated to that category page
        productsPage.waitForMensTshirtCategoryPage();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
