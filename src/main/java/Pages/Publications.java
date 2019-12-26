package Pages;

import base.TestBase;
import constants.TimeDelay;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;

public class Publications extends TestBase {
    public Publications(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "metatagging_publication_name")
    WebElement publicationName;
    @FindBy(id="metatagging_publication_code")
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
    @FindBy(className = "alert alert-success alert-dismissable")
    WebElement successValidationMessage;
    @FindBy(id = "publications_table_wrapper")
    WebElement listingTable;

    @Step("Click Publications on Side Bar")
    public void openPublicaton(){
        driver.findElement(By.xpath("//*[contains(text(),'Publications')]")).click();
    }

    @Step("Click on Save Button")
    public void clkSaveBtn(){
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.xpath("//*[contains(text(),'Save')]")).submit();
        //driver.findElement(By.className("btn btn-primary btn-block m-t")).submit();
    }

    @Step("Verify the URL of publication")
    public void verifyPublicationPageURL(){
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://new-content-admin-staging.embibe.com/publications");
    }

    @Step("Click Add New Publication Button")
    public void clkAddNewPublicationBtn(){
        driver.findElement(By.xpath("//*[@class=\"btn btn-primary btn-sm\"]")).click();
    }

    @Step("Verify all the fields available")
    public void verifyAllFiledAvailable(){
        Assert.assertTrue(publicationName.isDisplayed());
        Assert.assertTrue(publicationCode.isDisplayed());
        Assert.assertTrue(publicationDescription.isDisplayed());
        Assert.assertTrue(publicationAddress.isDisplayed());
        Assert.assertTrue(publicationContactNumber.isDisplayed());
        Assert.assertTrue(publicationCountry.isDisplayed());
    }

    @Step("Enter Publication Name")
    public void enterPublicationName(String name){
        publicationName.sendKeys(name);
    }
    @Step("Enter Unique Publication Name")
    public void enterUniquePublicationName(String name){
        delayTime(TimeDelay.TIME_1000S);
        Random objGenerator = new Random();
        for (int iCount = 0; iCount < 1; iCount++) {
            int randomNumber = objGenerator.nextInt(100000000);
            publicationName.sendKeys(name+" "+ randomNumber);
        }
    }

    @Step("Enter Publication Code")
    public void enterPublicationCode(String code){
            publicationCode.sendKeys(code);
    }

    @Step("Enter Unique Publication Code")
    public void enterUniquePublicationCode(String code){
        Random objGenerator = new Random();
        for (int iCount = 0; iCount < 1; iCount++) {
            int randomNumber = objGenerator.nextInt(100000000);
            publicationCode.sendKeys(code+" "+randomNumber);
        }
    }

    @Step("Enter Publication Description")
    public void enterPublicationDescription(String description){
        publicationDescription.sendKeys(description);
    }

    @Step("Enter Publication Address")
    public void enterPublicationAddress(String address){
        publicationAddress.sendKeys(address);
    }

    @Step("Enter Publication Contact Number")
    public void enterPublicationContactNumber(String contactNumber){
        publicationContactNumber.sendKeys(contactNumber);
    }

    @Step("Select Publication Country")
    public void selectPublicationCountry(String countryName){
        WebElement countrySearchField = driver.findElement(By.id("select2-metatagging_publication_country-container"));
        countrySearchField.click();
        driver.findElement(By.className("select2-search__field")).sendKeys(countryName);
        driver.findElement(By.className("select2-search__field")).sendKeys(Keys.ENTER);
        //countrySearchField.sendKeys(Keys.ENTER);
    }

    @Step("Verify Validation Message")
    public void verifyValidationMessage(){
        listingTable.isDisplayed();
        Assert.assertTrue(successValidationMessage.isDisplayed());
    }

    @Step("Verify Error Message")
    public void verifyErrorMessage(){
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    public void verifyNoErrorWhileSaving(){
        Assert.assertFalse(errorMessage.isDisplayed());
    }

    @Step("Verify Publication Name")
    public void verifyPublicationName(String expectedName){
        Assert.assertEquals(publicationName.getAttribute("value"), expectedName);
    }

    @Step("Verify Publication Code")
    public void verifyPublicationCode(String expectedCode){
        Assert.assertEquals(publicationCode.getAttribute("value"), expectedCode);
    }

    @Step("Verify Publication Description")
    public void verifyPublicationDescription(String expectedDescription){
        Assert.assertEquals(publicationDescription.getAttribute("value"), expectedDescription);
    }

    @Step("Verify Publication Address")
    public void verifyPublicationAddress(String expectedAddress){
        Assert.assertEquals(publicationAddress.getAttribute("value"), expectedAddress);
    }

    @Step("Verify Publication Contact Number")
    public void verifyPublicationContactNumber(String expectedContactNumber){
        Assert.assertEquals(publicationContactNumber.getAttribute("value"), expectedContactNumber);
    }
}