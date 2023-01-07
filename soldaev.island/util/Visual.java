package util;

import entities.World;
import service.StartedNewLife;
import setting.BaseStatsUnit;
import setting.Setting;

import java.util.Scanner;

public class Visual {
    private final String welcomeToThisWorld = "Welcome to this world";
    private final String creatWorld = "Do you want to set the settings of this world yourself?";
    private final String yesAndNo = "Enter (yes/no) : Y/N";
    private final String enterthequantity = "Enter the quantity";
    private final String herbivores = "Herbivores: ";
    private final String predators = "Predators: ";
    private final String plant = "Plant: ";
    private final String timeline = "The lifetime of the world in seconds: ";
    private final String invalidinput = "invalid input";
    private final String length = "Enter the length of the world";
    private final String width = "Enter the width of the world";
    private final Scanner scanner = new Scanner(System.in);
    private Setting setting = new Setting();
    private BaseStatsUnit baseStatsUnit = new BaseStatsUnit();
    private World world;
    private StartedNewLife startedNewLife;


    public void startIland() {
        setting.readTheWorldSettings();
        setting.customizeTheWorld();

        while (true) {
            print(welcomeToThisWorld);
            print(creatWorld);
            print(yesAndNo);
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
        print(predators);
        int predators = scanner.nextInt();
        print(herbivores);
        int herbivores = scanner.nextInt();
        print(plant);
        int plant = scanner.nextInt();
        print(timeline);
        int timline = scanner.nextInt();
        print(length);
        int x = scanner.nextInt();
        print(width);
        int y = scanner.nextInt();
        world = new World(x, y, timline);
        world.createLife(predators, herbivores, plant);
        startedNewLife = new StartedNewLife(world);
        startedNewLife.start();
    }

    private void createWorldParametersDefoliate() {
        world = new World();
        world.createLife(world.getNumberOfPredator(), world.getNumberOfHerbivore(), world.getNumberOfGrass());
        startedNewLife = new StartedNewLife(world);
        startedNewLife.start();
    }

    private <T> void print(T text) {
        System.out.println(text);
    }
}