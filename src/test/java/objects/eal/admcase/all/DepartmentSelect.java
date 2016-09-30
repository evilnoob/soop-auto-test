package objects.eal.admcase.all;

import elements.*;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class DepartmentSelect extends Page{

    public DepartmentSelect(WebDriver driver) {
        super(driver);
    }

    public WebElement department= InputField.inputFieldFromWindow(driver, "Выберите тер. орган дела", "Тер. орган");
    public WebElement selectButton = Button.buttonFromWindow(driver, "Выберите тер. орган дела", "Выбрать");
    public WebElement cancelButton = Button.buttonFromWindow(driver, "Выберите тер. орган дела", "Отменить");


    @Step("Заполнение поля \"Тер. орган\" значением {0}.")
    public void departmentInput(String data) {
        department.sendKeys(data);
    }

    @Step("Нажатие кнопки \"Выбрать\".")
    public void selectButtonClick() {
        selectButton.click();
    }

    @Step("Нажатие кнопки \"Отменить\".")
    public void cancelButtonClick() {
        cancelButton.click();
    }
}
