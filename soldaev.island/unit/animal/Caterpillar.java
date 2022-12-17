package unit.animal;

import setting.BaseStatsUnit;


public class Caterpillar extends Animal {
    private float satiety;
    private float hp;

    public Caterpillar(){
        this.satiety = BaseStatsUnit.STATS_BASE_BEAR.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_BEAR.weight;
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
