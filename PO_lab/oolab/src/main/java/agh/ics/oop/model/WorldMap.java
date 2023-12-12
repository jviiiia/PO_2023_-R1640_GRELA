package agh.ics.oop.model;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

/**
 * The interface responsible for interacting with the map of the world.
 * Assumes that Vector2d and MoveDirection classes are defined.
 *
 * @author apohllo, idzik
 */
public interface WorldMap extends MoveValidator {

    void addObserver(MapChangeListener observer);

    /**
     * Place a animal on the map.
     *
     * @param animal The animal to place on the map.
     * @return True if the animal was placed. The animal cannot be placed if the move is not valid.
     */
    boolean place(Animal animal) throws PositionAlreadyOccupiedException;

    /**
     * Moves an animal (if it is present on the map) according to specified direction.
     * If the move is not possible, this method has no effect.
     */
    void move(Animal animal, MoveDirection direction);

    /**
     * Return true if given position on the map is occupied. Should not be
     * confused with canMove since there might be empty positions where the animal
     * cannot move.
     *
     * @param position Position to check.
     * @return True if the position is occupied.
     */
    default boolean isOccupied(Vector2d position){
        return objectAt(position)!=null;
    }

    /**
     * Return an animal at a given position.
     *
     * @param position The position of the animal.
     * @return animal or null if the position is not occupied.
     */
    WorldElement objectAt(Vector2d position);

    List<Animal> getAnimals();
    Collection<WorldElement> getElements();

    Boundary getCurrentBounds();

    /**
     * Returns the unique identifier of the map.
     *
     * @return The unique identifier of the map.
     */
    UUID getId();
}

