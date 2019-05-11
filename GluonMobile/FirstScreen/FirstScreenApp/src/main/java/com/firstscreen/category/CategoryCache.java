/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstscreen.category;

import com.backend.api.model.category.Category;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public class CategoryCache {

    private static CategoryCache instance = new CategoryCache();
    private List<Category> categories;

    private CategoryCache() {
        categories = new ArrayList<>();
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static CategoryCache getInstance() {
        return instance;
    }

}
