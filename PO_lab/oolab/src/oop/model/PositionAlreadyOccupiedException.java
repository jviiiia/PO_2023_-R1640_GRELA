package agh.ics.oop.model;
import agh.ics.oop.model.Vector2d;

import java.security.cert.Extension;
public class PositionAlreadyOccupiedException extends Exception {
    public PositionAlreadyOccupiedException(Vector2d position){
        super("Position" + position.toString() + "is already occupied");
    }
}