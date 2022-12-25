package servis;

import entities.location.Island;
import entities.organism.Organism;
import entities.organism.animal.Animal;

public class Task {
    Island island;
    int x;
    int y;
    Organism organism;

    public Task(Island island, int x, int y, Organism unit) {
        this.island = island;
        this.x = x;
        this.y = y;
        this.organism = unit;
    }

    public void taskQueue() {
        if (island.getIsland().get(x).get(y).contains(organism)) {
            Animal animal = (Animal) organism;
            animal.eat(x, y, island);
            if (island.getIsland().get(x).get(y).contains(animal)) {
                animal.multiply(x, y, island);
                animal.move(x, y, island);

            }
        }
    }

}
