package com.firstscreen.details2.data;

import java.util.HashMap;
import java.util.Map;

public class Seasons {

    public static Map<String, String> getData() {
        Map<String, String> map = new HashMap<>();
        int i = 0;


        map.put("ch" + i, "冬天");
        map.put(String.format("ch%s.meta", i), "dōng tiān");
        map.put("en" + i, "Winter");
        map.put("ru" + i, "Зима");
        i++;

        map.put("ch" + i, "春天");
        map.put(String.format("ch%s.meta", i), "сhūn tiān");
        map.put("en" + i, "Spring");
        map.put("ru" + i, "Весна");
        i++;


        map.put("ch" + i, "夏天");
        map.put(String.format("ch%s.meta", i), "xià tiān");
        map.put("en" + i, "Summer");
        map.put("ru" + i, "Лето");
        i++;

        map.put("ch" + i, "秋天");
        map.put(String.format("ch%s.meta", i), "qiū tiān");
        map.put("en" + i, "Autumn/ Fall");
        map.put("ru" + i, "Осень");
        i++;

        return map;
    }
}
