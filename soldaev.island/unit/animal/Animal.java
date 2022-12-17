package unit.animal;


import servis.TypAnimal;
import unit.Organizm;



public abstract class Animal extends Organizm {
    private float satiety;
    private float hp;

    public void toEat(Animal organizm) throws NoSuchFieldException, IllegalAccessException {
        // проверка можно но ли скушать () -> какой шанс подброс кубика
        // скушал list.remove()
        // пополнил сытость -> если она выше необходимой то сделать просто полной

    }

    public void move(){
        // проверка есть ли пустое место? -> занять его
        // если нет поиск ближайших мест на велечину скорости
    }

    public TypAnimal multiply(){
        return null;
    }


}
