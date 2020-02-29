package com.firstscreen.details2.data;

import java.util.HashMap;
import java.util.Map;

public class PoisonBerry {

    public static Map<String, String> getData() {
        Map<String, String> map = new HashMap<>();
        int i = 0;

        map.put("ch" + i, "颠茄/别拉多娜草");
        map.put(String.format("ch%s.meta", i), "diān qié/bié lā duō nà cǎo");
        map.put("en" + i, "Belladonna");
        map.put("ru" + i, "Белладонна");
        i++;

        map.put("ch" + i, "水芋");
        map.put(String.format("ch%s.meta", i), "shuǐ yù");
        map.put("en" + i, "Marsh Calla/ bog arum");
        map.put("ru" + i, "Калла /Белокрыльник болотный");
        i++;

        map.put("ch" + i, "欧洲卫矛");
        map.put(String.format("ch%s.meta", i), "ōu zhōu wèi máo");
        map.put("en" + i, "European spindle");
        map.put("ru" + i, "Бересклет европейский/ Бруслина");
        i++;


        map.put("ch" + i, "女贞子");
        map.put(String.format("ch%s.meta", i), "nǚ zhēn zi");
        map.put("en" + i, "Chinese privet");
        map.put("ru" + i, "Бирючина /Волчьи ягоды");
        i++;

        map.put("ch" + i, "西洋接骨木");
        map.put(String.format("ch%s.meta", i), "xī yáng jiē gǔ mù");
        map.put("en" + i, "Black Elderberry");
        map.put("ru" + i, "Бузина чёрная");
        i++;

        map.put("ch" + i, "欧亚瑞香");
        map.put(String.format("ch%s.meta", i), "ōu yà ruì xiāng");
        map.put("en" + i, "February daphne / Mezereon");
        map.put("ru" + i, "Волчеягодник/ Волчье лыко");
        i++;


        map.put("ch" + i, "红果类叶升麻");
        map.put(String.format("ch%s.meta", i), "hóng guǒ lèi yè shēng má");
        map.put("en" + i, "Red baneberry");
        map.put("ru" + i, "Воронец");
        i++;

        map.put("ch" + i, "四叶重楼");
        map.put(String.format("ch%s.meta", i), "sì yè chóng lóu");
        map.put("en" + i, "Herb-paris");
        map.put("ru" + i, "Вороний глаз");
        i++;

        map.put("ch" + i, "忍冬果");
        map.put(String.format("ch%s.meta", i), "rěn dōng guǒ");
        map.put("en" + i, "Fly honeysuckle");
        map.put("ru" + i, "Жимолость лесная");
        i++;


        map.put("ch" + i, "欧鼠李");
        map.put(String.format("ch%s.meta", i), "ōu shǔ lǐ");
        map.put("en" + i, "Alder buckthorn");
        map.put("ru" + i, "Крушина ломкая");
        i++;


        map.put("ch" + i, "铃兰");
        map.put(String.format("ch%s.meta", i), "líng lán");
        map.put("en" + i, "Lily of the valley");
        map.put("ru" + i, "Ландыш майский");
        i++;


        map.put("ch" + i, "白英果");
        map.put(String.format("ch%s.meta", i), "bái yīng guǒ");
        map.put("en" + i, "Bittersweet nightshade");
        map.put("ru" + i, "Паслён  красный");
        i++;


        map.put("ch" + i, "雪果 /雪莓");
        map.put(String.format("ch%s.meta", i), "xuě guǒ/xuě méi");
        map.put("en" + i, "Snowberry");
        map.put("ru" + i, "Снежноягодник белый");
        i++;

        return map;
    }
}
