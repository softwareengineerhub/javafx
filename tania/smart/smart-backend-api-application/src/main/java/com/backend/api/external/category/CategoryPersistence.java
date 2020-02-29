/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.external.category;

import com.backend.api.model.category.Category;
import com.backend.api.model.version.VersionAmountData;

import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface CategoryPersistence {

    public List<Category> findAll();

    public VersionAmountData version();

}
