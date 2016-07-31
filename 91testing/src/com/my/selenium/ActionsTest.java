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
		System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		dr = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		dr.close();
	}

	@Test
	public void test_shezhi() throws InterruptedException {
		dr.get("http://baidu.com");
		Actions action = new Actions(dr);
		Thread.sleep(1000);
		//��ͣ��������pf pfhover��//*[@id="u1"]/a[8]
//		action.clickAndHold(dr.findElement(By.xpath("//a[@class='pf']"))).perform();//���Ϊʲô�����أ�
//		action.clickAndHold(dr.findElement(By.xpath("//a[@class='pf pfhover']"))).perform();
//		action.clickAndHold(dr.findElement(By.cssSelector(".pf.pfhover"))).perform();//���Ϊʲô�����أ�
//		action.clickAndHold(dr.findElement(By.className(".pf pfhover"))).perform();//���Ϊʲô�����أ�
//		action.clickAndHold(dr.findElement(By.xpath("//*[@id='u1']/a[8]"))).perform();
		action.clickAndHold(dr.findElement(By.linkText("����"))).perform();
//		dr.findElement(By.xpath("//a[@class='pf']")).click();
		System.out.println("shezhi");
		Thread.sleep(1000);
		//������ֵĸ߼�����/html/body/div[3]/div[5]/a[2]��//*[@id="wrapper"]/div[5]/a[2]
		action.click(dr.findElement(By.xpath("//*[@id='wrapper']/div[5]/a[2]")));
//		action.click(dr.findElement(By.xpath("//*[@id='head']/div/div[4]/div/div[2]/div[1]/div/a[2]")));
		
		Thread.sleep(2000);
		System.out.println(dr.getCurrentUrl());
//		System.out.println(dr.findElement(By.xpath("//input[@id='adv_keyword']")).getAttribute("name"));
	}
	@Test
	public void test_morepicture() throws InterruptedException {
		dr.get("http://baidu.com");
		Actions action = new Actions(dr);
		Thread.sleep(1000);
		//��ͣ�ڸ����Ʒ
//		action.clickAndHold(dr.findElement(By.xpath("//*[@id='u1']/a[9]"))).perform();
		dr.findElement(By.xpath("//*[@id='u1']/a[9]")).click();
		Thread.sleep(1000);
		//������ֵ�ͼƬ
		action.click(dr.findElement(By.linkText("ͼƬ")));
//		dr.findElement(By.linkText("ͼƬ")).click();
		Thread.sleep(2000);
		System.out.println(dr.getCurrentUrl());
//		System.out.println(dr.findElement(By.xpath("//input[@id='adv_keyword']")).getAttribute("name"));
	}

}
