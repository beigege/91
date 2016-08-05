package com.me.buke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TimeOut {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//设置浏览器驱动信息
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//设置10秒元素的等待
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//如果页面10秒钟还没有加载完成，就会报timeOutException
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//脚本异步执行时间
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MICROSECONDS);
		//打开百度首页
		driver.get("http://www.ctrip.com");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		}
		driver.findElement(By.className("fl_wrap_close"));
	}

}
