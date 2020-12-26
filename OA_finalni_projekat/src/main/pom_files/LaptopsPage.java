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

    // methods

    public LaptopsPage filterByProducer(String text){
        clickOnElement(checkboxProizvodjac(text));
        waitForFiltersTitle();
        return this;
    }

    public LaptopsPage waitForFiltersTitle() {
        waitForElement(driver,activeFiltersTitle,10);
        return this;
    }
}
