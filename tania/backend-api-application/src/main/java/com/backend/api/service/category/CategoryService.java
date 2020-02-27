/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.service.category;

import com.backend.api.model.category.Category;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface CategoryService {

    public List<Category> getAllCategories();

    public int version();

}
