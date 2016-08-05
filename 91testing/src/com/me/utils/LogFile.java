package com.me.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author mggao
 *
 */
public class LogFile {

	/**
	 * 
	 */
	final public static Map<String, String> readConfig() {
		BufferedReader input = null;
		Map<String, String> map = new HashMap<String, String>();
		String text = null;
		FileInputStream file = null;

		try {
			file = new FileInputStream( "config.ini");
			input = new BufferedReader(new InputStreamReader(file, "UTF-8"));
			while ((text = input.readLine()) != null) {
				if (text.length() >= 1 && text.substring(0, 1).equals("#")) {
					continue;
				}
				int number = text.indexOf("=");
				if (number != -1) {
					map.put(text.substring(0, number), text.substring(number + 1, text.length()));
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException ioException) {
			System.err.println("File Error!");
			ioException.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

}
