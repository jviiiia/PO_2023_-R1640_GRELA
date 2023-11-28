package agh.ics.oop.model;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveToValidPosition() {
        GrassField grassField = new GrassField(10);
        assertTrue(grassField.canMoveTo(new Vector2d(2, 3)));
    }

    @Test
    void canMoveToInvalidPosition() {
        GrassField grassField = new GrassField(10);
        assertFalse(grassField.canMoveTo(new Vector2d(11, 3)));
    }

    @Test
    void placeAnimalValidPosition() {
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(2, 3));
        assertTrue(grassField.place(animal));
        assertEquals(animal, grassField.objectAt(new Vector2d(2, 3)));
    }

    @Test
    void placeAnimalInvalidPosition() {
        GrassField grassField = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2, 3));
        Animal animal2 = new Animal(new Vector2d(2, 3));
        grassField.place(animal1);
        assertFalse(grassField.place(animal2));
    }

    @Test
    void moveAnimalValidPosition() {
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(2, 3));
        grassField.place(animal);
        grassField.move(animal, MoveDirection.RIGHT);
        assertEquals(new Vector2d(3, 3), animal.getPosition());
        assertEquals(animal, grassField.objectAt(new Vector2d(3, 3)));
    }

    @Test
    void moveAnimalInvalidPosition() {
        GrassField grassField = new GrassField(10);
        Animal animal = new Animal(new Vector2d(9, 9));
        grassField.place(animal);
        grassField.move(animal, MoveDirection.RIGHT);
        assertEquals(new Vector2d(9, 9), animal.getPosition());
        assertNull(grassField.objectAt(new Vector2d(10, 9)));
    }
}
