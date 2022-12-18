package unit.animal;

import unit.Organizm;

import java.util.ArrayList;

public interface Herbivore {
    default boolean lookingForGrass(ArrayList<Organizm> stepFood){
        // получаем список травы
        // если она есть кушаем
        // пере определяем метод для утки и ее подобных если нет травы ищем гусеницу
        return true;
    }
}
