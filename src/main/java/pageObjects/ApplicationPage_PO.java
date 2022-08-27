package pageObjects;

import org.openqa.selenium.By;

public class ApplicationPage_PO extends Base_PO{

    public static By leverApplication1 = By.xpath("(//a[contains(text(),'Apply for this job')])[1]");
    public static By leverApplication2 = By.xpath("(//a[contains(text(),'Apply for this job')])[2]");
    public static By jobTitle = By.xpath("//h2[contains(text(),'Software Q')]");


    public ApplicationPage_PO(){
        super();
    }

    public static void verifyApplicationPageURL() {
        wait(4000);
        windowHandle();
        waitFor(leverApplication1);
        wait(2000);

    }

    public static void verifyJobTitle() {
        waitFor(jobTitle);
    }
    public static void verifyApplyButton() {
        waitFor(leverApplication1);
    }
    public static void applyJob(){
        scrollToElements(leverApplication2);
        waitFor(leverApplication2);
        waitForWebElementAndClick(leverApplication2);
    }

}



