package pageObjects;

import org.openqa.selenium.By;
import utils.Global_Vars;

public class HomePage_PO extends Base_PO{

    public static By main = By.id("main-head");
    public static By more = By.xpath("//span[contains(text(),'More')]");
    public static By careers = By.xpath("//h5[contains(text(),'Careers')]");

    public HomePage_PO(){
        super();
    }
    public static void navigateTo_InsiderHomePage(){
        navigateTo_URL(Global_Vars.use_insider_url);
    }

    public static void checkIfHomePageOpen(){
        waitFor(main);
    }
    public static void clickMoreMenu(){
        waitForWebElementAndClick(more);
    }
    public static void clickCareersMenu(){
        waitForWebElementAndClick(careers);    }

}
