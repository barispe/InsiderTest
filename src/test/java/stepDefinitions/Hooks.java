package stepDefinitions;


import org.junit.After;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Timestamp;

import static driver.DriverFactory.cleanupDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {

    public static String screenshotsSubFolderName;
    //Calling our static methods @DriverFactory

    @BeforeMethod
    public void setup(){
        getDriver();
    }

    @AfterTest
    public void tearDown(){
        cleanupDriver();

    }

    @AfterMethod
    public void screenshotCapture(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            captureScreenshot(result.getTestContext().getName()+ "_" +result.getMethod().getMethodName()+".jpg");
        }
    }
    public void captureScreenshot(String fileName) {
        if(screenshotsSubFolderName == null) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH.mm");
            screenshotsSubFolderName = myDateObj.format(myFormatObj);

        }

        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./target/Screenshots/"+ screenshotsSubFolderName+"/"+fileName);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
    }
    }



