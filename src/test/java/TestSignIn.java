import base.TestBase;
import Pages.Login;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.*;

public class TestSignIn extends TestBase {

    public static ExtentTest test;
    public static ExtentReports report;
    Login objlogin;

    @BeforeClass
    public static void startTest() {
        report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReportResults.html");
        test = report.startTest("ReportSignIn");
    }

    @Test(priority = 4)
    public void TestNoUsername() {
        objlogin.clearUsernamePassword();
        objlogin.setUsernamePassword("", "embibe1234");
        objlogin.clickLogin();
        delayTime(TIME_1000S);
        objlogin.setValidationMsgEmail();
    }

    @Test(priority = 3)
    public void TestNoPassword() {
        objlogin.clearUsernamePassword();
        objlogin.setUsernamePassword("Surendar@embibe.com", "");
        objlogin.clickLogin();
        delayTime(TIME_1000S);
        objlogin.setValidationMsgPassword();
    }

    @Test(priority = 2)
    public void TestIncorrectEmail() {
        objlogin.clearUsernamePassword();
        objlogin.setUsernamePassword("suren@embibe.com", "embibe1234");
        objlogin.clickLogin();
        delayTime(TIME_1000S);
        objlogin.getValidationMsg(test);
    }

    @Test(priority = 1)
    public void TestIncorrectPassword() {
        objlogin.clearUsernamePassword();
        objlogin.setUsernamePassword("surendar@embibe.com", "embi34");
        objlogin.clickLogin();
        delayTime(TIME_2000S);
        objlogin.getValidationMsg(test);
    }

    @Test(priority = 5)
    public void NoUserNamePassword() {
        objlogin.clearUsernamePassword();
        objlogin.setUsernamePassword("", "");
        objlogin.clickLogin();
        delayTime(TIME_1000S);
        objlogin.setValidationMsgEmail();
    }

    @Test(priority = 6)
    public void EmptytextForgotPassword() {
        objlogin.clickForgotPassword();
        objlogin.clickForgotPassSubmit();
        objlogin.setValidationMsgForgotPass();
    }

    @Test(priority = 7)
    public void ForgotPassword() {
        objlogin.clickForgotPassword();
        objlogin.enterEmailForgot("Surendar@embibe.com");
        objlogin.clickForgotPassSubmit();
        delayTime(TIME_2000S);
        objlogin.setValidationMsgForgotPassword();
    }

    @Test(priority = 8)
    public void ForgotPasswordIncorrectEmail() {
        objlogin.clickForgotPassword();
        objlogin.enterEmailForgot("test@embibe.com");
        objlogin.clickForgotPassSubmit();
        objlogin.getValidatiionMsgForgotPassIncorrectEmail();
    }

    @Test(priority = 9)
    public void TestValidlogin() {
        objlogin.clearUsernamePassword();
        objlogin.setUsernamePassword("surendar@embibe.com", "embibe1234");
        objlogin.clickLogin();
    }

}