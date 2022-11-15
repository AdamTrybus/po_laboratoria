package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parseTest() {
        OptionsParser parser = new OptionsParser();
        String[] arguments = {"f", "  ", "ri", "r", "f"};
        MoveDirection[] moveDirections = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD,};
        assertArrayEquals(moveDirections, parser.parse(arguments));
    }
}
