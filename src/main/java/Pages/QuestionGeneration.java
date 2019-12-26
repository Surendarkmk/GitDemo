package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class QuestionGeneration {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='/question-generation']")
    WebElement questionGenerationSidebar;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]")
    WebElement fillintheblanks;
    @FindBy(xpath = "(//*[@id=\"select-name\"])[1]")
    WebElement grade;
    @FindBy(id = "6")
    WebElement grade6;
    @FindBy(xpath = "(//*[@id=\"select-name\"])[2]")
    WebElement subject;
    @FindBy(id = "Science")
    WebElement science;
    @FindBy(xpath = "(//*[@id=\"select-name\"])[3]")
    WebElement chapter;
    @FindBy(id = "1")
    WebElement chapter1;
    @FindBy(xpath = "//*[@id=\"cke_276_contents\"]/iframe")
    WebElement textEditor;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[4]/button")
    WebElement generateQuestions;

    @FindBy(xpath = "//span[@class='import-button']")
    WebElement BtnSelectFile;

    public QuestionGeneration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clkQuestionGenaration() {
        questionGenerationSidebar.click();
    }

    public void clickFillInTheBlanks() {
        fillintheblanks.click();
    }

    public void clickGrade6() {
        grade.click();
    }

    public void size() throws InterruptedException {
        grade.click();
        WebElement gradeSize = driver.findElement(By.xpath("(//*[@id=\"menu-name\"]/div[2])[1]"));
        int gradeSizee = gradeSize.findElements(By.tagName("li")).size();
        System.out.println(gradeSizee);             //Verify total size of the list
        Thread.sleep(1000);
        for (int i = 0; i <= gradeSizee; i++) {
            WebElement gradee = driver.findElement(By.xpath("(//*[@id=\"menu-name\"]/div[2])[1]"));
            List<WebElement> grade_size = gradee.findElements(By.tagName("li"));
            grade_size.get(i).click();
            Thread.sleep(1000);

            subject.click();
            Thread.sleep(1000);
            WebElement subSize = driver.findElement(By.xpath("//*[@id=\"menu-name\"]/div[2]/ul"));
            int subjectSize = subSize.findElements(By.tagName("li")).size();
            System.out.println(subjectSize);
            Actions size = new Actions(driver);
            size.sendKeys(Keys.ESCAPE).perform();

            for (int sub = 0; sub < subjectSize; sub++) {
                WebElement subjSize = driver.findElement(By.xpath("//*[@id=\"menu-name\"]/div[2]/ul"));
                List<WebElement> sub_size = subjSize.findElements(By.tagName("li"));
                sub_size.get(sub).click();
                Thread.sleep(1000);
                if (subjectSize - 1 != sub)
                    //subject.click();

                    chapter.click();
                Thread.sleep(1000);
                WebElement chapSize = driver.findElement(By.xpath(("//*[@id=\"menu-name\"]/div[2]/ul[3]")));
                int chapterSize = chapSize.findElements(By.tagName("li")).size();
                System.out.println(chapterSize);

                for (int chap = 0; chap < chapterSize; chap++) {
                    WebElement chaptSize = driver.findElement(By.xpath(("//*[@id=\"menu-name\"]/div[2]/ul[3]")));
                    List<WebElement> chap_size = chapSize.findElements(By.tagName("li"));
                    chap_size.get(chap).click();
                    Thread.sleep(1000);
                }
            }
            //grade.click();
        }
    }

    public void selectDropDown() throws InterruptedException {

        for (int i = 5; i <= 11; ++i) {
            grade.click();
            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
            }
            String grad = String.valueOf(i + 1);
            driver.findElement(By.id(grad)).click();
            Thread.sleep(400);
            for (int sub = 1; sub <= 1; ++sub) {
                subject.click();
                science.click();
                try {
                    Thread.sleep(400);
                } catch (InterruptedException ex) {
                }
            }
            for (int k = 0; k <= 24; ++k) {
                chapter.click();
                try {
                    Thread.sleep(400);
                } catch (InterruptedException ex) {
                }
                String chap = String.valueOf(k + 1);
                driver.findElement(By.id(chap)).click();
                try {
                    Thread.sleep(400);
                } catch (InterruptedException ex) {
                }
            }
        }
    }

    public void enterText() {

        String CWH = driver.getWindowHandle();
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        WebElement sat = driver.findElement(By.tagName("body"));
        sat.click();
        sat.sendKeys("Select in Selenium WebDriver. The 'Select' class in Selenium WebDriver is used for selecting and deselecting option in a dropdown. The objects of Select type can be initialized by passing the dropdown webElement as parameter to its constructor. How to select an option from drop-down menu?");
        driver.switchTo().window(CWH);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
    }

    public void clickGenerateQuestions() {

        //generateQuestions.click();
        if (generateQuestions.isEnabled()) {
            System.out.println("button enabled");
            generateQuestions.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
            }
        } else {
            System.out.println("button disabled");
            verifyQuestGenNoTxt();
        }
    }

    public void verifyQuestGen() {
        String approve = driver.getCurrentUrl();
        Assert.assertEquals(approve, "https://new-content-admin-staging.embibe.com/questions/approve");
    }

    public void verifyQuestGenNoTxt() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
        String upload = driver.getCurrentUrl();
        Assert.assertEquals(upload, "https://new-content-admin-staging.embibe.com/questions/upload");
    }

    public void selectGrade6() {
        grade.click();
        grade6.click();
    }

    public void selectSubjectScience() {
        subject.click();
        science.click();
    }

    public void selectChapter1() {
        chapter.click();
        chapter1.click();
    }

    public void selectSubject() {
        if (subject.isSelected()) {
            //subject.click();
            System.out.println("Subject Enabled");
        } else {
            System.out.println("Subject disabled");
            verifyQuestGenNoTxt();
        }
    }

    public void selectChapter() {
        if (chapter.isSelected()) {
            System.out.println("Chapter Enabled");
        } else {
            System.out.println("Chapter disabled");
            verifyQuestGenNoTxt();
        }
    }

    public void uploadEpubFile() {
        String file = new File("/Users/embibe/Downloads/igp-widget-world-v2.epub").toURI().toString();
        BtnSelectFile.sendKeys(file);

        BtnSelectFile.click();
    }

    public void delayTime() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
    }
}