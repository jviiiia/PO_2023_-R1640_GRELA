package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("System started");

        try {
            List<MoveDirection> directions = OptionsParser.parse(args);

            List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));

            GrassField grassField = new GrassField(10);

            WorldMap worldMap = grassField;

            ConsoleMapDisplay observer1 = new ConsoleMapDisplay();
            worldMap.addObserver(observer1);

            Simulation simulation = new Simulation(positions, directions, worldMap);
            simulation.run();
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid argument: " + e.getMessage());
            System.exit(1);
        }

        System.out.println("System ended");
    }

    public static void run(MoveDirection[] parsedArgs) {
        for (MoveDirection moveDirection : parsedArgs) {
            switch (moveDirection) {
                case FORWARD -> System.out.println("Animal is going forward");
                case BACKWARD -> System.out.println("Animal is going backward");
                case LEFT -> System.out.println("Animal is turning left");
                case RIGHT -> System.out.println("Animal is turning right");
            }
        }
    }
}
