/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.words.pptx.xml.creator;

import com.mycompany.wrods.xml.creator.Item;
import java.io.FileInputStream;
import java.io.*;
import java.util.List;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.POIXMLProperties.*;
import org.apache.poi.xslf.usermodel.*;

/**
 *
 * @author asusadmin
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String fileName = "D:\\Tania\\PDF\\кух.приборы.pptx";
        FileInputStream inputStream = new FileInputStream(fileName);        
        XMLSlideShow ppt = new XMLSlideShow(inputStream);        
        readPPT(ppt);
    }

    public static void readPPT(XMLSlideShow ppt) throws Exception {
        TextItemProcessor textItemProcessor = new TextItemProcessor();
        
        CoreProperties props = ppt.getProperties().getCoreProperties();
        //String title = props.getTitle();
        //System.out.println("Title: " + title);

        int index = 0;
        for (XSLFSlide slide : ppt.getSlides()) {
           
            XSLFShape[] shapes = slide.getShapes();
            String text = null;
            for (XSLFShape shape : shapes) {
                if (shape instanceof XSLFTextShape) {
                    XSLFTextShape textShape = (XSLFTextShape) shape;
                    text = textShape.getText();                    
                } else if(shape instanceof XSLFPictureShape){

                    if(text==null || text.trim().isEmpty()){
                        continue;
                    }
                    XSLFPictureShape picture = (XSLFPictureShape) shape;
                    byte[] image = picture.getPictureData().getData();
                    String fileName = picture.getPictureData().getFileName();                    
                    String type = fileName.substring(fileName.indexOf("."));                    
                    try(OutputStream out = new FileOutputStream(new File("img//"+index+type))){
                        out.write(image);
                    }                    
                    index++;
                    textItemProcessor.addText(text);                    
                }
               // System.out.println("----------------------------");
            }
        }
        
        System.out.println("---------------Parsing finished---------------");
        System.setOut(new PrintStream(new File("img\\details.xml")));
        System.out.println("<details>");               
        List<Item> items = textItemProcessor.getItems();
        for(Item a: items){
            System.out.println(a);
        }
        System.out.println("</details>");
        
        
    }

}
