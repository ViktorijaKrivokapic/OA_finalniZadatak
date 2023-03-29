package AutomationPractice.src.main.automationPractice.tests.java;

import AutomationPractice.src.main.automationPractice.pages.HomePage;
import AutomationPractice.src.main.automationPractice.pages.RegisterPage;
import AutomationPractice.src.main.selenium_core.DriverManager;
import AutomationPractice.src.main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import AutomationPractice.src.main.automationPractice.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test005RegisterUserWithExistingEmail {

    DriverManager driverManager;
    WebDriver driver = null;

    String signUpEmail = "viksi123@gmail.com";
    String signUpName = "viksi";


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
        //  4. Click on 'Signup / Login' button
        homePage.clickToRegister();
        //5. Verify 'New User Signup!' is visible
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.waitForSignUpForm();
        // 6. Enter name and already registered email address
        registerPage.populateNameOnSignUpPage(signUpName);
        registerPage.populateEmailOnSignUpPage(signUpEmail);

        // 7. Click 'Signup' button
        registerPage.clickSignupButton();
        //8. Verify error 'Email Address already exist!' is visible
        homePage.waitForYourEmailAddressAlreadyExistsMessage();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
