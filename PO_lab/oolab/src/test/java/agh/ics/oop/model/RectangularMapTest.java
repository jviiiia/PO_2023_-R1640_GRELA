package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveToValidPosition() {
        RectangularMap rectangularMap = new RectangularMap(5, 5);
        assertTrue(rectangularMap.canMoveTo(new Vector2d(2, 3)));
    }

    @Test
    void canMoveToInvalidPosition() {
        RectangularMap rectangularMap = new RectangularMap(5, 5);
        assertFalse(rectangularMap.canMoveTo(new Vector2d(6, 3)));
    }

    @Test
    void placeAnimalValidPosition() {
        RectangularMap rectangularMap = new RectangularMap(5, 5);
        assertTrue(rectangularMap.place(new Animal(new Vector2d(2, 3))));
        assertNotNull(rectangularMap.objectAt(new Vector2d(2, 3)));
    }

    @Test
    void placeAnimalInvalidPosition() {
        RectangularMap rectangularMap = new RectangularMap(5, 5);
        assertTrue(rectangularMap.place(new Animal(new Vector2d(2, 3))));
        assertFalse(rectangularMap.place(new Animal(new Vector2d(2, 3))));
    }

    @Test
    void moveAnimalValidPosition() {
        RectangularMap rectangularMap = new RectangularMap(5, 5);
        assertTrue(rectangularMap.place(new Animal(new Vector2d(2, 3))));
        rectangularMap.move(new Animal(new Vector2d(2, 3)), MoveDirection.RIGHT);
        assertNull(rectangularMap.objectAt(new Vector2d(2, 3)));
        assertNotNull(rectangularMap.objectAt(new Vector2d(3, 3)));
    }

    @Test
    void moveAnimalInvalidPosition() {
        RectangularMap rectangularMap = new RectangularMap(5, 5);
        assertTrue(rectangularMap.place(new Animal(new Vector2d(4, 4))));
        rectangularMap.move(new Animal(new Vector2d(4, 4)), MoveDirection.RIGHT);
        assertNotNull(rectangularMap.objectAt(new Vector2d(4, 4)));
        assertNull(rectangularMap.objectAt(new Vector2d(5, 4)));
    }
}
