package objects.eal.admcase.all.offender.physical;

import elements.BoundList;
import elements.Button;
import elements.CheckBox;
import elements.InputField;
import objects.Page;
import objects.eal.admcase.all.offender.*;
import utils.TestEngine;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.lang.reflect.InvocationTargetException;

public class PhysicalOffenderDetail extends Page {

    public PhysicalOffenderDetail(WebDriver driver) {
        super(driver);
    }

    public WebElement surname = InputField.inputFieldFromExtComp(driver, "Нарушитель", "Фамилия");
    public WebElement name = InputField.inputFieldFromExtComp(driver, "Нарушитель", "Имя");
    public WebElement patronymic = InputField.inputFieldFromExtComp(driver, "Нарушитель", "Отчество");
    public WebElement birthDate = InputField.inputFieldFromExtComp(driver, "Нарушитель", "Дата рождения");
    public WebElement birthPlace = InputField.inputFieldFromExtComp(driver, "Нарушитель", "Место рождения");
    public WebElement citizenship = InputField.inputFieldFromExtComp(driver, "Нарушитель", "Гражданство");
    public WebElement arrivalPurpose;
    public WebElement arrivalStatus;

    @Step("Заполнение поля \"Цель приезда\" значением {0} в случае его наличия.")
    public void arrivalPurposeInput(String data) {
        if (!citizenship.getAttribute("value").equals("Россия")) {
            arrivalPurpose = BoundList.inputFieldFromExtComp(driver, "Нарушитель", "Цель приезда");
            typeAndClick(arrivalPurpose, data);
        }
    }

    @Step("Заполнение поля \"Статус приехавшего\" значением {0} в случае его наличия.")
    public void arrivalStatusInput(String data) {
        if (!citizenship.getAttribute("value").equals("Россия")) {
            arrivalStatus = BoundList.inputFieldFromExtComp(driver, "Нарушитель", "Статус приехавшего");
            typeAndClick(arrivalStatus, data);
        }
    }

    public WebElement noDocumentsCheckbox = CheckBox.checkBoxFromExtComp(driver, "Нарушитель", "Документ отсутствует");
    public WebElement documents = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Документ, удостоверяющий личность");
    public WebElement addDocumentButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "3");
    public WebElement phone = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Телефон");
    public WebElement addPhoneButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "4");
    public WebElement noRegistrationAddressCheckbox = CheckBox.checkBoxFromExtComp(driver, "Нарушитель", "Адрес прописки отсутствует");
    public WebElement registrationAddress = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Адрес прописки");
    public WebElement addRegistrationAddressButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "5");
    public WebElement addressCopyButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "6");
    public WebElement noLivingAddressCheckbox = CheckBox.checkBoxFromExtComp(driver, "Нарушитель", "Лицо без определенного места жительства");
    public WebElement livingAddress = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Фактический адрес проживания");
    public WebElement addLivingAddressButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "7");
    public WebElement workPlace = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Место работы");
    public WebElement addWorkPlaceButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "8");
    public WebElement studyPlace = BoundList.inputFieldTriggerFromExtComp(driver, "Нарушитель", "Место учебы");
    public WebElement addStudyPlaceButton = Button.numberedButtonFromExtComp(driver, "Нарушитель", "9");

    @Step("Снятие/проставка чекбокса \"Документ отсутствует\".")
    public void noDocumentsCheckboxUse(String data) throws InterruptedException {
        if (CheckBox.checkBoxBodyFromInput(driver,noDocumentsCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Снять"))
            noDocumentsCheckbox.click();
        if (!CheckBox.checkBoxBodyFromInput(driver,noDocumentsCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Поставить"))
            noDocumentsCheckbox.click();
    }

    @Step("Выбор значения {0} из поля \"Существующие документы\".")
    public void documentPick(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        try {
            clickAndPick(documents, data);
        }   catch (NoSuchElementException e){
            addDocumentButton.click();
            System.out.println(data);
            TestEngine.executeTestFromData(driver, OffenderDocumentAdd.class, "data\\OffenderDetail.xlsx", "OffenderDocumentAdd", data);
        }

    }

    @Step("Выбор значения {0} из поля \"Телефон\".")
    public void phonePick(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        try {
            clickAndPick(phone, data);
        }   catch (NoSuchElementException e){
            addPhoneButton.click();
            TestEngine.executeTestFromData(driver, OffenderPhoneAdd.class, "data\\OffenderDetail.xlsx", "OffenderPhoneAdd", data);
        }
    }

    @Step("Снятие/проставка чекбокса \"Адрес прописки отсутствует\".")
    public void noRegistrationAddressCheckboxUse(String data) throws InterruptedException {
        if (CheckBox.checkBoxBodyFromInput(driver,noRegistrationAddressCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Снять"))
            noRegistrationAddressCheckbox.click();
        if (!CheckBox.checkBoxBodyFromInput(driver,noRegistrationAddressCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Поставить"))
            noRegistrationAddressCheckbox.click();
    }

    @Step("Выбор значения {0} из поля \"Адрес прописки\".")
    public void registrationAddressPick(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        try {
            clickAndPick(registrationAddress, data);
        }   catch (NoSuchElementException e){
            addRegistrationAddressButton.click();
            TestEngine.executeTestFromData(driver, OffenderRegistrationAddressAdd.class, "data\\OffenderDetail.xlsx", "OffenderRegistrationAddressAdd", data);
        }
    }

    @Step("Нажатие кнопки \"Копировать адрес\".")
    public void addressCopyButtonClick() throws InterruptedException {
        Thread.sleep(100);
        addressCopyButton.click();
    }

    @Step("Снятие/проставка чекбокса \"Лицо без определенного места жительства\".")
    public void noLivingAddressCheckboxUse(String data) throws InterruptedException {
        if (CheckBox.checkBoxBodyFromInput(driver,noLivingAddressCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Снять"))
            noLivingAddressCheckbox.click();
        if (!CheckBox.checkBoxBodyFromInput(driver,noLivingAddressCheckbox.getAttribute("id")).getAttribute("class").contains("x-form-cb-checked") && data.equals("Поставить"))
            noLivingAddressCheckbox.click();
    }

    @Step("Выбор значения {0} из поля \"Фактический адрес проживания\".")
    public void livingAddressPick(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        try {
            clickAndPick(livingAddress, data);
        }   catch (NoSuchElementException e){
            addLivingAddressButton.click();
            TestEngine.executeTestFromData(driver, OffenderLivingAddressAdd.class, "data\\OffenderDetail.xlsx", "OffenderLivingAddressAdd", data);
        }
    }

    @Step("Выбор значения {0} из поля \"Место работы\".")
    public void workPlacePick(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        try {
            clickAndPick(workPlace, data);
        }   catch (NoSuchElementException e){
            addWorkPlaceButton.click();
            TestEngine.executeTestFromData(driver, OffenderWorkPlaceAdd.class, "data\\OffenderDetail.xlsx", "OffenderWorkPlaceAdd", data);
        }
    }

    @Step("Выбор значения {0} из поля \"Место учебы\".")
    public void studyPlacePick(String data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        try {
            clickAndPick(studyPlace, data);
        }   catch (NoSuchElementException e){
            addStudyPlaceButton.click();
            TestEngine.executeTestFromData(driver, OffenderStudyPlaceAdd.class, "data\\OffenderDetail.xlsx", "OffenderStudyPlaceAdd", data);
        }
    }
}
