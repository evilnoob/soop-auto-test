package tests;

import objects.all.Login;
import utils.TestEngine;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class TestLoginPage extends TestNgBase{

    @Features("Авторизация")
    @Stories("Проверка авторизации")
    @Description("Выполняется проверка работы страницы авторизации")
    @Test(priority = 1, groups = {"Authorization"})
    public void test_LoginPage() throws Exception {
        TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ1");
    }
}

