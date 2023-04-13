package AutomationPractice.src.main.automationPractice.tests.java;


import AutomationPractice.src.main.automationPractice.pages.*;
import AutomationPractice.src.main.selenium_core.DriverManager;
import AutomationPractice.src.main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import AutomationPractice.src.main.automationPractice.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Test016PlaceOrderLoginBeforeCheckout {

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
    String loginEmail = "marko24@gmail.com";
    String loginPassword = "12345"



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


      //  3. Verify that home page is visible successfully
        homePage.waitForGirlImage();
      //  4. Click 'Signup / Login' button
        homePage.clickToRegister();
      //  5. Fill email, password and click 'Login' button
        LoginPage loginPage = new LoginPage(driver);
        loginPage.populateEmailAddressOnLoginPage(loginEmail);
        loginPage.populatePasswordOnLoginPage(loginPassword);
        loginPage.clickLoginButton();
      //  6. Verify 'Logged in as username' at top
        loginPage.waitForLoggedInAsUsername();
      //  7. Add products to cart
        homePage.clickProductButton();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart();
     //   8. Click 'Cart' button
        CartPage cartPage = new CartPage(driver);
        cartPage.clickViewCartButton();

        //  9. Verify that cart page is displayed
        cartPage.waitForShoppingCart();
      //  10. Click Proceed To Checkout
        cartPage.clickProceedToCheckoutButton();
      //  11. Verify Address Details and Review Your Order
        cartPage.verifyAddressOnAddressDetails(addressOnAddressDetail);
        cartPage.waitForFirstProductOnConfirmOrderPage();
        cartPage.waitForSecondProductOnConfirmOrderPage();
      //  12. Enter description in comment text area and click 'Place Order'
        cartPage.populateDescriptionFieldOnConfirmOrderPage(descriptionFieldTextOnCheckOrderPage);
        cartPage.clickPlaceAnOrder();
       // 13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        cartPage.populateNameOnCardInPaymentSection(nameOnCard);
        cartPage.populateCardNumber(cardNumber);
        cartPage.populateCvcNumber(cvcNumber);
        cartPage.populateExpirationDateMonthOnCard(expirationDateMonth);
        cartPage.populateExpirationDateYearOnCard(expirationDateYear);
       // 14. Click 'Pay and Confirm Order' button
        cartPage.clickPayAndConfirmOrderButton();
      //  15. Verify success message 'Your order has been placed successfully!'
        cartPage.waitForYourOrderHasBeenSuccessfullyPlacedNotification();
      //  16. Click 'Delete Account' button
        homePage.clickDeleteAccount();
       // 17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        homePage.waitForAccountDeletedNotification();
        homePage.clickToContinue();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
