package agh.ics.oop;
import agh.ics.oop.model.*;
import agh.ics.oop.model.util.*;


import java.util.List;

public class World {
    public static void main (String[] args){
        WorldMap map = new GrassField(15);
        MapVisualizer visualizer = new MapVisualizer(map);
        Animal animal1 = new Animal(new Vector2d(2,4));
        Animal animal2 = new Animal(new Vector2d(5,7));


        map.place(animal1);
        map.place(animal2);

        System.out.println(visualizer.draw(new Vector2d(0, 0), new Vector2d(map.getWidth(), map.getHeight())));


        map.move(animal1,MoveDirection.BACKWARD );
        map.move(animal1,MoveDirection.BACKWARD);
        map.move(animal2,MoveDirection.LEFT);
        map.move(animal2,MoveDirection.FORWARD);
        map.move(animal2,MoveDirection.FORWARD);

        map.place(animal1);
        map.place(animal2);


        System.out.println("Stan gry po ruchu:");
        System.out.println(visualizer.draw(new Vector2d(0, 0), new Vector2d(map.getWidth(), map.getHeight())));


    };

}

