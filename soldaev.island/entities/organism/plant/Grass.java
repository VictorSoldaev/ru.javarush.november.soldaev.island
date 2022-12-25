package entities.organism.plant;

import setting.BaseStatsUnit;


public class Grass extends Plant {
    private float hp;

    public Grass() {
        super(BaseStatsUnit.STATS_BASE_GRASS);
        this.hp = BaseStatsUnit.STATS_BASE_CATERPILLAR.weight;
    }
}
