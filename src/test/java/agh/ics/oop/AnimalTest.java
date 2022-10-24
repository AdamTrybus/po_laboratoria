package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.List;

import static agh.ics.oop.OptionsParser.parse;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AnimalTest {

    @Test
    void moveTest() {
        String[] args1 = {"f", "f", "f", "ri", "le", "l", "f", "left", "f"};
        String[] args2 = {"b", "li", "f", "left", "backward", "b", "f", "ri", "b"};
        String[] args3 = {"  ", "r", "r", "r", "f", "f", "f", "f", "f", "bck", "bk", "r"};

        List<MoveDirection> directions1 = parse(args1);
        List<MoveDirection> directions2 = parse(args2);
        List<MoveDirection> directions3 = parse(args3);

        Animal animal1 = new Animal();
        Animal animal2 = new Animal();
        Animal animal3 = new Animal();

        for (MoveDirection direction : directions1) {
            animal1.move(direction);
        }
        for (MoveDirection direction : directions2) {
            animal2.move(direction);
        }
        for (MoveDirection direction : directions3) {
            animal3.move(direction);
        }

        assertAll(
                () -> assertEquals(new Vector2d(1, 3), animal1.getAnimalPosition()),
                () -> assertEquals(MapDirection.SOUTH, animal1.getAnimalOrientation()),
                () -> assertEquals(new Vector2d(4, 2), animal2.getAnimalPosition()),
                () -> assertEquals(MapDirection.WEST, animal2.getAnimalOrientation()),
                () -> assertEquals(new Vector2d(0, 2), animal3.getAnimalPosition()),
                () -> assertEquals(MapDirection.NORTH, animal3.getAnimalOrientation())
        );
    }
}
