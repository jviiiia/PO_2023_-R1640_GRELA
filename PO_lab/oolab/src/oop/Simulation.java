package agh.ics.oop;
import agh.ics.oop.model.*;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private final WorldMap map;
    private final List<Animal> animals;
    private final List<MoveDirection> moves;

    public Simulation(List<Vector2d> positions, List<MoveDirection> moves, WorldMap map) {
        this.animals = new ArrayList<>();
        this.moves = moves;
        this.map = map;
        createAnimals(positions);
    }

    private void createAnimals(List<Vector2d> positions){
        for (Vector2d position : positions) {
            Animal animal = new Animal(position);
            try {
                map.place(animal);
                animals.add(animal);
            } catch (PositionAlreadyOccupiedException e) {
                System.err.println("Position is already occupied: " + e.getMessage());
            }
        }
    }

    public void run() {
        int numAnimals = animals.size();
        int numMoves = moves.size();
        for (int index=0; index < numMoves; index++) {
            MoveDirection currentMove = moves.get(index);
            int animalIndex = index % numAnimals;
            Animal currentAnimal = animals.get(animalIndex);

            map.move(currentAnimal, currentMove);
            System.out.println(map);
        }
    }
}
