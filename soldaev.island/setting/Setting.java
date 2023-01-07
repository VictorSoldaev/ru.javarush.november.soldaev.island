package setting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Setting {
    private static Setting setting;
    public static HashMap<String, HashMap<String, Integer>> food = new HashMap<>();
    public static HashMap<String, BaseStatsUnit> statsUnit = new HashMap<>();
    public static HashMap<String, Integer> settingWorld = new HashMap<>();
    public HashMap<String, HashMap<String, Integer>> foodTable = new HashMap<>();
    public HashMap<String, BaseStatsUnit> baseStatsUnit = new HashMap<>();
    public HashMap<String, Integer> defaultSettingWorld = new HashMap<>();

    public Setting() {

    }

    public void readTheWorldSettings(){
        try {
            setting = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).readValue(new File("soldaev.island/setting/config/startingWorldSettings"), Setting.class);
        } catch (IOException io){
            System.out.println("Configuration file not found");
        }
    }
    public void customizeTheWorld() {
        food = setting.foodTable;
        statsUnit = setting.baseStatsUnit;
        settingWorld = setting.defaultSettingWorld;
    }


}
