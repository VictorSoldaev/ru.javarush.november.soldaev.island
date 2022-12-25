package setting;


import java.util.HashMap;

public class Setting {
    public static HashMap<String, HashMap<String, Integer>> foodTable = new HashMap<>();

    // Волк
    {
        HashMap<String, Integer> wolf = new HashMap<>();
        wolf.put("Bear", 0);
        wolf.put("Buffalo", 10);
        wolf.put("Caterpillar", 0);
        wolf.put("Deer", 15);
        wolf.put("Duck", 40);
        wolf.put("Eagle", 0);
        wolf.put("Fox", 0);
        wolf.put("Goat", 60);
        wolf.put("Hog", 15);
        wolf.put("Horse", 10);
        wolf.put("Mouse", 80);
        wolf.put("Python", 0);
        wolf.put("Rabbit", 60);
        wolf.put("Sheep", 70);
        wolf.put("Wolf", 0);
        wolf.put("Grass", 0);
        foodTable.put("Wolf", wolf);
    }

    // Удав
    {
        HashMap<String, Integer> python = new HashMap<>();
        python.put("Bear", 0);
        python.put("Buffalo", 0);
        python.put("Caterpillar", 0);
        python.put("Deer", 0);
        python.put("Duck", 10);
        python.put("Eagle", 0);
        python.put("Fox", 15);
        python.put("Goat", 0);
        python.put("Hog", 0);
        python.put("Horse", 0);
        python.put("Mouse", 40);
        python.put("Python", 0);
        python.put("Rabbit", 20);
        python.put("Sheep", 0);
        python.put("Wolf", 0);
        python.put("Grass", 0);
        foodTable.put("Python", python);
    }

    //Лиса
    {
        HashMap<String, Integer> fox = new HashMap<>();
        fox.put("Wolf", 0);
        fox.put("Python", 0);
        fox.put("Fox", 0);
        fox.put("Bear", 0);
        fox.put("Eagle", 0);
        fox.put("Horse", 0);
        fox.put("Deer", 0);
        fox.put("Rabbit", 70);
        fox.put("Mouse", 90);
        fox.put("Goat", 0);
        fox.put("Sheep", 0);
        fox.put("Hog", 0);
        fox.put("Buffalo", 0);
        fox.put("Duck", 60);
        fox.put("Caterpillar", 40);
        fox.put("Grass", 0);
        foodTable.put("Fox", fox);
    }

    // Медведь
    {
        HashMap<String, Integer> bear = new HashMap<>();
        bear.put("Wolf", 0);
        bear.put("Python", 80);
        bear.put("Fox", 0);
        bear.put("Bear", 0);
        bear.put("Eagle", 0);
        bear.put("Horse", 40);
        bear.put("Deer", 80);
        bear.put("Rabbit", 80);
        bear.put("Mouse", 90);
        bear.put("Goat", 70);
        bear.put("Sheep", 70);
        bear.put("Hog", 50);
        bear.put("Buffalo", 20);
        bear.put("Duck", 10);
        bear.put("Caterpillar", 0);
        bear.put("Grass", 0);
        foodTable.put("Bear", bear);
    }

    // Орел
    {
        HashMap<String, Integer> eagle = new HashMap<>();
        eagle.put("Wolf", 0);
        eagle.put("Python", 0);
        eagle.put("Fox", 10);
        eagle.put("Bear", 0);
        eagle.put("Eagle", 0);
        eagle.put("Horse", 0);
        eagle.put("Deer", 0);
        eagle.put("Rabbit", 90);
        eagle.put("Mouse", 90);
        eagle.put("Goat", 0);
        eagle.put("Sheep", 0);
        eagle.put("Hog", 0);
        eagle.put("Buffalo", 0);
        eagle.put("Duck", 80);
        eagle.put("Caterpillar", 0);
        eagle.put("Grass", 0);
        foodTable.put("Eagle", eagle);
    }

    // Лошадь
    {
        HashMap<String, Integer> horse = new HashMap<>();
        horse.put("Wolf", 0);
        horse.put("Python", 0);
        horse.put("Fox", 0);
        horse.put("Bear", 0);
        horse.put("Eagle", 0);
        horse.put("Horse", 0);
        horse.put("Deer", 0);
        horse.put("Rabbit", 0);
        horse.put("Mouse", 0);
        horse.put("Goat", 0);
        horse.put("Sheep", 0);
        horse.put("Hog", 0);
        horse.put("Buffalo", 0);
        horse.put("Duck", 0);
        horse.put("Caterpillar", 0);
        horse.put("Grass", 100);
        foodTable.put("Horse", horse);
    }

    // Олень
    {
        HashMap<String, Integer> deer = new HashMap<>();
        deer.put("Wolf", 0);
        deer.put("Python", 0);
        deer.put("Fox", 0);
        deer.put("Bear", 0);
        deer.put("Eagle", 0);
        deer.put("Horse", 0);
        deer.put("Deer", 0);
        deer.put("Rabbit", 0);
        deer.put("Mouse", 0);
        deer.put("Goat", 0);
        deer.put("Sheep", 0);
        deer.put("Hog", 0);
        deer.put("Buffalo", 0);
        deer.put("Duck", 0);
        deer.put("Caterpillar", 0);
        deer.put("Grass", 100);
        foodTable.put("Deer", deer);
    }

    // Кролик
    {
        HashMap<String, Integer> rabbit = new HashMap<>();
        rabbit.put("Wolf", 0);
        rabbit.put("Python", 0);
        rabbit.put("Fox", 0);
        rabbit.put("Bear", 0);
        rabbit.put("Eagle", 0);
        rabbit.put("Horse", 0);
        rabbit.put("Deer", 0);
        rabbit.put("Rabbit", 0);
        rabbit.put("Mouse", 0);
        rabbit.put("Goat", 0);
        rabbit.put("Sheep", 0);
        rabbit.put("Hog", 0);
        rabbit.put("Buffalo", 0);
        rabbit.put("Duck", 0);
        rabbit.put("Caterpillar", 0);
        rabbit.put("Grass", 100);
        foodTable.put("Rabbit", rabbit);
    }

