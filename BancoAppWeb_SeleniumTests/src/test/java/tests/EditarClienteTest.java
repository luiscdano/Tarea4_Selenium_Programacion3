package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EditarClienteTest extends BaseTest {

    private void loginComoUsuarioValido() {
        driver.get(BASE_URL + "/Identity/Account/Login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.findElement(By.id("Input_Email")).sendKeys("pedrodavid@hotmail.com");
        driver.findElement(By.id("Input_Password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[contains(text(),'Cerrar sesión')]")
        ));
    }

    @Test
    public void editarCliente() {

        loginComoUsuarioValido();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get(BASE_URL + "/Clientes");

        // Esperar tabla cargada
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("table tbody tr")
        ));

        // Click en botón Editar
        WebElement editarBtn = driver.findElement(
                By.xpath("//table/tbody/tr[1]//a[contains(text(),'Editar')]")
        );
        editarBtn.click();

        // Editar datos
        WebElement nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Nombre")));
        WebElement apellido = driver.findElement(By.id("Apellido"));

        nombre.clear();
        nombre.sendKeys("Luis Editado");

        apellido.clear();
        apellido.sendKeys("Cedano Editado");

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Validar actualización
        WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'actualizado')]")
        ));

        Assert.assertTrue(mensaje.isDisplayed());

        takeScreenshot("EditarCliente");
    }
} 