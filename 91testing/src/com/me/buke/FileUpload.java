package com.me.buke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FileUpload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���������������Ϣ
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//���ϴ�ҳ��
		driver.get("file:///C:/Users/Administrator/Desktop/upload.html");
		//ͨ��Sendkeys�������ļ�·��
		driver.findElement(By.name("file")).sendKeys("D:\\upload_file.txt");
	}

}
