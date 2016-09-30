package tests.eal.admcase.gisgmp;

import objects.all.Login;
import objects.all.Title;
import objects.eal.EalMenu;
import objects.eal.admcase.CaseCreate;
import objects.eal.admcase.CaseFull;
import objects.eal.admcase.all.Toolbar;
import objects.eal.admcase.all.offender.Offender;
import objects.eal.admcase.all.offender.physical.PhysicalOffender;
import objects.eal.admcase.all.offender.physical.PhysicalOffenderDetail;
import objects.eal.admcase.resolution.ResolutionCreate;
import objects.eal.admcase.resolution.assignment.*;
import objects.eal.admcase.resolution.assignment.punishment.PunishmentFine;
import tests.TestNgBase;
import utils.TestEngine;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

public class PhysicalResolution extends TestNgBase{

    @Features("Интеграция с ГИС ГМП")
    @Stories("Создание постановления")
    @Description("Выполняется проверка работы создание постановления")
    @Test(priority = 1)
    public void createPhysicalResolution() throws Exception{
        String scenario = "Постановление об АН ФЛ 1";
        TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "Участковый ИАЗ2");
        TestEngine.executeTestFromData(driver, EalMenu.class, "data\\eal\\EalMenu.xlsx", "EalMenu", "Создание дела");
        TestEngine.executeTestFromData(driver, CaseCreate.class, "data\\Case.xlsx", "CaseCreate", "Добавление постановления");
        TestEngine.executeTestFromData(driver, ResolutionCreate.class, "data\\Resolution.xlsx", "ResolutionCreate", "Проверка типа при создании АН");
        TestEngine.executeTestFromData(driver, AssignmentRequisites.class, "data\\Resolution.xlsx", "AssignmentRequisites", scenario);
        TestEngine.executeTestFromData(driver, AssignmentComposer.class, "data\\Resolution.xlsx", "AssignmentComposer", scenario);
        TestEngine.executeTestFromData(driver, Offender.class, "data\\Offender.xlsx", "Offender", "Физическое лицо");
        TestEngine.executeTestFromData(driver, PhysicalOffender.class, "data\\Offender.xlsx", "PhysicalOffender", "ФЛ 1");
        TestEngine.executeTestFromData(driver, PhysicalOffenderDetail.class, "data\\Offender.xlsx", "PhysicalOffenderDetail", "ФЛ 1");
        TestEngine.executeTestFromData(driver, AssignmentOffence.class, "data\\Resolution.xlsx", "AssignmentOffence", scenario);
        TestEngine.executeTestFromData(driver, ResolutionPunishment.class, "data\\ResolutionPunishment.xlsx", "ResolutionPunishment", "Штраф 1");
        TestEngine.executeTestFromData(driver, PunishmentFine.class, "data\\ResolutionPunishment.xlsx", "PunishmentFine", "Штраф 1");
        TestEngine.executeTestFromData(driver, AssignmentAppeal.class, "data\\Resolution.xlsx", "AssignmentAppeal", scenario);
        beforeCount("Постановление", "Постановление о назначении административного наказания");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        afterCountAndCheck("Постановление", "Постановление о назначении административного наказания");
}

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование постановления")
    @Description("Выполняется изменение номера постановления на другой случайный")
    @Test(priority = 2)
    public void physicalResolutionNumberEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование постановления");
        TestEngine.executeTestFromData(driver, AssignmentRequisites.class, "data\\Resolution.xlsx", "AssignmentRequisites", "Изменение номера");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
       // Thread.sleep(100000);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование постановления")
    @Description("Выполняется изменение месяца даты вынесения на другой")
    @Test(priority = 3)
    public void physicalResolutionIssueDateMonthEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование постановления");
        TestEngine.executeTestFromData(driver, AssignmentRequisites.class, "data\\Resolution.xlsx", "AssignmentRequisites", "Изменение даты (месяц)");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        // Thread.sleep(100000);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование постановления")
    @Description("Выполняется изменение года даты вынесения на другой")
    @Test(priority = 4)
    public void physicalResolutionIssueDateYearEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование постановления");
        TestEngine.executeTestFromData(driver, AssignmentRequisites.class, "data\\Resolution.xlsx", "AssignmentRequisites", "Изменение даты (год)");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        // Thread.sleep(100000);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование постановления")
    @Description("Выполняется изменение составителя протокола на Служебный")
    @Test(priority = 5)
    public void physicalResolutionUnitComposerEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование постановления");
        TestEngine.executeTestFromData(driver, AssignmentComposer.class, "data\\Resolution.xlsx", "AssignmentComposer", "Служебный");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        // Thread.sleep(100000);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование постановления")
    @Description("Выполняется изменение составителя протокола на Территориальный")
    @Test(priority = 6)
    public void physicalResolutionDepartmentComposerEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование постановления");
        TestEngine.executeTestFromData(driver, AssignmentComposer.class, "data\\Resolution.xlsx", "AssignmentComposer", "Территориальный");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        // Thread.sleep(100000);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование постановления")
    @Description("Выполняется изменение составителя протокола на Региональный")
    @Test(priority = 7)
    public void physicalResolutionRegionComposerEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование постановления");
        TestEngine.executeTestFromData(driver, AssignmentComposer.class, "data\\Resolution.xlsx", "AssignmentComposer", "Региональный");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        //Thread.sleep(100000);
    }

    @Features("Интеграция с ГИС ГМП")
    @Stories("Редактирование постановления")
    @Description("Выполняется изменение составителя протокола на Подразделенный")
    @Test(priority = 8)
    public void physicalResolutionSubunitComposerEdit() throws Exception{
        TestEngine.executeTestFromData(driver, CaseFull.class, "data\\Case.xlsx", "CaseFull", "Редактирование постановления");
        TestEngine.executeTestFromData(driver, AssignmentComposer.class, "data\\Resolution.xlsx", "AssignmentComposer", "Подразделенный");
        TestEngine.executeTestFromData(driver, Toolbar.class, "data\\Blocks.xlsx", "Toolbar", "Сохранить");
        // Thread.sleep(100000);
    }
}
