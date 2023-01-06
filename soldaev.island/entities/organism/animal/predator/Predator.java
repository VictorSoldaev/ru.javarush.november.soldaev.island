package entities.organism.animal.predator;

import entities.location.Location;
import util.CoordinateHandler;
import setting.Setting;
import entities.organism.Organism;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public interface Predator extends CoordinateHandler {

    default float hunt(int x, int y, Location island) {
        int hx = 0;
        int hy = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                hx = getCoordinate(x + i, island.getMaxSizeIslandCoordinateX(), island.getMinSizeIslandX());
                hy = getCoordinate(y + j, island.getMaxSizeIslandCoordinateY(), island.getMinSizeIslandY());
                if (searchFood(island.getPopulationOrganisms(hx, hy))) {
                    return catchPrey(island.getPopulationOrganisms(hx, hy), island, hx, hy);
                }
            }
        }
        return 0;
    }


    default boolean searchFood(ArrayList<Organism> stepFood) {
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

    default float catchPrey(ArrayList<Organism> stepFood, Location island, int hx, int hy) {
        float satietyPositive = 0;
        for (Organism o :
                stepFood) {
            if (checkCatchPrey(o)) {
                try {
                    Field field = o.getClass().getDeclaredField("hp");
                    field.setAccessible(true);
                    satietyPositive = satietyPositive + (float) field.get(o);
                    island.removeOrganism(o, hx, hy);
                } catch (Exception ignor) {
                    System.out.println("Что-то пошло не так");
                }
                return satietyPositive;
            }
        }
        return 0;
    }

    default boolean checkCatchPrey(Organism organism) {
        Integer foodTableBearProbability = Setting.foodTable.get(this.getClass().getSimpleName()).get(organism.getClass().getSimpleName());
        return ThreadLocalRandom.current().nextInt(0, 101) < foodTableBearProbability;
    }
}
