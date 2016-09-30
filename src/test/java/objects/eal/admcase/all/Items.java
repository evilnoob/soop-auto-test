package objects.eal.admcase.all;

import elements.*;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class Items extends Page {

    public Items(WebDriver driver) {
        super(driver);
    }

    public WebElement itemType = BoundList.inputFieldFromWindow(driver,"Добавить вещь","Тип вещи");
    public WebElement measure = InputField.inputFieldFromWindow(driver,"Добавить вещь","Ед.изм");
    public WebElement quantity = InputField.inputFieldFromWindow(driver,"Добавить вещь","Количество");
    public WebElement sum = InputField.inputFieldFromWindow(driver,"Добавить вещь","На сумму (руб.)");
    public WebElement saveButton = Button.buttonFromWindow(driver,"Добавить вещь","Сохранить");
    public WebElement cancelButton = Button.buttonFromWindow(driver,"Добавить вещь","Отменить");

    @Step("Заполнение поля \"Тип вещи\" значением {0}.")
    public void itemTypeInput(String data){
        itemType.sendKeys(data);
    }

    @Step("Заполнение поля \"Ед.изм\" значением {0}.")
    public void measureInput(String data){
        measure.sendKeys(data);
    }

    @Step("Заполнение поля \"Количество\" значением {0}.")
    public void quantityInput(String data){
        quantity.sendKeys(data);
    }

    @Step("Заполнение поля \"Сумма\" значением {0}.")
    public void sumInput(String data){
        sum.sendKeys(data);
        measure.click();
    }

    @Step("Нажатие кнопки \"Сохранить\".")
    public void saveButtonClick(){
        saveButton.click();
    }

    @Step("Нажатие кнопки \"Отмена\".")
    public void cancelButtonClick(){
        cancelButton.click();
    }

}
