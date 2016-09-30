package tests.eal.admcase;

import objects.eal.EalMenu;
import objects.eal.admcase.all.DepartmentSelect;
import objects.eal.admcase.protocol.seize.SeizeComposer;
import objects.eal.admcase.protocol.seize.SeizeRegister;
import objects.eal.admcase.protocol.seize.SeizeRequisites;
import objects.eal.admcase.protocol.seize.SeizeRevealer;
import objects.eal.admcase.protocol.violation.ViolationComposer;
import objects.eal.admcase.protocol.violation.ViolationRequisites;
import objects.eal.admcase.protocol.violation.ViolationRevealer;
import objects.eal.admcase.protocol.violation.ViolationOffence;
import objects.eal.admcase.all.InformationMethod;
import objects.eal.admcase.all.MedicalExamination;
import objects.eal.admcase.all.offender.individual.IPOffender;
import objects.eal.admcase.all.offender.individual.IPOffenderDetail;
import objects.eal.admcase.all.offender.juridical.JuridicalOffender;
import objects.eal.admcase.all.offender.juridical.JuridicalOffenderDetail;
import objects.eal.admcase.all.offender.juridical.JuridicalRepresentative;
import objects.eal.admcase.all.offender.Offender;
import objects.eal.admcase.all.offender.physical.PhysicalOffender;
import objects.eal.admcase.all.offender.physical.PhysicalOffenderDetail;
import objects.eal.admcase.all.Toolbar;
import objects.eal.admcase.CaseCreate;
import objects.eal.admcase.protocol.ProtocolCreate;
import objects.eal.admcase.CaseFull;
import objects.all.Login;
import tests.TestNgBase;
import utils.TestEngine;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class TestProtocol extends TestNgBase{

    @Features("Протокол")
    @Stories("Протокол об административном правонарушении для физического лица")
    @Test(priority = 1)
    public void createPhysicalProtocol() throws Exception{
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
        //TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Завершить работу с делом");
    }

    @Features("Протокол")
    @Stories("Протокол об изъятии вещей и документов")
    @Test(priority = 2, dependsOnMethods = { "createPhysicalProtocol" })
    public void addSeizeProtocol() throws Exception{
        String scenario = "Протокол об Изъятии 1";
        //TestEngine.executeTestFromData(driver, LoginPage.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
        //TestEngine.executeTestFromData(driver, TitlePage.class, "data\\eal\\EalMenu.xlsx", "EalMenu", "Создание дела");
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\eal\\admcase\\Case.xlsx", "CaseCreate", "Добавление протокола");
        TestEngine.executeTestFromData(driver, ProtocolCreate.class, "data\\eal\\admcase\\Protocol.xlsx", "ProtocolCreate", "Проверка типа при создании изъятие");
        TestEngine.executeTestFromData(driver, SeizeRequisites.class, "data\\eal\\admcase\\Protocol.xlsx", "SeizeRequisites", scenario);
        TestEngine.executeTestFromData(driver, SeizeComposer.class, "data\\eal\\admcase\\Protocol.xlsx", "SeizeComposer", scenario);
        TestEngine.executeTestFromData(driver, SeizeRevealer.class, "data\\eal\\admcase\\Protocol.xlsx", "SeizeRevealer", scenario);
        TestEngine.executeTestFromData(driver, SeizeRegister.class, "data\\eal\\admcase\\Protocol.xlsx", "SeizeRegister", scenario);
        beforeCount("Протокол", "Протокол об изъятии вещей и документов");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Протокол", "Протокол об изъятии вещей и документов");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Завершить работу с делом");

    }

    @Features("Протокол")
    @Stories("Протокол об административном правонарушении для юридического лица")
    @Test(priority = 3, dependsOnMethods = { "addSeizeProtocol" })
    public void createJuridicalProtocol() throws Exception{
        String scenario = "Протокол об АП ЮЛ 1";
        //TestEngine.executeTestFromData(driver, LoginPage.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
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
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Завершить работу с делом");
    }

    @Features("Протокол")
    @Stories("Протокола об административном правонарушении для индивидуального предпринимателя")
    @Test(priority = 4, dependsOnMethods = { "createJuridicalProtocol" })
    //@Test(priority = 4)
    public void createIPProtocol() throws Exception{
        String scenario = "Протокол об АП ИП 1";
     //   TestEngine.executeTestFromData(driver, LoginPage.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
        TestEngine.executeTestFromData(driver, EalMenu.class, "data\\eal\\EalMenu.xlsx", "EalMenu", "Создание дела");
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\eal\\admcase\\Case.xlsx", "CaseCreate", "Добавление протокола");
        TestEngine.executeTestFromData(driver, ProtocolCreate.class, "data\\eal\\admcase\\Protocol.xlsx", "ProtocolCreate", "Проверка типа при создании АП");
        TestEngine.executeTestFromData(driver, ViolationRequisites.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationRequisites", scenario);
        TestEngine.executeTestFromData(driver, ViolationComposer.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationComposer", scenario);
        TestEngine.executeTestFromData(driver, ViolationRevealer.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationRevealer", scenario);
        TestEngine.executeTestFromData(driver, InformationMethod.class, "data\\eal\\admcase\\InformationMethod.xlsx", "InformationMethod", "Радио 1");
        TestEngine.executeTestFromData(driver, Offender.class, "data\\eal\\admcase\\Offender.xlsx", "Offender", "Индивидуальный предприниматель");
        TestEngine.executeTestFromData(driver, IPOffender.class, "data\\eal\\admcase\\Offender.xlsx", "IPOffender", "ИП 1");
        TestEngine.executeTestFromData(driver, IPOffenderDetail.class, "data\\eal\\admcase\\Offender.xlsx", "IPOffenderDetail", "ИП 1");
        TestEngine.executeTestFromData(driver, ViolationOffence.class, "data\\eal\\admcase\\Protocol.xlsx", "ViolationOffence", scenario);
        TestEngine.executeTestFromData(driver, MedicalExamination.class, "data\\eal\\admcase\\MedicalExamination.xlsx", "MedicalExamination", "Проверка 1");
        beforeCount("Протокол", "Протокол об административном правонарушении");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\eal\\admcase\\Toolbar.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Протокол", "Протокол об административном правонарушении");
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\eal\\admcase\\Case.xlsx", "CaseFull", "Завершить работу с делом");
    }

}
