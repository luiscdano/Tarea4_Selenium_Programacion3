package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditClientePage {

    private WebDriver driver;

    private By nombreInput = By.id("Nombre");
    private By apellidoInput = By.id("Apellido");
    private By telefonoInput = By.id("Telefono");
    private By emailInput = By.id("Email");
    private By botonActualizar = By.cssSelector("button[type='submit']");

    public EditClientePage(WebDriver driver) {
        this.driver = driver;
    }

    public void editarCliente(String nombre, String apellido, String telefono, String email) {
        driver.findElement(nombreInput).clear();
        driver.findElement(nombreInput).sendKeys(nombre);

        driver.findElement(apellidoInput).clear();
        driver.findElement(apellidoInput).sendKeys(apellido);

        driver.findElement(telefonoInput).clear();
        driver.findElement(telefonoInput).sendKeys(telefono);

        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);

        driver.findElement(botonActualizar).click();
    }
} 