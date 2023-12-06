package agh.ics.oop.model;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.*;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    int width;
    int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    Map<Vector2d,Animal> animals = new HashMap<>();


    @Override
    public boolean place(Animal animal) {

        Vector2d animalPosition = animal.getPosition();
        if (!canMoveTo(animalPosition) || animals.containsKey(animalPosition)) {
            return false;
        }
        animals.put(animalPosition,animal );
        return true;
    }




    @Override
    public void move(Animal animal, MoveDirection direction) {

        Vector2d newPosition = animal.getPosition().add(direction.toUnitVector());
        if (canMoveTo(newPosition) && !isOccupied(newPosition)) {
            animals.remove(animal.getPosition());
            animal.move(direction,this);
            animals.put(animal.getPosition(), animal); //dalam newPosition zamoast animal.getPosition()
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if( animals.containsKey(position) )return true;
        return false;
    }
    @Override
    public void run(MoveDirection[] directions) {
        for (MoveDirection direction : directions) {
            for (Animal animal : animals.values()) {
                move(animal, direction);
            }
        }
    }


    @Override
    public WorldElement objectAt(Vector2d position) {
        if(animals.get(position) != null)
            return animals.get(position);
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d lowerLeft = new Vector2d(0, 0);
        Vector2d upperRight = new Vector2d(width - 1, height - 1);
        return visualizer.draw(lowerLeft, upperRight);
    }
}
