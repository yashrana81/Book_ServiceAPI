package com.bookapi.restapi.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookapi.restapi.helpers.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/uploadFile")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file){

        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());

        try {
            if(file.isEmpty())
        {
            return ResponseEntity.internalServerError().body("File can't be empty");
        }

        if(!file.getContentType().equals("image/png") || file.getContentType().equals("image/jpeg"))
        {
            return ResponseEntity.internalServerError().body("file should be of image type");
        }

        boolean uploadStatus = fileUploadHelper.uploadFileHelper(file);
        if(uploadStatus) return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return ResponseEntity.internalServerError().body("something went wrong");
        
    }
}
