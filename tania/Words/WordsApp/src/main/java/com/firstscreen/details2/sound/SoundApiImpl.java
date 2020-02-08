package com.firstscreen.details2.sound;

public class SoundApiImpl implements SoundApi {

    //private String soundPath = "http://52.39.234.36:8080/sound-backend-api-application/sound?category=%s&details=%s&language=%s";
    private String soundPath = "http://134.209.244.234:8080/sound-backend-api-application/sound?category=%s&details=%s&language=%s";

    @Override
    public String getUrl(String categoryName, String detailsName, String language) {
        return String.format(soundPath, categoryName, detailsName, language);
    }

}
