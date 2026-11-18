package com.bancoeco.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private static final By USERNAME_INPUT = By.name("username");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");
    private static final By ERROR_MESSAGE = By.cssSelector("p.oxd-alert-content-text");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LoginPage esperarCarga() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        return this;
    }

    public void iniciarSesion(String usuario, String contrasena) {
        WebElement usuarioInput = wait.until(
                ExpectedConditions.elementToBeClickable(USERNAME_INPUT));
        usuarioInput.clear();
        usuarioInput.sendKeys(usuario);

        WebElement contrasenaInput = wait.until(
                ExpectedConditions.elementToBeClickable(PASSWORD_INPUT));
        contrasenaInput.clear();
        contrasenaInput.sendKeys(contrasena);

        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
    }

    public String obtenerMensajeError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE)).getText();
    }

    public boolean formularioEstaVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON)).isDisplayed();
    }

    public String obtenerUrlActual() {
        return driver.getCurrentUrl();
    }
}
