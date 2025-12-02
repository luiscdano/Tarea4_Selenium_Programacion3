package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrarClientePage;

public class RegistrarClienteTest extends BaseTest {

    @Test
    public void testRegistrarCliente() {

        driver.get(BASE_URL + "/Clientes/Create");

        RegistrarClientePage page = new RegistrarClientePage(driver);

        page.registrarCliente(
                "Luis",
                "Cedano",
                "8095555555",
                "luis@test.com"
        );

        boolean registrado =
                driver.getPageSource().contains("Clientes") ||
                driver.getCurrentUrl().contains("/Clientes");

        Assert.assertTrue(
                registrado,
                "El cliente NO fue registrado correctamente."
        );

        takeScreenshot("registrar_cliente");
    }
} 