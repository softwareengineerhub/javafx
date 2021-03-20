package com.backend.api.repository.xml.content;

import com.backend.api.model.details.Details;

import java.util.ArrayList;
import java.util.List;

public class C9 {

    public List<Details> detailsList = new ArrayList<>();

    {
        Details details = new Details();
        details.setDescriptionA("冬天");
        details.setDescriptionB("dōng tiān");
        details.setDescriptionC("Winter");
        details.setDescriptionD("Зима");
        detailsList.add(details);
        details = new Details();
        details.setDescriptionA("春天");
        details.setDescriptionB("сhūn tiān");
        details.setDescriptionC("Spring");
        details.setDescriptionD("Весна");
        detailsList.add(details);
        details = new Details();
        details.setDescriptionA("夏天");
        details.setDescriptionB("xià tiān");
        details.setDescriptionC("Summer");
        details.setDescriptionD("Лето");
        detailsList.add(details);
        details = new Details();
        details.setDescriptionA("秋天");
        details.setDescriptionB("qiū tiān");
        details.setDescriptionC("Autumn/ Fall");
        details.setDescriptionD("Осень");
        detailsList.add(details);
    }

}
