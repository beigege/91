package com.me.buke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FindElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//设置浏览器驱动信息
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//打开一个站点
		driver.get("file:///C:/Users/Administrator/Desktop/demo.html");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@des='abc']")));
		driver.findElement(By.id("kw")).sendKeys("aaa");
		//获取页面pages的li列表个数
//		List<WebElement> liList = driver.findElements(By.xpath("//ul[@class='wiki-pages']/li/a"));
//		System.out.println("li的数量："+liList.size());
////		liList.get(0).click();
//		int i = 0;

	}

}
