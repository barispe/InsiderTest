package stepDefinitions;
import org.testng.Assert;
import pageObjects.*;
import org.testng.annotations.Test;
import utils.Global_Vars;


public class TestCase extends Hooks {

    @Test
    public void testCase(){
        QA_PositionsPage_PO positionsPagePo = new QA_PositionsPage_PO();

        HomePage_PO.navigateTo_InsiderHomePage();
        HomePage_PO.checkIfHomePageOpen();
        HomePage_PO.clickMoreMenu();
        HomePage_PO.clickCareersMenu();

        CareerPage_PO.checkCareerPageURL();
        CareerPage_PO.acceptCookies();
        CareerPage_PO.checkIfCareerPageLoaded();
        CareerPage_PO.scrollToTeams();
        CareerPage_PO.seeAllTeams();
        CareerPage_PO.clickQA();

        QA_PO.verifyQAPage();
        QA_PO.seeAll_QA_Jobs();

        positionsPagePo.selectDepartment(Global_Vars.DEPARTMENT);
        positionsPagePo.selectLocation(Global_Vars.LOCATION);
        Assert.assertTrue(positionsPagePo.checkResults().size()>0,
                "no results with current filters" + Global_Vars.DEPARTMENT + "department " + Global_Vars.LOCATION +" location." );
        positionsPagePo.checkPositionAttributes();
        positionsPagePo.clickApply();

        ApplicationPage_PO.verifyApplicationPageURL();
        ApplicationPage_PO.verifyApplyButton();
        ApplicationPage_PO.verifyJobTitle();
        ApplicationPage_PO.applyJob();

        ApplicationForm_PO.verifyFormPage();
        ApplicationForm_PO.verifySubmitBtn();
    }
}
