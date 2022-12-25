package entities.organism.animal.herbivore;

import entities.location.Island;
import setting.BaseStatsUnit;
import entities.organism.animal.Animal;

public class Buffalo extends Animal implements Herbivore {
    private float satiety;
    private float hp;

    public Buffalo() {
        super(BaseStatsUnit.STATS_BASE_BUFFALO);
        this.satiety = BaseStatsUnit.STATS_BASE_BUFFALO.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_BUFFALO.weight;
    }

    @Override
    public void eat(int x, int y, Island island) {
        float r = lookingForGrass(x, y, island);

        if (r == 0) {
            satiety = (float) (satiety - BaseStatsUnit.STATS_BASE_BUFFALO.satiety * 0.5);
            if (satiety <= 0) {
                hp = (float) (hp - BaseStatsUnit.STATS_BASE_BUFFALO.weight * 0.5);
                if (hp <= 0) {
                    island.removeOrganism(this, x, y);
                }
            }
        } else if (satiety + r > BaseStatsUnit.STATS_BASE_BUFFALO.satiety) {
            satiety = BaseStatsUnit.STATS_BASE_BUFFALO.satiety;
        } else {
            satiety = satiety + r;
        }
    }


    @Override
    public void multiply(int x, int y, Island island) {
        if (island.getPopulationOrganisms(x, y).size() > 1) {
            island.addOrganism(new Buffalo(), x, y);
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
