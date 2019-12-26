package Pages;

import base.TestBase;
import constants.TimeDelay;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestCreation extends TestBase {
    public TestCreation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@id='client-snackbar']")
    WebElement snackBar;
    @FindBy(xpath = "//a[@href='/test/creation']")
    WebElement testCreation;

    public void clkTestCreation(){
        waitUntilElementClickable(testCreation);
        testCreation.click();
    }

    public void clkCreateNewTest(){
        driver.findElement(By.className("concept-new-btn-box")).click();
    }

    public void enterTestName(String TestName){
        driver.findElement(By.xpath("((//*[@id=\"outlined-dense\"])[1])")).sendKeys(TestName);
    }

    public void selectOrganization(){
        driver.findElement(By.xpath("//*[@class=' css-2b097c-container']")).click();
        waitUntillElementVisible(driver.findElement(By.id("react-select-2-option-0")));
        delayTime(TimeDelay.TIME_1000S);
        WebElement embibeOrganization = driver.findElement(By.xpath("//*[contains(text(),'Embibe')]"));
        embibeOrganization.click();
    }

    public void clkExamTypeDropDown(){
        driver.findElement(By.xpath("((//*[@class=' css-2b097c-container'])[2])")).click();
    }

    public void selectExam(String examType){
        WebElement exam = driver.findElement(By.xpath("//*[contains(text(),'"+examType+"')]"));
        waitUntillElementVisible(exam);
        exam.click();
        delayTime(TimeDelay.TIME_1000S);
    }

    public void enterTestFormatName(String testFormatName){
        driver.findElement(By.xpath("//*[@id=\"downshift-simple-input\"]")).sendKeys(testFormatName);
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.xpath("//*[contains(text(),'"+testFormatName+"')]")).click();
    }

    public void enterTestFormatInstructions(String testFormatInstructions){
        driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[2])")).sendKeys(testFormatInstructions);
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.xpath("//*[contains(text(),'"+testFormatInstructions+"')]")).click();
        delayTime(TimeDelay.TIME_1000S);
    }

    public void enterPhysicsQuestionId(String questionId){
        driver.findElement(By.className("physics-textarea")).sendKeys(questionId);
        delayTime(TimeDelay.TIME_1000S);
    }

    public void clkValidateBtn(){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]")).click();
    }

    public void verifyErrorMessage(String expectedErrorMessage){
        delayTime(TimeDelay.TIME_1000S);
        String actualErrorMesage = snackBar.getText();
        Assert.assertEquals(actualErrorMesage,expectedErrorMessage);
    }
}
