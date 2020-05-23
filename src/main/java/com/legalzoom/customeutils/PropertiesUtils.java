package com.legalzoom.customeutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
	public static Properties pro = new Properties();

	public static String getLocator(String locatorName) {
		String value = "";

		try {
			String basepath = System.getProperty("user.dir");
			FileInputStream fin = new FileInputStream(basepath + "\\src\\main\\resources\\ObjectRepository.properties");
			pro.load(fin);
			value = (String) pro.get(locatorName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("File not Found");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Unable to load Properties File");
			e.printStackTrace();
		}
		return value;

	}

}
