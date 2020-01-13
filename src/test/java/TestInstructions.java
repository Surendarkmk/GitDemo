import base.TestBase;
import org.testng.annotations.Test;


public class TestInstructions extends TestBase {

    @Test(priority = 1)
    public void searchByValidInstructionID() {

        objinstructions.clkInstructions();
        objinstructions.verifyListingPage();
        objinstructions.instructionSearchId("1324");
        objinstructions.clkSearch();
        objinstructions.verifyListingPage();

    }

    @Test(priority = 2)
    public void searchByInvalidInstructionID() {

        objinstructions.clkInstructions();
        objinstructions.verifyListingPage();
        objinstructions.instructionSearchId("13203");
        objinstructions.clkSearch();
        delayTime(TIME_4000S);
        objinstructions.verifyListingPageNoData();

    }

    @Test(priority = 3)
    public void searchByValidName() {

        objinstructions.clkInstructions();
        objinstructions.verifyListingPage();
        objinstructions.instructionSearchName("Test");
        objinstructions.clkSearch();
        objinstructions.verifyListingPage();

    }

    @Test(priority = 4)
    public void searchByValidNameandId() {

        objinstructions.clkInstructions();
        objinstructions.verifyListingPage();
        objinstructions.instructionSearchId("1326");
        objinstructions.instructionSearchName("Automation");
        objinstructions.clkSearch();
        objinstructions.verifyListingPage();

    }


    @Test(priority = 5)
    public void searchByInvalidNameandID() {

        objinstructions.clkInstructions();
        objinstructions.verifyListingPage();
        objinstructions.instructionSearchName("Test0001");
        objinstructions.instructionSearchId("13203");
        objinstructions.clkSearch();
        delayTime(TIME_4000S);
        objinstructions.verifyListingPageNoData();

    }

    @Test(priority = 6)
    public void searchByInvalidName() {

        objinstructions.clkInstructions();
        objinstructions.verifyListingPage();
        objinstructions.clearIdandName();
        objinstructions.instructionSearchName("Test0001");
        objinstructions.clkSearch();
        delayTime(TIME_2000S);
        objinstructions.verifyListingPageNoData();

    }

    @Test(priority = 7)
    public void CloseCreateInstruction() {

        objinstructions.clkInstructions();
        objinstructions.verifyListingPage();
        objinstructions.clkCreateNewInstruction();
        objinstructions.closeNewInstruction();
        objinstructions.verifyListingPage();

    }

    @Test(priority = 8)
    public void CreateNewInstruction() {

        objinstructions.clkInstructions();
        objinstructions.clkCreateNewInstruction();
        delayTime(TIME_4000S);
        objinstructions.EnterNewInstructionsName();
        delayTime(TIME_2000S);
        objinstructions.enterInstructionText();
        objinstructions.clkSaveInstructions();
        objinstructions.savedMsg();

    }

    @Test(priority = 9)
    public void CreateInstructionWithoutName() {

        objinstructions.clkInstructions();
        objinstructions.clkCreateNewInstruction();
        objinstructions.clkSaveInstructions();
        objinstructions.verifyErrorMsg();

    }

    @Test(priority = 10)
    public void CreateInstructionWithoutContent() {

        objinstructions.clkInstructions();
        objinstructions.clkCreateNewInstruction();
        objinstructions.EnterNewInstructionsName();
        objinstructions.clkSaveInstructions();
        objinstructions.verifyErrorMsg();

    }

    // Still error message while clicking on save with empty Name or instructions has not been validated.

    @Test(priority = 11)
    public void OpenAlreadySavedInstructions() {

        objinstructions.clkInstructions();
        objinstructions.clkInstructionSaved();

    }

    @Test(priority = 12)      //Will be updating the recent saved instruction
    public void UpdateAlreadySavedInstructions() {

        objinstructions.clkInstructions();
        objinstructions.clkInstructionSaved();
        delayTime(TIME_4000S);
        objinstructions.updateInstructionName();
        delayTime(TIME_2000S);
        objinstructions.updateInstructionText();
        objinstructions.clkSaveInstructions();
        objinstructions.updatedMsg();

    }
}