package agh.ics.oop;

import java.util.Arrays;

public class World {

    static void run(Direction[] args){

        for (Direction dir : args){
            switch(dir) {
                case f:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case b:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case r:
                    System.out.println("Zwierzak idzie w prawo");
                    break;
                case l:
                    System.out.println("Zwierzak idzie w lewo");
                    break;
                default:
                    // code block
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("System wystartował");
        Direction[] dirs = {Direction.f, Direction.b, Direction.l, Direction.r};
        run(dirs);
        System.out.println("System zakończył działanie");
    }
}
