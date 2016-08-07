package com.me.buke;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapaTest {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		//设置chrome路径
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		//浏览器属性设置
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		//chrome浏览器参数设置
		ChromeOptions chromeOptions = new ChromeOptions();
		//chrome启动的最大化
		chromeOptions.addArguments("--start-maximized");
		//设置手机模拟器
		chromeOptions.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 5_0_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Mobile/9A405");
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		driver.navigate().refresh();
		driver.get("http://www.baidu.com");
		//driver.manage().window().maximize();

	}

}
