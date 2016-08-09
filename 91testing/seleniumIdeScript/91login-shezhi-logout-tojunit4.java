package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class 91loginShezhiLogoutTojunit4 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.91testing.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test91loginShezhiLogoutTojunit4() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("li.hidden-xs > a")).click();
    driver.findElement(By.id("login_username")).clear();
    driver.findElement(By.id("login_username")).sendKeys("9108001");
    driver.findElement(By.id("login_password")).clear();
    driver.findElement(By.id("login_password")).sendKeys("123456");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("个人设置")).click();
    driver.findElement(By.linkText("头像设置")).click();
    driver.findElement(By.linkText("基础信息")).click();
    driver.findElement(By.id("profile_signature")).clear();
    driver.findElement(By.id("profile_signature")).sendKeys("个人签名");
    driver.findElement(By.id("profile_truename")).clear();
    driver.findElement(By.id("profile_truename")).sendKeys("姓名零零一");
    driver.findElement(By.id("profile-save-btn")).click();
    driver.findElement(By.linkText("退出登录")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
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
}
