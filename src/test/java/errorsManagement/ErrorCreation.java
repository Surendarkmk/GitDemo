package errorsManagement;

import base.TestBase;
import constants.TimeDelay;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Categories;

public class ErrorCreation extends TestBase {

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify by creating new error for questions")
    @Description("Verify by creating new error for questions")
    public void verifyByCreatingNewError() {
        errorManagement.clickErrorManagement();
        for (int i=1; i<=10; i++){
            errorManagement.clickCreateNewError();
            errorManagement.enterErrorName("New Error - Testing Automation");
            errorManagement.clickContentTypeDropDown();
            errorManagement.enterErrorDescription("Error Description - Testing Automation");
            errorManagement.clickSubSectionDropDown();
            errorManagement.clickErrorTypeDropDown();
            errorManagement.clickErrorMultiplierDropDown();
            errorManagement.clickErrorSeverityDropDown();
            errorManagement.enterErrorDeduction("5");
            errorManagement.enterErrorMaxDeduction("10");
            errorManagement.clickSaveNewError();
        }
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify by clicking on the error management in the side bar")
    @Description("Verify by clicking on the error management in the side bar")
    public void verifyByClickingErrorManagementSideBar() {
        errorManagement.clickErrorManagement();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://new-content-admin-staging.embibe.com/errors");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify by clicking on the \"Create New Error\" button on the error management listing page")
    @Description("Verify by clicking on the \"Create New Error\" button on the error management listing page")
    public void verifyByClickingCreateNewErrorButton() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://new-content-admin-staging.embibe.com/errors/new");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify by click on the close button(X) under the Create New Error page")
    @Description("Verify by click on the close button(X) under the Create New Error page")
    public void verifyByClickCloseButtonInCreateNewError() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.closeCreateError();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://new-content-admin-staging.embibe.com/errors");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify the error message by clcking on the save without any data")
    @Description("Verify the error message by clcking on the save without any data")
    public void verifyErrorMessageBySaveWithoutAnyData() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.clickSaveNewError();
        errorManagement.getErrorMessage("One or more fields are empty");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify user should be able to enter alaphanumeric in the \"Error Name\" field")
    @Description("Verify user should be able to enter alaphanumeric in the \"Error Name\" field")
    public void verifyAbleToEnterAlaphanumericInErrorNameField() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.enterErrorName("Error922");
        errorManagement.verifyErrorName("Error922");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify the list available by clicking on the \"Content Type\" drop down.")
    @Description("Verify the list available by clicking on the \"Content Type\" drop down.")
    public void verifyListAvailableonContentTypeDropDown() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.clickContentTypeDropDown();
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify user should be able to enter alaphanumeric in the \"Error Description\" field")
    @Description("Verify user should be able to enter alaphanumeric in the \"Error Description\" field")
    public void verifyUserShouldAbleToEnterAlaphanumericInErrorDescription() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.enterErrorDescription("Error Description 1234");
        errorManagement.verifyErrorDescription("Error Description 1234");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify user should be able to select the \"Sub Section\" on the dropdown")
    @Description("Verify user should be able to select the \"Sub Section\" on the dropdown")
    public void verifyUserShouldAbleToSelectSubSectionOnTheDropdown() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.clickSubSectionDropDown();
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify user should be able to select the \"Error Type\" on the dropdown")
    @Description("Verify user should be able to select the \"Error Type\" on the dropdown")
    public void verifyUserShouldAbleToSelectErrorTypeOnTheDropdown() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.clickErrorTypeDropDown();
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify user should be able to select the \"Error Multiplier\" on the dropdown")
    @Description("Verify user should be able to select the \"Error Multiplier\" on the dropdown")
    public void verifyUserShouldAbleToSelectErrorMultiplierOnTheDropdown() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.clickErrorMultiplierDropDown();
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify user should be able to select the \"Severity\" on the dropdown")
    @Description("Verify user should be able to select the \"Severity\" on the dropdown")
    public void verifyUserShouldAbleToSelectSeverityOnTheDropdown() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.clickErrorSeverityDropDown();
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify by entering the alaphebets in the \"Deduction\" box")
    @Description("Verify by entering the alaphebets in the \"Deduction\" box")
    public void verifyEnteringAlaphebetsInDeductionbox() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.enterErrorDeduction("Alpha");
        errorManagement.verifyErrorDeduction("");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify by entering the negative values in the \"Deduction\" tab")
    @Description("Verify by entering the negative values in the \"Deduction\" tab")
    public void verifyEnteringNegativeValuesInDeduction() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.enterErrorDeduction("-1");
        errorManagement.verifyErrorDeduction("1");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify by entering the numerical value in the deduction tab")
    @Description("Verify by entering the numerical value in the deduction tab")
    public void verifyEnteringNumericalValueDeduction() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.enterErrorDeduction("87");
        errorManagement.verifyErrorDeduction("87");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify by entering the alaphebets in the \"Max Deduction\" box")
    @Description("Verify by entering the alaphebets in the \"Max Deduction\" box")
    public void verifyEnteringAlaphebetsInMaxDeductionbox() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.enterErrorMaxDeduction("Alpha");
        errorManagement.verifyErrorMaxDeduction("");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify by entering the negative values in the \"Max Deduction\" tab")
    @Description("Verify by entering the negative values in the \"Deduction\" tab")
    public void verifyEnteringNegativeValuesInMaxDeduction() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.enterErrorMaxDeduction("-1");
        errorManagement.verifyErrorMaxDeduction("1");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify by entering the numerical value in the Max deduction tab")
    @Description("Verify by entering the numerical value in the deduction tab")
    public void verifyEnteringNumericalValueMaxDeduction() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreateNewError();
        errorManagement.enterErrorMaxDeduction("87");
        errorManagement.verifyErrorMaxDeduction("87");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify the error management listing page")
    @Description("Verify the error management listing page")
    public void verifyErrorManagementListingPage() {
        errorManagement.clickErrorManagement();
        errorManagement.verifyListingPageAvailable();
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify the search using ID with the valid data")
    @Description("Verify the search using ID with the valid data")
    public void verifySearchUsingIDWithValidData() {
        errorManagement.clickErrorManagement();
        errorManagement.enterErrorCode("ERR00001");
        errorManagement.clickSearch();
        errorManagement.verifyListingPageAvailable();
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify the search using ID with the Invalid data")
    @Description("Verify the search using ID with the valid data")
    public void verifySearchUsingInvalidID() {
        errorManagement.clickErrorManagement();
        errorManagement.enterErrorCode("ERR00001");
        errorManagement.clickSearch();
        errorManagement.verifyListingPageNotAvailable();
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify the search Created ")
    @Description("Verify the search Creator ")
    public void verifySearchCreated() {
        errorManagement.clickErrorManagement();
        errorManagement.clickCreatorInField();
        errorManagement.clickSearch();
        errorManagement.verifyCreatedBy("CG01 Automation");
    }

    @Test(groups = {Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_ERRORMANAGEMENT}, description = "Verify by Open already created Error from the listing page")
    @Description("Verify by Open already created Error from the listing page")
    public void verifyByOpenAlreadyCreatedErrorListingPage() {
        errorManagement.clickErrorManagement();
        errorManagement.openRecentError();
    }
}
