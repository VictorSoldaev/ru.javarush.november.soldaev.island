package entities.organism.animal.predator;
import entities.location.Location;
import entities.organism.animal.Animal;
import setting.Setting;

public class Wolf extends Animal implements Predator {
    private float satiety;
    private float hp;

    public Wolf() {
        this.satiety = Setting.statsUnit.get(this.getClass().getSimpleName()).getSatiety();
        this.hp = Setting.statsUnit.get(this.getClass().getSimpleName()).getWeight();
    }

    @Override
    public void eat(int x, int y, Location island) {
        island.getLock().lock();
        try {
            float r = hunt(x, y, island);
            if (r == 0) {
                satiety = (float) (satiety - Setting.statsUnit.get(this.getClass().getSimpleName()).getSatiety() * 0.2);
                if (satiety <= 0) {
                    hp = (float) (hp - Setting.statsUnit.get(this.getClass().getSimpleName()).getWeight() * 0.3);
                    if (hp <= 0) {
                        island.removeOrganism(this, x, y);

                    }
                }
            } else if (satiety + r > Setting.statsUnit.get(this.getClass().getSimpleName()).getSatiety()) {
                satiety = Setting.statsUnit.get(this.getClass().getSimpleName()).getSatiety();
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
            hp = (float) (hp - Setting.statsUnit.get(this.getClass().getSimpleName()).getWeight() * 0.2);
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
