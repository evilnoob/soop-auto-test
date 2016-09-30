package objects.eal.admcase.act.investigation;

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

public class InvestigationComposer extends Page{

    public InvestigationComposer(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Составил определение");
    public WebElement surname = InputField.inputFieldFromGradientBlock(driver, "Составил определение", "Фамилия");
    public WebElement name = InputField.inputFieldFromGradientBlock(driver, "Составил определение", "Имя");
    public WebElement patronymic = InputField.inputFieldFromGradientBlock(driver, "Составил определение", "Отчество");
    public WebElement chooseButton = Button.numberedButtonFromGradientBlock(driver, "Составил определение", "1");
    public WebElement copyButton = Button.buttonFromGradientBlock(driver, "Составил определение", "Копировать в \"Выявил нарушение\"");

    @Step("Скрытие(раскрытие) блока \"Составил определение\".")
    public void titleClick(){
        title.click();
    }

    @Step("Нажатие кнопки \"Выбрать сотрудника\" и выполнения сценария \"{0}\".")
    public void chooseButtonInvoke(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        chooseButton.click();
        TestEngine.executeTestFromData(driver, Employees.class, "data\\all\\Employees.xlsx", "Employees", data);
    }

    @Step("Нажатие кнопки \"Копировать в \"Выявил нарушение\"\".")
    public void copyButtonClick(){
        copyButton.click();
    }
}
