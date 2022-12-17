package servis;

import unit.Organizm;
import unit.animal.*;

public class UnitFactory {
    public UnitFactory(){}

    public Organizm create(TypAnimal type){
        Organizm organizm = null;
        switch (type){
            case BEAR:
                organizm = new Bear();
                break;
            case CATERPILLAR:
                organizm = new Caterpillar();
                break;
            case DUCK:
                organizm = new Duck();
                break;
            case WOLF:
                organizm = new Wolf();
                break;
        }
        return organizm;
    }
}
