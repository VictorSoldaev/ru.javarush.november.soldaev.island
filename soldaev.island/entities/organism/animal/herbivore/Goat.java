package entities.organism.animal.herbivore;

import entities.location.Island;
import setting.BaseStatsUnit;
import entities.organism.animal.Animal;


public class Goat extends Animal implements Herbivore {
    private float satiety;
    private float hp;

    public Goat() {
        super(BaseStatsUnit.STATS_BASE_GOAT);
        this.satiety = BaseStatsUnit.STATS_BASE_GOAT.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_GOAT.weight;
    }

    @Override
    public void eat(int x, int y, Island island) {
        float r = lookingForGrass(x, y, island);
        if (r == 0) {
            satiety = (float) (satiety - BaseStatsUnit.STATS_BASE_GOAT.satiety * 0.5);
            if (satiety <= 0) {
                hp = (float) (hp - BaseStatsUnit.STATS_BASE_GOAT.weight * 0.3);
                if (hp <= 0) {
                    island.removeOrganism(this, x, y);
                }
            }
        } else if (satiety + r > BaseStatsUnit.STATS_BASE_GOAT.satiety) {
            satiety = BaseStatsUnit.STATS_BASE_GOAT.satiety;
        } else {
            satiety = satiety + r;
        }
    }

    @Override
    public void multiply(int x, int y, Island island) {
        if (island.getPopulationOrganisms(x, y).size() > 1) {
            island.addOrganism(new Goat(), x, y);
        }
    }
    public void oldAge(int x, int y, Island island) {
        hp = (float) (hp - BaseStatsUnit.STATS_BASE_GOAT.weight * 0.2);
        if (hp <= 0) {
            island.removeOrganism(this, x, y);
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
