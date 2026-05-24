package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

public class AdminPage {

	 
    WebDriver driver;
    WaitUtils wait;
    LoginPage lp;
    

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
        this.lp = new LoginPage(this.driver);
    }

    // ================= LOCATORS =================
    By sidebar=By.xpath("//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']");

    By adminTab = By.xpath("//span[text()='Admin']");

    By adminHeader = By.xpath("//h6[text()='Admin']");
   By systemuser=By.xpath("//i[@class='oxd-icon bi-caret-down-fill']");

    By usernameSearch =
            By.xpath("((//input[@class='oxd-input oxd-input--active'])[2])");

    By searchBtn =
            By.xpath("//button[@type='submit']");

    By addBtn =
            By.xpath("//button[normalize-space()='Add']");
    By userDropdown = By.xpath("(//div[contains(@class,'oxd-select-text')])[1]");
	By adminRole = By.xpath("(//div[contains(@class,'oxd-select-text')])[1]//div[text()='Admin']");
	By userStatusDropdown = By.xpath("(//div[contains(@class,'oxd-select-text')])[4]");
	By enabledStatus = By.xpath("//div[contains(@class,'oxd-select-text')][1]//div[text()='Enabled']");
	By essRole = By.xpath("//div[text()='ESS']");
	By employeeName = By.xpath("//input[@placeholder=\"Type for hints...\"]");
	By newUsername = By.xpath("(//input[contains(@class,'oxd-input')])[2]");
	By password = By.xpath("(//input[@type='password'])[1]");
	//By deletebtn=By.xpath("(//div[@role='row']//i[contains(@class,'bi-trash')])[1]");
	By confirmPassword = By.xpath("(//input[@type='password'])[2]");
	By saveBtn = By.xpath("//button[@type=\"submit\"]");
    

    By editBtn =
            By.xpath("//i[@class='oxd-icon bi-pencil-fill']");

    By deleteBtn =
            By.xpath("//button[contains(@class,'oxd-icon-button')])[14]");

    By confirmDeleteBtn =
            By.xpath("//button[normalize-space()='Yes, Delete']");

    // ================= ACTIONS =================

    public void clickSideTab() {
        wait.waitForClickable(sidebar).click();
    }
    public void clickAdminTab() throws InterruptedException {
    	//Thread.sleep(30);
        wait.waitForElement(adminTab).click();
        //Thread.sleep(30);
    }

    public boolean adminPageDisplayed() {
        return wait.waitForElement(adminHeader).isDisplayed();
    }
    
    public void clickSystemuserTab() {
        wait.waitForClickable(systemuser).click();
    }

    public void searchUser(String username) {
       wait.waitForElement(usernameSearch).clear();
        wait.waitForElement(usernameSearch).sendKeys(username);
    }

    public void clickSearch() {
        wait.waitForClickable(searchBtn).click();
    }

    public void clickAdd() {
        wait.waitForClickable(addBtn).click();
    }
public void selectUserRole(String role) {
		
		wait.waitForElement(userDropdown).click();
		 driver.findElement(By.xpath("//span[text()='"+ role +"']")).click();
	}	
	
	public void selectStatus(String Status) {
		
		wait.waitForElement(userStatusDropdown).click();
		driver.findElement(By.xpath("//span[text()='"+ Status +"']")).click();
	}
	
	public void enterEmployeeName(String empName) {
		
		wait.waitForElement(employeeName).sendKeys(empName);
	}
	
	public void enterUsername(String uname) {
		wait.waitForElement(newUsername).sendKeys(uname);
	}	
	
	public void enterPassword(String pass) {
		wait.waitForElement(password).sendKeys(pass);
	}
	
	public void enterConfirmPassword(String confpass) {
		wait.waitForElement(confirmPassword).sendKeys(confpass);
	}
	
	public void clickSaveBtn() {
//		driver.findElement(saveBtn).click();
		wait.waitForElement(saveBtn).click();
	}

    public void clickEdit() {
        wait.waitForClickable(editBtn).click();
    }

    public void clickDelete() throws InterruptedException {
    	 
        wait.waitForClickable(deleteBtn).click();
        Thread.sleep(600);
    }

    public void confirmDelete() {
        wait.waitForClickable(confirmDeleteBtn).click();
    }
}