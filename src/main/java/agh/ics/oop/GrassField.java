package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private final int amountOfGrasses;

    public GrassField(int amountOfGrasses){
        this.amountOfGrasses = amountOfGrasses;
        this.grassList = new ArrayList<Grass>();
        this.lowerBound = new Vector2d(0, 0);
        this.upperBound = new Vector2d((int)Math.sqrt(amountOfGrasses*10), (int)Math.sqrt(amountOfGrasses*10));

        for (int i = 0; i < amountOfGrasses; i++){
            randomGenerator();
        }
        boundsUpdate();
    }

    public void randomGenerator(){
        Random generator = new Random();

        int x = generator.nextInt( (int) Math.sqrt(amountOfGrasses*10) + 1);
        int y = generator.nextInt( (int) Math.sqrt(amountOfGrasses*10) + 1);

        Vector2d grassPosition = new Vector2d(x, y);

        if (!isOccupied(grassPosition)){
            grassList.add(new Grass(grassPosition));
        }

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object obj = this.objectAt(position);
        return obj == null || obj instanceof Grass;
    }
}
