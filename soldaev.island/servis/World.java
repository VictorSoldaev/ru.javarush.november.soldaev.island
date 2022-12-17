package servis;

import location.Earth;

import java.util.concurrent.ThreadLocalRandom;

public class World {
    UnitFactory factory = new UnitFactory();
    Earth island = new Earth(120, 20);

    public void createLife() {
        int sis = island.getCoordinateX();
        int creat = 0;
        int i = ThreadLocalRandom.current().nextInt(0, sis);
        while (creat != 2) {
            if (island.isAdd(i)) {
                island.add(factory.create(TypAnimal.BEAR), i);
                creat ++;
            }
        }
        creat = 0;
        i = ThreadLocalRandom.current().nextInt(0, sis);
        while (creat != 2) {
            if (island.isAdd(i)) {
                island.add(factory.create(TypAnimal.DUCK), i);
                creat ++;
            }
        }
        creat = 0;
        i = ThreadLocalRandom.current().nextInt(0, sis);
        while (creat != 2) {
            if (island.isAdd(i)) {
                island.add(factory.create(TypAnimal.CATERPILLAR), i);
                creat ++;
            }
        }

    }
}