import base.TestBase;
import org.testng.annotations.Test;

public class TestConcepts extends TestBase {

    @Test
    public void searchConceptsValidId() {
        
        delayTime(TIME_2000S);
        objconcepts.openConceptPage();
        delayTime(TIME_2000S);
        objconcepts.conceptSearchId("279319");
        delayTime(TIME_2000S);
        objconcepts.clkSearch();
        delayTime(TIME_2000S);
        objconcepts.verifySearchId();
        delayTime(TIME_2000S);
        
    }

    @Test
    public void searchConceptsInvalidId() {
        
        delayTime(TIME_2000S);
        objconcepts.openConceptPage();
        delayTime(TIME_4000S);
        objconcepts.conceptSearchId("2793199");
        delayTime(TIME_1000S);
        objconcepts.clkSearch();
        delayTime(TIME_2000S);
        objconcepts.verifyInvalidSearchId();
        
    }

    @Test
    public void searchActiveStatus() {
        
        delayTime(TIME_2000S);
        objconcepts.openConceptPage();
        delayTime(TIME_4000S);
        objconcepts.clkStatus();
        objconcepts.selectActive();
        delayTime(TIME_2000S);
        objconcepts.clkSearch();
        delayTime(TIME_4000S);
        objconcepts.verifySearchId();
        delayTime(TIME_2000S);
        
    }

    @Test
    public void searchInactiveStatus() {
        
        delayTime(TIME_2000S);
        objconcepts.openConceptPage();
        delayTime(TIME_4000S);
        objconcepts.clkStatus();
        objconcepts.selectInactive();
        delayTime(TIME_2000S);
        objconcepts.clkSearch();
        delayTime(TIME_4000S);
        objconcepts.verifySearchId();
        delayTime(TIME_2000S);
        
    }

    @Test
    public void searchDraftStatus() {
        
        delayTime(TIME_2000S);
        objconcepts.openConceptPage();
        delayTime(TIME_4000S);
        objconcepts.clkStatus();
        objconcepts.selectDraft();
        delayTime(TIME_2000S);
        objconcepts.clkSearch();
        delayTime(TIME_4000S);
        objconcepts.verifySearchId();
        delayTime(TIME_2000S);
        
    }

    @Test
    public void searchConceptsValidCode() {
        
        delayTime(TIME_2000S);
        objconcepts.openConceptPage();
        delayTime(TIME_4000S);
        objconcepts.conceptSearchCode("new_KG14564");
        delayTime(TIME_2000S);
        objconcepts.clkSearch();
        delayTime(TIME_2000S);
        objconcepts.verifySearchCode();
        delayTime(TIME_2000S);
        
    }

    @Test
    public void searchConceptsInvalidCode() {
        
        delayTime(TIME_2000S);
        objconcepts.openConceptPage();
        delayTime(TIME_4000S);
        objconcepts.conceptSearchCode("2793199");
        delayTime(TIME_1000S);
        objconcepts.clkSearch();
        delayTime(TIME_2000S);
        objconcepts.verifyInvalidSearchId();
        delayTime(TIME_4000S);
        
    }

    @Test
    public void searchConceptsValidName() {
        
        delayTime(TIME_2000S);
        objconcepts.openConceptPage();
        delayTime(TIME_4000S);
        objconcepts.conceptSearchName("Test");
        delayTime(TIME_1000S);
        objconcepts.clkSearch();
        delayTime(TIME_2000S);
        objconcepts.verifySearchCode();
        delayTime(TIME_4000S);
        
    }

    @Test
    public void searchConceptsInvalidName() {
        
        delayTime(TIME_2000S);
        objconcepts.openConceptPage();
        delayTime(TIME_4000S);
        objconcepts.conceptSearchName("abcd");
        delayTime(TIME_1000S);
        objconcepts.clkSearch();
        delayTime(TIME_2000S);
        objconcepts.verifyInvalidSearchId();
        delayTime(TIME_4000S);
        
    }

    @Test
    public void searchConceptsDropCreator() {
        
        delayTime(TIME_2000S);
        objconcepts.openConceptPage();
        delayTime(TIME_4000S);
        objconcepts.clkCreatorDrop();
        delayTime(TIME_4000S);
        
    }

    @Test
    public void searchConceptsTextCreator() {
        
        delayTime(TIME_2000S);
        objconcepts.openConceptPage();
        delayTime(TIME_4000S);
        objconcepts.clkCreatorDrop();
        delayTime(TIME_2000S);
        objconcepts.enterCreatorText("Surendar Kaliappan");
        delayTime(TIME_2000S);
        objconcepts.pressEnterCreator();
        objconcepts.verifySearchId();
        delayTime(TIME_4000S);
        
    }

    //************** Above SEARCH has been done *************

