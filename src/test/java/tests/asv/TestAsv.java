package tests.asv;

import objects.all.Login;
import objects.all.SwitchModule;
import objects.asv.AsvMenu;
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
import objects.eal.admcase.all.Toolbar;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import tests.TestNgBase;
import utils.TestEngine;

public class TestAsv extends TestNgBase{

    @Features("Административный надзор")
    @Stories("Формальная постановка на надзор")
    @Test(priority = 1)
    public void createAsvCard() throws Exception{
        String scenario = "Административный надзор 1";
        TestEngine.executeTestFromData(driver, Login.class, "data\\Login.xlsx", "Users", "Мультиюзер");
        TestEngine.executeTestFromData(driver, SwitchModule.class, "data\\all\\SwitchModule.xlsx", "SwitchModule", "Административный надзор");
        TestEngine.executeTestFromData(driver, AsvMenu.class, "data\\asv\\AsvMenu.xlsx", "AsvMenu", "Создание карточки");

    }


}
