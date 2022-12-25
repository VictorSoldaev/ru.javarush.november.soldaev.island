package factory;

import entities.organism.Organism;
import entities.organism.animal.herbivore.*;
import entities.organism.animal.predator.*;

public class OrganismFactory {
    public OrganismFactory() {
    }

    public Organism create(TypePredator typePredator) {
        Organism organism = null;
        switch (typePredator) {
            case BEAR:
                organism = new Bear();
                break;
            case PYTHON:
                organism = new Python();
                break;
            case EAGLE:
                organism = new Eagle();
                break;
            case FOX:
                organism = new Fox();
                break;
            case WOLF:
                organism = new Wolf();
                break;
        }
        return organism;
    }

    public Organism create(TypeHerbivore typePredator) {
        Organism organism = null;
        switch (typePredator) {
            case HORSE:
                organism = new Horse();
                break;
            case CATERPILLAR:
                organism = new Caterpillar();
                break;
            case DUCK:
                organism = new Duck();
                break;
            case MOUSE:
                organism = new Mouse();
                break;
            case DEER:
                organism = new Deer();
                break;
            case BUFFALO:
                organism = new Buffalo();
                break;
            case RABBIT:
                organism = new Rabbit();
                break;
            case GOAT:
                organism = new Goat();
                break;
            case HOG:
                organism = new Hog();
                break;
            case SHEEP:
                organism = new Sheep();
                break;
        }
        return organism;
    }
}












