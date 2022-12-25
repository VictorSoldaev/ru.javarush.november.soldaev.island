package servis;

import java.util.concurrent.ThreadLocalRandom;

public interface CoordinateHandler {
    default int getCoordinate(int coordinate, int maxSize, int minSize , int step) {
        int coor = coordinate + ThreadLocalRandom.current().nextInt(-step, step);
        if (coor <= 0) {
            return maxSize + (coor - 1);
        } else if (coor > maxSize) {
            return minSize + coor - maxSize;
        }
        return coor;
    }

}
