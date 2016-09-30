package objects.eal.admcase.resolution.cancellation;

import elements.BoundList;
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

public class CancellationComposer extends Page{

    public CancellationComposer(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Кем вынесено");
    public WebElement composerType = BoundList.inputFieldFromGradientBlock(driver, "Кем вынесено", "Кем вынесено");
    public WebElement surname = InputField.inputFieldFromGradientBlock(driver, "Кем вынесено", "Фамилия");
    public WebElement name = InputField.inputFieldFromGradientBlock(driver, "Кем вынесено", "Имя");
    public WebElement patronymic = InputField.inputFieldFromGradientBlock(driver, "Кем вынесено", "Отчество");
    public WebElement chooseButton = Button.numberedButtonFromGradientBlock(driver, "Кем вынесено", "1");

    @Step("Скрытие(раскрытие) блока \"Кем вынесено\".")
    public void titleClick(){
        title.click();
    }

    @Step("Заполнение поля \"Кем вынесено\" значением {0}.")
    public void composerTypeInput(String data){
        typeAndClick(composerType,data);
    }

    @Step("Заполнение поля \"Фамилия\" значением {0}.")
    public void surnameInput(String data){
        surname = InputField.inputFieldFromGradientBlock(driver, "Кем вынесено", "Фамилия");
        surname.sendKeys(data);
    }

    @Step("Заполнение поля \"Имя\" значением {0}.")
    public void nameInput(String data){
        name = InputField.inputFieldFromGradientBlock(driver, "Кем вынесено", "Имя");
        name.sendKeys(data);
    }

    @Step("Заполнение поля \"Отчество\" значением {0}.")
    public void patronymicInput(String data){
        patronymic = InputField.inputFieldFromGradientBlock(driver, "Кем вынесено", "Отчество");
        patronymic.sendKeys(data);
    }

    @Step("Заполнение поля \"Кем вынесено\" значением {0}.")
    public void mvdDepartmentInput(String data){
        if (composerType.getAttribute("value").equals("МВД")){
            WebElement department = BoundList.inputFieldFromGradientBlock(driver, "Кем вынесено", "Тер. орган");
            typeAndClick(department,data);
        }
    }

    @Step("Нажатие кнопки \"Выбрать сотрудника\" и выполнения сценария \"{0}\".")
    public void chooseButtonInvoke(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        chooseButton.click();
        TestEngine.executeTestFromData(driver, Employees.class, "data\\all\\Employees.xlsx", "Employees", data);
    }
}
