package com.me.buke;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//���������������Ϣ
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		WebDriver driver = new ChromeDriver(desiredCapabilities);
		driver.get("http://www.baidu.com");
		String baiduHandle = driver.getWindowHandle();
		System.out.println("�ٶȾ��:"+baiduHandle);
		driver.findElement(By.linkText("��¼")).click();
		//�ȴ�3�룬�ȴ���¼�򵯳�
		Thread.sleep(3000);
		//������ע������
		driver.findElement(By.linkText("����ע��")).click();
//		driver.switchTo().window("ע��ٶ��ʺ�");
//		//��ȡ���д򿪴��ڵľ��
		Set<String> handls = driver.getWindowHandles();
		
		//ѭ����ӡ��ȡ�ľ��
		for(String currentHandle:handls){
			System.out.println("forHandles:"+currentHandle);
		}
		//��forѭ����ͨ���ͰٶȾ�����бȽϣ�������ǰٶȾ���������ҳ���л�
		int i = 1;
		for(String currentHandle:handls){
			//��N�λ�õľ��
			System.out.println("ѭ����"+i+"�λ�õľ��:"+currentHandle);
			i++;
			if(!currentHandle.equals(baiduHandle)){
				System.out.println("�ٶ�ע����:"+currentHandle);
				driver.switchTo().window(currentHandle);
			}
		}
		//�ڰٶ�ע��ҳ�������ֻ���
		driver.findElement(By.id("TANGRAM__PSP_4__phone")).sendKeys("13000000012");
		
	}

}
