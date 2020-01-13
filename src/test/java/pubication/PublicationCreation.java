package pubication;

import base.TestBase;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PublicationCreation extends TestBase {

    @Test(description = "Verify \"Publication Creation\" Tab is present along with other Tabs on Left side and clickable")
    @Description("Verify \"Publication Creation\" Tab is present along with other Tabs on Left side and clickable")
    public void verifyPublicationCreationIspresentLeftside() {
        publications.openPublicaton();
        publications.verifyPublicationPageURL();
    }

    @Test(description = "Verify\"Publication Creation\" tab consists of following paramenters:")
    @Description("Verify\"Publication Creation\" tab consists of following paramenters:")
    public void verifyPublicationCreationContainsAllParamenters() {
        publications.openPublicaton();
        publications.clkAddNewPublicationBtn();
        publications.verifyAllFiledAvailable();
    }

    @Test(description = "Create New Publication")
    @Description("Create New Publication")
    public void createNewPublication() {
        publications.openPublicaton();
        publications.clkAddNewPublicationBtn();
        publications.enterUniquePublicationName(publication.getProperty("PublicationName"));
        publications.enterUniquePublicationCode(publication.getProperty("PublicationCode"));
        publications.enterPublicationDescription(publication.getProperty("PublicationDescription"));
        publications.enterPublicationAddress(publication.getProperty("PublicationAddress"));
        publications.enterPublicationContactNumber(publication.getProperty("PublicationContactNumber"));
        publications.selectPublicationCountry(publication.getProperty("PublicationCountry"));
        publications.clkSaveBtn();
        publications.verifyValidationMessage();
        publications.openRecentCreatedPublication();
        Assert.assertFalse(driver.findElement(By.id("metatagging_publication_name")).getAttribute("value").isEmpty());
        Assert.assertFalse(driver.findElement(By.id("metatagging_publication_code")).getAttribute("value").isEmpty());
        Assert.assertFalse(driver.findElement(By.id("metatagging_publication_description")).getAttribute("value").isEmpty());
        Assert.assertFalse(driver.findElement(By.id("metatagging_publication_address")).getAttribute("value").isEmpty());
        Assert.assertFalse(driver.findElement(By.id("metatagging_publication_phone_no")).getAttribute("value").isEmpty());
    }

    @Test(description = "Verify the error message by creating new publication with same name")
    @Description("Verify the error message by creating new publication with same name")
    public void createPublicationWithExistingName() {
        publications.openPublicaton();
        publications.clkAddNewPublicationBtn();
        publications.enterPublicationName("Test3 publication");
        publications.enterPublicationCode(publication.getProperty("PublicationCode"));
        publications.enterPublicationDescription(publication.getProperty("PublicationDescription"));
        publications.enterPublicationAddress(publication.getProperty("PublicationAddress"));
        publications.enterPublicationContactNumber(publication.getProperty("PublicationContactNumber"));
        publications.selectPublicationCountry(publication.getProperty("PublicationCountry"));
        publications.clkSaveBtn();
        publications.verifyErrorMessage();
    }

    @Test(description = "Verify Admin is able to enter Alphanumeric in Publication Name.")
    @Description("Verify Admin is able to enter Alphanumeric in Publication Name.")
    public void verifyAlphanumericInPublicationNameField() {
        publications.openPublicaton();
        publications.clkAddNewPublicationBtn();
        publications.enterPublicationName("12334 publication");
        publications.verifyPublicationName("12334 publication");
    }

    @Test(description = "Verify Admin is able to enter Alphanumeric in Publication Code.")
    @Description("Verify Admin is able to enter Alphanumeric in Publication Code.")
    public void verifyAlphanumericInPublicationCodeField() {
        publications.openPublicaton();
        publications.clkAddNewPublicationBtn();
        publications.enterPublicationCode("12334 Code");
        publications.verifyPublicationCode("12334 Code");
    }

    @Test(description = "Verify Admin is able to enter Alphanumeric in Publication Description.")
    @Description("Verify Admin is able to enter Alphanumeric in Publication Description.")
    public void verifyAlphanumericInPublicationDescriptionField() {
        publications.openPublicaton();
        publications.clkAddNewPublicationBtn();
        publications.enterPublicationDescription("12334 Description");
        publications.verifyPublicationDescription("12334 Description");
    }

    @Test(description = "Verify Admin is able to enter Alphanumeric in Publication Address.")
    @Description("Verify Admin is able to enter Alphanumeric in Publication Address.")
    public void verifyAlphanumericInPublicationAddressField() {
        publications.openPublicaton();
        publications.clkAddNewPublicationBtn();
        publications.enterPublicationAddress("12334 Address");
        publications.verifyPublicationAddress("12334 Address");
    }

    @Test(description = "Verify Admin is able to select the Country using the drop down box.")
    @Description("Verify Admin is able to select the Country using the drop down box.")
    public void verifyAbleToSelectCountryDropDown() {
        publications.openPublicaton();
        publications.clkAddNewPublicationBtn();
        publications.selectPublicationCountry(publication.getProperty("PublicationCountry"));
    }

    @Test(description = "Verify Admin is able to enter only numbers in Phone Number field")
    @Description("Verify Admin is able to enter only numbers in Phone Number field")
    public void verifyAbleToEnterNumbersInPhoneNumberField() {
        publications.openPublicaton();
        publications.clkAddNewPublicationBtn();
        publications.enterPublicationContactNumber("9876543210");
        publications.verifyPublicationContactNumber("9876543210");
    }
}