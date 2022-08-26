package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Global_Vars;

public class CareerPage_PO extends Base_PO{

    public static By careersPageHead = By.id("page-head");
    public static By ourStory = By.xpath("//h2[contains(text(),'Our story')]");
    public static By teams = By.xpath("//a[contains(text(),'See all teams')]");
    public static By location = By.xpath("//h3[contains(text(),'Our Locations')]");
    public static By lifeAtInsider = By.xpath("//h2[contains(text(),'Life at Insider')]");
    public static By cookies = By.id("wt-cli-accept-all-btn");
    public static By QA_TeamTitle = By.xpath("//h3[normalize-space()='Quality Assurance']");
    public static By sales = By.xpath("//h3[contains(text(),'Sales')]");
    public static By seeAllBtn = By. xpath("//a[normalize-space(text())='See all teams']");
    public static By businessTitle = By. xpath("//h3[normalize-space()='Business Intelligence']");
    public static By securityTitle = By. xpath("//h3[normalize-space()='Security Engineering']");



    public CareerPage_PO(){
        super();
    }

    public static void acceptCookies() {
        waitForWebElementAndClick(cookies);
        wait(2000);
    }

    public void navigateTo_InsidersCareerPage(){
        navigateTo_URL(Global_Vars.USE_INSIDER_URL + "/careers/");
    }

    public static void checkIfCareerPageLoaded(){
        waitFor(careersPageHead);
        scrollToElements(ourStory);
        waitFor(ourStory);
        scrollToElements(teams);
        waitFor(teams);
        scrollToElements(location);
        waitFor(location);
        scrollToElements(lifeAtInsider);
        waitFor(lifeAtInsider);
        wait(2000);

    }
    public static void checkCareerPageURL(){

        Assert.assertEquals(getDriver().getCurrentUrl(),Global_Vars.USE_INSIDER_URL +  "careers/");


    }
    public static void seeAllTeams(){
        waitFor(seeAllBtn);
        wait(2000);
        waitForWebElementAndClick(seeAllBtn);
        waitFor(businessTitle);
        waitFor(securityTitle);


    }
    public static void scrollToTeams(){
        scrollToElements(sales);



    }
    public static void clickQA(){
        scrollToElements(QA_TeamTitle);
        wait(2000);
        waitForWebElementAndClick(QA_TeamTitle);

    }



}
