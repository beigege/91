package com.my.selenium;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowSwitchTest {

	private static WebDriver dr;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		dr = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		dr.close();
	}

	@Test
	public void test() throws InterruptedException {
		dr.get("http://www.ctrip.com/");
		Thread.sleep(1000);
		///html/body/div[13]/div[1]/div[2]/div[2]/div/div[2]/div
		List<WebElement> divs = dr.findElements(By.xpath("//div[@class='product-item']"));
		System.out.println(divs.size());
		
	}

}
