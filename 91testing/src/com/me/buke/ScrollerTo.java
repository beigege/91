package com.me.buke;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ScrollerTo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//���������������Ϣ
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//���ʰٶ���ҳ
		driver.get("http://www.baidu.com");
		//����ؼ��ֲ�ѯ
		//driver.findElement(By.id("kw")).sendKeys("�·�");
		((JavascriptExecutor)driver).executeScript("document.getElementById('kw').value='�·�';");
		//�����ѯ
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);
		//ִ��js����
		((JavascriptExecutor)driver).executeScript("window.scrollTo(100,450);");
	}

}
