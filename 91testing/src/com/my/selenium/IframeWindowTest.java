package com.my.selenium;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class IframeWindowTest {
	static WebDriver driver;

	@AfterClass
	public static void setup() {
		// 设置浏览器驱动信息
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		driver = new ChromeDriver(desiredCapabilities);
	}

	@Test
	public void f() {
		driver.get("http://baidu.com");
	}
}
