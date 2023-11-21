package agh.ics.oop.model;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;

    public Animal() {
        this.position = new Vector2d(2, 2);
        this.orientation = MapDirection.NORTH;

    }

    public Animal(Vector2d startingPosition) {
        this.position = startingPosition;
        this.orientation = MapDirection.NORTH;
    }

    @Override
    public String toString() {
        return switch (orientation) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case EAST -> ">";
            case WEST -> "<";
            default -> "?";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public Vector2d getPosition() {

        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public void move(MoveDirection direction, MoveValidator validator) {
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> moveForward();
            case BACKWARD -> moveBackward();
            default -> System.out.println("Unknown direction.");
        }
    }

    private void moveForward() {
        Vector2d newPosition = position.add(orientation.toUnitVector());
        if (isInsideMap(newPosition)) {
            position = newPosition;
        }
    }

    private void moveBackward() {
        Vector2d newPosition = position.subtract(orientation.toUnitVector());
        if (isInsideMap(newPosition)) {
            position = newPosition;
        }
    }

    private boolean isInsideMap(Vector2d newPosition) {
        return newPosition.follows(new Vector2d(0, 0)) && newPosition.precedes(new Vector2d(4, 4));
    }
}
