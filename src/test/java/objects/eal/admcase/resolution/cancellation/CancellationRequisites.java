package objects.eal.admcase.resolution.cancellation;

import elements.Date;
import elements.InputField;
import elements.Title;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CancellationRequisites extends Page{

    public CancellationRequisites(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Реквизиты");
    public WebElement seriesNumber = InputField.inputFieldFromGradientBlock(driver, "Реквизиты", "Серия/Номер");
    public WebElement issueDate = Date.inputFieldFromGradientBlock(driver, "Реквизиты", "Дата вынесения");
    public WebElement copyRecieveDate = Date.inputFieldFromGradientBlock(driver, "Реквизиты", "Дата вручения копии");
    public WebElement effectiveDate = Date.inputFieldFromGradientBlock(driver, "Реквизиты", "Дата вступления в силу");


    @Step("Скрытие(раскрытие) блока \"Реквизиты протокола\".")
    public void titleClick(){
        title.click();
    }

    @Step("Заполнение поля \"Серия/Номер\" значением {0}.")
    public void seriesNumberInput(String data){
        seriesNumber.clear();
        seriesNumber.sendKeys(resolutionNumber=data);
        issueDate.click();
    }

    @Step("Заполнение поля \"Серия/Номер\" случайным значением.")
    public void seriesNumberSetRandom(){
        seriesNumber.clear();
        seriesNumber.sendKeys(resolutionNumber=generateNumber());
    }

    @Step("Заполнение поля \"Дата вынесения\" значением {0}.")
    public void issueInput(String data){
        issueDate.clear();
        issueDate.sendKeys(data);
        seriesNumber.click();
    }

    @Step("Заполнение поля \"Дата вынесения\" значением системной даты.")
    public void issueDateSetSystem(){
        issueDate.clear();
        SimpleDateFormat sysDate = new SimpleDateFormat("dd.MM.yyyy");
        String date=sysDate.format(new java.util.Date());
        issueDate.sendKeys(date);
        seriesNumber.click();
    }

    @Step("Заполнение поля \"Дата вручения копии\" значением {0}.")
    public void copyRecieveInput(String data){
        copyRecieveDate.clear();
        copyRecieveDate.sendKeys(data);
    }

    @Step("Заполнение поля \"Дата вручениия копии\" значением системной даты.")
    public void copyRecieveDateSetSystem(){
        copyRecieveDate.clear();
        SimpleDateFormat sysDate = new SimpleDateFormat("dd.MM.yyyy");
        String date=sysDate.format(new java.util.Date());
        copyRecieveDate.sendKeys(date);
    }

    @Step("Заполнение поля \"Дата вступления в силу\" значением {0}.")
    public void effectiveDateInput(String data) throws InterruptedException {
       // effectiveDate = Date.inputFieldFromGradientBlock(driver, "Реквизиты", "Дата вступления в силу");
        //Thread.sleep(500);
        effectiveDate.clear();
        effectiveDate.sendKeys(data);
    }

    @Step("Заполнение поля \"Дата вступления в силу\" значением системной даты +10 дней.")
    public void effectiveDateSetSystemPlus10(){
        effectiveDate.clear();
        Calendar cal = Calendar.getInstance();
        java.util.Date date = new java.util.Date();
        cal.setTime(date);
        cal.add(Calendar.DATE, 11);
        date = cal.getTime();
        SimpleDateFormat sysDate = new SimpleDateFormat("dd.MM.yyyy");
        String dateString=sysDate.format(date);
        effectiveDate.sendKeys(dateString);
    }

}
