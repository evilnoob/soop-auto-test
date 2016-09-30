package objects.eal.admcase.act.investigation;

import elements.*;
import objects.eal.admcase.all.offence.Offence;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class InvestigationOffence extends Offence {

    public InvestigationOffence(WebDriver driver) {
        super(driver);
    }

    public WebElement fabula = TextArea.textAreaFromGradientBlock(driver, "Нарушение", "Фабула");

    @Step("Заполнение поля \"Фабула\" значением {0}.")
    public void fabulaInput(String data){
        fabula.sendKeys(data);
    }
}
