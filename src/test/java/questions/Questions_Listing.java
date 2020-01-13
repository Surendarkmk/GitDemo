package questions;

import base.TestBase;
import constants.TimeDelay;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.Categories;

import java.util.List;

public class Questions_Listing extends TestBase {

    @Test(groups = {Categories.ICMS_QUESTION_LISTING, Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_QUESTION}, description = "Verify user should be able to search the question using Valid Question ID")
    @Description("Verify user should be able to search the question using Valid Question ID")
    public void searchValidQuestionId() {
        questions.clkQuestions();
        questions.waitUntilListDisplay();
        questions.questionId("10007162"); //Valid Question ID
        questions.clickSearch();
        questions.waitUntilListDisplay();
        questions.verifyListingPage();
    }

    @Test(groups = {Categories.ICMS_QUESTION_LISTING, Categories.ICMS_QUESTION}, description = "Verify user should be able to search the question using Invalid Question ID")
    @Description("Verify user should be able to search the question using Invalid Question ID")
    public void searchInvalidQuestionId() {
        questions.clkQuestions();
        questions.waitUntilListDisplay();
        questions.questionId("12467598565467890"); //InValid Question ID
        questions.clickSearch();
        delayTime(TimeDelay.TIME_4000S);
        questions.verifyNolistingPage();
    }

    @Test(groups = {Categories.ICMS_QUESTION_LISTING, Categories.ICMS_QUESTION}, description = "Verify user should be able to search the question using Valid Question Code")
    @Description("Verify user should be able to search the question using Valid Question Code")
    public void SearchValidQuestionCode() {

        questions.clkQuestions();
        questions.waitUntilListDisplay();
        questions.questionCode("EM10007162"); ////Valid Question Code
        questions.clickSearch();
        questions.waitUntilListDisplay();
        questions.verifyListingPage();

    }

    @Test(groups = {Categories.ICMS_QUESTION_LISTING, Categories.ICMS_QUESTION}, description = "Verify user should be able to search the question using Invalid Question Code")
    @Description("Verify user should be able to search the question using Invalid Question Code")
    public void SearchInValidQuestionCode() {

        questions.clkQuestions();
        questions.waitUntilListDisplay();
        questions.questionCode("1246757"); //InValid Question Code
        questions.clickSearch();
        delayTime(TimeDelay.TIME_10000S);
        questions.verifyNolistingPage();

    }

    @Test(groups = {Categories.ICMS_QUESTION_LISTING, Categories.ICMS_QUESTION}, description = "Verify user should be able to search according to Question Type applied.")
    @Description("Verify user should be able to search according to Question Type applied.")
    public void SearchAllQuestionType() {

        questions.clkQuestions();
        questions.waitUntilListDisplay();
        questions.verifyAllQuestionTypes();

    }

    @Test(groups = {Categories.ICMS_QUESTION_LISTING, Categories.ICMS_QUESTION}, description = "Verify user should be able to search accoring to the Status of the question")
    @Description("Verify user should be able to search according to the Status of the question")
    public void SearchUsingAllStatus() {

        questions.clkQuestions();
        delayTime(TimeDelay.TIME_2000S);
        questions.clkStatus();
        List<WebElement> statusCount = driver.findElement(By.xpath("//*[@id=\"menu-name\"]/div[3]/ul")).findElements(By.tagName("li"));
        driver.findElement(By.xpath("//*[contains(text(),'Select status')]")).click();
        delayTime(TimeDelay.TIME_2000S);
        for (int statusType = 2; statusType <= statusCount.size(); statusType++) {
            System.out.println(statusType);
            questions.clkStatus();
            delayTime(TimeDelay.TIME_1000S);
            String count = Integer.toString(statusType);
            delayTime(TimeDelay.TIME_1000S);
            driver.findElement(By.xpath("/html/body/div[5]/div[3]/ul/li[" + count + "]")).click();
            delayTime(TimeDelay.TIME_1000S);
            questions.clickSearch();
            delayTime(TimeDelay.TIME_3000S);
            questions.waitUntilListDisplay();
        }

    }

    @Test(groups = {Categories.ICMS_QUESTION_LISTING, Categories.ICMS_QUESTION}, description = "Verify user should be able to search accoring to the Curator of the question")
    @Description("Verify user should be able to search according to the Curator of the question")
    public void SearchByCurator() {

        questions.clkQuestions();
        questions.waitUntilListDisplay();
        questions.enterCurator(prop.getProperty("UserName"));
        questions.clickSearch();
        questions.waitUntilListDisplay();
        questions.verifyListingPage();

    }
}
