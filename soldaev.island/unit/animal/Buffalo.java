package unit.animal;

import location.Earth;
import setting.BaseStatsUnit;
import java.util.concurrent.ThreadLocalRandom;

public class Buffalo extends Animal implements Herbivore {
    private float satiety;
    private float hp;

    public Buffalo() {
        super(BaseStatsUnit.STATS_BASE_BUFFALO);
        this.satiety = BaseStatsUnit.STATS_BASE_BUFFALO.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_BUFFALO.weight;
    }

    @Override
    public void eat(int x, int y, Earth earth) {
        float r = lookingForGrass(x, y, earth);
        if (r == 0) {
            satiety =(float) (satiety - BaseStatsUnit.STATS_BASE_BUFFALO.satiety * 0.5);
            if (satiety <= 0) {
                hp = (float) (hp - BaseStatsUnit.STATS_BASE_BUFFALO.weight * 0.5);
                if (hp <= 0) {
                    earth.remove(this, x, y);
                }
            }
        } else if (satiety + r > BaseStatsUnit.STATS_BASE_BUFFALO.satiety){
            satiety = BaseStatsUnit.STATS_BASE_BUFFALO.satiety;
        } else {
            satiety = satiety + r;
        }
    }


    @Override
    public void multiply(int x, int y, Earth earth) {
        if (earth.getArrayListAnimals(x, y).size() > 1) {
            earth.add(new Buffalo(), x, y);
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
