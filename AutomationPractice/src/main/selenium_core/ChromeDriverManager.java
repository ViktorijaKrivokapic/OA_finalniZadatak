package AutomationPractice.src.main.selenium_core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {


    protected void createWebDriver() {
        System.setProperty("webdriver.chrome.driver","AutomationPractice/src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        this.driver = new ChromeDriver();
    }
}
