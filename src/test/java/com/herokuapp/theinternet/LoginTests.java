package com.herokuapp.theinternet;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests {
	private WebDriver driver;

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	private void setUp(@Optional("chrome") String browser) {
		// Create driver
		switch (browser) {
		case "chrome":
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

	@Test(priority = 1, groups = { "positiveTests", "smokeTest" })
	public void positiveLoginTest() {
		System.out.println("Starting loginTest");
//		
//		open test page 
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("page is opened");
//		enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
//		enter password 
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
//		click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
//		verifications :
//	    new url
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");
//		logout button is visible
		WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logoutButton.isDisplayed(), "LogoutButton is not visible");
//	WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius broken']"));

//		succeful login message 
		// WebElement successmessage = driver.findElement(By.cssSelector("div#flash"));
		WebElement successmessage = driver.findElement(By.xpath("/html//div[@id='flash']"));
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successmessage.getText();
		// Assert.assertEquals(actualMessage, expectedMessage,"Actual message is not the
		// same as expected");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message.\n Actual Message:" + actualMessage
						+ "\n Expected Message:" + expectedMessage);
		logoutButton.click();
		System.out.println("Test finished");

	}

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 2, groups = { "negativeTests", "smokeTest" })
	public void negativeLoginTest(String username, String password, String expecteErrorMessage) {
		System.out.println("Starting incorrectLoginTest with" + username + "and" + password);
		sleep(1);

//		// Create driver 
		System.setProperty("webdriver.gecko.driver", "C:/Users/helmalih/Desktop/Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		System.out.println("Browser started");

//		open test page 
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);

		driver.manage().window().maximize();

		sleep(1);
		System.out.println("page is opened");
//		enter username
		WebElement usernameElement = driver.findElement(By.id("username"));
		usernameElement.sendKeys(username);
//		enter password 
		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(password);
//		click login button
		WebElement loginButton = driver.findElement(By.tagName("button"));
		loginButton.click();
		// verifications
		WebElement errorMessage = driver.findElement(By.id("flash"));
		String actualErrorMessage = errorMessage.getText();
		assertTrue(actualErrorMessage.contains(expecteErrorMessage),
				"Actual error message does not contain expected. \nActual :" + actualErrorMessage + "\nExpected: "
						+ expecteErrorMessage);

	}

	@AfterMethod(alwaysRun = true)
	private void tearDown(WebDriver driver) {
		// close browser
		driver.close();
	}

	/**
	 * stop excution for the given amount of time
	 * 
	 * @author helmalih
	 *
	 */
	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
