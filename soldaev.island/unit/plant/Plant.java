package unit.plant;

import setting.BaseStatsUnit;
import unit.Organizm;

public abstract class Plant extends Organizm {
    protected final BaseStatsUnit baseStatsUnit;

    protected Plant(BaseStatsUnit baseStatsUnit) {
        this.baseStatsUnit = baseStatsUnit;
    }
}
