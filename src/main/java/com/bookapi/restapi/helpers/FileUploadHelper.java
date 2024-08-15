package com.bookapi.restapi.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String uploadDir = new ClassPathResource("/static/image").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException{
    }

    public boolean uploadFileHelper(MultipartFile file)
    {
        boolean isSuccessful = false;
        try {            
            InputStream inputStream = file.getInputStream();
            String filename = uploadDir+File.separator+file.getOriginalFilename();

            // byte data[] = new byte[inputStream.available()];
            // inputStream.read(data);
            
            // String filename = uploadDir+File.separator+file.getOriginalFilename();
            // FileOutputStream fileOutputStream = new FileOutputStream(filename);
            // fileOutputStream.flush();
            // fileOutputStream.close();


            //Better Method to upload
            Files.copy(inputStream, Paths.get(filename), StandardCopyOption.REPLACE_EXISTING);
            isSuccessful = true;
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return isSuccessful;
    } 
    
}
