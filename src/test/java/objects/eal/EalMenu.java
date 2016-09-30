package objects.eal;

import elements.Label;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class EalMenu extends Page {

    public EalMenu(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement caseCreate = Label.label(driver,"Создание дела");
    public WebElement journal = Label.label(driver,"Журнал");
    public WebElement reports = Label.label(driver,"Отчеты");
    public WebElement proposals = Label.label(driver,"Представления");

    @Step("Нажатие кнопки \"Создание дела\".")
    public void caseCreateClick(){
        caseCreate.click();
    }

    @Step("Нажатие кнопки \"Журнал\".")
    public void journalClick(){
        journal.click();
    }

    @Step("Нажатие кнопки \"Отчеты\".")
    public void reportsClick(){
        reports.click();
    }

    @Step("Нажатие кнопки \"Представления\".")
    public void proposalClick(){
        proposals.click();
    }

}
