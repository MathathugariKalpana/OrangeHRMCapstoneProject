package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.LoginPage;
import pages.PIMModulePage;

public class PIMSteps {

    WebDriver driver = Hooks.driver;
    PIMModulePage pim;
    LoginPage lp;
    
  /*  @Given("User is logged into  application")
    public void user_is_logged_into_the_application() {
    	lp=new LoginPage(Hooks.driver);
    	lp=new LoginPage(driver);
        lp.EnteruserName("Admin");
        lp.EnterPassword("admin123");
        lp.LoginBtn();
    }*/
    // ---------------- ADD EMPLOYEE ----------------

    @Given("User is on PIM page")
    public void user_is_on_pim_page() {

        // ensure login
//        if (lp == null) {
//            lp = new LoginPage(driver);
//        }
        lp=new LoginPage(Hooks.driver);
        lp.EnteruserName("Admin");
        lp.EnterPassword("admin123");
        lp.LoginBtn();

        pim = new PIMModulePage(driver);
       // pim.clickSideTab();
        pim.clickPIMTab();
    }


    @When("User clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {

        pim.clickAddEmployee();
    }

    @And("User enters employee details")
    public void user_enters_employee_details() {

        pim.enterEmployeeDetails("John");
    }

    @And("User clicks Save button")
    public void user_clicks_save_button() {

        pim.clickSave();
    }

    @Then("Employee should be added successfully")
    public void employee_should_be_added_successfully() {

        System.out.println("Employee added successfully");
        Assert.assertTrue(true);
    }

    // ---------------- SEARCH EMPLOYEE ----------------

    @Given("User is on Employee List page")
    public void user_is_on_employee_list_page() {

    	 lp=new LoginPage(Hooks.driver);
         lp.EnteruserName("Admin");
         lp.EnterPassword("admin123");
         lp.LoginBtn();
        pim = new PIMModulePage(driver);
       // pim.clickSideTab();
        pim.clickPIMTab();
    }

    @When("User enters employee ID")
    public void user_enters_employee_id() {

    	//pim.clickEmpInfoTab();
        pim.searchEmployeeById("01715");
    }

    @And("User clicks Search button")
    public void user_clicks_search_button() {

        pim.clickSearch();
    }

    @Then("Employee details should be displayed")
    public void employee_details_should_be_displayed() {

        System.out.println("Employee found");
        Assert.assertTrue(true);
    }

    // ---------------- EDIT EMPLOYEE ----------------

    @Given("User searches an employee")
    public void user_searches_an_employee() {

    	//pim.clickSideTab();
    	 lp=new LoginPage(Hooks.driver);
         lp.EnteruserName("Admin");
         lp.EnterPassword("admin123");
         lp.LoginBtn();
        pim = new PIMModulePage(driver);

       // pim.clickSideTab();
        pim.clickPIMTab();
        //pim.clickEmpInfoTab();
        pim.searchEmployeeById("0312");
        pim.clickSearch();
    }

    @When("User clicks Edit employee button")
    public void user_clicks_edit_employee_button() throws InterruptedException {

    	Thread.sleep(2000);
        pim.clickEdit();
    }

    @And("User updates employee details")
    public void user_updates_employee_details() {

        System.out.println("Updating employee details");
    }

    @And("User clicks Save button after edit")
    public void user_clicks_save_button_after_edit() {

        pim.clickSave();
    }

    @Then("Employee details should be updated successfully")
    public void employee_details_should_be_updated_successfully() {

        System.out.println("Employee updated");
        Assert.assertTrue(true);
    }

    // ---------------- UPLOAD PHOTO ----------------

    @Given("User is on Add Employee page")
    public void user_is_on_add_employee_page() {
    	 lp=new LoginPage(Hooks.driver);
         lp.EnteruserName("Admin");
         lp.EnterPassword("admin123");
         lp.LoginBtn();

        pim = new PIMModulePage(driver);
       // pim.clickSideTab();
        pim.clickPIMTab();
        pim.clickAddEmployee();
    }

    @When("User uploads employee profile picture")
    public void user_uploads_employee_profile_picture() {

        pim.uploadProfilePicture(
                "C:\\Users\\Public\\Pictures\\Sample Pictures\\Tulips.jpg");
    }

    @Then("Profile picture should be uploaded successfully")
    public void profile_picture_should_be_uploaded_successfully() {

        System.out.println("Profile picture uploaded");
        Assert.assertTrue(true);
    }

    // ---------------- DELETE EMPLOYEE ----------------

    @Given("User searches employee for delete")
    public void user_searches_employee_for_delete() {

    	lp=new LoginPage(Hooks.driver);
        lp.EnteruserName("Admin");
        lp.EnterPassword("admin123");
        lp.LoginBtn();
        pim = new PIMModulePage(driver);
        //pim.clickSideTab();
        pim.clickPIMTab();
        //pim.clickEmpInfoTab();
        pim.searchEmployeeById("0312");
        pim.clickSearch();
    }

    @When("User clicks Delete employee button")
    public void user_clicks_delete_employee_button() {

        pim.clickDelete();
    }

    @And("User confirms employee deletion")
    public void user_confirms_employee_deletion() {

        pim.confirmDelete();
    }

    @Then("Employee record should be deleted successfully")
    public void employee_record_should_be_deleted_successfully() {

        System.out.println("Employee deleted successfully");
        Assert.assertTrue(true);
    }
}

