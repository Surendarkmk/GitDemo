package Pages;

import base.TestBase;
import constants.TimeDelay;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;

public class Books extends TestBase {
    public Books(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Verify The Availability in Side Bar")
    public void verifyBooksMenuAvailable() {
        driver.findElement(By.xpath("//*[contains(text(),'Books')]")).isDisplayed();
    }

    @Step("Click Books")
    public void clickBooks() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/books']")));
        driver.findElement(By.xpath("//a[@href='/books']")).click();
        waitForPageToLoad();
    }

    @Step("Verify Page URL")
    public void verifyPageUrl(String expectecURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectecURL);
    }

    @Step("Click Add New Book Button")
    public void clickAddNewBook() {
        driver.findElement(By.xpath("//a[@href='/books/new']")).click();
    }

    @Step("Enter Book Name")
    public void enterBookName(String bookName) {
        delayTime(TimeDelay.TIME_1000S);
        Random objGenerator = new Random();
        for (int iCount = 0; iCount < 1; iCount++) {
            int randomNumber = objGenerator.nextInt(100000000);
            driver.findElement(By.id("metatagging_book_name")).sendKeys(bookName + " " + randomNumber);
        }
    }

    @Step("Select Publication Name")
    public void selectPublicationName() {
        driver.findElement(By.id("metatagging_book_publication")).sendKeys("embibe");
        driver.findElement(By.id("metatagging_book_publication")).sendKeys(Keys.ENTER);
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Select Author Name")
    public void selectAuthorName() {
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.id("metatagging_book_authors")).sendKeys("Aggarwal");
        driver.findElement(By.id("metatagging_book_authors")).sendKeys(Keys.ENTER);
    }

    @Step("Enter Grade for the Book")
    public void enterGrade(String grade) {
        driver.findElement(By.id("metatagging_book_grade")).sendKeys(grade);
        driver.findElement(By.id("metatagging_book_grade")).sendKeys(Keys.ENTER);
    }

    @Step("Enter Edition for Book")
    public void enterEdition() {
        driver.findElement(By.id("metatagging_book_edition")).sendKeys("Version 1");
    }

    @Step("Enter Syllabus for Book")
    public void enterSyllabuses(String syllabus) {
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.id("metatagging_book_syllabuses")).sendKeys(syllabus);
        driver.findElement(By.id("metatagging_book_syllabuses")).sendKeys(Keys.ENTER);
    }

    @Step("Enter Code for Book")
    public void enterEmbibeBookCode() {
        Random objGenerator = new Random();
        for (int iCount = 0; iCount < 1; iCount++) {
            int randomNumber = objGenerator.nextInt(100000000);
            driver.findElement(By.id("metatagging_book_code")).sendKeys("Embibe " + randomNumber);
        }
    }

    @Step("Enter Language for Book")
    public void enterBookLanguage(String language) {
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.id("metatagging_book_languages")).sendKeys(language);
        driver.findElement(By.id("metatagging_book_languages")).sendKeys(Keys.ENTER);
    }

    @Step("Enter Subject for Book")
    public void enterBookSubject(String subject) {
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.id("metatagging_book_subjects")).sendKeys(subject);
        driver.findElement(By.id("metatagging_book_subjects")).sendKeys(Keys.ENTER);
    }

    @Step("Select ISBN Type for Book")
    public void selectISBNType() {
        driver.findElement(By.id("metatagging_book_isbn_type")).click();
        driver.findElement(By.xpath("//*[@value='ISBN 10']")).click();
    }

    @Step("Enter ISBN code for Book")
    public void enterISBNcode(String ISBNcode) {
        driver.findElement(By.id("metatagging_book_isbn_code")).sendKeys(ISBNcode);
    }

    @Step("Click on Save Button")
    public void clickSave() {
        driver.findElement(By.xpath("//*[@value='Save']")).click();
        delayTime(TimeDelay.TIME_2000S);
    }

    @Step("Verify Tenant Name for Book")
    public void verifyTenantName(String tenantName) {
        String tenant = driver.findElement(By.name("metatagging_book[tenant_name]")).getAttribute("value");
        Assert.assertEquals(tenant, tenantName);
    }

    @Step("Verify error message if no Name While save")
    public void verifyErrorMessageInName() {
        delayTime(TimeDelay.TIME_500S);
        String msg = driver.findElement(By.id("metatagging_book_name")).getAttribute("validationMessage");
        System.out.println(msg);
        Assert.assertEquals(msg, "Please fill in this field.");
    }

    public void verifyNoErrorMsg() {
        Assert.assertTrue(driver.findElements(By.id("error_explanation")).isEmpty());
    }

    @Step("Verify error message While save")
    public void verifyErrorMessage(String expectedAlertMsg) {
        String alertMessage = driver.findElement(By.id("error_explanation")).getText();
        Assert.assertEquals(alertMessage, expectedAlertMsg);
    }

    @Step("Verify Validation message after save")
    public void verifyValidationMessage(String expectedValidationMessage) {
        delayTime(TimeDelay.TIME_3000S);
        String validationMessage = driver.findElement(By.xpath("//*[@class='alert alert-success alert-dismissable']")).getText();
        Assert.assertEquals(validationMessage, expectedValidationMessage);
    }
}