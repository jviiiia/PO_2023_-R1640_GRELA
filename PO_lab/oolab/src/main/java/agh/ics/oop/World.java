import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("System started");

        Animal animal = new Animal();
        List<MoveDirection> moveAnimal = OptionParser.parse(args);
        List<MoveDirection> directions = OptionParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();
        run(moveAnimal, animal);
        Vector2d animalPosition = animal.getPosition();
        System.out.println("Animal's position: " + animalPosition);

        //Vector2d position1 = new Vector2d(1, 2);
        //System.out.println(position1);
        //Vector2d position2 = new Vector2d(-2, 1);
        //System.out.println(position2);
        //System.out.println(position1.add(position2));
        //MapDirection direction = MapDirection.NORTH;
        //System.out.println("Direction: " + direction);
        //System.out.println("Next: " + direction.next());
        //System.out.println("Previous: " + direction.previous());
        //System.out.println("Unit Vector: " + direction.toUnitVector());

        System.out.println("System finished");
    }

    public static void run(List<MoveDirection> moveAnimal, Animal animal) {
        for (MoveDirection moveDirection : moveAnimal) {
            switch (moveDirection) {
                case FORWARD -> animal.move(MoveDirection.FORWARD);
                case BACKWARD -> animal.move(MoveDirection.BACKWARD);
                case RIGHT -> animal.move(MoveDirection.RIGHT);
                case LEFT -> animal.move(MoveDirection.LEFT);
                default -> throw new IllegalStateException("Unexpected value: " + moveDirection);
                }
            }
        }
    }
