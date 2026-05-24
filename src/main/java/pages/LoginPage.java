package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

public class LoginPage {
	WebDriver driver;
	 WaitUtils wait;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		wait = new WaitUtils(driver);
	 
	}
	
	 //finding elements path
	    By username = By.name("username");
	    By password = By.xpath("//input[@name='password']");
	    By loginBtn = By.xpath("//button[@type='submit']");
	    By dashboardText = By.xpath("//h6[text()='Dashboard']");
	    By errorMsg=By.className("oxd-alert-content-text");
	    By requiredField=By.className("oxd-text");
	    By forgetpassword=By.className("orangehrm-login-forgot-header");
	    By Restpassword=By.xpath("//button[@type='submit']");
	    By restpage=By.xpath("//h6[text()='Reset Password']");
	    By SuccessMsg=By.xpath("//h6[text()='Reset Password link sent successfully']");
	//login module
	public void EnteruserName(String UserName) {
		wait.waitForElement(username).sendKeys(UserName);
	}
	public void EnterPassword(String pwd) {
		 wait.waitForElement(password)
         .sendKeys(pwd);
	}
	public void LoginBtn() {
		  wait.waitForClickable(loginBtn)
          .click();
	}
	public boolean dashboardDisplayed() {
	    return wait.waitForElement(dashboardText).isDisplayed();
	}
	
	public String ErrorMsg() {
		return wait.waitForElement(errorMsg)
                .getText();
	}
	public String ManditoryFieldsError() {
		return wait.waitForElement(requiredField)
                .getText();
	}
	//checking  UI elements 
	public boolean UsernameTextBoxdisplayed() {
		return wait.waitForElement(username)
                .isDisplayed();
		
	}
	public boolean PasswordTextBoxdisplayed() {
		return wait.waitForElement(password)
                .isDisplayed();
		}
	public boolean LoginBtndisplayed() {
		return wait.waitForElement(loginBtn)
                .isDisplayed();
		}
	
	//for password rest module
	
	public void clickForgotPassword() {

		 wait.waitForClickable(forgetpassword)
         .click();
		 }

	public boolean resetPasswordPageDisplayed() {

		return wait.waitForElement(restpage)
                .isDisplayed();
		}

	public void enterResetUsername(String Username) {

		 wait.waitForElement(username)
         .sendKeys(Username);
		 }

	public void clickResetButton() {

		  wait.waitForClickable(Restpassword)
          .click();
	}

	public String getSuccessMessage() {

        return wait.waitForElement(SuccessMsg)
                .getText();
	}
}
