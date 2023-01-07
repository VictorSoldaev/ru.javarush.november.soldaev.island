package entities.organism.plant;

import setting.BaseStatsUnit;
import entities.organism.Organism;
import setting.Setting;


public abstract class Plant extends Organism {
    protected BaseStatsUnit baseStatsUnit;

    public BaseStatsUnit getBaseStatsUnit() {
        return baseStatsUnit;
    }

    protected Plant() {
        this.baseStatsUnit = Setting.statsUnit.get(this.getClass().getSimpleName());
    }
}
