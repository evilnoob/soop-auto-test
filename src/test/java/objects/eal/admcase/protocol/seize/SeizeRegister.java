package objects.eal.admcase.protocol.seize;

import elements.*;
import objects.eal.admcase.all.Items;
import objects.Page;
import utils.TestEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.lang.reflect.InvocationTargetException;

public class SeizeRegister extends Page{

    public SeizeRegister(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Опись изымаемых вещей и документов");
    public WebElement addItem = Button.buttonFromExtComp(driver, "Опись изымаемых вещей и документов", "Добавить вещь");
    public WebElement changeItem = Button.buttonFromExtComp(driver, "Опись изымаемых вещей и документов", "Изменить вещь");
    public WebElement deleteItem = Button.buttonFromExtComp(driver, "Опись изымаемых вещей и документов", "Удалить вещь");

    @Step("Скрытие(раскрытие) блока \"Выявил нарушение\".")
    public void titleClick(){
        title.click();
    }

    @Step("Нажатие кнопки \"Добавить вещь\".")
    public void addItemInvoke(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        addItem.click();
        TestEngine.executeTestFromData(driver, Items.class, "data\\eal\\admcase\\Items.xlsx", "Items", data);
    }

    @Step("Нажатие кнопки \"Добавить вещь\".")
    public void changeItemClick(){
        changeItem.click();
    }

    @Step("Нажатие кнопки \"Добавить вещь\".")
    public void deleteItemClick(){
        deleteItem.click();
    }

}
