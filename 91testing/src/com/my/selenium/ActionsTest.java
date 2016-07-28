package com.my.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsTest {

	private static WebDriver dr;

	@BeforeClass
	public static void setUp() throws Exception {
		dr = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		dr.close();
	}

	@Test
	public void test() throws InterruptedException {
		dr.get("http://baidu.com");
		Actions action = new Actions(dr);
		Thread.sleep(1000);
		//悬停在设置上
//		action.clickAndHold(dr.findElement(By.xpath("//a[@class='pf pfhover']"))).perform();//这个为什么不行呢？
//		action.clickAndHold(dr.findElement(By.cssSelector(".pf.pfhover"))).perform();//这个为什么不行呢？
//		action.clickAndHold(dr.findElement(By.className(".pf pfhover"))).perform();//这个为什么不行呢？
//		action.clickAndHold(dr.findElement(By.xpath("//*[@id='u1']/a[8]"))).perform();
//		action.clickAndHold(dr.findElement(By.linkText("设置"))).perform();
//		action.clickAndHold(dr.findElement(By.xpath("//*[@id='u1']/a[9]"))).perform();
		dr.findElement(By.xpath("//*[@id='u1']/a[9]")).click();
		Thread.sleep(1000);
		//点击出现的高级搜索
//		action.click(dr.findElement(By.xpath("//*[@id='wrapper']/div[5]/a[2]")));
//		action.click(dr.findElement(By.xpath("//*[@id='head']/div/div[4]/div/div[2]/div[1]/div/a[2]")));
//		action.click(dr.findElement(By.linkText("图片")));
		dr.findElement(By.linkText("图片")).click();
		Thread.sleep(2000);
		System.out.println(dr.getCurrentUrl());
//		System.out.println(dr.findElement(By.xpath("//input[@id='adv_keyword']")).getAttribute("name"));
	}

}
