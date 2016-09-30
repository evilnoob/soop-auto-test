package tests;


import objects.all.Login;
import objects.all.Title;
import objects.eal.EalMenu;
import objects.eal.admcase.CaseCreate;
import objects.eal.admcase.CaseFull;
import objects.eal.admcase.act.ActCreate;
import objects.eal.admcase.act.investigation.InvestigationComposer;
import objects.eal.admcase.act.investigation.InvestigationOffence;
import objects.eal.admcase.act.investigation.InvestigationRequisites;
import objects.eal.admcase.act.investigation.InvestigationRevealer;
import objects.eal.admcase.act.retrieve.ReturnComposer;
import objects.eal.admcase.act.retrieve.ReturnRequisites;
import objects.eal.admcase.act.transfer.TransferComposer;
import objects.eal.admcase.act.transfer.TransferRequisites;
import objects.eal.admcase.all.InformationMethod;
import objects.eal.admcase.all.MedicalExamination;
import objects.eal.admcase.all.Toolbar;
import objects.eal.admcase.all.offender.Offender;
import objects.eal.admcase.all.offender.individual.IPOffender;
import objects.eal.admcase.all.offender.individual.IPOffenderDetail;
import objects.eal.admcase.protocol.ProtocolCreate;
import objects.eal.admcase.protocol.seize.SeizeComposer;
import objects.eal.admcase.protocol.seize.SeizeRegister;
import objects.eal.admcase.protocol.seize.SeizeRequisites;
import objects.eal.admcase.protocol.seize.SeizeRevealer;
import objects.eal.admcase.protocol.violation.ViolationComposer;
import objects.eal.admcase.protocol.violation.ViolationOffence;
import objects.eal.admcase.protocol.violation.ViolationRequisites;
import objects.eal.admcase.protocol.violation.ViolationRevealer;
import objects.eal.admcase.resolution.ResolutionCreate;
import objects.eal.admcase.resolution.assignment.*;
import objects.eal.admcase.resolution.assignment.punishment.PunishmentFine;
import objects.eal.admcase.resolution.cancellation.CancellationAppeal;
import objects.eal.admcase.resolution.cancellation.CancellationCause;
import objects.eal.admcase.resolution.cancellation.CancellationComposer;
import objects.eal.admcase.resolution.cancellation.CancellationRequisites;
import objects.eal.journal.EalJournal;
import objects.eal.journal.PhysicalJournal;
import utils.TestEngine;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class TestFull extends TestNgBase{

    @Features("Полный сценарий")
    @Stories("Создание определения о проведении административного расследования")
    @Description("Создание определения о проведения административного расследования")
    @Test(priority = 1)
    public void createInvestigationAct() throws Exception{
        String scenario = "Полный сценарий 1";
        TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "ЕАЛ Тула");
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
        //Thread.currentThread().sleep(10000);
    }

    @Features("Полный сценарий")
    @Stories("Создание протокола об административном правонарушении")
    @Description("Создание протокола на индивидуального предпринимателя")
    @Test(priority = 2, dependsOnMethods = { "createInvestigationAct" })
    public void createIPProtocol() throws Exception{
        String scenario = "Полный сценарий 1";
        //TestEngine.executeTestFromData(driver, LoginPage.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
        //TestEngine.executeTestFromData(driver, TitlePage.class, "data\\EalMenu.xlsx", "TitlePage", "Создание дела");
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\eal\\admcase\\Case.xlsx", "CaseCreate", "Добавление протокола");
        TestEngine.executeTestFromData(driver, ProtocolCreate.class, "data\\eal\\admcase\\Protocol.xlsx", "ProtocolCreate", "Протокол об административном правонарушении");
        TestEngine.executeTestFromData(driver, ViolationRequisites.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationRequisites", scenario);
        TestEngine.executeTestFromData(driver, ViolationComposer.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationComposer", scenario);
        TestEngine.executeTestFromData(driver, ViolationRevealer.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationRevealer", scenario);
        //TestEngine.executeTestFromData(driver, InformationMethod.class, "data\\Blocks.xlsx", "InformationMethod", "Радио 1");
        TestEngine.executeTestFromData(driver, Offender.class, "data\\eal\\admcase\\Offender.xlsx", "Offender", "Индивидуальный предприниматель");
        TestEngine.executeTestFromData(driver, IPOffender.class, "data\\eal\\admcase\\Offender.xlsx", "IPOffender", "ИП Григоренко");
        TestEngine.executeTestFromData(driver, IPOffenderDetail.class, "data\\eal\\admcase\\Offender.xlsx", "IPOffenderDetail", "ИП Григоренко");
        TestEngine.executeTestFromData(driver, ViolationOffence.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationOffence", scenario);
        TestEngine.executeTestFromData(driver, MedicalExamination.class, "data\\eal\\admcase\\MedicalExamination.xlsx", "MedicalExamination", "Проверка 1");
        beforeCount("Протокол", "Протокол об административном правонарушении");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Протокол", "Протокол об административном правонарушении");
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Завершить работу с делом");
        Thread.sleep(200);
    }

    @Features("Полный сценарий")
    @Stories("Создание протокола об изъятии")
    @Description("Добавление протокола об изъятии вещей и документов")
    @Test(priority = 3, dependsOnMethods = { "createIPProtocol" })
    public void addSeizeProtocol() throws Exception{
        String scenario = "Полный сценарий 1";
        //TestEngine.executeTestFromData(driver, LoginPage.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
        //TestEngine.executeTestFromData(driver, TitlePage.class, "data\\EalMenu.xlsx", "TitlePage", "Создание дела");
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\Case.xlsx", "CaseCreate", "Добавление протокола");
        TestEngine.executeTestFromData(driver, ProtocolCreate.class, "data\\Protocol.xlsx", "ProtocolCreate", "Проверка типа при создании изъятие");
        TestEngine.executeTestFromData(driver, SeizeRequisites.class, "data\\Protocol.xlsx", "SeizeRequisites", scenario);
        TestEngine.executeTestFromData(driver, SeizeComposer.class, "data\\Protocol.xlsx", "SeizeComposer", scenario);
        TestEngine.executeTestFromData(driver, SeizeRevealer.class, "data\\Protocol.xlsx", "SeizeRevealer", scenario);
        TestEngine.executeTestFromData(driver, SeizeRegister.class, "data\\Protocol.xlsx", "SeizeRegister", scenario);
        beforeCount("Протокол", "Протокол об изъятии вещей и документов");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Протокол", "Протокол об изъятии вещей и документов");
       // TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Завершить работу с делом");
        Thread.sleep(100);
    }


    @Features("Полный сценарий")
    @Stories("Определения о передаче дела об административном правонарушении")
    @Test(priority = 4, dependsOnMethods = { "addSeizeProtocol" })
    public void addTransferActDepartment() throws Exception{
        String scenario = "Полный сценарий 1";
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\Case.xlsx", "CaseCreate", "Добавление определения");
        TestEngine.executeTestFromData(driver, ActCreate.class, "data\\Act.xlsx", "ActCreate", "О передаче дела об административном правонарушении");
        TestEngine.executeTestFromData(driver, TransferRequisites.class, "data\\Act.xlsx", "TransferRequisites", scenario);
        TestEngine.executeTestFromData(driver, TransferComposer.class, "data\\Act.xlsx", "TransferComposer", scenario);
        beforeCount("Определение", "Определение о передаче дела об административном правонарушении");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Определение", "Определение о передаче дела об административном правонарушении");
        TestEngine.executeTestFromData(driver, Title.class, "data\\EalMenu.xlsx", "TitlePage", "Разлогиниться");
    }

    @Features("Полный сценарий")
    @Stories("Прием дела в другом территориальном органе")
    @Test(priority = 5, dependsOnMethods = { "addTransferActDepartment" })
    public void recieveCase() throws Exception{
        String scenario = "Полный сценарий 1";
        TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "Инспектор Тула");
        TestEngine.executeTestFromData(driver, Title.class, "data\\EalMenu.xlsx", "TitlePage", "Журнал");
        TestEngine.executeTestFromData(driver, EalJournal.class, "data\\EalJournal.xlsx", "EalJournal", "Свой тер. орган");
        TestEngine.executeTestFromData(driver, PhysicalJournal.class, "data\\EalJournal.xlsx", "PhysicalJournal", scenario);
        //TestEngine.executeTestFromData(driver, PhysicalJournal.class, "data\\EalJournal.xlsx", "PhysicalJournal", "123");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Принять дело в работу");
    }

    @Features("Полный сценарий")
    @Stories("Определения о передаче дела об административном правонарушении")
    @Test(priority = 6, dependsOnMethods = { "recieveCase" })
    public void addTransferActCourt1() throws Exception{
        String scenario = "Полный сценарий 2";
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\Case.xlsx", "CaseCreate", "Добавление определения");
        TestEngine.executeTestFromData(driver, ActCreate.class, "data\\Act.xlsx", "ActCreate", "О передаче дела об административном правонарушении");
        TestEngine.executeTestFromData(driver, TransferRequisites.class, "data\\Act.xlsx", "TransferRequisites", scenario);
        TestEngine.executeTestFromData(driver, TransferComposer.class, "data\\Act.xlsx", "TransferComposer", scenario);
        beforeCount("Определение", "Определение о передаче дела об административном правонарушении");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Определение", "Определение о передаче дела об административном правонарушении");
    }

    @Features("Полный сценарий")
    @Stories("Определение о возврате дела об административном правонарушении на доработку")
    @Test(priority = 7, dependsOnMethods = { "addTransferActCourt1" })
    public void addReturnAct() throws Exception{
        String scenario = "Полный сценарий 1";
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\Case.xlsx", "CaseCreate", "Добавление определения");
        TestEngine.executeTestFromData(driver, ActCreate.class, "data\\Act.xlsx", "ActCreate", "О возврате дела об административном правонарушении на доработку");
        TestEngine.executeTestFromData(driver, ReturnRequisites.class, "data\\Act.xlsx", "ReturnRequisites", scenario);
        TestEngine.executeTestFromData(driver, ReturnComposer.class, "data\\Act.xlsx", "ReturnComposer", scenario);
        beforeCount("Определение", "Определение о возврате дела об административном правонарушении на доработку");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Определение", "Определение о возврате дела об административном правонарушении на доработку");
    }

    @Features("Полный сценарий")
    @Stories("Определения о передаче дела об административном правонарушении")
    @Test(priority = 8, dependsOnMethods = { "addReturnAct" })
    public void addTransferActCourt2() throws Exception{
        String scenario = "Полный сценарий 3";
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\Case.xlsx", "CaseCreate", "Добавление определения");
        TestEngine.executeTestFromData(driver, ActCreate.class, "data\\Act.xlsx", "ActCreate", "О передаче дела об административном правонарушении");
        TestEngine.executeTestFromData(driver, TransferRequisites.class, "data\\Act.xlsx", "TransferRequisites", scenario);
        TestEngine.executeTestFromData(driver, TransferComposer.class, "data\\Act.xlsx", "TransferComposer", scenario);
        beforeCount("Определение", "Определение о передаче дела об административном правонарушении");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Определение", "Определение о передаче дела об административном правонарушении");
    }

    @Features("Полный сценарий")
    @Stories("О прекращении производства по делу об адм. правонарушении")
    @Test(priority = 9, dependsOnMethods = { "addTransferActCourt2" })
    public void addCancellationResolution() throws Exception{
        String scenario = "Полный сценарий 1";
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\Case.xlsx", "CaseFull", "Добавление постановления");
        TestEngine.executeTestFromData(driver, ResolutionCreate.class, "data\\Resolution.xlsx", "ResolutionCreate", "О прекращении производства по делу об адм. правонарушении");
        TestEngine.executeTestFromData(driver, CancellationRequisites.class, "data\\Resolution.xlsx", "CancellationRequisites", scenario);
        TestEngine.executeTestFromData(driver, CancellationComposer.class, "data\\Resolution.xlsx", "CancellationComposer", scenario);
        TestEngine.executeTestFromData(driver, CancellationCause.class, "data\\Resolution.xlsx", "CancellationCause", scenario);
        TestEngine.executeTestFromData(driver, CancellationAppeal.class, "data\\Resolution.xlsx", "CancellationAppeal", scenario);
        beforeCount("Постановление", "Постановление о прекращении производства по делу об адм. правонарушении");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        Thread.sleep(10000);
        afterCountAndCheck("Постановление", "Постановление о прекращении производства по делу об адм. правонарушении");
    }

    @Features("Полный сценарий")
    @Stories("Отмена постановления о прекращении производства по делу об адм. правонарушении")
    @Test(priority = 10, dependsOnMethods = { "addCancellationResolution" })
    public void cancelResolutionEdit() throws Exception{
        String scenario = "Полный сценарий 2";
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование постановления");
        TestEngine.executeTestFromData(driver, CancellationAppeal.class, "data\\Resolution.xlsx", "AssignmentAppeal", scenario);
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
    }

    @Features("Полный сценарий")
    @Stories("Постановления о назначении административного наказания")
   // @Test(priority = 11, dependsOnMethods = { "cancelResolutionEdit" })
    public void addResolutionToJuridicalProtocol() throws Exception{
        String scenario = "Постановление об АН после протокола 1";
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\Case.xlsx", "CaseCreate", "Добавление постановления");
        TestEngine.executeTestFromData(driver, ResolutionCreate.class, "data\\Resolution.xlsx", "ResolutionCreate", "О назначении административного наказания");
        TestEngine.executeTestFromData(driver, AssignmentRequisites.class, "data\\Resolution.xlsx", "AssignmentRequisites", scenario);
        TestEngine.executeTestFromData(driver, AssignmentComposer.class, "data\\Resolution.xlsx", "AssignmentComposer", scenario);
        TestEngine.executeTestFromData(driver, Offender.class, "data\\Offender.xlsx", "Offender", "Раскрытие блока");
        //TestEngine.executeTestFromData(driver, PhysicalOffender.class, "data\\Blocks.xlsx", "PhysicalOffender", "ФЛ 1");
        //TestEngine.executeTestFromData(driver, PhysicalOffenderDetail.class, "data\\Blocks.xlsx", "PhysicalOffenderDetail", "ФЛ 1");
        TestEngine.executeTestFromData(driver, AssignmentOffence.class, "data\\Resolution.xlsx", "AssignmentOffence", "Раскрытие блока");
        TestEngine.executeTestFromData(driver, ResolutionPunishment.class, "data\\ResolutionPunishment.xlsx", "ResolutionPunishment", "Штраф 1");
        TestEngine.executeTestFromData(driver, PunishmentFine.class, "data\\ResolutionPunishment.xlsx", "PunishmentFine", "Штраф 1");
        TestEngine.executeTestFromData(driver, AssignmentAppeal.class, "data\\Resolution.xlsx", "AssignmentAppeal", scenario);
        beforeCount("Постановление", "Постановление о назначении административного наказания");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Постановление", "Постановление о прекращении производства по делу об адм. правонарушении");
    }

}
