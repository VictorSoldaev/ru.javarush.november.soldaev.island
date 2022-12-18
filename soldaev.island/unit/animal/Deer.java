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
        this.satiety = BaseStatsUnit.STATS_BASE_DEER.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_DEER.weight;
    }

    @Override
    public void eat(int x, int y, Earth earth) {

    }

    @Override
    public void move(int x, int y, Earth earth) {
        for (int i = 0; i < 5; i++) {
            int xmove = x + ThreadLocalRandom.current().nextInt(0, BaseStatsUnit.STATS_BASE_DEER.speed);
            int ymove = y + ThreadLocalRandom.current().nextInt(0, BaseStatsUnit.STATS_BASE_DEER.speed);
            if (earth.add(this, xmove, ymove)) {
                earth.getArrayListAnimals(x, y).remove(this);
                break;
            }
        }
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
