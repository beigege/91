package com.me.buke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FindElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���������������Ϣ
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//��һ��վ��
		driver.get("file:///C:/Users/Administrator/Desktop/demo.html");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@des='abc']")));
		driver.findElement(By.id("kw")).sendKeys("aaa");
		//��ȡҳ��pages��li�б����
//		List<WebElement> liList = driver.findElements(By.xpath("//ul[@class='wiki-pages']/li/a"));
//		System.out.println("li��������"+liList.size());
////		liList.get(0).click();
//		int i = 0;

	}

}
