package objects.eal.admcase.protocol;

import elements.BoundList;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class ProtocolCreate extends Page {

    public ProtocolCreate(WebDriver driver) {
        super(driver);
    }

    public WebElement protocolType = BoundList.inputField(driver, "Вид протокола");
    public WebElement protocolTypeTrigger = BoundList.inputFieldTrigger(driver, "Вид протокола");

    @Step("Выбор вида протокола {0}.")
    public void protocolTypeInput(String data) throws InterruptedException {
        protocolTypeTrigger.click();
        clickAndPick(protocolTypeTrigger,data);
    }

    @Step("Удостовериться что тип протокола правильный - {0}.")
    public void checkType(String data){
        Assert.assertEquals(protocolType.getAttribute("value"),data);
    }

}
