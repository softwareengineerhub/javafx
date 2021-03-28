package com.example.utils;

public class CategoriesReader {
    private static final CategoriesModel[] res = new CategoriesModel[89];

    static {
        int i=0;
        res[i++] = new CategoriesModel("家庭", "jiā tíng", "Family", "Семья");
        res[i++] = new CategoriesModel("银行", "yín háng", "Bank", "Банк");
        res[i++] = new CategoriesModel("面部", "miàn bù", "Face", "Лицо");
        res[i++] = new CategoriesModel("数字", "shù zì", "Numbers", "Цифры");
        res[i++] = new CategoriesModel("人生大事", "rén shēng dà shì", "Life events", "События жизни");
        res[i++] = new CategoriesModel("坚果和种子", "jiān guǒ hé zhǒng zǐ", "Nuts And Seeds", "Орехи и семена");
        res[i++] = new CategoriesModel("运动", "yùn dòng", "Sport", "Спорт");
        res[i++] = new CategoriesModel("含酒精的饮料", "hán jiǔ jīng de yǐn liào", "Alcoholic drinks", "Алкогольные напитки");
        res[i++] = new CategoriesModel("马术", "mǎ shù", "Horse riding", "Верховая езда");
        res[i++] = new CategoriesModel("四季", "sì jì", "Seasons", "Времена года");
        res[i++] = new CategoriesModel("蘑菇", "mó gū", "Mushrooms", "Грибы");
        res[i++] = new CategoriesModel("动物", "dòng wù", "Animals", "Животные");
        res[i++] = new CategoriesModel("谷物和豆类", "gǔ wù hé dòu lèi", "Grains and beans", "Зерна и бобы");
        res[i++] = new CategoriesModel("毒浆果", "dú jiāng guǒ", "Poison berry", "Ядовитые ягоды");
        res[i++] = new CategoriesModel("浆果", "jiāng guǒ", "Berries", "Ягоды");
        res[i++] = new CategoriesModel("自然现象", "zì rán xiàn xiàng", "Natural phenomena", "Явления природы");
        res[i++] = new CategoriesModel("情感", "qíng gǎn", "Emotions", "Эмоции");
        res[i++] = new CategoriesModel("学校", "xué xiào", "School", "Школа");
        res[i++] = new CategoriesModel("蛋", "dàn", "Eggs", "Яйца");
        res[i++] = new CategoriesModel("颜色", "yán sè", "Colors", "Цвета");
        res[i++] = new CategoriesModel("方向和位置", "fāng xiàng hé wèi", "Sides", "Стороны");
        res[i++] = new CategoriesModel("柑橘类水果", "gān jú lèi shuǐ guǒ", "Citrus Fruit", "Цитрусовые фрукты");
        res[i++] = new CategoriesModel("酱", "jiàng", "Sauces", "Соусы");
        res[i++] = new CategoriesModel("卧室_家具", "wò shì_jiā jù", "Bedroom_Furniture", "Спальня_Мебель");
        res[i++] = new CategoriesModel("爬行动物", "pá xíng dòng wù", "Reptiles", "Рептилии/Пресмыкающиеся");
        res[i++] = new CategoriesModel("鸭子类", "yā zi lèi", "Ducks", "Семейство «Утиные»");
        res[i++] = new CategoriesModel("香草", "xiāng cǎo", "Herbs", "Пряные травы");
        res[i++] = new CategoriesModel("节日", "jié rì", "Celebrations", "Праздники");
        res[i++] = new CategoriesModel("天气", "tiān qì", "Weather", "Погода");
        res[i++] = new CategoriesModel("常用短语", "cháng yòng duǎn yǔ", "Basic phrases", "Основные фразы");
        res[i++] = new CategoriesModel("职业", "zhí yè", "Occupations", "Профессии");
        res[i++] = new CategoriesModel("蔬菜", "shū cài", "Vegetables", "Овощи");
        res[i++] = new CategoriesModel("昆虫", "Insects", "kūn chóng", "Насекомые");
        res[i++] = new CategoriesModel("ruǎn yǐn liào", "软饮料", "Soft drinks", "Безалкогольные напитки");
        res[i++] = new CategoriesModel("肉", "ròu", "Meat", "Мясо");
        res[i++] = new CategoriesModel("海鲜", "hǎi xiān", "Seafood", "Морепродукты");
        res[i++] = new CategoriesModel("奶制品", "nǎi zhì pǐn", "Milk products", "Молочные продукты");
        res[i++] = new CategoriesModel("软体动物", "ruǎn tǐ dòng wù", "Molluscs", "Моллюски");
        res[i++] = new CategoriesModel("油", "yóu", "Oil", "Масло");
        res[i++] = new CategoriesModel("首饰", "shǒu shì", "Jewellery", "Драгоценности");
        res[i++] = new CategoriesModel("女装", "nǚ zhuāng", "Women's clothing", "Женская одежда");
        res[i++] = new CategoriesModel("家用电器", "jiā yòng diàn qì", "Household electric appliance", "Домашняя техника");
        res[i++] = new CategoriesModel("代词", "dài cí", "Pronouns", "Местоимения");
        res[i++] = new CategoriesModel("狗", "gǒu", "Dogs", "Собаки");
        res[i++] = new CategoriesModel("鸟类", "niǎo lèi", "Birds", "Птицы");
        res[i++] = new CategoriesModel("交通工具", "jiāo tōng gōng jù", "Transport", "Транспорт");
        res[i++] = new CategoriesModel("猫的品种", "māo de pǐnzhǒng", "Сat breeds", "Породы кошек");
        res[i++] = new CategoriesModel("游戏", "yóu xì", "Games", "Игры");
        res[i++] = new CategoriesModel("儿童乐园", "ér tóng lè yuán", "Children's playground", "Детская площадка");
        res[i++] = new CategoriesModel("男装", "nán zhuāng", "Men’s clothing", "Мужская одежда");
        res[i++] = new CategoriesModel("电话", "diàn huà", "Telephone", "Телефон");
        res[i++] = new CategoriesModel("身体", "shēn tǐ", "Body", "Тело");
        res[i++] = new CategoriesModel("感觉", "gǎn jué", "Feelings", "Основные чувства человека");
        res[i++] = new CategoriesModel("大自然", "dà zì rán", "Nature", "Природа");
        res[i++] = new CategoriesModel("分娩", "fēn miǎn", "Childbirth", "Роджение ребенка");
        res[i++] = new CategoriesModel("替代疗法", "tì dài liáo fǎ", "Alternative therapy", "Нетрадиционная медицина");
        res[i++] = new CategoriesModel("疾病", "jí bìng", "Illness", "Болезни");
        res[i++] = new CategoriesModel("店铺", "diàn pù", "Shops", "Магазины");
        res[i++] = new CategoriesModel("城市", "chéng shì", "City", "Город");
        res[i++] = new CategoriesModel("乐器", "yuè qì", "Musical instruments", "Музыкальные инструменты");
        res[i++] = new CategoriesModel("鲜花", "xiān huā", "Flowers", "Цветы");
        res[i++] = new CategoriesModel("浴室", "yù shì", "Bathroom", "Ванная комната");
        res[i++] = new CategoriesModel("月份", "yuè fèn", "Months of the year", "Месяцы года");
        res[i++] = new CategoriesModel("俄语字母", "é yǔ zì mǔ", "Russian alphabet", "Русский алфавит");
        res[i++] = new CategoriesModel("树", "shù", "Trees", "Деревья");
        res[i++] = new CategoriesModel("音乐风格", "yīn yuè fēng gé", "Music styles", "Музыкальные стили");
        res[i++] = new CategoriesModel("蛋糕和甜点", "dàn gāo hé tián diǎn", "Cakes and Desserts", "Торты и десерты");
        res[i++] = new CategoriesModel("厨房", "chú fáng", "Kitchen", "Кухня");
        res[i++] = new CategoriesModel("几何形状", "jǐ hé xíng zhuàng", "Geometric figures", "Геометрические фигуры");
        res[i++] = new CategoriesModel("宗教", "zōng jiào", "Religion", "Религии");
        res[i++] = new CategoriesModel("早餐", "zǎo cān", "Breakfast", "Завтрак");
        res[i++] = new CategoriesModel("旅行", "lǚ xíng", "Travel", "Путешествие");
        res[i++] = new CategoriesModel("休息", "xiū xí", "Recreation", "Отдых");
        res[i++] = new CategoriesModel("大学", "dà xué", "University", "Университет");
        res[i++] = new CategoriesModel("超市", "chāo shì", "Supermarket", "Супермаркет");
        res[i++] = new CategoriesModel("厨具", "chú jù", "Kitchenware", "Кухонные приборы");
        res[i++] = new CategoriesModel("开车", "kāi chē", "Drive a car", "Водить машину");
        res[i++] = new CategoriesModel("100个动词", "100 gè dòng cí", "100 verbs", "100 глаголов");
        res[i++] = new CategoriesModel("化妆品", "huà zhuāng pǐn", "Cosmetics", "Косметика");
        res[i++] = new CategoriesModel("海滩", "hǎi tān", "Beach", "Пляж");
        res[i++] = new CategoriesModel("鲨鱼类", "shā yú lèi", "Sharks", "Акулы");
        res[i++] = new CategoriesModel("鱼类", "yú lèi", "Fishes", "Рыбы");
        res[i++] = new CategoriesModel("烹饪", "pēng rèn", "Cooking", "Готовить");
        res[i++] = new CategoriesModel("水果", "shuǐ guǒ", "Fruits", "Фрукты");
        res[i++] = new CategoriesModel("tóng zhuāng", "童装", "Children’s clothing", "Детская одежда");
        res[i++] = new CategoriesModel("jiā chù jiā qín", "家畜家禽", "Domestic animal", "Домашние животные");
        res[i++] = new CategoriesModel("xīng qī", "星期", "Days of the week", "Дни недели");
        res[i++] = new CategoriesModel("rén jì guān xì", "人际关系", "Relationships", "Отношения");
        res[i++] = new CategoriesModel("kuài cān", "快餐", "Fast Food", "Фаст фуд (Блюда)");

    }

    //String ch, String chMeta, String eng, String ru) {
    public static CategoriesModel[] readAllCategories(){
        return res;
    }



}
