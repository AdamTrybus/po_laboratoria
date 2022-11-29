package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private final Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int amountOfGrasses){
        int actualGrass = 0;

        while (actualGrass != amountOfGrasses){
            Random generator = new Random();

            int x = generator.nextInt( (int) Math.sqrt(amountOfGrasses*10) + 1);
            int y = generator.nextInt( (int) Math.sqrt(amountOfGrasses*10) + 1);

            Vector2d grassPosition = new Vector2d(x, y);
            Grass newGrass = new Grass(grassPosition);

            if (!isOccupied(grassPosition)){
                grasses.put(grassPosition, newGrass);
                actualGrass += 1;
            }

        }
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animalList.get(position) != null){
            return animalList.get(position);
        }
        return grasses.get(position);

    }

    @Override
    protected Vector2d getLowerBound() {
        Vector2d lowerBound = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (Vector2d position : animalList.keySet()){
            lowerBound = lowerBound.lowerLeft(position);
        }

        for (Vector2d position : grasses.keySet()){
            lowerBound = lowerBound.lowerLeft(position);
        }

        return lowerBound;
    }

    @Override
    protected Vector2d getUpperBound() {
        Vector2d upperBound = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (Vector2d position : animalList.keySet()){
            upperBound = upperBound.upperRight(position);
        }

        for (Vector2d position : grasses.keySet()){
            upperBound = upperBound.upperRight(position);
        }

        return upperBound;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object obj = this.objectAt(position);
        return obj == null || obj instanceof Grass;
    }
}
