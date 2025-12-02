package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ErrorLoginTest extends BaseTest {

    @Test
    public void testErrorLogin() {

        LoginPage login = new LoginPage(driver);

        // FIX: botón real en tu navbar
        login.navegarLogin(); // (este método ya debe usar "Iniciar sesión")

        login.login("wrong@bank.com", "123");

        Assert.assertTrue(
                login.validarErrorLogin(),
                "El sistema NO mostró el mensaje de error esperado."
        );

        takeScreenshot("error_login");
    }
} 