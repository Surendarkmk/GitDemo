package Pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;

public class Concepts extends TestBase {

    WebDriver driver;

    @FindBy (xpath = "//*[@id=\"side-menu\"]/li[7]/a")
    WebElement sidebarConcepts;
    @FindBy (xpath = "//*[@id=\"outlined-dense\"]")
    WebElement conceptId;
    @FindBy (id = "select-name")
    WebElement conceptStatus;
    @FindBy (xpath = "(//*[@id=\"outlined-dense\"])[2]")
    WebElement conceptCode;
    @FindBy (xpath = "(//*[@id=\"outlined-dense\"])[3]")
    WebElement conceptName;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[2]/div[2]/div[3]/div[2]/div/div/div/div[2]/div")
    WebElement conceptDropdownCreator;
    @FindBy (id = "react-select-2-input")
    WebElement conceptCreatorText;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[2]/div[3]/div/p")
    WebElement conceptSearch;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[3]/div[1]/div[2]/div/p")
    WebElement conceptCreate;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[1]/div/div[1]/img")
    WebElement conceptClose;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[8]")
    WebElement saveBtn;

    @FindBy (xpath = "//*[@id=\"cke_1_contents\"]/iframe")
    WebElement NewConceptName;
    @FindBy (xpath = "//*[@id=\"cke_2_contents\"]/iframe")
    WebElement NewConceptDescription;

    @FindBy (xpath = "(//div[@id='select-name'])[2]")
    WebElement conceptType;
    @FindBy (xpath = "(//div[@id='select-name'])[3]")
    WebElement conceptCategory;
    @FindBy (id = "Fundamentlal Quantities")
    WebElement Fundamentlal_Quantities;
    @FindBy (id = "Identity")
    WebElement conceptTypeIdentity;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[3]/div[3]/div[2]/input")
    WebElement CreateConceptCode;
    @FindBy (xpath = "//textarea[@class='video-link']")
    WebElement commonError1;
    @FindBy (xpath = "(//textarea[@class='video-link'])[2]")
    WebElement commonError2;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[4]/div/div[2]/div")
    WebElement addCommonError;
    @FindBy (xpath = "(//textarea[@class='video-link'])[2]")
    WebElement tip1;

    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[5]/div/div[2]/div")
    WebElement addTip;
    @FindBy (xpath = "(//div[@id='select-name'])[4]")
    WebElement skill1;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[6]/div/div[2]/div[2]")
    WebElement addSkill;
    @FindBy (id = "Creativity")
    WebElement skillCreativity;
    @FindBy (id = "Manipulation")
    WebElement skillManipulation;
    @FindBy (xpath = "(//div[@id='select-name'])[5]")
    WebElement skill2;
    @FindBy (xpath = "//div[@class='add-button']")
    WebElement addVideoLinkBtn;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[7]/div/div/div[2]/div[3]/div[1]/input")
    WebElement addVideoText;
    @FindBy (xpath = "//div[@class='preview']")
    WebElement videoPreview;
    @FindBy (xpath = "//div[@class='select']")
    WebElement selectVideoLink;


    @FindBy (id = "Active")
    WebElement StatusActive;
    @FindBy (id = "Inactive")
    WebElement StatusInactive;
    @FindBy (id = "Draft")
    WebElement StatusDraft;

    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[3]/div[2]/div/div[1]/div[2]")
    WebElement conceptListing;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div[1]")
    WebElement verifySearch;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[3]/div[2]/div/div[1]/div[2]/div/div/div[4]")
    WebElement listConcept;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement recentSaved;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[3]/div[2]/div/div[1]/div[2]")
    WebElement conceptLsting;
    @FindBy (xpath = "//*[@id=\"player_uid_330119919_1\"]/div[4]")
    WebElement videoTumbline;


    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[9]/div[2]/span[2]")
    WebElement errorMsgSave;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[9]/div[1]")
    WebElement errorConcept;

