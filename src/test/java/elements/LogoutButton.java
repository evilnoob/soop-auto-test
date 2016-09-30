package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutButton{

    public static WebElement logoutButton(WebDriver driver){
        return driver.findElement(By.xpath(Locator.findLogoutButton()));
    }
}
