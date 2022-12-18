package unit.animal;


import location.Earth;
import setting.BaseStatsUnit;
import unit.Organizm;

import java.util.ArrayList;

public class Python extends Animal implements Predator{
    private float satiety;
    private float hp;

    public Python() {
        super(BaseStatsUnit.STATS_BASE_PYTHON);
        this.satiety = BaseStatsUnit.STATS_BASE_PYTHON.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_PYTHON.weight;
    }

    @Override
    public void eat(int x, int y, Earth earth) {
        satiety = satiety + hunt(x, y, earth) > 0 ? hunt(x, y, earth) : -1;
    }

    @Override
    public Animal multiply(int x, int y, Earth earth) {
        if (earth.getArrayListAnimals(x, y).size() > 1) {
            return new Fox();
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
