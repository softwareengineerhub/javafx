/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sound.backend.api.application;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.DbxUserFilesRequests;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public class SoundPersistenceImpl implements SoundPersistence {

    private String ACCESS_TOKEN = System.getProperty("ACCESS_TOKEN");
    private DbxClientV2 client;

    public SoundPersistenceImpl() {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/backend-api").build();
        client = new DbxClientV2(config, ACCESS_TOKEN);
    }

    @Override
    public void downloadAllSounds() {
        try {
            DbxUserFilesRequests files = client.files();
            ListFolderResult list = files.listFolder("/Sound");
            List<Metadata> resList = list.getEntries();
            for (Metadata meta : resList) {
                String categoryName = meta.getName();
                downloadCategorySound(categoryName);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void downloadCategorySound(String categoryName) throws Exception {
        DbxUserFilesRequests files = client.files();
        ListFolderResult list = files.listFolder("/Sound/" + categoryName);
        List<Metadata> resList = list.getEntries();
        for (Metadata meta : resList) {
            String detailsName = meta.getName();
            downloadDetailsSound(categoryName, detailsName);
        }
    }

    private void downloadDetailsSound(String categoryName, String detailsName) throws Exception {
       
        //System.out.println(tmpDir);
        String tmpDir = System.getProperty("java.io.tmpdir");
        DbxUserFilesRequests files = client.files();
        ListFolderResult list = files.listFolder("/Sound/" + categoryName + "/" + detailsName);
        List<Metadata> resList = list.getEntries();
        for (Metadata meta : resList) {
            String languageName = meta.getName();
            String filePath = "/Sound/" + categoryName + "/" + detailsName + "/" + languageName;
            String fileName = tmpDir+File.separator+categoryName+detailsName + languageName;
            //System.out.println(filePath);
            downloadSound(filePath, fileName);        
        }
    }
    
    
    private void downloadSound(String filePath, String fileName) throws Exception {         
            DbxDownloader<FileMetadata> dl = client.files().download(filePath);
            File file = new File(fileName);
            System.out.println(file);
            try (OutputStream out = new FileOutputStream(file)) {
                dl.download(out);
            }            
    }
   
}
