package com.me.buke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Dialog {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//设置浏览器驱动信息
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//访问百度首页
		driver.get("http://www.baidu.com");
		//通过鼠标事件来实现菜单弹出
		Actions actions = new Actions(driver);
		actions.clickAndHold(driver.findElement(By.linkText("设置")));
		//鼠标移动到目标元素
		//actions.moveToElement(driver.findElement(By.linkText("设置")));
		actions.perform();
		//通过点击方式，弹出菜单
//		driver.findElement(By.linkText("设置")).click();
		//打开搜索设置
		driver.findElement(By.className("setpref")).click();
		//点击保存
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='prefpanelgo']")).click();
		//输出弹出框的内容
		System.out.println("弹出框内容:"+driver.switchTo().alert().getText());
		//点击确定按钮
		driver.switchTo().alert().accept();
	}

}
