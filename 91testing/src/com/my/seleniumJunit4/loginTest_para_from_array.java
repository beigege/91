package com.my.seleniumJunit4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


@RunWith(Parameterized.class) 
public class loginTest_para_from_array extends testBase {
	
	private String username;
	private String pwd;
	
	@Parameters
	public static Collection prepareData(){
		
		Object[][] o = {{"9108","7905886"},{"9108001","123456"}};  
        return Arrays.asList(o); 
	}
	
	public loginTest_para_from_array(String username,String pwd){
		this.username = username;
		this.pwd = pwd;
	}

	@Test
	public void login() {
		driver.get("http://www.91testing.net/");

		utilOperation.WaitForElement(driver, By.linkText("登录"), 6).click();
		utilOperation.inputValue(driver, By.id("login_username"), username);
		utilOperation.inputValue(driver, By.id("login_password"), pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		utilOperation.screenShot(driver, "login");
		// 验证登录是否成功
		String result = driver.findElement(By.xpath("//li[@class='visible-lg']//a[@href='/my']")).getText();
		assertEquals("我的学习", result.trim());
		logout(driver,By.xpath("//img[@class='avatar-xs']"));
	}
	
	public void  logout(WebDriver driver,By by) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(utilOperation.WaitForElement(driver, by, 5)).perform();
		utilOperation.WaitForElement(driver, By.linkText("退出登录"), 5).click();;
		
	}

}
