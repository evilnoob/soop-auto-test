package utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot{

    public static byte[] captureScreenShot(WebDriver driver)
    {
        byte[] screenShot = null;
        screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screenShot;
    }

}
