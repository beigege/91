package com.my.seleniumJunit4;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class testBase {
	
	static WebDriver driver = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities capabilities =  DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	

}
