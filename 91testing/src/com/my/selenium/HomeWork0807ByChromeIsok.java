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
 * 今天我们的课后作业（关于页面操作可以尝试用js）
1、在http://www.91testing.net/进行注册账号（已有账号的可以直接登录）。注册后验证账号是否正确，并截图
2、注册新账号后登录了，点击右侧我的学习链接，点击页面【您还没有头像。拥有一个独有的头像，老师和同学们能更容易关注到你哦～～ 点击设置】中的点击设置进行头像设置
3、头像设置完成后到个人中心设置基础信息，保存后点击退出登录

这个脚本的上传头像入口是针对首次注册或者是没有设置头像的用户的。已经有头像了的账号不行。
保存头像的操作呗注释了，如果要保存，取消注释就行 了。
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
		//登录
		dr.findElement(By.linkText("登录")).click();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.findElement(By.id("login_username")).sendKeys("9108002");
		dr.findElement(By.id("login_password")).sendKeys("123456");
		dr.findElement(By.xpath("//button[@type='submit']")).click();
		//登录后截屏
		File srcFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		String filename = "91screenshot"+ (new Date()).getTime()+".png";
		String filepath = new File("").getAbsoluteFile()+"\\screenShot\\"+filename;
		FileUtils.copyFile(srcFile, new File(filepath));
		//验证登录是否成功
		String result = dr.findElement(By.xpath("//li[@class='visible-lg']//a[@href='/my']")).getText();
		assertEquals("我的学习", result.trim());
		Thread.sleep(2000);
		//点击我的学习
		dr.findElement(By.xpath("//li[@class='visible-lg']//a[@href='/my']")).click();
		System.out.println("点击我的学习======================");
		//获取当前handle
		String mystudy_handle = dr.getWindowHandle();
		System.out.println("mystudy_handle:"+mystudy_handle);
		//点击设置，弹出新窗口
		dr.findElement(By.linkText("点击设置")).click();
		System.out.println("点击设置=========================");
		//获取全部handle，切换到设置窗口
		Set<String> handles = dr.getWindowHandles();
		for(String h: handles){
			if(!h.equals(mystudy_handle)){
				dr.switchTo().window(h);
				System.out.println("shezhi_handle:"+h);
				break;
			}
		}
		//上传头像
		String picPath =new File("").getAbsoluteFile()+"\\htmlfile\\touxiang.jpg";
		System.out.println(picPath);
		Thread.sleep(5000);
//		dr.findElement(By.xpath("//input[@name='file']")).sendKeys(picPath);
		dr.findElement(By.name("file")).sendKeys(picPath);
		Thread.sleep(5000);
//		dr.findElement(By.linkText("保存")).click();//先注释了，不保存设置的头像。因为保存成功了后，这个脚本的设置头像的入口就没了

		//点击基础信息
//		dr.findElement(By.linkText(" 基础信息")).click();
		dr.findElement(By.xpath("//li[@class='list-group-item ']//a[@href='/settings/']")).click();
		Thread.sleep(1000);
		
		//将页面滚动条拖到底部
		((JavascriptExecutor)dr).executeScript("window.scrollTo(100,450);");

		//个性签名textarea 文本框输入内容：
		String text = "个性签名";
		String js = "var sum=document.getElementById('profile_signature'); sum.value='" + text + "';";
		((JavascriptExecutor)dr).executeScript(js);
		System.out.println("输入了个性签名");
//		dr.switchTo().frame(dr.findElement(By.className("cke_wysiwyg_frame cke_reset")));//这个没识别
		dr.switchTo().frame(dr.findElement(By.tagName("iframe")));
		System.out.println("进入自我介绍iframe");

		
		WebElement editor = dr.findElement(By.tagName("body"));
		System.out.println("识别第三方插件");
	      JavascriptExecutor jsExecutor = (JavascriptExecutor) dr;
	      jsExecutor.executeScript("arguments[0].innerHTML = '自我介绍'", editor);

		Thread.sleep(2000);
		System.out.println("输入了自我介绍");
		
		//要跳出iframe，才能操作保存按钮
		dr.switchTo().defaultContent();
		dr.findElement(By.xpath("//button[@id='profile-save-btn']")).click();
		Thread.sleep(2000);
		
		//退出登录
		WebElement logout=dr.findElement(By.xpath("//img[@class='avatar-xs']"));
		Actions action = new Actions(dr);
//		action.moveToElement(logout);//这个方法好像不行
		action.clickAndHold(logout).perform();
		System.out.println("准备退出");
		Thread.sleep(2000);
		dr.findElement(By.linkText("退出登录")).click();
		Thread.sleep(2000);
		System.out.println("退出成功");

		
	}

}
