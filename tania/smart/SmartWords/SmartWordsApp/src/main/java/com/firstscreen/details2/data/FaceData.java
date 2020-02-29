package com.firstscreen.details2.data;

import java.util.HashMap;
import java.util.Map;

public class FaceData {

    public static Map<String, String> getData() {
        Map<String, String> map = new HashMap<>();
        int i = 0;

        map.put("ch" + i, "皮肤");
        map.put(String.format("ch%s.meta", i), "pí fū");
        map.put("en" + i, "Skin");
        map.put("ru" + i, "Кожа");
        i++;

        map.put("ch" + i, "前额/额头");
        map.put(String.format("ch%s.meta", i), "qián é /é tóu");
        map.put("en" + i, "Forehead");
        map.put("ru" + i, "Лоб");
        i++;

        map.put("ch" + i, "眉毛");
        map.put(String.format("ch%s.meta", i), "méi máo");
        map.put("en" + i, "Eyebrow");
        map.put("ru" + i, "Бровь");
        i++;

        map.put("ch" + i, "睫毛");
        map.put(String.format("ch%s.meta", i), "jié máo");
        map.put("en" + i, "Eyelash");
        map.put("ru" + i, "Ресница");
        i++;


        map.put("ch" + i, "眼睛");
        map.put(String.format("ch%s.meta", i), "yǎn jīng");
        map.put("en" + i, "Eye");
        map.put("ru" + i, "Глаз");
        i++;


        map.put("ch" + i, "鼻孔");
        map.put(String.format("ch%s.meta", i), "bí kǒng");
        map.put("en" + i, "Nostrils");
        map.put("ru" + i, "Ноздри");
        i++;


        map.put("ch" + i, "鼻子");
        map.put(String.format("ch%s.meta", i), "bí zi");
        map.put("en" + i, "Nose");
        map.put("ru" + i, "Нос");
        i++;

        map.put("ch" + i, "嘴");
        map.put(String.format("ch%s.meta", i), "zuǐ");
        map.put("en" + i, "Mouth");
        map.put("ru" + i, "Рот");
        i++;

        map.put("ch" + i, "牙齿");
        map.put(String.format("ch%s.meta", i), "yá chǐ");
        map.put("en" + i, "Tooth");
        map.put("ru" + i, "Зуб");
        i++;


        map.put("ch" + i, "嘴唇");
        map.put(String.format("ch%s.meta", i), "zuǐ chún");
        map.put("en" + i, "Lips");
        map.put("ru" + i, "Губы");
        i++;


        map.put("ch" + i, "脸颊");
        map.put(String.format("ch%s.meta", i), "liǎn jiá");
        map.put("en" + i, "Cheek");
        map.put("ru" + i, "Щека");
        i++;


        map.put("ch" + i, "舌头");
        map.put(String.format("ch%s.meta", i), "shé tóu");
        map.put("en" + i, "Tongue");
        map.put("ru" + i, "Язык");
        i++;


        map.put("ch" + i, "下颚");
        map.put(String.format("ch%s.meta", i), "xià è");
        map.put("en" + i, "Jaw");
        map.put("ru" + i, "Челюсть");
        i++;

        map.put("ch" + i, "下巴");
        map.put(String.format("ch%s.meta", i), "xià bā");
        map.put("en" + i, "Chin");
        map.put("ru" + i, "Подбородок");
        i++;



        map.put("ch" + i, "脖子");
        map.put(String.format("ch%s.meta", i), "bó zi");
        map.put("en" + i, "Neck");
        map.put("ru" + i, "Шея");
        i++;


        map.put("ch" + i, "耳朵");
        map.put(String.format("ch%s.meta", i), "ěr duo");
        map.put("en" + i, "Ear");
        map.put("ru" + i, "Ухо");
        i++;

        map.put("ch" + i, "头发");
        map.put(String.format("ch%s.meta", i), "tóu fā");
        map.put("en" + i, "Hair");
        map.put("ru" + i, "Волосы");
        i++;

        map.put("ch" + i, "痣");
        map.put(String.format("ch%s.meta", i), "zhì");
        map.put("en" + i, "Mole");
        map.put("ru" + i, "Родинка");
        i++;
        return  map;
    }
}
