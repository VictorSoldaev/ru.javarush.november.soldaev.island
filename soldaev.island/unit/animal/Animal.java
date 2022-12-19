package unit.animal;

import location.Earth;
import servis.CoordinateHandler;
import setting.BaseStatsUnit;
import unit.Organizm;


public abstract class Animal extends Organizm implements CoordinateHandler {
    protected final BaseStatsUnit baseStatsUnit;

    protected Animal(BaseStatsUnit baseStatsUnit) {
        this.baseStatsUnit = baseStatsUnit;
    }

    public abstract void eat(int x, int y, Earth earth);

    public void move(int x, int y, Earth earth) {
        for (int i = 0; i < 5; i++) {
            if (earth.add(this, getCoordinateX(x, earth, baseStatsUnit.speed), getCoordinateY(y, earth, baseStatsUnit.speed))) {
                earth.getArrayListAnimals(x, y).remove(this);
                break;
            }
        }
    }

    public abstract Animal multiply(int x, int y, Earth earth);

}
