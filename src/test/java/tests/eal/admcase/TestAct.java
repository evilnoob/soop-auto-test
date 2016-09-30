package tests.eal.admcase;

import objects.eal.EalMenu;
import objects.eal.admcase.CaseFull;
import objects.eal.admcase.act.investigation.InvestigationComposer;
import objects.eal.admcase.act.investigation.InvestigationRequisites;
import objects.eal.admcase.act.investigation.InvestigationRevealer;
import objects.eal.admcase.act.retrieve.ReturnComposer;
import objects.eal.admcase.act.retrieve.ReturnRequisites;
import objects.eal.admcase.act.transfer.TransferComposer;
import objects.eal.admcase.act.transfer.TransferRequisites;
import objects.eal.admcase.all.DepartmentSelect;
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

public class TestAct extends TestNgBase{

    @Features("Определение")
    @Stories("Определение о проведении административного расследования")
    @Test(priority = 1)
    public void createInvestigationAct() throws Exception{
        String scenario = "Определение АР 1";
        TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "Инспектор Тула");
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
    }

    @Features("Определение")
    @Stories("Определение о передаче дела об административном правонарушении")
    @Test(priority = 2, dependsOnMethods = { "createInvestigationAct" })
    public void addTransferAct() throws Exception{
        String scenario = "Определение Передача 1";
        //String scenario = "Полный сценарий 2";
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\eal\\admcase\\Case.xlsx", "CaseCreate", "Добавление определения");
        TestEngine.executeTestFromData(driver, ActCreate.class, "data\\eal\\admcase\\Act.xlsx", "ActCreate", "О передаче дела об административном правонарушении");
        TestEngine.executeTestFromData(driver, TransferRequisites.class, "data\\eal\\admcase\\Act.xlsx", "TransferRequisites", scenario);
        TestEngine.executeTestFromData(driver, TransferComposer.class, "data\\eal\\admcase\\Act.xlsx", "TransferComposer", scenario);
        beforeCount("Определение", "Определение о передаче дела об административном правонарушении");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Определение", "Определение о передаче дела об административном правонарушении");
    }

    @Features("Определение")
    @Stories("Определение о возврате дела об административном правонарушении на доработку")
    @Test(priority = 3, dependsOnMethods = { "addTransferAct" })
    public void addReturnAct() throws Exception{
        String scenario = "Определение Возврат 1";
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\eal\\admcase\\Case.xlsx", "CaseCreate", "Добавление определения");
        TestEngine.executeTestFromData(driver, ActCreate.class, "data\\eal\\admcase\\Act.xlsx", "ActCreate", "О возврате дела об административном правонарушении на доработку");
        TestEngine.executeTestFromData(driver, ReturnRequisites.class, "data\\eal\\admcase\\Act.xlsx", "ReturnRequisites", scenario);
        TestEngine.executeTestFromData(driver, ReturnComposer.class, "data\\eal\\admcase\\Act.xlsx", "ReturnComposer", scenario);
        beforeCount("Определение", "Определение о возврате дела об административном правонарушении на доработку");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Определение", "Определение о возврате дела об административном правонарушении на доработку");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Завершить работу с делом");
    }

}
