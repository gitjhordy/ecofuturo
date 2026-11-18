package com.bancoeco.qa.base;

import com.bancoeco.qa.config.TestConfig;
import com.bancoeco.qa.support.ScreenshotOnFailureExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @RegisterExtension
    final ScreenshotOnFailureExtension screenshotOnFailure =
            new ScreenshotOnFailureExtension(() -> driver);

    @BeforeEach
    void abrirNavegador() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1440,900");
        if (!TestConfig.VISUAL) {
            options.addArguments("--headless=new");
        }

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TestConfig.TIMEOUT_SECONDS));
        driver.get(TestConfig.BASE_URL);
    }

    @AfterEach
    void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
