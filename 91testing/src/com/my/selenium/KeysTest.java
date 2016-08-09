package com.my.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeysTest {
	
	static WebDriver dr ;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		dr = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		dr.quit();
	}

	@Test
	public void test() throws InterruptedException {
		dr.get("http://baidu.com");
		WebElement text = dr.findElement(By.id("kw"));
		text.sendKeys("hello keyss");
		Thread.sleep(2000);
		text.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		text.sendKeys(Keys.SPACE);
		text.sendKeys("selenium");
		text.sendKeys(Keys.ENTER);
	}

}
