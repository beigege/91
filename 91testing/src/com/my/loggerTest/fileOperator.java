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
		//����ļ��в������򴴽�   
		if  (!file.exists()  && !file.isDirectory())      
		{       
		    System.out.println("//������");  
		    file.mkdir();    
		} else   
		{  
		    System.out.println("//Ŀ¼����");  
		}
	}

	public static void main(String[] args) {
		
	}

}
