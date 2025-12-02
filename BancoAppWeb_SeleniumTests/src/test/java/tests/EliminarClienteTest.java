package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import pages.DeleteClientePage;

public class EliminarClienteTest extends BaseTest {

    @Test
    public void eliminarCliente() {

        driver.get(BASE_URL + "/Clientes");

        driver.findElement(By.cssSelector("a.btn-danger")).click();

        DeleteClientePage deletePage = new DeleteClientePage(driver);
        deletePage.confirmarEliminacion();

        takeScreenshot("cliente_eliminado");
    }
} 