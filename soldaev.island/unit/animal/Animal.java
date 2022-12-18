package unit.animal;


import servis.TypAnimal;
import unit.Organizm;



public abstract class Animal extends Organizm {
    private float satiety;
    private float hp;

    public abstract void toEat(Animal organizm) throws NoSuchFieldException, IllegalAccessException;

    public abstract void move();

    public abstract TypAnimal multiply();



}
