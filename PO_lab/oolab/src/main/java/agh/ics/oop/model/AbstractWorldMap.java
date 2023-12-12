package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {

    protected Map<Vector2d, Animal> animals = new HashMap<>();
    protected List<MapChangeListener> observers = new ArrayList<>();
    protected UUID id;

    public AbstractWorldMap() {
        this.id = UUID.randomUUID();
    }

    @Override
    public UUID getId() {
        return id;
    }

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
            notifyObservers("Animal moved to " + animal.getPosition());
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

    protected void notifyObservers(String message) {
        for (MapChangeListener observer : observers) {
            observer.mapChanged(this, message);
        }
    }
}
