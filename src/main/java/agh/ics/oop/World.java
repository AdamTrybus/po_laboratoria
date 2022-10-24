package agh.ics.oop;

import java.util.List;

import static agh.ics.oop.OptionsParser.parse;

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
        Animal animal = new Animal();
        System.out.println(animal.toString());
        List<MoveDirection> directions = parse(args);
        for(MoveDirection direction : directions){
            animal.move(direction);
        }
        System.out.println(animal);
    }
    public static Direction[] changeStringToEnumArray(String[] args){
        Direction[] EnumArray = new Direction[args.length];
        for (int i = 0; i < args.length; i++){
            switch(args[i]){
                case "f" -> EnumArray[i] = Direction.f;
                case "b" -> EnumArray[i] = Direction.b;
                case "l" -> EnumArray[i] = Direction.l;
                case "r" -> EnumArray[i] = Direction.r;
                default -> System.out.println("Nieprawidłowa litera");
            }
        }
        return EnumArray;
    }
}
