package objects.eal.admcase.all.offence;

import elements.*;
import objects.eal.admcase.all.KoAP;
import objects.Page;
import utils.TestEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import java.lang.reflect.InvocationTargetException;

public class Offence extends Page{

    public Offence(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Нарушение");
    public WebElement article = BoundList.inputFieldFromGradientBlock(driver, "Нарушение", "Статья");
    public WebElement part = BoundList.inputFieldFromGradientBlock(driver, "Нарушение", "часть");
    public WebElement item = BoundList.inputFieldFromGradientBlock(driver, "Нарушение", "пункт");
    public WebElement KoAPButton = Button.buttonFromGradientBlock(driver, "Нарушение", "КоАП РФ");
    public WebElement subjectArticleCheckbox = CheckBox.checkBoxFromGradientBlock(driver, "Нарушение", "Статья субъекта");
    public WebElement character = BoundList.inputFieldFromGradientBlock(driver, "Нарушение", "Характер нарушения");
    public WebElement repeatedCheckbox = CheckBox.checkBoxFromGradientBlock(driver, "Нарушение", "Повторность совершения");

    @Step("Скрытие(раскрытие) блока \"Нарушение\".")
    public void titleClick(){
        title.click();
    }

    @Step("Заполнение поля \"Статья\" значением {0}.")
    public void articleInput(String data){
        typeAndClick(article,data);
    }

    @Step("Заполнение поля \"часть\" значением {0}.")
    public void partInput(String data){
        typeAndClick(part,data);
    }

    @Step("Заполнение поля \"пункт\" значением {0}.")
    public void itemInput(String data){
        typeAndClick(item,data);
    }

    @Step("Нажатие кнопки \"КоАП\".")
    public void koapButtonInvoke(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        KoAPButton.click();
        //Thread.currentThread().sleep(2000);
        TestEngine.executeTestFromData(driver, KoAP.class, "data\\all\\KoAP.xlsx", "KoAP", data);
        //Thread.currentThread().sleep(10000);
    }

    @Step("Заполнение поля \"Характер нарушения\" значением {0}.")
    public void characterInput(String data){
        typeAndClick(character,data);
    }

    @Step("Нажатие чекбокса \"Повторность совершения\".")
    public void repeatedCheckboxClick(){
        repeatedCheckbox.click();
    }

    @Step("Нажатие чекбокса \"Статья субъекта\".")
    public void subjectArticleCheckboxClick(){
        subjectArticleCheckbox.click();
    }

    @Step("Выбор случайно статьи \"КоАП\".")
    public void randomArticleInvoke(String data){
        KoAPButton.click();
    }


}
