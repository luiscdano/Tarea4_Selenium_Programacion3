package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By linkRegister = By.linkText("Registrarse");
    private By emailInput = By.id("Input_Email");
    private By passInput = By.id("Input_Password");
    private By confirmPassInput = By.id("Input_ConfirmPassword");

    private By btnRegister = By.cssSelector("button[type='submit']");

    private By mensajeConfirmacion = By.xpath("//*[contains(text(),'Confirma')]");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navegar() {
        driver.get("http://localhost:5239");
        wait.until(ExpectedConditions.elementToBeClickable(linkRegister)).click();
    }

    public void registrarUsuario(String email, String password) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput))
                .sendKeys(email);

        driver.findElement(passInput).sendKeys(password);
        driver.findElement(confirmPassInput).sendKeys(password);

        driver.findElement(btnRegister).click();
    }

    public boolean registroExitoso() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeConfirmacion));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
} 