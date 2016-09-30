package objects.all;

import elements.Button;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class SwitchModule extends Page {

    public SwitchModule(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement ealButton = Button.button(driver, "Административная практика");
    public WebElement asvButton = Button.button(driver, "Административный надзор");
    public WebElement juvButton = Button.button(driver, "Инспектор ПДН");
    public WebElement adminButton = Button.button(driver, "Администрирование");

    @Step("Выбор модуля \"Административная практика\".")
    public void ealButtonClick(){
        ealButton.click();
    }

    @Step("Выбор модуля \"Административный надзор\".")
    public void asvButtonClick(){
        asvButton.click();
    }

    @Step("Выбор модуля \"Инспектор ПДН\".")
    public void juvButtonClick(){
        juvButton.click();
    }

    @Step("Выбор модуля \"Администрирование\".")
    public void adminButtonClick(){
        adminButton.click();
    }

}
