/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.external.category;

import com.backend.api.model.category.Category;
import com.backend.api.model.version.VersionAmountData;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DbxUserFilesRequests;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import javax.xml.parsers.ParserConfigurationException;
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
public class CategoryPersistenceXmlImpl implements CategoryPersistence {

    private String ACCESS_TOKEN = System.getProperty("ACCESS_TOKEN");
    private VersionAmountData version = new VersionAmountData();

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList();
        try {
            DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
            DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

            DbxUserFilesRequests files = client.files();
            ListFolderResult list = files.listFolder("/categories");
            List<Metadata> resList = list.getEntries();
            Category category = null;
            String name = null;
            String xml = loadXml(client);
            System.out.println(xml);
            Map<String, Map<String, String>> dataMap = parseXmlData(xml);
            System.out.println(dataMap.keySet());
            System.out.println(dataMap.values());
            for (Metadata metadata : resList) {
                name = metadata.getName();
                String filePath = String.format("/categories/%s", name);
                if (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")) {
                    category = new Category();
                    String categoryName = name.substring(0, name.lastIndexOf("."));
                    category.setName(categoryName);

                    DbxDownloader<FileMetadata> dl = client.files().download(filePath);
                    try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                        dl.download(out);
                        byte[] data = out.toByteArray();
                        category.setImageData(data);
                    }
                    String key = categoryName.substring(1, categoryName.length());
                        
                  //  System.out.println("key="+key);
                    
                    
                    if(dataMap.get(key)==null){
                        continue;
                    }
                    
                   // System.out.println(dataMap.get(key));
                    
                    
                    String descriptionA = dataMap.get(key).get("ch.meta");
                    String descriptionB = dataMap.get(key).get("ch");
                    String descriptionC = dataMap.get(key).get("en");
                    String descriptionD = dataMap.get(key).get("ru");

                    category.setDescriptionA(descriptionA);
                    category.setDescriptionB(descriptionB);
                    category.setDescriptionC(descriptionC);
                    category.setDescriptionD(descriptionD);

                    categories.add(category);
                    
                }

            }
            return categories;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public VersionAmountData version() {
        return version;
    }

    private Map<String, Map<String, String>> parseXmlData(String xml) throws Exception {
        Map<String, Map<String, String>> map = new HashMap<>();
        try (InputStream in = new ByteArrayInputStream(xml.getBytes())) {            
            Reader reader = new InputStreamReader(in, "UTF-8");
            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");
            
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(is, new DefaultHandler() {
                
                String prevTag = "";
                String currentTag = "";
                String id = "";
                
                String ch = "";
                String chmeta = "";
                String en = "";
                String ru = "";
                
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    prevTag = currentTag;
                    currentTag = qName;

                    if(currentTag.equalsIgnoreCase("categories")){
                        version.setVersion(Integer.parseInt(attributes.getValue("version")+""));
                    }

                    if(currentTag.equalsIgnoreCase("category")){
                        id = attributes.getValue("id");
                        map.put(id, new HashMap<>());                        
                    }


                    
                }
                
                
                @Override
                public void characters(char[] charData, int start, int length) throws SAXException {
                    String value = new String(charData, start, length);
                    if(!value.trim().isEmpty()){
                        if("ch".equalsIgnoreCase(currentTag)){
                            ch = value;
                        }
                        if("ch.meta".equalsIgnoreCase(currentTag)){
                            chmeta = value;
                        }
                        if("en".equalsIgnoreCase(currentTag)){
                            en = value;
                        }
                        if("ru".equalsIgnoreCase(currentTag)){
                            ru=value;
                        }                        
                    }
                }

                
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if("category".equalsIgnoreCase(qName)){
                       // System.out.println("ch="+ch);
                        map.get(id).put("ch", ch);
                        map.get(id).put("ch.meta", chmeta);
                        map.get(id).put("en", en);
                        map.get(id).put("ru", ru);
                    }
                } 
                
                
            });
        }
        version.setAmount(map.size());
        return map;
    }

    private String loadXml(DbxClientV2 client) throws Exception {
        String filePath = "/categories/categories.xml";
        DbxDownloader<FileMetadata> dl = client.files().download(filePath);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(dl.getInputStream()))) {
            String data = in.lines().collect(Collectors.joining());
            return data;
        }
    }

}
