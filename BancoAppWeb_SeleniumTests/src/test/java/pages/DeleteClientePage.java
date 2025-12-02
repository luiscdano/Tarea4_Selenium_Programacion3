package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteClientePage {

    private WebDriver driver;

    private By botonEliminar = By.cssSelector("button[type='submit']");

    public DeleteClientePage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmarEliminacion() {
        driver.findElement(botonEliminar).click();
    }
} 