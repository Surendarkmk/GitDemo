package test_creation;

import base.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TestValidation extends TestBase {

    @Test(description = "Verify that system generates a validation message when clicking on save/Validate button without filling any fields.")
    @Description("Verify that system generates a validation message when clicking on save/Validate button without filling any fields.")
    public void verifyValidationMessageClickingValidateWithoutFillingData() {
        testcreation.clkTestCreation();
        testcreation.clkCreateNewTest();
        testcreation.enterTestName("Dummy");
        testcreation.selectOrganization();
        testcreation.clkExamTypeDropDown();
        testcreation.selectExam("JEE Main");
        testcreation.enterTestFormatName("Validation Assertion");
        testcreation.enterTestFormatInstructions("Instruction for JEE Mains Part Test");
        testcreation.clkValidateBtn();
        testcreation.verifyErrorMessage("");
    }

    @Test(description = "Verify error message")
    @Description("Verify error message")
    public void verifyErrorMessage(){
        testcreation.clkTestCreation();
        testcreation.clkCreateNewTest();
        testcreation.enterTestName("Dummy");
        testcreation.selectOrganization();
        testcreation.clkExamTypeDropDown();
        testcreation.selectExam("JEE Main");
        testcreation.enterTestFormatName("Validation Assertion");
        testcreation.enterTestFormatInstructions("Instruction for JEE Mains Part Test");
        testcreation.enterPhysicsQuestionId("20000209");
        testcreation.clkValidateBtn();
        testcreation.verifyErrorMessage("Question type not related to Question ID/s 20000209");
    }
}
