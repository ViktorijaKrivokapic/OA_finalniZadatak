package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom_files.HomePage;
import selenium_core.DriverManager;
import selenium_core.DriverManagerFactory;

import java.util.concurrent.TimeUnit;

public class TehnomanijaTests {
    WebDriver driver;
    String URL = "https://www.tehnomanija.rs/";
    DriverManager driverManager;
    HomePage hp;

    @BeforeMethod
    public void setup(){
        driverManager = DriverManagerFactory.getDriverManager("CHROME");
        driver = driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    /**
     * I
     * 1. Navigate to https://www.tehnomanija.rs/
     * 2. Hover over "Prijava"
     * 3. Click register
     * 4. Fill the form "Formular za registraciju"
     * (This includes the extra details fields and Captcha; If needed you can complete the capcha manually)
     * 5. Click "Regsitracija button"
     * 6 Verify that the user is registered message is shown.
     * */

    @Test
    public void registracijaKorisnika(){

    }
}
