package com.org.MyFristMavenProjectIT;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class DemoCsvTest {
	
	@Test
	public void testCSV() throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("C:\\tmp\\creditCard.csv")); 
		String line;
		while ((line = br.readLine()) != null) { 
		    // use xx as separator 
		    String[] cols = line.split(";"); 
		    System.out.println(cols[0]); 
		    //pCardNumber = cols[0];
		}
	}
}
