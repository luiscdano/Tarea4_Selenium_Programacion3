package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ListarClientesPage;

public class ListarClientesTest extends BaseTest {

    @Test
    public void testListarClientes() {

        driver.get(BASE_URL + "/Clientes");

        ListarClientesPage page = new ListarClientesPage(driver);

        boolean hayTabla = page.hayClientes();
        boolean hayMensajeVacio = page.hayMensajeDeListaVacia();

        Assert.assertTrue(
                hayTabla || hayMensajeVacio,
                "NO se encontró ni tabla ni mensaje de lista vacía."
        );

        takeScreenshot("listar_clientes");
    }
} 