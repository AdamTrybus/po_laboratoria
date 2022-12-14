package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private final Vector2d lowerBound;
    private final Vector2d upperBound;

    public RectangularMap(int width, int height){
        this.lowerBound = new Vector2d(0,0);
        this.upperBound = new Vector2d(width - 1, height - 1);
    }

    @Override
    public Vector2d getLowerBound() {
        return lowerBound;
    }

    @Override
    public Vector2d getUpperBound() {
        return upperBound;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerBound) && position.precedes(upperBound) && !isOccupied(position);
    }

}
