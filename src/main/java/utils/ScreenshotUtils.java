package utils;

import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;    // <-- REQUIRED for Paths.get()
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            System.out.println("ScreenshotUtils.takeScreenshot - driver is null, cannot capture screenshot.");
            return null;
        }

        try {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            // Java 8 compatible folder path
            Path screenshotsDir = Paths.get("target", "screenshots");
            Files.createDirectories(screenshotsDir);

            Path screenshotPath =
                    screenshotsDir.resolve(testName + "_" + timestamp + ".png");

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), screenshotPath);

            String abs = screenshotPath.toAbsolutePath().toString();
            System.out.println("Screenshot saved: " + abs);
            return abs;

        } catch (Exception e) {
            System.out.println("ScreenshotUtils.takeScreenshot - failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}