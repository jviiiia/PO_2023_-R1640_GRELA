package agh.ics.oop.model;


import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SimulationTest {
    @Test
    public void testAnimalMovementSequence() {
        RectangularMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        map.place(animal);
        map.move(animal, MoveDirection.RIGHT);
        map.move(animal, MoveDirection.FORWARD);
        map.move(animal, MoveDirection.FORWARD);

        assertEquals(new Vector2d(4, 2), animal.getPosition());
        assertEquals(MapDirection.EAST, animal.getOrientation());
    }
    @Test
    public void testAnimalCollision() {
        WorldMap map = new RectangularMap(5,5);
        Animal animal1 = new Animal(new Vector2d(2, 2));
        Animal animal2 = new Animal(new Vector2d(2, 3));

        assertTrue(map.place(animal1));
        assertTrue(map.place(animal2));

        map.move(animal1,MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 2), animal1.getPosition());
    }

}

