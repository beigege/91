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
 * 今天我们的课后作业（关于页面操作可以尝试用js）
1、在http://www.91testing.net/进行注册账号（已有账号的可以直接登录）。注册后验证账号是否正确，并截图
2、注册新账号后登录了，点击右侧我的学习链接，点击页面【您还没有头像。拥有一个独有的头像，老师和同学们能更容易关注到你哦～～ 点击设置】中的点击设置进行头像设置
3、头像设置完成后到个人中心设置基础信息，保存后点击退出登录


用火狐，在上传完头像文件后，不出现保存的页面。换chrome就OK了，见HomeWork0807ByChromeIsok。
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
		dr.findElement(By.linkText("登录")).click();
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
		assertEquals("我的学习", result.trim());
		Thread.sleep(2000);
		dr.findElement(By.xpath("//li[@class='visible-lg']//a[@href='/my']")).click();
		System.out.println("点击我的学习======================");
		String mystudy_handle = dr.getWindowHandle();
		System.out.println("mystudy_handle:"+mystudy_handle);
		//没有设置头像时，会出现这个链接
		dr.findElement(By.linkText("点击设置")).click();
		System.out.println("点击设置=========================");
		//设置过头像，要从个人设置进去
//		Actions action = new Actions(dr);
//		action.clickAndHold(dr.findElement(By.xpath("//img[@class='avatar-xs']")));
//		dr.findElement(By.linkText("个人设置")).click();
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
//		System.out.println("上传新头像:"+dr.findElement(By.className("webuploader-element-invisible")).getAttribute("name"));
//		Thread.sleep(2000);
//		
//		System.out.println("跳转页面前================");
//		dr.navigate().to("http://www.91testing.net/settings/avatar/crop");
//		System.out.println("跳转页面后================");
//		dr.findElement(By.id("upload-avatar-btn")).click();
		
//		dr.findElement(By.xpath("//input[@name='file']")).sendKeys(picPath);
		Thread.sleep(5000);
		dr.findElement(By.name("file")).sendKeys(picPath);
		    Thread.sleep(5000);
		    dr.findElement(By.linkText("保存")).click();
//			dr.findElement(By.xpath("//a[@class='btn btn-fat btn-primary']")).click();

		
//		dr.findElement(By.linkText(" 基础信息")).click();
		dr.findElement(By.xpath("//li[@class='list-group-item ']//a[@href='/settings/']")).click();
		Thread.sleep(1000);
		//个性签名textarea 文本框输入内容：
		String text = "个性签名";
		String js = "var sum=document.getElementById('profile_signature'); sum.value='" + text + "';";
		((JavascriptExecutor)dr).executeScript(js);
		System.out.println("输入了个性签名");
//		dr.switchTo().frame(dr.findElement(By.className("cke_wysiwyg_frame cke_reset")));
//		((JavascriptExecutor)dr).executeScript("document.querySelectorAll('textarea')[2].style.display='block';");
		String text1 = "自我介绍";
		String js1 = "var sum=document.getElementById('profile_about'); sum.value='" + text1 + "';";
		((JavascriptExecutor)dr).executeScript(js1);
		System.out.println("输入了自我介绍");
		Thread.sleep(1000);
		dr.findElement(By.xpath("//button[@id='profile-save-btn']")).click();
		

		
	}

}
