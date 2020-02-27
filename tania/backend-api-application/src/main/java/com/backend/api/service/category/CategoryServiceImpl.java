/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.service.category;

import com.backend.api.cache.category.CategoryCache;
import com.backend.api.model.category.Category;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class CategoryServiceImpl implements CategoryService {

    private CategoryCache categoryCache;

    public CategoryServiceImpl(CategoryCache categoryCache) {
        this.categoryCache = categoryCache;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryCache.findAll();
    }

    @Override
    public int version() {
        return categoryCache.getVersion();
    }

}
