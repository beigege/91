package com.me.buke;

import java.sql.Driver;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Cookies {
	public static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//设置浏览器驱动信息
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		driver = new ChromeDriver(desiredCapabilities);
		driver.get("http://www.baidu.com");
		System.out.println("删除之前的:"+driver.manage().getCookieNamed("BIDUPSID"));
		//删除对应的cookie
		driver.manage().deleteCookieNamed("BIDUPSID");
		//新增自定义cookie
		Cookie c1 = new Cookie("name", "key-aaaaaaa");
		Cookie c2 = new Cookie("value", "value-bbbbbb");
		driver.manage().addCookie(c1);
		driver.manage().addCookie(c2);
		//获取所有的cookie ，循环打印
		Set<Cookie> cookies = driver.manage().getCookies();
		
		for(Cookie cooky:cookies){
			System.out.println(cooky);
		}
		
	}
	
	public static String getText(String locate){
		locate = "";
		String value = "";
		value = driver.findElement(By.id("")).getText();
		return value;
	}

}
