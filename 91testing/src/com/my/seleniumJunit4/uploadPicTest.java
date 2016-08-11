package com.my.seleniumJunit4;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;

@RunWith(Parameterized.class)
public class uploadPicTest extends testBase {
	private String username;
	private String pwd;
	
	@Parameters
	public static Collection getUserinfo(){
		return utilOperation.getUserInfo();
	}
	
	public uploadPicTest(String username,String pwd) {
		this.username = username;
		this.pwd = pwd;
	}

	@Test
	public void test() {
		login_logout.login(driver, username, pwd);
		
		login_logout.logout(driver,By.xpath("//img[@class='avatar-xs']"));
	}

}
