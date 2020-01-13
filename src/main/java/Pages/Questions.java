package Pages;

import base.TestBase;
import constants.TimeDelay;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class Questions extends TestBase {

    WebDriver driver;
    /////////// Key Attributes ////////////
    @FindBy(xpath = "//*[@class='key-attribute-textfield']")
    WebElement questionID;
    @FindBy(xpath = "//*[@class=' css-107lb6w-singleValue']")
    WebElement curator;
    @FindBy(id = "react-select-4-input")
    WebElement partnerTextBox;


    @FindBy(id = "add-ques-id")
    WebElement AssociateQuestionsTextBoxLinkedComprehension;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[4]/div[2]/div[2]")
    WebElement addQuestionBtnLinkedComprehension;

    //New Question Creation
    @FindBy(xpath = "//*[@id=\"0\"]/div/div[2]/div/input")
    WebElement OptionTextBox;

    @FindBy(xpath = "//*[contains(text(),'Add Hints')]")
    WebElement AddHints;

    //Question Details
    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div[3]/div[2]/div/div/div/div/iframe")
    WebElement questionEditor;

    //Question Meta Tags 1
    @FindBy(xpath = "((//*[@id=\"mui-component-select-name\"])[2])")
    WebElement smartTagDropDown;
    @FindBy(xpath = "//div[@class=\"PRIMARY_CONCEPT0\"]")
    WebElement primaryConceptList1;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div[7]/div[1]/div[1]/div[2]/div[7]/div[2]/div[2]/div/div[1]/div[1]/div/input")
    WebElement secondaryConcept2;
    @FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div[7]/div[1]/div[1]/div[2]/div[8]/div[2]/div[2]/div/div[1]/div[1]/div/input")
    WebElement secondaryConcept3;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[7]/div[1]/div[1]/div[2]/div[5]/div[3]")
    WebElement addSecondaryConcept; // "Plus +" icon to add secondary concept
    @FindBy(xpath = "((//*[@class=\"add-concepts\"])[2])")
    WebElement removeSecondaryConcept; // "minus -" icon to remove secondary concept
    @FindBy(xpath = "//div[@class=\"SECONDARY_CONCEPT0\"]")
    WebElement SecondryConceptList1;

    @FindBy(xpath = "((//*[@id=\"outlined-dense\"])[2])")
    WebElement idealTime;
    @FindBy(id = "Rote Learning")
    WebElement RoteLearning; //Bloom Level
    @FindBy(xpath = "//div[@class='input']//input")
    WebElement videoLinkText;
    @FindBy(xpath = "//div[@class='select']")
    WebElement confirmVideoLink;
    @FindBy(xpath = "//*[@class=\"invalid-url-message\"]")
    WebElement errorMessageInvalidVideoLink;

    // Question Learning Maps
    @FindBy(id = "topic-checkbox-0")
    WebElement firstTopicCheckBox;

    @FindBy(xpath = "//div[@class=\"preview\"]")
    WebElement preview;

    //Status
    @FindBy(className = "footer-add-choice-button")
    WebElement submitBtn;
    @FindBy(xpath = "//span[@id='client-snackbar']")
    WebElement snackBar;

    //Step wise Solution
    @FindBy(xpath = "//div[@class=\"question-details-add-create-steps-button\"]")
    WebElement createStepButton;

    public Questions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Click on Questions on Side bar")
    public void clkQuestions() {
        waitUntillElementVisible(driver.findElement(By.xpath("//*[contains(text(),'Questions')]")));
        driver.findElement(By.xpath("//*[contains(text(),'Questions')]")).click(); // Click Questions on Side Bar
    }

    public void verifyAllQuestionTypes() {
        clkQuestionType();
        delayTime(TimeDelay.TIME_1000S);
        List<WebElement> questionTypes = driver.findElement(By.xpath("//*[@id=\"menu-name\"]/div[3]/ul")).findElements(By.tagName("li"));
        System.out.println("Size of the Question Types : " + questionTypes.size());
        driver.findElement(By.xpath("//*[contains(text(),'Select type')]")).click();
        delayTime(TimeDelay.TIME_2000S);
        for (int questType = 2; questType <= questionTypes.size(); questType++) {
            clkQuestionType();
            delayTime(TimeDelay.TIME_1000S);
            String count = java.lang.Integer.toString(questType);
            driver.findElement(By.xpath("/html/body/div[5]/div[3]/ul/li[" + count + "]")).click();
            delayTime(TimeDelay.TIME_1000S);
            clickSearch();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]/div[2]/div/div[1]/div[2]/div[1]")));
        }
    }

    @Step("Click on Search button")
    public void clickSearch() {
        driver.findElement(By.className("search-button-div")).click(); // Click on Search in Question Listing Page
    }

    @Step("Enter Questions ID")
    public void questionId(String QuestId) {
        driver.findElement(By.xpath("((//*[@id=\"outlined-dense\"])[1])")).sendKeys(QuestId); // Enter Question ID
    }

    @Step("Enter Question Code")
    public void questionCode(String QuestCode) {
        driver.findElement(By.xpath("((//*[@id=\"outlined-dense\"])[2])")).sendKeys(QuestCode);
    }

    @Step("Click Question Type Drop Down")
    public void clkQuestionType() {
        driver.findElement(By.xpath("//*[@id=\"mui-component-select-name\"]")).click(); // Click Drop down Question Types
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Click Status Drop Down")
    public void clkStatus() {
        pageScrole(submitBtn);
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.xpath("//*[@id=\"mui-component-select-name\"])[2])")).click(); // Click Drop down on Status
    }

    @Step("Enter Curator Name")
    public void enterCurator(String userName) {
        driver.findElement(By.xpath("\"//*[@id=\\\"app\\\"]/div/div[3]/div[2]/div[2]/div[5]/div[2]/div/div/div[1]/div[1]")).click(); // Click Curator Drop Down
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.id("react-select-2-input")).sendKeys(userName); //Enter User Name on the Curator Text Box
        driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);
    }

    public void verifyListingPage() {
        Assert.assertTrue(driver.findElement(By.xpath("((//*[@class='rt-tr-group'])[1])")).isDisplayed()); // First Row of the listing page is display
        delayTime(TimeDelay.TIME_2000S);
    }

    public void waitUntilListDisplay() {
        waitUntillElementVisible(driver.findElement(By.xpath("((//*[@class='rt-tr-group'])[1])"))); // Wait until First Row of the listing page dispaly
    }

    public void verifyNolistingPage() {
        Assert.assertFalse(driver.findElement(By.className("rt-tbody")).isDisplayed());  // Verify No Data present on the listing page
    }


    //Question Creation

    @Step("Click Create New Question")
    public void clkCreateQuestion() {
        waitUntillElementVisible(driver.findElement(By.className("concept-new-btn-box")));
        driver.findElement(By.className("concept-new-btn-box")).click();
    }

    @Step("Select Single Choice")
    public void selectSingleChoiceQuestCreation() {
        waitUntillElementVisible(driver.findElement(By.id("Single Choice")));
        driver.findElement(By.id("Single Choice")).click();
    }

    public void selectMultiChoiceQuestCreation() {
        waitUntillElementVisible(driver.findElement(By.id("Multiple Choice")));
        driver.findElement(By.id("Multiple Choice")).click();
        delayTime(TimeDelay.TIME_2000S);
    }

    public void selectMatrixMatchSingleChoiceQuestCreation() {
        waitUntilElementClickable(driver.findElement(By.id("Matrix Match Single Choice")));
        driver.findElement(By.id("Matrix Match Single Choice")).click();
    }

    public void selectTrueFalsQuestCreation() {
        waitUntilElementClickable(driver.findElement(By.id("True False")));
        driver.findElement(By.id("True False")).click();
    }

    public void selectIntegerQuestCreation() {
        waitUntilElementClickable(driver.findElement(By.id("Integer")));
        driver.findElement(By.id("Integer")).click();
    }

    public void selectSubjectiveNumericalQuestCreation() {
        waitUntilElementClickable(driver.findElement(By.id("Subjective Numerical")));
        driver.findElement(By.id("Subjective Numerical")).click();
    }

    public void selectSubjectiveAnswerQuestCreation() {
        waitUntilElementClickable(driver.findElement(By.id("Subjective Answer")));
        driver.findElement(By.id("Subjective Answer")).click();
    }

    public void selectAssertionQuestCreation() {
        waitUntilElementClickable(driver.findElement(By.id("Assertion")));
        driver.findElement(By.id("Assertion")).click();
    }

    public void selectFillInTheBlanks() {
        waitUntillElementVisible(driver.findElement(By.id("Fill In The Blanks")));
        driver.findElement(By.id("Fill In The Blanks")).click();
    }

    public void selectMultipleFillInTheBlanks() {
        waitUntilElementClickable(driver.findElement(By.id("Multiple Fill In The Blanks")));
        driver.findElement(By.id("Multiple Fill In The Blanks")).click();
    }

    public void selectSingleDropDown() {
        waitUntilElementClickable(driver.findElement(By.id("Single Drop Down")));
        driver.findElement(By.id("Single Drop Down")).click();
    }

    public void selectSubjective() {
        waitUntilElementClickable(driver.findElement(By.id("Subjective")));
        driver.findElement(By.id("Subjective")).click();
    }

    public void selectLinkedComprehension() {
        waitUntilElementClickable(driver.findElement(By.id("Linked Comprehension")));
        driver.findElement(By.id("Linked Comprehension")).click();
    }

    public void selectMultipleDropDown() {
        waitUntilElementClickable(driver.findElement(By.id("Multiple Drop Down")));
        driver.findElement(By.id("Multiple Drop Down")).click();
    }

    public void selectMatrixGride() {
        waitUntilElementClickable(driver.findElement(By.id("Matrix Match Grid")));
        driver.findElement(By.id("Matrix Match Grid")).click();
    }

    @Step("Enter Question Text")
    public void enterQuestionText(String questionText) {
        try {
            waitForQuestionEditorEnable();
        } catch (Exception e) {
        }
        pageScroleMiddle(driver.findElement(By.xpath("//*[@class='question-details-title']")));
        String CWH = driver.getWindowHandle();
        delayTime(TimeDelay.TIME_1000S);
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        delayTime(TimeDelay.TIME_500S);
        WebElement sat = driver.findElement(By.tagName("body"));
        sat.click();
        sat.sendKeys(questionText);
        driver.switchTo().window(CWH);
        delayTime(TimeDelay.TIME_2000S);
    }

    @Step("Enter Option Text 1 value")
    public void enterOptionText1(String option11) {
        pageScroleMiddle(driver.findElement(By.xpath("//*[@id=\"0\"]/div/div[2]/div/div/div[2]")));
        ckEditor(driver.findElement(By.xpath("//*[@id=\"0\"]/div/div[2]/div/div/div[2]")), option11);
    }

    @Step("Enter Option Text 2 value")
    public void enterOptionText2(String option22) {
        if (driver.findElements(By.className("stepwise-solution-container")).isEmpty()) {
            pageScrole(driver.findElement(By.xpath("//*[@id=\"0\"]/div/div[1]/p")));
        } else {
            System.out.println("No Steps");
        }
        ckEditor(driver.findElement(By.xpath("//*[@id=\"1\"]/div/div[2]/div/div/div[2]")), option22);
    }

    @Step("Enter Option Text 3 value")
    public void enterOptionText3(String option33) {
        pageScroleMiddle(driver.findElement(By.xpath("((//*[@class=\"editor-output \"])[6])")));
        ckEditor(driver.findElement(By.xpath("((//*[@class=\"editor-output \"])[6])")), option33);
    }

    @Step("Enter Option Text 4 value")
    public void enterOptionText4(String option44) {
        pageScroleMiddle(driver.findElement(By.xpath("((//*[@class=\"question-details-is-correct-div\"])[4])")));
        ckEditor(driver.findElement(By.xpath("((//*[@class=\"editor-output \"])[8])")), option44);
    }

    @Step("Enter Solution Text")
    public void enterSubjectiveSolutionText() {
        pageScrole(driver.findElement(By.className("question-details-title-div")));
        ckEditor(driver.findElement(By.xpath("//div[@class=\"general-type-solution\"]")), "Solution Text");
    }

    @Step("Enter Solution Text 1 value")
    public void enterSolutionText1() {
        pageScrole(driver.findElement(By.xpath("//div[@class=\"question-details-text row-block\"]")));
        ckEditor(driver.findElement(By.xpath("((//div[@class=\"question-details-row-solution-editor-div\"])[1])")), "Solution 1 Text");
    }

    @Step("Enter Solution Text 1 value")
    public void enterStepSolutionText1() {
        pageScrole(driver.findElement(By.xpath("//div[@class=\"question-details-text row-block\"]")));
        ckEditor1(driver.findElement(By.xpath("((//div[@class=\"question-details-row-solution-editor-div\"])[1])")), "Solution 1 Text");
    }

    @Step("Enter Solution Text 2 value")
    public void enterSolutionText2() {
        pageScrole(driver.findElement(By.xpath("//div[@class=\"question-details-text row-block\"]")));
        ckEditor(driver.findElement(By.xpath("((//div[@class=\"question-details-row-solution-editor-div\"])[2])")), "Solution 2 Text");
    }

    @Step("Enter Solution Text 3 value")
    public void enterSolutionText3() {
        //pageScrole(driver.findElement(By.xpath("((//div[@class=\"qquestion-details-solution row-block\"])[1])")));
        ckEditor(driver.findElement(By.xpath("((//div[@class=\"question-details-row-solution-editor-div\"])[3])")), "Solution 3 Text");
    }

    @Step("enter Correct option 1 value")
    public void selectCorrectOption1() {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]/div[1]/div[1]/p")));
        driver.findElement(By.xpath("//*[@class=\"question-details-is-correct-div\"]")).click(); // Select Correct Option 1
    }

    @Step("enter Correct option 2 value")
    public void selectCorrectOption2() {
        driver.findElement(By.xpath("((//*[@class=\"question-details-is-correct-div\"])[2])")).click(); // Select Correct Option 2
    }

    @Step("enter Correct option 3 value")
    public void selectCorrectOption3() {
        driver.findElement(By.xpath("((//*[@class=\"question-details-is-correct-div\"])[3])")).click(); // Select correct Option 3
    }

    @Step("enter Correct option 4 value")
    public void selectCorrectOption4() {
        driver.findElement(By.xpath("((//*[@class=\"question-details-is-correct-div\"])[4])")).click(); // Select correct Option 4
    }

    @Step("Click Add Hint")
    public void clkAddHints() {
        pageScrole(driver.findElement(By.xpath("//*[@class=\"add-update-tag-button\"]")));
        AddHints.click();
    }

    @Step("Click Add Hints and enter value")
    public void enterHints1() {
        clkAddHints();
        ckEditor(driver.findElement(By.xpath("//div[@class=\"hints-editor\"]")), "Test Hint");
        driver.findElement(By.className("hints-sequence")).click();
    }

    @Step("Click Add Hints and enter Hint 2")
    public void enterHint2() {
        clkAddHints();
        ckEditor(driver.findElement(By.xpath("((//div[@class=\"hints-editor\"])[2])")), "Hint 2");
    }

    @Step("Select Difficulty level Concept")
    public void selectDifficultyLevel() {
        pageScrole(driver.findElement(By.xpath("//div[@class=\"question-meta-tags-title-div\"]")));
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 7) + 3; //StepWise solution contains 7 fields with same ID and 3rd field without Step is Difficulty level.
        String Step = String.valueOf(stepSize);
        System.out.println(Step);
        driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])")).click();
        delayTime(TimeDelay.TIME_2000S);
        List<WebElement> difficultyLevels = driver.findElement(By.xpath("//*[@id=\"menu-name\"]/div[3]/ul")).findElements(By.tagName("li"));
        System.out.println(difficultyLevels.size());
        difficultyLevels.get(2).click();
    }

    @Step("Enter Primary Concept")
    public void enterPrimaryConcept(String conceptName) {
        pageScrole(driver.findElement(By.className("question-meta-tags-title")));
        driver.findElement(By.xpath("((//button[@value='name'])[1])")).click();
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 1; //StepWise solution contains 4 fields with same ID
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[" + Step + "])")).sendKeys(conceptName);
        waitUntilElementClickable(primaryConceptList1);
        primaryConceptList1.click();
        delayTime(TimeDelay.TIME_2000S);
        try {
            driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[3]/button/span[1]")).click(); //Click Select after selecting the concept
        } catch (NoSuchElementException e) {

        }
    }

    @Step("Enter Primary Concept Code")
    public void enterPrimaryConceptCode(String conceptCode) {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[5]/div/div[2]/div[2]")));
        driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root MuiToggleButton-root MuiToggleButtonGroup-grouped\"]")).click(); // Toggle button to select Primary concept Code
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 1; //StepWise solution contains 4 fields with same ID
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[" + Step + "])")).sendKeys(conceptCode);
        waitUntilElementClickable(primaryConceptList1);
        primaryConceptList1.click();
        delayTime(TimeDelay.TIME_2000S);
        try {
            driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[3]/button/span[1]")).click(); //Click Select after selecting the concept
        } catch (NoSuchElementException e) {

        }
    }

    @Step("Enter Secondry Concept")
    public void enterSecondryConcept() {
        pageScrole(smartTagDropDown);
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 2; //StepWise solution contains 4 fields with same ID + 2 second field is Secondary Concept
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[" + Step + "])")).sendKeys("Kinetic");
        waitUntilElementClickable(SecondryConceptList1);
        SecondryConceptList1.click();
        delayTime(TimeDelay.TIME_2000S);
        try {
            WebElement secondryConceptSelect = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[3]/button/span[1]"));
            waitUntilElementClickable(secondryConceptSelect);
            secondryConceptSelect.click(); //Click Select after selecting the concept
        } catch (NoSuchElementException e) {

        }
    }

    @Step("Enter Secondry Concept")
    public void enterSecondryConceptCode(String secondaryConceptCode) {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[5]/div/div[2]/div[2]")));
        driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiToggleButton-root MuiToggleButtonGroup-grouped\"])[2])")).click(); // Toogle button to select Secondary concept code
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 2; //StepWise solution contains 4 fields with same ID + 2 second field is Secondary Concept
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[" + Step + "])")).sendKeys(secondaryConceptCode);
        waitUntilElementClickable(SecondryConceptList1);
        SecondryConceptList1.click();
        delayTime(TimeDelay.TIME_2000S);
        try {
            WebElement secondryConceptSelect = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[3]/button/span[1]"));
            waitUntilElementClickable(secondryConceptSelect);
            secondryConceptSelect.click(); //Click Select after selecting the concept
        } catch (NoSuchElementException e) {

        }
    }

    @Step("Add Secondry Concept 2")
    public void enterSecodaryConcept2() {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[5]/div/div[2]/div[2]")));
        addSecondaryConcept.click();
        secondaryConcept2.sendKeys("WATER");
        waitUntilElementClickable(SecondryConceptList1);
        SecondryConceptList1.click();
        delayTime(TimeDelay.TIME_2000S);
        try {
            WebElement secondryConceptSelect = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[3]/button/span[1]"));
            waitUntilElementClickable(secondryConceptSelect);
            secondryConceptSelect.click(); //Click Select after selecting the concept
        } catch (NoSuchElementException e) {

        }
    }

    @Step("Add Secondry Concept 3")
    public void enterSecodaryConcept3() {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[5]/div/div[2]/div[2]")));
        addSecondaryConcept.click();
        secondaryConcept3.sendKeys("Pollution");
        waitUntilElementClickable(SecondryConceptList1);
        SecondryConceptList1.click();
        delayTime(TimeDelay.TIME_2000S);
        try {
            WebElement secondryConceptSelect = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[3]/button/span[1]"));
            waitUntilElementClickable(secondryConceptSelect);
            secondryConceptSelect.click(); //Click Select after selecting the concept
        } catch (NoSuchElementException e) {

        }
    }

    @Step("Remove Secondary Concept")
    public void removeSecondaryConcept() {
        delayTime(TimeDelay.TIME_1000S);
        pageScrole(driver.findElement(By.className("question-meta-tags-title-div")));
        removeSecondaryConcept.click();
        delayTime(TimeDelay.TIME_500S);
        driver.findElement(By.xpath("//*[contains(text(),'Confirm')]")).click(); // Click POPUP confirm
        delayTime(TimeDelay.TIME_500S);
    }

    @Step("Enter Ideal Time")
    public void enterIdealTime() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 1) + 2;
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"outlined-dense\"])[" + Step + "])")).sendKeys(prop.getProperty("ideal_Time"));
    }

    @Step("Click Bloom level drop down")
    public void clkBloomLevel() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 7) + 4; //StepWise solution contains 7 fields with same ID and 4rd field without Step is Bloom level.
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])")).click();
    }

    @Step("select Rote Learning in Bloom level")
    public void selectBloomLevel() {
        waitUntillElementVisible(RoteLearning);
        RoteLearning.click();
    }

    @Step("Click Question Source Drop and Select 2004 type")
    public void SelectQuestionSource() {
        pageScrole(driver.findElement(By.xpath("//*[@class=\"question-meta-tags-title-div\"]")));
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 2) + 4; //StepWise solution contains 2 fields with same ID and 4rd field without Step is Question Source.
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@class=\" css-2b097c-container\"])[" + Step + "])")).click();
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.id("react-select-7-option-0")).click(); // Select 2004 question
    }

    @Step("Click Add video Link Button")
    public void clkAddVideoLinkBtn() {
        pageScrole(driver.findElement(By.xpath("//*[@class=\"question-meta-tags-title-div\"]")));
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = numberSteps.size() + 1; //Steps Contains Add video link on Meta Tags
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//div[@class='add-button'])[" + Step + "])")).click();
    }

    @Step("Enter Video link")
    public void enterVideoLink(String videoLink) {
        pageScrole(driver.findElement(By.className("main-input-question")));
        waitUntillElementVisible(videoLinkText);
        videoLinkText.sendKeys(videoLink);
    }

    @Step("Click Preview button")
    public void clkVideoPreview() {
        delayTime(TimeDelay.TIME_1000S);
        preview.click();
    }

    @Step("Click SELECT on video link ")
    public void clkSelectVideoLink() {
        delayTime(TimeDelay.TIME_2000S);
        confirmVideoLink.click();
    }

    @Step("Enter Topic")
    public void enterTopic(String Topic) {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 3; //StepWise solution contains 4 fields with same ID
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[" + Step + "])")).sendKeys(Topic);
    }

    @Step("Select JEE Main Learning Map")
    public void selectJeeMainLearningMap() {
        List<WebElement> topicJeeMainPhysics = driver.findElements(By.xpath("//*[contains(text(),'JEE Main--Physics')]"));
        String targetClassName = topicJeeMainPhysics.get(0).getAttribute("class").replace("TOPIC", "");
        driver.findElement(By.id("topic-checkbox-" + targetClassName)).click();
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Select JEE main Chemistry Learning Map")
    public void selectJeeMainChemistryLearningMap() {
        List<WebElement> topicJeeMainChemistry = driver.findElements(By.xpath("//*[contains(text(),'JEE Main--Chemistry')]"));
        String targetJeeMainChemistry = topicJeeMainChemistry.get(0).getAttribute("class").replace("TOPIC", "");
        driver.findElement(By.id("topic-checkbox-" + targetJeeMainChemistry)).click();
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Select JEE Advanced Physics Learning Map")
    public void selectJeeAdvancedPhysicsLearningMap() {
        List<WebElement> topicJeeAdvancedPhysics = driver.findElements(By.xpath("//*[contains(text(),'JEE Advanced--Physics')]"));
        String targetJeeAdvancedPhysics = topicJeeAdvancedPhysics.get(0).getAttribute("class").replace("TOPIC", "");
        driver.findElement(By.id("topic-checkbox-" + targetJeeAdvancedPhysics)).click();
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Select JEE Advanced Chemistry Learning Map")
    public void selectJeeAdvancedChemistryLearningMap() {
        List<WebElement> topicJeeAdvancedChemistry = driver.findElements(By.xpath("//*[contains(text(),'JEE Advanced--Chemistry')]"));
        String targetJeeAdvancedChemistry = topicJeeAdvancedChemistry.get(0).getAttribute("class").replace("TOPIC", "");
        driver.findElement(By.id("topic-checkbox-" + targetJeeAdvancedChemistry)).click();
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Select NEET Physics Learning Map")
    public void selectNeetLearningMap() {
        List<WebElement> topicNeetPhysics = driver.findElements(By.xpath("//*[contains(text(),'NEET--Physics')]"));
        String targetNeetPhysics = topicNeetPhysics.get(0).getAttribute("class").replace("TOPIC", "");
        driver.findElement(By.id("topic-checkbox-" + targetNeetPhysics)).click();
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Select NEET Chemistry Learning Map")
    public void selectNeetChemistryLearningMap() {
        List<WebElement> topicNeetChemistry = driver.findElements(By.xpath("//*[contains(text(),'NEET--Chemistry')]"));
        String targetNeetChemistry = topicNeetChemistry.get(0).getAttribute("class").replace("TOPIC", "");
        driver.findElement(By.id("topic-checkbox-" + targetNeetChemistry)).click();
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Select NEET Biology Learning Map")
    public void selectNeetBiologyLearningMap() {
        List<WebElement> topicNeetBiology = driver.findElements(By.xpath("//*[contains(text(),'NEET--Biology')]"));
        String targetNeetBiology = topicNeetBiology.get(0).getAttribute("class").replace("TOPIC", "");
        driver.findElement(By.id("topic-checkbox-" + targetNeetBiology)).click();
        delayTime(TimeDelay.TIME_1000S);
    }

    public void ClkDoneQuestionLearningMap() {
        driver.findElement(By.xpath("//*[@id=\"downshift-simple-menu\"]/div/div[2]/div")).click(); // Click Done button after learning Map selection
    }

    @Step("Click Status Drop Down")
    public void selectStatus() {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[8]/div/div[1]")));
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 7) + 10; //StepWise solution contains 7 fields with same ID and 10rd field without Step is Status dropDown.
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])")).click();
    }

    @Step("Click Save Button")
    public void clkSaveBtn() {
        pageScrole(driver.findElement(By.className("question-learning-maps-title-div")));
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.xpath("//div[@class='footer-add-choice-button-save']")).click(); // Click Save Button
        delayTime(TimeDelay.TIME_3000S);
    }

    // Question Details
    public void waitForQuestionEditorEnable() {
        waitUntillElementVisible(questionEditor);
    }

    public void removeOption3and4() {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"1\"]/div/div[1]/p")));
        for (int del = 0; del <= 1; del++) {
            driver.findElement(By.xpath("//*[@id=\"2\"]/div/div[4]")).click(); // Click on remove icon in option 3
            delayTime(TimeDelay.TIME_1000S);
            driver.findElement(By.xpath("//*[contains(text(),'Confirm')]")).click();
            delayTime(TimeDelay.TIME_1000S);
        }
    }

    // Single Choice Question Details
    public void singleChoiceQuestionDetails() {
        enterQuestionText(prop.getProperty("SingleChoiceQuestionText"));
        delayTime(TimeDelay.TIME_1000S);
        enterOptionText1(prop.getProperty("option1"));
        delayTime(TimeDelay.TIME_1000S);
        enterOptionText2(prop.getProperty("MultiChoiceAnserText"));
        delayTime(TimeDelay.TIME_1000S);
        enterSolutionText1();
        selectCorrectOption1();
        removeOption3and4();
    }

    // multi Choice Question Details
    public void multiChoiceQuestionDetails() {
        enterQuestionText(prop.getProperty("MultiChoiceQuestionText"));
        delayTime(TimeDelay.TIME_1000S);
        enterOptionText1(prop.getProperty("option1"));
        delayTime(TimeDelay.TIME_1000S);
        enterOptionText2(prop.getProperty("MultiChoiceAnserText"));
        delayTime(TimeDelay.TIME_1000S);
        enterSolutionText1();
        delayTime(TimeDelay.TIME_1000S);
        enterSolutionText2();
        selectCorrectOption1();
        selectCorrectOption2();
        removeOption3and4();
    }

    // True False Question Details
    public void TrueFalseQuestionDetails() {
        enterQuestionText(prop.getProperty("TrueFalseQuestionText"));
        delayTime(TimeDelay.TIME_1000S);
        enterSolutionText1();
        selectCorrectOption1();
    }

    //Interger Type Question
    public void intergerQuestionDetails() {
        enterQuestionText(prop.getProperty("IntegerQuestionText"));
        OptionTextBox.sendKeys(prop.getProperty("integer"));
        delayTime(TimeDelay.TIME_1000S);
        enterSolutionText1();
    }

    //SubjectiveNumerical Type Question
    public void subjectiveNumericalQuestionDetails() {
        enterQuestionText(prop.getProperty("SubjectiveNumericalQuestionText"));
        OptionTextBox.sendKeys(prop.getProperty("SubjectiveNumerical"));
        delayTime(TimeDelay.TIME_1000S);
        enterSolutionText1();
    }

    //Subjective Answer Type Question
    public void subjectiveAnswerDetails() {
        delayTime(TimeDelay.TIME_5000S);
        enterQuestionText(prop.getProperty("SingleChoiceQuestionText"));
        enterOptionText1(prop.getProperty("option1"));
        delayTime(TimeDelay.TIME_1000S);
        enterSolutionText1();
    }

    // Assertion Type Question
    public void assertionQuestionDetails() {
        enterQuestionText(prop.getProperty("AssertionQuestionText"));
        enterSolutionText2();
        selectCorrectOption2();
    }

    // Fill In The Blanks
    public void fillInTheBlanksQuestionDetails() {
        enterQuestionText(prop.getProperty("FillInTheBlanksQuestionText"));
        enterOptionText1(prop.getProperty("FillInTheBlanksAnswer"));
        enterSolutionText1();
    }

    // Multiple Fill In The Blanks
    public void multipleFillInTheBlanksQuestionDetails() {
        enterQuestionText(prop.getProperty("MultipleFillInTheBlanksQuestionText"));
        enterOptionText1(prop.getProperty("MultipleFillInTheBlanksAnswer1"));
        enterOptionText2(prop.getProperty("MultipleFillInTheBlanksAnswer1"));
        enterSolutionText1();
        enterSolutionText2();
        removeOption3and4();
    }

    // Subjective Type Question
    public void subjectiveQuestionDetails() {
        enterQuestionText(prop.getProperty("SubjectiveQuestionText"));
        enterSubjectiveSolutionText();
        delayTime(TimeDelay.TIME_1000S);
    }

    // Linked Comprehension Type Question
    public void linkedComprehensionQuestionDetails() {
        enterQuestionText(prop.getProperty("linkedComprehensionQuestionText"));
        pageScroleMiddle(driver.findElement(By.className("link-save-btn")));
        driver.findElement(By.className("link-save-btn")).click(); // Click on Save button for Linked Comprehension questions
        verifyAnyErrorMessageWhileSave();
    }

    public void multipleDropDownQuestionDetails() {
        enterQuestionText(prop.getProperty("SingleChoiceQuestionText"));
        enterOptionText1(prop.getProperty("option1"));
        selectCorrectOption1();
        enterSolutionText1();
        enterOptionText2(prop.getProperty("option2"));
        clkAddDropDown();
        enterOptionText3(prop.getProperty("option3"));
        enterSolutionText3();
        selectCorrectOption3();
        enterOptionText4(prop.getProperty("option4"));
    }

    public void linkedComprehensionAssociateQuestions() {
        AssociateQuestionsTextBoxLinkedComprehension.sendKeys(prop.getProperty("linkedComprehensionAssociateQuestionsId1"));
        delayTime(TimeDelay.TIME_1000S);
        addQuestionBtnLinkedComprehension.click();
        verifyAnyErrorMessageWhileSave();
        delayTime(TimeDelay.TIME_2000S);
        AssociateQuestionsTextBoxLinkedComprehension.sendKeys(prop.getProperty("linkedComprehensionAssociateQuestionsId2"));
        delayTime(TimeDelay.TIME_1000S);
        addQuestionBtnLinkedComprehension.click();
        verifyAnyErrorMessageWhileSave();
    }

    public void enterRowsandColumnsInMatrixGrid(String row, String column) {
        pageScrole(driver.findElement(By.xpath("//*[@class=\"question-details-title\"]")));
        driver.findElement(By.xpath("//*[@class=\"row-input\"]/input")).sendKeys(row);
        driver.findElement(By.xpath("//*[@class=\"column-input\"]/input")).sendKeys(column);
        driver.findElement(By.xpath("//*[@class=\"create-grid-button\"]")).click();
    }

    public void selectCorrectAnswerMatrixGrid() {
        Random objGenerator = new Random();
        for (int iCount = 1; iCount < 8; iCount++) {
            int randomNumber = objGenerator.nextInt(15) + 1;
            delayTime(TIME_500S);
            driver.findElement(By.xpath("((//*[@class=\"cell\"]/input)[" + randomNumber + "])")).click();
        }
    }

    public void clkAddDropDown() {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"1\"]/div/div[3]/span")));
        driver.findElement(By.className("question-details-drop-down")).click();
    }

    // Book Meta Tag
    public void BookMetaTags() {
        delayTime(TimeDelay.TIME_2000S);
        pageScrole(driver.findElement(By.xpath("//*[contains(text(),'Book Meta Tags')]")));
        delayTime(TimeDelay.TIME_1000S);
        clkBookType();
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.id("react-select-5-option-2")).click(); // Select Book
        delayTime(TimeDelay.TIME_1000S);
        clkBookSelection();
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.id("react-select-6-option-0")).click();
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.xpath("//div[@class='add-tag-button']")).click(); // Click on Add Tag Button
    }

    public void clkBookType() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 2) + 3; //StepWise solution contains 2 fields with same class name and 3rd field without Step is Book type.
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@class=\" css-2b097c-container\"])[" + Step + "])")).click();
    }

    public void clkBookSelection() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 2) + 4; //StepWise solution contains 2 fields with same class name and 3rd field without Step is Book type.
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@class=\" css-2b097c-container\"])[" + Step + "])")).click();
    }

    // Question Meta
    public void questionsMetaTag1() {
        pageScroleMiddle(driver.findElement(By.xpath("//*[@class=\"question-meta-tags-title-div\"]")));
        selectDifficultyLevel();
        enterIdealTime();
        delayTime(TimeDelay.TIME_1000S);
        clkBloomLevel();
        delayTime(TimeDelay.TIME_1000S);
        selectBloomLevel();
        delayTime(TimeDelay.TIME_1000S);
        enterPrimaryConcept(prop.getProperty("ConceptName"));
        enterSecondryConcept();
        delayTime(TimeDelay.TIME_1000S);
        SelectQuestionSource();
        delayTime(TimeDelay.TIME_1000S);
        clkAddVideoLinkBtn();
        delayTime(TimeDelay.TIME_2000S);
        enterVideoLink(prop.getProperty("validVideoLink"));
        delayTime(TimeDelay.TIME_1000S);
        clkVideoPreview();
        delayTime(TimeDelay.TIME_2000S);
        clkSelectVideoLink();
        delayTime(TimeDelay.TIME_2000S);
    }

    // Question Learning MAP
    public void QuestionLearningMaps() {
        pageScrole(driver.findElement(By.xpath("//*[@class=\"question-learning-maps-title-div\"]")));
        enterTopic(prop.getProperty("JEEmainTopic"));
        waitUntilElementClickable(firstTopicCheckBox);
        selectJeeMainLearningMap();
        selectNeetLearningMap();
        delayTime(TimeDelay.TIME_2000S);
        ClkDoneQuestionLearningMap();

    }

    //Verify Book Meta Tags
    public void verifyBookMetaTags() {
        pageScrole(driver.findElement(By.xpath("//*[contains(text(),'Book Meta Tags')]")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='preview-tags']//*[@class='preview-tag-field']")).isDisplayed());
    }

    //Verify Question Meta details
    public void verifyQuestionMetaDetails() {
        pageScrole(driver.findElement(By.className("custom-tags-title-div")));
        verifyDifficultyLevel();
        verifyIdealTime();
        verifyBloomLevel();
        verifyPrimaryConcept();
        verifySecondaryConcept();
        verifyQuestionSource();
    }

    public void verifyDifficultyLevel() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 7) + 3; //StepWise solution contains 7 fields with same ID and 3rd field without Step is Difficulty level.
        String Step = String.valueOf(stepSize);
        WebElement DifficultyLevel = driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])"));
        String difficultyLevelText = DifficultyLevel.getText();
        if (difficultyLevelText.isEmpty()) {
            System.out.println("Difficulty Empty");
            Assert.assertFalse(DifficultyLevel.isDisplayed());
        } else {
            System.out.println("Difficulty Level present");
        }
    }

    public void verifyIdealTime() {
        if (idealTime.isDisplayed()) {
            System.out.println("Ideal Time Present");
        } else {
            System.out.println("Ideal Time Empty");
            Assert.assertFalse(idealTime.isDisplayed());
        }
    }

    public void verifyBloomLevel() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 7) + 4; //StepWise solution contains 7 fields with same ID and 4rd field without Step is Bloom level.
        String Step = String.valueOf(stepSize);
        WebElement BloomLevel = driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])"));
        String bloomLevelText = BloomLevel.getText();
        if (bloomLevelText.isEmpty()) {
            System.out.println("Bloom Level Empty");
            Assert.assertFalse(BloomLevel.isDisplayed());
        } else {
            System.out.println("Bloom Level Present");
        }
    }

    public void verifyPrimaryConcept() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 1; //StepWise solution contains 4 fields with same ID
        String Step = String.valueOf(stepSize);
        WebElement PrimaryConcept = driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[" + Step + "])"));

        String primayConceptInput = PrimaryConcept.getAttribute("value");
        if (primayConceptInput.isEmpty()) {
            System.out.println("Primary Concept Removed");
            Assert.assertFalse(PrimaryConcept.isDisplayed());
        } else {
            System.out.println("Primary Concept Present");
        }
    }

    public void verifySecondaryConcept() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 2; //StepWise solution contains 4 fields with same ID + 2 second field is Secondary Concept
        String Step = String.valueOf(stepSize);
        WebElement secondaryConcept = driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[" + Step + "])"));

        String secondaryConceptInput = secondaryConcept.getAttribute("value");
        if (secondaryConceptInput.isEmpty()) {
            System.out.println("Secondary Concept Empty");
            Assert.assertFalse(secondaryConcept.isDisplayed());
        }
        System.out.println("Secondary Concept Present");
    }

    public void verifySecondaryConcept2() {
        String secondaryConceptInput = secondaryConcept2.getAttribute("value");
        if (secondaryConceptInput.isEmpty()) {
            System.out.println("Secondary Concept Empty");
            Assert.assertFalse(secondaryConcept2.isDisplayed());
        }
        System.out.println("Secondary-2 Concept Present");
    }

    public void verifySecondaryConcept3() {
        String secondaryConceptInput = secondaryConcept3.getAttribute("value");
        if (secondaryConceptInput.isEmpty()) {
            System.out.println("Secondary Concept Empty");
            Assert.assertFalse(secondaryConcept3.isDisplayed());
        }
        System.out.println("Secondary-3 Concept Present");
    }

    public void verifyQuestionSource() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 2) + 4; //StepWise solution contains 2 fields with same ID and 4rd field without Step is Question Source.
        String Step = String.valueOf(stepSize);
        WebElement questionSourceInputValue = driver.findElement(By.xpath("((//*[@class=\" css-2b097c-container\"])[" + Step + "])"));

        String questionSourceInput = questionSourceInputValue.getText();
        if (questionSourceInput.isEmpty()) {
            Assert.assertFalse(questionSourceInputValue.isDisplayed());
            System.out.println("Question Source Removed");
        } else {
            System.out.println("Question Source Present");
        }
    }

    public void verifyVideoSolutionForSavedQuestion() {
        pageScrole(driver.findElement(By.className("custom-tags-title-div")));
        String videoSolutionInputValue = driver.findElement(By.xpath("//*[@class=\"main-input-question\"]/input")).getAttribute("value"); // Get the values from the video text box
        Assert.assertEquals(videoSolutionInputValue, prop.getProperty("validVideoLink"));
        System.out.println("Video Link Present");
    }

    public void verifyInvalidLinkOnVideoSolution() {
        waitUntillElementVisible(errorMessageInvalidVideoLink);
        String invalidVideoLink = errorMessageInvalidVideoLink.getText();
        Assert.assertEquals(invalidVideoLink, "Invalid video link");
    }

    public void verifyQuestionLearningMaps() {
        pageScrole(driver.findElement(By.xpath("//*[@class=\"question-learning-maps-title-div\"]")));
        verifyTopicQuestionLearningMaps();
        verifySubjectQuestionLearningMap();
        verifyGoalQuestionLearningMap();
        verifyUnitQuestionLearningMap();
        verifyExamQuestionLearningMap();
        verifyChapterQuestionLearningMap();
    }

    public void verifyTopicQuestionLearningMaps() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 4; //StepWise solution contains 4 fields with same ID Already saved Topic under 4 ID
        String Step = String.valueOf(stepSize);
        WebElement topicInput = driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[" + Step + "])"));
        String topic = topicInput.getAttribute("value");
        System.out.println(topic);
        if (topic.isEmpty()) {
            System.out.println("topic empty");
            Assert.assertFalse(topicInput.isDisplayed());
        } else {
            System.out.println("Topic present");
        }
    }

    public void verifySubjectQuestionLearningMap() {
        List<WebElement> numberSteps1 = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps1.size() * 4) + 5; //StepWise solution contains 4 fields with same ID Subject under 5 ID
        String Step1 = String.valueOf(stepSize);
        WebElement subjectInput1 = driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step1 + "])"));
        String subject1 = subjectInput1.getText();
        System.out.println(subject1);
        if (subject1.isEmpty()) {
            System.out.println("Subject Empty");
            Assert.assertFalse(subjectInput1.isDisplayed());
        } else {
            System.out.println("Subject available");
        }
    }

    public void verifyGoalQuestionLearningMap() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 6; //StepWise solution contains 4 fields with same ID Goal under 5 ID
        String Step = String.valueOf(stepSize);
        WebElement goalInput = driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])"));
        String goals = goalInput.getText();
        System.out.println(goals);
        if (goals.isEmpty()) {
            System.out.println("Goals Empty");
            Assert.assertFalse(goalInput.isDisplayed());
        } else {
            System.out.println("Goals Present");
        }
    }

    public void verifyUnitQuestionLearningMap() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 6; //StepWise solution contains 4 fields with same ID Unit under 5 ID
        String Step = String.valueOf(stepSize);
        WebElement unitInput = driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])"));
        String units = unitInput.getText();
        System.out.println(units);
        if (units.isEmpty()) {
            System.out.println("Units Empty");
            Assert.assertFalse(unitInput.isDisplayed());
        } else {
            System.out.println("Units Present");
        }
    }

    public void verifyExamQuestionLearningMap() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 6; //StepWise solution contains 4 fields with same ID Exam under 5 ID
        String Step = String.valueOf(stepSize);
        WebElement examInput = driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])"));
        String exams = examInput.getText();
        System.out.println(exams);
        if (exams.isEmpty()) {
            System.out.println("Exam field Empty");
            Assert.assertFalse(examInput.isDisplayed());
        } else {
            System.out.println("Exam Field Present");
        }
    }

    @Step("Verify Chapter in Question Learning Map")
    public void verifyChapterQuestionLearningMap() {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = (numberSteps.size() * 4) + 6; //StepWise solution contains 4 fields with same ID Chapter under 5 ID
        String Step = String.valueOf(stepSize);
        WebElement chapterInput = driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])"));
        String chapter = chapterInput.getText();
        System.out.println(chapter);
        if (chapter.isEmpty()) {
            System.out.println("Chapter field Empty");
            Assert.assertFalse(chapterInput.isDisplayed());
        } else {
            System.out.println("Chapter Field Present");
        }
    }

    @Step("Verify Question ID")
    public void verifyQuestionIDfield() {
        waitUntillElementVisible(questionID);
        pageScrole(driver.findElement(By.className("key-attributes-title-div")));
        String ID = questionID.getAttribute("value");
        if (ID.isEmpty()) {
            System.out.println("Question ID not generated");
        } else {
            System.out.println("Question ID is " + ID);
        }
    }

    @Step("Verify version number change")
    public void verifyVersionChange(String expectedVersion) {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/div[1]/p")));
        WebElement questionVersion = driver.findElement(By.xpath("//div[@class=\"version-number\"]"));
        String versionValue = questionVersion.getText();
        System.out.println("Current version of the Question " + versionValue);
        Assert.assertEquals(versionValue, expectedVersion);
    }

    @Step("Verify versioning editor Name")
    public void verifyVersionEditorName(String expectedName) {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[1]/div[1]/p")));
        WebElement questionEditor = driver.findElement(By.xpath("//div[@class=\"editor-main-label\"]"));
        String questionEditorName = questionEditor.getText();
        System.out.println("Current version Editor Name is " + questionEditorName);
        Assert.assertEquals(questionEditorName, expectedName);
    }

    @Step("Open already created Question")
    public void openNewlyCreatedQuestion() {
        waitUntilListDisplay();
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[2]/div[3]/div/p")));
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[3]/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/div/a")).click();
    }

    @Step("Verify Curator Name")
    public void verifyCuratorName() {
        String curatorName = curator.getText();
        Assert.assertEquals(curatorName, "CG01 Automation");
        System.out.println("Curator name Present is " + curatorName);
    }

    @Step("Select Partner Name")
    public void selectPartner(String partnerName) {
        delayTime(TimeDelay.TIME_2000S);
        partnerTextBox.sendKeys(partnerName);
        partnerTextBox.sendKeys(Keys.ENTER);
    }

    @Step("Verify Language")
    public void verifyLanguage() {
        if (driver.findElements(By.xpath("//*[@id=\"app\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div")).size() != 0) {
            String languagePresent = driver.findElement(By.xpath("//*[@class=' css-14jk2my-container']")).getText();
            Assert.assertEquals(languagePresent, "English");
            System.out.println("New Question");
        } else {
            String languagePresent = driver.findElement(By.xpath("((//*[@class=' css-14jk2my-container'])[2])")).getText();
            Assert.assertEquals(languagePresent, "English");
            System.out.println("Already created Question");
        }
    }

    @Step("Verify Partner Name")
    public void verifyPartnerName() {
        delayTime(TimeDelay.TIME_2000S);
        if (driver.findElements(By.xpath("//*[@id=\"app\"]/div/div[3]/div[2]/div[3]/div/div[2]/div/div/div")).size() != 0) {
            WebElement partner = driver.findElement(By.xpath("((//div[@class=\" css-2b097c-container\"])[2])"));
            String partnerNa = partner.getText();
            Assert.assertEquals(partnerNa, "Imagin8ors");
            System.out.println(partnerNa);
        } else {
            WebElement partner = driver.findElement(By.xpath("((//div[@class=\" css-2b097c-container\"])[1])"));
            String partnerNa = partner.getText();
            Assert.assertEquals(partnerNa, "Imagin8ors");
            System.out.println(partnerNa);
        }
    }

    @Step("Click Check for Duplication")
    public void clkDupication() {
        pageScrole(driver.findElement(By.xpath("//div[@class=\"key-attributes-title-div\"]")));
        driver.findElement(By.xpath("//*[@class='question-details-title-div']//*[@class='MuiButtonBase-root MuiIconButton-root']")).click(); // Click Hamburger Icon
        driver.findElement(By.xpath("//*[@id=\"long-menu\"]/div[3]/ul/li")).click(); //Click "Check for Duplicates"
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[3]/div/div[1]/button/span[1]"))); // wait until popup for the list of question id's
    }

    @Step("Close duplication window")
    public void closeDuplication() {
        driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[1]/button/span[1]")).click(); // Close the Deduplication Pop up window
    }

    @Step("Select JEE main Exam Type on Smart Tagging")
    public void selectSmartTaggingJEEmain() {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[5]/div/p")));
        smartTagDropDown.click();
        driver.findElement(By.id("JEE Main")).click();
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Select NEET Exam Type on Smart Tagging")
    public void selectSmartTaggingNEET() {
        smartTagDropDown.click();
        driver.findElement(By.id("NEET")).click();
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Click Smart Tag Button")
    public void clkSmartTagButton() {
        pageScrole(AddHints);
        driver.findElement(By.xpath("((//div[@class='add-hints-btn'])[2])")).click();
    }

    //Step by Step Solution

    @Step("Verify Create Update Step button")
    public void verifyStepButton() {
        Assert.assertTrue(createStepButton.isDisplayed());
    }

    @Step("Verify Create Update Step button")
    public void clkCreateStepButton() {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]/div[1]/div[1]/p")));
        createStepButton.click();
    }

    @Step("Verify error message while create step with empty solution")
    public void verifyErrorMessage(String errorMessage) {
        delayTime(TimeDelay.TIME_500S);
        String validationMessage = snackBar.getText();
        System.out.println(validationMessage);
        Assert.assertEquals(validationMessage, errorMessage);
    }

    @Step("Verify Any error message while create question")
    public void verifyAnyErrorMessageWhileSave() {
        delayTime(TimeDelay.TIME_2000S);
        try {
            String validationMessage = snackBar.getText();
            System.out.println(validationMessage);
            Assert.assertFalse(snackBar.isDisplayed());
        } catch (Exception e) {
        }
    }

    @Step("Click Block Quotes")
    public void clkBlockQuotes() {
        driver.findElement(By.xpath("//span[@class=\"cke_button_icon cke_button__blockquote_icon\"]")).click();
    }

    @Step("Verify Steps")
    public void verifyStepsCount(String expectedSteps) {
        List<WebElement> numberSteps = driver.findElement(By.xpath("//div[@class=\"question-details\"]")).findElements(By.className("stepwise-solution-container"));
        int stepSize = numberSteps.size();
        String Step = String.valueOf(stepSize);
        Assert.assertEquals(Step, expectedSteps);
    }

    @Step("Click Meta Tags on Step")
    public void clickMetaTagsOnStep(String stepNumber) {
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        if (noOfStep == 1) {
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[1])")).click(); // select META TAGS TAB
        }
        if (noOfStep == 2) {
            pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]/div[5]/div[1]/div/div[4]/div/div[5]/div[2]/div/p")));
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[5])")).click();
        }
        if (noOfStep == 3) {
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[9])")).click();
        }
        if (noOfStep == 4) {
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[13])")).click();
        }
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Select Difficulty level Concept")
    public void selectDifficultyLevelOnStep(String stepNumber) {

        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        if (noOfStep == 1) {
            int stepSize = (noOfStep * 0) + 2;
            String Step = String.valueOf(stepSize);
            driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])")).click();
        }
        if (noOfStep == 2) {
            int stepSize = 9;
            String Step = String.valueOf(stepSize);
            driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])")).click();
        }
        if (noOfStep == 3) {
            int stepSize = 16;
            String Step = String.valueOf(stepSize);
            driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])")).click();
        }
        if (noOfStep == 4) {
            int stepSize = 23;
            String Step = String.valueOf(stepSize);
            driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])")).click();
        }
        delayTime(TimeDelay.TIME_1000S);
        List<WebElement> difficultyLevels = driver.findElement(By.xpath("//*[@id=\"menu-name\"]/div[3]/ul")).findElements(By.tagName("li"));
        System.out.println(difficultyLevels.size());
        difficultyLevels.get(2).click();
    }

    @Step("Remove Step")
    public void removeStep() {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]/div[3]/div[5]/p")));
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.xpath("((//div[@class=\"question-details-row-solution-editor-div\"])[1])")).click();
        delayTime(TimeDelay.TIME_1000S);
        String CWH = driver.getWindowHandle();
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        delayTime(TimeDelay.TIME_500S);
        WebElement sat = driver.findElement(By.tagName("body"));
        sat.click();
        for (int i = 1; i <= 9; i++) {
            sat.sendKeys(Keys.BACK_SPACE);
        }
        driver.switchTo().window(CWH);
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Enter Primary Concept on Steps")
    public void enterPrimaryConceptOnStepNumber(String stepNumber, String conceptName) {
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[5]/div/div[2]/div[2]")));
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        int stepSize = ((noOfStep - 1) * 4) + 1;
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[" + Step + "])")).sendKeys(conceptName);
        waitUntilElementClickable(primaryConceptList1);
        primaryConceptList1.click();
        delayTime(TimeDelay.TIME_2000S);
        try {
            driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[3]/button/span[1]")).click(); //Click Select after selecting the concept
        } catch (NoSuchElementException e) {

        }
    }

    @Step("Enter Secondry Concept on Steps")
    public void enterSecondryConceptOnStepNumber(String stepNumber) {
        pageScrole(createStepButton);
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        int stepSize = ((noOfStep - 1) * 4) + 2;
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[" + Step + "])")).sendKeys("Kinetic");
        waitUntilElementClickable(SecondryConceptList1);
        SecondryConceptList1.click();
        delayTime(TimeDelay.TIME_2000S);
        try {
            WebElement secondryConceptSelect = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[3]/button/span[1]"));
            waitUntilElementClickable(secondryConceptSelect);
            secondryConceptSelect.click(); //Click Select after selecting the concept
        } catch (NoSuchElementException e) {
        }
    }

    @Step("Enter Ideal Time on Steps")
    public void enterIdealTimeOnStepNumber(String stepNumber) {
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        int stepSize = (noOfStep * 1);
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"outlined-dense\"])[" + Step + "])")).sendKeys(prop.getProperty("ideal_Time"));
    }

    @Step("Click Bloom level drop down on Steps")
    public void clkBloomLevelOnStepNumber(String stepNumber) {
        delayTime(TimeDelay.TIME_1000S);
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        if (noOfStep == 1) {
            int stepSize = (noOfStep * 1) + 2; // 2, 12, 17, 24
            String Step = String.valueOf(stepSize);
            driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[" + Step + "])")).click();
        }
        if (noOfStep == 2) {
            driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[10])")).click();
        }
        if (noOfStep == 3) {
            driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[17])")).click();
        }
        if (noOfStep == 4) {
            driver.findElement(By.xpath("((//*[@id=\"mui-component-select-name\"])[24])")).click();
        }
        waitUntillElementVisible(RoteLearning);
        RoteLearning.click();
    }

    @Step("Click Question Source DropDown on Step and Select 2004 type")
    public void SelectQuestionSourceOnStepNumber(String stepNumber) {
        delayTime(TimeDelay.TIME_1000S);
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        if (noOfStep == 1) {
            if (driver.findElement(By.className("steps-primary-competency")) == null) {
                driver.findElement(By.xpath("((//*[@class='stepwise-solution-container']//*[@class=' css-2b097c-container'])[" + noOfStep + "])")).click();
            } else {
                driver.findElement(By.xpath("((//*[@class='stepwise-solution-container']//*[@class=' css-2b097c-container'])[" + 2 + "])")).click();
            }
        } else if (noOfStep == 2) {
            if (driver.findElement(By.className("steps-primary-competency")) == null) {
                driver.findElement(By.xpath("((//*[@class='stepwise-solution-container']//*[@class=' css-2b097c-container'])[" + noOfStep + "])")).click();
            } else {
                driver.findElement(By.xpath("((//*[@class='stepwise-solution-container']//*[@class=' css-2b097c-container'])[" + 4 + "])")).click();
            }
        } else if (noOfStep == 3) {
            if (driver.findElement(By.className("steps-primary-competency")) == null) {
                driver.findElement(By.xpath("((//*[@class='stepwise-solution-container']//*[@class=' css-2b097c-container'])[" + noOfStep + "])")).click();
            } else {
                driver.findElement(By.xpath("((//*[@class='stepwise-solution-container']//*[@class=' css-2b097c-container'])[" + 6 + "])")).click();
            }
        }
        waitUntilElementClickable(driver.findElement(By.xpath("//div[@class=\" css-1n7v3ny-option\"]")));
        driver.findElement(By.xpath("//div[@class=\" css-1n7v3ny-option\"]")).click();
    }

    @Step("Add video Link")
    public void addVideoLink(String stepNumber) {
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        int stepSize = noOfStep;
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//div[@class='add-button'])[" + Step + "])")).click();
        videoLinkText.sendKeys(prop.getProperty("validVideoLink"));
        delayTime(TimeDelay.TIME_1000S);
        preview.click();
        delayTime(TimeDelay.TIME_1000S);
        pageScrole(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]/div[5]/div[" + stepNumber + "]/div/div[3]/div/div[4]/div[1]")));
        confirmVideoLink.click();
    }

    public void enterMetaTagStepToStepNumber(String stepNumber, String conceptName) {
        clickMetaTagsOnStep(stepNumber);
        selectDifficultyLevelOnStep(stepNumber);
        enterPrimaryConceptOnStepNumber(stepNumber, conceptName);
        enterSecondryConceptOnStepNumber(stepNumber);
        enterIdealTimeOnStepNumber(stepNumber);
        clkBloomLevelOnStepNumber(stepNumber);
        SelectQuestionSourceOnStepNumber(stepNumber);
        addVideoLink(stepNumber);
    }

    public void clkLearningMapOnStepNumber(String stepNumber) {
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        if (noOfStep == 1) {
            delayTime(TimeDelay.TIME_2000S);
            pageScrole(driver.findElement(By.xpath("//*[@id=\"0\"]/div/div[1]/p")));
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[2])")).click(); // select META TAGS TAB
        }
        if (noOfStep == 2) {
            pageScrole(driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[5])")));
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[6])")).click();
        }
        if (noOfStep == 3) {
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[10])")).click();
        }
        if (noOfStep == 4) {
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[12])")).click();
        }
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Enter Topic Name on Steps")
    public void enterTopicOnStepNumber(String stepNumber) {
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        int stepSize = ((noOfStep - 1) * 4) + 3;
        String Step = String.valueOf(stepSize);
        driver.findElement(By.xpath("((//*[@id=\"downshift-simple-input\"])[" + Step + "])")).sendKeys("Energy");
        waitUntilElementClickable(firstTopicCheckBox);
        List<WebElement> topicJeeMainPhysics = driver.findElements(By.xpath("//*[contains(text(),'JEE Main--Physics')]"));
        String targetClassName = topicJeeMainPhysics.get(0).getAttribute("class").replace("TOPIC", "");
        driver.findElement(By.id("topic-checkbox-" + targetClassName)).click();
        delayTime(TimeDelay.TIME_1000S);
        ClkDoneQuestionLearningMap();
    }

    public void clkHintsOnStepNumber(String stepNumber) {
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        if (noOfStep == 1) {
            delayTime(TimeDelay.TIME_2000S);
            pageScrole(driver.findElement(By.xpath("//*[@id=\"0\"]/div/div[1]/p")));
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[3])")).click();
        }
        if (noOfStep == 2) {
            pageScrole(driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[5])")));
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[7])")).click();
        }
        if (noOfStep == 3) {
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[11])")).click();
        }
        if (noOfStep == 4) {
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[13])")).click();
        }
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Enter Hints on Step")
    public void enterHintsOnStep(String stepNumber) {
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        if (noOfStep == 1) {
            ckEditor(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]/div[5]/div[" + stepNumber + "]/div/div[5]/div/div[2]")), "Step 1 Hint");
        }
        if (noOfStep == 2) {
            ckEditor(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]/div[5]/div[" + stepNumber + "]/div/div[5]/div/div[2]")), "Step 2 Hint");
        }
        if (noOfStep == 3) {
            ckEditor(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]/div[5]/div[" + stepNumber + "]/div/div[5]/div/div[2]")), "Step 3 Hint");
        }
        if (noOfStep == 4) {
            ckEditor(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[3]/div[5]/div[" + stepNumber + "]/div/div[5]/div/div[2]")), "Step 4 Hint");
        }
    }

    public void clkMarksOnStepNumber(String stepNumber) {
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        if (noOfStep == 1) {
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[4])")).click();
        }
        if (noOfStep == 2) {
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[8])")).click();
        }
        if (noOfStep == 3) {
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[12])")).click();
        }
        if (noOfStep == 4) {
            driver.findElement(By.xpath("((//button[@class=\"MuiButtonBase-root MuiTab-root MuiTab-textColorInherit\"])[14])")).click();
        }
        delayTime(TimeDelay.TIME_1000S);
    }

    @Step("Enter Steps Mark")
    public void enterMarksForStep(String stepNumber) {
        int noOfStep = java.lang.Integer.parseInt(stepNumber);
        if (noOfStep == 1) {
            driver.findElement(By.xpath("((//input[@id=\"Marks\"])[" + stepNumber + "])")).sendKeys("2");
        }
        if (noOfStep == 2) {
            driver.findElement(By.xpath("((//input[@id=\"Marks\"])[" + stepNumber + "])")).sendKeys("2");
        }
        if (noOfStep == 3) {
            driver.findElement(By.xpath("((//input[@id=\"Marks\"])[" + stepNumber + "])")).sendKeys("2");
        }
        if (noOfStep == 4) {
            driver.findElement(By.xpath("((//input[@id=\"Marks\"])[" + stepNumber + "])")).sendKeys("2");
        }
    }

    @Step("Select Competency For Primary Competency")
    public void selectCompetencyForPrimaryCompetency() {
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.xpath("//*[@class='primary-competency']//*[@class=' css-2b097c-container']")).click();
        List<WebElement> competencyList = driver.findElements(By.xpath("//*[@class=' css-1575kqa-menu']//*[contains(@id,'react-select')]"));
        int availableCompetency = competencyList.size();
        System.out.println(availableCompetency);
        for (int i = 0; i < availableCompetency; i++) {
            System.out.println(i);
            competencyList.get(i).click();
            delayTime(TimeDelay.TIME_1000S);
        }
        driver.findElement(By.xpath("//*[@class='primary-competency']//*[@class=' css-2b097c-container']")).click();
    }

    @Step("Select Competency For Step Primary Competency")
    public void selectCompetencyForStepPrimaryCompetency(String stepNumber) {
        pageScroleMiddle(driver.findElement(By.xpath("((//*[@class='steps-primary-competency']//*[@class=' css-2b097c-container'])[" + stepNumber + "])")));
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.xpath("((//*[@class='steps-primary-competency']//*[@class=' css-2b097c-container'])[" + stepNumber + "])")).click();
        List<WebElement> competencyList = driver.findElements(By.xpath("//*[@class=' css-1575kqa-menu']//*[contains(@id,'react-select')]"));
        int availableCompetency = competencyList.size();
        System.out.println(availableCompetency);
        for (int i = 0; i < availableCompetency; i++) {
            System.out.println(i);
            competencyList.get(i).click();
            delayTime(TimeDelay.TIME_1000S);
        }
        driver.findElement(By.xpath("((//*[@class='steps-primary-competency']//*[@class=' css-2b097c-container'])[" + stepNumber + "])")).click();
    }

    @Step("Select Competency For Secondary Competency")
    public void selectCompetencyForSecondaryCompetency() {
        delayTime(TimeDelay.TIME_2000S);
        driver.findElement(By.xpath("//*[@class='secondary-competency']//*[@class=' css-2b097c-container']")).click();
        List<WebElement> competencyList = driver.findElements(By.xpath("//*[@class=' css-1575kqa-menu']//*[contains(@id,'react-select')]"));
        int availableCompetency = competencyList.size();
        System.out.println(availableCompetency);
        for (int i = 0; i < availableCompetency; i++) {
            System.out.println(i);
            competencyList.get(i).click();
            delayTime(TimeDelay.TIME_1000S);
        }
        driver.findElement(By.xpath("//*[@class='secondary-competency']//*[@class=' css-2b097c-container']")).click();
    }

    public void verifyCompetencyOnPrimaryConcept() {
        delayTime(TimeDelay.TIME_1000S);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='primary-competency']//*[@class='css-1rhbuit-multiValue']")).isDisplayed());
    }

    public void verifyCompetencyOnSecondaryConcept() {
        delayTime(TimeDelay.TIME_1000S);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='secondary-competency']//*[@class='css-1rhbuit-multiValue']")).isDisplayed());
    }
}