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
		WebElement text = dr.findElement(By.linkText("糯米"));
		System.out.println(text.getText());
		assertEquals("糯米",text.getText());
	}
	@Test
	public void test_by_partialLinkText() {
		
		dr.get("http://baidu.com");
		WebElement text = dr.findElement(By.partialLinkText("糯"));
		System.out.println(text.getText());
		assertEquals("糯米",text.getText());
	}
	@Test
	public void test_by_xpath() {
		
		dr.get("http://baidu.com");
		//xpath：//标签名[@属性='属性值']
		WebElement text = dr.findElement(By.xpath("//input[@value='百度一下']"));
		System.out.println(text.getAttribute("value"));
		assertEquals("百度一下",text.getAttribute("value"));
		//标签名是*，不指定标签名
		System.out.println(dr.findElement(By.xpath("//*[@type='submit']")).getAttribute("value"));
		//利用唯一定位父标签来找子标签
		System.out.println(dr.findElement(By.xpath("//span[@class='bg s_btn_wr']/input")).getAttribute("type"));
		//利用多个属性条件来定位标签
		System.out.println(dr.findElement(By.xpath("//*[@type='submit' and @class='bg s_btn']")).getAttribute("class"));
		//利用chrome/firebug获得的xpath是：//*[@id="su"]。使用时要把双引号——》单引号
		System.out.println(dr.findElement(By.xpath("//*[@id='su']")).getAttribute("class"));
		System.out.println(dr.findElement(By.xpath(".//*[@id='kw']")).getAttribute("class"));

	}
	
	@Test
	public void test_by_cssSelector() throws InterruptedException {
		
		dr.get("http://baidu.com");
		Thread.sleep(1000);
		////根据class，用.bg s_btn这个报错，要把空格改成点.
		WebElement text = dr.findElement(By.cssSelector(".bg.s_btn"));
		//根据ID
//		WebElement text = dr.findElement(By.cssSelector("#su"));
		//根据class
//		WebElement text = dr.findElement(By.cssSelector(".s_ipt"));
		System.out.println(text.getAttribute("value"));
		assertEquals("百度一下",text.getAttribute("value"));
		//根据标签名找，多个的话，输出第一个
		System.out.println(dr.findElement(By.cssSelector("input")).getAttribute("name"));
		//根据属性找
		System.out.println(dr.findElement(By.cssSelector("input[name='f']")).getAttribute("name"));
		//根据父标签名找子标签，多个的话，输出第一个
		System.out.println(dr.findElement(By.cssSelector("span[class='bg s_btn_wr'] > input")).getAttribute("class"));
		//组 合方式，class属性值中有空格用.替换
		System.out.println(dr.findElement(By.cssSelector("span.bg.s_btn_wr > input")).getAttribute("class"));
	}
	@Test
	public void test_setWindowSize() throws InterruptedException{
		//设置尺寸大小
		dr.manage().window().setSize(new Dimension(400, 500));
		//maximize()方法使打开的浏览器全屏显示
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
