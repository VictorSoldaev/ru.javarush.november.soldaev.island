package unit.animal;

import location.Earth;
import setting.BaseStatsUnit;
import unit.Organizm;

import java.util.ArrayList;

public class Goat extends Animal implements Herbivore{
    private float satiety;
    private float hp;

    public Goat() {
        super(BaseStatsUnit.STATS_BASE_GOAT);
        this.satiety = BaseStatsUnit.STATS_BASE_GOAT.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_GOAT.weight;
    }

    @Override
    public void eat(int x, int y, Earth earth) {

    }

    @Override
    public Animal multiply(int x, int y, Earth earth) {
        if (earth.getArrayListAnimals(x, y).size() > 1) {
            return new Goat();
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
