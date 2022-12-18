package unit.animal;

import location.Earth;
import setting.BaseStatsUnit;
import unit.Organizm;
import java.util.ArrayList;


public class Horse extends Animal implements Herbivore{
    private float satiety;
    private float hp;

    public Horse() {
        super(BaseStatsUnit.STATS_BASE_HORSE);
        this.satiety = BaseStatsUnit.STATS_BASE_HORSE.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_HORSE.weight;
    }

    @Override
    public void eat(int x, int y, Earth earth) {

    }

    @Override
    public Animal multiply(int x, int y, Earth earth) {
        if (earth.getArrayListAnimals(x, y).size() > 1) {
            return new Horse();
        }
        return null;
    }


    public float getSatiety() {
        return satiety;
    }

    public void setSatiety(float satiety) {
        this.satiety = satiety;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }
}
