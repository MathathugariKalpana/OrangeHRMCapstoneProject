package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElement(By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }
    
    public void waitForLoaderToDisappear() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(@class,'oxd-loading-spinner')]")));
    }
}