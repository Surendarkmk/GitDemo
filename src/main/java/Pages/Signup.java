package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Signup {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/div/div/button[2]")
    WebElement firstSignUp;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div/div[1]/div/input")
    WebElement firstName;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div/div[2]/div/input")
    WebElement lastName;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div/div[3]/div/input")
    WebElement emailId;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div/div[4]/div/input")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div/div[5]/div/input")
    WebElement repeatpassword;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div/div[6]/div/input")
    WebElement phoneNumber;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div/button/span[1]")
    WebElement signupbtn;
    @FindBy(name = "email")
    WebElement validationMsgEmail;
    @FindBy(name= "password")
    WebElement validationMsgpass;
    @FindBy(name = "repeat_password")
    WebElement validationMsgRepass;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[2]/div/form/div/div[7]/span")
    WebElement login;

    public Signup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignup() {
        firstSignUp.click();
    }

    public void enterFirstname(String firstname){
        firstName.sendKeys(firstname);
    }

    public void enterLastname(String lastname){
        lastName.sendKeys(lastname);
    }

    public void enterEmail(String emailid) {
        emailId.sendKeys(emailid);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void setRepeatpassword(String reptpass) {
        repeatpassword.sendKeys(reptpass);
    }

    public void enterPhonenumber(String number){
        phoneNumber.sendKeys(number);
    }

    public void createAccount() {
        signupbtn.click();
    }

    public void login(){
        login.click();
    }

    public void clearUsernamePassword() {
        emailId.clear();
        password.clear();
    }

    public void clearFnameLname(){
        firstName.clear();
        lastName.clear();
        phoneNumber.clear();
    }

    public void passwordNotMatch() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div[4]/div")).getText(), "Passwords do not match.");
    }

    public void existinguser() {
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"client-snackbar\"]")).getText(), "E-Mail ID already exists. Please provide a new E-Mail ID");
    }

    public void setValidationMsgFname(){
        String validationmsgName = firstName.getAttribute("validationMessage");
        Assert.assertEquals(validationmsgName, "Please fill in this field.");
    }

    public void setValidationMsgLname(){
        String validationmsgLname = lastName.getAttribute("validationMessage");
        Assert.assertEquals(validationmsgLname, "Please fill in this field.");
    }

    public void setValidationMsgEmail() {
        String validationmsg = validationMsgEmail.getAttribute("validationMessage");
        Assert.assertEquals(validationmsg, "Please fill in this field.");
    }

    public void setValidationMsgpass() {
        String validationmsgpass = validationMsgpass.getAttribute("validationMessage");
        Assert.assertEquals(validationmsgpass, "Please fill in this field.");
    }

    public void setValidationMsgrepass() {
        String validationmsgpass = validationMsgRepass.getAttribute("validationMessage");
        Assert.assertEquals(validationmsgpass, "Please fill in this field.");
    }

    public void setValidationMsgPhone(){
        String validationmsgPhone = phoneNumber.getAttribute("validationMessage");
        Assert.assertEquals(validationmsgPhone, "please filee in this field.");
    }

    public void delay() {
        try {
            Thread.sleep(2000);                 //3000 milliseconds is 3 second.
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
