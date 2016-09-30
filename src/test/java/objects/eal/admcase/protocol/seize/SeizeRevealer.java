package objects.eal.admcase.protocol.seize;

import elements.Button;
import elements.InputField;
import elements.Title;
import objects.eal.admcase.all.Employees;
import objects.Page;
import utils.TestEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.lang.reflect.InvocationTargetException;

public class SeizeRevealer extends Page{

    public SeizeRevealer(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Выявил нарушение");
    public WebElement surname = InputField.inputFieldFromGradientBlock(driver, "Выявил нарушение", "Фамилия");
    public WebElement name = InputField.inputFieldFromGradientBlock(driver, "Выявил нарушение", "Имя");
    public WebElement patronymic = InputField.inputFieldFromGradientBlock(driver, "Выявил нарушение", "Отчество");
    public WebElement chooseButton = Button.numberedButtonFromGradientBlock(driver, "Выявил нарушение", "1");

    @Step("Скрытие(раскрытие) блока \"Выявил нарушение\".")
    public void titleClick(){
        title.click();
    }

    @Step("Нажатие кнопки \"Выбрать сотрудника\" и выполнения сценария \"{0}\".")
    public void chooseButtonInvoke(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        chooseButton.click();
        TestEngine.executeTestFromData(driver, Employees.class, "data\\Blocks.xlsx", "Employees", data);
    }

}
