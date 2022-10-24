package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionsParserTest {

    @Test
    void parseTest() {
        String[] arguments = {"f", "  ", "ri", "r", "f"};
        MoveDirection[] moveDirections = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD,};
        assertEquals(Arrays.asList(moveDirections), parse(arguments));
    }
}
