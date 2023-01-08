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
    public HashMap<String, Integer> populationStatistics = new HashMap<>();

    public Location(int maxSizeIslendLength, int maxSizeIslendWidth) {
        maxSizeIslandCoordinateX = maxSizeIslendLength + MIN_SIZE_ISLAND_COORDINATE_X;
        maxSizeIslandCoordinateY = maxSizeIslendWidth + MIN_SIZE_ISLAND_COORDINATE_Y;
        createStatistics();
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
        populationStatistics.put(organizmName, populationStatistics.get(organizmName) + result);
    }

    public Lock getLock() {
        return lock;
    }

    private void createStatistics(){
        populationStatistics.put("Bear", 0);
        populationStatistics.put("Buffalo", 0);
        populationStatistics.put("Caterpillar", 0);
        populationStatistics.put("Deer", 0);
        populationStatistics.put("Duck", 0);
        populationStatistics.put("Eagle", 0);
        populationStatistics.put("Fox", 0);
        populationStatistics.put("Goat", 0);
        populationStatistics.put("Hog", 0);
        populationStatistics.put("Horse", 0);
        populationStatistics.put("Mouse", 0);
        populationStatistics.put("Python", 0);
        populationStatistics.put("Rabbit", 0);
        populationStatistics.put("Sheep", 0);
        populationStatistics.put("Wolf", 0);
        populationStatistics.put("Grass", 0);
    }

    @Override
    public String toString() {
        return "Wolf " + "\uD83D\uDC3A" + populationStatistics.get("Wolf") + "  " +
                "Python " + "\uD83D\uDC0D" + populationStatistics.get("Python") + "  " +
                "Fox " + "\uD83E\uDD8A" + populationStatistics.get("Fox") + "  " +
                "Bear " + "\uD83D\uDC3B" + populationStatistics.get("Bear") + "  " +
                "Eagle " + "\uD83E\uDD85" + populationStatistics.get("Eagle") + "  " +
                "Horse " + "\uD83D\uDC0E" + populationStatistics.get("Horse") + "  " +
                "Deer " + "\uD83E\uDD8C" + populationStatistics.get("Deer") + "  " +
                "Rabbit " + "\uD83D\uDC07" + populationStatistics.get("Rabbit") + "  " +
                "Mouse " + "\uD83D\uDC01" + populationStatistics.get("Mouse") + "  " +
                "Goat " + "\uD83D\uDC10" + populationStatistics.get("Goat") + "  " +
                "Sheep " + "\uD83D\uDC11" + populationStatistics.get("Sheep") + "  " +
                "Hog " + "\uD83D\uDC17" + populationStatistics.get("Hog") + "  " +
                "Buffalo " + "\uD83D\uDC03" + populationStatistics.get("Buffalo") + "  " +
                "Duck " + "\uD83E\uDD86" + populationStatistics.get("Duck") + "  " +
                "Caterpillar " + "\uD83D\uDC1B" + populationStatistics.get("Caterpillar") + "  " +
                "Grass " + "\uD83C\uDF3F" + populationStatistics.get("Grass");
    }


}
