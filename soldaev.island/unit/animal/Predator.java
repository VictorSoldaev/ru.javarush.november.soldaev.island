package unit.animal;

import location.Earth;
import setting.Setting;
import unit.Organizm;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public interface Predator {

    default float hunt(int x, int y, Earth earth) {
        int counter = 3;
        int speed = ((Animal)this).baseStatsUnit.speed;
        for (int i = 0; i < counter; i++) {
            int xhubt = x + ThreadLocalRandom.current().nextInt(1, speed);
            int yhubt = y + ThreadLocalRandom.current().nextInt(1, speed);
            if (searchFood(earth.getArrayListAnimals(xhubt, yhubt))) {
                return catchPrey(earth.getArrayListAnimals(xhubt, yhubt));
            }
        }
        return 0;
    }

    default boolean searchFood(ArrayList<Organizm> stepFood) {
        if (stepFood.get(0) == null) {
            return false;
        } else {
            Class<?>[] interfaces = stepFood.get(0).getClass().getInterfaces();
            for (Class c : interfaces) {
                String g = c.getSimpleName();
                if (g.equals("Herbivore")) {
                    return true;
                }
            }
        }
        return false;
    }

    default float catchPrey(ArrayList<Organizm> stepFood) {
        float satietyPositive = 0;
        for (Organizm o :
                stepFood) {
            if (checkCatchPrey(o)) {
                try {
                    Field field = o.getClass().getDeclaredField("hp");
                    field.setAccessible(true);
                    satietyPositive = satietyPositive + (float) field.get(o);
                    stepFood.remove(o);
                } catch (Exception ignor) {
                    System.out.println("Что-то пошло не так");
                }
                return satietyPositive;
            }
        }
        return 0;
    }

    default boolean checkCatchPrey(Organizm organizm) {
        Integer foodTableBearProbability = Setting.foodTable.get(this.getClass().getSimpleName()).get(organizm.getClass().getSimpleName());
        return ThreadLocalRandom.current().nextInt(0, 101) < foodTableBearProbability;
    }
}
