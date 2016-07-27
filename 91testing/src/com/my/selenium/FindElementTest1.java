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

public class FindElementTest1 {
	public static WebDriver dr;
	@BeforeClass
	public static void setup(){
		System.out.println("@BeforeClass**********************");
		dr = new FirefoxDriver();
	}

	@Test
	public void test_by_id() {
		
		dr.get("http://baidu.com");
		WebElement text = dr.findElement(By.id("kw"));
		assertEquals("kw",text.getAttribute("id"));
	}
	@Test
	public void test_by_name() {
		
		dr.get("http://baidu.com");
		WebElement text = dr.findElement(By.name("wd"));
		assertEquals("wd",text.getAttribute("name"));
	}
	@Test
	public void test_by_className() {
		
		dr.get("http://baidu.com");
		WebElement text = dr.findElement(By.className("s_ipt"));
		assertEquals("s_ipt",text.getAttribute("className"));
	}
	@Test
	public void test_by_linkText() {
		
		dr.get("http://baidu.com");
		WebElement text = dr.findElement(By.linkText("Ŵ��"));
		System.out.println(text.getText());
		assertEquals("Ŵ��",text.getText());
	}
	@Test
	public void test_by_partialLinkText() {
		
		dr.get("http://baidu.com");
		WebElement text = dr.findElement(By.partialLinkText("Ŵ"));
		System.out.println(text.getText());
		assertEquals("Ŵ��",text.getText());
	}
	@Test
	public void test_by_xpath() {
		
		dr.get("http://baidu.com");
		//xpath��//��ǩ��[@����='����ֵ']
		WebElement text = dr.findElement(By.xpath("//input[@value='�ٶ�һ��']"));
		System.out.println(text.getAttribute("value"));
		assertEquals("�ٶ�һ��",text.getAttribute("value"));
		//��ǩ����*����ָ����ǩ��
		System.out.println(dr.findElement(By.xpath("//*[@type='submit']")).getAttribute("value"));
		//����Ψһ��λ����ǩ�����ӱ�ǩ
		System.out.println(dr.findElement(By.xpath("//span[@class='bg s_btn_wr']/input")).getAttribute("type"));
		//���ö��������������λ��ǩ
		System.out.println(dr.findElement(By.xpath("//*[@type='submit' and @class='bg s_btn']")).getAttribute("class"));
		//����chrome/firebug��õ�xpath�ǣ�//*[@id="su"]��ʹ��ʱҪ��˫���š�����������
		System.out.println(dr.findElement(By.xpath("//*[@id='su']")).getAttribute("class"));
		System.out.println(dr.findElement(By.xpath(".//*[@id='kw']")).getAttribute("class"));

	}
	
	@Test
	public void test_by_cssSelector() throws InterruptedException {
		
		dr.get("http://baidu.com");
		Thread.sleep(1000);
		////����class����.bg s_btn�������Ҫ�ѿո�ĳɵ�.
		WebElement text = dr.findElement(By.cssSelector(".bg.s_btn"));
		//����ID
//		WebElement text = dr.findElement(By.cssSelector("#su"));
		//����class
//		WebElement text = dr.findElement(By.cssSelector(".s_ipt"));
		System.out.println(text.getAttribute("value"));
		assertEquals("�ٶ�һ��",text.getAttribute("value"));
		//���ݱ�ǩ���ң�����Ļ��������һ��
		System.out.println(dr.findElement(By.cssSelector("input")).getAttribute("name"));
		//����������
		System.out.println(dr.findElement(By.cssSelector("input[name='f']")).getAttribute("name"));
		//���ݸ���ǩ�����ӱ�ǩ������Ļ��������һ��
		System.out.println(dr.findElement(By.cssSelector("span[class='bg s_btn_wr'] > input")).getAttribute("class"));
		//�� �Ϸ�ʽ��class����ֵ���пո���.�滻
		System.out.println(dr.findElement(By.cssSelector("span.bg.s_btn_wr > input")).getAttribute("class"));
	}
	@Test
	public void test_setWindowSize() throws InterruptedException{
		//���óߴ��С
		dr.manage().window().setSize(new Dimension(400, 500));
		//maximize()����ʹ�򿪵������ȫ����ʾ
		dr.manage().window().maximize();
		dr.get("http://baidu.com");
		System.out.println("window size:"+dr.manage().window().getSize());
		Thread.sleep(3000);
	}
	@Test
	public void test_forward_back_refresh() throws InterruptedException{
		dr.get("http://baidu.com");
		System.out.println("first title:"+dr.getTitle());
		dr.findElement(By.id("kw")).sendKeys("java");
		dr.findElement(By.id("su")).click();
		Thread.sleep(1000);
		System.out.println("second title:"+dr.getTitle());
		dr.navigate().back();
		System.out.println("third title:"+dr.getTitle());
		dr.navigate().forward();
		System.out.println("fouth title:"+dr.getTitle());
		dr.navigate().refresh();
		
	}
	@Test
	public void test_clear() throws InterruptedException{
		dr.get("http://baidu.com");
		WebElement text = dr.findElement(By.id("kw"));
		text.sendKeys("java");
		Thread.sleep(2000);
		text.clear();
		Thread.sleep(2000);
		text.sendKeys("haha");
		Thread.sleep(2000);
		
	}
	@Test
	public void test_submit() throws InterruptedException{
		dr.get("http://baidu.com");
		WebElement text = dr.findElement(By.id("kw"));
		text.sendKeys("java");
		Thread.sleep(1000);
		text.submit();
		Thread.sleep(2000);
		
	}
	@AfterClass
	public static void tearDown(){
		System.out.println("@AfterClass**********************");
		dr.close();
	}

}
