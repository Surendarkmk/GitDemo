import base.TestBase;
import org.testng.annotations.Test;

public class TestQuestionGeneration extends TestBase {

/*    public static ExtentTest test;

    QuestionGeneration objquestgen;
    Login objlogin;
    Home objhome;
    Questions objquestions;

    @BeforeTest
    public void setup() {
        initialization();
        objlogin = new Login(driver,test);
        objhome = new Home(driver);
        objquestions = new Questions(driver);
        objquestgen = new QuestionGeneration(driver);
        login();
        objhome.clkQuestionGeneration();
    }*/

    @Test(priority = 1)
    public void selectDropDown() throws InterruptedException {
        
        objquestgen.clkQuestionGenaration();
        delayTime(TIME_4000S);
        objquestgen.clickFillInTheBlanks();
        objquestgen.selectDropDown();
        
    }

    /*@Testing
    public void size() throws InterruptedException {
        //objquestgen.clickGrade6();
        objquestgen.size();
    }*/

    @Test (priority = 1)
    public void txtWithContent(){
        
        objquestgen.clkQuestionGenaration();
        delayTime(TIME_4000S);
        objquestgen.clickFillInTheBlanks();
        //objquestgen.delayTime();
        delayTime(TIME_5000S);
        objquestgen.enterText();
        delayTime(TIME_2000S);
        objquestgen.clickGenerateQuestions();
        objquestgen.clickGenerateQuestions();
        objquestgen.verifyQuestGen();
        
    }

    @Test (priority = 2)
    public void txtWithoutContent(){
        
        objquestgen.clkQuestionGenaration();
        delayTime(TIME_4000S);
        objquestgen.clickFillInTheBlanks();
        delayTime(TIME_5000S);
        objquestgen.clickGenerateQuestions();
        delayTime(TIME_2000S);
        objquestgen.verifyQuestGenNoTxt();
        
    }

    @Test (priority = 3)
    public void selectSubjectWithoutGrade(){
        
        objquestgen.clkQuestionGenaration();
        delayTime(TIME_4000S);
        objquestgen.clickFillInTheBlanks();
        delayTime(TIME_2000S);
        objquestgen.selectSubject();
        
    }

    @Test
    public void selectChapterWithoutSubject(){
        
        objquestgen.clkQuestionGenaration();
        delayTime(TIME_4000S);
        objquestgen.clickFillInTheBlanks();
        delayTime(TIME_2000S);
        objquestgen.selectChapter();
        
    }

    @Test
    public void selectAllMetaData(){
        
        objquestgen.clkQuestionGenaration();
        delayTime(TIME_4000S);
        objquestgen.clickFillInTheBlanks();
        objquestgen.selectGrade6();
        delayTime(TIME_1000S);
        objquestgen.selectSubjectScience();
        delayTime(TIME_1000S);
        objquestgen.selectChapter1();
        
    }

    @Test
    public void uploadEpub(){
        
        objquestgen.clkQuestionGenaration();
        delayTime(TIME_4000S);
        objquestgen.clickFillInTheBlanks();
        delayTime(TIME_2000S);
        objquestgen.uploadEpubFile();
        delayTime(TIME_2000S);
        objquestgen.clickGenerateQuestions();
        
    }
}
