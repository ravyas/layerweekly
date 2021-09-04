package com.layer.domain;

import java.util.ArrayList;
import java.util.List;

public class LayerWeeklyMagazine extends Entity {

    private List<WeeklyEdition> editions = new ArrayList<>();

    public List<WeeklyEdition> getEditions() {
        return editions;
    }

    public void setEditions(List<WeeklyEdition> editions) {
        this.editions = editions;
    }
}
