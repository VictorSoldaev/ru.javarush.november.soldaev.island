package unit.animal;

import location.Earth;
import setting.BaseStatsUnit;
import unit.Organizm;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Deer extends Animal implements Herbivore{
    private float satiety;
    private float hp;

    public Deer() {
        super(BaseStatsUnit.STATS_BASE_DEER);
        this.satiety = BaseStatsUnit.STATS_BASE_DEER.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_DEER.weight;
    }

    @Override
    public void eat(int x, int y, Earth earth) {

    }

    @Override
    public Animal multiply(int x, int y, Earth earth) {
        if (earth.getArrayListAnimals(x, y).size() > 1) {
            return new Deer();
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
