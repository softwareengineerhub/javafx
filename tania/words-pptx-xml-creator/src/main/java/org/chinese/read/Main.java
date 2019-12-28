/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chinese.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperties());
        InputStream in = new FileInputStream(new File("C:\\Users\\asusadmin\\Desktop\\template_out.xml"));
        byte[] data = new byte[in.available()];
        in.read(data);
        //String content = new String(data, "ISO8859-1");
        String content = new String(data, "UTF-8");
        System.out.println(content);
    }
    
}
