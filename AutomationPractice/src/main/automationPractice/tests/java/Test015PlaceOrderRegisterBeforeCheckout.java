package AutomationPractice.src.main.automationPractice.tests.java;

import AutomationPractice.src.main.automationPractice.pages.*;
import AutomationPractice.src.main.selenium_core.DriverManager;
import AutomationPractice.src.main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import AutomationPractice.src.main.automationPractice.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test015PlaceOrderRegisterBeforeCheckout {

    DriverManager driverManager;
    WebDriver driver = null;

    String customerName = "Petar";
    String signupEmail = "viki.testing@gmail.com";
    String addressOnAddressDetail = "dskndl";
    String descriptionFieldTextOnCheckOrderPage = "no special requests";
    String nameOnCard = "Marko";
    String cvcNumber = "348";
    String expirationDateMonth = "03";
    String expirationDateYear = "20";
    String cardNumber = "28374938";
    String genderType = "male";
    String password = "12345";
    String mobileNumber = "46757588";
    String zipcode = "46783";
    String cityName = "London";
    String stateName = "djhgj";
    String countryName = "England";
    String address = "Kensington16";
    String companyName = "Volvo";
    String dayOfBirth = "27";
    String monthOfBirth = "04";
    String yearOfBirth = "1985";
    String firstName = "John";
    String lastName = "Lebovwski";
    String address2 = "Kensingtonstr17";

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
    public void test015() {
        HomePage homePage = new HomePage(driver);

      //  3. Verify that home page is visible successfully
        homePage.waitForGirlImage();
      //  4. Click 'Signup / Login' button
        homePage.clickToRegister();
      //  5. Fill all details in Signup and create account
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.populateNameOnSignUpPage(customerName);
        registerPage.populateEmailOnSignUpPage(signupEmail);
        registerPage.clickSignupButton();
        registerPage.waitForEnterAccountInformation();
        registerPage.chooseGenderOnRegisterPage(genderType);
        registerPage.populateNameOnEnterAccountInformation(customerName);
        //registerPage.populateEmail(emailOnEnterAccountInformation);
        registerPage.populatePassword(password);
        registerPage.selectDayOfBirth(dayOfBirth);
        registerPage.selectMonthOfBirth(monthOfBirth);
        registerPage.selectYearOfBirth(yearOfBirth);
        registerPage.clickSignupNewsletterButton();
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
        registerPage.clickCreateAccountButton();
      //  6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        registerPage.waitForEnterAccountInformation();
      //  7. Verify ' Logged in as username' at top
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoggedInAsUsername();
      //  8. Add products to cart
        homePage.clickProductButton();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart();
      //  9. Click 'Cart' button
        CartPage cartPage = new CartPage(driver);
        cartPage.clickViewCartButton();

      //  10. Verify that cart page is displayed
        cartPage.waitForShoppingCart();
      //  11. Click Proceed To Checkout
        cartPage.clickProceedToCheckoutButton();
      //  12. Verify Address Details and Review Your Order
        cartPage.verifyAddressOnAddressDetails(addressOnAddressDetail);
        cartPage.waitForFirstProductOnConfirmOrderPage();
        cartPage.waitForSecondProductOnConfirmOrderPage();
      //  13. Enter description in comment text area and click 'Place Order'
        cartPage.populateDescriptionFieldOnConfirmOrderPage(descriptionFieldTextOnCheckOrderPage);
        cartPage.clickPlaceAnOrder();


     //   14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        cartPage.populateNameOnCardInPaymentSection(nameOnCard);
        cartPage.populateCardNumber(cardNumber);
        cartPage.populateCvcNumber(cvcNumber);
        cartPage.populateExpirationDateMonthOnCard(expirationDateMonth);
        cartPage.populateExpirationDateYearOnCard(expirationDateYear);
     //   15. Click 'Pay and Confirm Order' button
        cartPage.clickPayAndConfirmOrderButton();
     //   16. Verify success message 'Your order has been placed successfully!'
        cartPage.waitForYourOrderHasBeenSuccessfullyPlacedNotification();

      //  17. Click 'Delete Account' button
        homePage.clickDeleteAccount();
     //   18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        homePage.waitForAccountDeletedNotification();
        homePage.clickToContinue();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
