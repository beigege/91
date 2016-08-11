package com.my.seleniumJunit4;

import static org.junit.Assert.*;

import org.junit.Test;

public class runOrderTestNAME_ASCENDING {

	@Test
	public void a1_test() {
		System.out.println("junt4用例执行顺序测试，按方法名首字母顺序执行：1");
	}
	@Test
	public void a2_test() {
		System.out.println("junt4用例执行顺序测试，按方法名首字母顺序执行：2");
	}
	@Test
	public void test() {
		System.out.println("junt4用例执行顺序测试，按方法名首字母顺序执行：3");
	}

}
