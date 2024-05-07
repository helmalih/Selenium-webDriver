package com.herokuapp.theinternet;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class TestCase2 {

	private WebDriver driver;

	public void elementNotInteractableException() {
		String url = "https://practicetestautomation.com/practice-test-exceptions/";
		driver = new ChromeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		WebElement ButtonAddElement = driver.findElement(By.id("add_btn"));
		ButtonAddElement.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(14));
		WebElement input_2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
		input_2.sendKeys("Pasta");
		
    	WebElement SaveButton = driver.findElement(By.xpath("//div[@id='row2']/button[@name='Save']"));
		SaveButton.click();
		
		WebElement SavedMessage = driver.findElement(By.id("confirmation"));
		String expectedMessage = "Row 2 was saved";
		String actualMessage = SavedMessage.getText();
		
		/*
		 * assertTrue(actualMessage.contains(expectedMessage),
		 * "Actual  message does not contain expected. \nActual :" + actualMessage +
		 * "\nExpected: " + expectedMessage);
		 */
		assertEquals(actualMessage, expectedMessage, "Confirmation Message is not expected");
	}
}
