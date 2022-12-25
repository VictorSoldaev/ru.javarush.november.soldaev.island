package entities.organism.animal.herbivore;

import entities.location.Island;
import setting.BaseStatsUnit;
import entities.organism.animal.Animal;


public class Caterpillar extends Animal implements Herbivore {
    private float satiety;
    private float hp;

    public Caterpillar() {
        super(BaseStatsUnit.STATS_BASE_CATERPILLAR);
        this.satiety = BaseStatsUnit.STATS_BASE_CATERPILLAR.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_CATERPILLAR.weight;
    }

    @Override
    public void eat(int x, int y, Island island) {
    }

    @Override
    public void multiply(int x, int y, Island island) {
        if (island.getPopulationOrganisms(x, y).size() > 1) {
            island.addOrganism(new Caterpillar(), x, y);
        }
    }

    @Override
    public void move(int x, int y, Island island) {
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
