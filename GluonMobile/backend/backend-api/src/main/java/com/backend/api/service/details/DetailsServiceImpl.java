/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.service.details;

import com.backend.api.cache.details.DetailsCache;
import com.backend.api.external.details.DetailsPersistence;
import com.backend.api.model.details.Details;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class DetailsServiceImpl implements DetailsService {
    
    private DetailsCache detailsCache;
    
    public DetailsServiceImpl(DetailsCache detailsCache) {
        this.detailsCache = detailsCache;
    }
    
    @Override
    public Details getDetailsByName(String categoryName, String name) {
        //return detailsCache.findDetailsByName(categoryName, name);
        return null;
    }
    
    @Override
    public List<Details> getAllDetailsPerCategory(String categoryName) {
        long start = System.currentTimeMillis();
        try {
            return detailsCache.findDetailsByCategory(categoryName);
        } finally {
            System.out.println("getAllDetailsPerCategory():"+(System.currentTimeMillis()-start));
        }
    }
    
    @Override
    public List<Details> getPaginationDetailsPerCategory(String categoryName, int start, int offset) {
        return new ArrayList();
    }
    
}
