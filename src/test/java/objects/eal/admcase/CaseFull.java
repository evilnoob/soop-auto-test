package objects.eal.admcase;

import elements.Button;
import elements.DisplayField;
import elements.ElementsGrid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class CaseFull extends CaseCreate {

    public CaseFull(WebDriver driver) {
        super(driver);
    }

    public WebElement UINText = DisplayField.displayField(driver,"УИН:");
    public String UINTextValue;
   // public List<WebElement> protocolsList = ElementsGrid.elementsSearchGridFromCase(driver, "Вид протокола");
    //public List<WebElement> resolutionsList = ElementsGrid.elementsSearchGridFromCase(driver, "Вид постановления");
   // public List<WebElement> actsList = ElementsGrid.elementsSearchGridFromCase(driver, "Вид определения");


    //public WebElement uinButton = Button.button(driver,"Отправить в ИБД-Р");


    @Step("Открыть постановление со статусом {0} для редактирования по сценарию.")
    public void resolutionOpenInvoke(String data){
        List<WebElement> resolutionsList = ElementsGrid.elementsSearchGridFromCase(driver, "Вид постановления");
        for (WebElement l: resolutionsList) {
            if (l.getText().contains(data)) {
                l.click();
                resolutionEditButtonClick();
                break;
            }
        }
    }

    @Step("Открыть протокол с типом {0} для редактирования по сценарию.")
    public void protocolOpenInvoke(String data){
        List<WebElement> protocolsList = ElementsGrid.elementsSearchGridFromCase(driver, "Вид протокола");
        for (WebElement l: protocolsList) {
            //System.out.println(l.getText());
            if (l.getText().contains(data)) {
                l.click();
                protocolEditButtonClick();
                break;
            }
        }
    }

    @Step("Кнопка \"УИН\" доступна (проверка).")
    public void assertUINButtonEnabled(){
        WebElement UINButton = Button.button(driver,"УИН");
        Assert.assertFalse(UINButton.getAttribute("class").contains("x-btn-disabled"));
    }

    @Step("Кнопка \"УИН\" заблокирована (проверка).")
    public void assertUINButtonDisabled(){
        WebElement UINButton = Button.button(driver,"УИН");
        Assert.assertTrue(UINButton.getAttribute("class").contains("x-btn-disabled"));
    }

    @Step("Нажатие кнопки \"УИН\".")
    public void UINButtonClick(){
        WebElement UINButton = Button.button(driver,"УИН");
        UINButton.click();
    }

    @Step("УИН пустой (проверка).")
    public void assertUINTextNull(){
        Assert.assertEquals(UINTextValue=UINText.getText(),"");
    }

    @Step("УИН не пустой (проверка).")
    public void assertUINTextNotNull(){
        Assert.assertNotEquals(UINTextValue=UINText.getText(),"");
    }


    @Step("Нажатие кнопки \"Принять в работу\".")
    public void acceptCaseClick(){
        WebElement acceptCase = Button.button(driver,"Принять в работу");
        acceptCase.click();
    }


}
