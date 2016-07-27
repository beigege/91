package com.my.selenium;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class FindElementTest2_iframe {
	public static WebDriver dr;
	@BeforeClass
	public static void setup(){
		System.out.println("@BeforeClass**********************");
		dr = new FirefoxDriver();
	}


	@Test
	public void test_iframe() throws InterruptedException{
		dr.get("http://mail.163.com/");
		Thread.sleep(1000);
		dr.switchTo().frame("x-URS-iframe");
//		WebElement name = dr.findElement(By.id("dologin"));
//		WebElement name = dr.findElement(By.xpath(".//*[@name='email']"));
		WebElement name = dr.findElement(By.xpath("//input[@class='j-inputtext dlemail']"));
//		WebElement name = dr.findElement(By.name("email"));
//		WebElement name = dr.findElement(By.className("j-inputtext dlemail"));
//		WebElement name = dr.findElement(By.cssSelector(".j-inputtext.dlemail"));
//		WebElement name = dr.findElement(By.cssSelector("input.j-inputtext.dlemail"));
		System.out.println(name.getText());
		name.sendKeys("15210906485");
		Thread.sleep(2000);
		System.out.println(name.getText());
		dr.findElement(By.name("password")).sendKeys("yingma_my7905886");
		dr.findElement(By.id("dologin")).click();
		
	}
	@AfterClass
	public static void tearDown(){
		System.out.println("@AfterClass**********************");
		dr.close();
	}

}
