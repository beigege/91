package com.my.seleniumJunit4;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class login_logout {
	public static String login(WebDriver driver,String username,String pwd) {
		driver.get("http://www.91testing.net/");

		utilOperation.WaitForElement(driver, By.linkText("登录"), 6).click();
		utilOperation.inputValue(driver, By.id("login_username"), username);
		utilOperation.inputValue(driver, By.id("login_password"), pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		utilOperation.screenShot(driver, "login");
		// 验证登录是否成功
		String result = driver.findElement(By.xpath("//li[@class='visible-lg']//a[@href='/my']")).getText();
		return result;
	}
	
	public static void  logout(WebDriver driver,By by) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(utilOperation.WaitForElement(driver, by, 5)).perform();
		utilOperation.WaitForElement(driver, By.linkText("退出登录"), 5).click();;
		
	}
}
