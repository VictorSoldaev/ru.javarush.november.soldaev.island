package unit.animal;


import setting.BaseStatsUnit;

public class Duck extends Animal{
    private float satiety;
    private float hp;

    public Duck(){
        this.satiety = BaseStatsUnit.STATS_BASE_DUCK.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_DUCK.weight;
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
