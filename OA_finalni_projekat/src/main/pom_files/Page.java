package main.pom_files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Page {
    //konstruktor
    WebDriver driver;
    public Page(WebDriver driver){
        this.driver = driver;
    }

    // selektori

    protected By dugmeSlazemSe = By.xpath("//a[@data-dismiss='alert']");
    // metode

    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        element.click();
    }

    public void waitForElement(WebDriver driver, By by, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeClickable(WebDriver driver, By by, int timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver,timeoutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public Page populateField(WebDriver driver, By by, String text){
        WebElement element = driver.findElement(by);
        element.sendKeys(text);
        return this;
    }

    public Page clickOnElement(WebDriver driver, By by){
        WebElement element = driver.findElement(by);
        element.click();
        return this;
    }

    public String getTextFromElement(WebDriver driver, By by){
        WebElement element = driver.findElement(by);
        String text = element.getText().trim();
        return text;
    }
    public Page hoverElement(WebDriver driver, By by){
        Actions hover = new Actions(driver);
        WebElement we = driver.findElement(by);
        hover.moveToElement(we).perform();
        return this;
    }

    public Page implicitWaitInSeconds (WebDriver driver, int timeout){
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        return this;
    }

    public int getNumberOfElementsUsingXpath(By by){
        int count = driver.findElements(by).size();
        return count;
    }

    public Page acceptCookies(){
        clickOnElement(dugmeSlazemSe);
        return this;
    }

    public String getTextColor(WebDriver driver, By by){
        WebElement webElement = driver.findElement(by);
        String boja = webElement.getCssValue("color");
        return boja;
    }
}
