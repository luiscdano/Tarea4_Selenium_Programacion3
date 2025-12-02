package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.UUID;

public class RegistrarUsuarioTest extends BaseTest {

    @Test
    public void testRegistrarUsuario() {
        driver.get(BASE_URL + "/Identity/Account/Register");

        String email = "user_" + UUID.randomUUID() + "@hotmail.com";

        driver.findElement(By.id("Input_Email")).sendKeys(email);
        driver.findElement(By.id("Input_Password")).sendKeys("Prueba123*");
        driver.findElement(By.id("Input_ConfirmPassword")).sendKeys("Prueba123*");

        // BOTÓN UNIVERSAL
        driver.findElement(By.cssSelector("button[type='submit'], input[type='submit']")).click();

        By LOGOUT = By.xpath("//*[contains(text(),'Cerrar') and contains(text(),'sesión')]");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT));

        Assert.assertTrue(logoutBtn.isDisplayed(), "El registro NO dejó al usuario logueado.");
    }
} 