package com.me.buke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GetText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//设置浏览器驱动信息
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//打开百度首页
		driver.get("http://www.baidu.com");
		System.out.println("当前的title:"+driver.getTitle());
		//获取title
		String title = driver.getTitle();
		if(title.equals("百度一下，你就知道")){
			System.out.println("当前的title:"+driver.getTitle()+"，验证通过");
		}else{
			System.out.println("当前的title:"+driver.getTitle()+"，验证不通过");
		}
		System.out.println("当前的URL:"+driver.getCurrentUrl());
		System.out.println("预期值:"+driver.findElement(By.id("setf")).getText());

	}

}
