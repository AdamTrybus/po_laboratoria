package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap,  IPositionChangeObserver{

    protected HashMap<Vector2d,Animal> animalList = new HashMap<>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    abstract protected Vector2d getLowerBound();
    abstract protected Vector2d getUpperBound();
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        animalList.put(newPosition, animalList.get(oldPosition));
        animalList.remove(oldPosition);
    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animalList.put(animal.getPosition(),animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }


    @Override
    public Object objectAt(Vector2d position) {
        return animalList.get(position);
    }

    @Override
    public String toString(){
        return this.mapVisualizer.draw(getLowerBound(), getUpperBound());
    }

}