package objects.eal.admcase.all;

import elements.*;
import objects.Page;
import utils.TestEngine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

public class Employees extends Page {

    public Employees(WebDriver driver) {
        super(driver);
    }

    //public List<WebElement> employeeList = ElementsGrid.elementsGridFromWindow(driver, "Сотрудники");
    public List<WebElement> employeeList = ElementsGrid.elementsSearchGridFromWindow(driver, "Сотрудники");
    public WebElement chooseButton = Button.buttonFromWindow(driver, "Сотрудники", "Выбрать");
    public WebElement addNewEmployeeButton = Button.buttonFromWindow(driver, "Сотрудники", "Добавить нового сотрудника");
    public WebElement currentCheckbox = CheckBox.checkBoxFromWindow(driver, "Сотрудники", "Свой тер. орган");
    public WebElement subordinateCheckbox = CheckBox.checkBoxFromWindow(driver, "Сотрудники", "Нижестоящие тер. органы");
    public WebElement surnameFilter = InputField.inputFieldInFilterFromWindow(driver, "Сотрудники", "Фамилия");
    public WebElement nameFilter = InputField.inputFieldInFilterFromWindow(driver, "Сотрудники", "Имя");
    public WebElement patronymicFilter = InputField.inputFieldInFilterFromWindow(driver, "Сотрудники", "Отчество");
    public WebElement departmentFilter = InputField.inputFieldInFilterFromWindow(driver, "Сотрудники", "Подразделение");
    public WebElement unitFilter = InputField.inputFieldInFilterFromWindow(driver, "Сотрудники", "Служба");
    public WebElement positionFilter = InputField.inputFieldInFilterFromWindow(driver, "Сотрудники", "Должность");
    public WebElement rankFilter = InputField.inputFieldInFilterFromWindow(driver, "Сотрудники", "Звание");
    public WebElement closeToolButton = ToolButton.toolButtonFromWindow(driver,"Сотрудники");

    @Step("Нажатие чекбокса \"Свой тер. орган\".")
    public void currentCheckboxClick() throws InterruptedException {
        currentCheckbox.click();
        Thread.sleep(500);
        employeeList = ElementsGrid.elementsSearchGridFromWindow(driver, "Сотрудники");
    }

    @Step("Нажатие чекбокса \"Нижестоящие тер. органы\".")
    public void subordinateCheckboxClick() throws InterruptedException {
        subordinateCheckbox.click();
        Thread.sleep(500);
        employeeList = ElementsGrid.elementsSearchGridFromWindow(driver, "Сотрудники");
    }


    @Step("Выбрать случайного сотрудника.")
    public void randomEmployeeClick(){
        Random rand = new Random();
        //System.out.println(employeeList.size());
        int index = rand.nextInt(employeeList.size());
        employeeList.get(index).click();
        //employeeList.get(0).click();
    }

    @Step("Поиск сотрудника по фамилии {0}.")
    public void surnameFilterInput(String data) throws InterruptedException {
        surnameFilter.sendKeys(data);
        Thread.sleep(1000);
        selectIfPresent();
    }

    @Step("Поиск сотрудника по имени {0}.")
    public void nameFilterInput(String data) throws InterruptedException {
        nameFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск сотрудника по отчеству {0}.")
    public void patronymicFilterInput(String data) throws InterruptedException {
        patronymicFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск сотрудника по подразделению {0}.")
    public void departmentFilterInput(String data) throws InterruptedException {
        departmentFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск сотрудника по службе {0}.")
    public void unitFilterInput(String data) throws InterruptedException {
        unitFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск сотрудника по должности {0}.")
    public void positionFilterInput(String data) throws InterruptedException {
        positionFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }

    @Step("Поиск сотрудника по званию {0}.")
    public void rankFilterInput(String data) throws InterruptedException {
        rankFilter.sendKeys(data);
        Thread.sleep(500);
        selectIfPresent();
    }


    @Step("Нажатие кнопки \"Добавить нового сотрудника\".")
    public void addNewEmployeeButtonInvoke(String surname) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        surnameFilterInput(surname);
        if (employeeList.isEmpty()) {
            addNewEmployeeButton.click();
            TestEngine.executeTestFromData(driver, CreateEmployee.class, "data\\all\\Employees.xlsx", "CreateEmployee", surname);
            //closeToolButton.click();
        }
        else{
            employeeList.get(0).click();
            chooseButton.click();
        }
    }

    @Step("Нажатие кнопки \"Выбрать\".")
    public void chooseButtonClick(){
        chooseButton.click();
    }

    public void selectIfPresent(){
        employeeList = ElementsGrid.elementsSearchGridFromWindow(driver, "Сотрудники");
        //System.out.println(employeeList);
        if (!employeeList.isEmpty()){
            employeeList.get(0).click();
        }
    }
}
