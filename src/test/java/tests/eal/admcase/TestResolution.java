package tests.eal.admcase;

import objects.eal.EalMenu;
import objects.eal.admcase.all.DepartmentSelect;
import objects.eal.admcase.protocol.violation.ViolationComposer;
import objects.eal.admcase.protocol.violation.ViolationOffence;
import objects.eal.admcase.protocol.violation.ViolationRequisites;
import objects.eal.admcase.protocol.violation.ViolationRevealer;
import objects.eal.admcase.resolution.assignment.*;
import objects.eal.admcase.resolution.assignment.ResolutionPunishment;
import objects.eal.admcase.resolution.assignment.punishment.PunishmentFine;
import objects.eal.admcase.resolution.cancellation.CancellationAppeal;
import objects.eal.admcase.resolution.cancellation.CancellationCause;
import objects.eal.admcase.resolution.cancellation.CancellationComposer;
import objects.eal.admcase.resolution.cancellation.CancellationRequisites;
import objects.eal.admcase.resolution.ResolutionCreate;
import objects.eal.admcase.all.InformationMethod;
import objects.eal.admcase.all.offender.juridical.JuridicalOffender;
import objects.eal.admcase.all.offender.juridical.JuridicalOffenderDetail;
import objects.eal.admcase.all.offender.juridical.JuridicalRepresentative;
import objects.eal.admcase.all.offender.Offender;
import objects.eal.admcase.all.offender.physical.PhysicalOffender;
import objects.eal.admcase.all.offender.physical.PhysicalOffenderDetail;
import objects.eal.admcase.all.Toolbar;
import objects.eal.admcase.CaseCreate;
import objects.eal.admcase.CaseFull;
import objects.all.Login;
import objects.eal.admcase.protocol.ProtocolCreate;
import tests.TestNgBase;
import utils.TestEngine;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class TestResolution extends TestNgBase{

    @Features("Постановление")
    @Stories("Постановление о назначении административного наказания")
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

    @Features("Постановление")
    @Stories("Отмена постановления о назначении административного наказания")
    @Test(priority = 2, dependsOnMethods = { "createPhysicalResolution" })
    public void cancelResolutionEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Редактирование постановления");
        TestEngine.executeTestFromData(driver, AssignmentAppeal.class, "data\\eal\\admcase\\Resolution.xlsx", "AssignmentAppeal", "Отменено");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
    }

    @Features("Постановление")
    @Stories("Постановление о прекращении производства по делу об адм. правонарушении")
    @Test(priority = 3, dependsOnMethods = { "cancelResolutionEdit" })
    public void addCancellationResolution() throws Exception{
        String scenario = "Постановление о прекращении 1";
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Добавление постановления");
        //TestEngine.executeTestFromData(driver, ResolutionCreate.class, "data\\eal\\admcase\\Resolution.xlsx", "ResolutionCreate", "Проверка типа при создании Отмена");
        TestEngine.executeTestFromData(driver, ResolutionCreate.class, "data\\eal\\admcase\\Resolution.xlsx", "ResolutionCreate", "О прекращении производства по делу об адм. правонарушении");
        TestEngine.executeTestFromData(driver, CancellationRequisites.class, "data\\eal\\admcase\\Resolution.xlsx", "CancellationRequisites", scenario);
        TestEngine.executeTestFromData(driver, CancellationComposer.class, "data\\eal\\admcase\\Resolution.xlsx", "CancellationComposer", scenario);
        TestEngine.executeTestFromData(driver, CancellationCause.class, "data\\eal\\admcase\\Resolution.xlsx", "CancellationCause", scenario);
        TestEngine.executeTestFromData(driver, CancellationAppeal.class, "data\\eal\\admcase\\Resolution.xlsx", "CancellationAppeal", scenario);
        beforeCount("Постановление", "Постановление о прекращении производства по делу об адм. правонарушении");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
        //Thread.sleep(100000);
        afterCountAndCheck("Постановление", "Постановление о прекращении производства по делу об адм. правонарушении");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Завершить работу с делом");
    }

    @Features("Постановление")
    @Stories("Протокол об административном правонарушении на юридическое лицо")
    @Test(priority = 4, dependsOnMethods = { "addCancellationResolution" })
    //@Test(priority = 4)
    public void createJuridicalProtocol() throws Exception{
        String scenario = "Протокол об АП ЮЛ 1";
        //TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
        TestEngine.executeTestFromData(driver, EalMenu.class, "data\\eal\\EalMenu.xlsx", "EalMenu", "Создание дела");
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\eal\\admcase\\Case.xlsx", "CaseCreate", "Добавление протокола");
        TestEngine.executeTestFromData(driver, ProtocolCreate.class, "data\\eal\\admcase\\Protocol.xlsx", "ProtocolCreate", "Проверка типа при создании АП");
        TestEngine.executeTestFromData(driver, ViolationRequisites.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationRequisites", scenario);
        TestEngine.executeTestFromData(driver, ViolationComposer.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationComposer", scenario);
        TestEngine.executeTestFromData(driver, ViolationRevealer.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationRevealer", scenario);
        TestEngine.executeTestFromData(driver, InformationMethod.class, "data\\eal\\admcase\\InformationMethod.xlsx", "InformationMethod", "Радио 1");
        TestEngine.executeTestFromData(driver, Offender.class, "data\\eal\\admcase\\Offender.xlsx", "Offender", "Юридическое лицо");
        TestEngine.executeTestFromData(driver, JuridicalOffender.class, "data\\eal\\admcase\\Offender.xlsx", "JuridicalOffender", "ЮЛ 1");
        TestEngine.executeTestFromData(driver, JuridicalOffenderDetail.class, "data\\eal\\admcase\\Offender.xlsx", "JuridicalOffenderDetail", "ЮЛ 1");
        TestEngine.executeTestFromData(driver, JuridicalRepresentative.class, "data\\eal\\admcase\\Offender.xlsx", "JuridicalRepresentative", "Представитель 1");
        TestEngine.executeTestFromData(driver, ViolationOffence.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationOffence", scenario);
        beforeCount("Протокол", "Протокол об административном правонарушении");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Протокол", "Протокол об административном правонарушении");
    }

    @Features("Постановление")
    @Stories("Добавление постановления о назначении административного наказания на юридическое лицо")
    @Test(priority = 5, dependsOnMethods = { "createJuridicalProtocol" })
    public void addResolutionToJuridicalProtocol() throws Exception{
        String scenario = "Постановление об АН после протокола 1";
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\eal\\admcase\\Case.xlsx", "CaseCreate", "Добавление постановления");
        TestEngine.executeTestFromData(driver, ResolutionCreate.class, "data\\eal\\admcase\\Resolution.xlsx", "ResolutionCreate", "О назначении административного наказания");
        TestEngine.executeTestFromData(driver, AssignmentRequisites.class, "data\\eal\\admcase\\Resolution.xlsx", "AssignmentRequisites", scenario);
        TestEngine.executeTestFromData(driver, AssignmentComposer.class, "data\\eal\\admcase\\Resolution.xlsx", "AssignmentComposer", scenario);
        TestEngine.executeTestFromData(driver, Offender.class, "data\\eal\\admcase\\Offender.xlsx", "Offender", "Раскрытие блока");
        //TestEngine.executeTestFromData(driver, PhysicalOffender.class, "data\\Blocks.xlsx", "PhysicalOffender", "ФЛ 1");
        //TestEngine.executeTestFromData(driver, PhysicalOffenderDetail.class, "data\\Blocks.xlsx", "PhysicalOffenderDetail", "ФЛ 1");
        TestEngine.executeTestFromData(driver, AssignmentOffence.class, "data\\eal\\admcase\\Resolution.xlsx", "AssignmentOffence", "Раскрытие блока");
        TestEngine.executeTestFromData(driver, ResolutionPunishment.class, "data\\eal\\admcase\\ResolutionPunishment.xlsx", "ResolutionPunishment", "Штраф 1");
        TestEngine.executeTestFromData(driver, PunishmentFine.class, "data\\eal\\admcase\\ResolutionPunishment.xlsx", "PunishmentFine", "Штраф 1");
        TestEngine.executeTestFromData(driver, AssignmentAppeal.class, "data\\eal\\admcase\\Resolution.xlsx", "AssignmentAppeal", scenario);
        beforeCount("Постановление", "Постановление о назначении административного наказания");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Постановление", "Постановление о прекращении производства по делу об адм. правонарушении");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Завершить работу с делом");
    }


}
