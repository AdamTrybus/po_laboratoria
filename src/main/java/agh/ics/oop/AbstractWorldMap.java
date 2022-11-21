package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    protected List<Animal> animalList = new ArrayList<Animal>();
    protected List<Grass> grassList = new ArrayList<Grass>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected Vector2d lowerBound;
    protected Vector2d upperBound;
    abstract public boolean canMoveTo(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animalList.add(animal);
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
        for (Animal animal : animalList) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }

        for (Grass grass : grassList) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }

        return null;
    }

    @Override
    public String toString(){
        boundsUpdate();
        return this.mapVisualizer.draw(lowerBound, upperBound);
    }

    public void boundsUpdate(){
        for (Animal animal : animalList){
            this.lowerBound = lowerBound.lowerLeft(animal.getPosition());
            this.upperBound = upperBound.upperRight(animal.getPosition());
        }

        for (Grass grass : grassList){
            this.lowerBound = lowerBound.lowerLeft(grass.getPosition());
            this.upperBound = upperBound.upperRight(grass.getPosition());
        }

    }

}