import location.Earth;
import servis.UnitFactory;
import servis.World;
import setting.Setting;
import unit.Organizm;
import unit.animal.Bear;
import unit.animal.Horse;
import unit.animal.Mouse;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class StarIsLand {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        World world = new World();
        world.createLife();
        Setting setting = new Setting();
        Bear bear = new Bear();
        bear.setSatiety(bear.getSatiety() - 10);
        System.out.println(bear.getSatiety());
        Mouse mouse = new Mouse();
        Horse horse = new Horse();
        System.out.println("Начинаем охоту");
        for (int i = 0; i < 50; i++) {
            bear.toEat(horse);
        }
        System.out.println(bear.getSatiety());
        UnitFactory factory = new UnitFactory();
        ArrayList<Organizm> lock = new ArrayList<>();
        Earth sdfsdf = new Earth(120, 20);

        if (true) {
            sdfsdf.add(factory.create(bear.multiply()), 5);

        }
    }
}
