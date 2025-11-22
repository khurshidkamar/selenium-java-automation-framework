package utils;

import org.openqa.selenium.*;
import java.io.File;
import java.nio.file.Files;
import java.time.LocalDateTime;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {

        try {
            String time = LocalDateTime.now().toString().replace(":", "-");
            String path = "screenshots/" + testName + "_" + time + ".png";

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), new File(path).toPath());

            return path;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
