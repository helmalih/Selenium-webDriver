package com.herokuapp.theinternet;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCase3 {
	private WebDriver driver;

	@Test
	public void invalidElementStateException() {
		// Open page
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-exceptions/");
		// Clear input field
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(14));
		WebElement input_1 = driver.findElement(By.xpath("//div[@id='row1']/input"));
		// Type text into the input field
		WebElement edditButton = driver.findElement(By.xpath("//div[@id='row1']/button[@name='Edit']"));
		edditButton.click();
		input_1.clear();
		
		input_1.sendKeys("Pasta");
		WebElement SaveButton = driver.findElement(By.xpath("//div[@id='row1']/button[@name='Save']"));
		SaveButton.click();
		// Verify text changed
		String value = input_1.getAttribute("value");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// verify text changed
        assertEquals(value, "Pasta", "Input 1 field value is not expected");
		/*
		 * assertTrue(actualMessage.contains(expectedMessage),
		 * "Actual  message does not contain expected. \nActual :" + actualMessage +
		 * "\nExpected: " + expectedMessage);
		 */
		// verify text saved 
		  WebElement SavedMessage = driver.findElement(By.id("confirmation"));
		  String expectedMessage = "Row 1 was saved";
		  String actualMessage =SavedMessage.getText();
		  assertEquals(actualMessage, expectedMessage,"Confirmation Message is not expected");
		 
		driver.quit();
	}
}
