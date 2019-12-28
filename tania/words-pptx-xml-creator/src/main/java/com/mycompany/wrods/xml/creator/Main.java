/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wrods.xml.creator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\asusadmin\\Desktop\\template.txt");
        //byte[] data = Files.readAllBytes(file.toPath());
        //String content = new String(data);
        List<Item> list = new ArrayList();        
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = null;
        Item item = new Item();
        int index = 0;
        while((line=bufferedReader.readLine())!=null){
            if(line.trim().isEmpty()){
                item.setId(list.size());
                list.add(item);
                item = new Item();
                index = 0;
            } else {
                switch(index){
                    case 0:
                        item.setCh(line);
                        break;
                    case 1:
                        item.setChMeta(line);
                        break;    
                    case 2:
                        item.setEn(line);
                        break;    
                    case 3:
                        item.setUa(line);
                        break;                        
                }
                index++;
            }
        }
        System.out.println("---------------Parsing finished---------------");
        System.setOut(new PrintStream(new File("C:\\Users\\asusadmin\\Desktop\\template_out.xml")));
        System.out.println("<details>");               
        for(Item a: list){
            System.out.println(a);
        }
        System.out.println("</details>");
        
    }
    
}