    @Test
    public void clkCreateNewConcept() {
        
        objconcepts.openConceptPage();
        objconcepts.verifyConceptListing();
        objconcepts.clkCreateConcept();
        delayTime(TIME_2000S);
        objconcepts.clkCloseConcept();
        objconcepts.verifyConceptListing();
        
    }

    @Test
    public void clkSaveWithoutConceptName() {
        
        objconcepts.openConceptPage();
        objconcepts.clkCreateConcept();
        delayTime(TIME_2000S);
        objconcepts.clkSaveBtn();
        objconcepts.verifyErrorMsg();
        
    }

    @Test
    public void createNewConcept() {
        
        objconcepts.openConceptPage();
        objconcepts.clkCreateConcept();
        delayTime(TIME_4000S);
        objconcepts.enterConceptName();
        objconcepts.enterConcept();
        objconcepts.clkStatus();
        objconcepts.selectInactive();
        delayTime(TIME_2000S);
        objconcepts.clkConceptType();
        delayTime(TIME_1000S);
        objconcepts.selectIdentity();
        delayTime(TIME_2000S);
        objconcepts.clkDropdownCategory();
        delayTime(TIME_1000S);
        objconcepts.selectCategory();
        delayTime(TIME_2000S);
        objconcepts.enterNewCoceptCode();
        delayTime(TIME_2000S);
        objconcepts.commonErrorText();
        delayTime(TIME_2000S);
        objconcepts.tipText();
        delayTime(TIME_2000S);
        objconcepts.clkDropskill1();
        //delayTime(TIME_2000S);
        objconcepts.selectSkill1();
        delayTime(TIME_2000S);
        objconcepts.clkAddVideoLink();
        delayTime(TIME_2000S);
        objconcepts.enterlinkVideo();
        delayTime(TIME_2000S);
        objconcepts.clkPreviewVideo();
        delayTime(TIME_5000S);
        objconcepts.verifyVideoTumbline();
        objconcepts.clkSelectVideoLink();
        delayTime(TIME_4000S);
        objconcepts.clkSaveBtn();
        objconcepts.verifyConceptListing();
        objconcepts.clkRecentSaved();
        delayTime(TIME_5000S);
        objconcepts.verifyAll();
        
    }

    @Test
    public void openRecentSaved() {
        
        objconcepts.openConceptPage();
        delayTime(TIME_10000S);
        objconcepts.clkRecentSaved();
        delayTime(TIME_4000S);
        objconcepts.verifyAll();
        
    }

    @Test
    public void openCreateConceptandClose() {
        
        objconcepts.openConceptPage();
        objconcepts.verifyConceptListing();
        objconcepts.clkCreateConcept();
        objconcepts.verifyConceptListing();
        objconcepts.clkCloseConcept();
        
    }

    @Test
    public void openNewConceptandSave() {
        
        objconcepts.openConceptPage();
        objconcepts.clkCreateConcept();
        objconcepts.clkSaveBtn();
        objconcepts.verifyErrorConceptName();
    }

    @Test
    public void enterConceptNameandSave() {
        
        objconcepts.openConceptPage();
        objconcepts.clkCreateConcept();
        objconcepts.enterConceptName();
        objconcepts.clkSaveBtn();
        objconcepts.verifyErrorConceptStatus();
        //need to author
        
    }

    @Test
    public void enterConceptNameandStatus() {
        
        objconcepts.openConceptPage();
        objconcepts.clkCreateConcept();
        objconcepts.enterConceptName();
        objconcepts.clkStatus();
        objconcepts.selectInactive();
        objconcepts.clkSaveBtn();
        objconcepts.verifyErrorConceptCode();
        
    }

    @Test
    public void enterConceptNameStatusandCode() {
        
        objconcepts.openConceptPage();
        objconcepts.clkCreateConcept();
        objconcepts.enterConceptName();
        objconcepts.clkStatus();
        objconcepts.selectInactive();
        objconcepts.enterNewCoceptCode();
        objconcepts.clkSaveBtn();
        objconcepts.verifyConceptListing();
        
    }

    @Test
    public void addCommonError() {
        
        objconcepts.openConceptPage();
        objconcepts.clkCreateConcept();
        objconcepts.enterConceptName();
        objconcepts.clkStatus();
        objconcepts.selectInactive();
        objconcepts.enterNewCoceptCode();
        objconcepts.commonErrorText();
        objconcepts.clkAddCommonError();
        objconcepts.commonErrorText2();
        objconcepts.clkSaveBtn();
        objconcepts.verifyConceptListing();
        objconcepts.clkRecentSaved();
        
    }

    @Test
    public void addTips() {
        
        objconcepts.openConceptPage();
        objconcepts.clkCreateConcept();
        objconcepts.enterConceptName();
        objconcepts.clkStatus();
        objconcepts.selectInactive();
        objconcepts.enterNewCoceptCode();
        objconcepts.tipText1();
        objconcepts.clkSaveBtn();
        objconcepts.verifyConceptListing();
        
    }
}