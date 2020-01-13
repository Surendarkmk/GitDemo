package questions;

import base.TestBase;
import constants.TimeDelay;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Categories;

public class Questions_Creation extends TestBase {

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify clicking on Create New Question, page should open to create new question")
    @Description("Verify clicking on Create New Question, page should open to create new question")
    public void verifyClickingOnCreateNewQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://new-content-admin-staging.embibe.com/questions/new");

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify by default Curator name appears in the curator text box.")
    @Description("Verify by default Curator name appears in the curator text box.")
    public void defaultCuratorNameAppearsInTheCuratorTextBox() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        delayTime(TimeDelay.TIME_3000S);
        questions.verifyCuratorName();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to select the required Partner name,under create question.")
    @Description("Verify user should be able to select the required Partner name,under create question.")
    public void selectTheRequiredPartnerName() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.selectPartner("imagin8ors");
        questions.verifyPartnerName();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user is  able to enter the question text under the Question Details.")
    @Description("Verify user is  able to enter the question text under the Question Details.")
    public void enterQuestionTextUnderQuestionDetails() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.enterQuestionText(prop.getProperty("SingleChoiceQuestionText"));

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to enter the option under option and mark it correct/incorrect")
    @Description("Verify user should be able to enter the option under option and mark it correct/incorrect")
    public void enterOptionUnderOptionAndMarkItCorrectOrIncorrect() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.enterOptionText1(prop.getProperty("option1"));
        questions.enterOptionText2(prop.getProperty("MultiChoiceAnserText"));
        questions.enterSolutionText1();
        questions.selectCorrectOption1();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should not be able to save the question until the solution is provided for the question.")
    @Description("Verify user should not be able to save the question until the solution is provided for the question.")
    public void userShouldNotAbleToSaveTheQuestionWithoutSolution() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.enterQuestionText(prop.getProperty("SingleChoiceQuestionText"));
        questions.enterOptionText1(prop.getProperty("option1"));
        questions.selectCorrectOption1();
        questions.enterOptionText2(prop.getProperty("MultiChoiceAnserText"));
        questions.removeOption3and4();
        questions.clkSaveBtn();
        questions.verifyErrorMessage(prop.getProperty("ErrorMessageWithoutSolution"));

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should not be able to save the question until the Answer Option is provided for the question.")
    @Description("Verify user should not be able to save the question until the Answer Option is provided for the question.")
    public void verifyUserShouldNotAbleToSaveQuestionUntilAnswerOptionProvided() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        delayTime(TimeDelay.TIME_2000S);
        questions.enterQuestionText(prop.getProperty("SingleChoiceQuestionText"));
        questions.enterOptionText1(prop.getProperty("option1"));
        questions.selectCorrectOption1();
        questions.clkSaveBtn();
        questions.verifyErrorMessage(prop.getProperty("ErrorMessageWithoutAnswerOption"));

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to select the question Meta Tags, under create question.")
    @Description("Verify user should be able to select the question Meta Tags, under create question.")
    public void ableToSelectQuestionMetaTags() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.questionsMetaTag1();
        questions.verifyQuestionMetaDetails();
        //questions.verifyVideoSolutionForUnsavedQuestion();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to Search and Select the concept using concept code")
    @Description("Verify user should be able to Search and Select the concept using concept code")
    public void ableToSearchAndSelectConceptUsingConceptCode() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.enterPrimaryConceptCode(prop.getProperty("ConceptCode"));
        questions.enterSecondryConceptCode(prop.getProperty("SecondaryConceptCode"));
        questions.verifyPrimaryConcept();
        questions.verifySecondaryConcept();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to add multiple secondary concept under Question Meta Tag.")
    @Description("Verify user should be able to add multiple secondary concept under Question Meta Tag.")
    public void ableToAddMultipleSecondaryConceptQuestionMetaTag() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.singleChoiceQuestionDetails();
        questions.enterPrimaryConcept(prop.getProperty("ConceptName"));
        questions.enterSecondryConcept();
        questions.enterSecodaryConcept2();
        questions.enterSecodaryConcept3();
        questions.clkSaveBtn();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to remove the secondary concept added, and the latest secondary concept should be removed under question meta tag.")
    @Description("Verify user should be able to remove the secondary concept added, and the latest secondary concept should be removed under question meta tag.")
    public void ableToRemoveSecondaryConceptAdded() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.enterPrimaryConcept(prop.getProperty("ConceptName"));
        questions.enterSecondryConcept();
        questions.enterSecodaryConcept2();
        questions.enterSecodaryConcept3();
        questions.removeSecondaryConcept();
        questions.removeSecondaryConcept();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to save the question without Hint, under question meta tag.")
    @Description("Verify user should be able to save the question without Hint, under question meta tag.")
    public void ableToSaveTheQuestionWithoutHint() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.clkSaveBtn();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to add hint to the question , under question meta tag.")
    @Description("Verify user should be able to add hint to the question , under question meta tag.")
    public void ableToAddHintToQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.enterHints1();
        questions.clkSaveBtn();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to add multiple hint for the questions.")
    @Description("Verify user should be able to add multiple hint for the questions.")
    public void ableToAddMultipleHintForQuestions() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.enterHints1();
        questions.enterHint2();
        questions.clkSaveBtn();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify validation message appears if user save the question with blank hint.")
    @Description("Verify validation message appears if user save the question with blank hint.")
    public void verifyValidationMessageSaveQuestionWithBlankHint() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.clkAddHints();
        questions.clkSaveBtn();
        questions.verifyErrorMessage(prop.getProperty("ErrorMessageWithBlankHint"));

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to add a video under video solution.")
    @Description("Verify user should be able to add a video under video solution.")
    public void ableToAddVideoUnderVideoSolution() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMultiChoiceQuestCreation();
        questions.multiChoiceQuestionDetails();
        questions.clkAddVideoLinkBtn();
        questions.enterVideoLink(prop.getProperty("validVideoLink"));
        questions.clkVideoPreview();
        questions.clkSelectVideoLink();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify validation message appear when user load a invalid video.")
    @Description("Verify validation message appear when user load a invalid video.")
    public void validateMessageAppearWhenLoadInvalidVideo() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMultiChoiceQuestCreation();
        questions.multiChoiceQuestionDetails();
        questions.clkAddVideoLinkBtn();
        questions.enterVideoLink(prop.getProperty("InvalidVideoLink"));
        questions.clkVideoPreview();
        questions.verifyInvalidLinkOnVideoSolution();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to save question without video.")
    @Description("Verify user should be able to save question without video.")
    public void userShouldAbleToSaveQuestionWithoutVideo() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectIntegerQuestCreation();
        questions.intergerQuestionDetails();
        questions.clkAddVideoLinkBtn();
        questions.enterVideoLink(prop.getProperty("validVideoLink"));
        questions.clkVideoPreview();
        questions.clkSelectVideoLink();
        questions.clkSaveBtn();
        delayTime(TimeDelay.TIME_5000S);
        questions.verifyVideoSolutionForSavedQuestion();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify when user search topic and clicks on Done, then all the text box under Question learning maps is autofilled with correct data.")
    @Description("Verify when user search topic and clicks on Done, then all the text box under Question learning maps is autofilled with correct data.")
    public void searchTopicAndClicksDoneVerifyAllTextBoxIsAutofilled() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectIntegerQuestCreation();
        questions.intergerQuestionDetails();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        delayTime(TimeDelay.TIME_10000S);
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify when all the manditory field is filled and clicked on save button, the question should be created and a unquie code number should be created.")
    @Description("Verify when all the manditory field is filled and clicked on save button, the question should be created and a unquie code number should be created.")
    public void questionShouldCreateQuestionIDNumber() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMatrixMatchSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.clkSaveBtn();
        questions.verifyQuestionIDfield();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify by default the version number should be 1 and Curator name must be displayed with change and action column.")
    @Description("Verify by default the version number should be 1 and Curator name must be displayed with change and action column.")
    public void versionNumberShould1AndCuratorNameMustDisplayed() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMatrixMatchSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.clkSaveBtn();
        delayTime(TimeDelay.TIME_5000S);
        questions.verifyVersionChange("1");
        questions.verifyVersionEditorName(prop.getProperty("UserName"));

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify user should be able to edit the question created.")
    @Description("Verify user should be able to edit the question created.")
    public void userShouldAbleToEditQuestionCreated() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSubjectiveAnswerQuestCreation();
        questions.subjectiveAnswerDetails();
        questions.clkSaveBtn();
        questions.verifyQuestionIDfield();
        questions.enterQuestionText(" Add data");
        questions.clkSaveBtn();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify each time the question is edited new version number is added")
    @Description("Verify each time the question is edited new version number is added")
    public void eachTimeQuestionEditedNewVersionNumberAdded() {
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSubjectiveAnswerQuestCreation();
        questions.subjectiveAnswerDetails();
        questions.clkSaveBtn();
        questions.verifyQuestionIDfield();
        questions.enterQuestionText(" Add data");
        questions.clkSaveBtn();
        questions.verifyVersionChange("2");
        questions.verifyVersionEditorName(prop.getProperty("UserName"));
    }


