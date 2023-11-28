package agh.ics.oop.model;


public class Animal implements WorldElement {
    private Vector2d position;
    private MapDirection orientation;
    private final Vector2d lowerLeft = new Vector2d(0,0);
    private final Vector2d upperRight = new Vector2d(9,9);

    public Animal(){
        this.position = new Vector2d(2,2);
        this.orientation = MapDirection.NORTH;
    }
    public Animal( Vector2d initialPosition){
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    public String toString(){
        switch (orientation) {
            case NORTH:
                return "^";
            case SOUTH:
                return "v";
            case WEST:
                return "<";
            case EAST:
                return ">";
            default:
                return "?";
        }
    }
    public boolean isAt(Vector2d targetPosition){
        return this.position.equals(targetPosition);
    }
    public Vector2d getPosition(){
        return position;
    }
    public MapDirection getOrientation(){
        return orientation;
    }

    public void move(MoveDirection direction, MoveValidator validator) {
        switch (direction) {
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case FORWARD -> {
                Vector2d newPosition = position.add(orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)) {
                    position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = position.subtract(orientation.toUnitVector());
                if (validator.canMoveTo(newPosition)) {
                    position = newPosition;
                }
            }
        }
    }
}
