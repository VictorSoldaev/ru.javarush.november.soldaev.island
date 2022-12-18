package servis;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartWorld {
    public void start(int x) {

        ExecutorService executorService = Executors.newFixedThreadPool(x);
        for (int i = 0; i < x; i++) {
            executorService.execute(new Task(i));
        }
    }
}
