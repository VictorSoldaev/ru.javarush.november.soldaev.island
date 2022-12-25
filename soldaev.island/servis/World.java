package servis;

import location.Earth;
import unit.animal.*;
import unit.plant.Grass;


public class World {
 //   private UnitFactory factory = new UnitFactory();
    Random random = new Random();

    public Earth getEarth() {
        return earth;
    }

    private Earth earth;

    public World() {
        this.earth = new Earth(10, 10);

    }

    public World(int sizeX, int sizeY) {
        this.earth = new Earth(sizeX, sizeY);

    }


    public void createLife() {
        System.out.println("Населяем мир");

        for (int i = 0; i < 10; i++) {
            earth.add(new Bear(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Buffalo(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Caterpillar(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Deer(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Duck(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Eagle(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Fox(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Goat(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }


        for (int i = 0; i < 10; i++) {
            earth.add(new Hog(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Horse(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Mouse(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Python(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Rabbit(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 10; i++) {
            earth.add(new Sheep(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }

        for (int i = 0; i < 12; i++) {
            earth.add(new Wolf(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }


        for (int i = 0; i < 150; i++) {
            earth.add(new Grass(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }


    }
    public void createLife(int trava){
        for (int i = 0; i < trava; i++) {
            earth.add(new Grass(), random.random(earth.getMIN_SIZE_ISLEND_X(), earth.getMaxSizeIslendX()), random.random(earth.getMIN_SIZE_ISLEND_Y(), earth.getMaxSizeIslendY()));
        }
    }

}