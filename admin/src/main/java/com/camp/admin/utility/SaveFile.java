package com.camp.admin.utility;

import java.io.FileOutputStream;
import org.springframework.web.multipart.MultipartFile;

public class SaveFile {								
	public static void saveFile(MultipartFile mf, String imagesdir) {
		byte [] data;
		String imgname = mf.getOriginalFilename();
		try {
			data = mf.getBytes();
			FileOutputStream fo = 
					new FileOutputStream(imagesdir+imgname);
			fo.write(data);
			fo.close();
		}catch(Exception e) {
			
		}
		
	}
	
}




