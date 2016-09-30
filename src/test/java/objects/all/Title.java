package objects.all;

import elements.Button;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class Title extends Page {

    public Title(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement switchModuleButton = Button.switchModuleButton(driver);
    public WebElement logoutButton = Button.logoutButton(driver);

    @Step("Смена модуля.")
    public void switchModuleButtonClick(){
        switchModuleButton.click();
    }

    @Step("Выход из системы.")
    public void logoutClick(){
        logoutButton.click();
        WebElement okButton = Button.buttonFromMessageBox(driver,"Вы действительно хотите выйти?","Да");
        //WebElement cancelButton;
        okButton.click();
    }


}
