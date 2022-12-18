package location;

import unit.Organizm;
import java.util.ArrayList;
import java.util.HashMap;

public class Earth extends Location {
    private int maxSizeIslendX;
    private int maxSizeIslendY;
    private final HashMap<Integer, HashMap<Integer, ArrayList<Organizm>>> island = new HashMap<>();

    public Earth(int maxSizeIslendX, int maxSizeIslendY) {
        this.maxSizeIslendX = maxSizeIslendX;
        this.maxSizeIslendY = maxSizeIslendY;
        createIsland();
    }

    private void createIsland() {
        for (int x = 0; x < maxSizeIslendX; x++) {
            island.put(x, new HashMap<>());
            for(int y = 0; y < maxSizeIslendY; y ++){
                island.get(x).put(y, new ArrayList<>());
            }
        }
    }

    public boolean add(Organizm organizm, int coordinateX, int coordinateY) {
       if (checkAdd(getArrayListAnimals(coordinateX,coordinateY), organizm)) {
           island.get(coordinateY).get(coordinateY).add(organizm);
           return true;
       } else {
           return false;
       }
    }

    public boolean checkAdd(ArrayList<Organizm> animals, Organizm unit) {
        if (animals.get(0) == null){
            return true;
        } else if (animals.get(0).getClass().getSimpleName().equals(unit.getClass().getSimpleName())){
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Organizm> getArrayListAnimals (int coordinateX, int coordinateY) {
        return island.get(coordinateX).get(coordinateY);
    }

    public Organizm getOrganizm (int coordinateX, int coordinateY) {
        return island.get(coordinateX).get(coordinateY).get(0);
    }



    public int getMaxSizeIslendX() {
        return maxSizeIslendX;
    }

    public void setMaxSizeIslendX(int maxSizeIslendX) {
        this.maxSizeIslendX = maxSizeIslendX;
    }

    public int getMaxSizeIslendY() {
        return maxSizeIslendY;
    }

    public void setMaxSizeIslendY(int maxSizeIslendY) {
        this.maxSizeIslendY = maxSizeIslendY;
    }

    public HashMap<Integer, HashMap<Integer, ArrayList<Organizm>>> getIsland() {
        return island;
    }
}
