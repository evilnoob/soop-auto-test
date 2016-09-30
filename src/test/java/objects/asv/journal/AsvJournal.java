package objects.asv.journal;

import elements.Button;
import elements.CheckBox;
import elements.ElementsGrid;
import elements.RadioButton;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class AsvJournal extends Page {

    public AsvJournal(WebDriver driver) {
        super(driver);
    }

    //public List<WebElement> caseList = ElementsGrid.elementsSearchGridFromJournal(driver, "Журнал административного производства");
    public List<WebElement> caseList;
    public WebElement physicalRadio = RadioButton.radioButtonFromContainer(driver, "Тип нарушителя", "Физ. лицо");
    public WebElement juridicalRadio = RadioButton.radioButtonFromContainer(driver, "Тип нарушителя", "Юр. лицо");
    public WebElement currentCheckbox = CheckBox.checkBoxFromBlock(driver, "Редактировать", "Свой тер. орган");
    public WebElement subordinateCheckbox = CheckBox.checkBoxFromBlock(driver, "Редактировать", "Нижестоящие тер. органы");

    public WebElement editButton = Button.button(driver, "Редактировать");
    public WebElement downloadButton = Button.button(driver, "Выгрузить");
    public WebElement journalCloseButton = Button.button(driver, "Завершить работу с журналом");
    public WebElement columnsVisibilityButton = Button.buttonWithDataQtip(driver, "Видимость столбцов");

    @Step("Нажатие радиобаттона \"Физ. лицо\".")
    public void physicalRadioClick() throws InterruptedException {
        physicalRadio.click();
    }

    @Step("Нажатие радиобаттона \"Юр. лицо\".")
    public void juridicalRadioClick() throws InterruptedException {
        juridicalRadio.click();
    }

    @Step("Нажатие чекбокса \"Свой тер. орган\".")
    public void currentCheckboxClick() throws InterruptedException {
        currentCheckbox.click();
    }

    @Step("Нажатие чекбокса \"Нижестоящие тер. органы\".")
    public void subordinateCheckboxClick() throws InterruptedException {
        subordinateCheckbox.click();
    }

    @Step("Нажатие кнопки \"Редактировать\".")
    public void editButtonClick(){
        editButton.click();
    }

    @Step("Нажатие кнопки \"Выгрузить\".")
    public void downloadButtonClick(){
        downloadButton.click();
    }

    @Step("Нажатие кнопки \"Завершить работу с журналом\".")
    public void journalCloseButtonClick(){
        journalCloseButton.click();
    }

    public void selectIfPresent(){
        caseList = ElementsGrid.elementsSearchGridFromJournal(driver, "Журнал административного производства");
        //System.out.println(caseList.toString());
        //System.out.println(caseList.get(0).toString());
        //System.out.println(caseList.get(0).getText());
        //System.out.println("id "+caseList.get(0).getAttribute("id"));
        //System.out.println("value "+caseList.get(0).getAttribute("value"));
        if (!caseList.isEmpty()){
            System.out.println(caseList.get(0).getAttribute("id"));
            caseList.get(0).click();
        }
    }

    @Step("Нажатие кнопки \"Видимость столбцов\".")
    public void columnsVisibilityClick(){
        columnsVisibilityButton.click();
    }
}
