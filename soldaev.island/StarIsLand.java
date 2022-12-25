import servis.StartWorld;
import servis.World;
import setting.BaseStatsUnit;
import setting.Setting;

public class StarIsLand {
    public static void main(String[] args)  {
        Setting setting = new Setting();
        BaseStatsUnit baseStatsUnit = new BaseStatsUnit();
        World world = new World();
        world.createLife();
        StartWorld startWorld = new StartWorld(world);
        startWorld.start();


    }
}
