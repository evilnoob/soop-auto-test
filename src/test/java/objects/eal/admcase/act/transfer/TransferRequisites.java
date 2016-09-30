package objects.eal.admcase.act.transfer;

import elements.BoundList;
import elements.Date;
import elements.Title;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.SimpleDateFormat;

public class TransferRequisites extends Page{

    public TransferRequisites(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Реквизиты определения");
    public WebElement issueDate = Date.inputFieldFromGradientBlock(driver, "Реквизиты определения", "Дата вынесения");
    public WebElement reciever = BoundList.inputFieldFromGradientBlock(driver, "Реквизиты определения", "Куда направлено");
    public WebElement recieverTrigger = BoundList.inputFieldTriggerFromGradientBlock(driver, "Реквизиты определения", "Куда направлено");



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

    @Step("Заполнение поля \"Куда направлено\" значением {0}.")
    public void recieverInput(String data) throws InterruptedException {
        //typeAndClick(reciever, data);
        clickAndPick(recieverTrigger,data);
    }

    @Step("Заполнение поля \"Тер. орган\" значением {0}.")
    public void departmentInput(String data) throws InterruptedException {
        if (reciever.getAttribute("value").equals("МВД")){
            Thread.sleep(1300);
            WebElement department = BoundList.inputFieldFromGradientBlock(driver, "Реквизиты определения", "Территориальная принадлежность органа");
            typeAndClick(department, data);
        }
    }
}
