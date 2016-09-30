package objects.eal.admcase.resolution.assignment.punishment;

import elements.Button;
import elements.RadioButton;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;


public class FineUIN extends Page {

    public FineUIN(WebDriver driver) {
        super(driver);
    }

    public WebElement radio1 = RadioButton.radioButtonFromWindow(driver, "УИН", "Бланк постановления изготовлен типографским способом");
    public WebElement radio2 = RadioButton.radioButtonFromWindow(driver, "УИН", "Постановление оформлено с использованием аппаратно-программного комплекса (Сервиса обеспечения охраны общественного порядка)");
    public WebElement radio3 = RadioButton.radioButtonFromWindow(driver, "УИН", "Постановление оформлено сотрудниками самостоятельно (вручную или с помощью печатающего устройства)");
    public WebElement radio4 = RadioButton.radioButtonFromWindow(driver, "УИН", "Дело об административном правонарушении (влекущее наложение административного штрафа), рассмотрение которого находится в компетенции суда");
    public WebElement generateButton = Button.buttonFromWindow(driver, "УИН", "Сгенерировать");
    public WebElement saveButton = Button.buttonFromWindow(driver, "УИН", "Сохранить");
    public WebElement cancelButton = Button.buttonFromWindow(driver, "УИН", "Отменить");

    @Step("Нажатие первой радио-кнопки в окне \"УИН\".")
    public void radio1Click(){
        radio1.click();
    }

    @Step("Нажатие второй радио-кнопки в окне \"УИН\".")
    public void radio2Click(){
        radio2.click();
    }

    @Step("Нажатие третьей радио-кнопки в окне \"УИН\".")
    public void radio3Click(){
        radio3.click();
    }

    @Step("Нажатие четвертой радио-кнопки в окне \"УИН\".")
    public void radio4Click(){
        radio4.click();
    }

    @Step("Нажатие кнопки \"Сгенерировать\".")
    public void generateButtonClick(){
        generateButton.click();
    }

    @Step("Нажатие кнопки \"Сохранить\".")
    public void saveButtonClick() throws InterruptedException {
        Thread.sleep(500);
        saveButton.click();
        Thread.sleep(500);
    }

    @Step("Нажатие кнопки \"Отмена\".")
    public void cancelButtonClick(){
        cancelButton.click();
    }

}
