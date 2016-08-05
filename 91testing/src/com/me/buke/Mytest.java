package com.me.buke;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Mytest {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		
		//System.setProperty("", "");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		desiredCapabilities.setCapability("databaseEnabled", true);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--mobileEmulationEnabled=true");
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 5_0_1 like Mac OS X) AppleWebKit/534.46 (KHTML, like Gecko) Mobile/9A405");
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//鼠标事件
		Actions actions = new Actions(driver);
		//键盘事件
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_5);
		driver.manage().window().fullscreen();
		//driver.manage().window().setSize(new Dimension(480, 800));
		//WebDriver driver = new ChromeDriver();
		driver.get("http://m.baidu.com");
		//driver.manage().window().maximize();
		//driver.close();
	}

}
