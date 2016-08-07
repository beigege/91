package com.my.selenium;

import java.io.File;
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
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		dr = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		dr.quit();
	}

	@Test
	public void test() throws InterruptedException {
		dr.get("http://www.ctrip.com/");
		Thread.sleep(1000);
		List<WebElement> divs = dr.findElements(By.xpath("//div[@class='product-item']"));
		System.out.println(divs.size());

	}
	@Test
	public void test_navigate(){
		//之前是在www.163.com页面操作，现在需要验证下www.sina.com.cn页面上的东西。

	dr.get("http://www.163.com/");
	//跳转新页面
	dr.navigate().to("http://www.sina.com.cn");
	//如果要回到之前的页面可以用
	dr.navigate().to("http://www.163.com/");
//	或者 
//	dr.navigate().back();

	}



}
