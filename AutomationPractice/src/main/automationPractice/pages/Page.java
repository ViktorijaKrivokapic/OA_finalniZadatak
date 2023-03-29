package AutomationPractice.src.main.automationPractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    //konstruktor
    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public Page populateField(WebDriver driver, By by, String text){
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
        return this;
    }

    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    public void waitForElement(WebDriver driver, By by, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public Select selectDropdown(WebDriver driver, By by) {
        Select dropdown = new Select(driver.findElement(by));
        return dropdown;
    }

    public void scrollToElement(By identifier){
        WebElement scrollElement = driver.findElement(identifier);
        Actions actions = new Actions(driver);
        actions.moveToElement(scrollElement);
        actions.perform();
    }
}
