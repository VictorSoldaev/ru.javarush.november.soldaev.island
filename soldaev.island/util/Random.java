package util;

import java.util.concurrent.ThreadLocalRandom;


public interface Random {
    default int random(int t, int n) {
        return ThreadLocalRandom.current().nextInt(t, n);
    }
}
