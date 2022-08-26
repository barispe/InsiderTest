package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Global_Vars;

public class QA_PO extends Base_PO{

    public static By seeAllQaJobs = By.xpath("//a[normalize-space()='See all QA jobs']");
    public static By titleQA = By.xpath("//h1[contains(text(),'Quality Assurance ')]");



    public QA_PO(){
        super();
    }

    public void navigateTo_QAPage(){
        navigateTo_URL(Global_Vars.USE_INSIDER_URL + "careers/quality-assurance/");
    }


    public static void verifyQAPage() {
        Assert.assertEquals(getDriver().getCurrentUrl(),Global_Vars.USE_INSIDER_URL +  "careers/quality-assurance/");
        waitFor(titleQA);
        waitFor(seeAllQaJobs);

    }

    public static void seeAll_QA_Jobs(){
        waitFor(seeAllQaJobs);
        waitForWebElementAndClick(seeAllQaJobs);
    }





}



