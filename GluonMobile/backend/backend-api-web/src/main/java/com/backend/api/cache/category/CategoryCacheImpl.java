/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.cache.category;

import com.backend.api.model.category.Category;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public class CategoryCacheImpl implements CategoryCache {

    private List<Category> categories;

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public void updateAll(List<Category> catrgories) {
        this.categories = catrgories;
    }

}
