package unit.animal;

import location.Earth;
import setting.BaseStatsUnit;
import unit.Organizm;
import java.util.ArrayList;


public class Horse extends Animal implements Herbivore{
    private float satiety;
    private float hp;

    public Horse() {
        this.satiety = BaseStatsUnit.STATS_BASE_HORSE.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_HORSE.weight;
    }


    @Override
    public void eat(int x, int y, Earth earth) {

    }

    @Override
    public void move() {

    }

    @Override
    public Animal multiply() {
        return new Horse();
    }


}
