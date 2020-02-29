/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.external.details;

import com.backend.api.model.details.Details;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DbxUserFilesRequests;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author asusadmin
 */
public class DetailsPersistenceXmlImpl implements DetailsPersistence {

    private String ACCESS_TOKEN = System.getProperty("ACCESS_TOKEN");
    private DbxClientV2 client;

    public DetailsPersistenceXmlImpl() {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/backend-api").build();
        client = new DbxClientV2(config, ACCESS_TOKEN);
    }

    private String loadXml(DbxClientV2 client, String categoryName) throws Exception {
        String filePath = "/Details/" + categoryName + "/details.xml";
        DbxDownloader<FileMetadata> dl = client.files().download(filePath);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(dl.getInputStream()))) {
            String data = in.lines().collect(Collectors.joining());
            return data;
        }
    }
    
    @Override
    public List<Details> findAllDetails(String categoryName) {
        try {
            List<Details> allDetails = findAllDetailsDescription(categoryName);
            
            DbxUserFilesRequests files = client.files();
            ListFolderResult list = files.listFolder("/Details/"+categoryName);
            List<Metadata> resList = list.getEntries();
        //    Details details = null;
            String name = null;            
            
            
            for (Metadata metadata : resList) {
                name = metadata.getName();
                String filePath = String.format("/Details/%s/%s", categoryName, name);
                if (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")) {
                    //details = new Details();
                    String detailsName = name.substring(0, name.lastIndexOf("."));
                    //details.setName(detailsName);
                    byte[] data = null;
                    DbxDownloader<FileMetadata> dl = client.files().download(filePath);
                    try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                        dl.download(out);
                        data = out.toByteArray();
                        //details.setImageData(data);
                    }
                    
                    
                    String key = name.substring(0, name.lastIndexOf("."));
                    
                    //System.out.println("!!!!!!!!!"+categoryName+"="+key);
                    int i = Integer.parseInt(key);
                    if(i>=allDetails.size()){
                        continue;
                    }
                    Details current = allDetails.get(i);
                    current.setName(detailsName);
                    current.setImageData(data);
                    
                    
                   // System.out.println("key="+key);

                  
                  
                }

            }
            
            
            
            
            
            
            
            
            /*for (Metadata metadata : resList) {
                name = metadata.getName();                
                details = new Details();
                details.setName(name);
                makeSubCall(categoryName, details, client);
                details.setSoundA(null);
                details.setSoundB(null);
                details.setSoundC(null);
                detailsList.add(details);
            }*/
            return allDetails;
        } catch (Exception ex) {
            System.out.println("Error: "+categoryName);
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    private List<Details> findAllDetailsDescription(String categoryName) {
        List<Details> detailsList = new ArrayList();
        try {
            String xml = loadXml(client, categoryName);

           try(InputStream in = new ByteArrayInputStream(xml.getBytes())){
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            
            
            Reader reader = new InputStreamReader(in, "UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");
            
            
            parser.parse(is, new DefaultHandler(){
                
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
            
            
           // System.out.println("#############details: "+detailsList.size());
            
            
            return detailsList;
           }
        } catch (Exception ex) {
            System.out.println("Error: " + categoryName);
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Details findDetailsByName(String categoryName, String name) {
        Details details = new Details();
        return details;
    }

}
