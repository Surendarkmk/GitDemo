package Pages;

import base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class TestFormat extends TestBase {

    WebDriver driver;

    public TestFormat(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//div[@class='rt-td']")
    WebElement table;
    // Search Details

    @FindBy (xpath = "((//*[@id=\"outlined-dense\"])[1])")
    WebElement searchID;
    @FindBy (xpath = "((//*[@id=\"outlined-dense\"])[2])")
    WebElement examID;
    @FindBy (xpath = "((//*[@id=\"outlined-dense\"])[3])")
    WebElement SearchTestName;
    @FindBy (id = "select-name")
    WebElement dropTestType;
    @FindBy (xpath = "//div[@class='search-button-div']")
    WebElement searchBtn;


    @FindBy (xpath = "//div[@class='rt-td']")
    WebElement listingTable;
    @FindBy (xpath = "//div[@class='rt-th']")
    WebElement tableHeader;

    @FindBy (xpath = "//div[@class='-pageJump']/input")
    WebElement paginationPageTextBox;
    @FindBy (xpath = "//div[@class='-next']/button")
    WebElement paginationNext;
    @FindBy (xpath = "//div[@class='-previous']/button")
    WebElement paginationPrevious;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[3]/div[3]/div[2]/div/div[2]/div/div[2]/span/span")
    WebElement paginationTotalNumberOfPages;

    //List <WebElement> testType = driver.findElement(By.xpath("//*[@id=\"menu-name\"]/div[2]/ul")).findElements(By.tagName("ul"));


    @FindBy (xpath = "//div/label[.='Enter test format name']")
    WebElement Name;
    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement posMark;
    @FindBy (xpath = "//div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/textarea[3][@id='outlined-dense']")
    WebElement posMark1;


    @FindBy(xpath = "//p[@class='concept-table-btn-label']")
    WebElement createNewTestormatBtn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[1]/img")
    WebElement closeTestFormat;
    @FindBy(xpath = "//*[@id=\"side-menu\"]/li[9]/a")
    WebElement Test_Format;
    @FindBy(xpath = "((//*[@id=\"outlined-dense\"])[1])")
    WebElement formatName;
    @FindBy(xpath = "((//*[@id=\"outlined-dense\"])[2])")
    WebElement formatMark;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div/div[3]/div[1]/div[1]/div/div/div/div[1]")
    WebElement selectExam;
    @FindBy (xpath = "//*[@id=\"react-select-2-input\"]")
    WebElement enterExamName;

    @FindBy(xpath = "((//*[@id=\"select-name\"])[1])")
    WebElement testTypeDrop;
    @FindBy(id = "full-test")
    WebElement fulltest;
    @FindBy (id = "chapterwise-test")
    WebElement chapterwisetest;
    @FindBy (id = "part-test")
    WebElement parttest;
    @FindBy (id = "previous-year-test")
    WebElement previousyeartest;
    @FindBy(id = "live-test")
    WebElement livetest;
    @FindBy (id = "mini-test")
    WebElement minitest;
    @FindBy (id = "11th-revision")
    WebElement eleventhrevision;

    @FindBy (xpath = "//div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/textarea[3][@id='outlined-dense']")
    WebElement subject1Duration;
    @FindBy (xpath = "//div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/textarea[3][@id='outlined-dense']")
    WebElement subject2Duration;
    @FindBy (xpath = "//div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/textarea[3][@id='outlined-dense']")
    WebElement subject3Duration;
    @FindBy (xpath = "//div[4]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/textarea[3][@id='outlined-dense']")
    WebElement subject4Duration;
    @FindBy (xpath = "//div[5]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/textarea[3][@id='outlined-dense']")
    WebElement subject5Duration;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]")
    WebElement addQuestType11;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]")
    WebElement addQuestType12;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]")
    WebElement addQuestType13;

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]")
    WebElement addQuestType21;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]")
    WebElement addQuestType22;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div[1]")
    WebElement addQuestType23;

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]")
    WebElement addQuestType31;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]")
    WebElement addQuestType32;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[3]/div[2]/div[2]/div[3]/div[1]")
    WebElement addQuestType33;

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[4]/div[2]/div[2]/div[1]/div[1]")
    WebElement addQuestType41;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[4]/div[2]/div[2]/div[2]/div[1]")
    WebElement addQuestType42;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[4]/div[2]/div[2]/div[3]/div[1]")
    WebElement addQuestType43;

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[5]/div[2]/div[2]/div[1]/div[1]")
    WebElement addQuestType51;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[5]/div[2]/div[2]/div[2]/div[1]")
    WebElement addQuestType52;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[5]/div[2]/div[2]/div[3]/div[1]")
    WebElement addQuestType53;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop11;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop12;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop13;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop21;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop22;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop23;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop31;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[3]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop32;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[3]/div[2]/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop33;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop41;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop42;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[4]/div[2]/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop43;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[5]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop51;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[5]/div[2]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop52;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[5]/div[2]/div[2]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement questTypedrop53;

    @FindBy (id = "Single Choice")
    WebElement singleChoice;
    @FindBy (id = "True False")
    WebElement TrueFalse;
    @FindBy (id = "Subjective Numerical")
    WebElement SubjectiveNumerical;
    @FindBy (id = "Matrix Match Grid")
    WebElement MatrixMatchGrid;
    @FindBy (id = "Linked Comprehension")
    WebElement LinkedComprehension;
    @FindBy (id = "Matrix Match Single Choice")
    WebElement MatrixMatchSingleChoice;
    @FindBy (id = "Assertion")
    WebElement Assertion;
    @FindBy (id = "Multiple Choice")
    WebElement MultipleChoice;
    @FindBy (id = "Integer")
    WebElement Integer;
    @FindBy (id = "Multiple Fill In The Blanks")
    WebElement MultipleFillInTheBlanks;
    @FindBy (id = "FillInTheBlanks")
    WebElement FillInTheBlanks;
    @FindBy (id = "Subjective")
    WebElement Subjective;
    @FindBy (id = "Single Drop Down")
    WebElement SingleDropDown;


    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount11;
    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount12;
    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[3]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount13;

    @FindBy (xpath = "//div[2]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount21;
    @FindBy (xpath = "//div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount22;
    @FindBy (xpath = "//div[2]/div[2]/div[2]/div[3]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount23;

    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount31;
    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount32;
    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[3]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount33;

    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount41;
    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount42;
    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[3]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount43;

    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount51;
    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount52;
    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[3]/div[2]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement questionCount53;


    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark11;
    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark12;
    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark13;

    @FindBy (xpath = "//div[2]/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark21;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/input[1]")
    WebElement positiveMark22;
    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[2]/div[2]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/input[1]")
    WebElement positiveMark23;

    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark31;
    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark32;
    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark33;

    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark41;
    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark42;
    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark43;

    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark51;
    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark52;
    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[3]/div[3]/div[2]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement positiveMark53;

    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark11;
    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark12;
    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[3]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark13;

    @FindBy (xpath = "//div[2]/div[2]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark21;
    @FindBy (xpath = "//div[2]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark22;
    @FindBy (xpath = "//div[2]/div[2]/div[2]/div[3]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark23;

    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark31;
    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark32;
    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[3]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark33;

    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark41;
    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark42;
    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[3]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark43;

    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[1]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark51;
    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark52;
    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[3]/div[3]/div[3]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement negativeMark53;

    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark11;
    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[2]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark12;
    @FindBy (xpath = "//div[1]/div[2]/div[2]/div[3]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark13;

    @FindBy (xpath = "//div[2]/div[2]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark21;
    @FindBy (xpath = "//div[2]/div[2]/div[2]/div[2]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark22;
    @FindBy (xpath = "//div[2]/div[2]/div[2]/div[3]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark23;

    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark31;
    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[2]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark32;
    @FindBy (xpath = "//div[3]/div[2]/div[2]/div[3]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark33;

    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark41;
    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[2]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark42;
    @FindBy (xpath = "//div[4]/div[2]/div[2]/div[3]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark43;

    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[1]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark51;
    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[2]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark52;
    @FindBy (xpath = "//div[5]/div[2]/div[2]/div[3]/div[3]/div[4]/div[1]/div[1]/input[1][@id='outlined-dense']")
    WebElement partialMark53;

    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[1]/div[1]/div[2]")
    WebElement subject1Drop;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[2]/div[1]/div[2]")
    WebElement subject2Drop;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[3]/div[1]/div[2]")
    WebElement subject3Drop;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[4]/div[1]/div[2]")
    WebElement subject4Drop;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[5]/div[1]/div[2]")
    WebElement subject5Drop;

    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/span/span[1]/input")
    WebElement Subject1Check;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/span/span[1]/input")
    WebElement Subject2Check;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[3]/div[1]/div[1]/span/span[1]/input")
    WebElement Subject3Check;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[4]/div[1]/div[1]/span/span[1]/input")
    WebElement Subject4Check;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[5]/div[1]/div[1]/span/span[1]/input")
    WebElement Subject5Check;

    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/div")
    WebElement Subject1Lable;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div")
    WebElement Subject2Lable;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[3]/div[1]/div[1]/div")
    WebElement Subject3Lable;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[4]/div[1]/div[1]/div")
    WebElement Subject4Lable;
    @FindBy (xpath = "//*[@id=\"app\"]/div/div[4]/div[2]/div[2]/div[5]/div[1]/div[1]/div")
    WebElement Subject5Lable;

    @FindBy (xpath = "//p[@class='next-button-text']")
    WebElement saveBtn;

    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a")
    WebElement FirstinList;
    @FindBy (id = "client-snackbar")
    WebElement errorMessage;

    @Step("clicking on Test Format sidebar")
    public void clkTestFormat(){
        waitUntillElementVisible(Test_Format);
        Test_Format.click();
    }

    @Step("Click Create New Test Format Button")
    public void clkCreateTestFormat(){
        waitUntilElementClickable(createNewTestormatBtn);
        createNewTestormatBtn.click();
    }

    @Step("Click on Close Icon (X) in Title Header")
    public void clkCloseTestFormat(){
        //waitUntilElementClickable(closeTestFormat);
        closeTestFormat.click();
    }

    public void enterFormatName(String examname) {
        Random objGenerator = new Random();
        for (int iCount = 0; iCount < 1; iCount++) {
            int randomNumber = objGenerator.nextInt(100000000);
            waitUntillElementVisible(formatName);
            formatName.sendKeys(examname + randomNumber);
        }
    }

    @Step ("Enter existing Test Format Name")
    public void enterTestFormatName(String name){
        formatName.sendKeys(name);
    }

    @Step ("Enter Test Format Total Mark")
    public void enterFormatMark(String fm){
        waitUntillElementVisible(formatMark);
        formatMark.sendKeys(fm);
    }

    @Step("Click Select Exam DropDown")
    public void clkSelectExam(){
        selectExam.click();
    }

    @Step("Search and Select the Exam Name")
    public void enterExam(String examname){
        waitUntillElementVisible(enterExamName);
        waitUntillElementVisible(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[4]/div/div[3]/div[1]/div[1]/div/div/div[2]")));
        enterExamName.sendKeys(examname);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
        }
        enterExamName.sendKeys(Keys.ENTER);
    }

    @Step ("Click Test Type Drop Down")
    public void clkTestType(){
        testTypeDrop.click();
    }

    @Step ("Select full-test")
    public void selectFullTest(){
        waitUntillElementVisible(fulltest);
        fulltest.click();
    }

    @Step ("Select chapterwise-test")
    public void selectchapterwisetest(){
        waitUntillElementVisible(chapterwisetest);
        chapterwisetest.click();
    }

    @Step ("Select part-test")
    public void selectparttest(){
        waitUntillElementVisible(parttest);
        parttest.click();
    }

    @Step ("Select Previous Year-test")
    public void selectpreviousyeartest(){
        waitUntillElementVisible(previousyeartest);
        previousyeartest.click();
    }

    @Step ("Select Live-test")
    public void selectlivetest(){
        waitUntillElementVisible(livetest);
        livetest.click();
    }

    @Step ("Select Mini-test")
    public void selectminitest(){
        waitUntillElementVisible(minitest);
        minitest.click();
    }

    @Step ("Select 11th Revision-test")
    public void selecteleventhrevision(){
        waitUntillElementVisible(eleventhrevision);
        eleventhrevision.click();
    }

    public void setSubject1Duration(String dur1){
        subject1Duration.sendKeys(dur1);
    }

    public void setSubject2Duration(String dur2){
        subject2Duration.sendKeys(dur2);
    }

    public void setSubject3Duration(String dur3){
        subject3Duration.sendKeys(dur3);
    }

    public void setSubject4Duration(String dur3){
        subject4Duration.sendKeys(dur3);
    }

    public void setSubject5Duration(String dur3){
        subject5Duration.sendKeys(dur3);
    }

    public void ClkAddQuestType11(){
        waitUntillElementVisible(addQuestType11);
        addQuestType11.click();
    }

    public void ClkAddQuestType21(){
        addQuestType21.click();
    }

    public void ClkAddQuestType31(){
        addQuestType31.click();
    }

    public void ClkAddQuestType41(){
        addQuestType41.click();
    }

    public void ClkAddQuestType42(){
        addQuestType42.click();
    }

    public void ClkAddQuestType43(){
        addQuestType43.click();
    }

    public void ClkAddQuestType51(){
        addQuestType51.click();
    }

    public void ClkAddQuestType52(){
        addQuestType52.click();
    }

    public void ClkAddQuestType53(){
        addQuestType53.click();
    }

    public void ClkAddQuestType12(){
        waitUntillElementVisible(addQuestType12);
        addQuestType12.click();
    }

    public void ClkAddQuestType22(){
        addQuestType22.click();
    }

    public void ClkAddQuestType32(){
        addQuestType32.click();
    }

    public void ClkAddQuestType13(){
        waitUntillElementVisible(addQuestType13);
        addQuestType13.click();
    }

    public void ClkAddQuestType23(){
        addQuestType23.click();
    }

    public void ClkAddQuestType33(){
        addQuestType33.click();
    }

    public void clkQuestionType11(){
        questTypedrop11.click();
    }

    public void clkQuestionType12(){
        questTypedrop12.click();
    }

    public void clkQuestionType13(){
        questTypedrop13.click();
    }

    public void clkQuestionType21(){
        questTypedrop21.click();
    }

    public void clkQuestionType22(){
        questTypedrop22.click();
    }

    public void clkQuestionType23(){
        questTypedrop23.click();
    }

    public void clkQuestionType31(){
        questTypedrop31.click();
    }

    public void clkQuestionType41(){
        questTypedrop41.click();
    }

    public void clkQuestionType42(){
        questTypedrop42.click();
    }

    public void clkQuestionType43(){
        questTypedrop43.click();
    }

    public void clkQuestionType51(){
        questTypedrop51.click();
    }

    public void clkQuestionType52(){
        questTypedrop52.click();
    }
    public void clkQuestionType53(){
        questTypedrop53.click();
    }

    public void clkQuestionType32(){
        questTypedrop32.click();
    }

    public void clkQuestionType33(){
        questTypedrop33.click();
    }

    // Types of Questions Selections

    public void selectSingleChoice(){
        waitUntillElementVisible(singleChoice);
        singleChoice.click();
    }

    public void selectTrueFalse(){
        waitUntillElementVisible(TrueFalse);
        TrueFalse.click();
    }

    public void selectSubjectiveNumerical(){
        waitUntillElementVisible(SubjectiveNumerical);
        SubjectiveNumerical.click();
    }

    public void selectMatrixMatchGrid(){
        waitUntillElementVisible(MatrixMatchGrid);
        MatrixMatchGrid.click();
    }

    public void selectLinkedComprehension(){
        waitUntillElementVisible(LinkedComprehension);
        LinkedComprehension.click();
    }

    public void selectMatrixMatchSingleChoice(){
        waitUntillElementVisible(MatrixMatchSingleChoice);
        MatrixMatchSingleChoice.click();
    }

    public void selectAssertion(){
        waitUntillElementVisible(Assertion);
        Assertion.click();
    }

    public void selectMultipleChoice(){
        waitUntillElementVisible(MultipleChoice);
        MultipleChoice.click();
    }

    public void selectInteger(){
        waitUntillElementVisible(Integer);
        Integer.click();
    }

    public void selectMultipleFillInTheBlanks(){
        waitUntillElementVisible(MultipleFillInTheBlanks);
        MultipleFillInTheBlanks.click();
    }

    public void selectFillInTheBlanks(){
        waitUntillElementVisible(FillInTheBlanks);
        FillInTheBlanks.click();
    }

    public void selectSubjective(){
        waitUntillElementVisible(Subjective);
        Subjective.click();
    }

    public void selectSingleDropDown(){
        waitUntillElementVisible(SingleDropDown);
        SingleDropDown.click();
    }


    public void clkSubject1(){
        if(subject1Duration.isDisplayed()){
            System.out.println("Duration tab available");
        }else{
            waitUntillElementVisible(subject1Drop);
            subject1Drop.click();
        }
    }

    public void clkSubject2(){
        if(subject2Duration.isDisplayed()){
            System.out.println("Duration2 Text box");
        }else {
            waitUntillElementVisible(subject2Drop);
            subject2Drop.click();
        }
    }

    public void clkSubject3(){
        if(subject3Duration.isDisplayed()){
            System.out.println("Duration3 Text box Available");
        }else {
            waitUntillElementVisible(subject3Drop);
            subject3Drop.click();
        }
    }

    public void clkSubject4(){
        if(subject4Duration.isDisplayed()){
            System.out.println("Duration3 Text box Available");
        }else {
            waitUntillElementVisible(subject4Drop);
            subject4Drop.click();
        }
    }

    public void clkSubject5(){
        if(subject5Duration.isDisplayed()){
            System.out.println("Duration3 Text box Available");
        }else {
            waitUntillElementVisible(subject5Drop);
            subject5Drop.click();
        }
    }

    public void enterQuestCount11(String qc1){
        waitUntillElementVisible(questionCount11);
        questionCount11.sendKeys(qc1);
    }

    public void enterQuestCount12(String qc12){
        waitUntillElementVisible(questionCount12);
        questionCount12.sendKeys(qc12);
    }

    public void enterQuestCount13(String qc13){
        waitUntillElementVisible(questionCount13);
        questionCount13.sendKeys(qc13);
    }

    public void enterQuestCount21(String qc2){
        waitUntillElementVisible(questionCount21);
        questionCount21.sendKeys(qc2);
    }

    public void enterQuestCount22(String qc22){
        waitUntillElementVisible(questionCount22);
        questionCount22.sendKeys(qc22);
    }

    public void enterQuestCount23(String qc23){
        waitUntillElementVisible(questionCount23);
        questionCount23.sendKeys(qc23);
    }

    public void enterQuestCount31(String qc3){
        waitUntillElementVisible(questionCount31);
        questionCount31.sendKeys(qc3);
    }

    public void enterQuestCount41(String qc41){
        waitUntillElementVisible(questionCount41);
        questionCount41.sendKeys(qc41);
    }

    public void enterQuestCount42(String qc42){
        waitUntillElementVisible(questionCount42);
        questionCount42.sendKeys(qc42);
    }

    public void enterQuestCount43(String qc43){
        waitUntillElementVisible(questionCount43);
        questionCount43.sendKeys(qc43);
    }

    public void enterQuestCount51(String qc51){
        waitUntillElementVisible(questionCount51);
        questionCount51.sendKeys(qc51);
    }

    public void enterQuestCount52(String qc52){
        waitUntillElementVisible(questionCount52);
        questionCount52.sendKeys(qc52);
    }

    public void enterQuestCount53(String qc53){
        waitUntillElementVisible(questionCount53);
        questionCount53.sendKeys(qc53);
    }

    public void enterQuestCount32(String qc32){
        waitUntillElementVisible(questionCount32);
        questionCount32.sendKeys(qc32);
    }

    public void enterQuestCount33(String qc33){
        waitUntillElementVisible(questionCount33);
        questionCount33.sendKeys(qc33);
    }

    public void enterPositiveMark11(String pm11){
        waitUntillElementVisible(positiveMark11);
        positiveMark11.sendKeys(pm11);
    }

    public void enterPositiveMark12(String pm12){
        waitUntillElementVisible(positiveMark12);
        positiveMark12.sendKeys(pm12);
    }

    public void enterPositiveMark13(String pm13){
        waitUntillElementVisible(positiveMark13);
        positiveMark13.sendKeys(pm13);
    }


    public void enterPositiveMark21(String pm2){
        waitUntillElementVisible(positiveMark21);
        positiveMark21.sendKeys(pm2);
    }

    public void enterPositiveMark22(String pm22){
        waitUntillElementVisible(positiveMark22);
        positiveMark22.sendKeys(pm22);
    }

    public void enterPositiveMark23(String pm23){
        waitUntillElementVisible(positiveMark23);
        positiveMark23.sendKeys(pm23);
    }

    public void enterPositiveMark31(String pm3){
        waitUntillElementVisible(positiveMark31);
        positiveMark31.sendKeys(pm3);
    }

    public void enterPositiveMark32(String pm32){
        waitUntillElementVisible(positiveMark32);
        positiveMark32.sendKeys(pm32);
    }

    public void enterPositiveMark33(String pm33){
        waitUntillElementVisible(positiveMark33);
        positiveMark33.sendKeys(pm33);
    }

    public void enterPositiveMark41(String pm41){
        waitUntillElementVisible(positiveMark41);
        positiveMark41.sendKeys(pm41);
    }

    public void enterPositiveMark42(String pm42){
        waitUntillElementVisible(positiveMark42);
        positiveMark42.sendKeys(pm42);
    }

    public void enterPositiveMark43(String pm43){
        waitUntillElementVisible(positiveMark43);
        positiveMark43.sendKeys(pm43);
    }

    public void enterPositiveMark51(String pm51){
        waitUntillElementVisible(positiveMark51);
        positiveMark51.sendKeys(pm51);
    }

    public void enterPositiveMark52(String pm52){
        waitUntillElementVisible(positiveMark52);
        positiveMark52.sendKeys(pm52);
    }

    public void enterPositiveMark53(String pm53){
        waitUntillElementVisible(positiveMark53);
        positiveMark53.sendKeys(pm53);
    }

    public void enterNegativeMark11(String nm1){
        negativeMark11.sendKeys(nm1);
    }

    public void enterNegativeMark12(String nm12){
        negativeMark12.sendKeys(nm12);
    }

    public void enterNegativeMark13(String nm13){
        negativeMark13.sendKeys(nm13);
    }

    public void enterNegativeMark21(String nm2){
        negativeMark21.sendKeys(nm2);
    }

    public void enterNegativeMark22(String nm22){
        negativeMark22.sendKeys(nm22);
    }

    public void enterNegativeMark23(String nm23){
        negativeMark23.sendKeys(nm23);
    }

    public void enterNegativeMark31(String nm3){
        negativeMark31.sendKeys(nm3);
    }

    public void enterNegativeMark32(String nm32){
        negativeMark32.sendKeys(nm32);
    }

    public void enterNegativeMark33(String nm33){
        negativeMark33.sendKeys(nm33);
    }

    public void enterNegativeMark41(String nm41){
        negativeMark41.sendKeys(nm41);
    }

    public void enterNegativeMark42(String nm42){
        negativeMark42.sendKeys(nm42);
    }
    public void enterNegativeMark43(String nm43){
        negativeMark43.sendKeys(nm43);
    }

    public void enterNegativeMark51(String nm51){
        negativeMark51.sendKeys(nm51);
    }

    public void enterNegativeMark52(String nm52){
        negativeMark52.sendKeys(nm52);
    }
    public void enterNegativeMark53(String nm53){
        negativeMark53.sendKeys(nm53);
    }

    public void enterPartialMark11(String parmark11){
        partialMark11.sendKeys(parmark11);
    }

    public void enterPartialMark12(String parmark12){
        partialMark12.sendKeys(parmark12);
    }

    public void enterPartialMark13(String parmark13){
        partialMark13.sendKeys(parmark13);
    }

    public void enterPartialMark21(String parmark21){
        partialMark21.sendKeys(parmark21);
    }

    public void enterPartialMark22(String parmark22){
        partialMark22.sendKeys(parmark22);
    }

    public void enterPartialMark23(String parmark23){
        partialMark23.sendKeys(parmark23);
    }

    public void enterPartialMark31(String parmark31){
        partialMark31.sendKeys(parmark31);
    }

    public void enterPartialMark32(String parmark32){
        partialMark32.sendKeys(parmark32);
    }

    public void enterPartialMark33(String parmark33){
        partialMark33.sendKeys(parmark33);
    }

    public void enterPartialMark41(String parmark41){
        partialMark41.sendKeys(parmark41);
    }

    public void enterPartialMark42(String parmark42){
        partialMark42.sendKeys(parmark42);
    }

    public void enterPartialMark43(String parmark43){
        partialMark43.sendKeys(parmark43);
    }

    public void enterPartialMark51(String parmark51){
        partialMark51.sendKeys(parmark51);
    }

    public void enterPartialMark52(String parmark52){
        partialMark52.sendKeys(parmark52);
    }

    public void enterPartialMark53(String parmark53){
        partialMark53.sendKeys(parmark53);
    }

    public void selectMathematics() {
        String Subject1 = Subject1Lable.getText();
        if (Subject1.equals("Mathematics")) {
            if (Subject1Check.isSelected()) {
                System.out.println("Mathematics Selected");
            } else {
                Subject1Check.click();
            }
            enterJEEmainMathematics();
        }
    }

    public void verifyMathematics() {
        String Subject1 = Subject1Lable.getText();
        if (Subject1.equals("Mathematics")) {
            if (Subject1Check.isSelected()) {
                System.out.println("Mathematics Selected");
            } else {
                Subject1Check.click();
            }
        }
    }

    public void selectPhysics(){
        String Subject2 = Subject2Lable.getText();
        //String Phy = "Physics";
        if(Subject2.equals("Physics")) {
            if (Subject2Check.isSelected()) {
                System.out.println("Physics Selected");
            } else {
                Subject2Check.click();
            }
            enterJEEmainPhysics();
        }
    }

    public void selectChemistry(){
        String Subject3 = Subject3Lable.getText();
        if(Subject3.equals("Chemistry")) {
            if (Subject3Check.isSelected()) {
                System.out.println("Chemistry Selected");
            } else {
                Subject3Check.click();
            }
            enterJEEmainChemistry();
        }
    }

    public void clkSave(){
        waitUntilElementClickable(saveBtn);
        saveBtn.click();

    }

    @Step("Verify Save Button Clickable")
    public void verifySaveButtonEnable(){
        delayTime(TIME_2000S);
        Assert.assertTrue(saveBtn.isEnabled());
    }

    @Step("Enter Mathematics Subject Details")
    public void enterJEEmainMathematics(){
        delayTime(TIME_3000S);
        clkSubject1();
        setSubject1Duration(prop.getProperty("JEEmainMathematicsDuration"));
        delayTime(TIME_2000S);
        ClkAddQuestType11();
        delayTime(TIME_2000S);
        clkQuestionType11();
        delayTime(TIME_2000S);
        selectSingleChoice();
        delayTime(TIME_2000S);
        enterQuestCount11(prop.getProperty("JEEmainMathematicsQuestionCount1"));
        delayTime(TIME_2000S);
        enterPositiveMark11(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark11(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark11(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_2000S);
    }


    @Step("Enter Physics Subject Details")
    public void enterJEEmainPhysics(){
        delayTime(TIME_2000S);
        //selectPhysics();
        delayTime(TIME_1000S);
        clkSubject2();
        setSubject2Duration(prop.getProperty("JEEmainPhysicsDuration"));
        delayTime(TIME_2000S);
        ClkAddQuestType21();
        delayTime(TIME_2000S);
        clkQuestionType21();
        delayTime(TIME_2000S);
        selectSingleChoice();
        delayTime(TIME_2000S);
        enterQuestCount21(prop.getProperty("JEEmainPhysicsQuestionCount1"));
        delayTime(TIME_2000S);
        enterPositiveMark21(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark21(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark21(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_2000S);
    }

    @Step("Enter Chemistry Subject Details")
    public void enterJEEmainChemistry(){
        delayTime(TIME_3000S);
        clkSubject3();
        setSubject3Duration(prop.getProperty("JEEmainChemistryDuration"));
        delayTime(TIME_2000S);
        ClkAddQuestType31();
        delayTime(TIME_2000S);
        clkQuestionType31();
        delayTime(TIME_2000S);
        selectSingleChoice();
        delayTime(TIME_2000S);
        enterQuestCount31(prop.getProperty("JEEmainChemistryQuestionCount1"));
        delayTime(TIME_2000S);
        enterPositiveMark31(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark31(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark31(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_2000S);
    }

    public void openNewlyCreatedFormat(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/div[2]/div[3]/div[1]/p")));
        waitUntillElementVisible(FirstinList);
       FirstinList.click();
    }

    public void verifyJEEmainMathematics(){
        clkSubject1();
        Assert.assertEquals(subject1Duration.getText(),prop.getProperty("JEEmainMathematicsDuration"));
        delayTime(TIME_1000S);
        Assert.assertEquals(questTypedrop11.getText(),"Single Choice");
        delayTime(TIME_1000S);
        Assert.assertEquals(questionCount11.getAttribute("value"),prop.getProperty("JEEmainMathematicsQuestionCount1"));
        delayTime(TIME_1000S);
        Assert.assertEquals(positiveMark11.getAttribute("value"),prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        Assert.assertEquals(negativeMark11.getAttribute("value"),prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        Assert.assertEquals(partialMark11.getAttribute("value"),prop.getProperty("JEEmainPartialMark"));
    }

    public void verifyJEEmainPhysics(){
        clkSubject2();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div")));
        delayTime(TIME_1000S);
        Assert.assertEquals(subject2Duration.getText(),prop.getProperty("JEEmainPhysicsDuration"));
        delayTime(TIME_1000S);
        Assert.assertEquals(questTypedrop21.getText(),"Single Choice");
        delayTime(TIME_1000S);
        Assert.assertEquals(questionCount21.getAttribute("value"),prop.getProperty("JEEmainPhysicsQuestionCount1"));
        delayTime(TIME_1000S);
        Assert.assertEquals(positiveMark21.getAttribute("value"),prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        Assert.assertEquals(negativeMark21.getAttribute("value"),prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        Assert.assertEquals(partialMark21.getAttribute("value"),prop.getProperty("JEEmainPartialMark"));
    }

    public void verifyJEEmainChemistry(){
        clkSubject3();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div[2]/div[2]/div[3]/div[1]/div[1]/div")));
        Assert.assertEquals(subject3Duration.getText(),prop.getProperty("JEEmainChemistryDuration"));
        delayTime(TIME_1000S);
        Assert.assertEquals(questTypedrop31.getText(),"Single Choice");
        delayTime(TIME_1000S);
        Assert.assertEquals(questionCount31.getAttribute("value"),prop.getProperty("JEEmainChemistryQuestionCount1"));
        delayTime(TIME_1000S);
        Assert.assertEquals(positiveMark31.getAttribute("value"),prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        Assert.assertEquals(negativeMark31.getAttribute("value"),prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        Assert.assertEquals(partialMark31.getAttribute("value"),prop.getProperty("JEEmainPartialMark"));
    }

    ///////////JEE ADVANCED/////////////

    public void selectJEEadvMathematics() {
        String Subject1 = Subject1Lable.getText();
        if (Subject1.equals("Mathematics")) {
            if (Subject1Check.isSelected()) {
                System.out.println("Mathematics Selected");
            } else {
                Subject1Check.click();
            }
        }
    }

    public void selectJEEadvChemistry(){
        String Subject2 = Subject2Lable.getText();
        if(Subject2.equals("Chemistry")) {
            if (Subject2Check.isSelected()) {
                System.out.println("Chemistry Selected");
            } else {
                Subject2Check.click();
            }
        }
    }

    public void selectJEEadvPhysics(){
        String Subject3 = Subject3Lable.getText();
        if(Subject3.equals("Physics")) {
            if (Subject3Check.isSelected()) {
                System.out.println("Physics Selected");
            } else {
                Subject3Check.click();
            }
        }
    }

    public void enterJEEadvMathematicsSCMCSN(){
        setSubject1Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType11();
        delayTime(TIME_1000S);
        clkQuestionType11();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount11(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark11(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark11(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark11(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType12();
        delayTime(TIME_1000S);
        clkQuestionType12();
        delayTime(TIME_1000S);
        selectMultipleChoice();
        enterQuestCount12(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark12(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark12(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark12(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType13();
        delayTime(TIME_1000S);
        clkQuestionType13();
        delayTime(TIME_1000S);
        selectSubjectiveNumerical();
        enterQuestCount13(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark13(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark13(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark13(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

    }


    public void enterJEEadvChemistrySCMCSN(){
        clkSubject2();
        setSubject2Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType21();
        delayTime(TIME_1000S);
        clkQuestionType21();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount21(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark21(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark21(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark21(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType22();
        delayTime(TIME_1000S);
        clkQuestionType22();
        delayTime(TIME_1000S);
        selectMultipleChoice();
        enterQuestCount22(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark22(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark22(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark22(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType23();
        delayTime(TIME_1000S);
        clkQuestionType23();
        delayTime(TIME_1000S);
        selectSubjectiveNumerical();
        enterQuestCount23(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark23(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark23(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark23(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
    }


    public void enterJEEadvPhysicsSCMCSN(){
        clkSubject3();
        delayTime(TIME_1000S);
        setSubject3Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType31();
        delayTime(TIME_1000S);
        clkQuestionType31();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount31(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark31(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark31(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark31(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType32();
        delayTime(TIME_1000S);
        clkQuestionType32();
        delayTime(TIME_1000S);
        selectMultipleChoice();
        enterQuestCount32(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark32(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark32(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark32(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType33();
        delayTime(TIME_1000S);
        clkQuestionType33();
        delayTime(TIME_1000S);
        selectSubjectiveNumerical();
        enterQuestCount33(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark33(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark33(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark33(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
    }

    //Format 2

    public void enterJEEadvMathematicsTFAMMSC(){
        clkSubject1();
        setSubject1Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_2000S);
        ClkAddQuestType11();
        delayTime(TIME_1000S);
        clkQuestionType11();
        delayTime(TIME_1000S);
        selectTrueFalse();
        delayTime(TIME_1000S);
        enterQuestCount11(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark11(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark11(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark11(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
        //clkSubject1();
        //delayTime(TIME_2000S);
        ClkAddQuestType12();
        delayTime(TIME_1000S);
        clkQuestionType12();
        delayTime(TIME_1000S);
        selectAssertion();
        enterQuestCount12(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark12(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark12(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark12(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
        //clkSubject1();
        //delayTime(TIME_2000S);
        ClkAddQuestType13();
        delayTime(TIME_1000S);
        clkQuestionType13();
        delayTime(TIME_1000S);
        selectMatrixMatchSingleChoice();
        enterQuestCount13(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark13(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark13(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark13(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

    }

    public void enterJEEadvChemistryTFAMMSC(){
        clkSubject2();
        setSubject2Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType21();
        delayTime(TIME_1000S);
        clkQuestionType21();
        delayTime(TIME_1000S);
        selectTrueFalse();
        delayTime(TIME_1000S);
        enterQuestCount21(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark21(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark21(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark21(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType22();
        delayTime(TIME_1000S);
        clkQuestionType22();
        delayTime(TIME_1000S);
        selectAssertion();
        enterQuestCount22(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark22(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark22(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark22(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType23();
        delayTime(TIME_1000S);
        clkQuestionType23();
        delayTime(TIME_1000S);
        selectMatrixMatchSingleChoice();
        enterQuestCount23(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark23(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark23(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark23(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
    }

    public void enterJEEadvPhysicsTFAMMSC(){
        clkSubject3();
        delayTime(TIME_1000S);
        setSubject3Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType31();
        delayTime(TIME_1000S);
        clkQuestionType31();
        delayTime(TIME_1000S);
        selectTrueFalse();
        delayTime(TIME_1000S);
        enterQuestCount31(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark31(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark31(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark31(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType32();
        delayTime(TIME_1000S);
        clkQuestionType32();
        delayTime(TIME_1000S);
        selectAssertion();
        enterQuestCount32(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark32(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark32(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark32(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType33();
        delayTime(TIME_1000S);
        clkQuestionType33();
        delayTime(TIME_1000S);
        selectMatrixMatchSingleChoice();
        enterQuestCount33(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark33(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark33(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark33(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
    }

    //Format 2

    public void enterJEEadvMathematicsSCINMG(){
        clkSubject1();
        setSubject1Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_2000S);
        ClkAddQuestType11();
        delayTime(TIME_1000S);
        clkQuestionType11();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount11(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark11(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark11(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark11(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
        //clkSubject1();
        //delayTime(TIME_2000S);
        ClkAddQuestType12();
        delayTime(TIME_1000S);
        clkQuestionType12();
        delayTime(TIME_1000S);
        selectInteger();
        enterQuestCount12(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark12(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark12(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark12(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
        //clkSubject1();
        //delayTime(TIME_2000S);
        ClkAddQuestType13();
        delayTime(TIME_1000S);
        clkQuestionType13();
        delayTime(TIME_1000S);
        selectMatrixMatchGrid();
        enterQuestCount13(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark13(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark13(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark13(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

    }

    public void enterJEEadvChemistrySCINMG(){
        clkSubject2();
        setSubject2Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType21();
        delayTime(TIME_1000S);
        clkQuestionType21();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount21(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark21(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark21(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark21(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType22();
        delayTime(TIME_1000S);
        clkQuestionType22();
        delayTime(TIME_1000S);
        selectInteger();
        enterQuestCount22(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark22(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark22(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark22(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType23();
        delayTime(TIME_1000S);
        clkQuestionType23();
        delayTime(TIME_1000S);
        selectMatrixMatchGrid();
        enterQuestCount23(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark23(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark23(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark23(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
    }

    public void enterJEEadvPhysicsSCINMG(){
        clkSubject3();
        delayTime(TIME_1000S);
        setSubject3Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType31();
        delayTime(TIME_1000S);
        clkQuestionType31();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount31(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark31(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark31(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark31(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType32();
        delayTime(TIME_1000S);
        clkQuestionType32();
        delayTime(TIME_1000S);
        selectInteger();
        enterQuestCount32(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark32(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark32(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark32(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

        ClkAddQuestType33();
        delayTime(TIME_1000S);
        clkQuestionType33();
        delayTime(TIME_1000S);
        selectMatrixMatchGrid();
        enterQuestCount33(prop.getProperty("QuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark33(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark33(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark33(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
    }

    public void verifyScore(){
        Assert.assertEquals(questionCount11.getAttribute("value"),"10");
        Assert.assertEquals(positiveMark11.getAttribute("value"),"4");
        Assert.assertEquals(negativeMark11.getAttribute("value"),"1");
        Assert.assertEquals(partialMark11.getAttribute("value"),"0");
    }

    public void verifyScoreSubject2(){
        Assert.assertEquals(questionCount21.getAttribute("value"),"10");
        Assert.assertEquals(positiveMark21.getAttribute("value"),"4");
        Assert.assertEquals(negativeMark21.getAttribute("value"),"1");
        Assert.assertEquals(partialMark21.getAttribute("value"),"0");
    }

    public void verifyJEEadvMathematicsFormat(){
        clkSubject1();
        Assert.assertEquals(subject1Duration.getText(),"60");
        Assert.assertEquals(questTypedrop11.getText(),"Single Choice");
        verifyScore();
        Assert.assertEquals(questTypedrop12.getText(),"Multiple Choice");
        verifyScore();
        Assert.assertEquals(questTypedrop13.getText(),"Subjective Numerical");
        verifyScore();
    }
    public void verifyJEEadvChemistryFormat(){
        clkSubject2();
        Assert.assertEquals(subject2Duration.getText(),"60");
        Assert.assertEquals(questTypedrop21.getText(),"Single Choice");
        verifyScore();
        Assert.assertEquals(questTypedrop22.getText(),"Multiple Choice");
        verifyScore();
        Assert.assertEquals(questTypedrop23.getText(),"Subjective Numerical");
        verifyScore();
    }

    public void verifyJEEadvPhysicsFormat(){
        clkSubject3();
        Assert.assertEquals(subject3Duration.getText(),"60");
        Assert.assertEquals(questTypedrop31.getText(),"Single Choice");
        verifyScore();
        Assert.assertEquals(questTypedrop32.getText(),"Multiple Choice");
        verifyScore();
        Assert.assertEquals(questTypedrop33.getText(),"Subjective Numerical");
        verifyScore();
    }

    public void verifyJEEadvFormat(){
        verifyJEEadvMathematicsFormat();
        verifyJEEadvChemistryFormat();
        verifyJEEadvPhysicsFormat();
    }

    public void verifyJEEadvMathematicsFormat1(){
        clkSubject1();
        Assert.assertEquals(subject1Duration.getText(),"60");
        Assert.assertEquals(questTypedrop11.getText(),"True False");
        verifyScore();
        Assert.assertEquals(questTypedrop12.getText(),"Assertion");
        verifyScore();
        Assert.assertEquals(questTypedrop13.getText(),"Matrix Match Single Choice");
        verifyScore();
    }
    public void verifyJEEadvChemistryFormat1(){
        clkSubject2();
        Assert.assertEquals(subject2Duration.getText(),"60");
        Assert.assertEquals(questTypedrop21.getText(),"True False");
        verifyScore();
        Assert.assertEquals(questTypedrop22.getText(),"Assertion");
        verifyScore();
        Assert.assertEquals(questTypedrop23.getText(),"Matrix Match Single Choice");
        verifyScore();
    }

    public void verifyJEEadvPhysicsFormat1(){
        clkSubject3();
        Assert.assertEquals(subject3Duration.getText(),"60");
        Assert.assertEquals(questTypedrop31.getText(),"True False");
        verifyScore();
        Assert.assertEquals(questTypedrop32.getText(),"Assertion");
        verifyScore();
        Assert.assertEquals(questTypedrop33.getText(),"Matrix Match Single Choice");
        verifyScore();
    }

    public void verifyJEEadvFormat1(){
        verifyJEEadvMathematicsFormat1();
        verifyJEEadvChemistryFormat1();
        verifyJEEadvPhysicsFormat1();
    }

    public void verifyJEEadvMathematicsFormat2(){
        clkSubject1();
        Assert.assertEquals(subject1Duration.getText(),"60");
        Assert.assertEquals(questTypedrop11.getText(),"Single Choice");
        verifyScore();
        Assert.assertEquals(questTypedrop12.getText(),"Integer");
        verifyScore();
        Assert.assertEquals(questTypedrop13.getText(),"Matrix Match Grid");
        verifyScore();
    }
    public void verifyJEEadvChemistryFormat2(){
        clkSubject2();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div")));
        Assert.assertEquals(subject2Duration.getText(),"60");
        Assert.assertEquals(questTypedrop21.getText(),"Single Choice");
        verifyScoreSubject2();
        Assert.assertEquals(questTypedrop22.getText(),"Integer");
        verifyScoreSubject2();
        Assert.assertEquals(questTypedrop23.getText(),"Matrix Match Grid");
        verifyScoreSubject2();
    }

    public void verifyJEEadvPhysicsFormat2(){
        clkSubject3();
        Assert.assertEquals(subject3Duration.getText(),"60");
        Assert.assertEquals(questTypedrop31.getText(),"Single Choice");
        verifyScore();
        Assert.assertEquals(questTypedrop32.getText(),"Integer");
        verifyScore();
        Assert.assertEquals(questTypedrop33.getText(),"Matrix Match Grid");
        verifyScore();
    }

    public void verifyJEEadvFormat2(){
        verifyJEEadvMathematicsFormat2();
        verifyJEEadvChemistryFormat2();
        verifyJEEadvPhysicsFormat2();
    }

    /////////////// NEET ///////////////

    public void unselectNEETChemistyPhysics(){
        if (Subject2Check.isSelected()){
            Subject2Check.click();
        }else {
            System.out.println("Subject 2 Not Selected");
        }
        if (Subject3Check.isSelected()){
            Subject3Check.click();
        }else {
            System.out.println("Subject 3 Not Selected");
        }
    }

    public void selectNEETBilogy() {
        String Subject1 = Subject1Lable.getText();
        if (Subject1.equals("Biology")) {
            if (Subject1Check.isSelected()) {
                System.out.println("Biology Selected");
            } else {
                Subject1Check.click();
            }
        }
    }

    public void enterNEETBiology(){
        clkSubject1();
        setSubject1Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_2000S);
        ClkAddQuestType11();
        delayTime(TIME_1000S);
        clkQuestionType11();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount11(prop.getProperty("NEETQuestion"));
        delayTime(TIME_1000S);
        enterPositiveMark11(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark11(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark11(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);

    }

    public void enterNEETChemistry(){
        clkSubject2();
        setSubject2Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType21();
        delayTime(TIME_1000S);
        clkQuestionType21();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount21(prop.getProperty("NEETQuestion"));
        delayTime(TIME_1000S);
        enterPositiveMark21(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark21(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark21(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
    }

    public void enterNEETPhysics(){
        clkSubject3();
        delayTime(TIME_1000S);
        setSubject3Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType31();
        delayTime(TIME_1000S);
        clkQuestionType31();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount31(prop.getProperty("NEETQuestion"));
        delayTime(TIME_1000S);
        enterPositiveMark31(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark31(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark31(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
    }



    ////////////// AIIMS ////////////

    public void selectAIIMSGeneralKnowledge() {
        String Subject1 = Subject1Lable.getText();
        if (Subject1.equals("General Knowledge")) {
            if (Subject1Check.isSelected()) {
                System.out.println("General Knowledge Selected");
            } else {
                Subject1Check.click();
            }
        }
    }

    public void selectAIIMSPhysics() {
        String Subject2 = Subject2Lable.getText();
        if (Subject2.equals("Physics")) {
            if (Subject2Check.isSelected()) {
                System.out.println("Physics Selected");
            } else {
                Subject2Check.click();
            }
        }
    }

    public void selectAIIMSChemistry() {
        String Subject3 = Subject3Lable.getText();
        if (Subject3.equals("Chemistry")) {
            if (Subject3Check.isSelected()) {
                System.out.println("Chemistry Selected");
            } else {
                Subject3Check.click();
            }
        }
    }

    public void selectAIIMSBiology() {
        String Subject4 = Subject4Lable.getText();
        if (Subject4.equals("Biology")) {
            if (Subject4Check.isSelected()) {
                System.out.println("Biology Selected");
            } else {
                Subject4Check.click();
            }
        }
    }

    public void enterAIIMSGendralKnowlege(){
        clkSubject1();
        setSubject1Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_2000S);
        ClkAddQuestType11();
        delayTime(TIME_1000S);
        clkQuestionType11();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount11(prop.getProperty("AIIMSGeneralKnowledgeQuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark11(prop.getProperty("AIIMSPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark11(prop.getProperty("AIIMSNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark11(prop.getProperty("AIIMSPartialMark"));
        delayTime(TIME_1000S);
    }

    public void enterAIIMSPhysics(){
        clkSubject2();
        setSubject2Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType21();
        delayTime(TIME_1000S);
        clkQuestionType21();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount21(prop.getProperty("AIIMSPhysicsQuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark21(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark21(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark21(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
    }

    public void enterAIIMSChemistry(){
        clkSubject3();
        delayTime(TIME_1000S);
        setSubject3Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType31();
        delayTime(TIME_1000S);
        clkQuestionType31();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount31(prop.getProperty("AIIMSChemistryQuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark31(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark31(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark31(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
    }

    public void enterAIIMSBiology(){
        clkSubject4();
        delayTime(TIME_1000S);
        setSubject4Duration(prop.getProperty("CommonDuration"));
        delayTime(TIME_1000S);
        ClkAddQuestType41();
        delayTime(TIME_1000S);
        clkQuestionType41();
        delayTime(TIME_1000S);
        selectSingleChoice();
        delayTime(TIME_1000S);
        enterQuestCount41(prop.getProperty("AIIMSBiologyQuestionCount"));
        delayTime(TIME_1000S);
        enterPositiveMark41(prop.getProperty("JEEmainPositiveMark"));
        delayTime(TIME_1000S);
        enterNegativeMark41(prop.getProperty("JEEmainNegativeMark"));
        delayTime(TIME_1000S);
        enterPartialMark41(prop.getProperty("JEEmainPartialMark"));
        delayTime(TIME_1000S);
    }

    @Step("Verify Test Format in Side Bar")
    public void checkTestFormatinSideBar(){
        waitUntillElementVisible(Test_Format);
        Test_Format.isDisplayed();
    }

    // Search Functionality

    @Step ("Enter Format ID")
    public void enterFormatId(String formatId){
        searchID.sendKeys(formatId);
    }

    @Step ("Enter Exam ID")
    public void enterFormatExamId(String examId){
        examID.sendKeys(examId);
    }

    @Step ("Click Search Button")
    public void clkSearch(){
        searchBtn.click();
    }

    @Step ("Click Test Type Drop Down")
    public void clkTestTypeDrop(){
        dropTestType.click();
    }

    @Step ("Verify data available")
    public void verifyListingTableAvailable(){
        delayTime(TIME_3000S);
        waitUntillElementVisible(driver.findElement(By.xpath("//div[@class='rt-th']")));
        try {
            Assert.assertTrue(listingTable.isDisplayed());
        }
        catch (NoSuchElementException e)
        {

        }
    }

    @Step ("Verify data not available")
    public void verifyListingTableNotavailable(){
        delayTime(TIME_3000S);
        waitUntillElementVisible(driver.findElement(By.xpath("//div[@class='rt-th']")));
        try {
            Assert.assertFalse(listingTable.isDisplayed());
        }
        catch (NoSuchElementException e)
        {

        }
    }

    @Step ("Enter Test Name")
    public void enterTestName(String testName){
        SearchTestName.sendKeys(testName);
    }

    @Step ("Verify the Count of the list Displayed")
    public void paginationCount(){
        waitUntillElementVisible(driver.findElement(By.xpath("//div[@class='rt-th']")));
        delayTime(TIME_2000S);
        List <WebElement> count = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        int formatCount = count.size();
        System.out.println("Actual List Count "+formatCount);
        int expectedCount = 25;
        Assert.assertEquals(formatCount,expectedCount);
    }

    @Step ("Click Next in Pagination")
    public void clkNextInPagination(){
        waitUntillElementVisible(tableHeader);
        delayTime(TIME_2000S);
        //String currentPage =paginationPageTextBox.getAttribute("value");
        paginationNext.click();
        waitUntillElementVisible(tableHeader);
        String nextPage = paginationPageTextBox.getAttribute("value");
        Assert.assertEquals(nextPage,"2");
    }

    @Step("Click Previous in Pagination From Other Page")
    public void clkPreviousFromOtherPageInPagination(){
        waitUntillElementVisible(tableHeader);
        String currentPage =paginationPageTextBox.getAttribute("value");
        int currentPageNumer = java.lang.Integer.parseInt(currentPage);
        if(currentPageNumer == 1){
            delayTime(TIME_2000S);
            paginationNext.click();
        }else {
            delayTime(TIME_2000S);
            paginationPrevious.click();
        }
        waitUntillElementVisible(tableHeader);
        String newPage = paginationPageTextBox.getAttribute("value");
        int pageNumber = java.lang.Integer.parseInt(newPage);
        Assert.assertEquals(pageNumber,currentPageNumer+1);
    }
    @Step("Click Previous in Pagination")
    public void clkPreviousInPagination(){
        waitUntillElementVisible(tableHeader);
        delayTime(TIME_2000S);
        Assert.assertFalse(paginationPrevious.isEnabled());
    }

    @Step("Click Last Page in Pagination")
    public void clkNextFromLastPageInPagination(){
        waitUntillElementVisible(tableHeader);
        delayTime(TIME_2000S);
        String totalPages = paginationTotalNumberOfPages.getText();
        int pages = java.lang.Integer.parseInt(totalPages);
        paginationPageTextBox.sendKeys(totalPages, Keys.ENTER);
        waitUntillElementVisible(tableHeader);
        delayTime(TIME_2000S);
        Assert.assertFalse(paginationNext.isEnabled());
    }

    public void getErrorMessage(){
    errorMessage.getText();
    }

}