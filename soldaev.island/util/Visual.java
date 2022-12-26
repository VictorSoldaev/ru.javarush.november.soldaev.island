package util;

import entities.World;
import servis.StartedNewLife;
import setting.BaseStatsUnit;
import setting.Setting;

import java.util.Scanner;

public class Visual {

    private final String welcomeToThisWorld = "Welcome to this world";
    private final String creatWorld = "Do you want to set the settings of this world yourself?";
    private final String YESANDNO = "Enter (yes/no) : Y/N";

    private final String enterthequantity = "Enter the quantity";
    private final String Herbivores = "Herbivores: ";
    private final String Predators = "Predators: ";
    private final String Plant = "Plant: ";
    private final String timeline = "The life time of the world: ";
    private final String invalidinput = "invalid input";
    private final String x = "Enter the length of the world";
    private final String y = "Enter the width of the world";
    private final Scanner scanner = new Scanner(System.in);
    private Setting setting = new Setting();
    private BaseStatsUnit baseStatsUnit = new BaseStatsUnit();
    private World world = new World();
    private StartedNewLife startedNewLife;

    public void startIland() {

        while (true) {
            print(welcomeToThisWorld);
            print(creatWorld);
            print(YESANDNO);
            String s = scanner.nextLine();
            if (s.equalsIgnoreCase("Y")) {
                createWorldParameters();
                break;
            } else if (s.equalsIgnoreCase("N")) {
                createWorldParametersDefoliate();
                break;
            }
            print(invalidinput);
        }

    }

    private void createWorldParameters() {
        print(enterthequantity);
        print(Predators);
        String r = scanner.nextLine();
        int predators = scanner.nextInt();
        print(Herbivores);
        int herbivores = scanner.nextInt();
        print(Plant);
        int plant = scanner.nextInt();
        print(timeline);
        int timline = scanner.nextInt();
        print(x);
        int x = scanner.nextInt();
        print(y);
        int y = scanner.nextInt();
        world = new World(x, y);
        world.createLife(predators, herbivores, plant);
        startedNewLife = new StartedNewLife(world.getIslend(), timline);
        startedNewLife.start();
    }

    private void createWorldParametersDefoliate() {
        world = new World();
        world.createLife();
        startedNewLife = new StartedNewLife(world.getIslend());
        startedNewLife.start();
    }

    private <T> void print(T text) {
        System.out.println(text);
    }
}