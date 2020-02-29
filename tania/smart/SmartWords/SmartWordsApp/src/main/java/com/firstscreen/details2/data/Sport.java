package com.firstscreen.details2.data;

import java.util.HashMap;
import java.util.Map;

public class Sport {

    public static Map<String, String> getData() {
        Map<String, String> map = new HashMap<>();
        int i = 0;


        map.put("ch" + i, "运动");
        map.put(String.format("ch%s.meta", i), "yùn dòng");
        map.put("en" + i, "Sport");
        map.put("ru" + i, "Спорт");
        i++;


        map.put("ch" + i, "健康");
        map.put(String.format("ch%s.meta", i), "jiàn kāng");
        map.put("en" + i, "Health");
        map.put("ru" + i, "Здоровье");
        i++;


        map.put("ch" + i, "体操");
        map.put(String.format("ch%s.meta", i), "tǐ cāo");
        map.put("en" + i, "Gymnastics");
        map.put("ru" + i, "Гимнастика");
        i++;


        map.put("ch" + i, "运动员");
        map.put(String.format("ch%s.meta", i), "yùn dòng yuán");
        map.put("en" + i, "Sportsman");
        map.put("ru" + i, "Спортсмен");
        i++;


        map.put("ch" + i, "体育场");
        map.put(String.format("ch%s.meta", i), "tǐ yù chǎng");
        map.put("en" + i, "Stadium");
        map.put("ru" + i, "Стадион");
        i++;


        map.put("ch" + i, "比赛");
        map.put(String.format("ch%s.meta", i), "bǐ sài");
        map.put("en" + i, "Competition");
        map.put("ru" + i, "Состязание/Матч");
        i++;


        map.put("ch" + i, "跳高");
        map.put(String.format("ch%s.meta", i), "tiào gāo");
        map.put("en" + i, "High jump");
        map.put("ru" + i, "Прыжок в высоту");
        i++;


        map.put("ch" + i, "跳远");
        map.put(String.format("ch%s.meta", i), "tiào yuǎn");
        map.put("en" + i, "Standing long jump");
        map.put("ru" + i, "Прыжок в длину");
        i++;


        map.put("ch" + i, "跳水");
        map.put(String.format("ch%s.meta", i), "tiào shuǐ");
        map.put("en" + i, "Diving");
        map.put("ru" + i, "Прыжки в воду");
        i++;


        map.put("ch" + i, "蹦床");
        map.put(String.format("ch%s.meta", i), "bèng chuáng");
        map.put("en" + i, "Trampoline");
        map.put("ru" + i, "Прыжки на батуте");
        i++;

        map.put("ch" + i, "赛跑");
        map.put(String.format("ch%s.meta", i), "sài pǎo");
        map.put("en" + i, "Running");
        map.put("ru" + i, "Бег");
        i++;


        map.put("ch" + i, "跑步");
        map.put(String.format("ch%s.meta", i), "pǎo bù");
        map.put("en" + i, "Jogging");
        map.put("ru" + i, "Делать пробежку");
        i++;

        map.put("ch" + i, "马拉松");
        map.put(String.format("ch%s.meta", i), "mǎ lā sōng");
        map.put("en" + i, "Marathon");
        map.put("ru" + i, "Марафон");
        i++;

        map.put("ch" + i, "自行车比赛");
        map.put(String.format("ch%s.meta", i), "zìxíngchē bǐsài");
        map.put("en" + i, "Bicycle race");
        map.put("ru" + i, "Велогонка");
        i++;


        map.put("ch" + i, "艺术体操");
        map.put(String.format("ch%s.meta", i), "yì shù tǐ cāo");
        map.put("en" + i, "Rhythmic  Gymnastics");
        map.put("ru" + i, "Художественная гимнастика");
        i++;


        map.put("ch" + i, "自由体操");
        map.put(String.format("ch%s.meta", i), "zì yóu tǐ cāo");
        map.put("en" + i, "Floor exercise");
        map.put("ru" + i, "Вольные упражнения");
        i++;


        map.put("ch" + i, "平衡木");
        map.put(String.format("ch%s.meta", i), "píng héng mù");
        map.put("en" + i, "Balance beam");
        map.put("ru" + i, "Бревно (гимнастика)");
        i++;

        map.put("ch" + i, "高低杠");
        map.put(String.format("ch%s.meta", i), "gāo dī gàng");
        map.put("en" + i, "Uneven bars");
        map.put("ru" + i, "Разновысокие брусья");
        i++;

        map.put("ch" + i, "跳马");
        map.put(String.format("ch%s.meta", i), "tiào mǎ");
        map.put("en" + i, "Horse-Vaulting");
        map.put("ru" + i, "Horse-Vaulting");
        i++;

        map.put("ch" + i, "ān mǎ");
        map.put(String.format("ch%s.meta", i), "鞍马");
        map.put("en" + i, "Pommel Horse ");
        map.put("ru" + i, " Конь гимнастический");
        i++;


        map.put("ch" + i, "单杠");
        map.put(String.format("ch%s.meta", i), "dān gàng");
        map.put("en" + i, "Horizontal bar");
        map.put("ru" + i, "Перекладина /Турник");
        i++;

        map.put("ch" + i, "双杠");
        map.put(String.format("ch%s.meta", i), "shuāng gàng");
        map.put("en" + i, "Parallel bars");
        map.put("ru" + i, "Параллельные брусья");
        i++;

        map.put("ch" + i, "吊环");
        map.put(String.format("ch%s.meta", i), "diào huán");
        map.put("en" + i, "Still rings");
        map.put("ru" + i, "Кольца");
        i++;


        map.put("ch" + i, "骑马");
        map.put(String.format("ch%s.meta", i), "qí mǎ");
        map.put("en" + i, "Horse riding");
        map.put("ru" + i, "Верховая езда");
        i++;

        map.put("ch" + i, "赛马");
        map.put(String.format("ch%s.meta", i), "sài mǎ");
        map.put("en" + i, "Horse racing");
        map.put("ru" + i, "Скачки");
        i++;


        map.put("ch" + i, "马球");
        map.put(String.format("ch%s.meta", i), "mǎ qiú");
        map.put("en" + i, "Polo");
        map.put("ru" + i, "Поло");
        i++;

        map.put("ch" + i, "排球");
        map.put(String.format("ch%s.meta", i), "pái qiú");
        map.put("en" + i, "Volleyball");
        map.put("ru" + i, "Волейбол");
        i++;

        map.put("ch" + i, "沙滩排球");
        map.put(String.format("ch%s.meta", i), "shā tān pái qiú");
        map.put("en" + i, "Beach volleyball");
        map.put("ru" + i, "Пляжный волейбол");
        i++;

        map.put("ch" + i, "打篮球");
        map.put(String.format("ch%s.meta", i), "dǎ lán qiú");
        map.put("en" + i, "Basketball");
        map.put("ru" + i, "Баскетбол");
        i++;

        map.put("ch" + i, "篮球");
        map.put(String.format("ch%s.meta", i), "lán qiú");
        map.put("en" + i, "Basketball ball");
        map.put("ru" + i, "Баскетбольный мяч");
        i++;


        map.put("ch" + i, "踢足球");
        map.put(String.format("ch%s.meta", i), "tī zú qiú");
        map.put("en" + i, "Play football");
        map.put("ru" + i, "Играть в футбол");
        i++;


        map.put("ch" + i, "足球");
        map.put(String.format("ch%s.meta", i), "zú qiú");
        map.put("en" + i, "Soccer-ball");
        map.put("ru" + i, "Футбольный мяч");
        i++;

        map.put("ch" + i, "球");
        map.put(String.format("ch%s.meta", i), "qiú");
        map.put("en" + i, "Ball");
        map.put("ru" + i, "Мяч");
        i++;

        map.put("ch" + i, "打乒乓球");
        map.put(String.format("ch%s.meta", i), "dǎ pīng pāng qiú");
        map.put("en" + i, "Table tennis/Ping-pong");
        map.put("ru" + i, "Пинг-понг");
        i++;


        map.put("ch" + i, "乒乓球台");
        map.put(String.format("ch%s.meta", i), "pīng pāng qiú tái");
        map.put("en" + i, "Ping-pong table");
        map.put("ru" + i, "Стол для настольного тенниса");
        i++;


        map.put("ch" + i, "乒乓球");
        map.put(String.format("ch%s.meta", i), "pīng pāng qiú");
        map.put("en" + i, "Table tennis ball");
        map.put("ru" + i, "Мяч для пинг-понга");
        i++;

        map.put("ch" + i, "乒乓球拍");
        map.put(String.format("ch%s.meta", i), "pīng pāng qiú pāi");
        map.put("en" + i, "Table tennis racket");
        map.put("ru" + i, "Ракетка для настольного тенниса");
        i++;

        map.put("ch" + i, "打羽毛球");
        map.put(String.format("ch%s.meta", i), "dǎ yǔ máo qiú");
        map.put("en" + i, "Badminton");
        map.put("ru" + i, "Бадминтон");
        i++;


        map.put("ch" + i, "羽毛球");
        map.put(String.format("ch%s.meta", i), "yǔ máo qiú");
        map.put("en" + i, "Badminton Shuttlecock");
        map.put("ru" + i, "Волан для бадминтона");
        i++;


        map.put("ch" + i, "羽毛球拍");
        map.put(String.format("ch%s.meta", i), "yǔ máo qiú pāi");
        map.put("en" + i, "Badminton racket");
        map.put("ru" + i, "Ракетка для бадминтона");
        i++;


        map.put("ch" + i, "打网球");
        map.put(String.format("ch%s.meta", i), "dǎ wǎng qiú");
        map.put("en" + i, "Tennis");
        map.put("ru" + i, "Теннис");
        i++;


        map.put("ch" + i, "网球");
        map.put(String.format("ch%s.meta", i), "wǎng qiú");
        map.put("en" + i, "Tennis ball");
        map.put("ru" + i, "Теннисный мяч");
        i++;


        map.put("ch" + i, "网球拍");
        map.put(String.format("ch%s.meta", i), "wǎng qiú pāi");
        map.put("en" + i, "Tennis racket");
        map.put("ru" + i, "Теннисная ракетка");
        i++;


        map.put("ch" + i, "高尔夫球");
        map.put(String.format("ch%s.meta", i), "gāo ěr fū qiú");
        map.put("en" + i, "Golf");
        map.put("ru" + i, "Гольф");
        i++;


        map.put("ch" + i, "射击");
        map.put(String.format("ch%s.meta", i), "shè jī");
        map.put("en" + i, "Shooting");
        map.put("ru" + i, "Стрельба");
        i++;

        map.put("ch" + i, "橄榄球");
        map.put(String.format("ch%s.meta", i), "gǎn lǎn qiú");
        map.put("en" + i, "Rugby");
        map.put("ru" + i, "Регби");
        i++;


        map.put("ch" + i, "美式橄榄球");
        map.put(String.format("ch%s.meta", i), "měi shì gǎn lǎn qiú");
        map.put("en" + i, "American football");
        map.put("ru" + i, "Американский футбол");
        i++;


        map.put("ch" + i, "手球");
        map.put(String.format("ch%s.meta", i), "shǒu qiú");
        map.put("en" + i, "Handball");
        map.put("ru" + i, "Гандбол");
        i++;

        map.put("ch" + i, "铅球");
        map.put(String.format("ch%s.meta", i), "qiān qiú");
        map.put("en" + i, "Shot put");
        map.put("ru" + i, "Толкание ядра");
        i++;

        map.put("ch" + i, "曲棍球");
        map.put(String.format("ch%s.meta", i), "qū gùn qiú");
        map.put("en" + i, "Field Hockey");
        map.put("ru" + i, "Хоккей на траве");
        i++;


        map.put("ch" + i, "太极拳");
        map.put(String.format("ch%s.meta", i), "tài jí quán");
        map.put("en" + i, "Tai ji quan / Tai chi");
        map.put("ru" + i, "Гимнастика Тайцзицюань");
        i++;


        map.put("ch" + i, "功夫");
        map.put(String.format("ch%s.meta", i), "gōng fū");
        map.put("en" + i, "Kung Fu");
        map.put("ru" + i, "Кунг-фу");
        i++;


        map.put("ch" + i, "柔道");
        map.put(String.format("ch%s.meta", i), "róu dào");
        map.put("en" + i, "Judo");
        map.put("ru" + i, "Дзюдо");
        i++;


        map.put("ch" + i, "摔跤");
        map.put(String.format("ch%s.meta", i), "shuāi jiāo");
        map.put("en" + i, "Wrestling");
        map.put("ru" + i, "Борьба");
        i++;


        map.put("ch" + i, "自由式摔跤");
        map.put(String.format("ch%s.meta", i), "zì yóu shì shuāi jiāo");
        map.put("en" + i, "Wrestling Freestyle");
        map.put("ru" + i, "Вольная борьба");
        i++;


        map.put("ch" + i, "古典式摔跤");
        map.put(String.format("ch%s.meta", i), "gǔ diǎn shì shuāi jiāo");
        map.put("en" + i, "Greco-Roman wrestling");
        map.put("ru" + i, "Греко-римская борьба");
        i++;


        map.put("ch" + i, "跆拳道");
        map.put(String.format("ch%s.meta", i), "tái quán dào");
        map.put("en" + i, "Taekwondo");
        map.put("ru" + i, "Тэквандо");
        i++;


        map.put("ch" + i, "拳击");
        map.put(String.format("ch%s.meta", i), "quán jí");
        map.put("en" + i, "Boxing");
        map.put("ru" + i, "Бокс");
        i++;


        map.put("ch" + i, "举重");
        map.put(String.format("ch%s.meta", i), "jǔ zhòng");
        map.put("en" + i, " Weightlifting");
        map.put("ru" + i, "Тяжёлая атлетика");
        i++;


        map.put("ch" + i, "轮滑");
        map.put(String.format("ch%s.meta", i), "lún huá");
        map.put("en" + i, "Roller skating");
        map.put("ru" + i, "Катание на роликах");
        i++;


        map.put("ch" + i, "滑板运动");
        map.put(String.format("ch%s.meta", i), "huá bǎn yùn dòng");
        map.put("en" + i, "Skateboarding");
        map.put("ru" + i, "Скейтбординг");
        i++;


        map.put("ch" + i, "水上运动");
        map.put(String.format("ch%s.meta", i), "shuǐ shàng yùn dòng");
        map.put("en" + i, "Water sport");
        map.put("ru" + i, "Водный спорт");
        i++;


        map.put("ch" + i, "水上飞行");
        map.put(String.format("ch%s.meta", i), "shuǐ shàng fēi xíng");
        map.put("en" + i, " Flyboarding");
        map.put("ru" + i, "Флайбординг");
        i++;


        map.put("ch" + i, "帆船");
        map.put(String.format("ch%s.meta", i), "fān chuán");
        map.put("en" + i, "Sailing");
        map.put("ru" + i, "Парусный спорт");
        i++;


        map.put("ch" + i, "皮划艇");
        map.put(String.format("ch%s.meta", i), "pí huá tǐng");
        map.put("en" + i, "Canoeing and Kayaking");
        map.put("ru" + i, "Гребля на байдарках и каноэ");
        i++;


        map.put("ch" + i, "赛艇");
        map.put(String.format("ch%s.meta", i), "sài tǐng");
        map.put("en" + i, "Rowing");
        map.put("ru" + i, "Гребля");
        i++;


        map.put("ch" + i, "游泳");
        map.put(String.format("ch%s.meta", i), "yóu yǒng");
        map.put("en" + i, "Swimming");
        map.put("ru" + i, "Плавание");
        i++;


        map.put("ch" + i, "蛙泳");
        map.put(String.format("ch%s.meta", i), "wā yǒng");
        map.put("en" + i, "Breaststroke");
        map.put("ru" + i, "Брасс");
        i++;


        map.put("ch" + i, "马拉松游泳");
        map.put(String.format("ch%s.meta", i), "mǎ lā sōng yóu yǒng");
        map.put("en" + i, "Marathon swimming");
        map.put("ru" + i, "Марафонское плавание");
        i++;


        map.put("ch" + i, "水球");
        map.put(String.format("ch%s.meta", i), "shuǐ qiú");
        map.put("en" + i, "Water polo");
        map.put("ru" + i, "Водное поло");
        i++;


        map.put("ch" + i, "花样游泳");
        map.put(String.format("ch%s.meta", i), "huā yàng yóu yǒng");
        map.put("en" + i, "Synchronised swimming");
        map.put("ru" + i, "Синхронное плавание");
        i++;


        map.put("ch" + i, "滑水");
        map.put(String.format("ch%s.meta", i), "huá shuǐ");
        map.put("en" + i, "Water skiing");
        map.put("ru" + i, "Водные лыжи");
        i++;

        map.put("ch" + i, "尾波滑水");
        map.put(String.format("ch%s.meta", i), "wěi bō huá shuǐ");
        map.put("en" + i, "Wakeboarding");
        map.put("ru" + i, "Вейкбординг");
        i++;

        map.put("ch" + i, "桨板冲浪");
        map.put(String.format("ch%s.meta", i), "jiǎng bǎn chōng làng");
        map.put("en" + i, "Paddle boarding");
        map.put("ru" + i, "Падлбординг");
        i++;

        map.put("ch" + i, "冲浪");
        map.put(String.format("ch%s.meta", i), "chōng làng");
        map.put("en" + i, "Surfing");
        map.put("ru" + i, "Сёрфинг");
        i++;

        map.put("ch" + i, "风筝冲浪");
        map.put(String.format("ch%s.meta", i), "fēng zhēng chōng làng");
        map.put("en" + i, "Kitesurfing");
        map.put("ru" + i, "Кайтсёрфинг");
        i++;

        map.put("ch" + i, "浅水冲浪");
        map.put(String.format("ch%s.meta", i), "qiǎn shuǐ chōng làng");
        map.put("en" + i, "Skimboarding");
        map.put("ru" + i, "Скимбординг");
        i++;

        map.put("ch" + i, "悬崖跳水");
        map.put(String.format("ch%s.meta", i), "xuán yá tiào shuǐ");
        map.put("en" + i, "Cliff diving");
        map.put("ru" + i, "Клифф-дайвинг");
        i++;

        map.put("ch" + i, "潜水");
        map.put(String.format("ch%s.meta", i), "qián shuǐ");
        map.put("en" + i, "Diving");
        map.put("ru" + i, "Дайвинг");
        i++;

        map.put("ch" + i, "自由潜水");
        map.put(String.format("ch%s.meta", i), "zì yóu qián shuǐ");
        map.put("en" + i, "Free diving");
        map.put("ru" + i, "Фридайвинг");
        i++;

        map.put("ch" + i, "飘流");
        map.put(String.format("ch%s.meta", i), "piāo liú");
        map.put("en" + i, "Rafting");
        map.put("ru" + i, "Рафтинг");
        i++;

        map.put("ch" + i, "皮划艇");
        map.put(String.format("ch%s.meta", i), "pí huá tǐng");
        map.put("en" + i, "Kayaking");
        map.put("ru" + i, "Каякинг");
        i++;

        map.put("ch" + i, "摩托艇运动");
        map.put(String.format("ch%s.meta", i), "mó tuō tǐng yùn dòng");
        map.put("en" + i, "Motorboat sport");
        map.put("ru" + i, "Водно-моторный спорт");
        i++;

        map.put("ch" + i, "现代冬季两项");
        map.put(String.format("ch%s.meta", i), "xiàn dài dōng jì liǎng xiàng");
        map.put("en" + i, "Biathlon");
        map.put("ru" + i, "Биатлон");
        i++;

        map.put("ch" + i, "冰壶");
        map.put(String.format("ch%s.meta", i), "bīng hú");
        map.put("en" + i, "Curling");
        map.put("ru" + i, "Кёрлинг");
        i++;

        map.put("ch" + i, "冰球");
        map.put(String.format("ch%s.meta", i), "bīng qiú");
        map.put("en" + i, "Ice hockey");
        map.put("ru" + i, "Хоккей");
        i++;

        map.put("ch" + i, "雪橇");
        map.put(String.format("ch%s.meta", i), "xuě qiāo");
        map.put("en" + i, "Sled");
        map.put("ru" + i, "Cанный спорт");
        i++;

        map.put("ch" + i, "雪橇");
        map.put(String.format("ch%s.meta", i), "xuě qiāo");
        map.put("en" + i, "Bobsleigh/ Bobsled");
        map.put("ru" + i, "Бобслей");
        i++;

        map.put("ch" + i, "无舵雪橇");
        map.put(String.format("ch%s.meta", i), "wú duò xuě qiāo");
        map.put("en" + i, "Luge");
        map.put("ru" + i, "Тобогган");
        i++;

        map.put("ch" + i, "钢架雪车");
        map.put(String.format("ch%s.meta", i), "gāng jià xuě chē");
        map.put("en" + i, "Skeleton");
        map.put("ru" + i, "Скелетон");
        i++;

        map.put("ch" + i, "花样滑冰");
        map.put(String.format("ch%s.meta", i), "huā yàng huá bīng");
        map.put("en" + i, "Figure skating");
        map.put("ru" + i, "Фигурное катание");
        i++;

        map.put("ch" + i, "速度滑冰");
        map.put(String.format("ch%s.meta", i), "sù dù huá bīng");
        map.put("en" + i, "Speed skating");
        map.put("ru" + i, "Конькобежный спорт");
        i++;

        map.put("ch" + i, "跳台滑雪");
        map.put(String.format("ch%s.meta", i), "tiào tái huá xuě");
        map.put("en" + i, "Ski jumping");
        map.put("ru" + i, "Прыжки на лыжах с трамплина");
        i++;

        map.put("ch" + i, "滑雪");
        map.put(String.format("ch%s.meta", i), "huá xuě");
        map.put("en" + i, "Skiing");
        map.put("ru" + i, "Лыжный спорт");
        i++;

        map.put("ch" + i, "单板滑雪");
        map.put(String.format("ch%s.meta", i), "dān bǎn huá xuě");
        map.put("en" + i, "Snowboarding");
        map.put("ru" + i, "Сноубординг");
        i++;

        map.put("ch" + i, "击剑");
        map.put(String.format("ch%s.meta", i), "jī  jiàn");
        map.put("en" + i, "Fencing");
        map.put("ru" + i, "Фехтование");
        i++;

        map.put("ch" + i, "花剑");
        map.put(String.format("ch%s.meta", i), "huā jiàn");
        map.put("en" + i, " Fencing foil");
        map.put("ru" + i, "Рапира");
        i++;

        map.put("ch" + i, "重剑");
        map.put(String.format("ch%s.meta", i), "zhòng jiàn");
        map.put("en" + i, "Court sword");
        map.put("ru" + i, "Шпага");
        i++;

        map.put("ch" + i, "健身");
        map.put(String.format("ch%s.meta", i), "jiàn shēn");
        map.put("en" + i, "Фитнес");
        map.put("ru" + i, "Fitness");
        i++;

        map.put("ch" + i, "奖杯");
        map.put(String.format("ch%s.meta", i), "jiǎng bēi");
        map.put("en" + i, "Trophy");
        map.put("ru" + i, "Кубок");
        i++;

        map.put("ch" + i, "金牌");
        map.put(String.format("ch%s.meta", i), "jīn pái");
        map.put("en" + i, "Golden medal");
        map.put("ru" + i, "Золотая медаль");
        i++;

        map.put("ch" + i, "银牌");
        map.put(String.format("ch%s.meta", i), "yín pái");
        map.put("en" + i, "Silver medal");
        map.put("ru" + i, "Серебряная медаль");
        i++;

        map.put("ch" + i, "铜牌");
        map.put(String.format("ch%s.meta", i), "tóng pái");
        map.put("en" + i, "Bronze medal");
        map.put("ru" + i, "Бронзовая медаль");

        return map;
    }

}