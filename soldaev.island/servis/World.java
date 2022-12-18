package servis;

import location.Earth;
import unit.Organizm;

import java.util.concurrent.ThreadLocalRandom;

public class World implements Runnable {
    UnitFactory factory;
    Earth island;

    public World() {
        this.island = new Earth(120, 20);
        this.factory = new UnitFactory();
        createLife();

    }

    public World(int sizeX, int sizeY) {
        this.island = new Earth(sizeX, sizeY);
        this.factory = new UnitFactory();
        createLife();
    }

    public void start(int i) {
        int j = 0;
        while (true) {
            if (island.getOrganizm(i, j) == null) {
                j++;
                continue;
            }
            Organizm organizm = island.getOrganizm(i, j);
            if (true) {
                // Кушаем?
            }
            if (true) {
                // Размножаемся?
            }
            if (true) {
                // идем?
            }
            j++;
        }

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

    public void createLife() {
        int sis = island.getCoordinateX();
        int creat = 0;
        int i = ThreadLocalRandom.current().nextInt(0, sis);
        while (creat != 2) {
            if (island.isAdd(i)) {
                island.add(factory.create(TypAnimal.BEAR), i);
                creat++;
            }
        }
        creat = 0;
        i = ThreadLocalRandom.current().nextInt(0, sis);
        while (creat != 2) {
            if (island.isAdd(i)) {
                island.add(factory.create(TypAnimal.DUCK), i);
                creat++;
            }
        }
        creat = 0;
        i = ThreadLocalRandom.current().nextInt(0, sis);
        while (creat != 2) {
            if (island.isAdd(i)) {
                island.add(factory.create(TypAnimal.CATERPILLAR), i);
                creat++;
            }
        }

    }

    @Override
    public void run() {

    }
}