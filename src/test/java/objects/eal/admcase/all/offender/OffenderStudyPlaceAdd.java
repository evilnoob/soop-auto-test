package objects.eal.admcase.all.offender;

import elements.*;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class OffenderStudyPlaceAdd extends Page {

    public OffenderStudyPlaceAdd(WebDriver driver) {
        super(driver);
    }

    public class OffenderWorkPlaceAdd extends Page {

        public OffenderWorkPlaceAdd(WebDriver driver) {
            super(driver);
        }


        public WebElement name = InputField.inputFieldFromWindow(driver, "Добавить место работы", "Название");
        public WebElement address = AddressField.inputFieldFromWindow(driver, "Добавить место работы", "Адрес");
        public WebElement flat = InputField.inputFieldFromWindow(driver, "Добавить место работы", "Кв.");
        public WebElement phone = InputField.inputFieldFromWindow(driver, "Добавить место работы", "Телефон");
        public WebElement graduationYear = InputField.inputFieldFromWindow(driver, "Добавить место работы", "Год окончания");
        public WebElement saveButton = Button.buttonFromWindow(driver, "Добавить место работы", "Сохранить");
        public WebElement cancelButton = Button.buttonFromWindow(driver, "Добавить место работы", "Отменить");

        @Step("Заполнение поля \"Название\" значением {0}.")
        public void setName(String data){
            name.sendKeys(data);
        }

        @Step("Заполнение поля \"Адрес\" значением {0}.")
        public void setAddress(String data) throws InterruptedException {
            typeAddress(address,data);
        }

        @Step("Заполнение поля \"Кв\" значением {0}.")
        public void setFlat(String data){
            flat.sendKeys(data);
        }

        @Step("Заполнение поля \"Телефон\" значением {0}.")
        public void setPhone(String data){
            phone.sendKeys(data);
        }

        @Step("Заполнение поля \"Должность\" значением {0}.")
        public void setGraduationYear(String data){
            graduationYear.sendKeys(data);
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
}
