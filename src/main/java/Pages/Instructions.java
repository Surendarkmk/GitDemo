package Pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;


public class Instructions extends TestBase {

    WebDriver driver;

    @FindBy(xpath = "(//*[@id=\"outlined-dense\"])[1]")
    WebElement instructionId;
    @FindBy(xpath = "(//*[@id=\"outlined-dense\"])[2]")
    WebElement instructionName;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[2]/div[3]/div/p")
    WebElement instructionSearch;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[3]/div[1]/div[2]/div/p")
    WebElement instructionCreate;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[1]/img")
    WebElement instructionClose;
    @FindBy(xpath = "//*[@id=\"outlined-dense\"]")
    WebElement createName;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[2]")
    WebElement instructionSave;
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[8]/a")
    WebElement InstructionSidebar;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[3]/div[2]/div/div[1]/div[2]")
    WebElement InstructionListing;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]")
    WebElement InstructiononListing;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[4]/div[1]")
    WebElement InstructionError;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div[4]/div")
    WebElement InstructionUpdate;

    public Instructions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clkInstructions() {
        waitUntillElementVisible(InstructionSidebar);
        InstructionSidebar.click();
    }

    public void instructionSearchId(String id) {
        waitUntillElementVisible(instructionId);
        instructionId.sendKeys(id);
    }

    public void instructionSearchName(String name) {
        waitUntillElementVisible(instructionName);
        instructionName.sendKeys(name);
    }

    public void clkSearch() {
        waitUntillElementVisible(instructionSearch);
        instructionSearch.click();
    }

    public void clkCreateNewInstruction() {
        waitUntillElementVisible(instructionCreate);
        instructionCreate.click();
    }

    public void clkSaveInstructions() {
        waitUntillElementVisible(instructionSave);
        instructionSave.click();
    }

    public void closeNewInstruction() {
        waitUntillElementVisible(instructionClose);
        instructionClose.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://new-content-admin-staging.embibe.com/instruction");
    }

    public void EnterNewInstructionsName() {
        Random objGenerator = new Random();
        for (int iCount = 0; iCount < 1; iCount++) {
            int randomNumber = objGenerator.nextInt(10000000);
            waitUntillElementVisible(createName);
            createName.sendKeys("Automation Instruction " + randomNumber);
        }
    }

    public void updateInstructionName() {
        waitUntillElementVisible(createName);
        createName.sendKeys(" Auto Updated");
    }

    public void clkInstructionSaved() {
        waitUntillElementVisible(InstructionListing);
        InstructiononListing.click();
    }

    public void clearIdandName() {
        ;
        instructionId.clear();
        instructionName.clear();
    }

    public void enterInstructionText() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        String CWH = driver.getWindowHandle();
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement sat = driver.findElement(By.tagName("body"));
        sat.click();
        sat.sendKeys("The exam is conducted in online mode mode\n" +
                "The question paper consists of 90 objective type of questions\n" +
                "Paper has three sections (Physics, Chemistry, Mathematics), each section carries 30 questions\n" +
                "Duration of the paper is 3 houres (180 Minutes).");
        driver.switchTo().window(CWH);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
    }

    public void updateInstructionText() {

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        String CWH = driver.getWindowHandle();
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement sat = driver.findElement(By.tagName("body"));
        sat.click();
        sat.sendKeys("Updated Instruction ");
        driver.switchTo().window(CWH);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
    }

    public void verifyListingPage() {
        waitUntillElementVisible(InstructionListing);
        Assert.assertTrue(InstructionListing.isDisplayed());
    }

    public void verifyListingPageNoData() {
        Assert.assertFalse(InstructionListing.isDisplayed());
    }

    public void verifyErrorMsg() {
        waitUntillElementVisible(InstructionError);
        Assert.assertEquals(InstructionError.getText(), "One or more fields are empty.");
    }

    public void updatedMsg() {
        waitUntillElementVisible(InstructionUpdate);
        Assert.assertEquals(InstructionUpdate.getText(), "Instruction Updated");
    }

    public void savedMsg() {
        waitUntillElementVisible(InstructionError);
        Assert.assertEquals(InstructionError.getText(), "Instruction Created");
    }
}