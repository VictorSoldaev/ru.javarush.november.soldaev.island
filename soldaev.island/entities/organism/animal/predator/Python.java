package entities.organism.animal.predator;


import entities.location.Island;
import setting.BaseStatsUnit;
import entities.organism.Organism;
import entities.organism.animal.Animal;

import java.util.ArrayList;

public class Python extends Animal implements Predator {
    private float satiety;
    private float hp;

    public Python() {
        super(BaseStatsUnit.STATS_BASE_PYTHON);
        this.satiety = BaseStatsUnit.STATS_BASE_PYTHON.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_PYTHON.weight;
    }

    @Override
    public boolean searchFood(ArrayList<Organism> stepFood) {
        if (stepFood.size() == 0) {
            return false;
        } else if (stepFood.get(0).getClass().getSimpleName().equals("Grass")) {
            return false;
        } else if (stepFood.get(0).getClass().getSimpleName().equals("Fox")) {
            return true;
        } else {
            Class<?>[] interfaces = stepFood.get(0).getClass().getInterfaces();
            for (Class c : interfaces) {
                String g = c.getSimpleName();
                if (g.equals("Herbivore")) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void eat(int x, int y, Island island) {
        float r = hunt(x, y, island);
        if (r == 0) {
            satiety = (float) (satiety - BaseStatsUnit.STATS_BASE_PYTHON.satiety * 0.2);
            if (satiety <= 0) {
                hp = (float) (hp - BaseStatsUnit.STATS_BASE_PYTHON.weight * 0.5);
                if (hp <= 0) {
                    island.removeOrganism(this, x, y);

                }
            }
        } else if (satiety + r > BaseStatsUnit.STATS_BASE_PYTHON.satiety) {
            satiety = BaseStatsUnit.STATS_BASE_PYTHON.satiety;
        } else {
            satiety = satiety + r;
        }
    }

    @Override
    public void multiply(int x, int y, Island island) {
        if (island.getPopulationOrganisms(x, y).size() > 1) {
            island.addOrganism(new Python(), x, y);
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
