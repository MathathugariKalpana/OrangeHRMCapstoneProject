package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtils;

public class MyInfoPage {

    WebDriver driver;
    WaitUtils wait;

    public MyInfoPage(WebDriver driver) {

        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    // Locators

    By sidebar=By.xpath("//i[@class='oxd-icon bi-list oxd-topbar-header-hamburger']");
    By myInfoTab = By.xpath("//span[text()='My Info']");
    By myInfoHeader=By.xpath("//h6[text()='Personal Details']");
    
    By firstName =By.name("firstName");
    By middleName = By.xpath("//input[@name='middleName']");
    By lastName = By.name("lastName");
    By employeeId = By.xpath("(//input[contains(@class,'oxd-input')])[5]");
    By personalSaveBtn = By.xpath("//h6[text()='Personal Details']/following::button[@type='submit'][1]");
//    By saveBtn =By.xpath("(//h6[text()='Contact Details']/following::button[@type='submit'][1])");
    By contactDetailsTab =By.xpath("//a[text()='Contact Details']");
    By street1 = By.xpath("//label[text()='Street 1']/ancestor::div[contains(@class,'oxd-input-group')]//input");
	By city = By.xpath("//label[text()='City']/ancestor::div[contains(@class,'oxd-input-group')]//input");
	By zipCode = By.xpath("//label[text()='Zip/Postal Code']/ancestor::div[contains(@class,'oxd-input-group')]//input");
	By email = By.xpath("//label[text()='Work Email']/ancestor::div[contains(@class,'oxd-input-group')]//input");
//	By contactSaveBtn = By.xpath("(//button[@type='submit'])[1]");
	By saveBtn =By.xpath("(//h6[text()='Contact Details']/following::button[@type='submit'][1])");
//    By addressStreet1 = By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]");
//    By mobileNumber =By.xpath("(//input[@class='oxd-input oxd-input--active'])[10]");
    By successMessage =By.xpath("//div[contains(@class,'oxd-toast-content')]//p[contains(text(),'Successfully')]");

    // Methods

    public void clickSideTab() {
        wait.waitForClickable(sidebar).click();
    }
    public void clickMyInfoTab() {
    	wait.waitForClickable(myInfoTab).click();
    	
    }
    public boolean isMyPageDisplayed() {
		return wait.waitForElement(myInfoHeader).isDisplayed();
	}
	

    public void updatePersonalDetails(String fname,String mname, String lname) {
        wait.waitForElement(firstName).clear();
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(middleName).clear();
        driver.findElement(middleName).sendKeys(mname);
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lname);
    }

    public void clickSave() {
        wait.waitForClickable(personalSaveBtn).click();
    }

    public void clickContactDetails() {
        wait.waitForClickable(contactDetailsTab).click();
    }

    public void updateContactDetails(String street, String cityname,String zipcode1,String emailid) {
//        wait.waitForElement(addressStreet1).clear();
//        driver.findElement(addressStreet1).sendKeys(address);
//        driver.findElement(mobileNumber).clear();
//        driver.findElement(mobileNumber).sendKeys(mobile);
    	wait.waitForElement(street1).clear();
    	wait.waitForElement(street1).sendKeys(street);
    	wait.waitForElement(city).clear();
    	wait.waitForElement(city).sendKeys(cityname);
    	wait.waitForElement(zipCode).clear();
    	wait.waitForElement(zipCode).sendKeys(zipcode1);
    	wait.waitForElement(email).clear();
    	wait.waitForElement(email).sendKeys(emailid);
    }
    public void clickContactSave() {
        wait.waitForClickable(saveBtn).click();
    }

    public String getSuccessMessage() {

    	WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
    	WebElement msg=w.until(ExpectedConditions.presenceOfElementLocated(successMessage));
        return wait.waitForElement(successMessage).getText();
    }
//	public void getFirtName(String fname1) {
//		// TODO Auto-generated method stub
//		wait.waitForElement(firstName).clear();
//        driver.findElement(firstName).sendKeys(fname1);
//	}
}

