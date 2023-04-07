package com.softserve.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.softserve.pages.HomePage;

import java.time.Duration;

public abstract class TestRunnerFirst {

	private final String BASE_URL = "https://demo.opencart.com/";
	private final int WAIT_SECONDS = 15;
	private WebDriver driver;

	protected void presentationSleep() {
		presentationSleep(1);
	}

	protected void presentationSleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void beforeSuite() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_SECONDS));
		driver.manage().window().maximize();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		presentationSleep();
		if (driver == null)
			return;
		driver.quit();
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(BASE_URL);
		presentationSleep();
	}

	@AfterMethod
	public void afterMethod() {
		presentationSleep();
	}

	protected HomePage loadApplication() {
		return new HomePage(driver);
	}
}