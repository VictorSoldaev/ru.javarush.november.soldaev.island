package unit.plant;

import setting.BaseStatsUnit;
import unit.Organizm;

public abstract class Plant extends Organizm {
    public BaseStatsUnit getBaseStatsUnit() {
        return baseStatsUnit;
    }

    protected final BaseStatsUnit baseStatsUnit;

    protected Plant(BaseStatsUnit baseStatsUnit) {
        this.baseStatsUnit = baseStatsUnit;
    }
}
