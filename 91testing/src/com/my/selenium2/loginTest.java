package com.my.selenium2;

import static org.junit.Assert.*;

import org.junit.Test;

public class loginTest extends testBase{

	@Test
	public void login() {
		driver.get("http://www.91testing.net/");
	}

}
