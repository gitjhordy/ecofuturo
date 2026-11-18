package com.bancoeco.qa.support;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class ScreenshotOnFailureExtension implements AfterTestExecutionCallback {

    private static final DateTimeFormatter TIMESTAMP =
            DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
    private final Supplier<WebDriver> driverSupplier;

    public ScreenshotOnFailureExtension(Supplier<WebDriver> driverSupplier) {
        this.driverSupplier = driverSupplier;
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isEmpty()) {
            return;
        }

        WebDriver driver = driverSupplier.get();
        if (!(driver instanceof TakesScreenshot screenshotDriver)) {
            return;
        }

        try {
            Path evidenceDirectory = Path.of("target", "evidencias");
            Files.createDirectories(evidenceDirectory);
            String testName = context.getRequiredTestMethod().getName();
            Path output = evidenceDirectory.resolve(
                    testName + "-" + LocalDateTime.now().format(TIMESTAMP) + ".png");
            Files.write(output, screenshotDriver.getScreenshotAs(OutputType.BYTES));
            System.err.println("Evidencia del fallo: " + output.toAbsolutePath());
        } catch (IOException | RuntimeException error) {
            System.err.println("No se pudo guardar la captura del fallo: " + error.getMessage());
        }
    }
}
