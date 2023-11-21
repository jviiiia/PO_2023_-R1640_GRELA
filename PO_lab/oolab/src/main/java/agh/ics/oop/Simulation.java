package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final WorldMap map;
    private final List<Animal> animals;
    private final List<MoveDirection> directions;

    public Simulation(WorldMap map, List<Vector2d> startingPositions, List<MoveDirection> directions) {
        this.map = map;
        this.animals = new ArrayList<>();
        for (Vector2d position : startingPositions) {
            Animal animal = new Animal(position);
            this.animals.add(animal);
            map.place(animal);
        }

        this.directions = directions;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void run() {
        System.out.println(animals);

        int numberOfAnimals = animals.size();
        int numberOfMoves = directions.size();

        int i = 0;
        for (MoveDirection currentMove : directions) {
            Animal currentAnimal = animals.get(i % numberOfAnimals);
            currentAnimal.move(currentMove, map);
            System.out.println("Animal " + i % numberOfAnimals + ": " + currentAnimal);
            i++;
        }
    }
}





}


