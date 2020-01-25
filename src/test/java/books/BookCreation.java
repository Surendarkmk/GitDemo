package books;

import base.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class BookCreation extends TestBase {

    @Test(description = "Verify Books option available on the slideBar")
    @Description("Verify Books option available on the slideBar")
    public void verifyBooksOptionAvailableOnSlideBar() {
        books.verifyBooksMenuAvailable();
    }

    @Test(description = "Verify By clicking on Books option on Slide Bar, User should Navigate to Books page")
    @Description("Verify By clicking on Books option on Slide Bar, User should Naviagte to Books page")
    public void verifyClickingBooksOnSlideBar() {
        books.clickBooks();
        books.verifyPageUrl("https://new-content-admin-staging.embibe.com/books");
    }

    @Test(description = "Verify is User able to Click Create New Book on the book listing page")
    @Description("Verify is User able to Click Create New Book on the book listing page")
    public void verifyUserAbleToClickCreateNewBook() {
        books.clickBooks();
        books.clickAddNewBook();
        books.verifyPageUrl("https://new-content-admin-staging.embibe.com/books/new");
    }

    @Test(description = "Verify is User able to Create Book without any one filed")
    @Description("Verify is User able to Create Book without any one Mandatory filed")
    public void verifyUserCreateBookWithoutMandatoryFiled() {
        books.clickBooks();
        books.clickAddNewBook();
        books.selectAuthorName();
        books.selectPublicationName();
        books.enterGrade("Grade 11");
        books.enterEdition();
        books.enterSyllabuses("cbse");
        books.enterBookLanguage("English");
        books.enterBookSubject("Physics");
        books.enterEmbibeBookCode();
        books.clickSave();
        books.verifyErrorMessageInName();
    }

    @Test(description = "Verify the Tenant name mentioned on the Book")
    @Description("Verify the Tenant name mentioned on the Book")
    public void verifyTenantNameMentionedOnBook() {
        books.clickBooks();
        books.clickAddNewBook();
        books.verifyTenantName("CG-Automation");
    }

    @Test(description = "Verfiy by entering the ISBN number of already created Book ")
    @Description("Verfiy by entering the ISBN number of already created Book ")
    public void verfiyEnteringISBNNumberAlreadyCreatedBook() {
        books.clickBooks();
        books.clickAddNewBook();
        books.enterBookName("Book");
        books.selectAuthorName();
        books.selectPublicationName();
        books.enterGrade("Grade 12");
        books.enterEdition();
        books.enterSyllabuses("CBSE");
        books.enterBookLanguage("English");
        books.enterBookSubject("Physics");
        books.enterEmbibeBookCode();
        books.enterISBNcode("342456778");
        books.clickSave();
        books.verifyErrorMessage("Alert!\n" +
                "1 error prohibited this book from being saved.\n" +
                "Isbn code has already been taken");
    }

    @Test(description = "Verify by Confirmation message once created New Book")
    @Description("Verify by Confirmation message once created New Book")
    public void verifyConfirmationMessageOnceCreatedNewBook() {
        books.clickBooks();
        books.clickAddNewBook();
        books.enterBookName("Book");
        books.selectAuthorName();
        books.selectPublicationName();
        books.enterGrade("Grade 12");
        books.enterEdition();
        books.enterSyllabuses("CBSE");
        books.enterBookLanguage("English");
        books.enterBookSubject("Physics");
        books.enterEmbibeBookCode();
        books.clickSave();
        books.verifyValidationMessage("×\n" +
                "Book was successfully created.");
    }

    @Test(description = "Verify by creating new book without ISBN code")
    @Description("Verify by creating new book without ISBN code")
    public void verifyCreatingNewBookWithoutISBNCode() {
        books.clickBooks();
        books.clickAddNewBook();
        books.enterBookName("Book");
        books.selectAuthorName();
        books.selectPublicationName();
        books.enterGrade("Grade 12");
        books.enterEdition();
        books.enterSyllabuses("CBSE");
        books.enterBookLanguage("English");
        books.enterBookSubject("Physics");
        books.enterEmbibeBookCode();
        books.clickSave();
        books.verifyValidationMessage("×\n" +
                "Book was successfully created.");
    }
}