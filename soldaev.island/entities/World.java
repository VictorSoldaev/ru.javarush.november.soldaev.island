package entities;

import factory.OrganismFactory;
import factory.TypeHerbivore;
import factory.TypePredator;
import entities.location.*;
import entities.organism.plant.Grass;
import setting.Setting;
import util.Random;

public class World implements Random {
    private OrganismFactory factory = new OrganismFactory();
    private Location island;
    private int lifeTime = Setting.settingWorld.get("lifeTime");
    private int numberOfPredator = Setting.settingWorld.get("numberOfPredator");
    private int numberOfHerbivore = Setting.settingWorld.get("numberOfHerbivore");
    private int numberOfGrass = Setting.settingWorld.get("numberOfGrass");
    private int maxSizeIslendLength = Setting.settingWorld.get("maxSizeIslendLength");
    private int maxSizeIslendWidth = Setting.settingWorld.get("maxSizeIslendWidth");

    public World() {
        this.island = new Location(maxSizeIslendLength, maxSizeIslendWidth);
    }

    public World(int maxSizeIslendLength, int maxSizeIslendWidth, int lifeTime) {
        this.island = new Location(maxSizeIslendLength, maxSizeIslendWidth);
        this.lifeTime = lifeTime * 1000;
    }


    public void createLife(int numberOfPredator, int numberOfHerbivore, int numberOfGrass) {
        createPredator(numberOfPredator, random(0, TypePredator.values().length));
        createHerbivore(numberOfHerbivore, random(0, TypeHerbivore.values().length));
        createPlants(numberOfGrass);
    }

    public void createPredator(int numberOfPredator, int numberTypeAnimals) {
        if (numberOfPredator > 0) {
            for (int i = 0; i < 2; i++) {
                island.addOrganism(factory.create(TypePredator.values()[numberTypeAnimals]), random(island.getMinSizeIslandX(), island.getMaxSizeIslandCoordinateX()),
                        random(island.getMinSizeIslandY(), island.getMaxSizeIslandCoordinateY()));
            }
            createPredator(numberOfPredator - 2, random(0, TypePredator.values().length));
        }
    }

    public void createHerbivore(int numberOfPredator, int numberTypeAnimals) {
        if (numberOfPredator > 0) {
            for (int i = 0; i < 2; i++) {
                island.addOrganism(factory.create(TypeHerbivore.values()[numberTypeAnimals]), random(island.getMinSizeIslandX(), island.getMaxSizeIslandCoordinateX()),
                        random(island.getMinSizeIslandY(), island.getMaxSizeIslandCoordinateY()));
            }
            createHerbivore(numberOfPredator - 2, random(0, TypeHerbivore.values().length));
        }
    }

    public void createPlants(int umberOfPlants) {
        for (int i = 0; i < umberOfPlants; i++) {
            island.addOrganism(new Grass(), random(island.getMinSizeIslandX(), island.getMaxSizeIslandCoordinateX()),
                    random(island.getMinSizeIslandY(), island.getMaxSizeIslandCoordinateY()));
        }
    }

    public Location getLocation() {
        return island;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }
    public int getNumberOfPredator() {
        return numberOfPredator;
    }

    public void setNumberOfPredator(int numberOfPredator) {
        this.numberOfPredator = numberOfPredator;
    }

    public int getNumberOfHerbivore() {
        return numberOfHerbivore;
    }

    public void setNumberOfHerbivore(int numberOfHerbivore) {
        this.numberOfHerbivore = numberOfHerbivore;
    }

    public int getNumberOfGrass() {
        return numberOfGrass;
    }

    public void setNumberOfGrass(int numberOfGrass) {
        this.numberOfGrass = numberOfGrass;
    }

}