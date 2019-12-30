package test_cases.questions;

import base.TestBase;
import constants.TimeDelay;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompetencyTagging extends TestBase {

    @Test(description = "Verify able to add competency for the concept")
    @Description("Verify able to add competency for the concept")
    public void addCompetencyForConcept() {
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.enterPrimaryConceptCode(prop.getProperty("ConceptCodeWithCompetency"));
        waitUntilElementClickable(driver.findElement(By.className("primary-competency")));
        Assert.assertTrue(driver.findElement(By.className("primary-competency")).isDisplayed());
    }

    @Test(description = "Verify competency tab should not visible for the concept not contains competency")
    @Description("Verify competency tab should not visible for the concept not contains competency")
    public void verifyCompetencyTabShouldNotVisibleForConceptNotContainsCompetency() {
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.enterPrimaryConcept(prop.getProperty("ConceptName"));
        verifyNoElementFound(By.className("primary-competency"));
    }

    @Test(description = "Verify the competency by selecting the concept using Concept code")
    @Description("Verify the competency by selecting the concept using Concept code")
    public void verifyCompetencyBySelectingConceptUsingConceptCode() {
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.enterPrimaryConceptCode(prop.getProperty("ConceptCodeWithCompetency"));
        questions.selectCompetencyForPrimaryCompetency();
    }

    @Test(description = "Verify the competency by selecting the concept using Concept Name")
    @Description("Verify the competency by selecting the concept using Concept Name")
    public void verifyCompetencySelectionUsingConceptName() {
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.enterPrimaryConcept(prop.getProperty("ConceptNameWithCompetency"));
        questions.selectCompetencyForPrimaryCompetency();
        questions.verifyCompetencyOnPrimaryConcept();
    }

    @Test(description = "Verify by selecting the multiple competency for the concept")
    @Description("Verify by selecting the multiple competency for the concept")
    public void verifySelectMultipleCompetencyConcept() {
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.enterPrimaryConceptCode(prop.getProperty("ConceptCodeWithCompetency"));
        questions.selectCompetencyForPrimaryCompetency();
        questions.verifyCompetencyOnPrimaryConcept();
    }

    @Test(description = "Verify user should able to select competency for both primary and secondary concept")
    @Description("Verify user should able to select competency for both primary and secondary concept")
    public void verifyBySelectCompetencyForBothPrimaryAndSecondaryConcept() {
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectSingleChoiceQuestCreation();
        questions.enterPrimaryConceptCode(prop.getProperty("ConceptCodeWithCompetency"));
        questions.selectCompetencyForPrimaryCompetency();
        questions.verifyCompetencyOnPrimaryConcept();
        questions.enterSecondryConceptCode(prop.getProperty("SecondaryConceptCodeWithCompetency"));
        questions.selectCompetencyForSecondaryCompetency();
        questions.verifyCompetencyOnSecondaryConcept();
    }

    @Test(description = "Verify user can abel to select the competency for the Solution Steps")
    @Description("Verify user can abel to select the competency for the Solution Steps")
    public void verifyUserCanAbelToSelectCompetencySolutionSteps() {
        questions.clkQuestions();
        questions.clkCreateQuestion();
        questions.clkQuestionType();
        questions.selectTrueFalsQuestCreation();
        questions.enterQuestionText("Dummy question");
        questions.selectCorrectOption1();
        questions.enterStepSolutionText1();
        questions.clkBlockQuotes();
        questions.clkCreateStepButton();
        questions.enterMetaTagStepToStepNumber("1", prop.getProperty("ConceptNameWithCompetency"));
        questions.selectCompetencyForStepPrimaryCompetency("1");
    }
}