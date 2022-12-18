package unit.animal;


import location.Earth;
import setting.BaseStatsUnit;
import unit.Organizm;
import java.util.ArrayList;


public abstract class Animal extends Organizm {

    public abstract void eat(int x, int y , Earth earth);

    public abstract void move(int x, int y , Earth earth);

    public abstract Animal multiply(int x, int y , Earth earth);



}
