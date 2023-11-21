package agh.ics.oop;
import agh.ics.oop.model.Animal;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.List;


public class Simulation {
    private List<Animal> animals;
    private List<MoveDirection> directions;

    public Simulation(List<Vector2d> initialPositions, List<MoveDirection> directions) {
        this.animals = new ArrayList<>();
        for (Vector2d position : initialPositions) {
            this.animals.add(new Animal(position));
        }
        // inicjowanie listy ruchów
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
            currentAnimal.move(currentMove);
            System.out.println("Animal " + i % numberOfAnimals + ": " + currentAnimal.toString());
            i++;
        }
    }





}