    public Concepts(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openConceptPage(){
        waitUntillElementVisible(sidebarConcepts);
        sidebarConcepts.click();
    }

    public void conceptSearchId(String id){
        waitUntillElementVisible(conceptId);
        conceptId.sendKeys(id);
    }

    public void conceptSearchCode(String code){
        waitUntillElementVisible(conceptCode);
        conceptCode.sendKeys(code);
    }

    public void conceptSearchName(String name){
        waitUntillElementVisible(conceptName);
        conceptName.sendKeys(name);
    }

    public void clkSearch(){
        waitUntillElementVisible(conceptSearch);
        conceptSearch.click();
    }

    public void verifySearchId(){
        waitUntillElementVisible(verifySearch);
        Assert.assertTrue(verifySearch.isDisplayed());
    }

    public void verifySearchCode(){
        waitUntillElementVisible(listConcept);
        Assert.assertTrue(listConcept.isDisplayed());
    }

    public void verifyInvalidSearchId(){
        waitUntillElementVisible(conceptListing);
        Assert.assertFalse(conceptListing.isDisplayed());
    }

    public void clkStatus(){
        waitUntillElementVisible(conceptStatus);
        conceptStatus.click();
    }

    public void selectActive(){
        if (driver.findElements(By.id("Active")).size() !=0){
            StatusActive.click();
        }else {
            driver.findElement(By.id("active")).click();
        }
    }

    public void selectInactive(){
        if (driver.findElements(By.id("Inactive")).size() != 0){
            StatusInactive.click();
        }else {
            driver.findElement(By.id("inactive")).click();
        }

    }

    public void selectDraft(){
        if (driver.findElements(By.id("Draft")).size() != 0){
            StatusDraft.click();
        }else {
            driver.findElement(By.id("draft")).click();
        }

    }

    public void clkCreatorDrop(){
        waitUntillElementVisible(conceptDropdownCreator);
        conceptDropdownCreator.click();
    }

    public void enterCreatorText(String Curator){
        waitUntillElementVisible(conceptCreatorText);
        conceptCreatorText.sendKeys(Curator);
    }

    public void pressEnterCreator(){
        waitUntillElementVisible(conceptCreatorText);
        conceptCreatorText.sendKeys(Keys.ENTER);
    }

    public void clkCreateConcept(){

        waitUntillElementVisible(conceptCreate);
        conceptCreate.click();
    }

    public void clkCloseConcept(){
        waitUntillElementVisible(conceptClose);
        conceptClose.click();
    }

    public void clkSaveBtn(){
        waitUntillElementVisible(saveBtn);
        saveBtn.click();
    }

    public void verifyErrorMsg(){
        waitUntillElementVisible(errorMsgSave);
        Assert.assertEquals(errorMsgSave.getText(), "Please enter concept name");
    }

    public void enterConceptName() {
        Random objGenerator = new Random();
        for (int iCount = 0; iCount< 1; iCount++) {
            int randomNumber = objGenerator.nextInt(100000000);
            System.out.println("Random No : " + randomNumber);

            String CWH = driver.getWindowHandle();
            //WebElement iframe = NewConceptName;
            WebElement iframe = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframe);
            WebElement sat = driver.findElement(By.tagName("body"));
            sat.click();
            sat.sendKeys("Automation Concept " + randomNumber);
            driver.switchTo().window(CWH);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void enterConcept(){
        String Description = driver.getWindowHandle();
        //WebElement iframe = NewConceptDescription;
        WebElement iframe = driver.findElement(By.xpath("//*[@id=\"cke_2_contents\"]/iframe"));
        driver.switchTo().frame(iframe);
        WebElement sat = driver.findElement(By.tagName("body"));
        sat.click();
        sat.sendKeys("Concept - Testing - Testing ");
        driver.switchTo().window(Description);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
    }

    public void clkConceptType(){
        waitUntillElementVisible(conceptType);
        conceptType.click();
    }

    public void selectIdentity(){
        waitUntillElementVisible(conceptTypeIdentity);
        conceptTypeIdentity.click();
    }

    public void clkDropdownCategory(){
        waitUntillElementVisible(conceptCategory);
        conceptCategory.click();
    }
    public void selectCategory(){
        waitUntillElementVisible(Fundamentlal_Quantities);
        Fundamentlal_Quantities.click();
    }

    public void enterNewCoceptCode(){
        Random objGenerator = new Random();
        for (int iCount = 0; iCount< 1; iCount++) {
            int randomNumber = objGenerator.nextInt(1000000);
            System.out.println("Random No : " + randomNumber);
            waitUntillElementVisible(CreateConceptCode);
            CreateConceptCode.sendKeys("AutoCode "+ randomNumber);
        }
    }

    public void commonErrorText(){
        waitUntillElementVisible(commonError1);
        commonError1.sendKeys("Auto - Error 1");
    }

    public void clkAddCommonError(){
        waitUntillElementVisible(addCommonError);
        addCommonError.click();
    }
    public void commonErrorText2(){
     waitUntillElementVisible(commonError2);
     commonError2.sendKeys("Auto-Common Error 2");
    }

    public void tipText(){
        waitUntillElementVisible(tip1);
        tip1.sendKeys("Auto - Tips 123");
    }

    public void tipText1(){
        waitUntillElementVisible(addTip);
        addTip.sendKeys("Auto Tip");
    }

    public void clkDropskill1(){
        waitUntillElementVisible(skill1);
        skill1.click();
    }

    public void selectSkill1(){
        waitUntillElementVisible(skillCreativity);
        skillCreativity.click();
    }

    public void skill2(){
        waitUntillElementVisible(skill2);
        addSkill.click();
        waitUntillElementVisible(skillCreativity);
        skillCreativity.click();
    }

    public void clkAddVideoLink(){
        addVideoLinkBtn.click();
    }

    public void enterlinkVideo(){
        waitUntillElementVisible(addVideoText);
        addVideoText.sendKeys("https://www.youtube.com/watch?v=EzhjMNUnWdU");
    }

    public void clkPreviewVideo(){
        waitUntillElementVisible(videoPreview);
        videoPreview.click();
    }

    public void clkSelectVideoLink(){
        waitUntillElementVisible(selectVideoLink);
        selectVideoLink.click();
    }

    public void timeDelay(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
    }

    public void verifyAll(){
        waitUntillElementVisible(conceptStatus);
        Assert.assertEquals(conceptStatus.getText(),"inactive");
        timeDelay();
        waitUntillElementVisible(conceptType);
        Assert.assertEquals(conceptType.getText(),"Identity");
        timeDelay();
        waitUntillElementVisible(conceptCategory);
        Assert.assertEquals(conceptCategory.getText(),"Fundamentlal Quantities");
        timeDelay();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[4]/div/div[2]/textarea")).getText(),"Auto - Error 1");
        timeDelay();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[5]/div/div[2]/textarea")).getText(),"Auto - Tips 123");
        timeDelay();
        String youtube = (driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div[7]/div[1]/div/div[2]/div/input"))).getAttribute("value");
        Assert.assertEquals(youtube,"https://www.youtube.com/watch?v=EzhjMNUnWdU");
        timeDelay();
        Assert.assertEquals(driver.findElement(By.xpath("(//*[@id=\"select-name\"])[4]")).getText(),"Creativity");
    }

    public void verifyCommonError1(){
        Assert.assertEquals(commonError1.getText(),"Auto - Error 1");
    }

    public void verifyCommonError2(){
        waitUntillElementVisible(commonError2);
        Assert.assertEquals(commonError2.getText(),"Auto - Error 2");
    }

    public void verifyTip1(){
        waitUntillElementVisible(tip1);
        Assert.assertEquals(tip1.getText(),"Auto - Tips 123");
    }

    public void clkRecentSaved(){
        waitUntillElementVisible(recentSaved);
        recentSaved.click();
    }

    public void verifyErrorConceptName(){
        waitUntillElementVisible(errorConcept);
        Assert.assertEquals(errorConcept.getText(),"Please enter concept name");
    }

    /*public void verifyErrorConceptCurator(){
        waitUntillElementVisible(errorConcept);
        Assert.assertEquals(errorConcept.getText(),"Please enter curator");
    }*/

    public void verifyConceptListing(){
        waitUntillElementVisible(conceptListing);
        Assert.assertTrue(conceptListing.isDisplayed());
    }

    public void verifyErrorConceptStatus(){
        waitUntillElementVisible(errorConcept);
        Assert.assertEquals(errorConcept.getText(),"Please enter concept status");
    }

    public void verifyVideoTumbline(){
        waitUntillElementVisible(videoTumbline);
        Assert.assertTrue(videoTumbline.isDisplayed());
    }

    public void verifyErrorConceptCode(){
        waitUntillElementVisible(errorConcept);
        Assert.assertEquals(errorConcept.getText(),"Please enter concept code");
    }

    public void verifyErrorUniquConceptCode(){
        waitUntillElementVisible(errorConcept);
        Assert.assertEquals(errorConcept.getText(),"Concept Code needs to be unique");
    }

}
