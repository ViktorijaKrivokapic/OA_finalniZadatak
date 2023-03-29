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


public class Test003LoginWithIncorrectEmailAndPassword {
    DriverManager driverManager;
    WebDriver driver = null;

    String loginEmail = "marko23@gmail.com";
    String loginPassword = "ehrfhelrjfn";


    @BeforeMethod
    public void setup() {


        driverManager = DriverManagerFactory.getDriverManager("CHROME");
        // 1. Launch browser
        driver = driverManager.getWebDriver();
        //2. Navigate to url 'http://automationexercise.com'
        driver.get(Constants.URL);
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test003() {
        HomePage homePage = new HomePage(driver);


        //  3. Verify that home page is visible successfully
        homePage.waitForGirlImage();
        //  4. Click on 'Signup / Login' button
        homePage.clickToRegister();

        // 5. Verify 'Login to your account' is visible
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoginToYourAccountText();
        // 6. Enter incorrect email address and password
        loginPage.populateIncorrectEmailAddressOnLoginPage(loginEmail);
        loginPage.populateincorrectPasswordOnLoginPage(loginPassword);

        //7. Click 'login' button
        loginPage.clickLoginButton();

        // 8. Verify error 'Your email or password is incorrect!' is visible*/
        homePage.waitForYourEmailOrPasswordIsIncorrectMessage();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
