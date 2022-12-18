package servis;

public class Task implements Runnable{
    int taskNit;
    World world = new World();
    public Task(int taskNit){
        this.taskNit = taskNit;
    }

    @Override
    public void run() {
        world.start(taskNit);
    }
}
