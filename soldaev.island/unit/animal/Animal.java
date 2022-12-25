package unit.animal;

import location.Earth;
import servis.CoordinateHandler;
import setting.BaseStatsUnit;
import unit.Organizm;


public abstract class Animal extends Organizm implements CoordinateHandler {
    public BaseStatsUnit getBaseStatsUnit() {
        return baseStatsUnit;
    }

    protected final BaseStatsUnit baseStatsUnit;

    protected Animal(BaseStatsUnit baseStatsUnit) {
        this.baseStatsUnit = baseStatsUnit;
    }

    public abstract void eat(int x, int y, Earth earth);


    public void move(int x, int y, Earth earth) {
        for (int i = 0; i < 5; i++) {
            if (earth.add(this, getCoordinate(x, earth.getMaxSizeIslendX(), earth.getMIN_SIZE_ISLEND_X(), baseStatsUnit.speed), getCoordinate(y, earth.getMaxSizeIslendY(), earth.getMIN_SIZE_ISLEND_Y(), baseStatsUnit.speed))) {
                earth.remove(this, x, y);
                break;
            }
        }
    }

    public abstract void multiply(int x, int y, Earth earth);

}
