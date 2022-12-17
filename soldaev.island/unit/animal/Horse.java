package unit.animal;

import setting.BaseStatsUnit;
import setting.Setting;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

public class Horse extends Animal{

    private float satiety;
    private float hp;

    public Horse(){
        this.satiety = BaseStatsUnit.STATS_BASE_HORSE.satiety;
        this.hp = BaseStatsUnit.STATS_BASE_HORSE.weight;
    }

    @Override
    public void toEat(Animal organizm) throws NoSuchFieldException, IllegalAccessException {
        String whoEat = organizm.getClass().getSimpleName();
        Integer bear = Setting.foodTable.get("Bear").get(whoEat);
        int i = ThreadLocalRandom.current().nextInt(bear, 101);
        Field field = organizm.getClass().getDeclaredField("hp");
        field.setAccessible(true);
        float s = (float) field.get(organizm);
        if(i == 100){
            System.out.println("Медведь скушал " + whoEat);
            satiety = satiety + s;
        } else {
            System.out.println("Медведь не скушал " + whoEat);
        }

    }

    @Override
    public void move() {
        super.move();
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
