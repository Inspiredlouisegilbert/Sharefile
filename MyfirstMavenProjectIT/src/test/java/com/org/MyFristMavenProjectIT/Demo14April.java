package com.org.MyFristMavenProjectIT;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo14April {

	public static void main(String[] args) throws IOException {
		
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = new FileInputStream("dataConfig.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			p.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(p.getProperty("csvdir"));
		
		BufferedReader br = new BufferedReader(new FileReader(p.getProperty("csvdir"))); 
		String line;
		while ((line = br.readLine()) != null) { 
		    // use xx as separator 
		    String[] cols = line.split(";"); 
		    System.out.println("first column " + cols[0]+ " second column " + cols[1]+ " third column " + cols[2]+ " fourth column " + cols[3]); 
		    String firstColumn = cols[0];
		    String secondColumn = cols[1];  
		    String thirdColumn = cols[2];
		    String fourthColumn = cols[3];
		}
	}
}