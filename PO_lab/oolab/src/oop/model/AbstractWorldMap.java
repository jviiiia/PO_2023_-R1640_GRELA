package agh.ics.oop.model;
import agh.ics.oop.model.util.MapVisualizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {

    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected List<MapChangeListener> observers = new ArrayList<>();

    @Override
    public abstract Boundary getCurrentBounds();

    @Override
    public boolean place(Animal animal) throws PositionAlreadyOccupiedException {
        if (!animals.containsKey(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            return true;
        } else {
            throw new PositionAlreadyOccupiedException(animal.getPosition());
        }
    }

    public void addObserver(MapChangeListener observer) {
        observers.add(observer);
    }

    public void removeObserver(MapChangeListener observer) {
        observers.remove(observer);
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        Vector2d newPosition = animal.getPosition().add(animal.getOrientation().toUnitVector());
        if (canMoveTo(newPosition) && !animals.containsKey(newPosition)) {
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            animals.put(animal.getPosition(), animal);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals.values());
    }

    @Override
    public Collection<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Boundary bounds = getCurrentBounds();
        return visualizer.draw(bounds.lowerLeft(), bounds.upperRight());
    }
}
