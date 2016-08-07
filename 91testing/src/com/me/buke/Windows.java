package com.me.buke;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//设置浏览器驱动信息
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		driver.get("http://www.baidu.com");
		String baiduHandle = driver.getWindowHandle();
		System.out.println("百度句柄:"+baiduHandle);
		driver.findElement(By.linkText("登录")).click();
		//等待3秒，等待登录框弹出
		Thread.sleep(3000);
		//点立即注册链接
		driver.findElement(By.linkText("立即注册")).click();
//		driver.switchTo().window("注册百度帐号");
//		//获取所有打开窗口的句柄
		Set<String> handls = driver.getWindowHandles();
		
		//循环打印获取的句柄
		for(String currentHandle:handls){
			System.out.println("forHandles:"+currentHandle);
		}
		//在for循环中通过和百度句柄进行比较，如果不是百度句柄，则进行页面切换
		int i = 1;
		for(String currentHandle:handls){
			//第N次获得的句柄
			System.out.println("循环第"+i+"次获得的句柄:"+currentHandle);
			i++;
			if(!currentHandle.equals(baiduHandle)){
				System.out.println("百度注册句柄:"+currentHandle);
				driver.switchTo().window(currentHandle);
			}
		}
		//在百度注册页面输入手机号
		driver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("13000000012");
		
	}

}
