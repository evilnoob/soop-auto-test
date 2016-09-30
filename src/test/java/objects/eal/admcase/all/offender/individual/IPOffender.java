package objects.eal.admcase.all.offender.individual;

import elements.InputField;
import objects.eal.admcase.all.offender.physical.PhysicalOffender;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class IPOffender extends PhysicalOffender{

    public IPOffender(WebDriver driver) {
        super(driver);
    }

    public WebElement INN = InputField.inputFieldFromWindow(driver, "Выбрать нарушителя", "ИНН");

    @Step("Заполнение поля \"ИНН\" значением {0}.")
    public void INNInput(String data){
        INN.sendKeys(data);
        name.click();
    }
}
