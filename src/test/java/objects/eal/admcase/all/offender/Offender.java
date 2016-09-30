package objects.eal.admcase.all.offender;

import elements.BoundList;
import elements.Title;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class Offender extends Page {

    public Offender(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Нарушитель");
    public WebElement offenderType = BoundList.inputFieldFromExtComp(driver, "Нарушитель", "Вид нарушителя");

    @Step("Скрытие(раскрытие) блока \"Нарушитель\".")
    public void titleClick(){
        title.click();
    }

    @Step("Выбор вида нарушителя {0}.")
    public void offenderTypeInput(String data) throws InterruptedException {
        clickAndPick(offenderType,data);
    }
}
