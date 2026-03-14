package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screenshot {
    public static void takeScreenshot(WebDriver driver, String testName) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("screenshots/" + testName + "_" + timestamp + ".png"));
            Log.info("Screenshot is saved: " + testName);
        } catch (IOException e) {
            Log.error("Screenshot is not saved: " + e.getMessage());
        }
    }
}