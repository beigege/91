package com.me.buke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GetText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���������������Ϣ
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//�򿪰ٶ���ҳ
		driver.get("http://www.baidu.com");
		System.out.println("��ǰ��title:"+driver.getTitle());
		//��ȡtitle
		String title = driver.getTitle();
		if(title.equals("�ٶ�һ�£����֪��")){
			System.out.println("��ǰ��title:"+driver.getTitle()+"����֤ͨ��");
		}else{
			System.out.println("��ǰ��title:"+driver.getTitle()+"����֤��ͨ��");
		}
		System.out.println("��ǰ��URL:"+driver.getCurrentUrl());
		System.out.println("Ԥ��ֵ:"+driver.findElement(By.id("setf")).getText());

	}

}
