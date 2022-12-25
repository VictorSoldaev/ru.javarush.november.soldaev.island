package servis;

import location.Earth;
import unit.Organizm;
import unit.animal.Animal;

public class Task {
    Earth earth;
    int x;
    int y;
    Organizm organizm;

    public Task(Earth earth, int x, int y, Organizm unit) {
        this.earth = earth;
        this.x = x;
        this.y = y;
        this.organizm = unit;
    }

    public void taskQueue() {
        if (earth.getIsland().get(x).get(y).contains(organizm)) {
            Animal animal = (Animal) organizm;
            animal.eat(x, y, earth);
            if (earth.getIsland().get(x).get(y).contains(animal)) {
                animal.move(x, y, earth);
                animal.multiply(x, y, earth);
            }


        }

    }
}
