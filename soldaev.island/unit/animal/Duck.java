package unit.animal;

import location.Earth;
import setting.BaseStatsUnit;

public class Duck extends Animal implements Herbivore {
    private float satiety;
    private float hp;

    public Duck() {
        super(BaseStatsUnit.STATS_BASE_DUCK);
        this.satiety = BaseStatsUnit.STATS_BASE_DUCK.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_DUCK.weight;
    }

    @Override
    public void eat(int x, int y, Earth earth) {
        float r = lookingForGrass(x, y, earth);
        if (r == 0) {
            satiety =(float) (satiety - BaseStatsUnit.STATS_BASE_DUCK.satiety * 0.5);
            if (satiety <= 0) {
                hp = (float) (hp - BaseStatsUnit.STATS_BASE_DUCK.weight * 0.5);
                if (hp <= 0) {
                    earth.remove(this, x, y);
                }
            }
        } else if (satiety + r > BaseStatsUnit.STATS_BASE_DUCK.satiety){
            satiety = BaseStatsUnit.STATS_BASE_DUCK.satiety;
        } else {
            satiety = satiety + r;
        }
    }

    @Override
    public void multiply(int x, int y, Earth earth) {
        if (earth.getArrayListAnimals(x, y).size() > 1) {
            earth.add(new Duck(), x, y);
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
