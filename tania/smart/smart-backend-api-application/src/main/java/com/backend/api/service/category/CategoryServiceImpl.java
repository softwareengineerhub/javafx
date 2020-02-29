/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.service.category;

import com.backend.api.cache.category.CategoryCache;
import com.backend.api.model.category.Category;
import com.backend.api.model.version.VersionAmountData;

import java.util.ArrayList;
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
    public VersionAmountData version() {
        return categoryCache.getVersion();
    }

    @Override
    public List<Category> getPaginationCategories(int page, int limit) {
        List<Category> list = categoryCache.findAll();
        int upperLimit = Math.min((page+1)*limit,list.size());
        List<Category> result = new ArrayList();
        int index = page*limit;
        while(result.size()<limit){
            result.add(list.get(index++));
        }
        return result;
    }

}
