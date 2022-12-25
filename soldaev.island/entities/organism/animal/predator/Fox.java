package entities.organism.animal.predator;

import entities.location.Island;
import setting.BaseStatsUnit;
import entities.organism.animal.Animal;

public class Fox extends Animal implements Predator {
    private float satiety;
    private float hp;

    public Fox() {
        super(BaseStatsUnit.STATS_BASE_FOX);
        this.satiety = BaseStatsUnit.STATS_BASE_FOX.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_FOX.weight;
    }

    @Override
    public void eat(int x, int y, Island island) {
        float r = hunt(x, y, island);
        if (r == 0) {
            satiety = (float) (satiety - BaseStatsUnit.STATS_BASE_FOX.satiety * 0.2);
            if (satiety <= 0) {
                hp = (float) (hp - BaseStatsUnit.STATS_BASE_FOX.weight * 0.5);
                if (hp <= 0) {
                    island.removeOrganism(this, x, y);
                }
            }
        } else if (satiety + r > BaseStatsUnit.STATS_BASE_FOX.satiety) {
            satiety = BaseStatsUnit.STATS_BASE_FOX.satiety;
        } else {
            satiety = satiety + r;
        }
    }

    @Override
    public void multiply(int x, int y, Island island) {
        if (island.getPopulationOrganisms(x, y).size() > 1) {
            island.addOrganism(new Fox(), x, y);
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
