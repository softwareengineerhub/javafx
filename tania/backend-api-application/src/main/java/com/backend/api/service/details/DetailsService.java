/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.api.service.details;

import com.backend.api.model.details.Details;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface DetailsService {
    
    public Details getDetailsByName(String categoryName, String name);
    
    public List<Details> getAllDetailsPerCategory(String categoryName);
    
    public List<Details> getPaginationDetailsPerCategory(String categoryName, int start, int offset);
    
    public Details getFirstDetailsPerCategory(String categoryName);

    public Object getDetailsByIndex(String categoryName, int detailsIndex);
    
}
