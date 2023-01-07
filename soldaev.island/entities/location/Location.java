package entities.location;

import entities.organism.Organism;
import entities.organism.animal.Animal;
import entities.organism.plant.Plant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Location {
    private final int MIN_SIZE_ISLAND_COORDINATE_X = 1;
    private final int MIN_SIZE_ISLAND_COORDINATE_Y = 1;
    private int maxSizeIslandCoordinateX;
    private int maxSizeIslandCoordinateY;
    private final HashMap<Integer, HashMap<Integer, ArrayList<Organism>>> island = new HashMap<>();
    private final Lock lock = new ReentrantLock();
    public HashMap<String, Integer> population = new HashMap<>();


    {
        population.put("Bear", 0);
        population.put("Buffalo", 0);
        population.put("Caterpillar", 0);
        population.put("Deer", 0);
        population.put("Duck", 0);
        population.put("Eagle", 0);
        population.put("Fox", 0);
        population.put("Goat", 0);
        population.put("Hog", 0);
        population.put("Horse", 0);
        population.put("Mouse", 0);
        population.put("Python", 0);
        population.put("Rabbit", 0);
        population.put("Sheep", 0);
        population.put("Wolf", 0);
        population.put("Grass", 0);
    }

    public Location(int maxSizeIslendLength, int maxSizeIslendWidth) {
        maxSizeIslandCoordinateX = maxSizeIslendLength + MIN_SIZE_ISLAND_COORDINATE_X;
        maxSizeIslandCoordinateY = maxSizeIslendWidth + MIN_SIZE_ISLAND_COORDINATE_Y;
        createIsland();
    }

    private void createIsland() {
        for (int x = MIN_SIZE_ISLAND_COORDINATE_X; x <= maxSizeIslandCoordinateX; x++) {
            island.put(x, new HashMap<>());
            for (int y = MIN_SIZE_ISLAND_COORDINATE_Y; y <= maxSizeIslandCoordinateY; y++) {
                island.get(x).put(y, new ArrayList<>());
            }
        }
    }

    public boolean addOrganism(Organism organism, int coordinateX, int coordinateY) {
        if (canAddOrganism(getPopulationOrganisms(coordinateX, coordinateY), organism)) {
            island.get(coordinateX).get(coordinateY).add(organism);
            counterOrganism(organism.getClass().getSimpleName(), 1);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeOrganism(Organism organism, int coordinateX, int coordinateY) {
        if (getPopulationOrganisms(coordinateX, coordinateY).remove(organism)) {
            counterOrganism(organism.getClass().getSimpleName(), -1);
            return true;
        }
        return false;
    }

    public boolean canAddOrganism(ArrayList<Organism> animals, Organism organism) {
        if (animals.size() == 0) {
            return true;
        } else if (animals.get(0).getClass().getSimpleName().equals(organism.getClass().getSimpleName())) {
            if (!organism.getClass().getSimpleName().equals("Grass")) {
                return animals.size() < ((Animal) organism).getBaseStatsUnit().MaxNumberPerLocation;
            } else {
                return animals.size() < ((Plant) organism).getBaseStatsUnit().MaxNumberPerLocation;
            }
        } else {
            return false;
        }
    }

    public ArrayList<Organism> getPopulationOrganisms(int coordinateX, int coordinateY) {
        return island.get(coordinateX).get(coordinateY);
    }

    public int getMaxSizeIslandCoordinateX() {
        return maxSizeIslandCoordinateX;
    }

    public int getMaxSizeIslandCoordinateY() {
        return maxSizeIslandCoordinateY;
    }

    public int getMinSizeIslandX() {
        return MIN_SIZE_ISLAND_COORDINATE_X;
    }

    public int getMinSizeIslandY() {
        return MIN_SIZE_ISLAND_COORDINATE_Y;
    }

    public HashMap<Integer, HashMap<Integer, ArrayList<Organism>>> getIsland() {
        return island;
    }

    public boolean containsIslandIsOrganism(Organism organism, int coordinateX, int coordinateY) {
        return island.get(coordinateX).get(coordinateY).contains(organism);
    }

    private void counterOrganism(String organizmName, int result) {
        population.put(organizmName, population.get(organizmName) + result);
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Wolf " + "\uD83D\uDC3A" + population.get("Wolf") + "  " +
                "Python " + "\uD83D\uDC0D" + population.get("Python") + "  " +
                "Fox " + "\uD83E\uDD8A" + population.get("Fox") + "  " +
                "Bear " + "\uD83D\uDC3B" + population.get("Bear") + "  " +
                "Eagle " + "\uD83E\uDD85" + population.get("Eagle") + "  " +
                "Horse " + "\uD83D\uDC0E" + population.get("Horse") + "  " +
                "Deer " + "\uD83E\uDD8C" + population.get("Deer") + "  " +
                "Rabbit " + "\uD83D\uDC07" + population.get("Rabbit") + "  " +
                "Mouse " + "\uD83D\uDC01" + population.get("Mouse") + "  " +
                "Goat " + "\uD83D\uDC10" + population.get("Goat") + "  " +
                "Sheep " + "\uD83D\uDC11" + population.get("Sheep") + "  " +
                "Hog " + "\uD83D\uDC17" + population.get("Hog") + "  " +
                "Buffalo " + "\uD83D\uDC03" + population.get("Buffalo") + "  " +
                "Duck " + "\uD83E\uDD86" + population.get("Duck") + "  " +
                "Caterpillar " + "\uD83D\uDC1B" + population.get("Caterpillar") + "  " +
                "Grass " + "\uD83C\uDF3F" + population.get("Grass");
    }


}
