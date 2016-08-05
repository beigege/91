package com.me.buke;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ScrollerTo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//设置浏览器驱动信息
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//访问百度首页
		driver.get("http://www.baidu.com");
		//输入关键字查询
		//driver.findElement(By.id("kw")).sendKeys("衣服");
		((JavascriptExecutor)driver).executeScript("document.getElementById('kw').value='衣服';");
		//点击查询
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		//执行js操作
		((JavascriptExecutor)driver).executeScript("window.scrollTo(100,450);");
	}

}
