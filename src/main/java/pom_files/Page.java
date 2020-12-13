package pom_files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
    //konstruktor
    WebDriver driver;
    public Page(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnElement(WebElement element){
        element.click();
    }
}
