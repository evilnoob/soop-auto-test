package tests.eal.admcase.uin;

import objects.all.Login;
import objects.eal.EalMenu;
import objects.eal.admcase.CaseCreate;
import objects.eal.admcase.CaseFull;
import objects.eal.admcase.UIN;
import objects.eal.admcase.all.InformationMethod;
import objects.eal.admcase.all.MedicalExamination;
import objects.eal.admcase.all.Toolbar;
import objects.eal.admcase.all.offender.Offender;
import objects.eal.admcase.all.offender.physical.PhysicalOffender;
import objects.eal.admcase.all.offender.physical.PhysicalOffenderDetail;
import objects.eal.admcase.protocol.ProtocolCreate;
import objects.eal.admcase.protocol.violation.ViolationComposer;
import objects.eal.admcase.protocol.violation.ViolationOffence;
import objects.eal.admcase.protocol.violation.ViolationRequisites;
import objects.eal.admcase.protocol.violation.ViolationRevealer;
import objects.eal.admcase.resolution.ResolutionCreate;
import objects.eal.admcase.resolution.assignment.*;
import objects.eal.admcase.resolution.assignment.punishment.PunishmentFine;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import tests.TestNgBase;
import utils.TestEngine;

public class TestUin2 extends TestNgBase{

    @Features("УИН2")
    @Stories("УИН")
    @Test(priority = 1)
    public void createPhysicalResolution() throws Exception{
        String scenario = "Протокол об АП ФЛ 1";
        TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
        TestEngine.executeTestFromData(driver, EalMenu.class, "data\\eal\\EalMenu.xlsx", "EalMenu", "Создание дела");
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\eal\\admcase\\Case.xlsx", "CaseCreate", "Добавление протокола");
        TestEngine.executeTestFromData(driver, ProtocolCreate.class, "data\\eal\\admcase\\Protocol.xlsx", "ProtocolCreate", "Проверка типа при создании АП");
        TestEngine.executeTestFromData(driver, ViolationRequisites.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationRequisites", scenario);
        TestEngine.executeTestFromData(driver, ViolationComposer.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationComposer", scenario);
        TestEngine.executeTestFromData(driver, ViolationRevealer.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationRevealer", scenario);
        TestEngine.executeTestFromData(driver, InformationMethod.class, "data\\eal\\admcase\\InformationMethod.xlsx", "InformationMethod", "Радио 1");
        TestEngine.executeTestFromData(driver, Offender.class, "data\\eal\\admcase\\Offender.xlsx", "Offender", "Физическое лицо");
        TestEngine.executeTestFromData(driver, PhysicalOffender.class, "data\\eal\\admcase\\Offender.xlsx", "PhysicalOffender", "ФЛ 1");
        TestEngine.executeTestFromData(driver, PhysicalOffenderDetail.class, "data\\eal\\admcase\\Offender.xlsx", "PhysicalOffenderDetail", "ФЛ 1");
        TestEngine.executeTestFromData(driver, ViolationOffence.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationOffence", scenario);
        TestEngine.executeTestFromData(driver, MedicalExamination.class, "data\\eal\\admcase\\MedicalExamination.xlsx", "MedicalExamination", "Проверка 1");
        beforeCount("Протокол", "Протокол об административном правонарушении");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Протокол", "Протокол об административном правонарушении");
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Завершить работу с делом");
    }

    @Features("УИН2")
    @Stories("УИН")
    @Test(priority = 2, dependsOnMethods = { "createPhysicalResolution" })
    public void checkUIN() throws Exception{
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка УИН не пуст");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка УИН пуст");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка кнопка УИН доступна");
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка кнопка УИН недоступна");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Открыть УИН");
        //TestEngine.executeTestFromData(driver, UIN.class, "data\\eal\\admcase\\UIN.xlsx", "UIN", "Проверка типа - МВД");
        TestEngine.executeTestFromData(driver, UIN.class, "data\\eal\\admcase\\UIN.xlsx", "UIN", "Проверка типа - СУД");
        //Thread.sleep(10000);
    }



}
