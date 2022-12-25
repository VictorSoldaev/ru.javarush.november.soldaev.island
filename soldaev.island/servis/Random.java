package servis;


import java.util.concurrent.ThreadLocalRandom;

public class Random {
     public int random(int t, int n){
         return ThreadLocalRandom.current().nextInt(t,n);
     }
}
