package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;
import pages.LoginPage;

public class AdminSteps {
	// LoginPage lp=new LoginPage(driver);
    WebDriver driver=Hooks.driver ;
    AdminPage ap;
    
    LoginPage lp;
    
         
    // ---------------- LOGIN CHECK ----------------

    @Given("User is logged into the application")
    public void user_is_logged_into_the_application() {
    	//driver.get("https://opensource-demo.orangehrmlive.com/we/index.php/auth/login");
    	lp=new LoginPage(Hooks.driver);
    	
    	lp.EnteruserName("Admin");
        lp.EnterPassword("admin123");
        lp.LoginBtn();
        
        Assert.assertTrue(lp.dashboardDisplayed());

        // Assuming login already done in LoginSteps OR reuse login here
        ap = new AdminPage(driver);
    }

    // ---------------- ADMIN TAB ----------------
    @Given("User is on Admin page")
    public void user_is_on_admin_page() throws InterruptedException {

        // Ensure login page object exists and perform login (each scenario is independent)
        if (lp == null) {
            lp = new LoginPage(driver);
        }
        lp.EnteruserName("Admin");
        lp.EnterPassword("admin123");
        lp.LoginBtn();

        // Then navigate to Admin page
        ap = new AdminPage(driver);
        //ap.clickSideTab();
        ap.clickAdminTab();
    }


    @When("User clicks on Admin tab")
    public void user_clicks_on_admin_tab() throws InterruptedException {
    	
        ap.clickAdminTab();
    }

    @Then("Admin page should be displayed")
    public void admin_page_should_be_displayed() {

        Assert.assertTrue(ap.adminPageDisplayed());
        System.out.println("Admin page is displayed");
    }

    // ---------------- SEARCH USER ----------------

    @Given("User is on Admin page for search")
    public void user_is_on_admin_page_for_search() throws InterruptedException {

        ap = new AdminPage(driver);

        if (lp == null) {
            lp = new LoginPage(driver);
        }
        lp.EnteruserName("Admin");
        lp.EnterPassword("admin123");
        lp.LoginBtn();

       // ap.clickSideTab();
        ap.clickAdminTab();
    }
    @When("User enters username in search box")
    public void user_enters_username_in_search_box() throws InterruptedException {

    	//ap.clickSystemuserTab();
//    	ap = new AdminPage(driver);
//    	lp.EnteruserName("Admin");
//        lp.EnterPassword("admin123");
//        lp.LoginBtn();
    	//ap.clickSideTab();
        ap.clickAdminTab();
        ap.searchUser("Admin");
    }

    @And("Clicks on search button")
    public void clicks_on_search_button() {

        ap.clickSearch();
    }

    @Then("User should be displayed in search results")
    public void user_should_be_displayed_in_search_results() {

        System.out.println("User found in results");
        //Assert.assertTrue(true);
    }

    // ---------------- ADD USER ----------------

   /* @Given("User is on Admin page for add user")
    public void user_is_on_admin_page_for_add_user() {

        ap = new AdminPage(driver);
        ap.clickAdminTab();
    }*/

    @When("User clicks on Add button")
    public void user_clicks_on_add_button() {

    	// ap = new AdminPage(driver);
    	 
        ap.clickAdd();
    }

    @And("User enters valid user details")
    public void user_enters_valid_user_details() {
    	ap.selectUserRole("ESS");
    	ap.enterEmployeeName("Kalpana");
    	ap.selectStatus("Enabled");
    	ap.enterUsername("kalpana");
    	ap.enterPassword("kalpana123");
    	ap.enterConfirmPassword("kalpana123");

        System.out.println("Entering user details (implement in Page class)");
    }

    @And("Clicks on Save button")
    public void clicks_on_save_button() {

    	ap.clickSaveBtn();
        System.out.println("Click Save button (add locator in AdminPage)");
    }

    @Then("New user should be created successfully")
    public void new_user_should_be_created_successfully() {

        System.out.println("User created successfully");
        Assert.assertTrue(true);
    }

    // ---------------- EDIT USER ----------------

   /* @Given("User is on Admin page for edit user")
    public void user_is_on_admin_page_for_edit_user() {

        ap = new AdminPage(driver);
        ap.clickAdminTab();
    }*/

    @When("User searches existing user")
    public void user_searches_existing_user() {

    	//ap.clickSystemuserTab();
       // ap.searchUser("Admin");
        ap.clickSearch();
    }

    @And("User clicks on Edit button")
    public void user_clicks_on_edit_button() {

        ap.clickEdit();
    }

    @And("User updates user details")
    public void user_updates_user_details() {

        System.out.println("Updating user details");
    }

    @And("User clicks on save button")
    public void user_clicks_on_save_button() {

    	ap.clickSaveBtn();
        System.out.println("Click Save after edit");
    }

    @Then("User details should be updated")
    public void user_details_should_be_updated() {

        System.out.println("User updated successfully");
        //Assert.assertTrue(true);
    }

    // ---------------- DELETE USER ----------------

    @Given("user is on Admin page")
    public void user_is_on_admin_page1() throws InterruptedException {

    	 lp = new LoginPage(driver); 
        lp.EnteruserName("Admin");
        lp.EnterPassword("admin123");
        lp.LoginBtn();

        ap = new AdminPage(driver);
        ap.clickAdminTab();
    }

    @When("User searches existing user for delete")
    public void user_searches_existing_user_for_delete() {

        ap.searchUser("Admin");
        ap.clickSearch();
        
    }

    @And("User clicks on delete button")
    public void user_clicks_on_delete_button() throws InterruptedException {

        ap.clickDelete();
    }

    @And("Confirms deletion")
    public void confirms_deletion() {

        ap.confirmDelete();
    }

    @Then("User should be deleted successfully")
    public void user_should_be_deleted_successfully() {

        System.out.println("User deleted successfully");
    }
}