package Day5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map map = new Map(10, 10);
        map.generateMap();
        map.generateMapObjects();


        play(map);


    }

    public static void play(Map map){
        Scanner scanner = new Scanner(System.in);
        String direction;
        Directions tempDirectionObject = null;
        boolean endgame = false;

        while(true){
            map.printMap();
            System.out.println("Direction? (W A S D)");
            direction = scanner.next().toLowerCase();
            scanner.nextLine();
            switch (direction){
                case "a" : tempDirectionObject = Directions.A;
                    break;
                case "w" : tempDirectionObject = Directions.W;
                    break;
                case "s" : tempDirectionObject = Directions.S;
                    break;
                case "d" : tempDirectionObject = Directions.D;
                    break;
                case "e" :
                    System.out.println("Exiting");
                    return;
                default:
                    continue;
            }

            endgame = map.foundExit(tempDirectionObject);
            if (endgame){
                System.out.println("You won");
                return;
            }
        }
    }

}
