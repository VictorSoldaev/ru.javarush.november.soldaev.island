package servis;

import entities.location.Island;

import java.util.ArrayList;
import java.util.concurrent.*;

public class StartedNewLife extends Thread {

    private final Island island;
    private volatile int day;
    private ArrayList<PopulationLife> populationOrganism = new ArrayList<>();
    int time;
    public StartedNewLife(Island island) {
        this.island = island;
        this.time = 100000;
    }

    public StartedNewLife(Island island, int time) {
        this.island = island;
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(island.toString());
        System.out.println("=".repeat(30));
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(2) {
        };
        service.scheduleAtFixedRate(this::metodDlyaZopuska, 0, 2, TimeUnit.SECONDS);
        try {
            Thread.sleep(time);
            service.shutdown();
        } catch (Exception e) {
            System.out.println("Сломалось");
        }

    }

    private void metodDlyaZopuska() {
        day++;
        for (int x = island.getMinSizeIslandX(); x <= island.getMaxSizeIslandCoordinateX(); x++) {
            for (int y = island.getMinSizeIslandY(); y <= island.getMaxSizeIslandCoordinateY(); y++) {
                if (island.getPopulationOrganisms(x, y).size() != 0) {
                    if (!island.getPopulationOrganisms(x, y).get(0).getClass().getSimpleName().equals("Grass"))
                        populationOrganism.add(new PopulationLife(island.getPopulationOrganisms(x, y), x, y, island));
                }
            }
        }
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (PopulationLife l :
                populationOrganism) {
            executorService.submit(l);
        }
        executorService.shutdown();
        populationOrganism.clear();
        System.out.println(day + "days have passed since the creation of the world");
        System.out.println(island);
        System.out.println("=".repeat(30));
    }
}