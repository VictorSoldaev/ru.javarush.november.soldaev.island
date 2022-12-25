package entities;

import factory.OrganismFactory;
import factory.TypeHerbivore;
import factory.TypePredator;
import entities.location.Island;
import entities.organism.plant.Grass;
import util.Random;


public class World implements Random {
    private OrganismFactory factory = new OrganismFactory();

    private Island island;

    public World() {
        this.island = new Island(20, 20);

    }

    public World(int maxSizeIslendLength, int maxSizeIslendWidth) {
        this.island = new Island(maxSizeIslendLength, maxSizeIslendWidth);
    }

    public void createLife() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < TypePredator.values().length; j++) {
                TypePredator value = TypePredator.values()[j];
                island.addOrganism(factory.create(TypePredator.values()[j]), random(island.getMinSizeIslandX(), island.getMaxSizeIslandCoordinateX()),
                        random(island.getMinSizeIslandY(), island.getMaxSizeIslandCoordinateY()));
            }
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < TypeHerbivore.values().length; j++) {
                island.addOrganism(factory.create(TypeHerbivore.values()[j]), random(island.getMinSizeIslandX(), island.getMaxSizeIslandCoordinateX()),
                        random(island.getMinSizeIslandY(), island.getMaxSizeIslandCoordinateY()));
            }
        }
        createPlants(150);
    }

    public void createLife(int numberOfPredator, int numberOfHerbivore, int numberOfGrass) {
        System.out.println("Населяем мир");
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

    public Island getIslend() {
        return island;
    }

}