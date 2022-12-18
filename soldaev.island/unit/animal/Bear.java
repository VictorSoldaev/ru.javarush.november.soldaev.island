package unit.animal;

import servis.TypAnimal;
import setting.BaseStatsUnit;
import setting.Setting;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

public class Bear extends Animal {

    private float satiety;
    private float hp;

    public Bear(){
        this.satiety = BaseStatsUnit.STATS_BASE_BEAR.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_BEAR.weight;
    }

    @Override
    public void toEat(Animal organizm) throws NoSuchFieldException, IllegalAccessException {
        String foodName = organizm.getClass().getSimpleName();
        Integer foodTableBearProbability = Setting.foodTable.get("Bear").get(foodName);
        int probability = ThreadLocalRandom.current().nextInt(foodTableBearProbability, 101);
        Field field = organizm.getClass().getDeclaredField("hp");
        field.setAccessible(true);
        float satietyPositive = (float) field.get(organizm);
        if(probability == 100){
            System.out.println("Медведь скушал " + foodName);
            satiety = satiety + satietyPositive;
        } else {
            System.out.println("Медведь не скушал " + foodName);
        }

    }


    @Override
    public void move() {

    }

    @Override
    public TypAnimal multiply() {
        return TypAnimal.BEAR;
    }

    public float getSatiety() {
        return satiety;
    }

    public void setSatiety(float satiety) {
        this.satiety = satiety;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }
}
