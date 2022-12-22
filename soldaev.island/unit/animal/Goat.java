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
        float r = lookingForGrass(x, y, earth);
        if (r == 0) {
            satiety =(float) (satiety - BaseStatsUnit.STATS_BASE_GOAT.satiety * 0.1);
            if (satiety <= 0) {
                hp = (float) (hp - hp * 0.1);
                if (hp <= 0) {
                    earth.remove(this, x, y);
                }
            }
        } else if (r > BaseStatsUnit.STATS_BASE_GOAT.satiety){
            satiety = BaseStatsUnit.STATS_BASE_GOAT.satiety;
        } else {
            satiety = satiety + r;
        }
    }

    @Override
    public void multiply(int x, int y, Earth earth) {
        if (earth.getArrayListAnimals(x, y).size() > 1) {
            earth.add(new Goat(), x, y);
        }
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
