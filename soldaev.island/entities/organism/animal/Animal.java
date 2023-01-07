package entities.organism.animal;

import entities.location.Location;
import setting.Setting;
import util.CoordinateHandler;
import setting.BaseStatsUnit;
import entities.organism.Organism;

public abstract class Animal extends Organism implements CoordinateHandler {
    protected BaseStatsUnit baseStatsUnit;

    public BaseStatsUnit getBaseStatsUnit() {
        return baseStatsUnit = Setting.statsUnit.get(this.getClass().getSimpleName());
    }

    protected Animal() {
        this.baseStatsUnit = Setting.statsUnit.get(this.getClass().getSimpleName());
    }

    public abstract void eat(int x, int y, Location island);

    public void move(int x, int y, Location island) {
        island.getLock().lock();
        try {
            for (int i = 0; i < 5; i++) {
                if (island.addOrganism(this, getCoordinate(x, island.getMaxSizeIslandCoordinateX(), island.getMinSizeIslandX(), baseStatsUnit.speed),
                        getCoordinate(y, island.getMaxSizeIslandCoordinateY(), island.getMinSizeIslandY(), baseStatsUnit.speed))) {
                    island.removeOrganism(this, x, y);
                    break;
                }
            }
        } finally {
            island.getLock().unlock();
        }
    }

    public abstract void multiply(int x, int y, Location island);

    public abstract void oldAge(int x, int y, Location island);
}
