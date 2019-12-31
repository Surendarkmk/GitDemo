package Pages;

import base.TestBase;
import constants.TimeDelay;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class Publications extends TestBase {
    public Publications(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "metatagging_publication_name")
    WebElement publicationName;
    @FindBy(id = "metatagging_publication_code")
    WebElement publicationCode;
    @FindBy(id = "metatagging_publication_description")
    WebElement publicationDescription;
    @FindBy(id = "metatagging_publication_address")
    WebElement publicationAddress;
    @FindBy(id = "metatagging_publication_phone_no")
    WebElement publicationContactNumber;
    @FindBy(id = "select2-metatagging_publication_country-container")
    WebElement publicationCountry;

    @FindBy(id = "error_explanation")
    WebElement errorMessage;
    @FindBy(id = "publications_table_wrapper")
    WebElement listingTable;

    @Step("Click Publications on Side Bar")
    public void openPublicaton() {
        waitUntillElementVisible(driver.findElement(By.xpath("//*[contains(text(),'Publications')]")));
        driver.findElement(By.xpath("//*[contains(text(),'Publications')]")).click();
    }

    @Step("Click on Save Button")
    public void clkSaveBtn() {
        pageScrole(driver.findElement(By.xpath("//*[@value='Save']")));
        driver.findElement(By.xpath("//*[@value='Save']")).submit();
    }

    @Step("Verify the URL of publication")
    public void verifyPublicationPageURL() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://new-content-admin-staging.embibe.com/publications");
    }

    @Step("Click Add New Publication Button")
    public void clkAddNewPublicationBtn() {
        driver.findElement(By.xpath("//*[@class=\"btn btn-primary btn-sm\"]")).click();
    }

    @Step("Verify all the fields available")
    public void verifyAllFiledAvailable() {
        Assert.assertTrue(publicationName.isDisplayed());
        Assert.assertTrue(publicationCode.isDisplayed());
        Assert.assertTrue(publicationDescription.isDisplayed());
        Assert.assertTrue(publicationAddress.isDisplayed());
        Assert.assertTrue(publicationContactNumber.isDisplayed());
        Assert.assertTrue(publicationCountry.isDisplayed());
    }

    @Step("Enter Publication Name")
    public void enterPublicationName(String name) {
        delayTime(TimeDelay.TIME_1000S);
        publicationName.sendKeys(name);
    }

    @Step("Enter Unique Publication Name")
    public void enterUniquePublicationName(String name) {
        delayTime(TimeDelay.TIME_1000S);
        Random objGenerator = new Random();
        for (int iCount = 0; iCount < 1; iCount++) {
            int randomNumber = objGenerator.nextInt(100000000);
            publicationName.sendKeys(name + " " + randomNumber);
        }
    }

    @Step("Enter Publication Code")
    public void enterPublicationCode(String code) {
        delayTime(TimeDelay.TIME_1000S);
        publicationCode.sendKeys(code);
    }

    @Step("Enter Unique Publication Code")
    public void enterUniquePublicationCode(String code) {
        Random objGenerator = new Random();
        for (int iCount = 0; iCount < 1; iCount++) {
            int randomNumber = objGenerator.nextInt(100000000);
            publicationCode.sendKeys(code + " " + randomNumber);
        }
    }

    @Step("Enter Publication Description")
    public void enterPublicationDescription(String description) {
        delayTime(TimeDelay.TIME_1000S);
        publicationDescription.sendKeys(description);
    }

    @Step("Enter Publication Address")
    public void enterPublicationAddress(String address) {
        delayTime(TimeDelay.TIME_1000S);
        publicationAddress.sendKeys(address);
    }

    @Step("Enter Publication Contact Number")
    public void enterPublicationContactNumber(String contactNumber) {
        delayTime(TimeDelay.TIME_1000S);
        publicationContactNumber.sendKeys(contactNumber);
    }

    @Step("Select Publication Country")
    public void selectPublicationCountry(String countryName) {
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.id("select2-metatagging_publication_country-container")).click();
        driver.findElement(By.className("select2-search__field")).sendKeys(countryName);
        driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
    }

    @Step("Verify Validation Message")
    public void verifyValidationMessage() {
        listingTable.isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='alert alert-success alert-dismissable']")).isDisplayed());
    }

    @Step("Verify Error Message")
    public void verifyErrorMessage() {
        delayTime(TimeDelay.TIME_2000S);
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Step("Verify Publication Name")
    public void verifyPublicationName(String expectedName) {
        delayTime(TimeDelay.TIME_2000S);
        Assert.assertEquals(publicationName.getAttribute("value"), expectedName);
    }

    @Step("Verify Publication Code")
    public void verifyPublicationCode(String expectedCode) {
        delayTime(TimeDelay.TIME_1000S);
        Assert.assertEquals(publicationCode.getAttribute("value"), expectedCode);
    }

    @Step("Verify Publication Description")
    public void verifyPublicationDescription(String expectedDescription) {
        delayTime(TimeDelay.TIME_1000S);
        Assert.assertEquals(publicationDescription.getAttribute("value"), expectedDescription);
    }

    @Step("Verify Publication Address")
    public void verifyPublicationAddress(String expectedAddress) {
        delayTime(TimeDelay.TIME_1000S);
        Assert.assertEquals(publicationAddress.getAttribute("value"), expectedAddress);
    }

    @Step("Verify Publication Contact Number")
    public void verifyPublicationContactNumber(String expectedContactNumber) {
        delayTime(TimeDelay.TIME_1000S);
        Assert.assertEquals(publicationContactNumber.getAttribute("value"), expectedContactNumber);
    }

    public void openRecentCreatedPublication() {
        List<WebElement> publicationTable = driver.findElements(By.xpath("//*[@id='publications_table']//descendant::a"));
        int numberOfPublication = publicationTable.size();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        String publicationUrl = publicationTable.get(numberOfPublication - 1).getAttribute("href");
        driver.get(publicationUrl);
        delayTime(TimeDelay.TIME_2000S);
    }
}