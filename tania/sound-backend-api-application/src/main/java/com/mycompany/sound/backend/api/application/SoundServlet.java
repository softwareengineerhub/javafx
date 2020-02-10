/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sound.backend.api.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asusadmin
 */
@WebServlet(name = "SoundServlet", urlPatterns = {"/sound"})
public class SoundServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("category");
        String detailsName = req.getParameter("details");
        String language = req.getParameter("language");
        byte[] sound = getSound(categoryName, detailsName, language);
        if(sound==null){
            sound = getSound("c2", "d0", "ru");
        }
        //resp.setContentType("application/mp3");
        resp.setContentType("video/mp4");
        try (OutputStream out = resp.getOutputStream()) {
            out.write(sound);
        }
    }

    private byte[] getSound(String categoryName, String detailsName, String language) throws IOException {
        String tmpDir = System.getProperty("java.io.tmpdir");
        String fileName = tmpDir+File.separator+categoryName+detailsName + language+".mp3";        
        try (InputStream in = new FileInputStream(fileName)) {
            byte[] data = new byte[in.available()];
            in.read(data);
            return data;
        }catch(Exception ex){
            return null;
        }
    }

}
