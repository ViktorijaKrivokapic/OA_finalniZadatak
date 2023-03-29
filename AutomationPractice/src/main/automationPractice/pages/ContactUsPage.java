package AutomationPractice.src.main.automationPractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage extends Page{

    protected By getInTouchMessage = By.xpath("//*[text()='Contact ']");
    protected By nameFieldOnContactUsForm = By.xpath("//*[text()data-qa='name']");
    protected By emailFieldOnContactUsForm = By.xpath("//*[text()data-qa='email']");
    protected By subjectFieldOnContactUsForm = By.xpath("//*[text()data-qa='subject']");
    protected By yourMessageHereFieldOnContactUsForm = By.xpath("//*[text()data-qa='message']");
    protected By chooseFileButtonOnContactForm = By.xpath("//*[text()='upload file']");
    protected By submitButtonOnContactForm = By.xpath("//*[text()data-qa='submit-button']");
    protected By successYourDetailsHaveBeenSubmittedSuccessfullyMessage = By.xpath("//*[text()='status alert alert-success']");


    public ContactUsPage(WebDriver driver) {super(driver);
    }



    public ContactUsPage waitForGetInTouchMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(getInTouchMessage));
        return this;
    }

    public ContactUsPage populateEmailAddressOnContactUsPage(String text) {
        populateField(driver, emailFieldOnContactUsForm, text);
        return this;
    }

    public ContactUsPage populateSubjectFieldOnContactUsForm(String text) {
        populateField(driver, subjectFieldOnContactUsForm, text);
        return this;
    }

    public ContactUsPage populateMessageFieldOnContactUsForm(String text) {
        populateField(driver, yourMessageHereFieldOnContactUsForm, text);
        return this;
    }

    public ContactUsPage clickChooseFileButton() {
        clickOnElement(chooseFileButtonOnContactForm);
        return this;
    }

    public ContactUsPage clickSubmitButton() {
        clickOnElement(submitButtonOnContactForm);
        return this;
    }

//    public ContactUsPage clickOkButton() {
//       clickOnElement();
//        return this;
//    }

    public ContactUsPage waitForSuccessYourDetailsHaveBeenSubmittedSuccessfullyMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(successYourDetailsHaveBeenSubmittedSuccessfullyMessage));
        return this;
    }

}
