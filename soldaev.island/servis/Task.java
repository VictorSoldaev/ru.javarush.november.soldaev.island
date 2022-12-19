package servis;
// In development
public class Task implements Runnable {
    int taskNit;
    World world = new World();

    public Task(int taskNit) {
        this.taskNit = taskNit;
    }

    @Override
    public void run() {
        try {
            world.start(taskNit);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
