package authors;

import base.TestBase;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthorCreation extends TestBase {

    @Test(description = "Verify \"Author Creation\" Tab is present along with other Tabs on Left side")
    @Description("Verify \"Author Creation\" Tab is present along with other Tabs on Left side")
    public void verifyAuthorCreationIspresentOnLeftSide() {
        authors.clkAuthors();
        authors.verifyAuthorPageUrl();
    }

    @Test(description = "Verify\"Author Creation\" tab consists of following paramenters")
    @Description("Verify\"Author Creation\" tab consists of following paramenters")
    public void verifyParameterConsists() {
        authors.clkAuthors();
        authors.clkAddNewAuthor();
        authors.verifyAllFiledAvailable();
    }

    @Test(description = "Verify by Creating New Author")
    @Description("Verify by Creating New Author")
    public void verifyCreatingNewAuthor() {
        authors.clkAuthors();
        authors.clkAddNewAuthor();
        authors.enterUniqueAuthorName(auth.getProperty("authorName"));
        authors.enterUniqueAuthorCode(auth.getProperty("authorCode"));
        authors.enterAuthorAlias(auth.getProperty("authorAlias"));
        authors.enterAuthorDescription(auth.getProperty("authorDescription"));
        authors.clkSave();
        authors.verifyNoErrorWhileSaving();
        authors.verifyConfirmationMessage("×\n" +
                "Author was successfully created.");
    }

    @Test(description = "Verify multiple authors are not added by Admins during the creation of the book")
    @Description("Verify multiple authors are not added by Admins during the creation of the book")
    public void verifyMultipleAuthorsCreation() {
        authors.clkAuthors();
        authors.clkAddNewAuthor();
        authors.enterAuthorName("Author 1");
        authors.enterAuthorCode(auth.getProperty("authorCode"));
        authors.enterAuthorAlias(auth.getProperty("authorAlias"));
        authors.enterAuthorDescription(auth.getProperty("authorDescription"));
        authors.clkSave();
        authors.verifyErrorMessageWhileSaving();
    }

    @Test(description = "Verify Admin is able to enter Alphanumeric in Author Name.")
    @Description("Verify Admin is able to enter Alphanumeric in Author Name.")
    public void verifyAbleToEnterAlphanumericAuthorNameFiled() {
        authors.clkAuthors();
        authors.clkAddNewAuthor();
        authors.enterAuthorName("Author 1876");
        authors.verifyAuthorName("Author 1876");
    }

    @Test(description = "Verify Admin is able to enter Alphanumeric in Author Code.")
    @Description("Verify Admin is able to enter Alphanumeric in Author Code.")
    public void verifyAbleToEnterAlphanumericAuthorCodeFiled() {
        authors.clkAuthors();
        authors.clkAddNewAuthor();
        authors.enterAuthorCode("Code1876");
        authors.verifyAuthorCode("Code1876");
    }

    @Test(description = "Verify Admin is able to enter Alphanumeric in Author Description.")
    @Description("Verify Admin is able to enter Alphanumeric in Author Description.")
    public void verifyAbleToEnterAlphanumericInAuthorDescription() {
        authors.clkAuthors();
        authors.clkAddNewAuthor();
        authors.enterAuthorDescription("Text+87876");
        authors.verifyAuthorDescription("Text+87876");
    }

    @Test(description = "Verify Admin is able to enter Alphanumeric in Author Alias.")
    @Description("Verify Admin is able to enter Alphanumeric in Author Alias.")
    public void verifyAdminAbleToEnterAlphanumericAuthorAlias() {
        authors.clkAuthors();
        authors.clkAddNewAuthor();
        authors.enterAuthorAlias("Alias007");
        authors.verifyAuthorAlias("Alias007");
    }

    @Test(description = "Verify Author in a book will be supported based on searching")
    @Description("Verify Author in a book will be supported based on searching")
    public void verifyAuthorSearchUsingName() {
        authors.clkAuthors();
        authors.verifyAuthorListingPage();
        authors.searchUsingName("Author 1");
        authors.clkSearchButton();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/authors/100/edit']")).isDisplayed());
    }

    @Test(description = "Verify Author in a book will be supported based on searching")
    @Description("Verify Author in a book will be supported based on searching")
    public void verifyAuthorSearchUsingAlise() {
        authors.clkAuthors();
        authors.verifyAuthorListingPage();
        authors.searchUsingAlias("Agarwal");
        authors.clkSearchButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"authors_table\"]/tbody/tr[1]")).isDisplayed());
    }

    @Test(description = "Verify Author search using Invalid code")
    @Description("Verify Author search using Invalid code")
    public void verifyAuthorSearchUsingInvalidCode() {
        authors.clkAuthors();
        authors.verifyAuthorListingPage();
        authors.searchUsingCode("100");
        authors.clkSearchButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='authors_table']//*[@class='dataTables_empty']")).isDisplayed());
    }

    @Test(description = "Verify Author in a book will be supported based on searching")
    @Description("Verify Author in a book will be supported based on searching")
    public void verifyAuthorSearchUsingCode() {
        authors.clkAuthors();
        authors.verifyAuthorListingPage();
        authors.searchUsingCode("Author 1");
        authors.clkSearchButton();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"authors_table\"]/tbody/tr[1]")).isDisplayed());
    }
}