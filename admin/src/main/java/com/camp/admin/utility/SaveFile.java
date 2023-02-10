package com.camp.admin.utility;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class SaveFile {								
	public static void saveFile(MultipartFile mf, String imagesdir,String Filename) {
		byte [] data;
		try {
			data = mf.getBytes();
			FileOutputStream fo = 
					new FileOutputStream(imagesdir+Filename);
			fo.write(data);
			fo.close();
		}catch(Exception e) {
			
		}
	}
	
	public static void deleteFile(String imagesdir,String image_file) {
		
		File file = new File(imagesdir+image_file);
		if(file.exists()) { 
			file.delete(); 	
		}
		
	}
	
	
	
}




