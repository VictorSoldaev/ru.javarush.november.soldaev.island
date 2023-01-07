package setting;

public class BaseStatsUnit {
//    public static final BaseStatsUnit STATS_BASE_WOLF = new BaseStatsUnit(50F, 30, 3, 8F);
//    public static final BaseStatsUnit STATS_BASE_PYTHON = new BaseStatsUnit(15F, 30, 1, 3F);
//    public static final BaseStatsUnit STATS_BASE_FOX = new BaseStatsUnit(8F, 30, 2, 2F);
//    public static final BaseStatsUnit STATS_BASE_BEAR = new BaseStatsUnit(500F, 5, 2, 80F);
//    public static final BaseStatsUnit STATS_BASE_EAGLE = new BaseStatsUnit(6F, 20, 3, 1F);
//    public static final BaseStatsUnit STATS_BASE_HORSE = new BaseStatsUnit(400F, 20, 4, 60F);
//    public static final BaseStatsUnit STATS_BASE_DEER = new BaseStatsUnit(300F, 20, 4, 50F);
//    public static final BaseStatsUnit STATS_BASE_RABBIT = new BaseStatsUnit(2, 150, 2, 0.45F);
//    public static final BaseStatsUnit STATS_BASE_MOUSE = new BaseStatsUnit(0.05F, 500, 1, 0.01F);
//    public static final BaseStatsUnit STATS_BASE_GOAT = new BaseStatsUnit(60F, 140, 3, 10F);
//    public static final BaseStatsUnit STATS_BASE_SHEEP = new BaseStatsUnit(70F, 140, 3, 15F);
//    public static final BaseStatsUnit STATS_BASE_HOG = new BaseStatsUnit(400F, 50, 2, 50F);
//    public static final BaseStatsUnit STATS_BASE_BUFFALO = new BaseStatsUnit(700F, 10, 3, 100F);
//    public static final BaseStatsUnit STATS_BASE_DUCK = new BaseStatsUnit(1F, 200, 4, 0.15F);
//    public static final BaseStatsUnit STATS_BASE_CATERPILLAR = new BaseStatsUnit(0.01F, 1000, 0, 0);
//    public static final BaseStatsUnit STATS_BASE_GRASS = new BaseStatsUnit(1F, 200, 0, 0);


    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getMaxNumberPerLocation() {
        return MaxNumberPerLocation;
    }

    public void setMaxNumberPerLocation(int maxNumberPerLocation) {
        MaxNumberPerLocation = maxNumberPerLocation;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getSatiety() {
        return satiety;
    }

    public void setSatiety(float satiety) {
        this.satiety = satiety;
    }

    public float weight;
    public int MaxNumberPerLocation;
    public int speed;
    public float satiety;

    public BaseStatsUnit(float weight, int maxNumberPerLocation, int speed, float satiety) {
        this.weight = weight;
        this.MaxNumberPerLocation = maxNumberPerLocation;
        this.speed = speed;
        this.satiety = satiety;

    }

    public BaseStatsUnit() {
    }
}

