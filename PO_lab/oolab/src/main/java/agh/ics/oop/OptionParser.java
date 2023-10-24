package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class OptionParser {
    public static MoveDirection[] parse(String[] args) {
        MoveDirection[] directions = new MoveDirection[args.length];

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            directions[i] = switch (arg) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default -> throw new IllegalArgumentException(arg + "is not legal move specification");
            };
        }

        return directions;
    }
}


