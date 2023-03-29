package AutomationPractice.src.main.automationPractice.pages;

import AutomationPractice.src.main.automationPractice.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends Page {

    protected By signUpPageText = By.xpath("//h2[text()='New User Signup!']");

    protected By accountCreatedNotification = By.xpath("//h2[text()]='Account Created!']");
    protected By signupNameField = By.xpath("//*[@data-qa='signup-name']");
    protected By signupEmailField = By.xpath("//*[@data-qa='signup-email']");
    protected By signUpButton = By.xpath("//*[@data-qa='signup-button']");
    protected By createAccountButton = By.xpath("//*[@data-qa='create-account']");
    protected By enterAccountInformation = By.xpath("//b[text()='Enter Account Information']");
    protected By userLoggedInText = By.xpath("//a[text()=' Logged in as ']");

    protected By titleMr = By.xpath("//input[@id='id_gender1']");
    protected By titleMrs = By.xpath("//input[@id='id_gender2']");
    protected By nameOnEnterAccountInformation = By.xpath("//*[@data-qa='name']");
    protected By emailOnEnterAccountInformation = By.xpath("//*[@data-qa='email']");
    protected By passwordFieldOnEnterAccountInformation = By.xpath("//*[@data-qa='password']");
    protected By firstNameOnAddressInformation = By.xpath("//*[@data-qa='first_name']");
    protected By customerName = By.xpath("//*[@data-qa='name']");
    protected By lastNameOnAddressInformation = By.xpath("//*[@data-qa='last_name']");
    protected By companyNameOnAddressInformation = By.xpath("//*[@id='company']");
    protected By addressOnAddressInformation = By.xpath("//*[@id='address1']");
    protected By address2OnAddressInformation = By.xpath("//*[@id='address2']");
    protected By countryOnAddressInformation2 = By.xpath("//*[@id='country']");
    protected By stateOnAddressInformation1 = By.xpath("//*[@id='state']");
    protected By cityOnAddressInformation2 = By.xpath("//*[@id='city']");
    protected By zipcodeOnAddressInformation = By.xpath("//*[@id='zipcode']");
    protected By mobileNumberOnAddressInformation = By.xpath("//*[@id='mobile_number']");
    protected By createAccountOnAddressInformation = By.xpath("//*[@data-qa='create-account']");
    protected By continueButtonOnAccountCreated = By.xpath("//*[@data-qa='continue-button']");


    protected By newsletterInput = By.id("newsletter");
    protected By specialOfferInput = By.id("optin");

    protected By dayDropdown = By.id("days");
    protected By monthDropdown = By.id("months");
    protected By yearDropdown = By.id("years");
    protected By countryDropdown = By.id("country");
    protected By stateInput = By.id("state");
    protected By zipcode = By.id("zipcode");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage waitForSignUpForm() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signUpPageText));
        return this;

    }
    public RegisterPage populateNameOnSignUpPage(String text) {
        populateField(driver, signupNameField, text);
        return this;
    }
        public RegisterPage populateEmailOnSignUpPage(String text) {
            populateField(driver, signupEmailField, text);
            return this;
        }
    public RegisterPage populateFirstName(String text) {
        populateField(driver, firstNameOnAddressInformation, text);
        return this;
    }
    public RegisterPage populateNameOnEnterAccountInformation(String text) {
        populateField(driver, nameOnEnterAccountInformation, text);
        return this;
    }
    public RegisterPage populateLastName(String text) {
        populateField(driver, lastNameOnAddressInformation, text);
        return this;
    }

    public RegisterPage populateCompany(String text) {
        populateField(driver, companyNameOnAddressInformation, text);
        return this;
    }

    public RegisterPage populateAddress(String text) {
        populateField(driver, addressOnAddressInformation, text);
        return this;
    }

    public RegisterPage populateAddress2(String text) {
        populateField(driver, address2OnAddressInformation, text);
        return this;
    }

    public RegisterPage populateEmail(String text) {
        populateField(driver, emailOnEnterAccountInformation, text);
        return this;
    }

    public RegisterPage populateZipcode(String text) {
        populateField(driver, zipcodeOnAddressInformation, text);
        return this;
    }

    public RegisterPage clickSignupButton() {
        clickOnElement(signUpButton);
        return this;
    }

    public RegisterPage waitForEnterAccountInformation() {
        waitForElement(driver, enterAccountInformation, Constants.MEDIUM_WAIT);
        return this;
    }

    public RegisterPage waitForLoggedInAsUsernameText() {
        waitForElement(driver, userLoggedInText, Constants.MEDIUM_WAIT);
        return this;
    }

    public RegisterPage populatePassword(String text) {
        populateField(driver, passwordFieldOnEnterAccountInformation, text);
        return this;
    }

    public RegisterPage chooseGenderOnRegisterPage(String genderType) {
        if (genderType == "Mr") {
            clickOnElement(titleMr);
        } else if (genderType == "Mrs") {
            clickOnElement(titleMrs);
        }
        return this;
    }

    public RegisterPage selectDayOfBirth(String day) {
        Select dropdown = selectDropdown(driver, dayDropdown);
        dropdown.selectByVisibleText(day);
        return this;
    }

    public RegisterPage selectCountry(String countryName) {
        Select dropdown = selectDropdown(driver, countryDropdown);
        dropdown.selectByVisibleText(countryName);
        return this;
    }

    public RegisterPage populateState(String state) {
        populateField(driver, stateInput, state);
        return this;
    }

    public RegisterPage populateCity(String city) {
        populateField(driver, cityOnAddressInformation2, city);
        return this;

    }

    public RegisterPage populateMobileNumber(String number) {
        populateField(driver, mobileNumberOnAddressInformation, number);
        return this;
    }


    public RegisterPage selectMonthOfBirth(String month) {
        Select dropdown = selectDropdown(driver, monthDropdown);
        dropdown.selectByVisibleText(month);
        return this;
    }

    public RegisterPage selectYearOfBirth(String year) {
        Select dropdown = selectDropdown(driver, yearDropdown);
        dropdown.selectByVisibleText(year);
        return this;
    }

    public RegisterPage clickSignupNewsletterButton() {
        scrollToElement(newsletterInput);
        clickOnElement(newsletterInput);
        return this;
    }

    public RegisterPage clickReceiveSpecialOffer() {
        clickOnElement(specialOfferInput);
        return this;
    }

    public RegisterPage clickCreateAccountButton() {
        clickOnElement(createAccountButton);
        return this;
    }

    public RegisterPage waitForAccountCreatedNotification() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedNotification));
        return this;
    }

}
