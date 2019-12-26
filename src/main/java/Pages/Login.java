package Pages;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login {
    public static int TIME_10000S = 10000;
    public static int TIME_5000S = 5000;
    public static int TIME_4000S = 4000;
    public static int TIME_3000S = 3000;
    public static int TIME_2000S = 2000;
    public static int TIME_1000S = 1000;
    public static int TIME_200S = 200;
    WebDriver driver;
    ExtentTest test;


    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/div/div/button[1]")
    WebElement signIn;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/div/div/button[2]")
    WebElement signup;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/div/form/div/div[1]/div/input")
    WebElement username;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/div/form/div/div[2]/div/input")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/div/form/div/button[1]/span[1]")
    WebElement signinbtn;
    @FindBy(name = "email")
    WebElement validationMsgEmail;
    @FindBy(name = "password")
    WebElement validationMsgPassword;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/div/form/div/div[3]")
    WebElement forgotPasswordLink;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[3]/form/div/div[2]/div/input")
    WebElement forgotPasswordEmail;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[3]/form/div/button/span[1]")
    WebElement forgetPassSubmit;
    @FindBy(xpath = "//*[@id=\"client-snackbar\"]")
    WebElement validationMsgForgotPassword;

    public Login(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, this);
    }

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignIn() {
        signIn.click();
    }

    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }

    public void clickForgotPassSubmit() {
        forgetPassSubmit.click();
    }

    public void enterEmailForgot(String forgotemail) {
        forgotPasswordEmail.sendKeys(forgotemail);
    }

    public void setUsernamePassword(String strusername, String strpassword) {
        username.sendKeys(strusername);
        password.sendKeys(strpassword);
    }

    public void clickSignup() {
        signup.click();
    }

    public void clickLogin() {
        signinbtn.click();
        String HomeBaseUrl = driver.getCurrentUrl();
    }

    public void clearUsernamePassword() {
        username.clear();
        password.clear();
    }

    public void setValidationMsgEmail() {
        String validationmsgemail = validationMsgEmail.getAttribute("validationMessage");
        Assert.assertEquals(validationmsgemail, "Please fill in this field.");
    }

    public void setValidationMsgPassword() {
        String validationmsgpassword = validationMsgPassword.getAttribute("validationMessage");
        Assert.assertEquals(validationmsgpassword, "Please fill in this field.");
    }

    public void setValidationMsgForgotPass() {
        String validationmsgforgotpass = forgotPasswordEmail.getAttribute("validationMessage");
        Assert.assertEquals(validationmsgforgotpass, "Please fill in this field.");
    }

    public void setValidationMsgForgotPassword() {
        String validationmsgforgotpassword = validationMsgForgotPassword.getAttribute("validationMessage");
        Assert.assertEquals(validationmsgforgotpassword, "Password reset instructions sent to Surendar@embibe.com");
    }

    public void getValidationMsg(ExtentTest test) {
        Assert.assertEquals(validationMsgForgotPassword.getText(), "Invalid User name or Password");
        //test.log(LogStatus.PASS, "Test Case (TestNoPassword) Status is passed");
    }

    public void getValidatiionMsgForgotPassIncorrectEmail() {
        String validationmsgforgotpassincorrectemail = validationMsgForgotPassword.getAttribute("validationMessage");
        Assert.assertEquals(validationmsgforgotpassincorrectemail, "E-mail does not exist in the database. Please contact the administrator.");
    }
}