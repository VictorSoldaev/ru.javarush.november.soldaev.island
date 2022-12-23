package unit.animal;

import location.Earth;
import setting.BaseStatsUnit;

public class Bear extends Animal implements Predator {

    private float satiety;
    private float hp;

    public Bear() {
        super(BaseStatsUnit.STATS_BASE_BEAR);
        this.satiety = BaseStatsUnit.STATS_BASE_BEAR.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_BEAR.weight;
    }

    @Override
    public void eat(int x, int y, Earth earth) {
        float r = hunt(x, y, earth);
        if (r == 0) {
            satiety =(float) (satiety - BaseStatsUnit.STATS_BASE_BEAR.satiety * 0.5);
            if (satiety <= 0) {
                hp = (float) (hp - BaseStatsUnit.STATS_BASE_BEAR.weight * 0.5);
                if (hp <= 0) {
                    earth.remove(this, x, y);
                }
            }
        } else if (satiety + r > BaseStatsUnit.STATS_BASE_BEAR.satiety){
            satiety = BaseStatsUnit.STATS_BASE_BEAR.satiety;
        } else {
            satiety = satiety + r;
        }
    }

    @Override
    public void multiply(int x, int y, Earth earth) {
        if (earth.getArrayListAnimals(x, y).size() > 1) {
            earth.add(new Bear(), x, y);
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
