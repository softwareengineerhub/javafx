/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.external.category;

import com.backend.api.model.category.Category;
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
public class CategoryPersistenceImpl implements CategoryPersistence {

    private String ACCESS_TOKEN = "BmYGyrUTeYAAAAAAAAAAEiHo_KrNZyuze9wsUyYei0EJKYMc-c9mdhC3abTmTzJr";

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList();
        try {
            DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
            DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
            DbxUserFilesRequests files = client.files();
            ListFolderResult list = files.listFolder("");
            List<Metadata> resList = list.getEntries();
            Category category = null;
            String name = null;
            for (Metadata metadata : resList) {
                name = metadata.getName();
                category = new Category();
                category.setName(name);
                makeCall(category, client);
                categories.add(category);
            }
            return categories;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    private void makeCall(Category category, DbxClientV2 client) throws Exception {
        DbxUserFilesRequests files = client.files();
        ListFolderResult list = files.listFolder("/"+category.getName());
        List<Metadata> resList = list.getEntries();
        for (Metadata metadata : resList) {
            String name = metadata.getName();           
            if (name.endsWith(".properties")) {
                DbxDownloader<FileMetadata> dl = client.files().download("/"+category.getName() + "/" + name);
                Properties props = new Properties();
                try (InputStream in = dl.getInputStream()) {
                    props.load(in);
                }
                category.setDescriptionA(props.getProperty("en"));
                category.setDescriptionB(props.getProperty("ch"));
                category.setDescriptionC(props.getProperty("ru"));
                continue;
            }
            
            if (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")) {
                DbxDownloader<FileMetadata> dl = client.files().download("/"+category.getName() + "/" + name);                
                try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    dl.download(out);
                    byte[] data = out.toByteArray();
                    category.setImage(data);
                }
                continue;
            }
        }
    }

}
