/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.backend.api.start;

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
import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author asusadmin
 */
public class ApplicationStartup implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Init cache");

        CategoryCache categoryCache = new CategoryCacheImpl();
        CategoryPersistence categoryPersistence = new CategoryPersistenceImpl();
        initCategoryCache(categoryCache, categoryPersistence);

        DetailsPersistence detailsPersistence = new DetailsPersistenceImpl();
        DetailsCache detailsCache = new DetailsCacheImpl();
        initDetailsCacheForAllCategories(categoryCache.findAll(), detailsCache, detailsPersistence);

        CategoryService categoryService = new CategoryServiceImpl(categoryCache);
        DetailsService detailsService = new DetailsServiceImpl(detailsCache);
        System.out.println("----------------SERVER STARTED----------------------------");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      
    }

    private static void initCategoryCache(CategoryCache categoryCache, CategoryPersistence categoryPersistence) {
        long start = System.currentTimeMillis();
        categoryCache.updateAll(categoryPersistence.findAll());
        System.out.println("category cache created: " + (System.currentTimeMillis() - start));
    }

    private static void initDetailsCacheForAllCategories(List<Category> categories, DetailsCache detailsCache, DetailsPersistence detailsPersistence) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            initDetailsCacheForCategory(categories.get(i), detailsCache, detailsPersistence);
        }
        System.out.println("\tall details cache created: " + (System.currentTimeMillis() - start));
    }

    private static void initDetailsCacheForCategory(Category category, DetailsCache detailsCache, DetailsPersistence detailsPersistence) {
        long start = System.currentTimeMillis();
        List<Details> detailsList = detailsPersistence.findAllDetails(category.getName());
        detailsCache.updateDetailsPerCategory(category.getName(), detailsList);
        System.out.println("\t\tdetails cache created: " + (System.currentTimeMillis() - start));
    }

}
