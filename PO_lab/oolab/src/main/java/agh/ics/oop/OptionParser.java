package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;

// lab2
//public class OptionParser {
//   public static MoveDirection[] parse(String[] args) {
//        MoveDirection[] directions = new MoveDirection[args.length];
//
//        for (int i = 0; i < args.length; i++) {
//            String arg = args[i];
//            directions[i] = switch (arg) {
//                case "f" -> MoveDirection.FORWARD;
//                case "b" -> MoveDirection.BACKWARD;
//                case "r" -> MoveDirection.RIGHT;
//                case "l" -> MoveDirection.LEFT;
//                default -> throw new IllegalArgumentException(arg + "is not legal move specification");
//            };
//        }
//
//        return directions;
//    }
//}

//lab4
import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.List;

public class OptionParser {
    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> directions = new ArrayList<>();

        for (String arg : args) {
            MoveDirection direction = switch (arg) {
                case "f" -> MoveDirection.FORWARD;
                case "b" -> MoveDirection.BACKWARD;
                case "r" -> MoveDirection.RIGHT;
                case "l" -> MoveDirection.LEFT;
                default -> null;
            };

            if (direction != null) {
                directions.add(direction);
            }
        }

        return directions;
    }
}





