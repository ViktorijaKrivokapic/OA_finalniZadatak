package AutomationPractice.src.main.automationPractice.tests.java;


import AutomationPractice.src.main.automationPractice.pages.ContactUsPage;
import AutomationPractice.src.main.automationPractice.pages.HomePage;
import AutomationPractice.src.main.selenium_core.DriverManager;
import AutomationPractice.src.main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import AutomationPractice.src.main.automationPractice.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test006ContactUsForm {

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
        // 4. Click on 'Contact Us' button
        homePage.clickContactUsButton();
        // 5. Verify 'GET IN TOUCH' is visible
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        contactUsPage.waitForGetInTouchMessage();

        //6. Enter name, email, subject and message
//        contactUsPage.populateEmailAddressOnContactUsPage();
//        contactUsPage.populateSubjectFieldOnContactUsForm();
//        contactUsPage.populateMessageFieldOnContactUsForm();


        // 7. Upload file
//        contactUsPage.clickChooseFileButton();
//        upload.sendKeys("C:\Users\RudnikZlata\Desktop\jfj");
        // 8. Click 'Submit' button
        contactUsPage.clickSubmitButton();
        // 9. Click OK button
        driver.switchTo().alert().accept();

      // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        contactUsPage.waitForSuccessYourDetailsHaveBeenSubmittedSuccessfullyMessage();
        // 11. Click 'Home' button and verify that landed to home page successfully
       homePage.clickHomeButton();
        homePage.waitForGirlImage();

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
