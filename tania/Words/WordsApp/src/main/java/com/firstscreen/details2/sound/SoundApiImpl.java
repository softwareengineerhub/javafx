package com.firstscreen.details2.sound;

import com.backend.api.config.AppConfig;

public class SoundApiImpl implements SoundApi {

    private String soundPath = "http://" + AppConfig.HOST + ":8080/sound-backend-api-application/sound?category=%s&details=%s&language=%s";

    @Override
    public String getUrl(String categoryName, String detailsName, String language) {
        return String.format(soundPath, categoryName, detailsName, language);
    }

}
