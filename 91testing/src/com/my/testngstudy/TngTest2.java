package com.my.testngstudy;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TngTest2 {
  @Test()
  public void f2() {
	  System.out.println("TngTest2-testcase-f2++++++++++++");
  }
  
  @Test()
  public void g2() {
	  System.out.println("TngTest2-testcase-g2++++++++++++");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("TngTest2-beforeMethod++++++++++++");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("TngTest2-beforeMethod++++++++++++");
  }


//  @BeforeClass
//  public void beforeClass() {
//	  System.out.println("TngTest2-beforeClass++++++++++++");
//  }
//
//  @AfterClass
//  public void afterClass() {
//	  System.out.println("TngTest2-afterClass++++++++++++");
//  }
//
//  @BeforeTest
//  public void beforeTest() {
//	  System.out.println("TngTest2-beforeTest++++++++++++");
//  }
//
//  @AfterTest
//  public void afterTest() {
//	  System.out.println("TngTest2-afterTest++++++++++++");
//  }
//
//  @BeforeSuite
//  public void beforeSuite() {
//	  System.out.println("TngTest2-beforeSuite++++++++++++");
//  }
//
//  @AfterSuite
//  public void afterSuite() {
//	  System.out.println("TngTest2-afterSuite++++++++++++");
//  }

}
