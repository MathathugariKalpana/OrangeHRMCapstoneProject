package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends BaseClass {
	public static WebDriver driver;
	
	@Before
	public void setup() {
		ChromeOptions ch=new ChromeOptions();
		//ch.addArguments("--headless");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(ch);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@After
	public void tearDown() {
		if (driver != null) {
            driver.quit();
        }
	}
}
