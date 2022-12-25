package servis;

import entities.location.Island;
import entities.organism.Organism;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class PopulationLife implements Runnable {
    ArrayList<Organism> organisms;

    private Island island;
    private int x;
    private int y;
    private final Queue<Task> tasks = new ConcurrentLinkedDeque<>();

    public PopulationLife(ArrayList<Organism> organisms, int x, int y, Island island) {
        this.organisms = organisms;
        this.island = island;
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        startTheLifeCycleOfTheDay();
    }

    private void startTheLifeCycleOfTheDay() {
        island.getLock().lock();
        try {
            for (int i = 0; i < organisms.size(); i++) {
                tasks.add(new Task(island, x, y, organisms.get(i)));
            }
            for (Task t : tasks) {
                t.taskQueue();
            }
            tasks.clear();
        } finally {
            island.getLock().unlock();
        }
    }
}