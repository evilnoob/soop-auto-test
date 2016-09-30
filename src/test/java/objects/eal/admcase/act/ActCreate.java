package objects.eal.admcase.act;

import elements.BoundList;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class ActCreate extends Page {

    public ActCreate(WebDriver driver) {
        super(driver);
    }

    public WebElement actType = BoundList.inputField(driver, "Вид определения");
    public WebElement actTypeTrigger = BoundList.inputFieldTrigger(driver, "Вид определения");

    @Step("Выбор вида определения {0}.")
    public void actTypeInput(String data) throws InterruptedException {
        //doubleClick(actTypeTrigger);
        actType.click();
        actTypeTrigger.click();
        //clickAndPickNoScroll(actTypeTrigger, data);
        clickAndPickNoScroll(actTypeTrigger, data);
    }

    @Step("Удостовериться что тип протокола правильный - {0}.")
    public void checkType(String data){
        Assert.assertEquals(actType.getAttribute("value"),data);
    }
}
