package com.my.seleniumJunit4;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class runOrderTest {

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
