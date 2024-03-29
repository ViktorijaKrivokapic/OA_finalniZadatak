package AutomationPractice.src.main.automationPractice.tests.java;


import AutomationPractice.src.main.automationPractice.pages.HomePage;
import AutomationPractice.src.main.selenium_core.DriverManager;
import AutomationPractice.src.main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import AutomationPractice.src.main.automationPractice.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class Test007VerifyTestCasesPage {

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
    public void test007() {
        HomePage homePage = new HomePage(driver);


        // 3. Verify that home page is visible successfully
        homePage.waitForGirlImage();
        //4. Click on 'Test Cases' button
        homePage.clickTestCasesButton();
        //5. Verify user is navigated to test cases page successfully
        homePage.waitForTestCasesPageText();

    }
        @AfterClass
        public void tearDown() {
            driver.quit();
        }
}
