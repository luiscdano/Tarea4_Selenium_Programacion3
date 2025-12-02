package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {
        try {
            String folderPath = "Reports/Screenshots/";
            Files.createDirectories(Paths.get(folderPath));

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String filePath = folderPath + testName + "_" + System.currentTimeMillis() + ".png";

            File dest = new File(filePath);
            Files.copy(src.toPath(), dest.toPath());

            return dest.getAbsolutePath();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
} 