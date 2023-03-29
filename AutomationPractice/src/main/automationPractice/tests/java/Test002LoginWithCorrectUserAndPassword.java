package AutomationPractice.src.main.automationPractice.tests.java;

import AutomationPractice.src.main.automationPractice.pages.HomePage;
import AutomationPractice.src.main.automationPractice.pages.LoginPage;
import AutomationPractice.src.main.selenium_core.DriverManager;
import AutomationPractice.src.main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import AutomationPractice.src.main.automationPractice.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test002LoginWithCorrectUserAndPassword {
    DriverManager driverManager;
    WebDriver driver = null;

    String loginEmail = "marko25@gmail.com";
    String loginPassword = "markomarkovic1";



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
       // 4. Click on 'Signup / Login' button
        homePage.clickToRegister();
       // 5. Verify 'Login to your account' is visible
       LoginPage loginPage = new LoginPage(driver);
       loginPage.waitForLoginToYourAccountText();

        //6. Enter correct email address and password
        loginPage.populateEmailAddressOnLoginPage(loginEmail);
        loginPage.populatePasswordOnLoginPage(loginPassword);

       // 7. Click 'login' button
        loginPage.clickLoginButton();

       // 8. Verify that 'Logged in as username' is visible
        loginPage.waitForLoggedInAsUsername();

        //9. Click 'Delete Account' button
        homePage.clickDeleteAccount();
       // 10. Verify that 'ACCOUNT DELETED!' is visible
        homePage.waitForAccountDeletedNotification();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
