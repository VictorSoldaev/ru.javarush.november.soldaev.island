package setting;

public class BaseStatsUnit {

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

