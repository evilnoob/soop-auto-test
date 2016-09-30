package objects.eal.admcase.all.offender;

import elements.AddressField;
import elements.Button;
import elements.InputField;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class OffenderLivingAddressAdd extends Page {

    public OffenderLivingAddressAdd(WebDriver driver) {
        super(driver);
    }

    public WebElement address = AddressField.inputFieldFromWindow(driver, "Добавить адрес проживания", "Адрес");
    public WebElement flat = InputField.inputFieldFromWindow(driver, "Добавить адрес проживания", "Кв.");
    public WebElement saveButton = Button.buttonFromWindow(driver, "Добавить адрес проживания", "Сохранить");
    public WebElement cancelButton = Button.buttonFromWindow(driver, "Добавить адрес проживания", "Отменить");

    @Step("Заполнение поля \"Адрес\" значением {0}.")
    public void addressInput(String data) throws InterruptedException {
        typeAddress(address,data);
    }

    @Step("Заполнение поля \"Квартира\" значением {0}.")
    public void flatInput(String data) {
        flat.sendKeys(data);
    }

    @Step("Нажатие кнопки \"Сохранить\".")
    public void saveButtonClick() {
        saveButton.click();
    }

    @Step("Нажатие кнопки \"Отменить\".")
    public void cancelButtonClick() {
        cancelButton.click();
    }

}
