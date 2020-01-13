package base;

import Pages.*;
import com.browserstack.local.Local;
import com.google.common.io.Files;
import constants.TimeDelay;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.time.Instant;
import java.util.List;
import java.util.Properties;

public class TestBase {
    public static final String USERNAME = "embibe1";
    public static final String AUTOMATE_KEY = "M7fG8LiP1hz6evTh3z3q";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static int TIME_10000S = 10000;
    public static int TIME_6000S = 6000;
    public static int TIME_5000S = 5000;
    public static int TIME_4000S = 4000;
    public static int TIME_3000S = 3000;
    public static int TIME_2000S = 2000;
    public static int TIME_1000S = 1000;
    public static int TIME_500S = 500;
    public static WebDriver driver;
    public static Properties prop;
    public static Properties auth;
    public static Properties publication;
    public static Properties format;
    public Login objlogin;
    public Instructions objinstructions;
    public Concepts objconcepts;
    public QuestionGeneration objquestgen;
    public TestFormat objtestformat;
    public Authors authors;
    public Publications publications;
    public TestCreation testcreation;
    protected Questions questions;
    public Books books;
    private Local local;
    private Instant wait;

    /*private void startLocalTestingOnBrowserStack() throws Exception {
            local = new Local();
            Map<String, String> options = new HashMap<String, String>();
            options.put("key", "M7fG8LiP1hz6evTh3z3q");
            System.out.println("port number 45691 is busy " + isPortBusy(45691));
            if (isPortBusy(45691)) {
                killThePort();
            }

            local.start(options);
    }

    public void browserStack throws Exception(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "70.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() throws Exception {
        System.out.println(" before suite");
        startLocalTestingOnBrowserStack();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() throws Exception {
        System.out.println(" after suite");
        if (local != null) {
            local.stop();
            if (isPortBusy(45691))
                killThePort();

        }

    }

    private boolean isPortBusy(int portNumber) {
        boolean isBusy = false;
        try (Socket socket = new Socket("localhost", portNumber)) {
            isBusy = true;
        } catch (IOException e) {
            isBusy = false;
        }
        return isBusy;
    }


    public void killThePort() {
        //lsof -i :45691 to find out  the process id by port number
        //kill -9 98206
        try {
            Runtime run = Runtime.getRuntime();
            Process process = run.exec("pgrep BrowserSt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String processId;
            while ((processId = reader.readLine()) != null) {
                int exitVal = process.waitFor();
                if (exitVal == 0) {
                    System.out.print("browserStack process is running on this process id ");
                    System.out.println(processId);
                    run.exec("kill -9 " + processId);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }*/

    public TestBase() {
        try {
            prop = new Properties();
            InputStream ip = getClass().getClassLoader().getResourceAsStream("questions.properties");
            prop.load(ip);

            auth = new Properties();
            InputStream author = getClass().getClassLoader().getResourceAsStream("auth.properties");
            auth.load(author);

            format = new Properties();
            InputStream formats = getClass().getClassLoader().getResourceAsStream("testformat.properties");
            format.load(formats);

            publication = new Properties();
            InputStream publi = getClass().getClassLoader().getResourceAsStream("publications.properties");
            publication.load(publi);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.firefoxdriver().setup();
        //driver = new FirefoxDriver();
        String BaseUrl = "https://new-content-admin-staging.embibe.com/";
        driver.get(BaseUrl);
        driver.manage().window().maximize();
    }

    @Attachment(type = "image/png")
    public static byte[] screenshot(WebDriver driver)/* throws IOException */ {
        try {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            return Files.toByteArray(screen);
        } catch (IOException e) {
            return null;
        }
    }

    public void reactLogout() {
        driver.findElement(By.xpath("//*[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-edgeEnd\"]")).click();
        delayTime(TimeDelay.TIME_1000S);
        driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
    }

    public void rubyLogout() {
        driver.findElement(By.xpath("//*[@class=\"dropdown-toggle\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[1]/nav/ul/li/ul/li[6]")).click();
    }

    @BeforeMethod(alwaysRun = true)
    public void open() {
        setup();
    }

    @AfterMethod(alwaysRun = true)
    public void close(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            screenshot(driver);
            System.out.println("Successfully captured a screenshot");
        }
        logout();
    }

    @Step("Click Signin /n/ Enter User Name /n/ Enter Password /n/ Click Login")
    public void setup() {
        initialization();
        objquestgen = new QuestionGeneration(driver);
        objinstructions = new Instructions(driver);
        objlogin = new Login(driver);
        questions = new Questions(driver);
        objconcepts = new Concepts(driver);
        objtestformat = new TestFormat(driver);
        authors = new Authors(driver);
        publications = new Publications(driver);
        testcreation = new TestCreation(driver);
        books = new Books(driver);
        objlogin.clickSignIn();
        objlogin.clearUsernamePassword();
        objlogin.setUsernamePassword("CGautomation01@gmail.com", "embibe1234");
        objlogin.clickLogin();
        delayTime(TimeDelay.TIME_3000S);
    }

    public void logout() {
        delayTime(TimeDelay.TIME_1000S);
        if (isElementPresent(By.xpath("//*[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-edgeEnd\"]"))) {
            reactLogout();
        } else {
            rubyLogout();
        }
        driver.close();
    }

    public void delayTime(int time) {
        try {
            Thread.sleep(time);                 //milliseconds is one second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitUntillElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForPageToLoad() {
        new WebDriverWait(driver, 30).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void verifyNoElementFound(By locator) {
        List<WebElement> lstElements = driver.findElements(locator);
        int i = lstElements.size();
        if (i >= 0) {
            System.out.println("No Such Element Found");
        } else {
            System.out.println("Element Found");
            Assert.assertFalse(lstElements.isEmpty());
        }

    }

    public void pageScrole(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
        }
    }

    public void pageScroleMiddle(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
    }

    public void ckEditor(WebElement element, String enterText) {
        element.click();
        delayTime(TimeDelay.TIME_1000S);
        String option1 = driver.getWindowHandle();
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        delayTime(TimeDelay.TIME_500S);
        WebElement sat = driver.findElement(By.tagName("body"));
        sat.click();
        sat.sendKeys(enterText);
        driver.switchTo().window(option1);
        delayTime(TimeDelay.TIME_2000S);
    }

    public void ckEditor1(WebElement element, String enterText) {
        element.click();
        delayTime(TimeDelay.TIME_1000S);
        String option1 = driver.getWindowHandle();
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        delayTime(TimeDelay.TIME_500S);
        WebElement sat = driver.findElement(By.tagName("body"));
        sat.click();
        sat.sendKeys(Keys.ENTER);
        sat.sendKeys(enterText);
        driver.switchTo().window(option1);
        delayTime(TimeDelay.TIME_2000S);
    }
}