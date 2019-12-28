/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wordsdescriptionfilecopyhelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    private static String filePath = "C:\\Users\\asusadmin\\Desktop\\folder";
    
    public static void main(String[] args) throws Exception {
        m(new File("C:\\Users\\asusadmin\\Documents\\NetBeansProjects\\Words\\WordsApp\\src\\main\\resources\\details2\\c14"));
    }
    
    private static void m(File root) throws Exception{         
        File[] files = root.listFiles();
        if(files!=null){
            for(File f: files){
                m2(f);   
            }                        
        }
    }
    
    private static void m2(File root) throws Exception {
        System.out.println("m2.root="+root);
        String itemName=root.getName();
        itemName = itemName.replaceAll("Details", "");
        System.out.println("itemName="+itemName );
        //String id = itemName.substring(0, itemName.lastIndexOf("."));
        
        File[] files = root.listFiles();
        if(files!=null){
            for(File f: files){                
                String name = f.getName();                
                String mask = name.substring(name.lastIndexOf("."), name.length());
                System.out.println("mask="+mask);
                if(name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")){
                    try(OutputStream out = new FileOutputStream(new File(filePath, itemName+mask));
                            InputStream in = new FileInputStream(f)){
                        byte[] data = new byte[in.available()];
                        in.read(data);
                        out.write(data);
                    }
                }
            }
        }
    }
    
}
