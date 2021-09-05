package io.layer.weekly.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LayerWeeklyMagazine extends Entity {

    private List<WeeklyEdition> editions = new ArrayList<>();

    public LayerWeeklyMagazine() {
        this.setId(UUID.randomUUID().toString());
    }

    public WeeklyEdition kickOffNewEdition() {
        WeeklyEdition newWeeklyEdition = new WeeklyEdition();
        newWeeklyEdition.setCurrentEdition(true);
        editions.add(newWeeklyEdition);
        return newWeeklyEdition;
    }

    public WeeklyEdition currentEdition() {
        return editions.stream().filter(WeeklyEdition::isCurrentEdition).findFirst().orElseThrow();
    }

    public List<WeeklyEdition> getEditions() {
        return editions;
    }

    public void setEditions(List<WeeklyEdition> editions) {
        this.editions = editions;
    }
}
