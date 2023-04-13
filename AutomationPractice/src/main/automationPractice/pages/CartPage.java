package AutomationPractice.src.main.automationPractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends Page {

    protected By viewCartButton = By.xpath("//a*[text()='View Cart ']");
    protected By continueShoppingButton = By.xpath("//*[@class='btn btn-success close-modal btn-block']");
    protected By firstProductInCart = By.xpath("//a*[text()='/product details/1 ']");
    protected By secondProductInCart = By.xpath("//a*[text()='/product details/2 ']");
    protected By firstProductInCartTotalPrice = By.xpath("//*[@class='cart_total_price ']");
    protected By shoppingCartPage = By.xpath("//*[text()='Shopping Cart']");
    protected By proceedToCheckoutButton = By.xpath("//*[@class='btn btn-default check_out']");
    protected By addressOnAddressDetailPage(String address) {
       return By.xpath("//*[@class='address_address1 address_address2'][text()='" + address + "']");
    }

    protected By firstProductOnConfirmOrgedPage = By.xpath("//a*[text()='/product_details/2']");
    protected By secondProductOnConfirmOrgedPage = By.xpath("//a*[text()='/product_details/1']");
    protected By descriptionFieldOnConfirmOrderPage = By.xpath("//*[@id='ordermsg']//textarea");
    protected By placeOrderButton =  By.xpath("//a*[text()='Place Order']");
    protected By nameOnCard = By.xpath("//*[@data-qa='name-on-card']");
    protected By cardNumber = By.xpath("//*[@data-qa='card-number']");
    protected By cvcNumber = By.xpath("//*[@data-qa='cvc']");
    protected By expirationDateMonth = By.xpath("//*[@data-qa='expiry-month']");
    protected By expirationDateYear = By.xpath("//*[@data-qa='expiry-year']");
    protected By payAndConfirmOrderButton = By.xpath("//*[@data-qa='pay-button']");
    protected By orderSuccessfullyPlaced = By.xpath("//*[@id='success_message']/*[contains(text(),'Your order has been placed successfully!')]");

    protected By deleteProductById(int productId) {
        return By.id("product-"+productId);
    }



    public CartPage(WebDriver driver) {super(driver);
    }

    public CartPage clickViewCartButton() {
        clickOnElement(viewCartButton);
        return this;
    }
    public CartPage clickContinueShoppingButton() {
        clickOnElement(continueShoppingButton);
        return this;
    }

    public CartPage waitForFirstProductInCart() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductInCart));
        return this;
    }

    public CartPage waitForSecondProductInCart() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondProductInCart));
        return this;
    }

    public CartPage waitForShoppingCart() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(shoppingCartPage));
        return this;
    }

    public CartPage clickProceedToCheckoutButton() {
        clickOnElement(proceedToCheckoutButton);
        return this;
    }

    public CartPage verifyAddressOnAddressDetails(String address) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressOnAddressDetailPage(address)));
       return this;
    }

    public CartPage waitForFirstProductOnConfirmOrderPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductOnConfirmOrgedPage));
        return this;
    }

    public CartPage waitForSecondProductOnConfirmOrderPage() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondProductOnConfirmOrgedPage));
        return this;
    }

    public CartPage populateDescriptionFieldOnConfirmOrderPage(String text) {
        populateField(driver, descriptionFieldOnConfirmOrderPage, text);
        return this;
    }
    public CartPage populateNameOnCardInPaymentSection(String text) {
        populateField(driver, nameOnCard, text);
        return this;
    }
    public CartPage populateCardNumber(String text) {
        populateField(driver,cardNumber , text);
        return this;
    }

    public CartPage populateCvcNumber(String text) {
        populateField(driver,cvcNumber , text);
        return this;
    }

    public CartPage populateExpirationDateMonthOnCard(String text) {
        populateField(driver,expirationDateMonth , text);
        return this;
    }

    public CartPage populateExpirationDateYearOnCard(String text) {
        populateField(driver,expirationDateYear , text);
        return this;
    }

    public CartPage clickPlaceAnOrder() {
        clickOnElement(placeOrderButton);
        return this;
    }

    public CartPage clickPayAndConfirmOrderButton() {
        clickOnElement(payAndConfirmOrderButton);
        return this;
    }

    public CartPage waitForYourOrderHasBeenSuccessfullyPlacedNotification() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccessfullyPlaced));
        return this;
    }

    public CartPage clickDeleteProductFromCart(int productId) {
        clickOnElement(deleteProductById(productId));
        return this;
    }





}
