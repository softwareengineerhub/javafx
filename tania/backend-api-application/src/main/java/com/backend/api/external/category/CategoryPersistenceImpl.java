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

    private String ACCESS_TOKEN = System.getProperty("ACCESS_TOKEN");

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
            Properties props = loadProperties(client);
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

                    String descriptionA = props.getProperty(key + "ch.meta");
                    String descriptionB = props.getProperty(key + "ch");
                    String descriptionC = props.getProperty(key + "en");
                    String descriptionD = props.getProperty(key + "ru");

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
    public int version() {
        return 0;
    }

    private Properties loadProperties(DbxClientV2 client) throws Exception {
        Properties props = new Properties();
        String filePath = "/categories/categories.properties";
        DbxDownloader<FileMetadata> dl = client.files().download(filePath);
        try (InputStream in = dl.getInputStream()) {
            props.load(in);
        }
        return props;
    }

}
