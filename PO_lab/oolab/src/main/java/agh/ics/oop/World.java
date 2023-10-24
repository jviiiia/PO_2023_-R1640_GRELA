package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args) {
        System.out.println("System started"); //wyświetlenie komunikatu na początku programu
        MoveDirection[] moveAnimal = OptionParser.parse(args); //zmiana argumentów wywołania programu na kierunki ruchu
        run(moveAnimal); //wywołanie funkcji run, która przekazuje kierunki ruchu
        System.out.println("System finished"); // wyświetlenie komunikatu na zakończenie programu
    }

    public static void run(MoveDirection[] moveAnimal) {
        for (MoveDirection moveDirection : moveAnimal) {
            switch (moveDirection) {
                case FORWARD -> System.out.println("The animal is moving forward");
                case BACKWARD -> System.out.println("The animal is moving backward");
                case RIGHT -> System.out.println("The animal is turning right");
                case LEFT -> System.out.println("The animal is turning left");
                default -> {
                    // Wyrzucenie wyjątku w przypadku nieoczekiwanego kierunku
                    throw new IllegalStateException("Unexpected value: " + moveDirection);
                }
            }
        }
    }
}