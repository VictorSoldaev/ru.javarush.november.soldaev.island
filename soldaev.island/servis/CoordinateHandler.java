package servis;

import location.Earth;
import java.util.concurrent.ThreadLocalRandom;

public interface CoordinateHandler {
    default int getCoordinateX(int coordinate, Earth earth, int step) {
        int coordinateX = coordinate + ThreadLocalRandom.current().nextInt(-step, step);
        if (coordinateX > earth.getMaxSizeIslendX()) {
            return 0 + coordinateX - earth.getMaxSizeIslendX();
        } else if (coordinateX < 0) {
            return earth.getMaxSizeIslendX() - coordinateX;
        }
        return coordinateX;
    }

    default int getCoordinateY(int coordinate, Earth earth, int step) {
        int coordinateY = coordinate + ThreadLocalRandom.current().nextInt(-step, step);
        if (coordinateY > earth.getMaxSizeIslendY()) {
            return 0 + coordinateY - earth.getMaxSizeIslendY();
        } else if (coordinateY < 0) {
            return earth.getMaxSizeIslendY() - coordinateY;
        }
        return coordinateY;
    }
}
