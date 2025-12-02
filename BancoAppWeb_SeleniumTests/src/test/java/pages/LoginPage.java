package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Selectores
    private By linkLogin = By.linkText("Iniciar sesión");
    private By emailInput = By.id("Input_Email");
    private By passInput = By.id("Input_Password");
    private By btnLogin = By.id("login-submit");
    private By errorMsg = By.cssSelector(".text-danger, .validation-summary-errors li");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navegar a la pantalla de login
    public void navegarLogin() {
        driver.get("http://localhost:5239");

        wait.until(ExpectedConditions.elementToBeClickable(linkLogin))
                .click();
    }

    // Ejecutar login
    public void login(String email, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput))
                .sendKeys(email);

        driver.findElement(passInput).sendKeys(password);

        driver.findElement(btnLogin).click();
    }

    // Validar error de login
    public boolean validarErrorLogin() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
} 