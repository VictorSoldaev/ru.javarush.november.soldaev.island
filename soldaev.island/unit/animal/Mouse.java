package unit.animal;


import location.Earth;
import unit.Organizm;

import java.util.ArrayList;

public class Mouse extends Animal implements Herbivore, Predator{


    @Override
    public void eat(int x, int y, Earth earth) {

    }

    @Override
    public void move() {

    }

    @Override
    public Animal multiply() {
        return new Mouse();
    }
}
