package Hooks;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageobjects.Billboardspage;
import pageobjects.Forgotpasswordpage;
import pageobjects.Signinpage;
import pageobjects.Memberspage;
import resources.Base;
public class Testhooks extends Base {
	public WebDriver driver;
	public WebDriverWait wait;
	public Signinpage signinpage;
	public Memberspage memberspage;
	public Forgotpasswordpage forgotpasswordpage;
	public Billboardspage billboardspage;
	 private static Logger LOGGER =
			   LogManager.getLogger(Testhooks.class);
	 
	public void initializeWait() {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	}
	
	@Before
	public void setup(Scenario scenario) throws Exception {
		
		LOGGER = LogManager
				.getLogger(Testhooks.class.getName());
		LOGGER.info("Execution Started");
		driver = initializeDriver();
		LOGGER.info("Browser got launched");
		signinpage = new Signinpage(driver);
		memberspage = new Memberspage(driver);
		forgotpasswordpage = new Forgotpasswordpage(driver);
		billboardspage = new Billboardspage(driver);
		driver.get(prop.getProperty("Al_Arabia_URL"));

		initializeWait();
		LOGGER.info("Navigated to url");
		System.out.println("Login page opened");

		Robot robot = new Robot();
		System.out.println("About to zoom out");
		for (int i = 0; i < 3; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
		LOGGER.info("Page is zoomed out");
		System.out.println(
				"** Execution started for scenario -" + scenario.getName());
		System.out.println("++ Browser got launched and maximized ++");
		System.out.println("++ Application URL got opened in the browser ++");
		Thread.sleep(1000);
		return;
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {

		if (driver != null) {
			driver.quit();
			LOGGER.info("Browser got closed");
			System.out.println("-- Browser got closed --");
			System.out.println(
					"** Execution ended for scenario -" + scenario.getName());
		}
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.BYTES);
		if (scenario.isFailed()) {
			scenario.attach(screenshot, "image/png", scenario.getName());
			LOGGER.info("Failed scenario screenshot got captured" + scenario.getName());
		}else {
//            scenario.attach(screenshot, "image/png", "Passed scenario: " + scenario.getName());
//            LOGGER.info("Passed scenario screenshot captured: " + scenario.getName());
        }
	}

	public WebDriver getDriver() {
		return driver;
	}

}
