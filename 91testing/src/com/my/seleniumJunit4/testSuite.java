package com.my.seleniumJunit4;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	loginTest_para_from_file.class,
	runOrderTest.class
})
public class testSuite {

}
