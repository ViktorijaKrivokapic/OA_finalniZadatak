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




public class Test011VerifySubscriptionInCartPage {

    DriverManager driverManager;
    WebDriver driver = null;

    String emailAddress = "vikitesting@gmail.com";


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
    public void test011() {
        HomePage homePage = new HomePage(driver);

       // 3. Verify that home page is visible successfully
        homePage.waitForGirlImage();
      //  4. Click 'Cart' button
        homePage.clickCartButtonOnHomepage();
     //   5. Scroll down to footer
        homePage.scrollToFooter();

      //  6. Verify text 'SUBSCRIPTION'
        homePage.waitForSubsripctionText();
      //  7. Enter email address in input and click arrow button
        homePage.populateEmailAddressOnSubscription(emailAddress);
        homePage.clickSubscribeButton();
       // 8. Verify success message 'You have been successfully subscribed!' is visible
        homePage.waitForSuccessfullySubscribedMessage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
