/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.external.details;

import com.backend.api.model.details.Details;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface DetailsPersistence {

    public List<Details> findAllDetails(String categoryName);

    public Details findDetailsByName(String categoryName, String name);

}
