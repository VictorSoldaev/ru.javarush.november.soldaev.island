package unit.animal;

import setting.BaseStatsUnit;
import unit.Organizm;

public class Mouse extends Animal{
    private float satiety;
    private float hp;

    public Mouse(){
        this.satiety = BaseStatsUnit.STATS_BASE_MOUSE.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_MOUSE.weight;
    }

    @Override
    public void toEat(Animal organizm) {

    }

    @Override
    public void move() {
        super.move();
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
