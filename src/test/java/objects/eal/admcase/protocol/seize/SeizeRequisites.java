package objects.eal.admcase.protocol.seize;

import elements.AddressField;
import elements.Date;
import elements.InputField;
import elements.Title;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.text.SimpleDateFormat;

public class SeizeRequisites extends Page{

    public SeizeRequisites(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Реквизиты протокола");
    public WebElement issueDate = Date.inputFieldFromGradientBlock(driver, "Реквизиты протокола", "Дата составления");
    public WebElement createAddress = AddressField.inputFieldFromGradientBlock(driver, "Реквизиты протокола", "Место составления");
    public WebElement createFlat = InputField.inputFieldFromGradientBlock(driver, "Реквизиты протокола", "Кв.");

    @Step("Скрытие(раскрытие) блока \"Реквизиты протокола\".")
    public void titleClick(){
        title.click();
    }

    @Step("Заполнение поля \"Дата создания\" значением {0}.")
    public void issueDateInput(String data){
        issueDate.clear();
        issueDate.sendKeys(data);
    }

    @Step("Заполнение поля \"Дата создания\" значением системной даты.")
    public void issueDateSetSystem(){
        SimpleDateFormat sysDate = new SimpleDateFormat("dd.MM.yyyy");
        String date=sysDate.format(new java.util.Date());
        issueDate.sendKeys(date);
    }

    @Step("Заполнение поля \"Место составления\" значением {0}.")
    public void createAddressInput(String data) throws InterruptedException {
        typeAddress(createAddress, data);
    }

    @Step("Заполнение поля \"Кв.\" значением {0}.")
    public void createFlatInput(String data){
        createFlat.sendKeys(data);
    }

}
