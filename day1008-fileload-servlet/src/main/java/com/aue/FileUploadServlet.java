package com.aue;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/fileUploadServlet")
@MultipartConfig(
        location = "",
        maxFileSize = -1L,
        maxRequestSize = -1L,
        fileSizeThreshold = 0
)
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part avatar = req.getPart("avatar");
        String url = req.getServletContext().getRealPath("image");
        File file = new File(url);
        if (!file.exists()) {
            file.mkdirs();
        }
        avatar.write(url + File.separator + avatar.getSubmittedFileName());
        System.out.println("file name:" + avatar.getSubmittedFileName());
        System.out.println("description:" + req.getParameter("description"));
    }
}
