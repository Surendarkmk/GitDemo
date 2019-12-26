package Pages;

import base.TestBase;
import constants.TimeDelay;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;

public class Authors extends TestBase {
    @FindBy(id = "metatagging_author_name")
    WebElement authorName;
    @FindBy(id = "metatagging_author_code")
    WebElement authorCode;
    @FindBy(id = "metatagging_author_alias")
    WebElement authorAlias;
    @FindBy(id = "metatagging_author_description")
    WebElement authorDescription;
    @FindBy(id = "metatagging_author_tenant")
    WebElement authorTenant;
    @FindBy(id = "error_explanation")
    WebElement authorError;
    @FindBy(className = "dataTables_scroll")
    WebElement authorListingPage;

    public Authors(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click Authors on left side bar")
    public void clkAuthors() {
        driver.findElement(By.xpath("//*[contains(text(),'Authors')]")).click();
    }

    @Step("Click on Save Button")
    public void clkSave() {
        driver.findElement(By.className("col-sm-2")).click();
    }

    @Step("Click on Add New Author Button")
    public void clkAddNewAuthor() {
        waitUntillElementVisible(driver.findElement(By.xpath("//*[@class=\"btn btn-primary btn-sm\"]")));
        driver.findElement(By.xpath("//*[@class=\"btn btn-primary btn-sm\"]")).click();
    }

    @Step("Verify the Page URL")
    public void verifyAuthorPageUrl() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://new-content-admin-staging.embibe.com/authors");
    }

    @Step("Verify All fields present")
    public void verifyAllFiledAvailable() {
        Assert.assertTrue(authorName.isDisplayed());
        Assert.assertTrue(authorCode.isDisplayed());
        Assert.assertTrue(authorAlias.isDisplayed());
        Assert.assertTrue(authorDescription.isDisplayed());
        Assert.assertTrue(authorTenant.isEnabled());
    }

    @Step("Enter Unique Author Name")
    public void enterUniqueAuthorName(String AuthorName) {
        delayTime(TimeDelay.TIME_1000S);
        Random objGenerator = new Random();
        for (int iCount = 0; iCount < 1; iCount++) {
            int randomNumber = objGenerator.nextInt(100000000);
            authorName.sendKeys(AuthorName + " " + randomNumber);
        }
    }

    @Step("Enter Author Name")
    public void enterAuthorName(String AuthorName) {
        authorName.sendKeys(AuthorName);
    }

    @Step("Enter Unique Author Code")
    public void enterUniqueAuthorCode(String AuthorCode) {
        Random objGenerator = new Random();
        for (int iCount = 0; iCount < 1; iCount++) {
            int randomNumber = objGenerator.nextInt(100000000);
            authorCode.sendKeys(AuthorCode + " " + randomNumber);
        }
    }

    @Step("Enter Author Code")
    public void enterAuthorCode(String AuthorCode) {
        authorCode.sendKeys(AuthorCode);
    }

    @Step("Enter Author Alias")
    public void enterAuthorAlias(String AuthorAlias) {
        delayTime(TimeDelay.TIME_1000S);
        authorAlias.sendKeys(AuthorAlias);
    }

    @Step("Enter Author Description")
    public void enterAuthorDescription(String AuthorDescription) {
        authorDescription.sendKeys(AuthorDescription);
    }

    public void verifyNoErrorWhileSaving() {
        try {
            Assert.assertFalse(authorError.isDisplayed());
        } catch (Exception e) {
        }
    }

    public void verifyErrorMessageWhileSaving() {
        try {
            Assert.assertTrue(authorError.isDisplayed());
        } catch (Exception e) {
        }
    }

    public void verifyConfirmationMessage(String expectedMessage) {
        String confirmationMessage = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]")).getText();
        System.out.println(confirmationMessage);
        Assert.assertEquals(confirmationMessage, expectedMessage);
    }

    public void verifyAuthorName(String expectedAuthorName) {
        delayTime(TimeDelay.TIME_1000S);
        Assert.assertEquals(authorName.getAttribute("value"), expectedAuthorName);
    }

    public void verifyAuthorCode(String expectedAuthorCode) {
        Assert.assertEquals(authorCode.getAttribute("value"), expectedAuthorCode);
    }

    public void verifyAuthorDescription(String expectedAuthorDescription) {
        Assert.assertEquals(authorDescription.getAttribute("value"), expectedAuthorDescription);
    }

    public void verifyAuthorAlias(String expectedAuthorAlias) {
        Assert.assertEquals(authorAlias.getAttribute("value"), expectedAuthorAlias);
    }

    public void verifyAuthorListingPage() {
        try {
            waitUntillElementVisible(authorListingPage);
        } catch (Exception e) {
        }
        Assert.assertTrue(authorListingPage.isDisplayed());
    }

    @Step("Enter Author Name to Search")
    public void searchUsingName(String nameToSearch) {
        driver.findElement(By.id("search_name")).sendKeys(nameToSearch);
    }

    @Step("Enter Author Alias to Search")
    public void searchUsingAlias(String aliasToSearch) {
        driver.findElement(By.id("search_alias")).sendKeys(aliasToSearch);
    }

    @Step("Enter Author Code to Search")
    public void searchUsingCode(String codeToSearch) {
        driver.findElement(By.id("search_code")).sendKeys(codeToSearch);
    }

    @Step("Click on Search Button")
    public void clkSearchButton() {
        waitUntillElementVisible(driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]")));
        driver.findElement(By.xpath("//*[@class=\"btn btn-primary\"]")).click();
    }
}