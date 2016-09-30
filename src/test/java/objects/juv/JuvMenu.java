package objects.juv;

import elements.Label;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class JuvMenu extends Page {

    public JuvMenu(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement juvCreate = Label.label(driver,"Постановка на учет");
    public WebElement journal = Label.label(driver,"Журнал");

    @Step("Нажатие кнопки \"Постановка на учет\".")
    public void juvClick(){
        juvCreate.click();
    }

    @Step("Нажатие кнопки \"Журнал\".")
    public void journalClick(){
        journal.click();
    }

}
