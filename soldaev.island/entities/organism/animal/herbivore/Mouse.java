package entities.organism.animal.herbivore;


import entities.location.Island;
import setting.BaseStatsUnit;
import entities.organism.Organism;
import entities.organism.animal.Animal;
import entities.organism.animal.predator.Predator;

import java.util.ArrayList;

public class Mouse extends Animal implements Herbivore, Predator {
    private float satiety;
    private float hp;

    public Mouse() {
        super(BaseStatsUnit.STATS_BASE_MOUSE);
        this.satiety = BaseStatsUnit.STATS_BASE_MOUSE.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_MOUSE.weight;
    }

    @Override
    public boolean searchFood(ArrayList<Organism> stepFood) {
        if (stepFood.size() == 0) {
            return false;
        } else if (stepFood.get(0).getClass().getSimpleName().equals("Caterpillar")) {
            return true;
        }
        return false;
    }

    @Override
    public void eat(int x, int y, Island island) {
        float r = lookingForGrass(x, y, island);
        if (r == 0) {
            r = hunt(x, y, island);
        }
        if (r == 0) {
            satiety = (float) (satiety - BaseStatsUnit.STATS_BASE_MOUSE.satiety * 0.5);
            if (satiety <= 0) {
                hp = (float) (hp - BaseStatsUnit.STATS_BASE_MOUSE.weight * 0.5);
                if (hp <= 0) {
                    island.removeOrganism(this, x, y);
                }
            }
        } else if (satiety + r > BaseStatsUnit.STATS_BASE_MOUSE.satiety) {
            satiety = BaseStatsUnit.STATS_BASE_MOUSE.satiety;
        } else {
            satiety = satiety + r;
        }
    }

    @Override
    public void multiply(int x, int y, Island island) {
        if (island.getPopulationOrganisms(x, y).size() > 1) {
            island.addOrganism(new Mouse(), x, y);
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
