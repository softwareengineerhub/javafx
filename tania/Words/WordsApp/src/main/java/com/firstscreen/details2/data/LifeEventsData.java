package com.firstscreen.details2.data;

import java.util.HashMap;
import java.util.Map;

public class LifeEventsData {

    public static Map<String, String> getData() {
        Map<String, String> map = new HashMap<>();

        int i = 0;
        map.put("ch" + i, "出生");
        map.put(String.format("ch%s.meta", i), "chū shēng");
        map.put("en" + i, "Birth");
        map.put("ru" + i, "Рождение");
        i++;


        map.put("ch" + i, "出生证明");
        map.put(String.format("ch%s.meta", i), "сhū shēng zhèng míng");
        map.put("en" + i, "Birth certificate");
        map.put("ru" + i, "Свидетельство о рождении");
        i++;

        map.put("ch" + i, "洗礼");
        map.put(String.format("ch%s.meta", i), "xǐ lǐ");
        map.put("en" + i, "Christening");
        map.put("ru" + i, "Крещение");
        i++;

        map.put("ch" + i, "上幼儿园");
        map.put(String.format("ch%s.meta", i), "shàng yòu ér yuán");
        map.put("en" + i, "Go to a kindergarten");
        map.put("ru" + i, "Пойти в детский сад");
        i++;

        map.put("ch" + i, "交朋友");
        map.put(String.format("ch%s.meta", i), "jiāo péng yǒu");
        map.put("en" + i, "Make friends");
        map.put("ru" + i, "Заводить друзей");
        i++;

        map.put("ch" + i, "入学/上学");
        map.put(String.format("ch%s.meta", i), "rù xué/ shàng xué");
        map.put("en" + i, "Go to school");
        map.put("ru" + i, "Пойти в школу");
        i++;


        map.put("ch" + i, "毕业");
        map.put(String.format("ch%s.meta", i), "bì yè");
        map.put("en" + i, "Graduate");
        map.put("ru" + i, "Окончить учебное заведение");
        i++;


        map.put("ch" + i, "毕业典礼");
        map.put(String.format("ch%s.meta", i), "bì yè diǎn lǐ");
        map.put("en" + i, "Graduation");
        map.put("ru" + i, "Выпускной");
        i++;

        map.put("ch" + i, "恋爱");
        map.put(String.format("ch%s.meta", i), "liàn ài");
        map.put("en" + i, "Fall in love");
        map.put("ru" + i, "Влюбиться");
        i++;


        map.put("ch" + i, "就业");
        map.put(String.format("ch%s.meta", i), "jiù yè");
        map.put("en" + i, "Get a job");
        map.put("ru" + i, "Получить работу");
        i++;


        map.put("ch" + i, "移民");
        map.put(String.format("ch%s.meta", i), "yí mín");
        map.put("en" + i, "Emigrate");
        map.put("ru" + i, "Эмигрировать/ Переселяться");
        i++;

        map.put("ch" + i, "结婚");
        map.put(String.format("ch%s.meta", i), "jié hūn");
        map.put("en" + i, "Get married");
        map.put("ru" + i, "Пожениться/Выйти замуж");
        i++;

        map.put("ch" + i, "婚礼");
        map.put(String.format("ch%s.meta", i), "hūn lǐ");
        map.put("en" + i, "Wedding");
        map.put("ru" + i, "Бракосочетание");
        i++;


        map.put("ch" + i, "婚宴");
        map.put(String.format("ch%s.meta", i), "hūn yàn");
        map.put("en" + i, "Wedding party");
        map.put("ru" + i, "Свадьба");
        i++;


        map.put("ch" + i, "蜜月");
        map.put(String.format("ch%s.meta", i), "mì yuè");
        map.put("en" + i, "Honeymoon");
        map.put("ru" + i, "Медовый месяц");
        i++;


        map.put("ch" + i, "纪念日");
        map.put(String.format("ch%s.meta", i), "jì niàn rì");
        map.put("en" + i, "Anniversary");
        map.put("ru" + i, "Юбилей/ Годовщина");
        i++;

        map.put("ch" + i, "生孩子");
        map.put(String.format("ch%s.meta", i), "shēng hái zi");
        map.put("en" + i, "Have a baby");
        map.put("ru" + i, "Рождение ребенка");
        i++;


        map.put("ch" + i, "离婚");
        map.put(String.format("ch%s.meta", i), "lí hūn");
        map.put("en" + i, "Divorce");
        map.put("ru" + i, "Развод");
        i++;


        map.put("ch" + i, "退休");
        map.put(String.format("ch%s.meta", i), "tuì xiū");
        map.put("en" + i, "Retire");
        map.put("ru" + i, "Выйти на пенсию");
        i++;


        map.put("ch" + i, "死亡");
        map.put(String.format("ch%s.meta", i), "sǐ wáng");
        map.put("en" + i, "Die");
        map.put("ru" + i, "Умереть/Скончаться");
        i++;


        map.put("ch" + i, "死亡");
        map.put(String.format("ch%s.meta", i), "sǐ wáng");
        map.put("en" + i, "Death");
        map.put("ru" + i, "Смерть");
        i++;


        map.put("ch" + i, "葬礼");
        map.put(String.format("ch%s.meta", i), "zàng lǐ");
        map.put("en" + i, "Funeral");
        map.put("ru" + i, "Похороны");
        i++;

        return map;
    }

}



