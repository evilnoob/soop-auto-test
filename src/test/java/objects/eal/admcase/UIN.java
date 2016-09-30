package objects.eal.admcase;

import elements.Button;
import elements.InputField;
import elements.Label;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class UIN extends Page {

    public UIN(WebDriver driver) {
        super(driver);
    }

    public WebElement generateButton = Button.buttonFromWindow(driver, "УИН", "Сгенерировать");
    public WebElement saveButton = Button.buttonFromWindow(driver, "УИН", "Сохранить");
    public WebElement cancelButton = Button.buttonFromWindow(driver, "УИН", "Отменить");
    public WebElement UINForTypeElement = Label.labelFromWindowFromTextfield(driver, "УИН");
    //public WebElement UINInput = InputField.inputFieldFromWindow(driver, "УИН", UINForTypeElement.getText());

    public void checkUINForType (String data){
        //System.out.println(UINForTypeElement.getAttribute("id"));
        //System.out.println(UINForTypeElement.getText());
        Assert.assertEquals(data,UINForTypeElement.getText());
    }

    @Step("Нажатие кнопки \"Завершить работу с делом\".")
    public void generateButtonClick(){
        generateButton.click();
    }

    @Step("Нажатие кнопки \"Завершить работу с делом\".")
    public void cancelButtonClick(){
        cancelButton.click();
    }

    @Step("Нажатие кнопки \"Завершить работу с делом\".")
    public void saveButtonClick(){
        saveButton.click();
    }

}
