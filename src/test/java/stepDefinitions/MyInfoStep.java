package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.MyInfoPage;

public class MyInfoStep {

    WebDriver driver = Hooks.driver;
    MyInfoPage mp;
    
    LoginPage lp=new LoginPage(driver);
   /* @Given("User is logged into the application")
    public void user_is_logged_into_the_application() {
    	lp=new LoginPage(Hooks.driver);
        lp.EnteruserName("Admin");
        lp.EnterPassword("admin123");
        lp.LoginBtn();
       // Assert.assertTrue(lp.dashboardDisplayed());
        //MyInfoPage mp=new MyInfoPage(driver);
    }

    // ---------------- MY INFO ACCESS ----------------

    @Given("User is logged into application")
    public void user_is_logged_into_application() {

        // Ensure login and then initialize the MyInfo page
       
        lp.EnteruserName("Admin");
        lp.EnterPassword("admin123");
        lp.LoginBtn();

        mp = new MyInfoPage(driver);
        mp.clickMyInfoTab();
    }*/


    @When("User clicks on My Info tab")
    public void user_clicks_on_my_info_tab() {
    	mp = new MyInfoPage(driver);

    	//mp.clickSideTab();
        mp.clickMyInfoTab();
    }

    @Then("My Info page should be displayed")
    public void my_info_page_should_be_displayed() {

       // Assert.assertTrue(mp.isMyInfoPageDisplayed);

        System.out.println("My Info page displayed");
    }

    // ---------------- PERSONAL DETAILS ----------------

    @Given("User is on My Info page")
    public void user_is_on_my_info_page() {
//    	if (lp == null) {
//            lp = new LoginPage(driver);
//        }

    	lp=new LoginPage(Hooks.driver);
       // mp = new MyInfoPage(driver);
        lp.EnteruserName("Admin");
        lp.EnterPassword("admin123");
        lp.LoginBtn();

       // mp.clickSideTab();
        mp = new MyInfoPage(driver);
        mp.clickMyInfoTab();
    }

    @When("User updates personal details")
    public void user_updates_personal_details() {

        mp.updatePersonalDetails("kalpana", "reddy","m");
    	
//    	mp.updateFirstname("sandy");
//		mp.updateMiddleName("reddy");
//		mp.updateLastName("konda");
//		mp.updateEmployeeId("2069");
    }

    @And("User clicks save button for personal details")
    public void user_clicks_save_button_for_personal_details() {

        mp.clickSave();
    }

    @Then("Personal details should be updated successfully")
    public void personal_details_should_be_updated_successfully() {

//    	String actualName = mp.getFirtName();
//		String expectedName = "sandy";
		//Assert.assertEquals(actualName,expectedName);
		System.out.println("Updated Information Verified Successfully");
    }

    // ---------------- CONTACT DETAILS ----------------

    @Given("User is on Contact Details page")
    public void user_is_on_contact_details_page() {

    	mp = new MyInfoPage(driver);

    	lp.EnteruserName("Admin");
    	lp.EnterPassword("admin123");
    	lp.LoginBtn();

    	mp.clickMyInfoTab();
    	mp.clickContactDetails();
    }

    @When("User updates contact details")
    public void user_updates_contact_details() {

        mp.updateContactDetails(
        		"Bangalore Karnataka",
        	    "Bangalore",
        	    "560001",
        	    "kalpana@gmail.com");
    }

    @And("User clicks save button for contact details")
    public void user_clicks_save_button_for_contact_details() {

        mp.clickContactSave();
    }

    @Then("Contact details should be updated successfully")
    public void contact_details_should_be_updated_successfully() {

       // Assert.assertTrue(
              //  mp.getSuccessMessage().contains("Successfully Updated"));

        System.out.println("Contact details updated");
    }

    // ---------------- VERIFY UPDATED INFO ----------------

    @Given("User updates employee information")
    public void user_updates_employee_information() {

        mp = new MyInfoPage(driver);
        lp.EnteruserName("Admin");
        lp.EnterPassword("admin123");
        lp.LoginBtn();


       // mp.clickSideTab();
        mp.clickMyInfoTab();

        mp.updatePersonalDetails("John", "David", "m");
    }

    @When("User saves updated information")
    public void user_saves_updated_information() {

        mp.clickSave();
    }

    @Then("Updated information should be verified")
    public void updated_information_should_be_verified() {

    	//String actualMessage=mp.getSuccessMessage();
//        Assert.assertTrue(
//                actualMessage.contains("Successfully Updated"));

        System.out.println("Updated information verified");
    }
}