    // Мышь
    {
        HashMap<String, Integer> mouse = new HashMap<>();
        mouse.put("Wolf", 0);
        mouse.put("Python", 0);
        mouse.put("Fox", 0);
        mouse.put("Bear", 0);
        mouse.put("Eagle", 0);
        mouse.put("Horse", 0);
        mouse.put("Deer", 0);
        mouse.put("Rabbit", 0);
        mouse.put("Mouse", 0);
        mouse.put("Goat", 0);
        mouse.put("Sheep", 0);
        mouse.put("Hog", 0);
        mouse.put("Buffalo", 0);
        mouse.put("Duck", 0);
        mouse.put("Caterpillar", 90);
        mouse.put("Grass", 100);
        foodTable.put("Mouse", mouse);
    }

    // Коза
    {
        HashMap<String, Integer> goat = new HashMap<>();
        goat.put("Wolf", 0);
        goat.put("Python", 0);
        goat.put("Fox", 0);
        goat.put("Bear", 0);
        goat.put("Eagle", 0);
        goat.put("Horse", 0);
        goat.put("Deer", 0);
        goat.put("Rabbit", 0);
        goat.put("Mouse", 0);
        goat.put("Goat", 0);
        goat.put("Sheep", 0);
        goat.put("Hog", 0);
        goat.put("Buffalo", 0);
        goat.put("Duck", 0);
        goat.put("Caterpillar", 0);
        goat.put("Grass", 100);
        foodTable.put("Goat", goat);
    }

    // Овца
    {
        HashMap<String, Integer> sheep = new HashMap<>();
        sheep.put("Wolf", 0);
        sheep.put("Python", 0);
        sheep.put("Fox", 0);
        sheep.put("Bear", 0);
        sheep.put("Eagle", 0);
        sheep.put("Horse", 0);
        sheep.put("Deer", 0);
        sheep.put("Rabbit", 0);
        sheep.put("Mouse", 0);
        sheep.put("Goat", 0);
        sheep.put("Sheep", 0);
        sheep.put("Hog", 0);
        sheep.put("Buffalo", 0);
        sheep.put("Duck", 0);
        sheep.put("Caterpillar", 0);
        sheep.put("Grass", 100);
        foodTable.put("Sheep", sheep);
    }

    // Кабан
    {
        HashMap<String, Integer> hog = new HashMap<>();
        hog.put("Wolf", 0);
        hog.put("Python", 0);
        hog.put("Fox", 0);
        hog.put("Bear", 0);
        hog.put("Eagle", 0);
        hog.put("Horse", 0);
        hog.put("Deer", 0);
        hog.put("Rabbit", 0);
        hog.put("Mouse", 50);
        hog.put("Goat", 0);
        hog.put("Sheep", 0);
        hog.put("Hog", 0);
        hog.put("Buffalo", 0);
        hog.put("Duck", 0);
        hog.put("Caterpillar", 90);
        hog.put("Grass", 100);
        foodTable.put("Hog", hog);
    }

    // Буйвол
    {
        HashMap<String, Integer> buffalo = new HashMap<>();
        buffalo.put("Wolf", 0);
        buffalo.put("Python", 0);
        buffalo.put("Fox", 0);
        buffalo.put("Bear", 0);
        buffalo.put("Eagle", 0);
        buffalo.put("Horse", 0);
        buffalo.put("Deer", 0);
        buffalo.put("Rabbit", 0);
        buffalo.put("Mouse", 0);
        buffalo.put("Goat", 0);
        buffalo.put("Sheep", 0);
        buffalo.put("Hog", 0);
        buffalo.put("Buffalo", 0);
        buffalo.put("Duck", 0);
        buffalo.put("Caterpillar", 0);
        buffalo.put("Grass", 100);
        foodTable.put("Buffalo", buffalo);
    }

    // Утка
    {
        HashMap<String, Integer> duck = new HashMap<>();
        duck.put("Wolf", 0);
        duck.put("Python", 0);
        duck.put("Fox", 0);
        duck.put("Bear", 0);
        duck.put("Eagle", 0);
        duck.put("Horse", 0);
        duck.put("Deer", 0);
        duck.put("Rabbit", 0);
        duck.put("Mouse", 0);
        duck.put("Goat", 0);
        duck.put("Sheep", 0);
        duck.put("Hog", 0);
        duck.put("Buffalo", 0);
        duck.put("Duck", 0);
        duck.put("Caterpillar", 90);
        duck.put("Grass", 100);
        foodTable.put("Duck", duck);
    }

    // Гусеница
    {
        HashMap<String, Integer> caterpillar = new HashMap<>();
        caterpillar.put("Wolf", 0);
        caterpillar.put("Python", 0);
        caterpillar.put("Fox", 0);
        caterpillar.put("Bear", 0);
        caterpillar.put("Eagle", 0);
        caterpillar.put("Horse", 0);
        caterpillar.put("Deer", 0);
        caterpillar.put("Rabbit", 0);
        caterpillar.put("Mouse", 0);
        caterpillar.put("Goat", 0);
        caterpillar.put("Sheep", 0);
        caterpillar.put("Hog", 0);
        caterpillar.put("Buffalo", 0);
        caterpillar.put("Duck", 0);
        caterpillar.put("Caterpillar", 0);
        caterpillar.put("Grass", 100);
        foodTable.put("Caterpillar", caterpillar);
    }
}
