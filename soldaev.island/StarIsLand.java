import servis.StartedNewLife;
import entities.World;
import setting.BaseStatsUnit;
import setting.Setting;


public class StarIsLand {
    public static void main(String[] args) {
        Setting setting = new Setting();
        BaseStatsUnit baseStatsUnit = new BaseStatsUnit();
        World world = new World();
        world.createLife();
        StartedNewLife startedNewLife = new StartedNewLife(world.getIslend());
        startedNewLife.start();
    }
}
