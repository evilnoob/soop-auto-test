package objects.eal.admcase.all;

import elements.*;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class MedicalExamination extends Page{

    public MedicalExamination(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Мед. освидетельствование");
    public WebElement checkbox1 = CheckBox.checkBoxFromGradientBlock(driver, "Мед. освидетельствование", "Направление на медицинское освидетельствование на состояние опьянения (согласно ст. 27.12 КоАП)");


    @Step("Скрытие(раскрытие) блока \"Нарушение\".")
    public void titleClick(){
        title.click();
    }

    @Step("Нажатие чекбокса \"Направление на медицинское освидетельствование на состояние опьянения (согласно ст. 27.12 КоАП)\".")
    public void сheckbox1Click(){
        checkbox1.click();
    }

    @Step("Нажатие чекбокса \"Отказ от прохождения медицинского освидетельствования на состояние опьянения\".")
    public void сheckbox2Click(){
        WebElement checkbox2 = CheckBox.checkBoxFromGradientBlock(driver, "Мед. освидетельствование", "Отказ от прохождения медицинского освидетельствования на состояние опьянения");
        checkbox2.click();
    }

    @Step("Нажатие чекбокса \"Факт опьянения не установлен\".")
    public void сheckbox3Click(){
        WebElement checkbox3 = CheckBox.checkBoxFromGradientBlock(driver, "Мед. освидетельствование", "Факт опьянения не установлен");
        checkbox3.click();
    }

    @Step("Нажатие чекбокса \"Установлено алкогольное опьянение\".")
    public void сheckbox4Click(){
        WebElement checkbox4 = CheckBox.checkBoxFromGradientBlock(driver, "Мед. освидетельствование", "Установлено алкогольное опьянение");
        checkbox4.click();
    }

    @Step("Нажатие чекбокса \"Установлено наркотическое опьянение\".")
    public void сheckbox5Click(){
        WebElement checkbox5 = CheckBox.checkBoxFromGradientBlock(driver, "Мед. освидетельствование", "Установлено наркотическое опьянение");
        checkbox5.click();
    }

}
