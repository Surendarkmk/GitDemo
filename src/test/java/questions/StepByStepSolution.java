package questions;

import base.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class StepByStepSolution extends TestBase {

    @Test(description = "Verify user should be able to see \"Create Step\" button once select answer as correct")
    @Description("Verify user should be able to see \"Create Step\" button once select answer as correct")
    public void ableToSeeCreateStepButtonOnceSelectAnswerAsCorrect(){
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.verifyStepButton();
    }

    @Test(description = "Verify user should not allowed to create step with empty solution")
    @Description("Verify user should not allowed to create step with empty solution")
    public void VerifyUserShouldNotAllowedToCreateStepWithEmptySolution(){
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.selectCorrectOption1();
        questions.clkCreateStepButton();
        questions.verifyErrorMessage(prop.getProperty("errorMessageWithEmptySolution"));
    }

    @Test(description = "Verify user should not allowed to create step without selecting Block Quotes")
    @Description("Verify user should not allowed to create step without selecting Block Quotes")
    public void shouldNotAllowedToCreateStepWithoutSelectingBlockQuotes(){
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.clkCreateStepButton();
        questions.verifyErrorMessage(prop.getProperty("ErrorMessageWithOutSelectingBlockQuotes"));
    }

    @Test(description = "Verify user should be able to create Step by step solution by click on Create Step")
    @Description("Verify user should be able to create Step by step solution by click on Create Step")
    public void shouldAbleToCreateStepByClickOnCreateStep() {
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMultiChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.enterQuestionText(prop.getProperty("MultipleFillInTheBlanksQuestionText"));
        questions.selectCorrectOption1();
        questions.enterOptionText1(prop.getProperty("MultipleFillInTheBlanksAnswer1"));
        questions.enterStepSolutionText1();
        questions.clkBlockQuotes();
        questions.clkCreateStepButton();
        questions.verifyStepsCount("1");
    }

    @Test (description = "Verify user should not be allowed to create Step unless all content marked in Block Quotes ")
    @Description("Verify user should not be allowed to create Step unless all content marked in Block Quotes ")
    public void shouldNotAllowedToCreateStepUnlessAllContentMarkedInBlockQuotes(){
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMultiChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.enterQuestionText(prop.getProperty("MultipleFillInTheBlanksQuestionText"));
        questions.selectCorrectOption1();
        questions.enterOptionText1(prop.getProperty("MultipleFillInTheBlanksAnswer1"));
        questions.enterStepSolutionText1();
        questions.clkBlockQuotes();
        questions.enterStepSolutionText1();
        questions.clkCreateStepButton();
        questions.verifyErrorMessage(prop.getProperty("ErrorMessageWithOutSelectingBlockQuotes"));
    }

    @Test (description = "Verify user should able to remove the Steps created by removing the Block Quotes and content")
    @Description("Verify user should able to remove the Steps created by removing the Block Quotes and content")
    public void ableToRemoveStepsCreated(){
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMultiChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.enterQuestionText(prop.getProperty("MultipleFillInTheBlanksQuestionText"));
        questions.selectCorrectOption1();
        questions.enterOptionText1(prop.getProperty("MultipleFillInTheBlanksAnswer1"));
        questions.enterStepSolutionText1();
        questions.clkBlockQuotes();
        questions.enterStepSolutionText1();
        questions.clkBlockQuotes();
        questions.clkCreateStepButton();
        questions.removeStep();
        questions.clkBlockQuotes();
        questions.clkCreateStepButton();
    }

    @Test(description = "Verify user Steps should remain the same after Editing by clicking on Retain tag")
    @Description("Verify user Steps should remain the same after Editing by clicking on Retain tag")
    public void verifyUserStepsRemainSameAfterEditing(){
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectTrueFalsQuestCreation();
        questions.enterQuestionText("Dummy question");
        questions.selectCorrectOption1();
        questions.enterStepSolutionText1();
        questions.clkBlockQuotes();
        questions.clkCreateStepButton();
        questions.enterMetaTagStepToStepNumber("1", prop.getProperty("ConceptName"));
        questions.clkLearningMapOnStepNumber("1");
        questions.enterTopicOnStepNumber("1");
        questions.enterStepSolutionText1();
        questions.clkCreateStepButton();
    }

    @Test()
    public void verify(){
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.enterQuestionText("Steps Testing");
        questions.enterOptionText1("Option Text 1");
        questions.selectCorrectOption1();
        questions.enterStepSolutionText1();
        questions.clkBlockQuotes();
        /*questions.enterStepSolutionText1();
        questions.clkBlockQuotes();*/
        questions.clkCreateStepButton();
        questions.enterMetaTagStepToStepNumber("1", prop.getProperty("ConceptName"));
        questions.clkLearningMapOnStepNumber("1");
        questions.enterTopicOnStepNumber("1");
        questions.clkHintsOnStepNumber("1");
        questions.enterHintsOnStep("1");
        questions.clkMarksOnStepNumber("1");
        questions.enterMarksForStep("1");
       /* questions.enterMetaTagStepToStepNumber("2");
        questions.clkLearningMapOnStepNumber("2");
        questions.enterTopicOnStepNumber("2");
        questions.clkHintsOnStepNumber("2");
        questions.enterHintsOnStep("2");
        questions.clkMarksOnStepNumber("2");
        questions.enterMarksForStep("2");*/
        questions.enterOptionText2("Option Text 2");
        questions.removeOption3and4();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyQuestionIDfield();
    }
}
