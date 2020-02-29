package com.firstscreen.details2.data;

import java.util.HashMap;
import java.util.Map;

public class Mashrooms {





    public static Map<String, String> getData() {
        Map<String, String> map = new HashMap<>();
        int i = 0;

        map.put("ch" + i, "牛肝菌");
        map.put(String.format("ch%s.meta", i), "niú gān jùn");
        map.put("en" + i, "Porcini mushroom");
        map.put("ru" + i, "Белый гриб");
        i++;

        map.put("ch" + i, "褐疣柄牛肝菌");
        map.put(String.format("ch%s.meta", i), "hè yóu bǐng niú gān jùn");
        map.put("en" + i, "Birch bolete");
        map.put("ru" + i, "Подберёзовик");
        i++;

        map.put("ch" + i, "平菇/侧耳");
        map.put(String.format("ch%s.meta", i), "píng gū /cè ěr");
        map.put("en" + i, "Oyster mushroom");
        map.put("ru" + i, "Вёшенка / Устричный гриб");
        i++;





        map.put("ch" + i, "鸡油菌");
        map.put(String.format("ch%s.meta", i), "jī yóu jùn");
        map.put("en" + i, "Golden chanterelle");
        map.put("ru" + i, "Лисички");
        i++;

        map.put("ch" + i, "卷边乳菇");
        map.put(String.format("ch%s.meta", i), "juǎn biān rǔ gū");
        map.put("en" + i, "Milk agaric");
        map.put("ru" + i, "Груздь");
        i++;

        map.put("ch" + i, "乳牛肝菌");
        map.put(String.format("ch%s.meta", i), "rǔ niú gān jùn");
        map.put("en" + i, "Slippery jack mushroom");
        map.put("ru" + i, "Маслёнок");
        i++;

        map.put("ch" + i, "厚环乳牛肝菌");
        map.put(String.format("ch%s.meta", i), "hòu huán rǔ niú gān jùn");
        map.put("en" + i, "Greville's bolete");
        map.put("ru" + i, "Маслёнок лиственничный");
        i++;

        map.put("ch" + i, "毒蝇伞");
        map.put(String.format("ch%s.meta", i), "dú yíng sǎn");
        map.put("en" + i, "Fly amanita");
        map.put("ru" + i, "Мухомор красный");
        i++;

        map.put("ch" + i, "毛柄库恩菌");
        map.put(String.format("ch%s.meta", i), "máo bǐng kù ēn jùn");
        map.put("en" + i, "Sheathed woodtuft mushroom");
        map.put("ru" + i, "Опёнок летний");
        i++;

        map.put("ch" + i, "蜜环菌");
        map.put(String.format("ch%s.meta", i), "mì huán jùn");
        map.put("en" + i, "Honey mushroom");
        map.put("ru" + i, "Опёнок осенний");
        i++;

        map.put("ch" + i, "松乳菇/松菌");
        map.put(String.format("ch%s.meta", i), "sōng rǔ gū /sōng jùn");
        map.put("en" + i, "Red pine mushroom");
        map.put("ru" + i, "Рыжик");
        i++;

        map.put("ch" + i, "羊肚菌");
        map.put(String.format("ch%s.meta", i), "yáng dù jùn");
        map.put("en" + i, "Morel / Sponge morel");
        map.put("ru" + i, "Сморчок съедобный");
        i++;

        map.put("ch" + i, "菱红菇");
        map.put(String.format("ch%s.meta", i), "líng hóng gū");
        map.put("en" + i, "Bare-toothed russula");
        map.put("ru" + i, "Сыроежка пищевая");
        i++;

        map.put("ch" + i, "绿菇");
        map.put(String.format("ch%s.meta", i), "lǜ gū");
        map.put("en" + i, "Green russula");
        map.put("ru" + i, "Сыроежка зеленоватая");
        i++;

        map.put("ch" + i, "亮黄红菇");
        map.put(String.format("ch%s.meta", i), "liàng huáng hóng gū");
        map.put("en" + i, "Yellow swamp russula");
        map.put("ru" + i, "Сыроежка светло-жёлтая");
        i++;





        map.put("ch" + i, "松露");
        map.put(String.format("ch%s.meta", i), "sōng lù");
        map.put("en" + i, "Truffle");
        map.put("ru" + i, "Трюфель");
        i++;





        map.put("ch" + i, "双孢蘑菇/ 洋蘑菇");
        map.put(String.format("ch%s.meta", i), "shuāng bāo mó gū / yáng mó gū");
        map.put("en" + i, "Button mushroom");
        map.put("ru" + i, "Шампиньон двуспоровый");
        i++;


        map.put("ch" + i, "香菇");
        map.put(String.format("ch%s.meta", i), "xiāng gū");
        map.put("en" + i, "Shiitake");
        map.put("ru" + i, "Шиитаке/ Японский лесной гриб");
        i++;





        map.put("ch" + i, "金针菇");
        map.put(String.format("ch%s.meta", i), "jīn zhēn gū");
        map.put("en" + i, "Enoki Mushroom/ Enokitake");
        map.put("ru" + i, "Грибы Эноки/ Энокитаке");
        i++;

        map.put("ch" + i, "黑木耳");
        map.put(String.format("ch%s.meta", i), "hēi mù ěr");
        map.put("en" + i, "Wood ear/ Jew's ear");
        map.put("ru" + i, "Древесные грибы/ Иудины уши");
        i++;

        return map;
    }
}
