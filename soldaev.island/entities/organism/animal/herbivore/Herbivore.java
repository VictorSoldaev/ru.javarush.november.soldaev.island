package entities.organism.animal.herbivore;

import entities.location.Island;
import util.CoordinateHandler;
import entities.organism.Organism;

import java.lang.reflect.Field;
import java.util.ArrayList;


public interface Herbivore extends CoordinateHandler {
    default float lookingForGrass(int x, int y, Island island) {
        int lx = 0;
        int ly = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 || j == 0) {
                    continue;
                }
                lx = getCoordinate(x + i, island.getMaxSizeIslandCoordinateX(), island.getMinSizeIslandX());
                ly = getCoordinate(y + j, island.getMaxSizeIslandCoordinateY(), island.getMinSizeIslandY());
                if (checkGress(island.getPopulationOrganisms(lx, ly))) {
                    return eatGrass(island.getPopulationOrganisms(lx, ly), island, lx, ly);
                }
            }

        }
        return 0;
    }


    default boolean checkGress(ArrayList<Organism> stepFood) {
        if (stepFood.size() == 0) {
            return false;
        } else if (stepFood.get(0).getClass().getSimpleName().equals("Grass")) {
            return true;
        }
        return false;
    }

    default float eatGrass(ArrayList<Organism> stepFood, Island island, int lx, int ly) {
        float satietyPositive = 0;
        for (Organism o :
                stepFood) {
            try {
                Field field = o.getClass().getDeclaredField("hp");
                field.setAccessible(true);
                satietyPositive = satietyPositive + (float) field.get(o);
                island.removeOrganism(o, lx, ly);
            } catch (Exception ignor) {
                System.out.println("Что-то пошло не так");
            }
            return satietyPositive;

        }
        return 0;
    }
}
