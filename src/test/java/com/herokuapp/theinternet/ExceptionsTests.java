package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class ExceptionsTests {
	private WebDriver driver;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	private void setUp(@Optional("chrome") String browser) {
		// Create driver
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:/Users/helmalih/Desktop/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "fireFox":
			System.setProperty("webdriver.gecko.driver", "C:/Users/helmalih/Desktop/Drivers/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Do not know how to start " + browser + "staring chrome instead");
			driver = new ChromeDriver();
			break;
		}
		driver = new ChromeDriver();
		System.out.println("Browser started");

//			open test page 
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);

		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	private void tearDown(WebDriver driver) {
		// close browser
		driver.close();
	}
}
