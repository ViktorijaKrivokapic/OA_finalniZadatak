package AutomationPractice.src.main.automationPractice.pages;

import AutomationPractice.src.main.automationPractice.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

    protected By emailAddressOnLoginPage = By.xpath("//*[@data-qa='login-email']");
    protected By passwordFieldOnLoginPage = By.xpath("//*[@data-qa='login-password']");
    protected By loginButtonOnLoginPage = By.xpath("//*[@data-qa='login-button']");
    protected By loginPageText = By.xpath("//h2[text()='Login to your account']");
    protected By userLoggedInAs = By.xpath("//a[text()=' Logged in as ']");

    public LoginPage(WebDriver driver) {super(driver);
    }


    public LoginPage populateEmailAddressOnLoginPage(String text) {
        populateField(driver, emailAddressOnLoginPage, text);
        return this;
    }
    public LoginPage populateIncorrectEmailAddressOnLoginPage(String text) {
        populateField(driver, emailAddressOnLoginPage, text);
        return this;
    }

        public LoginPage populatePasswordOnLoginPage(String text) {
            populateField(driver, passwordFieldOnLoginPage, text);
            return this;
        }

        public LoginPage populateincorrectPasswordOnLoginPage(String text) {
            populateField(driver, passwordFieldOnLoginPage, text);
            return this;
        }

            public LoginPage clickLoginButton() {
                clickOnElement(loginButtonOnLoginPage);
                return this;
            }

                    public LoginPage waitForLoginToYourAccountText() {
                        waitForElement(driver, loginPageText, Constants.MEDIUM_WAIT);
                        return this;
                    }
    public LoginPage waitForLoggedInAsUsername() {
        waitForElement(driver, userLoggedInAs, Constants.MEDIUM_WAIT);
        return this;
    }

}

