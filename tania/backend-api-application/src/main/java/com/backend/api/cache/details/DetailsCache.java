/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.cache.details;

import com.backend.api.model.details.Details;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public interface DetailsCache {

    public List<Details> findDetailsByCategory(String categoryName);

    public void updateDetailsPerCategory(String categoryName, List<Details> detailsList);
}
