package main.pom_files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page{

    // konstruktor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    protected By linkPrijava = By.xpath("//*[@class='user-wraper']");
    protected By tooltipLogin = By.id("login_dropdown");
    protected By linkRegistracija = By.xpath("//div[@class='register-links-wrap']/a");
    protected By linkKategorijeProizvoda = By.className("scroll-category");



    //metode

    public HomePage hoverPrijava (){
        Actions hover = new Actions(driver);
        WebElement we = driver.findElement(linkPrijava);
        hover.moveToElement(we).perform();
        return this;
    }
    public HomePage hoverKategorijeProizvoda (){
        Actions hover = new Actions(driver);
        WebElement we = driver.findElement(linkKategorijeProizvoda);
        hover.moveToElement(we).perform();
        return this;
    }

    public HomePage waitForTooltip(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipLogin));
        return this;
    }

    public HomePage clickToRegister () {
        driver.findElement(linkRegistracija).click();
        return this;
    }
}
