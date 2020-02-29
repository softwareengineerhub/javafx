/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.cache.category;

import com.backend.api.model.category.Category;
import com.backend.api.model.version.VersionAmountData;

import java.util.List;

/**
 *
 * @author asusadmin
 */
public interface CategoryCache {

    public List<Category> findAll();

    public void updateAll(List<Category> catrgories);

    public VersionAmountData getVersion();

    public void setVersion(VersionAmountData version);


}
