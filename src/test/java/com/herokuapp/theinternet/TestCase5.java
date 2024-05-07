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

@Test
public class TestCase5 {

	private WebDriver driver;

	public void timeoutException() {
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-exceptions/");
		// Click Add button
		WebElement ButtonAddElement = driver.findElement(By.id("add_btn"));
		ButtonAddElement.click();
		// Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		WebElement inputfield = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
		// Verify second input field is displayed
		Assert.assertTrue(inputfield.isDisplayed(), "Row 2 is not displayed");

	}
}
