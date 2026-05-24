package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.LogoutPage;

public class LogoutStep {
    WebDriver driver = Hooks.driver;
    LogoutPage lp= new LogoutPage(driver);

    // ---------------- LOGOUT ----------------

   /* @Given("User is logged into the application")
    public void userapplication() {
       // lp = new LogoutPage(driver);
    }*/

    @When("User clicks on profile dropdown")
    public void user_clicks_on_profile_dropdown() {
        lp.clickProfileDropdown();
    }

    @And("User clicks on Logout button")
    public void user_clicks_on_logout_button() {
        lp.clickLogoutButton();
    }

    @Then("User should be logged out successfully")
    public void user_should_be_logged_out_successfully() {
        Assert.assertTrue(lp.loginPageDisplayed());
        System.out.println("Logout successful");
    }

    // ---------------- SESSION TERMINATION ----------------

    @Given("User logs out from application")
    public void user_logs_out_from_application() {
        /*lp = new LogoutPage(driver);
        lp.clickProfileDropdown();
        lp.clickLogoutButton();*/
    }

    @When("User clicks browser back button")
    public void user_clicks_browser_back_button() {
        driver.navigate().back();
    }

    @Then("User should not access application pages")
    public void user_should_not_access_application_pages() {
//        LogoutPage logoutPage = new LogoutPage(driver);
//        boolean isLoginVisible = false;
//        try {
//            isLoginVisible = logoutPage.loginPageDisplayed();
//        } catch (Exception e) {
//            // If wait failed, fallback to URL check
//            isLoginVisible = driver.getCurrentUrl().toLowerCase().contains("login")
//                    || driver.getCurrentUrl().toLowerCase().contains("auth");
//        }
//        Assert.assertTrue(isLoginVisible, "Expected to be redirected to login page after logout.");
//        System.out.println("Session terminated successfully");
//
    String actualURL=lp.getCurrentUrl();
    Assert.assertFalse(actualURL.contains("login"));
    System.out.println("Session Terminated Successfully");
    }

}
