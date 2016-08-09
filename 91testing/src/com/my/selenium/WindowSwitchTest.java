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
		//֮ǰ����www.163.comҳ�������������Ҫ��֤��www.sina.com.cnҳ���ϵĶ�����

	dr.get("http://www.163.com/");
	//��ת��ҳ��
	dr.navigate().to("http://www.sina.com.cn");
	//���Ҫ�ص�֮ǰ��ҳ�������
	dr.navigate().to("http://www.163.com/");
//	���� 
//	dr.navigate().back();

	}



}
