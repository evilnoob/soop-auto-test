package objects.eal.admcase;

import elements.Button;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class CaseCreate extends Page {

    public CaseCreate(WebDriver driver) {
        super(driver);
    }

    public WebElement closeButton = Button.button(driver, "Завершить работу с делом");
    public WebElement protocolCreateButton = Button.buttonFromSearchGrid(driver, "Добавить протокол");
    public WebElement protocolEditButton = Button.buttonFromSearchGrid(driver, "Редактировать протокол");
    public WebElement resolutionCreateButton = Button.buttonFromSearchGrid(driver, "Добавить постановление");
    public WebElement resolutionEditButton = Button.buttonFromSearchGrid(driver, "Редактировать постановление");
    public WebElement actCreateButton = Button.buttonFromSearchGrid(driver, "Добавить определение");
    public WebElement actEditButton = Button.buttonFromSearchGrid(driver, "Редактировать определение");


    @Step("Нажатие кнопки \"Завершить работу с делом\".")
    public void closeButtonClick(){
        scrollIntoElement(closeButton);
        closeButton.click();
    }

    @Step("Нажатие кнопки \"Добавить протокол\".")
    public void protocolCreateButtonClick(){
        protocolCreateButton = Button.buttonFromSearchGrid(driver, "Добавить протокол");
        scrollIntoElement(protocolCreateButton);
        protocolCreateButton.click();
    }

    @Step("Нажатие кнопки \"Редактировать протокол\".")
    public void protocolEditButtonClick(){
        protocolEditButton = Button.buttonFromSearchGrid(driver, "Редактировать протокол");
        scrollIntoElement(protocolEditButton);
        protocolEditButton.click();
    }

    @Step("Нажатие кнопки \"Добавить постановление\".")
    public void resolutionCreateButtonClick(){
        resolutionCreateButton = Button.buttonFromSearchGrid(driver, "Добавить постановление");
        scrollIntoElement(resolutionCreateButton);
        resolutionCreateButton.click();
    }

    @Step("Нажатие кнопки \"Редактировать постановление\".")
    public void resolutionEditButtonClick(){
        resolutionEditButton = Button.buttonFromSearchGrid(driver, "Редактировать постановление");
        scrollIntoElement(resolutionEditButton);
        resolutionEditButton.click();
    }

    @Step("Нажатие кнопки \"Добавить определение\".")
    public void actCreateButtonClick(){
        actCreateButton = Button.buttonFromSearchGrid(driver, "Добавить определение");
        scrollIntoElement(actCreateButton);
        actCreateButton.click();
    }

    @Step("Нажатие кнопки \"Редактировать определение\".")
    public void actEditButtonClick(){
        actEditButton = Button.buttonFromSearchGrid(driver, "Редактировать определение");
        scrollIntoElement(actEditButton);
        actEditButton.click();
    }

}
