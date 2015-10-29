package org.ponaszki;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileParser {
	
	public ArrayList<HashMap<String, String>> readFile(String path){
		ArrayList<HashMap<String, String>> parsedData = new ArrayList<HashMap<String,String>>();
		try {
	        File fileDir = new File(path);

	        BufferedReader in = new BufferedReader(
	           new InputStreamReader(
	                      new FileInputStream(fileDir), "UTF8"));

	        String str;

	        while ((str = in.readLine()) != null) {
	            System.out.println(str);
	            HashMap<String, String> operation = parseLine(str);
	            System.out.println("op size" + operation.size());
	            parsedData.add(operation);
	            System.out.println("pd size" + parsedData.size());
	        }
	        
	        in.close();
	        return parsedData;
			} 
	        catch (UnsupportedEncodingException e) 
	        {
	            System.out.println(e.getMessage());
	        } 
	        catch (IOException e) 
	        {
	            System.out.println(e.getMessage());
	        }
	        catch (Exception e)
	        {
	            System.out.println(e.getMessage());
	        }
		return parsedData;
	}
	
	private HashMap<String, String> parseLine(String line){
		HashMap<String, String> lineMap = new HashMap<String, String>();
		int index = 0;
		while(index>=0){
			int firstAt = line.indexOf("@", index); 
			index = firstAt+1;
			int secondAt = line.indexOf("@", index);
			index = secondAt;
			String elem;
			if(index!=-1){
				elem = line.substring(firstAt+1, secondAt);	
			}else{
				elem = line.substring(firstAt+1);
			}
			
			int colon = elem.indexOf(":");
			String key = elem.substring(0, colon);
			String v,v2;
			if(key.equals("amount")){
				v = elem.substring(colon+1, elem.length()-3);
				v2 =v.replace(",", ".");
				lineMap.put(key, v2);
				
			}else{
				v = elem.substring(colon+1);
				lineMap.put(key, v);
			}
			
//			System.out.println("Elem" + elem);
		}
		return lineMap;
	}
}
