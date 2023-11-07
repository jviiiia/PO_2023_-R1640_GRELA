package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    void testEquals() {
        Vector2d vector1 = new Vector2d(1, 3);
        Vector2d vector2 = new Vector2d(1, 3);
        assertEquals(vector1, vector2);
    }

    @Test
    void testToString() {
        Vector2d vector = new Vector2d(3, -2);
        assertEquals("(3, -2)", vector.toString());
    }

    @Test
    void testPrecedes() {
        Vector2d vector1 = new Vector2d(1, 3);
        Vector2d vector2 = new Vector2d(4, 5);
        assertTrue(vector1.precedes(vector2));
    }

    @Test
    void testFollows() {
        Vector2d vector1 = new Vector2d(3, 5);
        Vector2d vector2 = new Vector2d(1, 3);
        assertTrue(vector1.follows(vector2));
    }
    @Test
    void testUpperRight() {
        Vector2d vector1 = new Vector2d(1, 3);
        Vector2d vector2 = new Vector2d(4, 1);
        Vector2d result = vector1.upperRight(vector2);
        assertEquals(new Vector2d(4, 3), result);
    }

    @Test
    void testLowerLeft() {
        Vector2d vector1 = new Vector2d(1, 3);
        Vector2d vector2 = new Vector2d(4, 1);
        Vector2d result = vector1.lowerLeft(vector2);
        assertEquals(new Vector2d(1, 1), result);
    }

    @Test
    void testAdd() {
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(5, 5);
        Vector2d result = vector1.add(vector2);
        assertEquals(new Vector2d(7, 8), result);
    }
    @Test
    void testSubtract() {
        Vector2d vector1 = new Vector2d(2, 3);
        Vector2d vector2 = new Vector2d(3, 2);
        Vector2d result = vector1.subtract(vector2);
        assertEquals(new Vector2d(-1, 1), result);
    }
    @Test
    void testOpposite() {
        Vector2d vector = new Vector2d(6, -3);
        Vector2d result = vector.opposite();
        assertEquals(new Vector2d(-6, 3), result);
    }

}

