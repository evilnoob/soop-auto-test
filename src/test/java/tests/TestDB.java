package tests;

import utils.DataBase;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;


public class TestDB {

    @Features("Проверка подключения к БД")
    @Stories("Проверка запроса")
    @Description("Выполняется проверка запроса \"Select\".")
    @Test
    public void testDB() throws Exception {
        DataBase.select("case_id","case_id","int","isod.tbcase","case_id<0");
    }
}
