package objects.eal.admcase.resolution;

import elements.BoundList;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class ResolutionCreate extends Page {

    public ResolutionCreate(WebDriver driver) {
        super(driver);
    }

    public WebElement resolutionType = BoundList.inputField(driver, "Вид постановления");
    public WebElement resolutionTypeTrigger = BoundList.inputFieldTrigger(driver, "Вид постановления");

    @Step("Выбор вида постановления {0}.")
    public void resolutionTypeInput(String data) throws InterruptedException {
        resolutionTypeTrigger.click();
        clickAndPick(resolutionTypeTrigger,data);
    }

    @Step("Удостовериться что тип протокола правильный - {0}.")
    public void checkType(String data){
        Assert.assertEquals(resolutionType.getAttribute("value"),data);
    }

}
