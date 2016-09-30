package objects.asv;

import elements.Button;
import elements.Label;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class AsvMenu extends Page {

    public AsvMenu(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement asvCreate = Label.label(driver,"Создание карточки");
    public WebElement journal = Label.label(driver,"Журнал");
    public WebElement notificationsBell = Button.buttonWithDataQtip(driver,"Уведомления");

    @Step("Нажатие кнопки \"Создание карточки\".")
    public void asvCreateClick(){
        asvCreate.click();
    }

    @Step("Нажатие кнопки \"Журнал\".")
    public void journalClick(){
        journal.click();
    }

    @Step("Нажатие кнопки \"Колокольчик\" списка нотификаций.")
    public void notificationsBellClick(){
        notificationsBell.click();
    }

}
