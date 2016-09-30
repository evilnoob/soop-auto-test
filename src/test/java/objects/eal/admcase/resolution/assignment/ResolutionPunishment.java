package objects.eal.admcase.resolution.assignment;

import elements.BoundList;
import elements.CheckBox;
import elements.Title;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class ResolutionPunishment extends Page{

    public ResolutionPunishment(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Наказание");
    public WebElement mainPunishment = BoundList.inputFieldFromGradientBlock(driver, "Наказание", "Основное наказание");
    public WebElement additionalPunishment = BoundList.inputFieldFromGradientBlock(driver, "Наказание", "Дополнительное наказание");
    public WebElement checkbox = CheckBox.checkBoxFromGradientBlock(driver, "Наказание", "Возложена обязанность прохождения диагностики, профилактических мероприятий, лечения от наркомании и (или) медицинской и (или) социальной реабилитации (согласно ч. 2.1 ст. 4.1 КоАП)");

    @Step("Скрытие(раскрытие) блока \"Нарушение\".")
    public void titleClick(){
        title.click();
    }

    @Step("Заполнение поля \"Основное наказание\" значением {0}.")
    public void mainPunishmentInvoke(String data){
        typeAndClick(mainPunishment,data);
    }

    @Step("Заполнение поля \"Дополнительное наказание\" значением {0}.")
    public void additionalPunishmentInvoke(String data){
        typeAndClick(additionalPunishment,data);
    }

    @Step("Нажатие чекбокса \"Возложена обязанность\".")
    public void checkboxClick(){
        checkbox.click();
    }


}
