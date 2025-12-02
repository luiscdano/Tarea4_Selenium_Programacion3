package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.function.Function;

public class BasePage {

    protected WebDriver driver;
    protected FluentWait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        // FluentWait profesional: más estable que WebDriverWait tradicional
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofMillis(450))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class);
    }

    // -----------------------------------------
    // 🔵 MÉTODOS DE ESPERA PROFESIONALES
    // -----------------------------------------

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean waitForURLContains(String fragment) {
        try {
            return wait.until((ExpectedCondition<Boolean>) d -> 
                d.getCurrentUrl().contains(fragment)
            );
        } catch (Exception e) {
            return false;
        }
    }

    // -----------------------------------------
    // 🔵 ACCIONES
    // -----------------------------------------

    public void writeText(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator) {
        WebElement element = waitForClickable(locator);
        element.click();
    }

    public String readText(By locator) {
        return waitForVisible(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitForVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }

    // -----------------------------------------
    // 🔵 UTILIDAD PROFESIONAL: SCROLL
    // -----------------------------------------

    public void scrollIntoView(By locator) {
        WebElement element = waitForVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // -----------------------------------------
    // 🔵 UTILIDAD PROFESIONAL: CLICK CON JS
    // -----------------------------------------

    public void forceClick(By locator) {
        WebElement element = waitForVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    // -----------------------------------------
    // 🔵 SCREENSHOT PROFESIONAL
    // -----------------------------------------

    public void takeScreenshot(String name) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File dest = new File("reports/screenshots/" + name + ".png");
            dest.getParentFile().mkdirs();

            Files.copy(src.toPath(), dest.toPath());

            System.out.println("📸 Screenshot guardado: " + dest.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("❌ ERROR al guardar screenshot: " + e.getMessage());
        }
    }

    // -----------------------------------------
    // 🔵 ESPERAR FIN DE CARGA DE PÁGINA
    // -----------------------------------------

    public void waitForPageLoaded() {
        wait.until((Function<WebDriver, Boolean>) driver -> 
            ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState")
                    .toString()
                    .equals("complete")
        );
    }
} 