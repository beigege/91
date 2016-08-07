package com.me.buke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FileUpload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//设置浏览器驱动信息
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//打开上传页面
		driver.get("file:///C:/Users/Administrator/Desktop/upload.html");
		//通过Sendkeys来传递文件路径
		driver.findElement(By.name("file")).sendKeys("D:\\upload_file.txt");
	}

}
