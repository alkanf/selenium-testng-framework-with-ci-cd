package utilities;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshot {
    public static String takeScreenshot(WebDriver driver, String testName) { // String return must
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String path = "screenshots/" + testName + "_" + timestamp + ".png"; // Take Path
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(path));
            Log.info("Screenshot is saved: " + testName);
            return path; // Saved location
        } catch (IOException e) {
            Log.error("Screenshot is not saved: " + e.getMessage());
            return null;
        }
    }
}