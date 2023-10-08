package com.aue.controller;


import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@MultipartConfig
public class FileLoad {

    @PostMapping("fileUploadServlet")
    public String fileLoad(@RequestPart MultipartFile avatar, @RequestParam String description, HttpSession httpSession) throws IOException {
        String path = httpSession.getServletContext().getRealPath("image");
        String fileName = avatar.getOriginalFilename();
        File file = new File(path);
        String finalPath = path + File.separator + fileName;
        if(!file.exists()){
            boolean isDirExist = file.mkdirs();
            if(isDirExist){
                avatar.transferTo(new File(finalPath));
            }
        }
        System.out.println("description" + description);
        return "/image/" + fileName;
    }
}
