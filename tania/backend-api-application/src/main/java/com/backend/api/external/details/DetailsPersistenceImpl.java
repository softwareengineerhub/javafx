/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.external.details;

import com.backend.api.model.category.Category;
import com.backend.api.model.details.Details;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DbxUserFilesRequests;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Denys.Prokopiuk
 */
public class DetailsPersistenceImpl implements DetailsPersistence {

    private String ACCESS_TOKEN = System.getProperty("ACCESS_TOKEN");
    private DbxClientV2 client;

    public DetailsPersistenceImpl() {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/backend-api").build();
        client = new DbxClientV2(config, ACCESS_TOKEN);
    }

    private Properties loadProperties(DbxClientV2 client, String categoryName) throws Exception {
        Properties props = new Properties();
        String filePath = "/Details/"+categoryName+"/details.properties";
        DbxDownloader<FileMetadata> dl = client.files().download(filePath);
        try (InputStream in = dl.getInputStream()) {
            props.load(in);
        }
        return props;
    }
    
    

    @Override
    public List<Details> findAllDetails(String categoryName) {
        List<Details> detailsList = new ArrayList();
        try {
            Properties props = loadProperties(client, categoryName);
            
            
            DbxUserFilesRequests files = client.files();
            ListFolderResult list = files.listFolder("/Details/"+categoryName);
            List<Metadata> resList = list.getEntries();
            Details details = null;
            String name = null;            
            
            
            for (Metadata metadata : resList) {
                name = metadata.getName();
                String filePath = String.format("/Details/%s/%s", categoryName, name);
                if (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")) {
                    details = new Details();
                    String detailsName = name.substring(0, name.lastIndexOf("."));
                    details.setName(detailsName);

                    DbxDownloader<FileMetadata> dl = client.files().download(filePath);
                    try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                        dl.download(out);
                        byte[] data = out.toByteArray();
                        details.setImageData(data);
                    }
                    String key = name.substring(0, name.lastIndexOf("."));
                   // System.out.println("key="+key);

                    String descriptionA = props.getProperty("ch"+key+".meta");
                    String descriptionB = props.getProperty("ch"+key);
                    String descriptionC = props.getProperty("en"+key);
                    String descriptionD = props.getProperty("ru"+key);

                    details.setDescriptionA(descriptionA);
                    details.setDescriptionB(descriptionB);
                    details.setDescriptionC(descriptionC);
                    details.setDescriptionD(descriptionD);
                    detailsList.add(details);
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
            return detailsList;
        } catch (Exception ex) {
            System.out.println("Error: "+categoryName);
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Details findDetailsByName(String categoryName, String name) {
        Details details = new Details();
      /*  details.setName(name);
        try {

            makeSubCall(categoryName, details, client);
            return details;
        } catch (Exception ex) {
            ex.printStackTrace();
            return details;
        }*/
      return details;
    }


}
