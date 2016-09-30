package tests.eal.admcase.uin;

import objects.eal.EalMenu;
import objects.eal.admcase.CaseFull;
import objects.eal.admcase.act.investigation.InvestigationComposer;
import objects.eal.admcase.act.investigation.InvestigationRequisites;
import objects.eal.admcase.act.investigation.InvestigationRevealer;
import objects.eal.admcase.all.InformationMethod;
import objects.eal.admcase.act.investigation.InvestigationOffence;
import objects.eal.admcase.all.Toolbar;
import objects.eal.admcase.CaseCreate;
import objects.all.Login;
import objects.eal.admcase.act.ActCreate;
import org.testng.annotations.Test;
import tests.TestNgBase;
import utils.TestEngine;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;


public class TestUin3 extends TestNgBase{

    @Features("УИН3")
    @Stories("УИН")
    @Test(priority = 1)
    public void createPhysicalResolution() throws Exception{
            String scenario = "Определение АР 1";
            TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
            //TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
            TestEngine.executeTestFromData(driver, EalMenu.class, "data\\eal\\EalMenu.xlsx", "EalMenu", "Создание дела");
            TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\eal\\admcase\\Case.xlsx", "CaseCreate", "Добавление определения");
            TestEngine.executeTestFromData(driver, ActCreate.class, "data\\eal\\admcase\\Act.xlsx", "ActCreate", "Проверка типа при создании");
            TestEngine.executeTestFromData(driver, InvestigationRequisites.class, "data\\eal\\admcase\\Act.xlsx", "InvestigationRequisites", scenario);
            TestEngine.executeTestFromData(driver, InvestigationComposer.class, "data\\eal\\admcase\\Act.xlsx", "InvestigationComposer", scenario);
            TestEngine.executeTestFromData(driver, InvestigationRevealer.class, "data\\eal\\admcase\\Act.xlsx", "InvestigationRevealer", scenario);
            TestEngine.executeTestFromData(driver, InvestigationOffence.class, "data\\eal\\admcase\\Act.xlsx", "InvestigationOffence", scenario);
            TestEngine.executeTestFromData(driver, InformationMethod.class, "data\\eal\\admcase\\InformationMethod.xlsx", "InformationMethod", "Радио 1");
            beforeCount("Определение", "Определение о проведении административного расследования");
            TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
            afterCountAndCheck("Определение", "Определение о проведении административного расследования");
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Завершить работу с делом");
    }

    @Features("УИН3")
    @Stories("УИН")
    @Test(priority = 2, dependsOnMethods = { "createPhysicalResolution" })
    public void checkUIN() throws Exception{
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка УИН не пуст");
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка УИН пуст");
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка кнопка УИН доступна");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка кнопка УИН недоступна");
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Открыть УИН");
        //TestEngine.executeTestFromData(driver, UIN.class, "data\\eal\\admcase\\UIN.xlsx", "UIN", "Проверка типа - МВД");
        //TestEngine.executeTestFromData(driver, UIN.class, "data\\eal\\admcase\\UIN.xlsx", "UIN", "Проверка типа - СУД");
        Thread.sleep(10000);
    }



}
