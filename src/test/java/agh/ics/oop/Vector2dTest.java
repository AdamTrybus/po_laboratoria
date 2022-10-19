package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void equalsTest(){
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 2);
        Vector2d vector3 = new Vector2d(2, 1);

        assertTrue(vector1.equals(vector2));
        assertFalse(vector3.equals(vector2));
    }
    @Test
    public void toStringTest(){
        Vector2d vector1 = new Vector2d(1, 2);
        String a = "(1,2)";
        String b = "(2,1)";

        assertTrue(vector1.toString().equals(a));
        assertFalse(vector1.toString().equals(b));
    }
    @Test
    public void precedesTest(){
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 2);
        Vector2d vector3 = new Vector2d(2, 1);

        assertTrue(vector1.precedes(vector2));
        assertFalse(vector3.precedes(vector1));
        assertFalse(vector1.precedes(vector3));
    }
    @Test
    public void followsTest(){
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(1, 2);
        Vector2d vector3 = new Vector2d(2, 1);

        assertTrue(vector1.follows(vector2));
        assertFalse(vector3.follows(vector1));
        assertFalse(vector1.follows(vector3));
    }
    @Test
    public void upperRightTest(){
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 1);
        Vector2d vector3 = new Vector2d(1, 2);
        Vector2d vector4 = new Vector2d(2, 2);

        assertEquals(vector1.upperRight(vector2), vector4);
        assertEquals(vector1.upperRight(vector3), vector1);
    }
    @Test
    public void lowerLeftTest(){
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 1);
        Vector2d vector3 = new Vector2d(1, 2);
        Vector2d vector4 = new Vector2d(1, 1);

        assertEquals(vector1.lowerLeft(vector2), vector4);
        assertEquals(vector1.lowerLeft(vector3), vector1);
    }
    @Test
    public void addTest(){
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 1);
        Vector2d vector3 = new Vector2d(-1, -2);
        Vector2d vector4 = new Vector2d(4, 5);
        Vector2d vector5 = new Vector2d(3, 3);

        assertEquals(vector1.add(vector2), vector5);
        assertEquals(vector3.add(vector4), vector5);
    }
    @Test
    public void substractTest(){
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(2, 1);
        Vector2d vector3 = new Vector2d(-1, -2);
        Vector2d vector4 = new Vector2d(0, -3);
        Vector2d vector5 = new Vector2d(-1, 1);

        assertEquals(vector1.subtract(vector2), vector5);
        assertEquals(vector3.subtract(vector4), vector5);
    }
    @Test
    public void oppositeTest(){
        Vector2d vector1 = new Vector2d(1, 2);
        Vector2d vector2 = new Vector2d(-1, -2);

        assertEquals(vector1.opposite(), vector2);
    }
}
