package io.layer.weekly.dao;

import io.layer.weekly.domain.WeeklyEdition;

import java.util.ArrayList;
import java.util.List;

public class WeeklyEditionRepository {

    private List<WeeklyEdition> inMemoryWeeklyEditions = new ArrayList<>();

    public void saveWeeklyEdition(WeeklyEdition weeklyEdition) {
        inMemoryWeeklyEditions.add(weeklyEdition);
    }

    public WeeklyEdition getWeeklyEditionById(String id) {
        return inMemoryWeeklyEditions.stream().filter(w -> w.getId().equals(id)).findFirst().orElseThrow();
    }

}
