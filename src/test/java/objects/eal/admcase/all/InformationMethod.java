package objects.eal.admcase.all;

import elements.RadioButton;
import elements.Title;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class InformationMethod extends Page{

    public InformationMethod(WebDriver driver) {
        super(driver);
    }

    public WebElement title = Title.title(driver, "Способ поступления информации о правонарушении");
    public WebElement radio1 = RadioButton.radioButtonFromGradientBlock(driver, "Способ поступления информации о правонарушении", "Непосредственное обнаружение должностными лицами, уполномоченными составлять протоколы");
    public WebElement radio2 = RadioButton.radioButtonFromGradientBlock(driver, "Способ поступления информации о правонарушении", "Сообщения и заявления физических и юридических лиц, а также сообщения в средствах массовой информации");
    public WebElement radio3 = RadioButton.radioButtonFromGradientBlock(driver, "Способ поступления информации о правонарушении", "Материалы, поступившие из правоохранительных органов, а также из других государственных органов, органов местного самоуправления, от общественных объединений");


    @Step("Способ поступления информации о правонарушении.")
    public void titleClick(){
        title.click();
    }

    @Step("Нажатие первой радио-кнопки в блоке \"Способ поступления информации о правонарушении\".")
    public void radio1Click(){
        //scrollIntoElement(radio1);
        radio1.click();
        //chromeClick(driver,radio1);
    }

    @Step("Нажатие второй радио-кнопки в блоке \"Способ поступления информации о правонарушении\".")
    public void radio2Click(){
        //scrollIntoElement(radio2);
        radio2.click();
    }

    @Step("Нажатие третьей радио-кнопки в блоке \"Способ поступления информации о правонарушении\".")
    public void radio3Click(){
        //scrollIntoElement(radio3);
        radio3.click();
    }
}
