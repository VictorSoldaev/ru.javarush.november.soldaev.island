package entities.organism.animal;

import entities.location.Island;
import util.CoordinateHandler;
import setting.BaseStatsUnit;
import entities.organism.Organism;

public abstract class Animal extends Organism implements CoordinateHandler {
    public BaseStatsUnit getBaseStatsUnit() {
        return baseStatsUnit;
    }

    protected final BaseStatsUnit baseStatsUnit;

    protected Animal(BaseStatsUnit baseStatsUnit) {
        this.baseStatsUnit = baseStatsUnit;
    }

    public abstract void eat(int x, int y, Island island);

    public void move(int x, int y, Island island) {
        for (int i = 0; i < 5; i++) {
            if (island.addOrganism(this, getCoordinate(x, island.getMaxSizeIslandCoordinateX(), island.getMinSizeIslandX(), baseStatsUnit.speed),
                    getCoordinate(y, island.getMaxSizeIslandCoordinateY(), island.getMinSizeIslandY(), baseStatsUnit.speed))) {
                island.removeOrganism(this, x, y);
                break;
            }
        }
    }

    public abstract void multiply(int x, int y, Island island);

}
