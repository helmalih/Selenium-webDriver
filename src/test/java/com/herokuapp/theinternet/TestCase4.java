package com.herokuapp.theinternet;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class TestCase4 {

	private WebDriver driver;

	public void staleElementReferenceException() {
		// Open page
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-exceptions/");
//	Find the instructions text element
		WebElement instruction = driver.findElement(By.id("instructions"));
//	Push add button
		WebElement ButtonAddElement = driver.findElement(By.id("add_btn"));
		ButtonAddElement.click();
//	Verify instruction text element is no longer displayed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(13));
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("instructions"))), "Instructions are still displayed");
	driver.close();
	}
}
