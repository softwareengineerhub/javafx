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
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class DetailsPersistenceImpl implements DetailsPersistence {

    private String ACCESS_TOKEN = "BmYGyrUTeYAAAAAAAAAAEiHo_KrNZyuze9wsUyYei0EJKYMc-c9mdhC3abTmTzJr";
    private DbxClientV2 client;

    public DetailsPersistenceImpl() {
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/backend-api").build();
        client = new DbxClientV2(config, ACCESS_TOKEN);
    }

    @Override
    public List<Details> findAllDetails(String categoryName) {
        List<Details> detailsList = new ArrayList();
        try {
            DbxUserFilesRequests files = client.files();
            ListFolderResult list = files.listFolder("/"+categoryName+"/details");
            List<Metadata> resList = list.getEntries();
            Details details = null;
            String name = null;            
            for (Metadata metadata : resList) {
                name = metadata.getName();                
                details = new Details();
                details.setName(name);
                makeSubCall(categoryName, details, client);
                detailsList.add(details);
            }
            return detailsList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Details findDetailsByName(String categoryName, String name) {
        Details details = new Details();
        details.setName(name);
        try {

            makeSubCall(categoryName, details, client);
            return details;
        } catch (Exception ex) {
            ex.printStackTrace();
            return details;
        }
    }

    private void makeSubCall(String categoryName, Details details, DbxClientV2 client) throws Exception {
        DbxUserFilesRequests files = client.files();
        ListFolderResult list = files.listFolder("/"+categoryName + "/details/" + details.getName());
        List<Metadata> resList = list.getEntries();
        for (Metadata metadata : resList) {
            String name = metadata.getName();
            if (name.endsWith(".mp3")) {
                DbxDownloader<FileMetadata> dl = client.files().download("/"+categoryName + "/details/" + details.getName() + "/" + name);
                try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    dl.download(out);
                    byte[] data = out.toByteArray();
                    if (name.startsWith("en")) {
                        details.setSoundA(data);
                    } else if (name.startsWith("ch")) {
                        details.setSoundB(data);
                    } else if (name.startsWith("ru")) {
                        details.setSoundC(data);
                    }
                }
                continue;
            }

            if (name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png")) {
                DbxDownloader<FileMetadata> dl = client.files().download("/"+categoryName + "/details/" + details.getName() + "/" + name);
                try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                    dl.download(out);
                    byte[] data = out.toByteArray();
                    details.setImage(data);
                }
            }
        }
    }

}
