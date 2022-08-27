package pageObjects;

import org.openqa.selenium.By;


public class ApplicationForm_PO extends Base_PO{

    public static By submitBtn = By.xpath("//button[@type='submit']");
    public static By formTitle = By.xpath("//h2[contains(text(),'Software Q')]");

    public ApplicationForm_PO(){
        super();
    }

    public static void verifyFormPage() {
        wait(4000);
        waitFor(formTitle);
    }
    public static void verifySubmitBtn(){
        scrollToElements(submitBtn);
        waitFor(submitBtn);
    }
}



