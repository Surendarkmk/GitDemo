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

    @Test(description = "Verify By clicking on Books option on Slide Bar, User should Naviagte to Books page")
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
        books.enterGrade();
        books.enterEdition();
        books.enterSyllabuses();
        books.enterBookLanguage();
        books.enterBookLanguage();
        books.enterBookSubject();
        books.enterEmbibeBookCode();
        books.clickSave();
    }
}