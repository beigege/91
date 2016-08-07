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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * 
 * �������ǵĿκ���ҵ������ҳ��������Գ�����js��
1����http://www.91testing.net/����ע���˺ţ������˺ŵĿ���ֱ�ӵ�¼����ע�����֤�˺��Ƿ���ȷ������ͼ
2��ע�����˺ź��¼�ˣ�����Ҳ��ҵ�ѧϰ���ӣ����ҳ�桾����û��ͷ��ӵ��һ�����е�ͷ����ʦ��ͬѧ���ܸ����׹�ע����Ŷ���� ������á��еĵ�����ý���ͷ������
3��ͷ��������ɺ󵽸����������û�����Ϣ����������˳���¼


�û�������ϴ���ͷ���ļ��󣬲����ֱ����ҳ�档��chrome��OK�ˣ���HomeWork0807ByChromeIsok��
 * */
public class HomeWork0806ByFirefoxNotok {
	public static WebDriver dr;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files\\Mozilla Firefox\\firefox.exe");
//		FirefoxProfile firefoxProfile = new FirefoxProfile();
		dr = new FirefoxDriver();
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
		dr.findElement(By.linkText("��¼")).click();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.findElement(By.id("login_username")).sendKeys("9108001");
		dr.findElement(By.id("login_password")).sendKeys("123456");
//		dr.findElement(By.className("btn.btn-primary.btn-lg.btn-block")).click();
		dr.findElement(By.xpath("//button[@type='submit']")).click();
		
		File srcFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		String filename = "91screenshot"+ (new Date()).getTime()+".png";
		String filepath = new File("").getAbsoluteFile()+"\\screenShot\\"+filename;
		FileUtils.copyFile(srcFile, new File(filepath));
//		System.out.println(dr.findElement(By.xpath("//li[@role='presentation']")).getAttribute("role"));

		System.out.println(dr.findElement(By.xpath("//li[@class='visible-lg']//a[@href='/my']")).getText());
		String result = dr.findElement(By.xpath("//li[@class='visible-lg']//a[@href='/my']")).getText();
		assertEquals("�ҵ�ѧϰ", result.trim());
		Thread.sleep(2000);
		dr.findElement(By.xpath("//li[@class='visible-lg']//a[@href='/my']")).click();
		System.out.println("����ҵ�ѧϰ======================");
		String mystudy_handle = dr.getWindowHandle();
		System.out.println("mystudy_handle:"+mystudy_handle);
		//û������ͷ��ʱ��������������
		dr.findElement(By.linkText("�������")).click();
		System.out.println("�������=========================");
		//���ù�ͷ��Ҫ�Ӹ������ý�ȥ
//		Actions action = new Actions(dr);
//		action.clickAndHold(dr.findElement(By.xpath("//img[@class='avatar-xs']")));
//		dr.findElement(By.linkText("��������")).click();
		Set<String> handles = dr.getWindowHandles();
		for(String h: handles){
			if(!h.equals(mystudy_handle)){
				dr.switchTo().window(h);
				System.out.println("shezhi_handle:"+h);
				break;
			}
		}
		
		String picPath =new File("").getAbsoluteFile()+"\\htmlfile\\touxiang.jpg";
		System.out.println(picPath);
//		dr.findElement(By.className("webuploader-element-invisible")).sendKeys(picPath);
//		System.out.println("�ϴ���ͷ��:"+dr.findElement(By.className("webuploader-element-invisible")).getAttribute("name"));
//		Thread.sleep(2000);
//		
//		System.out.println("��תҳ��ǰ================");
//		dr.navigate().to("http://www.91testing.net/settings/avatar/crop");
//		System.out.println("��תҳ���================");
//		dr.findElement(By.id("upload-avatar-btn")).click();
		
//		dr.findElement(By.xpath("//input[@name='file']")).sendKeys(picPath);
		Thread.sleep(5000);
		dr.findElement(By.name("file")).sendKeys(picPath);
		    Thread.sleep(5000);
		    dr.findElement(By.linkText("����")).click();
//			dr.findElement(By.xpath("//a[@class='btn btn-fat btn-primary']")).click();

		
//		dr.findElement(By.linkText(" ������Ϣ")).click();
		dr.findElement(By.xpath("//li[@class='list-group-item ']//a[@href='/settings/']")).click();
		Thread.sleep(1000);
		//����ǩ��textarea �ı����������ݣ�
		String text = "����ǩ��";
		String js = "var sum=document.getElementById('profile_signature'); sum.value='" + text + "';";
		((JavascriptExecutor)dr).executeScript(js);
		System.out.println("�����˸���ǩ��");
//		dr.switchTo().frame(dr.findElement(By.className("cke_wysiwyg_frame cke_reset")));
//		((JavascriptExecutor)dr).executeScript("document.querySelectorAll('textarea')[2].style.display='block';");
		String text1 = "���ҽ���";
		String js1 = "var sum=document.getElementById('profile_about'); sum.value='" + text1 + "';";
		((JavascriptExecutor)dr).executeScript(js1);
		System.out.println("���������ҽ���");
		Thread.sleep(1000);
		dr.findElement(By.xpath("//button[@id='profile-save-btn']")).click();
		

		
	}

}
