package AutomationPractice.src.main.automationPractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page{


    // lokatori

    protected By girlImage = By.xpath("//img[@alt='demo website for practice']");
    protected By linkRegistracija = By.xpath("//a[text()=' Signup / Login']");
    protected By continueButtonOnAccountCreated = By.xpath ("//a[text()='continue-button']");
    protected By deleteAccountButton = By.xpath("//a[text()=' Delete Account']");
    protected By accountDeletedNotification = By.xpath ("//b[text()='Account Deleted!']");
    protected By emailOrPasswordIsIncorrectNotification = By.xpath("//p[text()='Your email or password is incorrect!']");
    protected By continueButtonOnAccountDeleted = By.xpath("//*[@data-qa='continue-button']");
    protected By logoutButton = By.xpath ("//a[text()=' Logout']");
    protected By emailAddressAlreadyExistsNotification = By.xpath("//p[text()='Email Address already exist!']");
    protected By contactUsButton = By.xpath ("//a[text()=' Contact us']");
    protected By homeButton = By.xpath("//*[text()=' Home']");
    protected By testCasesButton = By.xpath ("//a[text()=' Test Cases']");
    protected By testCasesPageText = By.xpath("//h2[text()='Test Cases']");
    protected By productsButton = By.xpath ("//a[text()=' Products']");
    protected By allProductsPage = By.xpath("//h2[text()='All Products']");
    protected By subscriptionText = By.xpath("//h2[text()='Subscription']");
    protected By subscribeButton = By.id("subscribe");
    protected By subscribeEmailField = By.id("susbscribe_email");
    protected By successfullySubscribedMessage = By.xpath("//*[text()='You have been successfully subscribed!']");
    protected By cartButtonOnHomepage = By.xpath("//*[text()=' Cart']");
    protected By categoryHeadline = By.xpath("//*[text()='Category']");
    protected By womenSectionInCategory = By.xpath("//*[text()='Women']");




    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage waitForGirlImage(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(girlImage));
        return this;
    }

    public HomePage clickToRegister() {
        driver.findElement(linkRegistracija).click();
        return this;
    }

    public HomePage clickDeleteAccount() {
        driver.findElement(deleteAccountButton).click();
        return this;
    }

    public HomePage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return this;
    }

    public HomePage clickContactUsButton() {
        driver.findElement(contactUsButton).click();
        return this;
    }

    public HomePage waitForAccountDeletedNotification() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedNotification));
        return this;
        }

    public HomePage waitForYourEmailOrPasswordIsIncorrectMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailOrPasswordIsIncorrectNotification));
        return this;
    }

    public HomePage waitForYourEmailAddressAlreadyExistsMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressAlreadyExistsNotification));
        return this;
    }

        public HomePage clickToContinue() {
            driver.findElement(continueButtonOnAccountDeleted).click();
            return this;
        }

    public HomePage clickHomeButton() {
        driver.findElement(homeButton).click();
        return this;
    }
    public HomePage clickTestCasesButton(){
        driver.findElement(testCasesButton).click();
        return this;
    }

    public HomePage waitForTestCasesPageText() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesPageText));
        return this;
    }

    public HomePage clickProductButton(){
        driver.findElement(productsButton).click();
        return this;
    }

    public HomePage waitForAllProductsPageText() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(allProductsPage));
        return this;
    }

    public HomePage waitForSubsripctionText() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(subscriptionText));
        return this;
    }

    public HomePage clickSubscribeButton() {
        clickOnElement(subscribeButton);
        return this;
    }

    public HomePage waitForSuccessfullySubscribedMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successfullySubscribedMessage));
        return this;
    }

    public HomePage populateEmailAddressOnSubscription(String text) {
        populateField(driver, subscribeEmailField, text);
        return this;
    }

    public HomePage clickCartButtonOnHomepage() {
        clickOnElement(cartButtonOnHomepage);
        return this;
    }

    public HomePage waitForCategoryHeadline() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryHeadline));
        return this;
    }

    public HomePage clickWomenSectionInCategory() {
        clickOnElement(womenSectionInCategory);
        return this;
    }


}
