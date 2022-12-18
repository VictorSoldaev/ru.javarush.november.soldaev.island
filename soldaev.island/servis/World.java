package servis;

import location.Earth;
import unit.animal.*;
import unit.plant.Grass;

import java.util.concurrent.ThreadLocalRandom;

public class World {
    UnitFactory factory;
    private Earth earth;
    private int maxSizeX = 120;
    private int maxSizeY = 20;
    private int minSizeX = 0;
    private int minSizeY = 0;

    public World() {
        this.earth = new Earth(maxSizeX, maxSizeY);
        //  this.factory = new UnitFactory();
        createLife();

    }

    public World(int sizeX, int sizeY) {
        this.earth = new Earth(sizeX, sizeY);
        this.factory = new UnitFactory();
        createLife();
    }

    public void start(int i) throws NoSuchFieldException, IllegalAccessException {
//        int j = 0;
//        while (true) {
//            if (island.getOrganizm(i, j) == null) {
//                j++;
//                continue;
//            }
//            unit.animal.Animal organizm = (unit.animal.Animal) island.getOrganizm(i, j);
//            if (true) {
//                // Кушаем?
//                organizm.eat(island.getLock(i));
//            }
//            if (true) {
//                // Размножаемся?
//            }
//            if (true) {
//                // идем?
//            }
//            j++;
//        }

        // создаем все необходимое для мира
        // создаем потоков равное кординате X
        // цикл
        // каждый поток бегает по heshmap[n] -> arreylist и спрашивает жиаотное хочет ли оно сделать
        // кушать или перейти или размножиться
        // за шанс что-то сделать отвечает random(судбьба 50/50)
        // даеться всемя, что бы опросить потом все потоки становяться в ожидании
        // запускаеться поток сбора статистики -> если животных осталось 0 мир останавливаеться если осталась
        //              только трава пищеться растения побкдили
        // выводиться статистика
        // возвращаемся снова к опросу
        // ......
    }

    private void createLife() {
        int x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        int y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Bear(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Buffalo(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Caterpillar(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Deer(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Duck(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Eagle(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Fox(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Goat(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Goat(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Hog(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Horse(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Mouse(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Python(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Rabbit(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Sheep(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 2; i++) {
            earth.add(new Wolf(), x, y);
        }


        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 10; i++) {
            earth.add(new Grass(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 10; i++) {
            earth.add(new Grass(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 10; i++) {
            earth.add(new Grass(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 10; i++) {
            earth.add(new Grass(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 10; i++) {
            earth.add(new Grass(), x, y);
        }
        x = ThreadLocalRandom.current().nextInt(minSizeX, maxSizeX);
        y = ThreadLocalRandom.current().nextInt(minSizeY, maxSizeY);
        for (int i = 0; i < 10; i++) {
            earth.add(new Grass(), x, y);
        }
    }

}