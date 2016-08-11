package com.my.loggerTest;

import java.io.File;
import java.io.IOException;

public class fileOperator {
	
	public static void mkFile(String filePath){
		File file=new File(filePath);//"C:\\Users\\QPING\\Desktop\\JavaScript\\2.htm"    
		if(!file.exists())    
		{    
		    try {    
		        file.createNewFile();    
		    } catch (IOException e) {    
		        // TODO Auto-generated catch block    
		        e.printStackTrace();    
		    }    
		} 
	}
	public static void mkDirectory(String directoryPath) {
		System.out.println(directoryPath);
		File file =new File(directoryPath);//"C:\\Users\\QPING\\Desktop\\JavaScript"    
		//如果文件夹不存在则创建   
		if  (!file.exists()  && !file.isDirectory())      
		{       
		    System.out.println("//不存在");  
		    file.mkdir();    
		} else   
		{  
		    System.out.println("//目录存在");  
		}
	}

	public static void main(String[] args) {
		
	}

}
