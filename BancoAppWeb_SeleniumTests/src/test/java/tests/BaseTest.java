package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {

    public WebDriver driver;   // ←🔥 CAMBIADO A PUBLIC
    protected final String BASE_URL = "http://localhost:5239";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void takeScreenshot(String name) {
        try {
            Files.createDirectories(Paths.get("Reports/screenshots"));
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Files.copy(
                    screenshot.toPath(),
                    Paths.get("Reports/screenshots/" + name + "_" + System.currentTimeMillis() + ".png")
            );
        } catch (Exception e) {
            System.out.println("❌ Error tomando screenshot: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 