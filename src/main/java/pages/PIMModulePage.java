package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

public class PIMModulePage {
	WebDriver driver;
	WaitUtils wait;
	
	public PIMModulePage(WebDriver driver) {
		this.driver=driver;
		wait = new WaitUtils(driver);
	}
	
	By sidebar=By.xpath("//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']");
	By pimtab=By.xpath("//span[text()='PIM']");
	By addBtn=By.xpath("//button[contains(.,'Add')]");
	By firstname=By.name("firstName");
	By Middlename=By.name("middleName");
	By lastname=By.name("lastName");
	By savebtn=By.xpath("//button[@type=\'submit\']");
	By empinfo=By.xpath("//i[@class='oxd-icon bi-caret-down-fill']");
	By Empidsearch=By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By searchBtn =By.xpath("//button[@type='submit']");
	By editBtn =By.xpath("(//button[contains(@class,'oxd-table-cell-action-space')])[1]");
	By deleteBtn =By.xpath("(//i[contains(@class,'bi-trash')])[1]");
    By confirmDeleteBtn =By.xpath("//button[text()=' Yes, Delete ']");
    By uploadPhoto =By.xpath("//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']");
    //button[@type='submit']
    // Methods

    public void clickSideTab() {
        wait.waitForClickable(sidebar).click();
    }
    
    public void clickPIMTab() {
    	//wait.waitForClickable(sidebar).click(); 
         wait.waitForClickable(pimtab).click();
    }

    public void clickAddEmployee() {
        wait.waitForClickable(addBtn).click();
    }

    public void enterEmployeeDetails(String fname) {
        wait.waitForElement(firstname).sendKeys(fname);
       // driver.findElement(lastname).sendKeys(lname);
    }

    public void clickSave() {
        wait.waitForClickable(savebtn).click();
    }

    public void clickEmpInfoTab() {
        wait.waitForClickable(empinfo).click();
    }
    
    public void searchEmployeeById(String empId) {
        wait.waitForElement(Empidsearch).sendKeys(empId);
    }

    public void clickSearch() {
        wait.waitForClickable(searchBtn).click();
    }

    public void clickEdit() {
        wait.waitForClickable(editBtn).click();
    }

    public void clickDelete() {
        wait.waitForClickable(deleteBtn).click();
    }

    public void confirmDelete() {
        wait.waitForClickable(confirmDeleteBtn).click();
    }

    public void uploadProfilePicture(String path) {
        wait.waitForElement(uploadPhoto).sendKeys(path);
    }
}