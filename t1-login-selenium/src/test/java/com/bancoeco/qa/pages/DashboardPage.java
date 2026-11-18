package com.bancoeco.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {

    private static final By PAGE_TITLE =
            By.cssSelector("h6.oxd-topbar-header-breadcrumb-module");
    private static final By USER_MENU = By.cssSelector("p.oxd-userdropdown-name");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public DashboardPage esperarCarga() {
        wait.until(ExpectedConditions.urlContains("/dashboard/index"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_MENU));
        return this;
    }

    public String obtenerTitulo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE)).getText();
    }

    public boolean menuUsuarioEstaVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(USER_MENU)).isDisplayed();
    }

    public String obtenerUrlActual() {
        return driver.getCurrentUrl();
    }
}
