package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_Vars;
import java.time.Duration;
import java.util.List;

public class Base_PO {


    public Base_PO(){
        PageFactory.initElements(getDriver(), this);
    }
    public static WebDriver getDriver(){
        return DriverFactory.getDriver();
    }
    public static void navigateTo_URL(String url){
        getDriver().get(url);
    }


    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }
    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }


    public void sendKeys(By by, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys((textToType));
    }
    public void sendKeys(WebElement element, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys((textToType));
    }
    public static void waitFor(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
    public void waitFor(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForWebElementAndClick(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void waitForWebElementAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void waitForAlert_And_ValidateText(String text){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = getDriver().switchTo().alert().getText();
        Assert.assertEquals(alert_Message_Text,text);

    }
    public static void scrollToElements(By by) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", findElement(by));


    }
    public void moveToElement (By by) {
        Actions actionProvider = new Actions(getDriver());
        actionProvider.moveToElement(findElement(by)).build().perform();
    }
    public static List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElements(by);
    }
    public static WebElement findElement(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return getDriver().findElement(by);
    }
    public static void wait(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

    protected By setLocatorParameters (By by,String name) {
        String test = by.toString().replace("By.xpath: ","");
        test = test.replace("{1}",name);
        return new By.ByXPath(test);
    }
    protected static void windowHandle() {
        String currentTabHandle = getDriver().getWindowHandle();
        String newTabHandle = getDriver().getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(currentTabHandle ))
                .findFirst()
                .get();
        getDriver().switchTo().window(newTabHandle);
    }
}
