package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientesPage extends BasePage {

    By registrarBtn = By.linkText("Registrar Cliente");

    public ClientesPage(WebDriver driver) {
        super(driver);
    }

    public void irARegistrarCliente() {
        driver.findElement(registrarBtn).click();
    }
} 