package entities.organism.plant;

import setting.BaseStatsUnit;
import entities.organism.Organism;


public abstract class Plant extends Organism {
    public BaseStatsUnit getBaseStatsUnit() {
        return baseStatsUnit;
    }

    protected final BaseStatsUnit baseStatsUnit;

    protected Plant(BaseStatsUnit baseStatsUnit) {
        this.baseStatsUnit = baseStatsUnit;
    }
}
