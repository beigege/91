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
		//���������������Ϣ
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		driver = new ChromeDriver(desiredCapabilities);
		driver.get("http://www.baidu.com");
		System.out.println("ɾ��֮ǰ��:"+driver.manage().getCookieNamed("BIDUPSID"));
		//ɾ����Ӧ��cookie
		driver.manage().deleteCookieNamed("BIDUPSID");
		//�����Զ���cookie
		Cookie c1 = new Cookie("name", "key-aaaaaaa");
		Cookie c2 = new Cookie("value", "value-bbbbbb");
		driver.manage().addCookie(c1);
		driver.manage().addCookie(c2);
		//��ȡ���е�cookie ��ѭ����ӡ
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
