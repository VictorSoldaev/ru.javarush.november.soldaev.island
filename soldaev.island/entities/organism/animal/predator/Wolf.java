package entities.organism.animal.predator;
import entities.location.Location;
import setting.BaseStatsUnit;
import entities.organism.animal.Animal;

public class Wolf extends Animal implements Predator {
    private float satiety;
    private float hp;

    public Wolf() {
        super(BaseStatsUnit.STATS_BASE_WOLF);
        this.satiety = BaseStatsUnit.STATS_BASE_WOLF.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_WOLF.weight;
    }

    @Override
    public void eat(int x, int y, Location island) {
        island.getLock().lock();
        try {
            float r = hunt(x, y, island);
            if (r == 0) {
                satiety = (float) (satiety - BaseStatsUnit.STATS_BASE_WOLF.satiety * 0.2);
                if (satiety <= 0) {
                    hp = (float) (hp - BaseStatsUnit.STATS_BASE_WOLF.weight * 0.3);
                    if (hp <= 0) {
                        island.removeOrganism(this, x, y);

                    }
                }
            } else if (satiety + r > BaseStatsUnit.STATS_BASE_WOLF.satiety) {
                satiety = BaseStatsUnit.STATS_BASE_WOLF.satiety;
            } else {
                satiety = satiety + r;
            }
        } finally {
            island.getLock().unlock();
        }

    }

    @Override
    public void multiply(int x, int y, Location island) {
        island.getLock().lock();
        try {
            if (island.getPopulationOrganisms(x, y).size() > 1) {
                island.addOrganism(new Wolf(), x, y);
            }
        } finally {
            island.getLock().unlock();
        }
    }

    public void oldAge(int x, int y, Location island) {
        island.getLock().lock();
        try {
            hp = (float) (hp - BaseStatsUnit.STATS_BASE_WOLF.weight * 0.2);
            if (hp <= 0) {
                island.removeOrganism(this, x, y);
            }
        } finally {
            island.getLock().unlock();
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