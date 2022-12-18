package unit.animal;

import location.Earth;
import setting.BaseStatsUnit;

public class Duck extends Animal implements Herbivore, Predator{
    private float satiety;
    private float hp;

    public Duck() {
        super(BaseStatsUnit.STATS_BASE_DUCK);
        this.satiety = BaseStatsUnit.STATS_BASE_DUCK.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_DUCK.weight;
    }

    @Override
    public void eat(int x, int y, Earth earth) {

    }

    @Override
    public Animal multiply(int x, int y, Earth earth) {
        if (earth.getArrayListAnimals(x, y).size() > 1) {
            return new Duck();
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
