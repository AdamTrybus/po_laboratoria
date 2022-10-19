package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void nextTest(){
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;

        assertEquals(north.next(), east);
        assertEquals(south.next(), west);
        assertEquals(east.next(), south);
        assertEquals(west.next(), north);
    }
    @Test
    public void previousTest(){
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;

        assertEquals(north.previous(), west);
        assertEquals(south.previous(), east);
        assertEquals(east.previous(), north);
        assertEquals(west.previous(), south);
    }
}
