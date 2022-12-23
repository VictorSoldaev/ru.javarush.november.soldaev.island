package servis;

import java.util.ArrayList;
import java.util.Collection;

public class StartWorld extends Thread{
    World world;
    ArrayList<Task> eqTask = new ArrayList<>();

    public StartWorld(World world) {
        this.world = world;
    }


    public void start() {
        System.out.println("Мир создан");
        int dey = 0;
        while (true) {
            for (int x = world.getEarth().getMIN_SIZE_ISLEND_X(); x <= world.getEarth().getMaxSizeIslendX(); x++) {
                for (int y = world.getEarth().getMIN_SIZE_ISLEND_Y(); y <= world.getEarth().getMaxSizeIslendY(); y++) {
                    if (world.getEarth().getIsland().get(x).get(y).size() == 0) {
                        continue;
                    } else {
                        for (int z = 0; z < world.getEarth().getIsland().get(x).get(y).size(); z++) {
                            if (world.getEarth().getIsland().get(x).get(y).get(z).getClass().getSimpleName().equals("Grass")) {
                                continue;
                            }
                            eqTask.add(new Task(world.getEarth(), x, y, world.getEarth().getIsland().get(x).get(y).get(z)));
                        }
                    }
                }
            }
            for (int i = 0; i < eqTask.size(); i++){
                eqTask.get(i).taskQueue();
            }
            eqTask.clear();
            world.createLife(100);
            dey++;
            System.out.println("Прошел " + dey + " с дня сотворения мира");
            System.out.println(world.getEarth().toString());
            System.out.println("=".repeat(30));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
