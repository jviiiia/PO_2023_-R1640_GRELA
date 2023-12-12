package agh.ics.oop.model;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.util.MapVisualizer;

import javax.swing.*;
import java.util.Collection;
import java.util.*;

public class GrassField extends AbstractWorldMap {
    protected Map<Vector2d, Grass> grassMap = new HashMap<>();

    public GrassField(int grassCount){
        placeGrass(grassCount);
    }

    private void placeGrass(int grassAmount){
        int placedGrassCount = 0;
        Random random = new Random();
        double grassBound = Math.sqrt(grassAmount * 10);

        while (placedGrassCount < grassAmount){
            int x = random.nextInt((int) grassBound);
            int y = random.nextInt((int) grassBound);
            Vector2d grassPosition = new Vector2d(x,y);

            if (!grassMap.containsKey(grassPosition)){
                grassMap.put(grassPosition, new Grass(grassPosition));
                placedGrassCount++;
            }
        }
    }

    @Override
    public Boundary getCurrentBounds() {
        Vector2d lowerLeft=calculateLowerLeft();
        Vector2d upperRight=calculateUpperRight();

        return new Boundary(lowerLeft, upperRight);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        WorldElement worldElement = super.objectAt(position);
        if (worldElement == null) {
            return grassMap.get(position);
        }
        return worldElement;
    }


    private Vector2d calculateLowerLeft(){
        Vector2d minVector = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);


        for(Vector2d position : animals.keySet()){
            minVector = minVector.lowerLeft(position);
        }

        for (Vector2d position : grassMap.keySet()){
            minVector = minVector.lowerLeft(position);
        }
        return minVector;
    }

    private Vector2d calculateUpperRight(){
        Vector2d maxVector = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);


        for (Vector2d position : animals.keySet()){
            maxVector = maxVector.upperRight(position);
        }

        for (Vector2d position : grassMap.keySet()){
            maxVector = maxVector.upperRight(position);
        }
        return maxVector;
    }

    public List<Grass> getGrass() {
        return new ArrayList<>(grassMap.values());
    }

    @Override
    public Collection<WorldElement> getElements(){
        var elements = super.getElements();
        elements.addAll(grassMap.values());
        return elements;
    }
}
