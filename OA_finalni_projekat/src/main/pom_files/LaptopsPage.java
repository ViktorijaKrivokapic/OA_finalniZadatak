package main.pom_files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaptopsPage extends Page{
    public LaptopsPage(WebDriver driver) {
        super(driver);
    }

    // selectors
    protected By checkboxProizvodjac(String proizvodjac) {
        String locatorText = "//input[@value='"+proizvodjac+"']";
        return By.xpath(locatorText);
    }
    protected By activeFiltersTitle = By.xpath("//span[text()='Aktivni filteri:']");
    protected By anyProductLink = By.className("product-link");
    protected By productTextByIndex(int index){
        String locatorText = "(//*[@class='product-name-grid'])["+index+"]";
        return By.xpath(locatorText);
    }
    protected By sortButton = By.className("sort-products");
    protected By padajuciMeni = By.xpath("//*[@class='sort-select'][contains(@style,'block')]");
    protected By stavkaIzMenijaPremaTekstu(String tekst) {
            String locatorText = "//*[@name='sort'][text()='"+tekst+"']";
        return By.xpath(locatorText);
    }
    protected By priceByIndex(int index) {
        String locatorText = "(//*[@class='price'])["+index+"]";
        return By.xpath(locatorText);
    }

    // methods

    public LaptopsPage filterByProducer(String text){
        scrollToElement(checkboxProizvodjac(text));
        clickOnElement(checkboxProizvodjac(text));
        waitForFiltersTitle();
        return this;
    }

    public LaptopsPage waitForFiltersTitle() {
        waitForElement(driver,activeFiltersTitle,10);
        return this;
    }

    public int getNumberOfProducts(){
        int numberOfProducts = driver.findElements(anyProductLink).size();
        return numberOfProducts;
    }

    public String getProductDescriptionTextByIndex(int index){
        String text = driver.findElement(productTextByIndex(index)).getText();
        return text;
    }
    public String getProductPrice(int index){
        String text = driver.findElement(priceByIndex(index)).getText();
        return text;
    }

    public LaptopsPage openSortMenu(){
        clickOnElement(sortButton);
        waitForElement(driver,padajuciMeni,10);
        return this;
    }

    public LaptopsPage clickOnSortItem(String text){
        clickOnElement(stavkaIzMenijaPremaTekstu(text));
        return this;
    }

    public LaptopsPage sortByText(String stavka){
        openSortMenu();
        clickOnSortItem(stavka);
        return this;
    }
}
