package objects.eal.admcase.resolution.cancellation;

import elements.BoundList;
import elements.CheckBox;
import elements.Date;
import elements.Title;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.SimpleDateFormat;

public class CancellationCause extends Page{

    public CancellationCause(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Обжалование");
    public WebElement reason = BoundList.inputFieldFromGradientBlock(driver, "Причина прекращения дела", "Причина");
    public WebElement stopDate = Date.inputFieldFromGradientBlock(driver, "Причина прекращения дела", "Дата прекращения");
    public WebElement dutyCheckbox = CheckBox.checkBoxFromGradientBlock(driver, "Причина прекращения дела", "Возложена обязанность прохождения диагностики, профилактических мероприятий, лечения от наркомании и (или) медицинской и (или) социальной реабилитации (согласно ч. 2.1 ст. 4.1 КоАП)");
    public WebElement verbalRemarkCheckbox = CheckBox.checkBoxFromGradientBlock(driver, "Причина прекращения дела", "Устное замечание");


    @Step("Скрытие(раскрытие) блока \"Обжалование\".")
    public void titleClick(){
        title.click();
    }

    @Step("Заполнение поля \"Причина\" значением {0}.")
    public void reasonInput(String data){
        reason.clear();
        typeAndClick(reason,data);
    }

    @Step("Заполнение поля \"Дата прекращения\" значением {0}.")
    public void stopDateInput(String data){
        stopDate.clear();
        stopDate.sendKeys(data);
    }

    @Step("Заполнение поля \"Дата прекращения\" значением системной даты.")
    public void stopDateSetSystem(){
        stopDate.clear();
        SimpleDateFormat sysDate = new SimpleDateFormat("dd.MM.yyyy");
        String date=sysDate.format(new java.util.Date());
        stopDate.sendKeys(date);
    }

    @Step("Нажатие чекбокса \"Возложена обязанность прохождения диагностики...\".")
    public void dutyCheckboxClick(){
        dutyCheckbox.click();
    }

    @Step("Нажатие чекбокса \"Устное замечание\".")
    public void verbalRemarkCheckboxClick(){
        verbalRemarkCheckbox.click();
    }

}
