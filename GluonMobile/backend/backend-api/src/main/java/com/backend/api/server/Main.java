/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.server;

import com.backend.api.cache.category.CategoryCache;
import com.backend.api.cache.category.CategoryCacheImpl;
import com.backend.api.cache.details.DetailsCache;
import com.backend.api.cache.details.DetailsCacheImpl;
import com.backend.api.external.category.CategoryPersistence;
import com.backend.api.external.category.CategoryPersistenceImpl;
import com.backend.api.external.details.DetailsPersistence;
import com.backend.api.external.details.DetailsPersistenceImpl;
import com.backend.api.model.category.Category;
import com.backend.api.model.details.Details;
import com.backend.api.service.category.CategoryService;
import com.backend.api.service.category.CategoryServiceImpl;
import com.backend.api.service.details.DetailsService;
import com.backend.api.service.details.DetailsServiceImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
       // System.setOut(new PrintStream(new File("log.txt")));
        System.out.println("Init cache");

        CategoryCache categoryCache = new CategoryCacheImpl();
        CategoryPersistence categoryPersistence = new CategoryPersistenceImpl();
        initCategoryCache(categoryCache, categoryPersistence);

        DetailsPersistence detailsPersistence = new DetailsPersistenceImpl();
        DetailsCache detailsCache = new DetailsCacheImpl();
        initDetailsCacheForAllCategories(categoryCache.findAll(), detailsCache, detailsPersistence);

        CategoryService categoryService = new CategoryServiceImpl(categoryCache);
        DetailsService detailsService = new DetailsServiceImpl(detailsCache);

        BackendApiServer backendApiServer = new BackendApiServer(8083, categoryService, detailsService);
        backendApiServer.start();
        System.out.println("----------------SERVER STARTED----------------------------");
    }

    private static void initCategoryCache(CategoryCache categoryCache, CategoryPersistence categoryPersistence) {
        long start = System.currentTimeMillis();
        categoryCache.updateAll(categoryPersistence.findAll());
        System.out.println("category cache created: " + (System.currentTimeMillis() - start));
    }

    private static void initDetailsCacheForAllCategories(List<Category> categories, DetailsCache detailsCache, DetailsPersistence detailsPersistence) throws Exception {
        long start = System.currentTimeMillis();
        List<Future> futures = new ArrayList(categories.size());
        for (int i = 0; i < categories.size(); i++) {
            futures.add(initDetailsCacheForCategory(categories.get(i), detailsCache, detailsPersistence));
        }
        for(Future future: futures){
            future.get();
        }
        System.out.println("\tall details cache created: " + (System.currentTimeMillis() - start));
    }

    private static Future initDetailsCacheForCategory(Category category, DetailsCache detailsCache, DetailsPersistence detailsPersistence) {
        return executorService.submit(new Callable() {
            @Override
            public Object call() {
                long start = System.currentTimeMillis();
                List<Details> detailsList = detailsPersistence.findAllDetails(category.getName());
                detailsCache.updateDetailsPerCategory(category.getName(), detailsList);
                System.out.println("\t\tdetails cache created: " + (System.currentTimeMillis() - start));
                return "";
            }
        });

    }

}
