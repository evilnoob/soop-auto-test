package objects.eal.admcase.all.offender.juridical;

import elements.BoundList;
import elements.Button;
import elements.InputField;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class JuridicalOffenderDetail extends Page {

    public JuridicalOffenderDetail(WebDriver driver) {
        super(driver);
    }

    public WebElement ownershipType = InputField.inputFieldFromExtComp(driver, "Нарушитель", "Форма собственности");
    public WebElement name = InputField.inputFieldFromExtComp(driver, "Нарушитель", "Название");
    public WebElement patronymic = InputField.inputFieldFromExtComp(driver, "Нарушитель", "ИНН");
    public WebElement birthDate = InputField.inputFieldFromExtComp(driver, "Нарушитель", "ОГРН");

    public WebElement juridicalAddress = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Юридический адрес");
    public WebElement addJuridicalAddressButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "1");
    public WebElement actualAddress = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Фактический адрес");
    public WebElement addActualAddressButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "2");
    public WebElement phone = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Телефон");
    public WebElement addPhoneButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "3");
    public WebElement representative= BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Представитель");
    public WebElement addRepresentativeButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "4");


    @Step("Выбор значения {0} из поля \"Юридический адрес\".")
    public void juridicalAddressPick(String data) throws InterruptedException {
        clickAndPick(juridicalAddress,data);
    }

    @Step("Выбор значения {0} из поля \"Адрес прописки\".")
    public void actualAddressPick(String data) throws InterruptedException {
        clickAndPick(actualAddress,data);
    }

    @Step("Выбор значения {0} из поля \"Телефон\".")
    public void phonePick(String data) throws InterruptedException {
        clickAndPick(phone, data);
    }

    @Step("Выбор значения {0} из поля \"Представитель\".")
    public void representativePick(String data) throws InterruptedException {
        clickAndPick(representative, data);
    }

}
