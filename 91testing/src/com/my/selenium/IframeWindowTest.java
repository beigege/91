package com.my.selenium;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class IframeWindowTest {
	public static WebDriver driver;
	@BeforeClass
	public static void setup(){
		System.out.println("@BeforeClass**********************");
//		driver = new FirefoxDriver();
		// ���������������Ϣ
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		driver = new ChromeDriver(desiredCapabilities);
		System.out.println((driver != null)?"not null":"is null");
	}

	@Test
	public void f() throws InterruptedException {
		driver.get("http://www.91testing.net/");
		driver.findElement(By.linkText("��¼")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login_username")).sendKeys("9108");
		driver.findElement(By.id("login_password")).sendKeys("7905886");
		driver.findElement(By.className("btn btn-primary btn-lg btn-block")).click();
		String text = driver.findElement(By.linkText("�ҵ�ѧϰ")).getText();
		assertEquals("�ҵ�ѧϰ", text);
		
	}
}
