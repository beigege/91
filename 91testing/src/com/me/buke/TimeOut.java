package com.me.buke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TimeOut {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//���������������Ϣ
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//����10��Ԫ�صĵȴ�
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//���ҳ��10���ӻ�û�м�����ɣ��ͻᱨtimeOutException
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//�ű��첽ִ��ʱ��
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MICROSECONDS);
		//�򿪰ٶ���ҳ
		driver.get("http://www.ctrip.com");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
		}
		driver.findElement(By.className("fl_wrap_close"));
	}

}
