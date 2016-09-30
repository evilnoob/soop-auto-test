package objects.eal.admcase.protocol.violation;

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

public class ViolationComposer extends Page{

    public ViolationComposer(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Составил протокол");
    public WebElement surname = InputField.inputFieldFromGradientBlock(driver, "Составил протокол", "Фамилия");
    public WebElement name = InputField.inputFieldFromGradientBlock(driver, "Составил протокол", "Имя");
    public WebElement patronymic = InputField.inputFieldFromGradientBlock(driver, "Составил протокол", "Отчество");
    public WebElement chooseButton = Button.numberedButtonFromGradientBlock(driver, "Составил протокол", "1");
    public WebElement copyButton = Button.buttonFromGradientBlock(driver, "Составил протокол", "Копировать в \"Выявил нарушение\"");

    @Step("Скрытие(раскрытие) блока \"Составил протокол\".")
    public void titleClick(){
        title.click();
    }

    @Step("Нажатие кнопки \"Выбрать сотрудника\" и выполнения сценария \"{0}\".")
    public void chooseButtonInvoke(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        chooseButton.click();
        TestEngine.executeTestFromData(driver, Employees.class, "data\\all\\Employees.xlsx", "Employees", data);
    }

    @Step("Нажатие кнопки \"Копировать в \"Выявил нарушение\"\".")
    public void copyButtonClick(){
        copyButton.click();
    }
}
