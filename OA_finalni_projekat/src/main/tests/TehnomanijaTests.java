package main.tests;

import main.pom_files.HomePage;
import main.pom_files.RegisterPage;
import main.selenium_core.DriverManager;
import main.selenium_core.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TehnomanijaTests {

    int waitForCaptcha = 120;

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
        String email = "Viktorija.krivokapic25+1@gmail.com";
        String lozinka = "Test123!@#";
        String brojTelefona = "0123456789";
        String datumRodjenja = "01.01.1970";
        String expectedText = "Uspešno ste se registrovali.";
        String errorMesssage = "Ocekivani i posmatrani text nisu identicni.";



        driverManager = DriverManagerFactory.getDriverManager("CHROME");
        driver = driverManager.getWebDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

        HomePage hp = new HomePage(driver);
        hp.hoverPrijava(driver)
                .waitForTooltip(driver)
                .clickToRegister(driver);

        RegisterPage rp = new RegisterPage(driver);
        rp.waitForTitle(driver)
                .acceptCookies();
        rp.populateName(ime)
                .populateSurname(prezime)
                .populateEmail(email)
                .confirmEmail(email)
                .populatePassword(lozinka)
                .confirmPassword(lozinka)
                .populateNumber(brojTelefona)
                .populateDateOfBirth(datumRodjenja)
                .acceptTerms();


        // cekaj 'waitForCaptcha' sekundi dok korisnik ne klikne captcha
        System.out.println("Imate "+waitForCaptcha+" sekundi da rijesite kepcu!");

        //rp.waitForCaptchaToBeSolved();

        //driver.manage().timeouts().implicitlyWait(waitForCaptcha, TimeUnit.SECONDS);

        rp.clickToRegister();

        String actualText = rp.getTextFromSuccessfulRegisterMessage();

        assert actualText==expectedText: errorMesssage;

    }
}
