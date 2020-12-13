package pom_files;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Page{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    // selektori

    protected By naslovStrane = By.xpath("//h1[text()='Formular za registraciju']");
}
