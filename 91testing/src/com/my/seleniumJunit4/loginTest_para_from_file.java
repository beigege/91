package com.my.seleniumJunit4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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
public class loginTest_para_from_file extends testBase {
	
	private String username;
	private String pwd;
	
	@Parameters
	public static Collection prepareData(){
		
		return utilOperation.getUserInfo();
	}
	
	public loginTest_para_from_file(String username,String pwd){
		this.username = username;
		this.pwd = pwd;
	}

	@Test
	public void login() {
		
		String result = login_logout.login(driver, username, pwd);
		assertEquals("ÎÒµÄÑ§Ï°", result.trim());
		login_logout.logout(driver,By.xpath("//img[@class='avatar-xs']"));
	}
	


}
