package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrarClientePage {

    private WebDriver driver;

    public RegistrarClientePage(WebDriver driver) {
        this.driver = driver;
    }

    private By campoNombre = By.id("Nombre");
    private By campoApellido = By.id("Apellido");
    private By campoTelefono = By.id("Telefono");
    private By campoEmail = By.id("Email");
    private By botonRegistrar = By.id("btnRegistrarCliente");

    public void registrarCliente(String nombre, String apellido, String telefono, String email) {
        driver.findElement(campoNombre).sendKeys(nombre);
        driver.findElement(campoApellido).sendKeys(apellido);
        driver.findElement(campoTelefono).sendKeys(telefono);
        driver.findElement(campoEmail).sendKeys(email);
        driver.findElement(botonRegistrar).click();
    }
} 