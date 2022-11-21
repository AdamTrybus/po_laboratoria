package agh.ics.oop;

public class Animal implements IMapElement{

    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;


    public Animal(IWorldMap map) {
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "N";
            case WEST -> "W";
            case SOUTH -> "S";
            case EAST -> "E";
        };
    }

    public MapDirection getAnimalOrientation() {
        return orientation;
    }

    boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }


    public void move(MoveDirection direction) {
        Vector2d newPosition = position;

        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                newPosition = position.add(orientation.toUnitVector());
            }
            case BACKWARD -> {
                newPosition = position.subtract(orientation.toUnitVector());
            }
        }

        if (map.canMoveTo(newPosition)) {
            this.position = newPosition;
        }

    }
}
