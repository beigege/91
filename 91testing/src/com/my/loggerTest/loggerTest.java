package com.my.loggerTest;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class loggerTest {
	
	public void logger1() throws SecurityException, IOException {
		Logger log = Logger.getLogger("lavasoft"); 
        log.setLevel(Level.INFO); 
        Logger log1 = Logger.getLogger("lavasoft"); 
        System.out.println(log==log1);     //true 
        Logger log2 = Logger.getLogger("lavasoft.blog"); 
//        log2.setLevel(Level.WARNING); 

        ConsoleHandler consoleHandler =new ConsoleHandler(); 
        consoleHandler.setLevel(Level.ALL); 
        log.addHandler(consoleHandler); 
        File file = new File("");
        String logpath = file.getAbsolutePath();
        String directoryPath=logpath+"\\logfile";
        fileOperator.mkDirectory(directoryPath);
        FileHandler fileHandler = new FileHandler(directoryPath+"\\testlog%g.log"); 
        fileHandler.setLevel(Level.INFO); 
        fileHandler.setFormatter(new SimpleFormatter());
        log.addHandler(fileHandler); 
        log.info("aaa1"); 
        log2.info("bbb1"); 
        log2.fine("fine"); 
	}

	public static void main(String[] args) throws SecurityException, IOException {

		new loggerTest().logger1();
	}

}
