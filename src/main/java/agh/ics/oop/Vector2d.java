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
    public boolean equals(Object obj){
        if (obj == this) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector2d other = (Vector2d) obj;
        return (x == other.x && y == other.y);
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
