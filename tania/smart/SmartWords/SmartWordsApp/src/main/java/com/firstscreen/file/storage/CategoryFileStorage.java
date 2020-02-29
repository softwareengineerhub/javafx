package com.firstscreen.file.storage;

import com.backend.api.model.category.Category;

import java.util.List;

public interface CategoryFileStorage {

    public void save(List<Category> categories, int paginationIndex);

    public void clear();

    public List<Category> load(int paginationIndex);

}
