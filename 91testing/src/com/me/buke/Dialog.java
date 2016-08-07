package com.me.buke;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Dialog {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//���������������Ϣ
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		//���ʰٶ���ҳ
		driver.get("http://www.baidu.com");
		//ͨ������¼���ʵ�ֲ˵�����
		Actions actions = new Actions(driver);
		actions.clickAndHold(driver.findElement(By.linkText("����")));
		//����ƶ���Ŀ��Ԫ��
		//actions.moveToElement(driver.findElement(By.linkText("����")));
		actions.perform();
		//ͨ�������ʽ�������˵�
//		driver.findElement(By.linkText("����")).click();
		//����������
		driver.findElement(By.className("setpref")).click();
		//�������
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='prefpanelgo']")).click();
		//��������������
		System.out.println("����������:"+driver.switchTo().alert().getText());
		//���ȷ����ť
		driver.switchTo().alert().accept();
	}

}
