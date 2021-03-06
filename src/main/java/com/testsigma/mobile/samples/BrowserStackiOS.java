package com.testsigma.mobile.samples;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;


public class BrowserStackiOS
{
	public static WebDriver driver;
	public static String userName = "mythri7";
	public static String accessKey = "b2Msz9uSQyDnUfHVDcxV";

	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "safari");
		caps.setCapability("device", "iPhone 7 Plus");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "10.3");
		caps.setCapability("browserVersion", "Latest"); 

		driver = new RemoteWebDriver(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);

		driver.get("https://demoqa.com/registration/");
		Thread.sleep(3000);
		driver.getTitle();
		WebElement firstname = driver.findElement(By.id("name_3_firstname"));
		firstname.sendKeys("Testsigma Testing");
		WebElement select = driver.findElement(By.id("dropdown_7"));
		Select country = new Select(select);
		country.selectByValue("Brazil");

		System.out.println("working fine");
		driver.quit();
	}

}
