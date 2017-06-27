package com.samples.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtils {
	
	public static File getFile (String pathname) {
		File file = new File(pathname);
		return file.exists() ? file : null;
	}
	
	public static boolean isFileExists(String pathname) {
		File file = new File(pathname);
		return file.exists();
	}
	
	
	public static boolean isDirectory (String pathname) {
		File file = new File(pathname);
		return file.isDirectory();
	}
	
	public static void printLines(String pathname) throws IOException {
		File file = new File(pathname);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		
		reader.close();
	}
	
	public static BufferedReader getByteReader(String filePath) throws FileNotFoundException {		
		FileInputStream fileInputStream = new FileInputStream(new File(filePath));
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
		return reader;		
	}
	
	public static BufferedReader getCharReader(String filePath) throws FileNotFoundException {		
		BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
		return reader;
	}	
}
