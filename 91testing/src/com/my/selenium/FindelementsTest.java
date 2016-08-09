package com.my.selenium;

import java.io.File;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindelementsTest {

	private static WebDriver dr;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		dr = new FirefoxDriver();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		dr.quit();
	}

	
	@Test
	public void test_findCHekbox() throws InterruptedException {
//		File file = new File("E:/jase/checkbox.html");
//		String filePath = file.getAbsolutePath();
//		driver.get(filePath);
		
		File directory = new File("");// 设定为当前文件夹
		try {
			System.out.println(directory.getCanonicalPath());// 获取标准的路径
			System.out.println(directory.getAbsolutePath());// 获取绝对路径

			dr.get(directory.getCanonicalPath() + "\\htmlfile\\checkbox.html");
			List<WebElement> checkboxs=dr.findElements(By.tagName("input"));
			for(int i =0 ;i<checkboxs.size();i++){
				System.out.println(checkboxs.get(i).getAttribute("id"));
				if(checkboxs.get(i).getAttribute("type").equals("checkbox")){
					checkboxs.get(i).click();

				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
