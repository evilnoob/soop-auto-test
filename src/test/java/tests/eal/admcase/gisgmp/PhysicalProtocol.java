package tests.eal.admcase.gisgmp;


import objects.all.Login;
import objects.all.Title;
import objects.eal.EalMenu;
import objects.eal.admcase.CaseCreate;
import objects.eal.admcase.CaseFull;
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
import tests.TestNgBase;
import utils.TestEngine;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class PhysicalProtocol extends TestNgBase{

    @Features("Интеграция с ГИС ГМП")
    @Stories("Создание протокола")
    @Description("Выполняется проверка работы создания протокола")
    @Test(priority = 1)
    public void createPhysicalProtocol() throws Exception{
        String scenario = "Протокол об АП ФЛ 1";
        TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
        TestEngine.executeTestFromData(driver, EalMenu.class, "data\\eal\\EalMenu.xlsx", "EalMenu", "Создание дела");
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\Case.xlsx", "CaseCreate", "Добавление протокола");
        TestEngine.executeTestFromData(driver, ProtocolCreate.class, "data\\Protocol.xlsx", "ProtocolCreate", "Проверка типа при создании АП");
        TestEngine.executeTestFromData(driver, ViolationRequisites.class, "data\\Protocol.xlsx", "ViolationRequisites", scenario);
        TestEngine.executeTestFromData(driver, ViolationComposer.class, "data\\Protocol.xlsx", "ViolationComposer", scenario);
        TestEngine.executeTestFromData(driver, ViolationRevealer.class, "data\\Protocol.xlsx", "ViolationRevealer", scenario);
        TestEngine.executeTestFromData(driver, InformationMethod.class, "data\\Blocks.xlsx", "InformationMethod", "Радио 1");
        TestEngine.executeTestFromData(driver, Offender.class, "data\\Offender.xlsx", "Offender", "Физическое лицо");
        TestEngine.executeTestFromData(driver, PhysicalOffender.class, "data\\Offender.xlsx", "PhysicalOffender", "ФЛ 1");
        TestEngine.executeTestFromData(driver, PhysicalOffenderDetail.class, "data\\Offender.xlsx", "PhysicalOffenderDetail", "ФЛ 1");
        TestEngine.executeTestFromData(driver, ViolationOffence.class, "data\\Protocol.xlsx", "ViolationOffence", scenario);
        TestEngine.executeTestFromData(driver, MedicalExamination.class, "data\\Blocks.xlsx", "MedicalExamination", "Проверка 1");
        beforeCount("Протокол", "Протокол об административном правонарушении");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Протокол", "Протокол об административном правонарушении");
        Thread.sleep(100);

    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Создание постановления")
    @Description("Выполняется создание постановления о назначении административного наказания для дела, уже содержащего протокол.")
    @Test(priority = 2)
    public void addResolutionToPhysicalProtocol() throws Exception{
        String scenario = "Постановление об АН после протокола 1";
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Добавление постановления");
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
        afterCountAndCheck("Постановление", "Постановление о назначении административного наказания");
        Thread.sleep(100);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование протокола")
    @Description("Выполняется изменение номера протокола на другой случайный")
    @Test(priority = 3)
    public void physicalProtocolNumberEdit() throws Exception{
        //Thread.sleep(100000);
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование протокола");
        TestEngine.executeTestFromData(driver, ViolationRequisites.class, "data\\Protocol.xlsx", "ViolationRequisites", "Изменение номера");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование протокола")
    @Description("Выполняется изменение месяца даты вынесения на другой")
    @Test(priority = 4)
    public void physicalProtocolIssueDateMonthEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование протокола");
        TestEngine.executeTestFromData(driver, ViolationRequisites.class, "data\\Protocol.xlsx", "ViolationRequisites", "Изменение даты (месяц)");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        // Thread.sleep(100000);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование протокола")
    @Description("Выполняется изменение года даты вынесения на другой")
    @Test(priority = 5)
    public void physicalProtocolIssueDateYearEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование протокола");
        TestEngine.executeTestFromData(driver, ViolationRequisites.class, "data\\Protocol.xlsx", "ViolationRequisites", "Изменение даты (год)");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        // Thread.sleep(100000);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование протокола")
    @Description("Выполняется изменение составителя протокола на Служебный")
    @Test(priority = 6)
    public void physicalProtocolUnitComposerEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование протокола");
        TestEngine.executeTestFromData(driver, ViolationComposer.class, "data\\Protocol.xlsx", "ViolationComposer", "Служебный");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        // Thread.sleep(100000);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование протокола")
    @Description("Выполняется изменение составителя протокола на Территориальный")
    @Test(priority = 7)
    public void physicalProtocolDepartmentComposerEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование протокола");
        TestEngine.executeTestFromData(driver, ViolationComposer.class, "data\\Protocol.xlsx", "ViolationComposer", "Территориальный");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        // Thread.sleep(100000);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование протокола")
    @Description("Выполняется изменение составителя протокола на Региональный")
    @Test(priority = 8)
    public void physicalProtocolRegionComposerEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование протокола");
        TestEngine.executeTestFromData(driver, ViolationComposer.class, "data\\Protocol.xlsx", "ViolationComposer", "Региональный");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
       //Thread.sleep(100000);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование протокола")
    @Description("Выполняется изменение составителя протокола на Подразделенный")
    @Test(priority = 9)
    public void physicalProtocolSubunitComposerEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование протокола");
        TestEngine.executeTestFromData(driver, ViolationComposer.class, "data\\Protocol.xlsx", "ViolationComposer", "Подразделенный");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        // Thread.sleep(100000);
    }

}
