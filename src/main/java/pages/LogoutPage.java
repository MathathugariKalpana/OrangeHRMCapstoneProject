package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.WaitUtils;

public class LogoutPage {

    WebDriver driver;
    WaitUtils wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    // Locators
    By profileDropdown =By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    By logoutBtn =By.xpath("//a[text()='Logout']");
    By loginPageLogo =By.xpath("//div[contains(@class,'orangehrm-login-branding')]");

    // Methods
    public void clickProfileDropdown() {
        wait.waitForClickable(profileDropdown).click();
    }

    public void clickLogoutButton() {
        wait.waitForClickable(logoutBtn).click();
    }

    public boolean loginPageDisplayed() {
        return wait.waitForElement(loginPageLogo).isDisplayed();
    }
    public String getCurrentUrl() {
    	return driver.getCurrentUrl();
    }
    public void clickBrowserBackButton() {
    	 driver.navigate().back();
    }
}