package objects.eal.admcase.act.retrieve;

import elements.InputField;
import elements.Title;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class ReturnComposer extends Page{

    public ReturnComposer(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Составил определение");
    public WebElement surname = InputField.inputFieldFromGradientBlock(driver, "Составил определение", "Фамилия");
    public WebElement name = InputField.inputFieldFromGradientBlock(driver, "Составил определение", "Имя");
    public WebElement patronymic = InputField.inputFieldFromGradientBlock(driver, "Составил определение", "Отчество");

    @Step("Скрытие(раскрытие) блока \"Составил определение\".")
    public void titleClick(){
        title.click();
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

}
