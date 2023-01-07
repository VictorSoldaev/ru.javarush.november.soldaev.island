package entities.organism.plant;

import setting.Setting;


public class Grass extends Plant {
    private float hp;

    public Grass() {
        this.hp = Setting.statsUnit.get(this.getClass().getSimpleName()).getWeight();
    }
}
