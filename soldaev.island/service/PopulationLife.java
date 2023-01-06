package service;

import entities.location.Location;
import entities.organism.Organism;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class PopulationLife implements Runnable {
    private ArrayList<Organism> organisms;
    private Location island;
    private int x;
    private int y;
    private final Queue<Task> tasks = new ConcurrentLinkedDeque<>();

    public PopulationLife(ArrayList<Organism> organisms, int x, int y, Location island) {
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
        } finally {
            island.getLock().unlock();
        }

        for (Task t : tasks) {
            t.taskQueue();
        }
        tasks.clear();
    }
}