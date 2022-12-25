package unit.animal;

import location.Earth;
import servis.CoordinateHandler;
import unit.Organizm;

import java.lang.reflect.Field;
import java.util.ArrayList;

public interface Herbivore {
    default float lookingForGrass(int x, int y, Earth earth) {
        int lx = 0;
        int ly = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                lx = obrabotchik(x + i, earth.getMaxSizeIslendX(), earth.getMIN_SIZE_ISLEND_X());
                ly = obrabotchik(y + j, earth.getMaxSizeIslendY(), earth.getMIN_SIZE_ISLEND_Y());
                if (checkGress(earth.getArrayListAnimals(lx, ly))) {
                    return eatGrass(earth.getArrayListAnimals(lx, ly), earth, lx, ly);
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

    default boolean checkGress(ArrayList<Organizm> stepFood) {
        if (stepFood.size() == 0) {
            return false;
        } else if (stepFood.get(0).getClass().getSimpleName().equals("Grass")) {
            return true;
        }
        return false;
    }

    default float eatGrass(ArrayList<Organizm> stepFood, Earth earth, int lx, int ly) {
        float satietyPositive = 0;
        for (Organizm o :
                stepFood) {
            try {
                Field field = o.getClass().getDeclaredField("hp");
                field.setAccessible(true);
                satietyPositive = satietyPositive + (float) field.get(o);
                earth.remove(o, lx, ly);
            } catch (Exception ignor) {
                System.out.println("Что-то пошло не так");
            }
            return satietyPositive;

        }
        return 0;
    }
}
