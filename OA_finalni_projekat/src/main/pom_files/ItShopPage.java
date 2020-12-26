package main.pom_files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItShopPage extends Page{
    public ItShopPage(WebDriver driver) {
        super(driver);
    }

    // selectors
    protected By LinkSlika(String naslov) {
        String locatorText = "//a[@title='"+naslov+"']";
        return By.xpath(locatorText);
    }

    // methods

    public ItShopPage clickOnImageLink(String text){
        clickOnElement(LinkSlika(text));
        return this;
    }
}
