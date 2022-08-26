package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Global_Vars;


import java.util.List;

public class QA_PositionsPage_PO extends Base_PO{

    public static By positionDepartment = By.className("position-department");
    public static By positionLocation = By.className("position-location");
    public static By locationContainer = By.id("select2-filter-by-location-container");
    public static By locations = By.xpath("//li[contains(text(),'{1}')]");
    public static By departmentContainer = By.id("select2-filter-by-department-container");
    public static By departments = By.xpath("//li[contains(text(),'{1}')]");
    public static By positionListItem = By.className("position-list-item");
    public static By positionItem = By.xpath("//*[@id='jobs-list']/div[1]");
    public static By ApplyNowBtn = By.xpath("//*[@id='jobs-list']/div[1]/div/a");
    public static By positionTitle = By.xpath("//div[@class='position-list-item-wrapper bg-light']/p");


    List<WebElement> listPosition;
    List<WebElement> listDepartment;
    List<WebElement> listLocation;

    public QA_PositionsPage_PO(){
        super();
    }


    public void navigateTo_Insider_QA(){
        navigateTo_URL(Global_Vars.USE_INSIDER_URL + "careers/open-positions/?department=qualityassurance");
    }

    public List<WebElement> checkResults(){
        listPosition = findElements(positionListItem);
        return listPosition;
    }
    //click first result, save position "include" to global.vars, click apply
    public void clickApply(){
        wait(4000);
        scrollToElements(positionItem);
        moveToElement(positionItem);
        waitForWebElementAndClick(ApplyNowBtn);
        Global_Vars.chosenPosition = listPosition.get(0).getText();
    }
    //select department and location from dropdown
    public void selectDepartment(String departmentName){
        waitForWebElementAndClick(departmentContainer);
        departments = setLocatorParameters(departments,departmentName);
        scrollToElements(departments);
        waitForWebElementAndClick(departments);
    }
    public void selectLocation(String locationsName){
        waitForWebElementAndClick(locationContainer);
        locations = setLocatorParameters(locations,locationsName);
        scrollToElements(locations);
        waitForWebElementAndClick(locations);
    }
    public void checkPositionAttributes(){
        wait(2000);
        waitFor(positionTitle);
        listPosition = findElements(positionTitle);
        listDepartment = findElements(positionDepartment);
        listLocation = findElements(positionLocation);

        //check attributes for all results
        for (int i=0; i<listPosition.size(); i++) {
            Assert.assertTrue(listPosition.get(i).getText().contains(Global_Vars.position)," wrong position  " + listPosition);
            Assert.assertTrue(listDepartment.get(i).getText().contains(Global_Vars.DEPARTMENT), "wrong department " + listDepartment);
            Assert.assertTrue(listLocation.get(i).getText().contains(Global_Vars.LOCATION), "wrong location" + listLocation);
        }
    }



}








