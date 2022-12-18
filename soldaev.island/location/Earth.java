package location;

import unit.Organizm;


import java.util.ArrayList;
import java.util.HashMap;


public class Earth extends Location {

    private int coordinateX;
    private int coordinateY;

    private HashMap<Integer, ArrayList<Organizm>> land = new HashMap<>();

    public Earth(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        createLand();
    }

    private void createLand() {
        for (int i = 0; i < coordinateX; i++) {
            land.put(i, new ArrayList<>());
        }
    }

    public void add(Organizm unit, int coordinateX) {
        land.get(coordinateX).add(unit);
        // проверка лимита колличества (метод)
        // проверяем свободна ячейка? (метод)
        // добавляем в этом методе
    }

    public boolean isAdd(int x) {
        boolean isAdd = false;
        int size = land.get(x).size();
        isAdd = coordinateY > size;
        return isAdd;
    }

    public Organizm getOrganizm(int coordinateX, int coordinateY){
        return this.land.get(coordinateX).get(coordinateY);
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
}
