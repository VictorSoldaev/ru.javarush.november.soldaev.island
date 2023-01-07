package entities.organism.animal.herbivore;

import entities.location.Location;
import entities.organism.animal.Animal;
import setting.Setting;

public class Caterpillar extends Animal implements Herbivore {
    private float satiety;
    private float hp;

    public Caterpillar() {
        this.satiety = Setting.statsUnit.get(this.getClass().getSimpleName()).getSatiety();
        this.hp = Setting.statsUnit.get(this.getClass().getSimpleName()).getWeight();
    }

    @Override
    public void eat(int x, int y, Location island) {
    }

    @Override
    public void multiply(int x, int y, Location island) {
        island.getLock().lock();
        try {
            if (island.getPopulationOrganisms(x, y).size() > 1) {
                island.addOrganism(new Caterpillar(), x, y);
            }
        } finally {
            island.getLock().unlock();
        }
    }

    @Override
    public void move(int x, int y, Location island) {
    }

    public void oldAge(int x, int y, Location island) {
        island.getLock().lock();
        try {
            hp = (float) (hp - Setting.statsUnit.get(this.getClass().getSimpleName()).getWeight() * 0.1);
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
