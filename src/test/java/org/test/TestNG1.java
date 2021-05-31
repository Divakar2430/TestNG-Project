package org.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG1 {
static WebDriver driver;
@BeforeClass
private void launchBrowser() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ganapathy\\Desktop\\gana.java\\TestNGProject\\driver\\chromedriver.exe");
	driver = new ChromeDriver();
}

@AfterMethod
private void endTime() {
	Date d = new Date();
	System.out.println(d);
}

@AfterClass
private void quitBrowser() {
	driver.quit();
}

@BeforeMethod
private void startTime() {
	Date d = new Date();
	System.out.println(d);
}

@Test
private void testCase1() {
	driver.get("https://www.facebook.com");
	Assert.assertTrue(driver.getTitle().contains("Facebook"));
	WebElement user = driver.findElement(By.id("email"));
	user.sendKeys("Farith@gmail.com");
	Assert.assertEquals("Farith@gmai.com", user.getAttribute("value"));
	WebElement pass = driver.findElement(By.name("pass"));
	pass.sendKeys("fonature@123");
	WebElement button = driver.findElement(By.id("loginbutton"));
	button.click();
}

@Test
private void testCase2() {
	driver.get("https://www.facebook.com");
	SoftAssert s = new SoftAssert();
	s.assertTrue(driver.getCurrentUrl().equals("google"));
	WebElement user = driver.findElement(By.id("email"));
	user.sendKeys("Karthick"); 
	s.assertEquals("Karthick", user.getAttribute("value"));
	WebElement pass = driver.findElement(By.name("pass"));
	pass.sendKeys("542364872");
	WebElement button = driver.findElement(By.id("loginbutton"));
	button.click();
	s.assertTrue(driver.getCurrentUrl().equals("https://www.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=110"));
	//s.assertAll();
}
}


