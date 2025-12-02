package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginCorrecto() {

        driver.get(BASE_URL + "/Identity/Account/Login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Usuario válido
        WebElement emailInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("Input_Email"))
        );
        WebElement passwordInput = driver.findElement(By.id("Input_Password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit'], input[type='submit']"));

        emailInput.sendKeys("pedrodavid@hotmail.com");
        passwordInput.sendKeys("123456");
        loginButton.click();

        By logoutLocator = By.xpath(
                "//*[contains(" +
                        "translate(normalize-space(.)," +
                        " 'ABCDEFGHIJKLMNOPQRSTUVWXYZÁÉÍÓÚáéíóú'," +
                        " 'abcdefghijklmnopqrstuvwxyzaeiouaeiou')," +
                        " 'cerrar sesion')]"
        );

        WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLocator));

        Assert.assertTrue(logoutBtn.isDisplayed());

        takeScreenshot("LoginCorrecto");
    }
}
 