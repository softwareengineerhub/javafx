package com.firstscreen.file.storage;

import com.backend.api.model.category.Category;
import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.StorageService;
import com.gluonhq.charm.glisten.control.Alert;
import com.gluonhq.charm.glisten.control.ExceptionDialog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryFileStorageImpl implements CategoryFileStorage {
    private static final String CATEGORY_FILE_PATTERN = "cat%s.txt";

    @Override
    public void save(List<Category> categories, int paginationIndex) {
        Services.get(StorageService.class).ifPresent(t -> {
            t.getPrivateStorage().ifPresent(f -> {
                File data = new File(f, String.format(CATEGORY_FILE_PATTERN, paginationIndex));
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(data))) {
                    out.writeObject(categories);
                } catch (Exception ex) {
                    ExceptionDialog exceptionDialog = new ExceptionDialog();
                    exceptionDialog.setException(ex);
                    exceptionDialog.showAndWait();
                }
            });

        });
    }

    @Override
    public void clear() {
        Services.get(StorageService.class).ifPresent(t -> {
            t.getPrivateStorage().ifPresent(f -> {

                for(int i=0;i<100;i++) {
                    File data = new File(f, String.format(CATEGORY_FILE_PATTERN, i));
                    if(data.exists()) {
                        data.delete();
                    }
                }
            });
        });
    }

    @Override
    public List<Category> load(int paginationIndex) {
        List<Category> list = new ArrayList<>();
        Services.get(StorageService.class).ifPresent(t->{




            t.getPrivateStorage().ifPresent(f->{
                File data = new File(f, String.format(CATEGORY_FILE_PATTERN, paginationIndex));
                try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(data))){
                   list.addAll((List<Category>)in.readObject());
                }catch(Exception ex){
                    ExceptionDialog exceptionDialog = new ExceptionDialog();
                    exceptionDialog.setException(ex);
                    exceptionDialog.showAndWait();
                }
            });

        });

        return list;
    }
}
