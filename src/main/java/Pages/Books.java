package Pages;

import base.TestBase;
import constants.TimeDelay;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Books extends TestBase {
    public Books(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyBooksMenuAvailable() {
        driver.findElement(By.xpath("//*[contains(text(),'Books')]")).isDisplayed();
    }

    public void clickBooks() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/books']")));
        driver.findElement(By.xpath("//a[@href='/books']")).click();
        waitForPageToLoad();
    }

    public void verifyPageUrl(String expectecURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectecURL);
    }

    public void clickAddNewBook() {
        driver.findElement(By.xpath("//a[@href='/books/new']")).click();
    }

    public void enterBookName(String bookName) {
        driver.findElement(By.id("metatagging_book_name")).sendKeys(bookName);
    }

    public void selectPublicationName() {
        driver.findElement(By.id("metatagging_book_publication")).sendKeys("embibe");
        driver.findElement(By.id("metatagging_book_publication")).sendKeys(Keys.ENTER);
        delayTime(TimeDelay.TIME_1000S);
    }

    public void selectAuthorName() {
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.id("metatagging_book_authors")).sendKeys("Aggarwal");
        driver.findElement(By.id("metatagging_book_authors")).sendKeys(Keys.ENTER);
    }

    public void enterGrade() {
        driver.findElement(By.id("metatagging_book_grade")).sendKeys("Grade 11");
        driver.findElement(By.id("metatagging_book_grade")).sendKeys(Keys.ENTER);
    }

    public void enterEdition() {
        driver.findElement(By.id("metatagging_book_edition")).sendKeys("Version 1");
    }

    public void enterSyllabuses() {
        driver.findElement(By.id("metatagging_book_syllabuses")).sendKeys("CBSE");
        driver.findElement(By.id("metatagging_book_syllabuses")).sendKeys(Keys.ENTER);
    }

    public void enterEmbibeBookCode() {
        driver.findElement(By.id("metatagging_book_code")).sendKeys("Embibe 123");
    }

    public void enterBookLanguage() {
        driver.findElement(By.id("metatagging_book_languages")).sendKeys("English");
        driver.findElement(By.id("metatagging_book_languages")).sendKeys(Keys.ENTER);
    }

    public void enterBookSubject() {
        driver.findElement(By.id("metatagging_book_subjects")).sendKeys("Physics");
        driver.findElement(By.id("metatagging_book_subjects")).sendKeys(Keys.ENTER);
    }

    public void selectISBNType() {
        driver.findElement(By.id("metatagging_book_isbn_type")).click();
        driver.findElement(By.xpath("//*[@value='ISBN 10']")).click();
    }

    public void enterISBNcode(String ISBNcode) {
        driver.findElement(By.id("metatagging_book_isbn_code")).sendKeys(ISBNcode);
    }

    public void clickSave() {
        driver.findElement(By.xpath("//*[@value='Save']")).click();
        delayTime(TimeDelay.TIME_1000S);
    }
}