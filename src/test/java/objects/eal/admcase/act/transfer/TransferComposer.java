package objects.eal.admcase.act.transfer;

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

public class TransferComposer extends Page{

    public TransferComposer(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Составил определение");
    public WebElement compiler = BoundList.inputFieldFromGradientBlock(driver, "Составил определение", "Кем вынесено");
    public WebElement compilerTrigger = BoundList.inputFieldTriggerFromGradientBlock(driver, "Составил определение", "Кем вынесено");
    public WebElement surname = InputField.inputFieldFromGradientBlock(driver, "Составил определение", "Фамилия");
    public WebElement name = InputField.inputFieldFromGradientBlock(driver, "Составил определение", "Имя");
    public WebElement patronymic = InputField.inputFieldFromGradientBlock(driver, "Составил определение", "Отчество");

    @Step("Скрытие(раскрытие) блока \"Составил определение\".")
    public void titleClick(){
        title.click();
    }

    @Step("Заполнение поля \"Кем вынесено\" значением {0}.")
    public void compilerInput(String data) throws InterruptedException {
        //typeAndClick(compiler, data);
        clickAndPick(compilerTrigger,data);
    }

    @Step("Заполнение поля \"Уточнение\" значением {0}.")
    public void descriptionInput(String data){
        WebElement description = InputField.inputNextFieldFromGradientBlock(driver, "Составил определение", "Кем вынесено");
        description.sendKeys(data);
    }

    @Step("Заполнение поля \"Фамилия\" значением {0}.")
    public void surnameInput(String data){
        surname.sendKeys(data);
    }

    @Step("Заполнение поля \"Фамилия\" значением {0}.")
    public void nameInput(String data){
        name.sendKeys(data);
    }

    @Step("Заполнение поля \"Фамилия\" значением {0}.")
    public void patronymicInput(String data){
        patronymic.sendKeys(data);
        surname.click();
    }

    @Step("Нажатие кнопки \"Выбрать сотрудника\" и выполнения сценария \"{0}\".")
    public void chooseButtonInvoke(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        if (compiler.getAttribute("value").equals("МВД")) {
            WebElement chooseButton = Button.numberedButtonFromGradientBlock(driver, "Составил определение", "1");
            chooseButton.click();
            TestEngine.executeTestFromData(driver, Employees.class, "data\\all\\Employees.xlsx", "Employees", data);
        }
    }
}
