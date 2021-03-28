package com.backend.api.repository.xml.content;

import com.backend.api.model.details.Details;

import java.util.ArrayList;
import java.util.List;

public class C52 {

    public List<Details> detailsList = new ArrayList<>();

    {
        Details details = new Details();
        details.setDescriptionA(" shì jué");
        details.setDescriptionB("视觉");
        details.setDescriptionC("Sight");
        details.setDescriptionD("Зрение");
        detailsList.add(details);
        details = new Details();
        details.setDescriptionA("tīng lì");
        details.setDescriptionB("听力");
        details.setDescriptionC("Hearing");
        details.setDescriptionD("Слух");
        detailsList.add(details);
        details = new Details();
        details.setDescriptionA(" chù jué ");
        details.setDescriptionB("触觉");
        details.setDescriptionC("Touch");
        details.setDescriptionD("Осязание");
        detailsList.add(details);
        details = new Details();
        details.setDescriptionA(" xiù jué ");
        details.setDescriptionB("嗅觉");
        details.setDescriptionC("Smell");
        details.setDescriptionD("Обоняние");
        detailsList.add(details);
        details = new Details();
        details.setDescriptionA("wèi jué");
        details.setDescriptionB("味觉");
        details.setDescriptionC("Taste");
        details.setDescriptionD("Вкус");
        detailsList.add(details);

    }
}
