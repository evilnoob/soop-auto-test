package objects.eal.admcase.all.offender.juridical;

import elements.Button;
import elements.ElementsGrid;
import elements.InputField;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class JuridicalOffender extends Page{

    public JuridicalOffender(WebDriver driver) {
        super(driver);
    }

    public WebElement ownershipType = InputField.inputFieldFromWindow(driver, "Выбрать юридическое лицо", "Форма собственности");
    public WebElement name = InputField.inputFieldFromWindow(driver, "Выбрать юридическое лицо", "Название");
    public WebElement INN = InputField.inputFieldFromWindow(driver, "Выбрать юридическое лицо", "ИНН");
    public WebElement OGRN = InputField.inputFieldFromWindow(driver, "Выбрать юридическое лицо", "ОГРН");
    public WebElement saveButton = Button.buttonFromWindow(driver, "Выбрать юридическое лицо", "Сохранить");
    public WebElement cancelButton = Button.buttonFromWindow(driver, "Выбрать юридическое лицо", "Отмена");

    @Step("Заполнение поля \"Форма собственности\" значением {0}.")
    public void ownershipTypeInput(String data){
        typeAndClick(ownershipType,data);
    }

    @Step("Заполнение поля \"Название\" значением {0}.")
    public void nameInput(String data){
        name.sendKeys(data);
    }

    @Step("Заполнение поля \"ИНН\" значением {0}.")
    public void INNInput(String data){
        INN.sendKeys(data);
    }

    @Step("Заполнение поля \"ОГРН\" значением {0}.")
    public void OGRNInput(String data){
        OGRN.sendKeys(data);
    }

    @Step("Нажатие кнопки \"Сохранить\"")
    public void saveButtonClick(){
        saveButton.click();
    }

    @Step("Нажатие кнопки \"Отмена\".")
    public void cancelButtonClick(){
        cancelButton.click();
    }

    @Step("Выбор нарушителя.")
    public void chooseAndClick() throws InterruptedException {
        INN.click();
        Thread.sleep(1000);
        //explicitWaitElement(driver,ElementsGrid.elementSearchGridFromWindow(driver, "Выбрать нарушителя"));
        List<WebElement> offenderList = ElementsGrid.elementsSearchGridFromWindow(driver, "Выбрать юридическое лицо");
        doubleClick(driver, offenderList.get(0));
    }
}
