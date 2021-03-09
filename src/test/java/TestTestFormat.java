import base.TestBase;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestTestFormat extends TestBase {

    ////////// Testing Format Creation /////////////

    @Test (description = "Verify by click on \"Create New Testing Format\"")
    @Description("Verify by click on \"Create New Testing Format\"")
    public void clkCreateNewTestFormat(){
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        delayTime(TIME_1000S);
        Assert.assertEquals(driver.getCurrentUrl(),"https://new-content-admin-staging.embibe.com/test/format/new");
    }

    @Test (description = "Verify by clicking on close icon in Create new Testing format")
    @Description("Verify by clicking on close icon in Create new Testing format")
    public void clkCloseIconInCreateTestFormat(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.clkCloseTestFormat();
        Assert.assertEquals(driver.getCurrentUrl(),"https://new-content-admin-staging.embibe.com/test/format");
        
    }

    @Test (description = "Verify by clicking on save button without filling the details")
    @Description("Verify by clicking on save button without filling the details")
    public void clkSaveWithoutAnyInput(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.verifySaveButtonEnable();
        
    }

    @Test (description = "Verify by creating the Testing format in same Name")
    @Description("Verify by creating the Testing format in same Name")
    public void createTestFormatInSameName(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterTestFormatName(prop.getProperty("ExistingTestFormatName"));
        testformat.enterFormatMark("360");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        testformat.clkTestType();
        testformat.selectFullTest();
        delayTime(TIME_2000S);
        testformat.enterJEEmainMathematics();
        testformat.enterJEEmainPhysics();
        testformat.enterJEEmainChemistry();
        testformat.clkSave();
        delayTime(TIME_2000S);
        Assert.assertEquals(driver.findElement(By.id("client-snackbar")).getText(),"Testing format name already exists");
        
    }

    @Test (description = "Verify by giving Duration greater dhan 600 Minutes and save")
    @Description("Verify by giving Duration greater dhan 600 Minutes and save")
    public void enterDurationGreaterThan600Mins(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterTestFormatName(prop.getProperty("ExistingTestFormatName"));
        testformat.enterFormatMark("360");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        testformat.clkTestType();
        testformat.selectFullTest();
        testformat.clkSubject1();
        testformat.setSubject1Duration(prop.getProperty("TestFormatDurationGreaterThen600Minutes"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error-status']")).getText(),"enter value less than or equal to 600");
        
    }

    @Test (description = "Verify by clicking save without entering Marking scheme to create new format")
    @Description("Verify by clicking save without entering Marking scheme to create new format")
    public void createTestFormatWithOutMarkScheme(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName(prop.getProperty("ExistingTestFormatName"));
        testformat.enterFormatMark(prop.getProperty("TestFormatMaximumMark"));
        testformat.clkSelectExam();
        testformat.enterExam("JEE Adv");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectparttest();
        delayTime(TIME_2000S);
        testformat.verifyMathematics();
        testformat.clkSubject1();
        testformat.setSubject1Duration(prop.getProperty("TestFormatDurationGreaterThen600Minutes"));
        testformat.ClkAddQuestType11();
        delayTime(TIME_2000S);
        testformat.clkQuestionType11();
        delayTime(TIME_2000S);
        testformat.selectSingleChoice();
        delayTime(TIME_2000S);
        testformat.enterQuestCount11(prop.getProperty("JEEmainMathematicsQuestionCount1"));
        delayTime(TIME_2000S);
        testformat.clkSave();
        delayTime(TIME_1000S);
        Assert.assertEquals(driver.findElement(By.id("client-snackbar")).getText(),"Max marks should be equal to product of no.of questions and positive marks");
        
    }

    @Test (description = "Verify if user select full test/ mini test/live test and try to select only 1 subject")
    @Description("Verify if user select full test/ mini test/live test and try to select only 1 subject")
    public void selectOneSubjectForFullTest(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("NEET Full Testing (Single Choice, Integer and Matrix Grid) ");
        testformat.enterFormatMark(prop.getProperty("NEETtotalMark"));
        testformat.clkSelectExam();
        testformat.enterExam("NEET");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectFullTest();
        delayTime(TIME_4000S);
        testformat.unselectNEETChemistyPhysics();
        testformat.selectNEETBilogy();
        testformat.enterNEETBiology();
        testformat.clkSave();
        // Verify the saved data
        
    }

    @Test (description = "Verify by creating the Testing format with \"Duration\" 0 mins")
    @Description("Verify by creating the Testing format with \"Duration\" 0 mins")
    public void createTestFormatWithDuration0Mins(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterTestFormatName(prop.getProperty("TestFormatName"));
        testformat.enterFormatMark(prop.getProperty("NEETtotalMark"));
        testformat.clkSelectExam();
        testformat.enterExam("NEET");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectparttest();
        delayTime(TIME_4000S);
        testformat.selectNEETBilogy();
        testformat.clkSubject1();
        testformat.setSubject1Duration(prop.getProperty("Duration"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error-status']")).getText(),"enter value less than or equal to 600");
        
    }

    @Test(description = "Actual JEE main Full Testing Format")
    @Description("Full Testing")
    public void createJEEmainFullTestFormatwithSingleChoice(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Main Full Testing ");
        testformat.enterFormatMark("360");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        testformat.clkTestType();
        testformat.selectFullTest();
        delayTime(TIME_2000S);
        testformat.enterJEEmainMathematics();
        testformat.enterJEEmainPhysics();
        testformat.enterJEEmainChemistry();
        testformat.clkSave();
        delayTime(TIME_6000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        testformat.verifyJEEmainMathematics();
        testformat.verifyJEEmainPhysics();
        testformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main Live Testing Format")
    @Description("Live Testing")
    public void createJEEmainLiveTestFormatwithSingleChoice(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Main Live Testing ");
        testformat.enterFormatMark("360");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        testformat.clkTestType();
        testformat.selectlivetest();
        delayTime(TIME_2000S);
        testformat.enterJEEmainMathematics();
        testformat.enterJEEmainPhysics();
        testformat.enterJEEmainChemistry();
        testformat.clkSave();
        delayTime(TIME_6000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        testformat.verifyJEEmainMathematics();
        testformat.verifyJEEmainPhysics();
        testformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main Previous Year Testing Format")
    @Description("Previous Year Testing")
    public void createJEEmainPreviousYearFormatwithSingleChoice(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Main Previous Year Testing ");
        testformat.enterFormatMark("360");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        testformat.clkTestType();
        testformat.selectpreviousyeartest();
        delayTime(TIME_2000S);
        testformat.enterJEEmainMathematics();
        testformat.enterJEEmainPhysics();
        testformat.enterJEEmainChemistry();
        testformat.clkSave();
        delayTime(TIME_6000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        testformat.verifyJEEmainMathematics();
        testformat.verifyJEEmainPhysics();
        testformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main 11th Revision Testing Format")
    @Description("11th Revision Testing")
    public void createJEEmain11thRevisionFormatwithSingleChoice(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Main 11th Revision Testing ");
        testformat.enterFormatMark("360");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        testformat.clkTestType();
        testformat.selecteleventhrevision();
        delayTime(TIME_2000S);
        testformat.enterJEEmainMathematics();
        testformat.enterJEEmainPhysics();
        testformat.enterJEEmainChemistry();
        testformat.clkSave();
        delayTime(TIME_6000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        testformat.verifyJEEmainMathematics();
        testformat.verifyJEEmainPhysics();
        testformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main Mini Testing Format")
    @Description("Mini Testing")
    public void createJEEmainMiniTestFormatwithSingleChoice(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Main Mini-Testing ");
        testformat.enterFormatMark("360");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectminitest();
        delayTime(TIME_2000S);
        testformat.enterJEEmainMathematics();
        testformat.enterJEEmainPhysics();
        testformat.enterJEEmainChemistry();
        testformat.clkSave();
        delayTime(TIME_6000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        testformat.verifyJEEmainMathematics();
        testformat.verifyJEEmainPhysics();
        testformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main PartTest Format")
    @Description("Part Testing - Mathematics")
    public void createJEEmainMathematicsPartTestFormatwithSingleChoice() {
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Main Part-Testing ");
        testformat.enterFormatMark("120");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectparttest();
        delayTime(TIME_5000S);
        testformat.selectMathematics();
        delayTime(TIME_2000S);
        testformat.clkSave();
        delayTime(TIME_6000S);
        testformat.openNewlyCreatedFormat();
        testformat.verifyJEEmainMathematics();
        
    }

    @Test(description = "Actual JEE main PartTest Format")
    @Description("Part Testing - Physics")
    public void createJEEmainPhysicsPartTestFormatwithSingleChoice() {
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Main Part-Testing ");
        testformat.enterFormatMark("120");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectparttest();
        testformat.selectPhysics();
        delayTime(TIME_2000S);
        testformat.clkSave();
        delayTime(TIME_6000S);
        testformat.openNewlyCreatedFormat();
        testformat.verifyJEEmainPhysics();
        
    }

    @Test(description = "Actual JEE main PartTest Format")
    @Description("Part Testing - Chemistry")
    public void createJEEmainChemistryPartTestFormatwithSingleChoice() {
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Main Part-Testing ");
        testformat.enterFormatMark("120");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_4000S);
        testformat.clkTestType();
        testformat.selectparttest();
        delayTime(TIME_2000S);
        testformat.selectChemistry();
        testformat.clkSave();
        delayTime(TIME_6000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_2000S);
        testformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main Chapterwise Format")
    @Description("Chapterwise Testing - Mathematics")
    public void createJEEmainMathematicsChapterTestFormatwithSingleChoice() {
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Main ChapterWise ");
        testformat.enterFormatMark("120");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectchapterwisetest();
        delayTime(TIME_2000S);
        testformat.selectMathematics();
        testformat.clkSave();
        delayTime(TIME_10000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        testformat.verifyJEEmainMathematics();
        
    }

    @Test(description = "Actual JEE main Chapterwise Testing Format")
    @Description("Chapterwise Testing - Physics")
    public void createJEEmainPhysicsChapterTestFormatwithSingleChoice() {
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Main Chapter ");
        testformat.enterFormatMark("120");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        testformat.clkTestType();
        testformat.selectchapterwisetest();
        delayTime(TIME_2000S);
        testformat.selectPhysics();
        testformat.clkSave();
        delayTime(TIME_6000S);
        testformat.openNewlyCreatedFormat();
        testformat.verifyJEEmainPhysics();
        
    }

    @Test(description = "Actual JEE main Chapterwise Format")
    @Description("Chapterwise Testing - Chemistry")
    public void createJEEmainChemistryChapterTestFormatwithSingleChoice() {
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Main Chapterwise ");
        testformat.enterFormatMark("120");
        testformat.clkSelectExam();
        testformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectchapterwisetest();
        delayTime(TIME_2000S);
        testformat.selectChemistry();
        testformat.clkSave();
        delayTime(TIME_6000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_2000S);
        testformat.verifyJEEmainChemistry();
        
    }


////////////////////JEE Advanced//////////////////////


    @Test (description = "JEE advanced Testing Format - Full Testing")
    @Description("Single choice, Mulitple choice, Subjective Numerical types of Question")
    public void createJEEadvFormat(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Advanced Full Testing ");
        testformat.enterFormatMark("360");
        testformat.clkSelectExam();
        testformat.enterExam("JEE Advan");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectFullTest();
        delayTime(TIME_4000S);
        testformat.selectJEEadvMathematics();
        testformat.enterJEEadvMathematicsSCMCSN();//Single Choice, Multiple Choice, Subjective Numerical
        testformat.selectJEEadvChemistry();
        testformat.enterJEEadvChemistrySCMCSN();
        testformat.selectJEEadvPhysics();
        testformat.enterJEEadvPhysicsSCMCSN();
        testformat.clkSave();
        delayTime(TIME_10000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        testformat.verifyJEEadvFormat();
        
    }

    @Test (description = "JEE advanced Testing Format - Full Testing")
    @Description("True or False, Assertion, Matrix Match Single Choice types of Question")
    public void createJEEadvFormat1(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Adv (True or False, Assertion, Matrix Match Single Choice) ");
        testformat.enterFormatMark("360");
        testformat.clkSelectExam();
        testformat.enterExam("JEE Advan");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectFullTest();
        delayTime(TIME_4000S);
        testformat.selectJEEadvMathematics();
        testformat.enterJEEadvMathematicsTFAMMSC();
        testformat.selectJEEadvChemistry();
        testformat.enterJEEadvChemistryTFAMMSC();
        testformat.selectJEEadvPhysics();
        testformat.enterJEEadvPhysicsTFAMMSC();
        testformat.clkSave();
        delayTime(TIME_5000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        testformat.verifyJEEadvFormat1();
        
    }

    @Test (description = "JEE advanced Testing Format - Full Testing")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createJEEadvFormat2(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Adv (Single Choice, Integer and Matrix Grid) ");
        testformat.enterFormatMark("360");
        testformat.clkSelectExam();
        testformat.enterExam("JEE Advan");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectFullTest();
        delayTime(TIME_4000S);
        testformat.selectJEEadvMathematics();
        testformat.enterJEEadvMathematicsSCINMG();
        testformat.selectJEEadvChemistry();
        testformat.enterJEEadvChemistrySCINMG();
        testformat.selectJEEadvPhysics();
        testformat.enterJEEadvPhysicsSCINMG();
        testformat.clkSave();
        delayTime(TIME_5000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        testformat.verifyJEEadvFormat2();
        
    }

    @Test (description = "JEE advanced Testing Format - Part Testing")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createJEEadvPartTestFormat(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Adv Part Testing (Single Choice, Integer and Matrix Grid) ");
        testformat.enterFormatMark("120");
        testformat.clkSelectExam();
        testformat.enterExam("JEE Advan");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectparttest();
        delayTime(TIME_4000S);
        testformat.selectJEEadvChemistry();
        testformat.enterJEEadvChemistrySCINMG();
        testformat.clkSave();
        delayTime(TIME_5000S);
        testformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        testformat.verifyJEEadvChemistryFormat2();
        
    }

    @Test (description = "JEE advanced Testing Format - Chapterwise - Testing")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createJEEadvChapterTestFormat(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("JEE Adv Part Testing (Single Choice, Integer and Matrix Grid) ");
        testformat.enterFormatMark("120");
        testformat.clkSelectExam();
        testformat.enterExam("JEE Advan");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectchapterwisetest();
        delayTime(TIME_4000S);
        testformat.selectJEEadvPhysics();
        testformat.enterJEEadvPhysicsSCINMG();
        testformat.clkSave();
        delayTime(TIME_10000S);
        testformat.openNewlyCreatedFormat();
        
    }

    //////////////////// NEET //////////////////////

    @Test (description = "NEET Testing Format - Full Testing")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createNEETfullTestFormat(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("NEET Full Testing (Single Choice, Integer and Matrix Grid) ");
        testformat.enterFormatMark(prop.getProperty("NEETtotalMark"));
        testformat.clkSelectExam();
        testformat.enterExam("NEET");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectFullTest();
        delayTime(TIME_4000S);
        testformat.selectNEETBilogy();
        testformat.enterNEETBiology();
        testformat.selectJEEadvChemistry();
        testformat.enterNEETChemistry();
        testformat.selectJEEadvPhysics();
        testformat.enterNEETPhysics();
        testformat.clkSave();
        
    }

    @Test (description = "NEET Testing Format - Part Testing")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createNEETPartTestFormat(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("NEET Part Testing (Single Choice, Integer and Matrix Grid) ");
        testformat.enterFormatMark(prop.getProperty("NEETPartTestMark"));
        testformat.clkSelectExam();
        testformat.enterExam("NEET");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectparttest();
        delayTime(TIME_4000S);
        testformat.selectNEETBilogy();
        testformat.enterNEETBiology();
        testformat.clkSave();
        
    }

    @Test (description = "NEET Testing Format - Chapter wise Testing")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createNEETChapterTestFormat(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("NEET Chapter Testing (Single Choice, Integer and Matrix Grid) ");
        testformat.enterFormatMark(prop.getProperty("NEETChapterWiseTestMark"));
        testformat.clkSelectExam();
        testformat.enterExam("NEET");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectchapterwisetest();
        delayTime(TIME_4000S);
        testformat.selectNEETBilogy();
        testformat.enterNEETBiology();
        testformat.clkSave();
        
    }

    ////////// AIIMS ////////////

    @Test (description = "AIIMS Testing Format - FULL Testing")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createAIIMSFullTestTestFormat(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("AIIMS FUll Testing ");
        testformat.enterFormatMark(prop.getProperty("AIIMSTotalMark"));
        testformat.clkSelectExam();
        testformat.enterExam("AIIMS");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectFullTest();
        delayTime(TIME_4000S);
        testformat.selectAIIMSGeneralKnowledge();
        testformat.enterAIIMSGendralKnowlege();
        testformat.selectAIIMSPhysics();
        testformat.enterAIIMSPhysics();
        testformat.selectAIIMSChemistry();
        testformat.enterAIIMSChemistry();
        testformat.selectAIIMSBiology();
        testformat.enterAIIMSBiology();
        testformat.clkSave();
        
    }

    @Test (description = "AIIMS Testing Format - Part Testing")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createAIIMSPartTestTestFormat(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("AIIMS Part Testing (Single Choice, Integer and Matrix Grid) ");
        testformat.enterFormatMark(prop.getProperty("AIIMSPart/ChapterTestMark_GK"));
        testformat.clkSelectExam();
        testformat.enterExam("AIIMS");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectparttest();
        delayTime(TIME_4000S);
        testformat.selectAIIMSGeneralKnowledge();
        testformat.enterAIIMSGendralKnowlege();
        testformat.clkSave();
        
    }

    @Test (description = "AIIMS Testing Format - Chapter Wise Testing")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createAIIMSChapterTestTestFormat(){
        
        testformat.clkTestFormat();
        testformat.clkCreateTestFormat();
        testformat.enterFormatName("AIIMS Chapter Wise Testing (Single Choice, Integer and Matrix Grid) ");
        testformat.enterFormatMark(prop.getProperty("AIIMSPart/ChapterTestMark_GK"));
        testformat.clkSelectExam();
        testformat.enterExam("AIIMS");
        delayTime(TIME_3000S);
        testformat.clkTestType();
        testformat.selectchapterwisetest();
        delayTime(TIME_4000S);
        testformat.selectAIIMSGeneralKnowledge();
        testformat.enterAIIMSGendralKnowlege();
        testformat.clkSave();
        
    }

    ///////////// Search Functionality /////////////

    @Test (description = "Verify the user could able to see the Testing Format option on the dash board page")
    @Description("Verify the user could able to see the Testing Format option on the dash board page.")
    public void verifyTestFormatOption(){
        
        testformat.checkTestFormatinSideBar();
        
    }

    @Test (description = "Verify clicking on Testing Format tab in the Side bar, user is navigated to Testing Format page")
    @Description("Verify clicking on Testing Format tab in the Side bar, user is navigated to Testing Format page.")
    public void clickTestFormtSideBar(){
        
        testformat.clkTestFormat();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://new-content-admin-staging.embibe.com/test/format"); //Verify the Page
        
    }

    @Test (description = "Verify user should be able to search test format by valid")
    @Description ("Verify user should be able to search test format by valid")
    public void searchUsingValidId(){
        
        testformat.clkTestFormat();
        testformat.enterFormatId(prop.getProperty("TestFormatValidId"));
        testformat.clkSearch();
        testformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify user should be able to search test format by \"invalid ID\"")
    @Description ("Verify user should be able to search test format by \"invalid ID\"")  //Need to verify the element not available
    public void searchUsingInvalidId(){
        
        testformat.clkTestFormat();
        testformat.enterFormatId(prop.getProperty("TestFormatInvalidId"));
        testformat.clkSearch();
        testformat.verifyListingTableNotavailable();
        
    }

    @Test (description = "Verify user could able to search test format by \"Valid Exam ID\"")
    @Description("verify user could able to search test format by \"Valid Exam ID\"")
    public void searchUsingValidExamId(){
        
        testformat.clkTestFormat();
        testformat.enterFormatExamId(prop.getProperty("TestFormatValidExamId"));
        testformat.clkSearch();
        testformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify user could able to search test format by \"Invalid Exam ID\"")
    @Description("verify user could able to search test format by \"Invalid Exam ID\"")
    public void searchUsingInvalidExamId(){
        
        testformat.clkTestFormat();
        testformat.enterFormatExamId(prop.getProperty("TestFormatInvalidExamId"));
        testformat.clkSearch();
        testformat.verifyListingTableNotavailable();
        
    }

    @Test (description = "Verify by clicking on drop-down for Testing types")
    @Description("Verify by clicking on drop-down for Testing types")
    public void searchTestTypeUsingDropdown(){
        
        testformat.clkTestFormat();
        testformat.clkTestTypeDrop();
        List <WebElement> testType =driver.findElement(By.xpath("//*[@id=\"menu-name\"]/div[2]/ul")).findElements(By.tagName("li"));
        driver.findElement(By.xpath("//*[contains(text(),'Select type')]")).click();
        delayTime(TIME_4000S);
        int testTypeCount = testType.size();
        System.out.println(testTypeCount);
        delayTime(TIME_2000S);
        for(int i=2;i<=testTypeCount;i++) {
            System.out.println(i);
            testformat.clkTestTypeDrop();
            String count = Integer.toString(i);
            delayTime(TIME_2000S);
            driver.findElement(By.xpath("/html/body/div[5]/div[2]/ul/li["+ count+"]")).click();
            delayTime(TIME_2000S);
            testformat.clkSearch();
            testformat.verifyListingTableAvailable();
            delayTime(TIME_2000S);
        }
        
    }

    @Test (description = "Verify by entering the valid test name on the Testing name field")
    @Description("Verify by entering the valid test name on the Testing name field")
    public void searchUsingValidTestName(){
        
        testformat.clkTestFormat();
        testformat.enterTestName(prop.getProperty("TestFormatValidName"));
        testformat.clkSearch();
        testformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify by entering the Invalid test name on the Testing name field")
    @Description("Verify by entering the Invalid test name on the Testing name field") //Need to verify the element not available
    public void searchUsingInvalidTestName(){
        
        testformat.clkTestFormat();
        testformat.enterTestName(prop.getProperty("TestFormatInvalidName"));
        testformat.clkSearch();
        testformat.verifyListingTableNotavailable();
        
    }

    @Test (description = "Verify by entering Id and Exam Id of the same test format to search")
    @Description ("Verify by entering Id and Exam Id of the same test format to search")
    public void searchValidTestNameInWildCard(){
        
        testformat.clkTestFormat();
        testformat.enterTestName(prop.getProperty("TestFormatWildCardName"));
        testformat.clkSearch();
        testformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify by entering Id and Exam Id of the same test format to search")
    @Description("Verify by entering Id and Exam Id of the same test format to search")
    public void searchUsingValidIdandExamId(){
        
        testformat.clkTestFormat();
        testformat.enterFormatId(prop.getProperty("TestFormatValidId"));
        testformat.enterFormatExamId(prop.getProperty("TestFormatValidExamId"));
        testformat.clkSearch();
        testformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify by entering ID and Exam ID of the different Testing format to search")
    @Description("Verify by entering ID and Exam ID of the different Testing format to search")
    public void searchUsingInvalidIdandExamId(){
        
        testformat.clkTestFormat();
        testformat.enterFormatId(prop.getProperty("TestFormatInvalidId"));
        testformat.enterFormatExamId(prop.getProperty("TestFormatInvalidExamId"));
        testformat.clkSearch();
        testformat.verifyListingTableNotavailable();
        
    }

    @Test (description = "Verify if user click \"search\" from the already search result data")
    @Description("Verify if user click \"search\" from the already search result data")
    public void searchTwiceForSameData(){
        
        testformat.clkTestFormat();
        testformat.enterTestName(prop.getProperty("TestFormatValidName"));
        testformat.clkSearch();
        testformat.verifyListingTableAvailable();
        testformat.clkSearch();
        testformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify by entering only one character on the Format ID field to \"Search\"")
    @Description ("Verify by entering only one character on the Format ID field to \"Search\"")
    public void searchUsingOneDigitId(){
        
        testformat.clkTestFormat();
        testformat.enterFormatId(prop.getProperty("TestFormatId"));
        testformat.clkSearch();
        testformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify by entering only one character on the Exam ID field to \"Search\"")
    @Description("Verify by entering only one character on the Exam ID field to \"Search\"")
    public void searchUsingOneDigitExamId(){
        
        testformat.clkTestFormat();
        testformat.enterFormatExamId(prop.getProperty("TestFormatExamId"));
        testformat.clkSearch();
        testformat.verifyListingTableNotavailable();
        
    }

    @Test(description = "Verify by entering only one character on the Testing name field to \"Search\"")
    @Description ("Verify by entering only one character on the Testing name field to \"Search\"")
    public void searchValidOneLetterInTestName(){
        
        testformat.clkTestFormat();
        testformat.enterTestName(prop.getProperty("TestFormatWildCardName"));
        testformat.clkSearch();
        testformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify the default count of records per page in the pagination list")
    @Description("Verify the default count of records per page in the pagination list")
    public void pageCountPagination(){
        
        testformat.clkTestFormat();
        testformat.paginationCount();
        
    }

    @Test (description = "Verify by clicking on Next from the first page in the pagination")
    @Description("Verify by clicking on Next from the first page in the pagination")
    public void pageNavigationNextUsingPagination(){
        
        testformat.clkTestFormat();
        testformat.clkPreviousFromOtherPageInPagination();
        
    }

    @Test (description = "Verify by clicking on Previous from the first page in the pagination")
    @Description("Verify by clicking on Previous from the first page in the pagination")
    public void clickPreviousFromFirstPageOfPagination(){
        
        testformat.clkTestFormat();
        testformat.clkPreviousInPagination();
        
    }

    @Test (description = "Verify by clicking on Next from the last page in the pagination")
    @Description("Verify by clicking on Next from the last page in the pagination")
    public void clickNextFromLastPageOfPagination(){
        
        testformat.clkTestFormat();
        testformat.clkNextFromLastPageInPagination();
        
    }
}
