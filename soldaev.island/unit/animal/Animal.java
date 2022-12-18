package unit.animal;


import location.Earth;
import setting.BaseStatsUnit;
import unit.Organizm;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public abstract class Animal extends Organizm {
    protected final BaseStatsUnit baseStatsUnit;

    protected Animal(BaseStatsUnit baseStatsUnit){
        this.baseStatsUnit = baseStatsUnit;
    }

    public abstract void eat(int x, int y , Earth earth);

    public void move(int x, int y , Earth earth){
        for (int i = 0; i < 5; i++) {
            int xmove = x + ThreadLocalRandom.current().nextInt(0, baseStatsUnit.speed);
            int ymove = y + ThreadLocalRandom.current().nextInt(0, baseStatsUnit.speed);
            if (earth.add(this, xmove, ymove)) {
                earth.getArrayListAnimals(x, y).remove(this);
                break;
            }
        }
    };

    public abstract Animal multiply(int x, int y , Earth earth);



}
