package com.my.seleniumJunit4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.http.util.Args;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class utilOperation {
	
	public static List<String[]> getUserInfo(){
		List<String []> list = new ArrayList<String []>();
 		String path = new File("").getAbsoluteFile().toString();
// 		System.out.println(new File(utilOperation.class.getName()).getAbsoluteFile().toString());
// 		System.out.println(utilOperation.class.getClass().getResource("/").getPath());
 		System.out.println(path+"\\bin\\com\\my\\seleniumJunit4\\user.properties");
		File f = new File(path+"\\bin\\com\\my\\seleniumJunit4\\user.properties");
		BufferedReader bufread;
		try {
			bufread = new BufferedReader(new FileReader(f));
			String lineTxt = null;
			
			while ((lineTxt = bufread.readLine())!=null) {
//				System.out.println(lineTxt.split(",")[0]);
//				System.out.println(lineTxt.split(",")[1]);
				list.add(lineTxt.split(","));
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public static void inputValue(WebDriver driver, By by, String value) {
		WebElement element = WaitForElement(driver, by, 5);
		element.clear();
		element.sendKeys(value);
	}

	public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public static String closeAlertAndGetItsText(WebDriver driver) {
		boolean acceptNextAlert = true;
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
	
	public static WebElement WaitForElement(WebDriver driver, By by,long time)
    {
//        WebElement targetElement = (new WebDriverWait(driver,10))
//        		.until(ExpectedConditions.presenceOfElementLocated(by));
//        return targetElement; 
        
        WebDriverWait wait = new WebDriverWait(driver, time);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by)); 
        return element;
        
    }
	public static boolean screenShot(WebDriver dr,String picname){
		File srcFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		String filename = "91screenshot"+"_"+picname+ (new Date()).getTime()+".png";
		String filepath = new File("").getAbsoluteFile()+"\\screenShot\\"+filename;
		try {
			FileUtils.copyFile(srcFile, new File(filepath));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String Args[]){
		getUserInfo();
	}
}
