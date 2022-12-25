package unit.animal;

import location.Earth;
import setting.BaseStatsUnit;
import java.util.concurrent.ThreadLocalRandom;


public class Caterpillar extends Animal implements Herbivore{
    private float satiety;
    private float hp;

    public Caterpillar() {
        super(BaseStatsUnit.STATS_BASE_CATERPILLAR);
        this.satiety = BaseStatsUnit.STATS_BASE_CATERPILLAR.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_CATERPILLAR.weight;
    }

    @Override
    public void eat(int x, int y, Earth earth) {
    }

    @Override
    public void multiply(int x, int y, Earth earth) {
        if (earth.getArrayListAnimals(x, y).size() > 1) {
            earth.add(new Caterpillar(), x, y);
        }
    }

    @Override
    public void move(int x, int y, Earth earth) {
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
