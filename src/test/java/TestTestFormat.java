import base.TestBase;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestTestFormat extends TestBase {

    ////////// Test Format Creation /////////////

    @Test (description = "Verify by click on \"Create New Test Format\"")
    @Description("Verify by click on \"Create New Test Format\"")
    public void clkCreateNewTestFormat(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        delayTime(TIME_1000S);
        Assert.assertEquals(driver.getCurrentUrl(),"https://new-content-admin-staging.embibe.com/test/format/new");
        
    }

    @Test (description = "Verify by clicking on close icon in Create new Test format")
    @Description("Verify by clicking on close icon in Create new Test format")
    public void clkCloseIconInCreateTestFormat(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.clkCloseTestFormat();
        Assert.assertEquals(driver.getCurrentUrl(),"https://new-content-admin-staging.embibe.com/test/format");
        
    }

    @Test (description = "Verify by clicking on save button without filling the details")
    @Description("Verify by clicking on save button without filling the details")
    public void clkSaveWithoutAnyInput(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.verifySaveButtonEnable();
        
    }

    @Test (description = "Verify by creating the Test format in same Name")
    @Description("Verify by creating the Test format in same Name")
    public void createTestFormatInSameName(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterTestFormatName(prop.getProperty("ExistingTestFormatName"));
        objtestformat.enterFormatMark("360");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        objtestformat.clkTestType();
        objtestformat.selectFullTest();
        delayTime(TIME_2000S);
        objtestformat.enterJEEmainMathematics();
        objtestformat.enterJEEmainPhysics();
        objtestformat.enterJEEmainChemistry();
        objtestformat.clkSave();
        delayTime(TIME_2000S);
        Assert.assertEquals(driver.findElement(By.id("client-snackbar")).getText(),"Test format name already exists");
        
    }

    @Test (description = "Verify by giving Duration greater dhan 600 Minutes and save")
    @Description("Verify by giving Duration greater dhan 600 Minutes and save")
    public void enterDurationGreaterThan600Mins(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterTestFormatName(prop.getProperty("ExistingTestFormatName"));
        objtestformat.enterFormatMark("360");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        objtestformat.clkTestType();
        objtestformat.selectFullTest();
        objtestformat.clkSubject1();
        objtestformat.setSubject1Duration(prop.getProperty("TestFormatDurationGreaterThen600Minutes"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error-status']")).getText(),"enter value less than or equal to 600");
        
    }

    @Test (description = "Verify by clicking save without entering Marking scheme to create new format")
    @Description("Verify by clicking save without entering Marking scheme to create new format")
    public void createTestFormatWithOutMarkScheme(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName(prop.getProperty("ExistingTestFormatName"));
        objtestformat.enterFormatMark(prop.getProperty("TestFormatMaximumMark"));
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE Adv");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectparttest();
        delayTime(TIME_2000S);
        objtestformat.verifyMathematics();
        objtestformat.clkSubject1();
        objtestformat.setSubject1Duration(prop.getProperty("TestFormatDurationGreaterThen600Minutes"));
        objtestformat.ClkAddQuestType11();
        delayTime(TIME_2000S);
        objtestformat.clkQuestionType11();
        delayTime(TIME_2000S);
        objtestformat.selectSingleChoice();
        delayTime(TIME_2000S);
        objtestformat.enterQuestCount11(prop.getProperty("JEEmainMathematicsQuestionCount1"));
        delayTime(TIME_2000S);
        objtestformat.clkSave();
        delayTime(TIME_1000S);
        Assert.assertEquals(driver.findElement(By.id("client-snackbar")).getText(),"Max marks should be equal to product of no.of questions and positive marks");
        
    }

    @Test (description = "Verify if user select full test/ mini test/live test and try to select only 1 subject")
    @Description("Verify if user select full test/ mini test/live test and try to select only 1 subject")
    public void selectOneSubjectForFullTest(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("NEET Full Test (Single Choice, Integer and Matrix Grid) ");
        objtestformat.enterFormatMark(prop.getProperty("NEETtotalMark"));
        objtestformat.clkSelectExam();
        objtestformat.enterExam("NEET");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectFullTest();
        delayTime(TIME_4000S);
        objtestformat.unselectNEETChemistyPhysics();
        objtestformat.selectNEETBilogy();
        objtestformat.enterNEETBiology();
        objtestformat.clkSave();
        // Verify the saved data
        
    }

    @Test (description = "Verify by creating the Test format with \"Duration\" 0 mins")
    @Description("Verify by creating the Test format with \"Duration\" 0 mins")
    public void createTestFormatWithDuration0Mins(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterTestFormatName(prop.getProperty("TestFormatName"));
        objtestformat.enterFormatMark(prop.getProperty("NEETtotalMark"));
        objtestformat.clkSelectExam();
        objtestformat.enterExam("NEET");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectparttest();
        delayTime(TIME_4000S);
        objtestformat.selectNEETBilogy();
        objtestformat.clkSubject1();
        objtestformat.setSubject1Duration(prop.getProperty("Duration"));
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='error-status']")).getText(),"enter value less than or equal to 600");
        
    }

    @Test(description = "Actual JEE main Full Test Format")
    @Description("Full Test")
    public void createJEEmainFullTestFormatwithSingleChoice(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Main Full Test ");
        objtestformat.enterFormatMark("360");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        objtestformat.clkTestType();
        objtestformat.selectFullTest();
        delayTime(TIME_2000S);
        objtestformat.enterJEEmainMathematics();
        objtestformat.enterJEEmainPhysics();
        objtestformat.enterJEEmainChemistry();
        objtestformat.clkSave();
        delayTime(TIME_6000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        objtestformat.verifyJEEmainMathematics();
        objtestformat.verifyJEEmainPhysics();
        objtestformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main Live Test Format")
    @Description("Live Test")
    public void createJEEmainLiveTestFormatwithSingleChoice(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Main Live Test ");
        objtestformat.enterFormatMark("360");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        objtestformat.clkTestType();
        objtestformat.selectlivetest();
        delayTime(TIME_2000S);
        objtestformat.enterJEEmainMathematics();
        objtestformat.enterJEEmainPhysics();
        objtestformat.enterJEEmainChemistry();
        objtestformat.clkSave();
        delayTime(TIME_6000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        objtestformat.verifyJEEmainMathematics();
        objtestformat.verifyJEEmainPhysics();
        objtestformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main Previous Year Test Format")
    @Description("Previous Year Test")
    public void createJEEmainPreviousYearFormatwithSingleChoice(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Main Previous Year Test ");
        objtestformat.enterFormatMark("360");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        objtestformat.clkTestType();
        objtestformat.selectpreviousyeartest();
        delayTime(TIME_2000S);
        objtestformat.enterJEEmainMathematics();
        objtestformat.enterJEEmainPhysics();
        objtestformat.enterJEEmainChemistry();
        objtestformat.clkSave();
        delayTime(TIME_6000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        objtestformat.verifyJEEmainMathematics();
        objtestformat.verifyJEEmainPhysics();
        objtestformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main 11th Revision Test Format")
    @Description("11th Revision Test")
    public void createJEEmain11thRevisionFormatwithSingleChoice(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Main 11th Revision Test ");
        objtestformat.enterFormatMark("360");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        objtestformat.clkTestType();
        objtestformat.selecteleventhrevision();
        delayTime(TIME_2000S);
        objtestformat.enterJEEmainMathematics();
        objtestformat.enterJEEmainPhysics();
        objtestformat.enterJEEmainChemistry();
        objtestformat.clkSave();
        delayTime(TIME_6000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        objtestformat.verifyJEEmainMathematics();
        objtestformat.verifyJEEmainPhysics();
        objtestformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main Mini Test Format")
    @Description("Mini Test")
    public void createJEEmainMiniTestFormatwithSingleChoice(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Main Mini-Test ");
        objtestformat.enterFormatMark("360");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectminitest();
        delayTime(TIME_2000S);
        objtestformat.enterJEEmainMathematics();
        objtestformat.enterJEEmainPhysics();
        objtestformat.enterJEEmainChemistry();
        objtestformat.clkSave();
        delayTime(TIME_6000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        objtestformat.verifyJEEmainMathematics();
        objtestformat.verifyJEEmainPhysics();
        objtestformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main PartTest Format")
    @Description("Part Test - Mathematics")
    public void createJEEmainMathematicsPartTestFormatwithSingleChoice() {
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Main Part-Test ");
        objtestformat.enterFormatMark("120");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectparttest();
        delayTime(TIME_5000S);
        objtestformat.selectMathematics();
        delayTime(TIME_2000S);
        objtestformat.clkSave();
        delayTime(TIME_6000S);
        objtestformat.openNewlyCreatedFormat();
        objtestformat.verifyJEEmainMathematics();
        
    }

    @Test(description = "Actual JEE main PartTest Format")
    @Description("Part Test - Physics")
    public void createJEEmainPhysicsPartTestFormatwithSingleChoice() {
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Main Part-Test ");
        objtestformat.enterFormatMark("120");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectparttest();
        objtestformat.selectPhysics();
        delayTime(TIME_2000S);
        objtestformat.clkSave();
        delayTime(TIME_6000S);
        objtestformat.openNewlyCreatedFormat();
        objtestformat.verifyJEEmainPhysics();
        
    }

    @Test(description = "Actual JEE main PartTest Format")
    @Description("Part Test - Chemistry")
    public void createJEEmainChemistryPartTestFormatwithSingleChoice() {
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Main Part-Test ");
        objtestformat.enterFormatMark("120");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_4000S);
        objtestformat.clkTestType();
        objtestformat.selectparttest();
        delayTime(TIME_2000S);
        objtestformat.selectChemistry();
        objtestformat.clkSave();
        delayTime(TIME_6000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_2000S);
        objtestformat.verifyJEEmainChemistry();
        
    }

    @Test(description = "Actual JEE main Chapterwise Format")
    @Description("Chapterwise Test - Mathematics")
    public void createJEEmainMathematicsChapterTestFormatwithSingleChoice() {
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Main ChapterWise ");
        objtestformat.enterFormatMark("120");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectchapterwisetest();
        delayTime(TIME_2000S);
        objtestformat.selectMathematics();
        objtestformat.clkSave();
        delayTime(TIME_10000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        objtestformat.verifyJEEmainMathematics();
        
    }

    @Test(description = "Actual JEE main Chapterwise Test Format")
    @Description("Chapterwise Test - Physics")
    public void createJEEmainPhysicsChapterTestFormatwithSingleChoice() {
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Main Chapter ");
        objtestformat.enterFormatMark("120");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        //1st Subject
        objtestformat.clkTestType();
        objtestformat.selectchapterwisetest();
        delayTime(TIME_2000S);
        objtestformat.selectPhysics();
        objtestformat.clkSave();
        delayTime(TIME_6000S);
        objtestformat.openNewlyCreatedFormat();
        objtestformat.verifyJEEmainPhysics();
        
    }

    @Test(description = "Actual JEE main Chapterwise Format")
    @Description("Chapterwise Test - Chemistry")
    public void createJEEmainChemistryChapterTestFormatwithSingleChoice() {
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Main Chapterwise ");
        objtestformat.enterFormatMark("120");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE main");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectchapterwisetest();
        delayTime(TIME_2000S);
        objtestformat.selectChemistry();
        objtestformat.clkSave();
        delayTime(TIME_6000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_2000S);
        objtestformat.verifyJEEmainChemistry();
        
    }


////////////////////JEE Advanced//////////////////////


    @Test (description = "JEE advanced Test Format - Full Test")
    @Description("Single choice, Mulitple choice, Subjective Numerical types of Question")
    public void createJEEadvFormat(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Advanced Full Test ");
        objtestformat.enterFormatMark("360");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE Advan");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectFullTest();
        delayTime(TIME_4000S);
        objtestformat.selectJEEadvMathematics();
        objtestformat.enterJEEadvMathematicsSCMCSN();//Single Choice, Multiple Choice, Subjective Numerical
        objtestformat.selectJEEadvChemistry();
        objtestformat.enterJEEadvChemistrySCMCSN();
        objtestformat.selectJEEadvPhysics();
        objtestformat.enterJEEadvPhysicsSCMCSN();
        objtestformat.clkSave();
        delayTime(TIME_10000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        objtestformat.verifyJEEadvFormat();
        
    }

    @Test (description = "JEE advanced Test Format - Full Test")
    @Description("True or False, Assertion, Matrix Match Single Choice types of Question")
    public void createJEEadvFormat1(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Adv (True or False, Assertion, Matrix Match Single Choice) ");
        objtestformat.enterFormatMark("360");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE Advan");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectFullTest();
        delayTime(TIME_4000S);
        objtestformat.selectJEEadvMathematics();
        objtestformat.enterJEEadvMathematicsTFAMMSC();
        objtestformat.selectJEEadvChemistry();
        objtestformat.enterJEEadvChemistryTFAMMSC();
        objtestformat.selectJEEadvPhysics();
        objtestformat.enterJEEadvPhysicsTFAMMSC();
        objtestformat.clkSave();
        delayTime(TIME_5000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        objtestformat.verifyJEEadvFormat1();
        
    }

    @Test (description = "JEE advanced Test Format - Full Test")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createJEEadvFormat2(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Adv (Single Choice, Integer and Matrix Grid) ");
        objtestformat.enterFormatMark("360");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE Advan");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectFullTest();
        delayTime(TIME_4000S);
        objtestformat.selectJEEadvMathematics();
        objtestformat.enterJEEadvMathematicsSCINMG();
        objtestformat.selectJEEadvChemistry();
        objtestformat.enterJEEadvChemistrySCINMG();
        objtestformat.selectJEEadvPhysics();
        objtestformat.enterJEEadvPhysicsSCINMG();
        objtestformat.clkSave();
        delayTime(TIME_5000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        objtestformat.verifyJEEadvFormat2();
        
    }

    @Test (description = "JEE advanced Test Format - Part Test")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createJEEadvPartTestFormat(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Adv Part Test (Single Choice, Integer and Matrix Grid) ");
        objtestformat.enterFormatMark("120");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE Advan");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectparttest();
        delayTime(TIME_4000S);
        objtestformat.selectJEEadvChemistry();
        objtestformat.enterJEEadvChemistrySCINMG();
        objtestformat.clkSave();
        delayTime(TIME_5000S);
        objtestformat.openNewlyCreatedFormat();
        delayTime(TIME_5000S);
        objtestformat.verifyJEEadvChemistryFormat2();
        
    }

    @Test (description = "JEE advanced Test Format - Chapterwise - Test")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createJEEadvChapterTestFormat(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("JEE Adv Part Test (Single Choice, Integer and Matrix Grid) ");
        objtestformat.enterFormatMark("120");
        objtestformat.clkSelectExam();
        objtestformat.enterExam("JEE Advan");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectchapterwisetest();
        delayTime(TIME_4000S);
        objtestformat.selectJEEadvPhysics();
        objtestformat.enterJEEadvPhysicsSCINMG();
        objtestformat.clkSave();
        delayTime(TIME_10000S);
        objtestformat.openNewlyCreatedFormat();
        
    }

    //////////////////// NEET //////////////////////

    @Test (description = "NEET Test Format - Full Test")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createNEETfullTestFormat(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("NEET Full Test (Single Choice, Integer and Matrix Grid) ");
        objtestformat.enterFormatMark(prop.getProperty("NEETtotalMark"));
        objtestformat.clkSelectExam();
        objtestformat.enterExam("NEET");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectFullTest();
        delayTime(TIME_4000S);
        objtestformat.selectNEETBilogy();
        objtestformat.enterNEETBiology();
        objtestformat.selectJEEadvChemistry();
        objtestformat.enterNEETChemistry();
        objtestformat.selectJEEadvPhysics();
        objtestformat.enterNEETPhysics();
        objtestformat.clkSave();
        
    }

    @Test (description = "NEET Test Format - Part Test")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createNEETPartTestFormat(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("NEET Part Test (Single Choice, Integer and Matrix Grid) ");
        objtestformat.enterFormatMark(prop.getProperty("NEETPartTestMark"));
        objtestformat.clkSelectExam();
        objtestformat.enterExam("NEET");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectparttest();
        delayTime(TIME_4000S);
        objtestformat.selectNEETBilogy();
        objtestformat.enterNEETBiology();
        objtestformat.clkSave();
        
    }

    @Test (description = "NEET Test Format - Chapter wise Test")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createNEETChapterTestFormat(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("NEET Chapter Test (Single Choice, Integer and Matrix Grid) ");
        objtestformat.enterFormatMark(prop.getProperty("NEETChapterWiseTestMark"));
        objtestformat.clkSelectExam();
        objtestformat.enterExam("NEET");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectchapterwisetest();
        delayTime(TIME_4000S);
        objtestformat.selectNEETBilogy();
        objtestformat.enterNEETBiology();
        objtestformat.clkSave();
        
    }

    ////////// AIIMS ////////////

    @Test (description = "AIIMS Test Format - FULL Test")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createAIIMSFullTestTestFormat(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("AIIMS FUll Test ");
        objtestformat.enterFormatMark(prop.getProperty("AIIMSTotalMark"));
        objtestformat.clkSelectExam();
        objtestformat.enterExam("AIIMS");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectFullTest();
        delayTime(TIME_4000S);
        objtestformat.selectAIIMSGeneralKnowledge();
        objtestformat.enterAIIMSGendralKnowlege();
        objtestformat.selectAIIMSPhysics();
        objtestformat.enterAIIMSPhysics();
        objtestformat.selectAIIMSChemistry();
        objtestformat.enterAIIMSChemistry();
        objtestformat.selectAIIMSBiology();
        objtestformat.enterAIIMSBiology();
        objtestformat.clkSave();
        
    }

    @Test (description = "AIIMS Test Format - Part Test")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createAIIMSPartTestTestFormat(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("AIIMS Part Test (Single Choice, Integer and Matrix Grid) ");
        objtestformat.enterFormatMark(prop.getProperty("AIIMSPart/ChapterTestMark_GK"));
        objtestformat.clkSelectExam();
        objtestformat.enterExam("AIIMS");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectparttest();
        delayTime(TIME_4000S);
        objtestformat.selectAIIMSGeneralKnowledge();
        objtestformat.enterAIIMSGendralKnowlege();
        objtestformat.clkSave();
        
    }

    @Test (description = "AIIMS Test Format - Chapter Wise Test")
    @Description("Single Choice, Integer and Matrix Grid types of Question")
    public void createAIIMSChapterTestTestFormat(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkCreateTestFormat();
        objtestformat.enterFormatName("AIIMS Chapter Wise Test (Single Choice, Integer and Matrix Grid) ");
        objtestformat.enterFormatMark(prop.getProperty("AIIMSPart/ChapterTestMark_GK"));
        objtestformat.clkSelectExam();
        objtestformat.enterExam("AIIMS");
        delayTime(TIME_3000S);
        objtestformat.clkTestType();
        objtestformat.selectchapterwisetest();
        delayTime(TIME_4000S);
        objtestformat.selectAIIMSGeneralKnowledge();
        objtestformat.enterAIIMSGendralKnowlege();
        objtestformat.clkSave();
        
    }

    ///////////// Search Functionality /////////////

    @Test (description = "Verify the user could able to see the Test Format option on the dash board page")
    @Description("Verify the user could able to see the Test Format option on the dash board page.")
    public void verifyTestFormatOption(){
        
        objtestformat.checkTestFormatinSideBar();
        
    }

    @Test (description = "Verify clicking on Test Format tab in the Side bar, user is navigated to Test Format page")
    @Description("Verify clicking on Test Format tab in the Side bar, user is navigated to Test Format page.")
    public void clickTestFormtSideBar(){
        
        objtestformat.clkTestFormat();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://new-content-admin-staging.embibe.com/test/format"); //Verify the Page
        
    }

    @Test (description = "Verify user should be able to search test format by valid")
    @Description ("Verify user should be able to search test format by valid")
    public void searchUsingValidId(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterFormatId(prop.getProperty("TestFormatValidId"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify user should be able to search test format by \"invalid ID\"")
    @Description ("Verify user should be able to search test format by \"invalid ID\"")  //Need to verify the element not available
    public void searchUsingInvalidId(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterFormatId(prop.getProperty("TestFormatInvalidId"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableNotavailable();
        
    }

    @Test (description = "Verify user could able to search test format by \"Valid Exam ID\"")
    @Description("verify user could able to search test format by \"Valid Exam ID\"")
    public void searchUsingValidExamId(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterFormatExamId(prop.getProperty("TestFormatValidExamId"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify user could able to search test format by \"Invalid Exam ID\"")
    @Description("verify user could able to search test format by \"Invalid Exam ID\"")
    public void searchUsingInvalidExamId(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterFormatExamId(prop.getProperty("TestFormatInvalidExamId"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableNotavailable();
        
    }

    @Test (description = "Verify by clicking on drop-down for Test types")
    @Description("Verify by clicking on drop-down for Test types")
    public void searchTestTypeUsingDropdown(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkTestTypeDrop();
        List <WebElement> testType =driver.findElement(By.xpath("//*[@id=\"menu-name\"]/div[2]/ul")).findElements(By.tagName("li"));
        driver.findElement(By.xpath("//*[contains(text(),'Select type')]")).click();
        delayTime(TIME_4000S);
        int testTypeCount = testType.size();
        System.out.println(testTypeCount);
        delayTime(TIME_2000S);
        for(int i=2;i<=testTypeCount;i++) {
            System.out.println(i);
            objtestformat.clkTestTypeDrop();
            String count = Integer.toString(i);
            delayTime(TIME_2000S);
            driver.findElement(By.xpath("/html/body/div[5]/div[2]/ul/li["+ count+"]")).click();
            delayTime(TIME_2000S);
            objtestformat.clkSearch();
            objtestformat.verifyListingTableAvailable();
            delayTime(TIME_2000S);
        }
        
    }

    @Test (description = "Verify by entering the valid test name on the Test name field")
    @Description("Verify by entering the valid test name on the Test name field")
    public void searchUsingValidTestName(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterTestName(prop.getProperty("TestFormatValidName"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify by entering the Invalid test name on the Test name field")
    @Description("Verify by entering the Invalid test name on the Test name field") //Need to verify the element not available
    public void searchUsingInvalidTestName(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterTestName(prop.getProperty("TestFormatInvalidName"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableNotavailable();
        
    }

    @Test (description = "Verify by entering Id and Exam Id of the same test format to search")
    @Description ("Verify by entering Id and Exam Id of the same test format to search")
    public void searchValidTestNameInWildCard(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterTestName(prop.getProperty("TestFormatWildCardName"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify by entering Id and Exam Id of the same test format to search")
    @Description("Verify by entering Id and Exam Id of the same test format to search")
    public void searchUsingValidIdandExamId(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterFormatId(prop.getProperty("TestFormatValidId"));
        objtestformat.enterFormatExamId(prop.getProperty("TestFormatValidExamId"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify by entering ID and Exam ID of the different Test format to search")
    @Description("Verify by entering ID and Exam ID of the different Test format to search")
    public void searchUsingInvalidIdandExamId(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterFormatId(prop.getProperty("TestFormatInvalidId"));
        objtestformat.enterFormatExamId(prop.getProperty("TestFormatInvalidExamId"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableNotavailable();
        
    }

    @Test (description = "Verify if user click \"search\" from the already search result data")
    @Description("Verify if user click \"search\" from the already search result data")
    public void searchTwiceForSameData(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterTestName(prop.getProperty("TestFormatValidName"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableAvailable();
        objtestformat.clkSearch();
        objtestformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify by entering only one character on the Format ID field to \"Search\"")
    @Description ("Verify by entering only one character on the Format ID field to \"Search\"")
    public void searchUsingOneDigitId(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterFormatId(prop.getProperty("TestFormatId"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify by entering only one character on the Exam ID field to \"Search\"")
    @Description("Verify by entering only one character on the Exam ID field to \"Search\"")
    public void searchUsingOneDigitExamId(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterFormatExamId(prop.getProperty("TestFormatExamId"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableNotavailable();
        
    }

    @Test(description = "Verify by entering only one character on the Test name field to \"Search\"")
    @Description ("Verify by entering only one character on the Test name field to \"Search\"")
    public void searchValidOneLetterInTestName(){
        
        objtestformat.clkTestFormat();
        objtestformat.enterTestName(prop.getProperty("TestFormatWildCardName"));
        objtestformat.clkSearch();
        objtestformat.verifyListingTableAvailable();
        
    }

    @Test (description = "Verify the default count of records per page in the pagination list")
    @Description("Verify the default count of records per page in the pagination list")
    public void pageCountPagination(){
        
        objtestformat.clkTestFormat();
        objtestformat.paginationCount();
        
    }

    @Test (description = "Verify by clicking on Next from the first page in the pagination")
    @Description("Verify by clicking on Next from the first page in the pagination")
    public void pageNavigationNextUsingPagination(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkPreviousFromOtherPageInPagination();
        
    }

    @Test (description = "Verify by clicking on Previous from the first page in the pagination")
    @Description("Verify by clicking on Previous from the first page in the pagination")
    public void clickPreviousFromFirstPageOfPagination(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkPreviousInPagination();
        
    }

    @Test (description = "Verify by clicking on Next from the last page in the pagination")
    @Description("Verify by clicking on Next from the last page in the pagination")
    public void clickNextFromLastPageOfPagination(){
        
        objtestformat.clkTestFormat();
        objtestformat.clkNextFromLastPageInPagination();
        
    }
}
