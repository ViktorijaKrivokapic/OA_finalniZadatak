package AutomationPractice.src.main.automationPractice.pages;

import AutomationPractice.src.main.automationPractice.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends Page{

    protected By fistProductViewButton = By.xpath ("//a*[text()='/product details/1']");
    protected By productAvailabilityInfo = By.xpath ("//p*[text()='In Stock']");
    protected By productName = By.xpath ("//h2*[text()='Blue Top']");
    protected By productCategory = By.xpath ("//h2*[text()='Category: Women > Tops']");
    protected By productPrice = By.xpath ("//*[@class='product-information']//span/span");
    protected By productCondition = By.xpath("//p*[text()='New']");
    protected By productBrand = By.xpath("//p*[text()='Polo']");
    protected By searchProductField = By.id("search_product");
    protected By searchedProducts = By.xpath("//h2[text()='Searched Products']");
    protected By searchedProduct1 = By.xpath("//h2[text()='Sleeveless Dress']");
    protected By searchedProduct2 = By.xpath("//h2[text()='Stylish Dress']");
    protected By viewFirstProductInProductPage = By.xpath("//a*[text()='/product details/1 ']");
    protected By addToCartButton = By.xpath("//*[@class='btn btn-default cart']");
    protected By womenProductsDress = By.xpath("//*[text()='Dress']");
    protected By womenTopsProductsSection = By.xpath("//*[text()='Women - Tops Products']");
    protected By tShirtsInMenCategory = By.xpath("//*[text()='Tshirts']");

    protected By poloBrand = By.xpath("//a*[text()='Polo']");
    protected By bibarand = By.xpath("//a*[text()='Biba']");
    protected By brandBibaProductsPage = By.xpath("//h2*[text()='Brand - Biba Products']");
    protected By mickeyMouseDressInBibaBrand = By.xpath("//p2[text()='Blue Cotton Indie Mickey Dress']");
    protected By longTulleDress = By.xpath("//p2[text()='Long Maxi Tulle Fancy Dress Up Outfits -Pink']");
    protected By blueTopInPoloBrand = By.xpath("//p*[text()='Blue Top']");



    public ProductsPage(WebDriver driver) {super(driver);
    }

    public ProductsPage clickFirstProductViewButton() {
        clickOnElement(fistProductViewButton);
        return this;
    }

    public ProductsPage waitForProductAvailabilityInfo() {
        waitForElement(driver,productAvailabilityInfo, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage waitForProductNameInfo() {
        waitForElement(driver,productName, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage waitForProductCategoryInfo() {
        waitForElement(driver,productCategory, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage waitForProductBrandInfo() {
        waitForElement(driver,productBrand, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage waitForProductPriceInfo() {
        waitForElement(driver,productPrice, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage populateSearchFieldonProductsPage(String searchText) {
        populateField(driver, searchProductField, searchText);
        return this;
    }

    public ProductsPage waitForSearchedProducts() {
        waitForElement(driver,searchedProducts, Constants.MEDIUM_WAIT);
        return this;
    }
    public ProductsPage waitForSearchedProduct1() {
        waitForElement(driver, searchedProduct1, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage waitForSearchedProduct2() {
        waitForElement(driver, searchedProduct2, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage viewFirstProductonProductPage() {
        clickOnElement(viewFirstProductInProductPage);
        return this;
    }

    public ProductsPage addProductToCart() {
        clickOnElement(addToCartButton);
        return this;
    }

    public ProductsPage clickOnWomenProductsDress() {
        clickOnElement(womenProductsDress);
        return this;
    }

    public ProductsPage waitForWomenTopsProductsSection() {
        waitForElement(driver, womenTopsProductsSection, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage clickOnTshirtsInMenCategory() {
        clickOnElement(tShirtsInMenCategory);
        return this;
    }

    public ProductsPage waitForMensTshirtCategoryPage() {
        waitForElement(driver, tShirtsInMenCategory, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage waitForPoloBrand() {
        waitForElement(driver, poloBrand, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage waitForBibaBrand() {
        waitForElement(driver, bibarand, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage clickOnBibaBrand() {
        clickOnElement(bibarand);
        return this;
    }

    public ProductsPage waitForBrandBibaProductsPage() {
        waitForElement(driver, brandBibaProductsPage, Constants.MEDIUM_WAIT);
        return this;
    }
    public ProductsPage waitForMickeyMouseDressOnBibaProductsPage() {
        waitForElement(driver, mickeyMouseDressInBibaBrand, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage waitForLongTulleDressOnBibaProductsPage() {
        waitForElement(driver, longTulleDress, Constants.MEDIUM_WAIT);
        return this;
    }

    public ProductsPage clickOnPoloBrand() {
        clickOnElement(poloBrand);
        return this;
    }

    public ProductsPage waitForBlueTopInPoloBrand() {
        waitForElement(driver, blueTopInPoloBrand, Constants.MEDIUM_WAIT);
        return this;
    }

}
