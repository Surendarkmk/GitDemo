package Pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Home extends TestBase {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[1]/div[1]/img")
    WebElement GrailImg;
    @FindBy (xpath = "//*[@id=\"side-menu\"]/li[2]/a")
    WebElement MyQuestionTasks;
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[3]/a")
    WebElement Questions;
    @FindBy (xpath = "//*[@id=\"side-menu\"]/li[4]/a")
    WebElement QuestionBulkView;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[5]/a[1]")
    WebElement Question_Generation;
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[6]/a")
    WebElement ParamSaksham;
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[7]/a")
    WebElement Concepts;
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[8]/a")
    WebElement Instruction;
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[9]/a")
    WebElement Test_Format;
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[10]/a")
    WebElement Test_Creation;
    @FindBy (xpath = "//*[contains(text(),'Select type')]")
    WebElement Authors;

    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyGrailImg() {
        return GrailImg.isDisplayed();
    }

    public void clkQuestionGeneration() {
        Question_Generation.click();
        String questionGeneration = driver.getCurrentUrl();
        Assert.assertEquals(questionGeneration, "https://new-content-admin-staging.embibe.com/question-generation");
    }

    public void clkParamsaksham() {
        ParamSaksham.click();
        String paramsaksham = driver.getCurrentUrl();
        Assert.assertEquals(paramsaksham, "https://new-content-admin.embibe.com/tasks");
    }

    public void clkConcepts() {
        Concepts.click();
        String concepts = driver.getCurrentUrl();
        Assert.assertEquals(concepts, "https://new-content-admin.embibe.com/concepts");
    }

    public void clkTestFormat() {
        Test_Format.click();
        String testformat = driver.getCurrentUrl();
        Assert.assertEquals(testformat, "https://new-content-admin.embibe.com/concepts");
    }

    public void clkInstruction() {
        Instruction.click();
        String instruction = driver.getCurrentUrl();
        Assert.assertEquals(instruction, "https://new-content-admin.embibe.com/instruction");
    }

    public void verifyQuestionsListing() {
        Questions.click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
        }
Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]/div[2]/div/div[1]/div[2]/div[1]")).isDisplayed());
    }

    public void clkQuestions(){
        Questions.click();
    }

    public void clkTestCreation() {
        Test_Creation.click();
        String testcreation = driver.getCurrentUrl();
        Assert.assertEquals(testcreation, "https://new-content-admin.embibe.com/test/creation");
    }
}
