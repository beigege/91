package com.my.selenium;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * 
 * �������ǵĿκ���ҵ������ҳ��������Գ�����js��
1����http://www.91testing.net/����ע���˺ţ������˺ŵĿ���ֱ�ӵ�¼����ע�����֤�˺��Ƿ���ȷ������ͼ
2��ע�����˺ź��¼�ˣ�����Ҳ��ҵ�ѧϰ���ӣ����ҳ�桾����û��ͷ��ӵ��һ�����е�ͷ����ʦ��ͬѧ���ܸ����׹�ע����Ŷ���� ������á��еĵ�����ý���ͷ������
3��ͷ��������ɺ󵽸����������û�����Ϣ����������˳���¼

����ű����ϴ�ͷ�����������״�ע�������û������ͷ����û��ġ��Ѿ���ͷ���˵��˺Ų��С�
����ͷ��Ĳ�����ע���ˣ����Ҫ���棬ȡ��ע�;��� �ˡ�
 * */
public class HomeWork0807ByChromeIsok {
	public static WebDriver dr;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "tools/chromedriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		dr = new ChromeDriver(desiredCapabilities);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dr.quit();
	}

	@Test
	public void test() throws InterruptedException, IOException {
		dr.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		dr.get("http://www.91testing.net/");
		dr.manage().window().maximize();
		//��¼
		dr.findElement(By.linkText("��¼")).click();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.findElement(By.id("login_username")).sendKeys("9108002");
		dr.findElement(By.id("login_password")).sendKeys("123456");
		dr.findElement(By.xpath("//button[@type='submit']")).click();
		//��¼�����
		File srcFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		String filename = "91screenshot"+ (new Date()).getTime()+".png";
		String filepath = new File("").getAbsoluteFile()+"\\screenShot\\"+filename;
		FileUtils.copyFile(srcFile, new File(filepath));
		//��֤��¼�Ƿ�ɹ�
		String result = dr.findElement(By.xpath("//li[@class='visible-lg']//a[@href='/my']")).getText();
		assertEquals("�ҵ�ѧϰ", result.trim());
		Thread.sleep(2000);
		//����ҵ�ѧϰ
		dr.findElement(By.xpath("//li[@class='visible-lg']//a[@href='/my']")).click();
		System.out.println("����ҵ�ѧϰ======================");
		//��ȡ��ǰhandle
		String mystudy_handle = dr.getWindowHandle();
		System.out.println("mystudy_handle:"+mystudy_handle);
		//������ã������´���
		dr.findElement(By.linkText("�������")).click();
		System.out.println("�������=========================");
		//��ȡȫ��handle���л������ô���
		Set<String> handles = dr.getWindowHandles();
		for(String h: handles){
			if(!h.equals(mystudy_handle)){
				dr.switchTo().window(h);
				System.out.println("shezhi_handle:"+h);
				break;
			}
		}
		//�ϴ�ͷ��
		String picPath =new File("").getAbsoluteFile()+"\\htmlfile\\touxiang.jpg";
		System.out.println(picPath);
		Thread.sleep(5000);
//		dr.findElement(By.xpath("//input[@name='file']")).sendKeys(picPath);
		dr.findElement(By.name("file")).sendKeys(picPath);
		Thread.sleep(5000);
//		dr.findElement(By.linkText("����")).click();//��ע���ˣ����������õ�ͷ����Ϊ����ɹ��˺�����ű�������ͷ�����ھ�û��

		//���������Ϣ
//		dr.findElement(By.linkText(" ������Ϣ")).click();
		dr.findElement(By.xpath("//li[@class='list-group-item ']//a[@href='/settings/']")).click();
		Thread.sleep(1000);
		
		//��ҳ��������ϵ��ײ�
		((JavascriptExecutor)dr).executeScript("window.scrollTo(100,450);");

		//����ǩ��textarea �ı����������ݣ�
		String text = "����ǩ��";
		String js = "var sum=document.getElementById('profile_signature'); sum.value='" + text + "';";
		((JavascriptExecutor)dr).executeScript(js);
		System.out.println("�����˸���ǩ��");
//		dr.switchTo().frame(dr.findElement(By.className("cke_wysiwyg_frame cke_reset")));//���ûʶ��
		dr.switchTo().frame(dr.findElement(By.tagName("iframe")));
		System.out.println("�������ҽ���iframe");

		
		WebElement editor = dr.findElement(By.tagName("body"));
		System.out.println("ʶ����������");
	      JavascriptExecutor jsExecutor = (JavascriptExecutor) dr;
	      jsExecutor.executeScript("arguments[0].innerHTML = '���ҽ���'", editor);

		Thread.sleep(2000);
		System.out.println("���������ҽ���");
		
		//Ҫ����iframe�����ܲ������水ť
		dr.switchTo().defaultContent();
		dr.findElement(By.xpath("//button[@id='profile-save-btn']")).click();
		Thread.sleep(2000);
		
		//�˳���¼
		WebElement logout=dr.findElement(By.xpath("//img[@class='avatar-xs']"));
		Actions action = new Actions(dr);
//		action.moveToElement(logout);//�������������
		action.clickAndHold(logout).perform();
		System.out.println("׼���˳�");
		Thread.sleep(2000);
		dr.findElement(By.linkText("�˳���¼")).click();
		Thread.sleep(2000);
		System.out.println("�˳��ɹ�");

		
	}

}
