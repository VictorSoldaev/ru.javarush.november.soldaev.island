package location;

import unit.Organizm;
import unit.animal.Animal;
import unit.plant.Plant;

import java.util.ArrayList;
import java.util.HashMap;

public class Earth extends Location {
    private int MIN_SIZE_ISLEND_X = 1;
    private int MIN_SIZE_ISLEND_Y = 1;
    private int maxSizeIslendX;
    private int maxSizeIslendY;

    public HashMap<String, Integer> populationAnimals = new HashMap<>();

    {
        populationAnimals.put("Bear", 0);
        populationAnimals.put("Buffalo", 0);
        populationAnimals.put("Caterpillar", 0);
        populationAnimals.put("Deer", 0);
        populationAnimals.put("Duck", 0);
        populationAnimals.put("Eagle", 0);
        populationAnimals.put("Fox", 0);
        populationAnimals.put("Goat", 0);
        populationAnimals.put("Hog", 0);
        populationAnimals.put("Horse", 0);
        populationAnimals.put("Mouse", 0);
        populationAnimals.put("Python", 0);
        populationAnimals.put("Rabbit", 0);
        populationAnimals.put("Sheep", 0);
        populationAnimals.put("Wolf", 0);
        populationAnimals.put("Grass", 0);
    }

    private final HashMap<Integer, HashMap<Integer, ArrayList<Organizm>>> island = new HashMap<>();

    public Earth(int maxSizeIslendX, int maxSizeIslendY) {
        this.maxSizeIslendX = maxSizeIslendX;
        this.maxSizeIslendY = maxSizeIslendY;
        createIsland();
    }

    private void createIsland() {
        for (int x = MIN_SIZE_ISLEND_X; x <= maxSizeIslendX; x++) {
            island.put(x, new HashMap<>());
            for (int y = MIN_SIZE_ISLEND_Y; y <= maxSizeIslendY; y++) {
                island.get(x).put(y, new ArrayList<>());
            }
        }
    }

    public boolean add(Organizm organizm, int coordinateX, int coordinateY) {
        //  System.out.println("По этим координатм:" + "X= " + coordinateX + "  Y= " + coordinateY);
        if (checkAdd(island.get(coordinateX).get(coordinateY), organizm)) {
            island.get(coordinateX).get(coordinateY).add(organizm);
            counterAnimal(organizm.getClass().getSimpleName(), 1);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(Organizm organizm, int coordinateX, int coordinateY) {
        if (island.get(coordinateX).get(coordinateY).remove(organizm)) {
            counterAnimal(organizm.getClass().getSimpleName(), -1);
            return true;
        }
        return false;
    }

    public boolean checkAdd(ArrayList<Organizm> animals, Organizm unit) {
        if (animals.size() == 0) {
            //  System.out.println("Организ был добавлен " + unit.getClass().getSimpleName());
            return true;
        } else if (animals.get(0).getClass().getSimpleName().equals(unit.getClass().getSimpleName())) {
            if (!unit.getClass().getSimpleName().equals("Grass")) {
                if (animals.size() < ((Animal) unit).getBaseStatsUnit().MaxNumberPerLocation){
                    return true;
                }
            } else {
                if (animals.size() < ((Plant)unit).getBaseStatsUnit().MaxNumberPerLocation){
                    return true;
                }
            }
            //    System.out.println("Организ был добавлен " + unit.getClass().getSimpleName());
            return false;
        } else {
            //   System.out.println("Организ не был добавлен " + unit.getClass().getSimpleName());
            return false;
        }
    }

    public ArrayList<Organizm> getArrayListAnimals(int coordinateX, int coordinateY) {
        return island.get(coordinateX).get(coordinateY);
    }

    public int getMaxSizeIslendX() {
        return maxSizeIslendX;
    }

    public int getMaxSizeIslendY() {
        return maxSizeIslendY;
    }

    public int getMIN_SIZE_ISLEND_X() {
        return MIN_SIZE_ISLEND_X;
    }

    public int getMIN_SIZE_ISLEND_Y() {
        return MIN_SIZE_ISLEND_Y;
    }

    public HashMap<Integer, HashMap<Integer, ArrayList<Organizm>>> getIsland() {
        return island;
    }

    public boolean getToBo(Organizm organizm, int coordinateX, int coordinateY) {
        return island.get(coordinateX).get(coordinateY).contains(organizm);
    }

    private void counterAnimal(String organizmName, int result) {
        populationAnimals.put(organizmName, populationAnimals.get(organizmName) + result);
    }

    @Override
    public String toString() {
        return "Wolf " + "\uD83D\uDC3A" + populationAnimals.get("Wolf") + "  " +
                "Python " + "\uD83D\uDC0D" + populationAnimals.get("Python") + "  " +
                "Fox " + "\uD83E\uDD8A" + populationAnimals.get("Fox") + "  " +
                "Bear " + "\uD83D\uDC3B" + populationAnimals.get("Bear") + "  " +
                "Eagle " + "\uD83E\uDD85" + populationAnimals.get("Eagle") + "  " +
                "Horse " + "\uD83D\uDC0E" + populationAnimals.get("Horse") + "  " +
                "Deer " + "\uD83E\uDD8C" + populationAnimals.get("Deer") + "  " +
                "Rabbit " + "\uD83D\uDC07" + populationAnimals.get("Rabbit") + "  " +
                "Mouse " + "\uD83D\uDC01" + populationAnimals.get("Mouse") + "  " +
                "Goat " + "\uD83D\uDC10" + populationAnimals.get("Goat") + "  " +
                "Sheep " + "\uD83D\uDC11" + populationAnimals.get("Sheep") + "  " +
                "Hog " + "\uD83D\uDC17" + populationAnimals.get("Hog") + "  " +
                "Buffalo " + "\uD83D\uDC03" + populationAnimals.get("Buffalo") + "  " +
                "Duck " + "\uD83E\uDD86" + populationAnimals.get("Duck") + "  " +
                "Caterpillar " + "\uD83D\uDC1B" + populationAnimals.get("Caterpillar") + "  " +
                "Grass " + "\uD83C\uDF3F" + populationAnimals.get("Grass");
    }
}
