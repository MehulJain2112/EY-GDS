package com.ey.day8assignment;

import java.io.File;

public class FolderDisplay {
	public static void displayFolders(File folder,String indent) {
		System.out.println(indent+"+--"+folder.getName());
		
		File[] files = folder.listFiles();
		
		if(files!=null) {
			for(File file:files) {
				if(file.isDirectory())
					displayFolders(file,indent + "   ");
			}
		}
	}
	
	public static void main(String[] args) {
		String folderPath = "C:\\Users\\BX756RJ\\eclipse-workspace\\JavaPractise\\src";
		File folder = new File(folderPath);
		
		if(folder.exists() && folder.isDirectory())
			displayFolders(folder,"");
		else
			System.out.println("The provided path is not a valid directory");
		
	}
}
