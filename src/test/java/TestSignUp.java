import base.TestBase;
import Pages.Login;
import Pages.Signup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestSignUp extends TestBase {

    WebDriver driver;
    Signup objsignup;
    Login objlogin;


    @Test(priority = 1)
    public void emptyFieldsClickSignup() {
        objsignup.clearUsernamePassword();
        objsignup.createAccount();
        objsignup.setValidationMsgFname();
        objsignup.delay();
    }

    @Test(priority = 2)
    public void enterOnlyUsernameClickSignup() {
        objsignup.clearUsernamePassword();
        objsignup.enterFirstname("Test");
        objsignup.createAccount();
        objsignup.setValidationMsgLname();
        objsignup.delay();
    }

    @Test(priority = 3)
    public void enterOnlyPasswordClickSignup() {
        objsignup.clearFnameLname();
        objsignup.enterFirstname("Test");
        objsignup.enterLastname("embibe");
        objsignup.clearUsernamePassword();
        objsignup.enterEmail("");
        objsignup.enterPassword("embibe1234");
        objsignup.createAccount();
        objsignup.setValidationMsgEmail();
        objsignup.delay();
    }

    @Test(priority = 4)
    public void checkValidationMsginReenterPass() {
        objsignup.clearFnameLname();
        objsignup.enterFirstname("Test");
        objsignup.enterLastname("Embibe");
        objsignup.clearUsernamePassword();
        objsignup.enterEmail("Surendar@embibe.com");
        objsignup.enterPassword("embibe1234");
        objsignup.enterPhonenumber("4527921445");
        objsignup.createAccount();
        objsignup.setValidationMsgrepass();
        objsignup.delay();
    }

    @Test(priority = 5)
    public void checkValidationMsgincorrectPass() {
        objsignup.clearFnameLname();
        objsignup.enterFirstname("Test");
        objsignup.enterLastname("Embibe");
        objsignup.clearUsernamePassword();
        objsignup.enterEmail("Surendar@embibe.com");
        objsignup.enterPassword("embibe1234");
        objsignup.setRepeatpassword("embibe");
        objsignup.enterPhonenumber("4527921445");
        objsignup.createAccount();
        objsignup.passwordNotMatch();
        objsignup.delay();
    }

    @Test(priority = 6)
    public void existingUserSignup() {
        objsignup.clearFnameLname();
        objsignup.enterFirstname("Test");
        objsignup.enterLastname("Embibe");
        objsignup.clearUsernamePassword();
        objsignup.enterEmail("Surendar@embibe.com");
        objsignup.enterPassword("embibe1234");
        objsignup.setRepeatpassword("embibe1234");
        objsignup.enterPhonenumber("4527921445");
        objsignup.createAccount();
        objsignup.existinguser();
        objsignup.delay();
    }

    @Test(priority = 7)
    public void login(){
        objsignup.login(); //screen should naviagate to login screen While click Login through signUp screen
        objlogin.setUsernamePassword("Test-admin@embibe.com", "embibe1234");
        objlogin.clickLogin();
    }
}
