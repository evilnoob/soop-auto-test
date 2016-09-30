package tests.eal.admcase.uin;

import objects.all.Login;
import objects.eal.EalMenu;
import objects.eal.admcase.CaseCreate;
import objects.eal.admcase.CaseFull;
import objects.eal.admcase.UIN;
import objects.eal.admcase.act.ActCreate;
import objects.eal.admcase.act.investigation.InvestigationComposer;
import objects.eal.admcase.act.investigation.InvestigationOffence;
import objects.eal.admcase.act.investigation.InvestigationRequisites;
import objects.eal.admcase.act.investigation.InvestigationRevealer;
import objects.eal.admcase.all.InformationMethod;
import objects.eal.admcase.all.Toolbar;
import objects.eal.admcase.all.offender.Offender;
import objects.eal.admcase.all.offender.physical.PhysicalOffender;
import objects.eal.admcase.all.offender.physical.PhysicalOffenderDetail;
import objects.eal.admcase.resolution.ResolutionCreate;
import objects.eal.admcase.resolution.assignment.*;
import objects.eal.admcase.resolution.assignment.punishment.PunishmentFine;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import tests.TestNgBase;
import utils.TestEngine;

public class TestUin1 extends TestNgBase{

    @Features("УИН1")
    @Stories("УИН")
    @Test(priority = 1)
    public void createPhysicalResolution() throws Exception{
        String scenario = "Постановление об АН ФЛ 1";
        TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
        TestEngine.executeTestFromData(driver, EalMenu.class, "data\\eal\\EalMenu.xlsx", "EalMenu", "Создание дела");
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\eal\\admcase\\Case.xlsx", "CaseCreate", "Добавление постановления");
        TestEngine.executeTestFromData(driver, ResolutionCreate.class, "data\\eal\\admcase\\Resolution.xlsx", "ResolutionCreate", "Проверка типа при создании АН");
        TestEngine.executeTestFromData(driver, AssignmentRequisites.class, "data\\eal\\admcase\\Resolution.xlsx", "AssignmentRequisites", scenario);
        TestEngine.executeTestFromData(driver, AssignmentComposer.class, "data\\eal\\admcase\\Resolution.xlsx", "AssignmentComposer", scenario);
        TestEngine.executeTestFromData(driver, Offender.class, "data\\eal\\admcase\\Offender.xlsx", "Offender", "Физическое лицо");
        TestEngine.executeTestFromData(driver, PhysicalOffender.class, "data\\eal\\admcase\\Offender.xlsx", "PhysicalOffender", "ФЛ 1");
        TestEngine.executeTestFromData(driver, PhysicalOffenderDetail.class, "data\\eal\\admcase\\Offender.xlsx", "PhysicalOffenderDetail", "ФЛ 1");
        TestEngine.executeTestFromData(driver, AssignmentOffence.class, "data\\eal\\admcase\\Resolution.xlsx", "AssignmentOffence", scenario);
        TestEngine.executeTestFromData(driver, ResolutionPunishment.class, "data\\eal\\admcase\\ResolutionPunishment.xlsx", "ResolutionPunishment", "Штраф 1");
        TestEngine.executeTestFromData(driver, PunishmentFine.class, "data\\eal\\admcase\\ResolutionPunishment.xlsx", "PunishmentFine", "Штраф 1");
        TestEngine.executeTestFromData(driver, AssignmentAppeal.class, "data\\eal\\admcase\\Resolution.xlsx", "AssignmentAppeal", scenario);
        beforeCount("Постановление", "Постановление о назначении административного наказания");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Постановление", "Постановление о назначении административного наказания");
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Завершить работу с делом");
    }

    @Features("УИН1")
    @Stories("УИН")
    @Test(priority = 2, dependsOnMethods = { "createPhysicalResolution" })
    public void checkUIN() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка УИН не пуст");
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка УИН пуст");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка кнопка УИН доступна");
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Проверка кнопка УИН недоступна");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Открыть УИН");
        TestEngine.executeTestFromData(driver, UIN.class, "data\\eal\\admcase\\UIN.xlsx", "UIN", "Проверка типа - МВД");
        //TestEngine.executeTestFromData(driver, UIN.class, "data\\eal\\admcase\\UIN.xlsx", "UIN", "Проверка типа - СУД");
        //Thread.sleep(10000);
    }



}
