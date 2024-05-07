package com.herokuapp.theinternet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestCase1 {
	private WebDriver driver;
	@Test
	// NoSuchElementException 
	public void noSuchElementException() {
		System.out.println("Starting TestCase1");
		//Open page
        String url="https://practicetestautomation.com/practice-test-exceptions/";
		System.setProperty("webdriver.chrome.driver", "C:/Users/helmalih/Desktop/Drivers/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//Click Add button
		WebElement ButtonAddElement = driver.findElement(By.id("add_btn"));
		ButtonAddElement.click();
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
		//Explicit wait 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));
		WebElement inputfield= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
		//Verify Row 2 input field is displayed
		//WebElement inputfield = driver.findElement(By.xpath("//div[@id='row2']/input"));
		Assert.assertTrue(inputfield.isDisplayed(), "Row 2 is not displayed");
		//WebElement inputfield = driver.findElement(By.xpath("//div[@id='rows']/div[3]/div[@class='row']/input[@type='text']"));
			driver.close();
	}
	
	}


