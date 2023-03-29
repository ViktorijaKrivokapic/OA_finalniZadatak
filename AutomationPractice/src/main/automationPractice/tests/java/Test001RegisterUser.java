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

public class Test001RegisterUser {

    DriverManager driverManager;
    WebDriver driver = null;

    String newUsername = "Viki";
    String firstName = "Petar";
    String lastName = "Petrovic";
    String companyName = "Volvo";
    String address = "Address 1";
    String address2 = "Address 2";
    String countryName = "India";
    String stateName = "Goa";
    String cityName = "Bangalore";
    String zipcode = "37467";
    String mobileNumber = "1873973494";

    String signupEmail = "viki.testing@gmail.com";
    String genderType = "Mrs";
    String password = "qwerty";
    String customerName = "Petar";
    String dayOfBirth = "25";
    String monthOfBirth = "July";
    String yearOfBirth = "1989";
    String emailOnEnterAccountInformation = "viki.testing@gmail.com";


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
    public void test001RegisterUser() {
        HomePage homePage = new HomePage(driver);

        // 3. Verify that home page is visible successfully
        homePage.waitForGirlImage();


        // 4. Click on 'Signup / Login' button
        homePage.clickToRegister();

        // 5. Verify 'New User Signup!' is visible
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.waitForSignUpForm();

        // 6. Enter name and email address
        registerPage.populateNameOnSignUpPage(customerName);
        registerPage.populateEmailOnSignUpPage(signupEmail);

        // 7. Click 'Signup' button
        registerPage.clickSignupButton();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        registerPage.waitForEnterAccountInformation();

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        registerPage.chooseGenderOnRegisterPage(genderType);
        registerPage.populateNameOnEnterAccountInformation(customerName);
        //registerPage.populateEmail(emailOnEnterAccountInformation);
        registerPage.populatePassword(password);
        registerPage.selectDayOfBirth(dayOfBirth);
        registerPage.selectMonthOfBirth(monthOfBirth);
        registerPage.selectYearOfBirth(yearOfBirth);


        // 10. Select checkbox 'Sign up for our newsletter!'
        registerPage.clickSignupNewsletterButton();


        // 11. Select checkbox 'Receive special offers from our partners!'
        registerPage.clickReceiveSpecialOffer();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        registerPage.populateFirstName(firstName);
        registerPage.populateLastName(lastName);
        registerPage.populateCompany(companyName);
        registerPage.populateAddress(address);
        registerPage.populateAddress2(address2);
        registerPage.selectCountry(countryName);
        registerPage.populateState(stateName);
        registerPage.populateCity(cityName);
        registerPage.populateZipcode(zipcode);
        registerPage.populateMobileNumber(mobileNumber);
        // 13. Click 'Create Account button'

        registerPage.clickCreateAccountButton();
        //  14. Verify that 'ACCOUNT CREATED!' is visible
        registerPage.waitForAccountCreatedNotification();
        // 15. Click 'Continue' button
        homePage.clickToContinue();

        // 16. Verify that 'Logged in as username' is visible;
        registerPage.waitForLoggedInAsUsernameText();

        //17. Click 'Delete Account' button
        homePage.clickDeleteAccount();
        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button*/
        homePage.waitForAccountDeletedNotification();
        homePage.clickToContinue();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
