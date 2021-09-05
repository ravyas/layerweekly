package io.layer.weekly.service;

import io.layer.weekly.dao.LayerWeeklyMagazineRepository;
import io.layer.weekly.domain.WeeklyEdition;

public class LayerWeeklyMagazineService {

    private LayerWeeklyMagazineRepository layerWeeklyMagazineRepository;

    public LayerWeeklyMagazineService(LayerWeeklyMagazineRepository layerWeeklyMagazineRepository) {
        this.layerWeeklyMagazineRepository = layerWeeklyMagazineRepository;
    }

    public WeeklyEdition currentEdition() {
        return layerWeeklyMagazineRepository.layerWeeklyMagazine().currentEdition();
    }

    public WeeklyEdition kickOffNewEdition() {
        return layerWeeklyMagazineRepository.layerWeeklyMagazine().kickOffNewEdition();
    }
}
