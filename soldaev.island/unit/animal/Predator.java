package unit.animal;

import location.Earth;
import servis.CoordinateHandler;
import setting.Setting;
import unit.Organizm;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public interface Predator {

    default float hunt(int x, int y, Earth earth) {
        int hx = 0;
        int hy = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                hx = obrabotchik(x + i, earth.getMaxSizeIslendX(), earth.getMIN_SIZE_ISLEND_X());
                hy = obrabotchik(y + j, earth.getMaxSizeIslendY(), earth.getMIN_SIZE_ISLEND_Y());
                if (searchFood(earth.getArrayListAnimals(hx, hy))) {
                    return catchPrey(earth.getArrayListAnimals(hx, hy), earth, hx, hy);
                }
            }
        }
        return 0;
    }

    default int obrabotchik(int x, int maxSize, int minSize) {
        if (x == 0) {
            return maxSize;
        } else if (x > maxSize) {
            return minSize;
        }
        return x;
    }

    default boolean searchFood(ArrayList<Organizm> stepFood) {
        if (stepFood.size() == 0) {
            return false;
        } else if (stepFood.get(0).getClass().getSimpleName().equals("Grass")) {
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

    default float catchPrey(ArrayList<Organizm> stepFood, Earth earth, int hx, int hy) {
        float satietyPositive = 0;
        for (Organizm o :
                stepFood) {
            if (checkCatchPrey(o)) {
                try {
                    Field field = o.getClass().getDeclaredField("hp");
                    field.setAccessible(true);
                    satietyPositive = satietyPositive + (float) field.get(o);
                    earth.remove(o, hx, hy);
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
