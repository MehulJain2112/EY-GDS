package com.ey.day8assignment;

import java.io.File;

public class FileSearch {
	public static 	File searchFile(File directory,String fileName) {
		File[] files = directory.listFiles();
		
		if(files!=null) {
			for(File file:files) {
				if(file.isDirectory()) {
					File result = searchFile(file,fileName);
					if(result!=null)
						return result;
				}
				else if(file.getName().equals(fileName))
					return file;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		String directoryPath = "C:\\Users\\BX756RJ\\eclipse-workspace\\JavaPractise\\src";
		String fileName = "Product.java";
		
		File directory = new File(directoryPath);
		if(directory.exists() && directory.isDirectory()) {
			File result = searchFile(directory,fileName);
			if(result!=null)
				System.out.println("File found at : "+result.getAbsolutePath());
			else 
				System.out.println("File not found");
		}
		else
			System.out.println("The provided path is not a valid directory");
	}
}
