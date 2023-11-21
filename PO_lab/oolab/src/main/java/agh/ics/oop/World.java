package agh.ics.oop;
import agh.ics.oop.model.*;
import agh.ics.oop.model.util.*;

import java.util.List;

public class World {
    public static void main (String[] args){

        // Wyświetlamy całą mapę
        //System.out.println(visualizer.draw(new Vector2d(0, 0), new Vector2d(9, 9)));
        WorldMap map = new RectangularMap(10,10);
        MapVisualizer visualizer = new MapVisualizer(map);
        Animal animal1 = new Animal(new Vector2d(2,4));
        Animal animal2 = new Animal(new Vector2d(5,7));


        animal1.move(MoveDirection.BACKWARD, map);
        animal2.move(MoveDirection.BACKWARD, map);
        animal2.move(MoveDirection.LEFT, map);
        animal2.move(MoveDirection.FORWARD, map);
        animal2.move(MoveDirection.FORWARD, map);



        map.place(animal1);
        map.place(animal2);

        System.out.println("Movement status:");
        System.out.println(visualizer.draw(new Vector2d(0, 0), new Vector2d(9, 9)));

    };
}


