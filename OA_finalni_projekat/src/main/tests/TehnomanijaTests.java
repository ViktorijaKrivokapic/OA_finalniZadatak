package main.tests;

import main.pom_files.HomePage;
import main.pom_files.RegisterPage;
import main.selenium_core.DriverManager;
import main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TehnomanijaTests {


   // @BeforeMethod
  /*  public void setup(){
        driverManager = DriverManagerFactory.getDriverManager("CHROME");
        driver = driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }*/
    /**
     * I
     * 1. Navigate to https://www.tehnomanija.rs/
     * 2. Hover over "Prijava"
     * 3. Click register
     * 4. Fill the form "Formular za registraciju"
     * (This includes the extra details fields and Captcha; If needed you can complete the capcha manually)
     * 5. Click "Registracija" button
     * 6 Verify that the user is registered message is shown.
     * */

    @Test
    public void registracijaKorisnika(){
        WebDriver driver;
        String URL = "https://www.tehnomanija.rs/";
        DriverManager driverManager;
        String ime = "Testerica";
        String prezime = "Testerovic";
        String email = "Viktorija.krivokapic25@gmail.com";
        String lozinka = "test123!@#";
        String brojTelefona = "0123456789";
        String datumRodjenja = "01.01.1970";


        driverManager = DriverManagerFactory.getDriverManager("CHROME");
        driver = driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

        HomePage hp = new HomePage(driver);
        hp.hoverPrijava(driver)
                .waitForTooltip(driver)
                .clickToRegister(driver);

        RegisterPage rp = new RegisterPage(driver);
        rp.waitForTitle(driver);
        rp.populateName(ime).populateSurname(prezime).populateEmail(email).confirmEmail(email).populatePassword(lozinka);

    }
}
