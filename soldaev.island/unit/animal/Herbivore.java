package unit.animal;

import location.Earth;
import servis.CoordinateHandler;
import unit.Organizm;

import java.lang.reflect.Field;
import java.util.ArrayList;

public interface Herbivore extends CoordinateHandler {
    default float lookingForGrass(int x, int y, Earth earth) {
        int counter = 8;
        int speed = ((Animal) this).baseStatsUnit.speed;
        for (int i = 0; i < counter; i++) {
            int xG = getCoordinateX(x, earth, speed);
            int yG = getCoordinateY(y, earth, speed);
            if (checkGress(earth.getArrayListAnimals(xG, yG))) {
                return eatGrass(earth.getArrayListAnimals(xG, yG));
            }
        }
        return 0;
    }

    default boolean checkGress(ArrayList<Organizm> stepFood) {
        if (stepFood.get(0) == null) {
            return false;
        } else {
            if (stepFood.get(0).getClass().getSimpleName().equals("Grass")) {
                return true;
            }
        }
        return false;
    }

    default float eatGrass(ArrayList<Organizm> stepFood) {
        float satietyPositive = 0;
        for (Organizm o :
                stepFood) {
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
        return 0;
    }
}
