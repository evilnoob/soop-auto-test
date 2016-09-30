package objects.eal.admcase.resolution.assignment;

import elements.BoundList;
import elements.Date;
import elements.Title;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import java.text.SimpleDateFormat;

public class AssignmentAppeal extends Page{

    public AssignmentAppeal(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Обжалование");
    public WebElement resolutionStatus = BoundList.inputFieldFromGradientBlock(driver, "Обжалование", "Статус постановления");
    public WebElement statusChangeDate = Date.inputFieldFromGradientBlock(driver, "Обжалование", "Дата изменения статуса");


    @Step("Скрытие(раскрытие) блока \"Обжалование\".")
    public void titleClick(){
        title.click();
    }

    @Step("Заполнение поля \"Статус постановления\" значением {0}.")
    public void resolutionStatusInput(String data) throws InterruptedException {
        resolutionStatus.clear();
        Thread.sleep(500);
        typeAndClick(resolutionStatus,data);
    }

    @Step("Заполнение поля \"Дата изменения статуса\" значением {0}.")
    public void statusChangeDateInput(String data){
        statusChangeDate.sendKeys(data);
    }

    @Step("Заполнение поля \"Дата изменения статуса\" значением системной даты.")
    public void statusChangeDateSetSystem(){
        SimpleDateFormat sysDate = new SimpleDateFormat("dd.MM.yyyy");
        String date=sysDate.format(new java.util.Date());
        statusChangeDate.sendKeys(date);
    }

}
