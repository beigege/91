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

public class TngTest3 {

  @Test()
  public void g3() {
	  System.out.println("TngTest3-testcase-g3++++++++++++");
  }
  @Test()
  public void h3() {
	  System.out.println("TngTest3-testcase-h3++++++++++++");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("TngTest3-beforeMethod++++++++++++");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("TngTest3-beforeMethod++++++++++++");
  }


 
  @BeforeClass
  public void beforeClass() {
	  System.out.println("TngTest3-beforeClass++++++++++++");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("TngTest3-afterClass++++++++++++");
  }

//  @BeforeTest
//  public void beforeTest() {
//	  System.out.println("TngTest3-beforeTest++++++++++++");
//  }
//
//  @AfterTest
//  public void afterTest() {
//	  System.out.println("TngTest3-afterTest++++++++++++");
//  }

 


}
