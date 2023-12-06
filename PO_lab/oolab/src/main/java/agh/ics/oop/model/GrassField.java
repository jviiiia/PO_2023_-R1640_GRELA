package agh.ics.oop.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GrassField extends AbstractWorldMap {
    int fieldCount;
    Map<Vector2d, Grass> grasses;

    public GrassField(int fieldCount) {
        this.fieldCount = fieldCount;
        grasses = new HashMap<>();
        animals = new HashMap<>();
        this.width = (int) Math.floor(Math.sqrt(fieldCount * 10));
        this.height = (int) Math.floor(Math.sqrt(fieldCount * 10));
        generateGrasses();
    }

    private void generateGrasses() {
        Set<Vector2d> usedPositions = new HashSet<>();
        for (int i = 0; i < fieldCount; i++) {
            Vector2d randomPosition;
            do {
                randomPosition = new Vector2d((int) (Math.random() * width), (int) (Math.random() * height));
            } while (usedPositions.contains(randomPosition) || animals.containsKey(randomPosition));

            usedPositions.add(randomPosition);
            grasses.put(randomPosition, new Grass(randomPosition));
        }
    }


    @Override
    public boolean place(Animal animal) {
        Vector2d animalPosition = animal.getPosition();
        if (!canMoveTo(animalPosition) || animals.containsKey(animalPosition)) {
            return false;
        }
        animals.put(animalPosition,animal );
        return true;
    }

    public boolean canMoveTo(Vector2d position){

        if(position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(width -1,height-1)) && !animals.containsKey(position)){
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

        Vector2d newPosition = animal.getPosition().add(direction.toUnitVector());
        if (canMoveTo(newPosition) && !animals.containsKey(newPosition)) {
            animals.remove(animal.getPosition());
            animal.move(direction,this);
            animals.put(animal.getPosition(), animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {

        if( grasses.containsKey(position) )return true;
        return  super.isOccupied(position);

    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if(animals.get(position) != null)
            return animals.get(position);
        if(grasses.get(position) != null)
            return grasses.get(position);
        return null;
    }

}
