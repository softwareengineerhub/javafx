package com.backend.api.model.details.sound;

import com.middleware.AppConfig;

public class SoundApiImpl implements SoundApi {

    private String soundPath = "http://" + AppConfig.HOST + ":8080/sound-backend-api-application/sound?category=%s&details=%s&language=%s";

    @Override
    public String getUrl(String categoryName, String detailsName, String language) {
        return String.format(soundPath, categoryName, detailsName, language);
    }

}
