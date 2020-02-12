package Pages;

import base.TestBase;
import constants.TimeDelay;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.sql.Time;
import java.util.List;

public class ErrorManagement extends TestBase {

    public ErrorManagement(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickErrorManagement() {
        pageScrole(driver.findElement(By.xpath("//*[contains(text(),'Error Management')]")));
        driver.findElement(By.xpath("//*[contains(text(),'Error Management')]")).click();
        driver.navigate().to("https://new-content-admin-staging.embibe.com/errors");
    }

    public void clickCreateNewError() {
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.xpath("//button[@class='btn-success btn Ripple-parent header-action-button']")).click();
    }

    public void clickSaveNewError() {
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.xpath("//button[@class='btn-success btn Ripple-parent header-action-button']")).click();
    }

    public void enterErrorName(String ErrorName) {
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.xpath("((//*[@class='MuiInputBase-input MuiOutlinedInput-input'])[1])")).sendKeys(ErrorName);
    }

    public void enterErrorDescription(String ErrorDescription) {
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.xpath("//textarea[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline MuiOutlinedInput-inputMultiline']")).sendKeys(ErrorDescription);
    }

    public void enterErrorDeduction(String ErrorDeduction) {
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.xpath("((//*[@class='MuiInputBase-input MuiOutlinedInput-input'])[2])")).sendKeys(ErrorDeduction);
    }

    public void enterErrorMaxDeduction(String ErrorMaxDeduction) {
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.xpath("((//*[@class='MuiInputBase-input MuiOutlinedInput-input'])[3])")).sendKeys(ErrorMaxDeduction);
    }

    public void clickContentTypeDropDown() {
        driver.findElement(By.xpath("((//*[@id='simple-select-outlined'])[1])")).click();
        delayTime(TimeDelay.TIME_2000S);
        List<WebElement> contentType = driver.findElement(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']")).findElements(By.tagName("li"));
        contentType.get(1).click(); //Click Question
    }

    public void clickSubSectionDropDown() {
        driver.findElement(By.xpath("((//*[@id='simple-select-outlined'])[2])")).click();
        List<WebElement> subSection = driver.findElement(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']")).findElements(By.tagName("li"));
        subSection.get(1).click(); //Click Question
    }

    public void clickErrorTypeDropDown() {
        driver.findElement(By.xpath("((//*[@id='simple-select-outlined'])[3])")).click();
        List<WebElement> errorType = driver.findElement(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']")).findElements(By.tagName("li"));
        errorType.get(1).click(); //Click Question
    }

    public void clickErrorMultiplierDropDown() {
        driver.findElement(By.xpath("((//*[@id='simple-select-outlined'])[4])")).click();
        List<WebElement> errorMultiplier = driver.findElement(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']")).findElements(By.tagName("li"));
        errorMultiplier.get(1).click(); //Click Question
    }

    public void clickErrorSeverityDropDown() {
        driver.findElement(By.xpath("((//*[@id='simple-select-outlined'])[5])")).click();
        List<WebElement> errorSeverity = driver.findElement(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']")).findElements(By.tagName("li"));
        errorSeverity.get(1).click(); //Click Question
    }

    public void closeCreateError() {
        driver.findElement(By.xpath("//*[@class='MuiSvgIcon-root alert-close-back-to-listing']")).click();
    }

    public void getErrorMessage(String expectedError) {
        delayTime(TimeDelay.TIME_500S);
        String errorMessage = driver.findElement(By.className("header-alert")).getText();
        Assert.assertEquals(errorMessage, expectedError);
    }

    public void verifyErrorName(String ExpectedErrorName) {
        String ErrorName = driver.findElement(By.xpath("((//*[@class='MuiInputBase-input MuiOutlinedInput-input'])[1])")).getAttribute("value");
        Assert.assertEquals(ErrorName, ExpectedErrorName);
    }

    public void verifyErrorDescription(String ExpectedErrorDescription) {
        delayTime(TimeDelay.TIME_1000S);
        String ErrorDescription = driver.findElement(By.xpath("//textarea[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputMultiline MuiOutlinedInput-inputMultiline']")).getText();
        Assert.assertEquals(ErrorDescription, ExpectedErrorDescription);
    }

    public void verifyErrorDeduction(String ExpectedErrorDeduction) {
        delayTime(TimeDelay.TIME_1000S);
        String ErrorDeduction = driver.findElement(By.xpath("((//*[@class='MuiInputBase-input MuiOutlinedInput-input'])[2])")).getAttribute("value");
        Assert.assertEquals(ErrorDeduction, ExpectedErrorDeduction);
    }

    public void verifyErrorMaxDeduction(String ExpectedErrorMaxDeduction) {
        delayTime(TimeDelay.TIME_1000S);
        String ErrorMaxDeduction = driver.findElement(By.xpath("((//*[@class='MuiInputBase-input MuiOutlinedInput-input'])[3])")).getAttribute("value");
        Assert.assertEquals(ErrorMaxDeduction, ExpectedErrorMaxDeduction);
    }

    public void enterErrorCode(String errorCode) {
        driver.findElement(By.xpath("//*[@class='MuiInputBase-input MuiOutlinedInput-input']")).sendKeys(errorCode);
    }

    public void clickCreatorInField() {
        driver.findElement(By.id("simple-select-outlined")).click();
        List<WebElement> creator = driver.findElement(By.xpath("//ul[@class='MuiList-root MuiMenu-list MuiList-padding']")).findElements(By.tagName("li"));
        creator.get(3).click();
    }

    public void clickSearch() {
        driver.findElement(By.xpath("//*[@class='btn-success btn Ripple-parent search-button']")).click();
        delayTime(TimeDelay.TIME_3000S);
    }

    public void verifyListingPageAvailable() {
        Assert.assertFalse(isElementPresent(By.id("row-1")));
    }

    public void verifyListingPageNotAvailable() {
        Assert.assertTrue(isElementPresent(By.id("row-1")));
    }

    public void verifyCreatedBy(String expectedUser) {
        String createdBy = driver.findElement(By.id("cell-KmmGe1GLd-9")).getText();
        Assert.assertEquals(createdBy, expectedUser);
    }

    public void openRecentError() {
        List<WebElement> listError = driver.findElements(By.className("error-open-record"));
        System.out.println(listError.size());
    }
}