package agh.ics.oop;


import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "("+x+","+y+")";
    }
    public boolean precedes(Vector2d other){
        if(x<= other.x && y<= other.y){
            return true;
        }
        return false;
    }
    public boolean follows(Vector2d other){
        if(x>= other.x && y>= other.y){
            return true;
        }
        return false;
    }
    public Vector2d add(Vector2d other){
        return new Vector2d(x+other.x,y+other.y);
    }
    public Vector2d subtract(Vector2d other){
        return new Vector2d(x-other.x,y-other.y);
    }
    public Vector2d upperRight(Vector2d other){
        int x1 = Math.max(x,other.x);
        int y1 = Math.max(y,other.y);
        return new Vector2d(x1,y1);
    }
    public Vector2d lowerLeft(Vector2d other){
        int x1 = Math.min(x,other.x);
        int y1 = Math.min(y,other.y);
        return new Vector2d(x1,y1);
    }
    public Vector2d opposite(){
        return new Vector2d(-x,-y);
    }
    @Override
    public boolean equals(Object other){
        if(other instanceof Vector2d vector2dOther) {
            return (x == vector2dOther.x && y == vector2dOther.y);
        }
        return false;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
}
