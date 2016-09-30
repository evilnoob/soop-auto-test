package objects.admin;

import elements.Label;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class AdminMenu extends Page {

    public AdminMenu(WebDriver webDriver){
        super(webDriver);
    }

    public WebElement departments = Label.label(driver,"Тер. органы");
    public WebElement roles = Label.label(driver,"Роли");
    public WebElement users = Label.label(driver,"Сотрудники");
    public WebElement dictionaries = Label.label(driver,"Справочники");

    @Step("Нажатие кнопки \"Создание дела\".")
    public void departmentsClick(){
        departments.click();
    }

    @Step("Нажатие кнопки \"Журнал\".")
    public void rolesClick(){
        roles.click();
    }

    @Step("Нажатие кнопки \"Отчеты\".")
    public void usersClick(){
        users.click();
    }

    @Step("Нажатие кнопки \"Представления\".")
    public void dictionariesClick(){
        dictionaries.click();
    }

}
