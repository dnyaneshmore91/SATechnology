package com.SALabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tandable {

	
	    public static void main(String[] args) {
	        // Setting up Chrome driver path
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\More Dnyaneshwar\\Downloads\\chromedriver-win64\\chromedriver.exe");

	        // Creating a new instance of the Chrome driver
	        WebDriver driver = new ChromeDriver();

	        // Task 1: Open the URL
	        driver.get("https://www.tendable.com/");

	        // Task 2: Confirm accessibility of top-level menus
	        verifyTopLevelMenu(driver, "Home");
	        verifyTopLevelMenu(driver, "Our Story");
	        verifyTopLevelMenu(driver, "Our Solution");
	        verifyTopLevelMenu(driver, "Why Tendable");

	        // Task 3: Verify "Request a Demo" button presence and activity
	        verifyRequestDemoButton(driver, "Home");
	        verifyRequestDemoButton(driver, "Our Story");
	        verifyRequestDemoButton(driver, "Our Solution");
	        verifyRequestDemoButton(driver, "Why Tendable");

	        // Task 4: Navigate to "Contact Us" section, choose "Marketing", and complete the form
	        navigateToContactUsAndFillForm(driver);

	        // Close the browser
	        driver.quit();
	    }

	    private static void verifyTopLevelMenu(WebDriver driver, String menuName) {
	        WebElement menu = driver.findElement(By.linkText(menuName));
	        System.out.println("Menu '" + menuName + "' is accessible: " + menu.isDisplayed());
	    }

	    private static void verifyRequestDemoButton(WebDriver driver, String menuName) {
	        WebElement menu = driver.findElement(By.linkText(menuName));
	        menu.click();
	        WebElement requestDemoButton = driver.findElement(By.xpath("//a[contains(text(),'Request a Demo')]"));
	        System.out.println("Request a Demo button on '" + menuName + "' page is present and active: " + requestDemoButton.isEnabled());
	    }

	    private static void navigateToContactUsAndFillForm(WebDriver driver) {
	        WebElement contactUsLink = driver.findElement(By.linkText("Contact Us"));
	        contactUsLink.click();
	        WebElement marketingCheckbox = driver.findElement(By.xpath("//label[contains(text(),'Marketing')]"));
	        marketingCheckbox.click();
	        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
	        submitButton.click();
	        WebElement errorMessage = driver.findElement(By.xpath("//span[contains(text(),'Message field is required')]"));
	        if (errorMessage.isDisplayed()) {
	            System.out.println("Test Passed: Error message is displayed.");
	        } else {
	            System.out.println("Test Failed: Error message is not displayed.");
	        }
	    
	


	}

}
