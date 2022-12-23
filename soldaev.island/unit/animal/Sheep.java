package unit.animal;

import location.Earth;
import setting.BaseStatsUnit;

public class Sheep extends Animal implements Herbivore{
    private float satiety;
    private float hp;

    public Sheep() {
        super(BaseStatsUnit.STATS_BASE_SHEEP);
        this.satiety = BaseStatsUnit.STATS_BASE_SHEEP.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_SHEEP.weight;
    }

    @Override
    public void eat(int x, int y, Earth earth) {
        float r = lookingForGrass(x, y, earth);
        if (r == 0) {
            satiety =(float) (satiety - BaseStatsUnit.STATS_BASE_SHEEP.satiety * 0.5);
            if (satiety <= 0) {
                hp = (float) (hp - BaseStatsUnit.STATS_BASE_SHEEP.weight * 0.5);
                if (hp <= 0) {
                    earth.remove(this, x, y);
                }
            }
        } else if (satiety + r > BaseStatsUnit.STATS_BASE_SHEEP.satiety){
            satiety = BaseStatsUnit.STATS_BASE_SHEEP.satiety;
        } else {
            satiety = satiety + r;
        }
    }

    @Override
    public void multiply(int x, int y, Earth earth) {
        if (earth.getArrayListAnimals(x, y).size() > 1) {
            earth.add(new Sheep(), x, y);
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
