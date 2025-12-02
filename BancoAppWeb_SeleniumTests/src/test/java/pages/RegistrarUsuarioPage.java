package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrarUsuarioPage extends BasePage {

    private By emailField = By.id("Input_Email");
    private By passwordField = By.id("Input_Password");
    private By confirmPasswordField = By.id("Input_ConfirmPassword");
    private By registerButton = By.id("register-submit");

    public RegistrarUsuarioPage(WebDriver driver) {
        super(driver);
    }

    public void navegarARegistroUsuario() {
        driver.get("http://localhost:5239/Identity/Account/Register");
    }

    public void registrarUsuario(String email, String password) {
        writeText(emailField, email);
        writeText(passwordField, password);
        writeText(confirmPasswordField, password);
        click(registerButton);
    }

    public boolean validarRegistroExitoso() {
        return driver.getPageSource().contains("Hola,");
    }
} 