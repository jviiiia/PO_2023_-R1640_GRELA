package agh.ics.oop.model;

import javax.xml.validation.Validator;
import java.util.Vector;

public class Animal implements WorldElement{
    public static final Vector2d LOW_BOUNDARY = new Vector2d(0, 0);
    public static final Vector2d UP_BOUNDARY = new Vector2d(4, 4);

    private Vector2d position;
    private MapDirection orientation;


    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }


    public Animal() {
        this(new Vector2d(2, 2));
    }


    public Animal(Vector2d position) {
        this.position = position;
        this.orientation = MapDirection.NORTH;
    }

    @Override
    public String toString() {
        return orientation.toSymbol();
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
        //return Object.equals(this.position, position);

    }


    public void move(MoveDirection direction, MoveValidator validator) {
        orientation = switch (direction) {
            case RIGHT -> orientation.next();
            case LEFT -> orientation.previous();
            case FORWARD, BACKWARD -> orientation;
        };
        Vector2d newPosition = switch (direction) {
            case FORWARD -> position.add(orientation.toUnitVector());
            case BACKWARD -> position.subtract(orientation.toUnitVector());
            case LEFT, RIGHT -> position;
        };
        if (validator.canMoveTo(newPosition)) {
            this.position = newPosition;
        }
    }
}