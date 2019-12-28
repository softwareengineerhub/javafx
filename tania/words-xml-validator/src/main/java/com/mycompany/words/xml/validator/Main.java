/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.words.xml.validator;

import com.backend.api.model.details.Details;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        System.setProperty("file.encoding", "UTF-8");
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        
        List<Details> detailsList = new ArrayList();
        
        parser.parse(new File("C:\\Users\\asusadmin\\Desktop\\details.xml"), new DefaultHandler(){
                
                Details details = null;
                private String currentTag;
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    currentTag = qName;
                    if("detail".equalsIgnoreCase(currentTag)){
                        details = new Details();
                    }
                }
                
                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String value = new String(ch, start, length);
                    if(!value.trim().isEmpty()){
                        if("ch".equalsIgnoreCase(currentTag)){
                            details.setDescriptionA(value);
                        }
                        if("ch.meta".equalsIgnoreCase(currentTag)){
                            details.setDescriptionB(value);
                        }
                        if("en".equalsIgnoreCase(currentTag)){
                            details.setDescriptionC(value);
                        }
                        if("ru".equalsIgnoreCase(currentTag)){
                            details.setDescriptionD(value);
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if("detail".equalsIgnoreCase(qName)){
                       // System.out.println("#############HERE");
                        detailsList.add(details);
                    }
                }
                
                

                
                
                
            });
        
        System.out.println(detailsList.size());
    }
    
}
