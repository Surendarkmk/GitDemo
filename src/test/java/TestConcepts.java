import base.TestBase;
import constants.TimeDelay;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestConcepts extends TestBase {

    @Test(description = "Verify User is navigated to Concepts Listing Page on Clicking Concepts Button")
    @Description("Verify User is navigated to Concepts Listing Page on Clicking Concepts Button")
    public void verifyUserAbleToNavigatedConceptsListingPage() {
        concepts.clickConcept();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://new-content-admin-staging.embibe.com/concepts");
    }

    @Test(description = "Verify User is navigated to Create New Concept Page on clicking on Click New Concept button")
    @Description("Verify User is navigated to Create New Concept Page on clicking on Click New Concept button")
    public void VerifyUserAbleToNavigatedNewConceptPage() {
        concepts.clickConcept();
        concepts.clkCreateConcept();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://new-content-admin-staging.embibe.com/concepts/new");
    }

    @Test(description = "Verify Preview Button is enabled after user fills in Concept Description and Concept Name Button")
    @Description("Verify Preview Button is enabled after user fills in Concept Description and Concept Name Button")
    public void VerifyPreviewButtonEnabledAfterFillsDescriptionAndName() {
        concepts.clickConcept();
        concepts.clkCreateConcept();
        delayTime(TimeDelay.TIME_5000S);
        concepts.enterConceptName();
        //delayTime(TimeDelay.TIME_2000S);
        concepts.enterConceptDescription();
        concepts.verifyConceptName();
        concepts.clkStatus();
        concepts.selectActive();
        concepts.clkAddVideoLink();
        concepts.enterlinkVideo();
        concepts.clkPreviewVideo();
        concepts.clkSelectVideoLink();
        concepts.clkSaveBtn();
    }
}