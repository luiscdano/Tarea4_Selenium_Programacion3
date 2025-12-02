package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListarClientesPage {

    private WebDriver driver;

    public ListarClientesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By tablaClientes = By.tagName("table");
    private By mensajeVacio = By.xpath("//*[contains(text(),'No hay clientes registrados')]");

    public boolean hayClientes() {
        return driver.findElements(tablaClientes).size() > 0;
    }

    public boolean hayMensajeDeListaVacia() {
        return driver.findElements(mensajeVacio).size() > 0;
    }
}