    //This Test case has to be run after question has more than 1 secondary concept
    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify if user removes or delete any data from the question while edit, the question must get updated accordingly and version number should be added.")
    @Description("Verify if user removes or delete any data from the question while edit, the question must get updated accordingly and version number should be added.")
    public void removesAnyDataEditVersionNumberShouldUpdated() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.enterPrimaryConcept(prop.getProperty("ConceptName"));
        questions.enterSecondryConcept();
        questions.enterSecodaryConcept2();
        questions.enterSecodaryConcept3();
        questions.clkSaveBtn();
        questions.verifyQuestionIDfield();
        questions.removeSecondaryConcept();
        questions.clkSaveBtn();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify if user able to find the duplicate questions by clicking on \"deduplication\"")
    @Description("Verify if user able to find the duplicate questions by clicking on \"deduplication\"")
    public void ableToFindDuplicateQuestionsByDeduplication() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectIntegerQuestCreation();
        questions.intergerQuestionDetails();
        questions.clkDupication();
        delayTime(TimeDelay.TIME_3000S);
        questions.closeDuplication();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify if user able to do smartTag for JEE main question type with question details")
    @Description("Verify if user able to do smartTag for JEE mainquestion type with question details")
    public void ableToSmartTagJEEmainQuestionTypeQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.selectSmartTaggingJEEmain();
        questions.clkSmartTagButton();
        delayTime(TimeDelay.TIME_5000S);
        questions.verifyDifficultyLevel();
        questions.verifyPrimaryConcept();
        questions.verifySecondaryConcept();
        questions.verifySecondaryConcept2();
        questions.verifyIdealTime();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify if user able to do smartTag for NEET question type with question details")
    @Description("Verify if user able to do smartTag for NEET question type with question details")
    public void ableToSmartTagNEETQuestionTypeQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.selectSmartTaggingNEET();
        questions.clkSmartTagButton();
        delayTime(TimeDelay.TIME_5000S);
        questions.verifyDifficultyLevel();
        questions.verifyPrimaryConcept();
        questions.verifySecondaryConcept();
        questions.verifySecondaryConcept2();
        questions.verifyIdealTime();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify error message if click on smartTag without question details")
    @Description("Verify error message if click on smartTag without question details")
    public void errorMessageClickSmartTagWithoutQuestionDetails() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.selectSmartTaggingJEEmain();
        questions.clkSmartTagButton();
        questions.verifyErrorMessage(prop.getProperty("ErrorMessageWithoutQuestionDetails"));

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify error message if click on smartTag without Option details")
    @Description("Verify error message if click on smartTag without Option details")
    public void errorMessageClickSmartTagWithoutOptionDetails() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.enterQuestionText(prop.getProperty("SingleChoiceQuestionText"));
        questions.selectSmartTaggingJEEmain();
        questions.clkSmartTagButton();
        questions.verifyErrorMessage(prop.getProperty("ErrorMessageWithoutAnswerOption"));

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify error message if click on smartTag without selecting correct Option")
    @Description("Verify error message if click on smartTag without selecting correct Option")
    public void errorMessageClickSmartTagWithoutSelectingCorrectOption() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectTrueFalsQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.enterQuestionText(prop.getProperty("SingleChoiceQuestionText"));
        questions.selectSmartTaggingJEEmain();
        questions.clkSmartTagButton();
        questions.verifyErrorMessage(prop.getProperty("ErrorMessageWithoutSelectingAnswerOption"));

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION}, description = "Verify error message if click on smartTag without entering solution for question")
    @Description("Verify error message if click on smartTag without entering solution for question")
    @Story("Questions : Smart Tagging")
    public void errorMessageClickSmartTagWithoutEnteringSolution() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectTrueFalsQuestCreation();
        questions.waitForQuestionEditorEnable();
        questions.enterQuestionText(prop.getProperty("SingleChoiceQuestionText"));
        questions.selectCorrectOption1();
        questions.selectSmartTaggingJEEmain();
        questions.clkSmartTagButton();
        questions.verifyErrorMessage(prop.getProperty("ErrorMessageWithoutSolution"));

    }
}