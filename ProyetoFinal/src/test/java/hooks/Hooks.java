package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private static WebDriver driver;
    private static Scenario scenario;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before(order = 0)
    public void setUp() {
        // Detectar SO
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            WebDriverManager.chromedriver().setup();
        } else if (os.contains("mac")) {
            WebDriverManager.chromedriver().setup();
        } else {
            throw new IllegalStateException("Unsupported operating system: " + os);
        }

        // Configuración HTTP Factory
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public static void esperaImplicita() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
