package com.my;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest1 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://baidu.com");
		driver.findElement(By.id("kw")).sendKeys("java");
		driver.findElement(By.id("su")).click();
		System.out.println(driver.getTitle());
//		try {
//			driver.wait(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("wait");
//		driver.findElement(By.className("t c-gap-bottom-small op-soft-title")).click();;
		driver.findElement(By.className("t c-gap-bottom-small op-soft-title")).click();
		driver.close();
	} 

}
