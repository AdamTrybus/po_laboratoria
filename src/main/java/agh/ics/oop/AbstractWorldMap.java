package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap,  IPositionChangeObserver{

    protected HashMap<Vector2d,Animal> animalList = new HashMap<>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    abstract public Vector2d getLowerBound();
    abstract public Vector2d getUpperBound();
    abstract public boolean canMoveTo(Vector2d position);
    protected MapBoundary mapBoundary = new MapBoundary();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = animalList.get(oldPosition);
        animalList.remove(oldPosition);
        animalList.put(newPosition, animal);
        mapBoundary.positionChanged(oldPosition, newPosition);
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException{
        if (canMoveTo(animal.getPosition())){
            animalList.put(animal.getPosition(),animal);
            animal.addObserver(this);
            mapBoundary.addPosition(animal.getPosition());
            return true;
        }
        throw new IllegalArgumentException(animal.getPosition() + "is not legal move specification");
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