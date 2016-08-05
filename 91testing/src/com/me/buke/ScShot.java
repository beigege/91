package com.me.buke;

import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ScShot {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//设置浏览器驱动信息
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//打开百度首页
		driver.get("http://www.baidu.com");
		//输入关键字，查找
		((JavascriptExecutor)driver).executeScript("document.getElementById('kw').value='衣服';");
		//点击查询
		driver.findElement(By.id("su")).click();
		Thread.sleep(2000);//等待2秒
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File("d:\\ccc.png"));
		driver.quit();
		
	}

}
