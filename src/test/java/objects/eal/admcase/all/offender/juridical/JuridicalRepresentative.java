package objects.eal.admcase.all.offender.juridical;

import elements.BoundList;
import elements.Button;
import elements.CheckBox;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class JuridicalRepresentative extends Page {

    public JuridicalRepresentative(WebDriver driver) {
        super(driver);
    }

    public WebElement noDocumentsCheckbox = CheckBox.checkBoxFromExtComp(driver, "Нарушитель", "Документ отсутствует");
    public WebElement documents = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Документ, удостоверяющий личность");
    public WebElement addDocumentButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "5");
    public WebElement noRegistrationAddressCheckbox = CheckBox.checkBoxFromExtComp(driver, "Нарушитель", "Адрес прописки отсутствует");
    public WebElement registrationAddress = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Адрес прописки");
    public WebElement addRegistrationAddresButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "6");
    public WebElement addressCopyButton = Button.buttonFromExtComp(driver, "Нарушитель", "Копировать");
    public WebElement noLivingAddressCheckbox = CheckBox.checkBoxFromExtComp(driver, "Нарушитель", "Лицо без определенного места жительства");
    public WebElement livingAddress = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Фактический адрес проживания");
    public WebElement addLivingAddressButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "8");
    public WebElement arrivalPurpose;
    public WebElement arrivalStatus;

    @Step("Заполнение поля \"Цель приезда\" значением {0} в случае его наличия.")
    public void arrivalPurposeInput(String data) throws InterruptedException {
        //Thread.sleep(1000);
        if (BoundList.inputFieldFromExtComp(driver, "Нарушитель", "Цель приезда").isEnabled()) {
            arrivalPurpose = BoundList.inputFieldFromExtComp(driver, "Нарушитель", "Цель приезда");
            typeAndClick(arrivalPurpose, data);
        }
    }

    @Step("Заполнение поля \"Статус приехавшего\" значением {0} в случае его наличия.")
    public void arrivalStatusInput(String data) {
        if (BoundList.inputFieldFromExtComp(driver, "Нарушитель", "Цель приезда").isEnabled()) {
            arrivalStatus = BoundList.inputFieldFromExtComp(driver, "Нарушитель", "Статус приехавшего");
            typeAndClick(arrivalStatus, data);
        }
    }

    @Step("Снятие/проставка чекбокса \"Документ отсутствует\".")
    public void noDocumentsCheckboxUse(String data) throws InterruptedException {
        if (CheckBox.checkBoxBodyFromInput(driver,noDocumentsCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Снять"))
            noDocumentsCheckbox.click();
        if (!CheckBox.checkBoxBodyFromInput(driver,noDocumentsCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Поставить"))
            noDocumentsCheckbox.click();
    }

    @Step("Выбор значения {0} из поля \"Существующие документы\".")
    public void documentPick(String data) throws InterruptedException {
        clickAndPick(documents,data);
    }

    @Step("Нажатие кнопки \"Добавить документ\".")
    public void addDocumentButtonInvoke() {
        addDocumentButton.click();
    }

    @Step("Снятие/проставка чекбокса \"Адрес прописки отсутствует\".")
    public void noRegistrationAddressCheckboxUse(String data) throws InterruptedException {
        if (CheckBox.checkBoxBodyFromInput(driver,noRegistrationAddressCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Снять"))
            noRegistrationAddressCheckbox.click();
        if (!CheckBox.checkBoxBodyFromInput(driver,noRegistrationAddressCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Поставить"))
            noRegistrationAddressCheckbox.click();
    }

    @Step("Выбор значения {0} из поля \"Адрес прописки\".")
    public void registrationAddressPick(String data) throws InterruptedException {
        clickAndPick(registrationAddress,data);
    }

    @Step("Нажатие кнопки \"Добавить адрес прописки\".")
    public void addRegistrationAddressButtonInvoke() {
        addRegistrationAddresButton.click();
    }

    @Step("Нажатие кнопки \"Копировать адрес\".")
    public void addressCopyButtonClick() {
        addressCopyButton.click();
    }

    @Step("Снятие/проставка чекбокса \"Лицо без определенного места жительства\".")
    public void noActualAddressCheckboxUse(String data) throws InterruptedException {
        if (CheckBox.checkBoxBodyFromInput(driver,noLivingAddressCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Снять"))
            noLivingAddressCheckbox.click();
        if (!CheckBox.checkBoxBodyFromInput(driver,noLivingAddressCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Поставить"))
            noLivingAddressCheckbox.click();
    }

    @Step("Выбор значения {0} из поля \"Фактический адрес проживания\".")
    public void livingAddressPick(String data) throws InterruptedException {
        clickAndPick(livingAddress,data);
    }

    @Step("Нажатие кнопки \"Добавить фактический адрес проживания\".")
    public void addLivingAddressButtonInvoke() {
        addLivingAddressButton.click();
    }

}
