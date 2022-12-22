package servis;

import location.Earth;
import unit.animal.Animal;

public class Task {
    Earth earth;
    int x;
    int y;
    int z;

    public Task(Earth earth, int x, int y, int z) {
        this.earth = earth;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void taskQueue() {
        if (earth.getIsland().get(x).get(y).size() != 0) {
            if (!earth.getIsland().get(x).get(y).get(z).getClass().getSimpleName().equals("Grass")) {
                Animal animal = (Animal) earth.getIsland().get(x).get(y).get(z);
                if (earth.getIsland().get(x).get(y).contains(animal)) {
                    animal.eat(x, y, earth);
                    if (earth.getIsland().get(x).get(y).contains(animal)) {
                        animal.move(x, y, earth);
                        animal.multiply(x, y, earth);
                    }
                }
            }
        }

    }
}
