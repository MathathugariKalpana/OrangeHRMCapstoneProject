package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStep {
	WebDriver driver=Hooks.driver;
    LoginPage lp ;
	@Given("User launches the application")
	public void user_launches_the_application() {
	     
	}

	@When("User enters valid username and valid password")
	public void user_enters_valid_username_and_valid_password() {
		lp= new LoginPage(driver);
	     lp.EnteruserName("Admin");
	     lp.EnterPassword("admin123");
	}

	@And("clicks on login button")
	public void Login() {
	     lp.LoginBtn();
	}

	@Then("user login should be successful")
	public void user_login_should_be_successful() {
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		System.out.println("Successfully login");
	     
	}
	@When("User enters invalid username and valid password")
	public void user_enters_invalid_username_and_valid_password() {
		lp= new LoginPage(driver);
	     lp.EnteruserName("Kalpana");
	     lp.EnterPassword("admin123");
	     
	}

	@Then("User should see invalid username error")
	public void user_should_see_invalid_username_error() {
	     Assert.assertEquals(lp.ErrorMsg(), "Invalid credentials");
	     System.out.println("Invalid credentials");
	}

	@When("User enters valid username and invalid password")
	public void user_enters_valid_username_and_invalid_password() {
		lp= new LoginPage(driver);
	     lp.EnteruserName("Admin");
	     lp.EnterPassword("Admin1234");
	    
	}

	@Then("User should see invalid password error")
	public void user_should_see_invalid_password_error() {
		 Assert.assertEquals(lp.ErrorMsg(), "Invalid credentials");
	     System.out.println("Invalid credentials");
	}

	@Given("User is on login page")
	public void user_is_on_login_page() {
	     
	}

	@When("User leaves username and password blank")
	public void user_leaves_username_and_password_blank() {
		 
	}

	@When("Clicks on login button")
	public void clicks_on_login_button() {
		lp=new LoginPage(driver);
		lp.LoginBtn();
	     
	}

	@Then("User should see mandatory field error")
	public void user_should_see_mandatory_field_error() {
		lp = new LoginPage(driver);
		Assert.assertEquals(lp.ManditoryFieldsError(), "Login");
		 System.out.println("Display Error As Required");
	}

	@Then("Verify username textbox is displayed")
	public void verify_username_textbox_is_displayed() {
		lp = new LoginPage(driver);
		Assert.assertTrue(lp.UsernameTextBoxdisplayed());
	}

	@Then("Verify password textbox is displayed")
	public void verify_password_textbox_is_displayed() {
		lp = new LoginPage(driver);
		Assert.assertTrue(lp.PasswordTextBoxdisplayed());
	}

	@Then("Verify login button is displayed")
	public void verify_login_button_is_displayed() {
		lp = new LoginPage(driver);
		Assert.assertTrue(lp.LoginBtndisplayed());
	}

	@When("User enters invalid credentials")
	public void user_enters_invalid_credentials() {
		lp= new LoginPage(driver);
	     lp.EnteruserName("kalpana");
	     lp.EnterPassword("kalpana123");
	}

	@Then("Verify error message is displayed")
	public void verify_error_message_is_displayed() {
		 Assert.assertEquals(lp.ErrorMsg(), "Invalid credentials");
	     System.out.println("Invalid credentials");
	}
	
	//Forget password Module
	
	@When("User clicks on Forgot Password link")
	public void user_clicks_on_forgot_password_link() {
	     lp=new LoginPage(driver);
	     lp.clickForgotPassword();
	}

	@Then("User should navigate to reset password page")
	public void user_should_navigate_to_reset_password_page() {
		lp.resetPasswordPageDisplayed();
	     
	}

	/*@Given("User is on reset password page")
	public void user_is_on_reset_password_page() {
		
	     
	}

	@When("User enters valid username for reset")
	public void user_enters_valid_username_for_reset() {
	     
	}

	@When("User clicks on reset password button")
	public void user_clicks_on_reset_password_button() {
	     
	}

	@Then("Verify success message after reset")
	public void verify_success_message_after_reset() {
	     
	}*/
	
	@Given("User is on reset password page")
	public void user_is_on_reset_password_page() {
		lp=new LoginPage(driver);
		lp.clickForgotPassword();
		
	     
	}

	@When("User enters invalid username for reset")
	public void user_enters_invalid_username_for_reset() {
		lp=new LoginPage(driver);
		lp.EnteruserName("kalpana");
	    
	}
	@And("User clicks on reset password button")
	public void user_clicks_on_reset_password_button() {
		lp.clickResetButton();
	     
	}

	@Then("Verify reset password error message")
	public void verify_reset_password_error_message() {
		lp.getSuccessMessage();
	     
	}

}
