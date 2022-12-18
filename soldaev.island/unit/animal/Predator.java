package unit.animal;

import unit.Organizm;

import java.util.ArrayList;

public interface Predator {
    default boolean hunt(ArrayList<Organizm> stepFood) {
        // получает список фильтрует его по оставляя только травоядных
        // выбирает самую сытную пищу
        // охотиться с шансом даеться попыток N от чего подумать?
        // говорит методу animal.eat поймал или нет
        return false;
    }
}
