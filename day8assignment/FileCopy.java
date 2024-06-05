package com.ey.day8assignment;

import java.io.*;

public class FileCopy {
	public static void copyFile(File source,File destination) throws IOException {
		try(InputStream in = new FileInputStream(source);
			OutputStream out = new FileOutputStream(destination)) {
			
			byte[] buffer = new byte[1024];
			int length;
			while((length=in.read(buffer))>0)
				out.write(buffer,0,length);
		}
	}
	
	public static void main(String[] args) {
		if(args.length!=2) {
			System.out.println("Usage: java Filecopy <source_file> <destination_file>");
			return;
		}
		String sourceFilePath = args[0];
		String destinationFilePath = args[1];
		
		File sourceFile = new File(sourceFilePath);
		File destinationFile = new File(destinationFilePath);
		
		try {
			if(!sourceFile.exists())
				throw new FileNotFoundException("Exception : Source file not found");
			if(destinationFile.exists()) {
				System.out.println("Destination file already exist. Do you want to override? (Yes/No)");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String userInput = reader.readLine().toLowerCase();
				
				if(!userInput.equals("yes")) {
					System.out.println("File copy operation aborted");
					return ;
				}
			}
			copyFile(sourceFile,destinationFile);
			System.out.println("File copied successfully");
		}
		catch (IOException e) {
			System.out.println("An error occured "+e.getMessage());
		}
	}
}
