package objects.eal.admcase.act.retrieve;

import elements.Date;
import elements.Title;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.SimpleDateFormat;

public class ReturnRequisites extends Page{

    public ReturnRequisites(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Реквизиты определения");
    public WebElement issueDate = Date.inputFieldFromGradientBlock(driver, "Реквизиты определения", "Дата вынесения");


    @Step("Скрытие(раскрытие) блока \"Реквизиты определения\".")
    public void titleClick(){
        title.click();
    }

    @Step("Заполнение поля \"Дата вынесения\" значением {0}.")
    public void issueDateInput(String data){
        issueDate.clear();
        issueDate.sendKeys(data);
    }

    @Step("Заполнение поля \"Дата вынесения\" значением системной даты.")
    public void issueDateSetSystem(){
        issueDate.clear();
        SimpleDateFormat sysDate = new SimpleDateFormat("dd.MM.yyyy");
        String date=sysDate.format(new java.util.Date());
        issueDate.sendKeys(date);
    }

}
