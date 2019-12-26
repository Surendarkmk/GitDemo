package test_cases.questions;

import base.TestBase;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utils.Categories;

public class QuestionCreationAllTypes extends TestBase {

    @Test(groups = {Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE, Categories.ICMS_QUESTION}, description = "Create Single Choice Question")
    @Description("Create Single choice Question")
    public void createSingleChoiceQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Multiple Choice Question")
    @Description("Create Multiple choice Question")
    public void createMultipleChoiceQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMultiChoiceQuestCreation();
        questions.multiChoiceQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Matrix Match Single Choice Question")
    @Description("Create Matrix Match choice Question")
    public void createMatrixMatchSingleChoiceQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMatrixMatchSingleChoiceQuestCreation();
        questions.singleChoiceQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create True Or False Question")
    @Description("Create True or False Question")
    public void createTrueFalseQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectTrueFalsQuestCreation();
        questions.TrueFalseQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Integer Question")
    @Description("Create Integer Question")
    public void createIntegerQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectIntegerQuestCreation();
        questions.intergerQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Subjective Numerical Question")
    @Description("Create Subjective Numerical Question")
    public void createSubjectiveNumericalQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSubjectiveNumericalQuestCreation();
        questions.subjectiveNumericalQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Subjective Answer Question")
    @Description("Create Subjective Answer Question")
    public void createSubjectiveAnswerQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSubjectiveAnswerQuestCreation();
        questions.subjectiveAnswerDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Assertion Type Question")
    @Description("Create Assertion Type Question")
    public void createAssertionQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectAssertionQuestCreation();
        questions.assertionQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Fill In The Blanks Question")
    @Description("Create Fill In The Blanks Question")
    public void createFillInTheBlanksQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectFillInTheBlanks();
        questions.fillInTheBlanksQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Multiple Fill In The Blanks Question")
    @Description("Create Multiple Fill In The Blanks Question")
    public void createMultipleFillInTheBlanksQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMultipleFillInTheBlanks();
        questions.multipleFillInTheBlanksQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Single Drop Down Question")
    @Description("Create Single Drop Down Question")
    public void createSingleDropDownQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleDropDown();
        questions.singleChoiceQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Subjective Question")
    @Description("Create Subjective Question")
    public void createSubjectiveQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSubjective();
        questions.subjectiveQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Linked Comprehension Question")
    @Description("Create Linked Comprehension Question")
    public void createLinkedComprehensionQuestion() {

        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectLinkedComprehension();
        questions.linkedComprehensionQuestionDetails();
        questions.linkedComprehensionAssociateQuestions();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();

    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Multiple Drop Down Question")
    @Description("Create Multiple Drop Down Question")
    public void createMultipleDropDownQuestion() {
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMultipleDropDown();
        questions.multipleDropDownQuestionDetails();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();
    }

    @Test(groups = {Categories.ICMS_QUESTION, Categories.ICMS_QUESTION_CREATION, Categories.ICMS_SMOKE_TEST_CASE}, description = "Create Matrix Gride Question")
    @Description("Create Matrix Gride Question")
    public void createMatrixGrideQuestion() {
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectMatrixGride();
        questions.enterQuestionText(prop.getProperty("SingleChoiceQuestionText"));
        questions.enterRowsandColumnsInMatrixGrid("4", "6");
        questions.selectCorrectAnswerMatrixGrid();
        questions.BookMetaTags();
        questions.enterHints1();
        questions.questionsMetaTag1();
        questions.QuestionLearningMaps();
        questions.clkSaveBtn();
        questions.verifyAnyErrorMessageWhileSave();
        questions.verifyQuestionIDfield();
        questions.verifyQuestionMetaDetails();
        questions.verifyVideoSolutionForSavedQuestion();
        questions.verifyQuestionLearningMaps();
    }
}