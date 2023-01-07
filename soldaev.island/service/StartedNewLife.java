package service;

import entities.World;
import entities.location.Location;
import java.util.ArrayList;
import java.util.concurrent.*;

public class StartedNewLife extends Thread {

    private final Location island;
    private final World world;
    private int day;
    private ArrayList<PopulationLife> populationOrganism = new ArrayList<>();


    public StartedNewLife(World world) {
        this.world = world;
        this.island = world.getLocation();
    }

//    public StartedNewLife(World world, int lifeTime) {
//        this.world = world;
//        this.island = world.getLocation();
//    }

    @Override
    public void run() {
        System.out.println("Initial world population \n" + island.toString());
        System.out.println("=".repeat(100));
        ScheduledExecutorService launchingLifeStreams = Executors.newScheduledThreadPool(4);
        launchingLifeStreams.scheduleWithFixedDelay(this::startWorldLife, 0, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(world.getLifeTime());
            launchingLifeStreams.shutdown();
        } catch (Exception e) {
            System.out.println("end");
        }
        System.out.println("end");
    }

    private void startWorldLife() {
        day++;
        for (int x = island.getMinSizeIslandX(); x <= island.getMaxSizeIslandCoordinateX(); x++) {
            for (int y = island.getMinSizeIslandY(); y <= island.getMaxSizeIslandCoordinateY(); y++) {
                if (island.getPopulationOrganisms(x, y).size() != 0) {
                    if (!island.getPopulationOrganisms(x, y).get(0).getClass().getSimpleName().equals("Grass"))
                        populationOrganism.add(new PopulationLife(island.getPopulationOrganisms(x, y), x, y, island));
                }
            }
        }
        ExecutorService startingTheLifeOfOrganisms = Executors.newFixedThreadPool(4);
        for (PopulationLife lifeOrganism :
                populationOrganism) {
            startingTheLifeOfOrganisms.submit(lifeOrganism);
        }
        startingTheLifeOfOrganisms.shutdown();
        populationOrganism.clear();
        world.createPlants(100);
        System.out.println(day + " days have passed since the creation of the world");
        System.out.println(island);
        System.out.println("=".repeat(100));
    }
}