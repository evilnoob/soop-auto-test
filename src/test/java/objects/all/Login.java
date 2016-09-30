package objects.all;

import elements.Button;
import elements.InputField;
import objects.Page;
import utils.DataBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

public class Login extends Page {

    public Login(WebDriver webDriver){
      super(webDriver);
    }

    public WebElement loginInputField = InputField.inputField(driver, "Логин");
    public WebElement passwordInputField = InputField.inputField(driver, "Пароль");
    public WebElement loginButton = Button.button(driver, "Войти");
    public WebElement sudisLoginButton = Button.button(driver, "Войти через СУДИС");

    @Step("Заполнение поля \"Логин\" значением {0}.")
    public void loginInput(String data) throws Exception {
        loginInputField.sendKeys(data);
        currentRegionCode=DataBase.select("code","code","string","isod.tbemployee e join isod.tbuser u on e.user_id=u.user_id join isod.tbdepartment d on d.department_id=e.department_id join isod.tbdepartment_region d_r on d_r.department_id=d.department_id join isod.tbregion r on r.id=d_r.region_id"
                ,"u.login='"+data+"'").get(0);
        currentDepartment=DataBase.select("short_name","short_name","string","isod.tbemployee e join isod.tbuser u on e.user_id=u.user_id join isod.tbdepartment d on d.department_id=e.department_id"
                ,"u.login='"+data+"'").get(0);
    }

    @Step("Заполнение поля \"Пароль\" значением {0}.")
    public void passwordInput(String data){
        passwordInputField.sendKeys(data);
    }

    @Step("Нажатие кнопки \"Войти\".")
    public void loginButtonClick(){
        loginButton.click();
    }

    @Step("Нажатие кнопки \"Войти через СУДИС\".")
    public void sudisLoginButtonClick(){
        sudisLoginButton.click();
    }

}
