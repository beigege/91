package com.my.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.org.apache.bcel.internal.ExceptionConstants;

public class WaitTest {
	static WebDriver dr;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		dr = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dr.quit();
	}

	@Test
	public void test_manulDefine() {
		dr.get("http://baidu.com");
		int i;
		for(i=0;i<10;i++){
			System.out.println(i);
			if(iselementExist(dr,By.id("kw"))){
				break;
			}
		}
		if(i>=10){
			System.out.println("time out!");
		}
		
	}
	@Test
	public void test_xianshiwait(){
		dr.get("http://baidu.com");
		WebDriverWait wait = new WebDriverWait(dr,10,1);
		wait.until(new ExpectedCondition<WebElement>() {

			@Override
			public WebElement apply(WebDriver arg0) {
				
				return arg0.findElement(By.id("kw"));
			}
		}).sendKeys("wait");
		
	}
	
	public boolean iselementExist(WebDriver dr, By by){
		boolean flag = false;
		try{
			dr.findElement(by);
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
	}

}
