/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.backend.api.sound;

import com.backend.api.cache.details.DetailsCacheImpl;
import com.backend.api.model.details.Details;
import com.backend.api.service.details.DetailsService;
import com.backend.api.service.details.DetailsServiceImpl;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asusadmin
 */
public class SoundServlet extends HttpServlet {

    private DetailsService detailsService = new DetailsServiceImpl(new DetailsCacheImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        String details = req.getParameter("details");
        String country = req.getParameter("country");
        resp.setContentType("audio/mpeg");
        byte[] data = readSound(category, details, country);
        try (OutputStream out = resp.getOutputStream()) {
            out.write(data);
        }
    }

    private byte[] readSound(String category, String details, String country) {
        Details detailsItem = detailsService.getAllDetailsPerCategory(category).stream().filter(d -> d.getName().equals(details)).collect(Collectors.toList()).get(0);
        if ("en".equalsIgnoreCase(country)) {
            return detailsItem.getSoundA();
        }
        if ("ch".equalsIgnoreCase(country)) {
            return detailsItem.getSoundB();
        }
        return detailsItem.getSoundC();
    }

}
