package Day5;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Map {
    private int[][] map;
    private int rows;
    private int columns;
    private Hashtable<String, MapObject> mapObjectHashtable;
    private List<MapObject> pathPlayerToExit;
    private Player player;

    public Map(int x, int y) {
        this.rows = x;
        this.columns = y;
        this.mapObjectHashtable = new Hashtable<String, MapObject>();
        this.pathPlayerToExit = new ArrayList<>();
    }

    public void generateMap(){
        if (mapObjectHashtable.size()>0) {
            mapObjectHashtable.clear();
        }
        this.map = new int[this.rows][this.columns];

        for(int x = 0; x < this.rows;x++){
            for(int y = 0; y < columns; y++){
                MapObject temp = new MapObject(x, y, Symbol.SPACE);
                mapObjectHashtable.put(temp.getMapPositionCode(), temp);
            }
        }
    }

    public void generateMapObjects(){
        Random rand = new Random();
        int availablePositions = this.rows*this.columns;
        List<MapObject> tempAvailableEmptySpaces = new ArrayList<MapObject>();

        for(int x = 0; x < this.rows; x++){
            for(int y = 0; y < this.columns; y++){
                MapObject temp = mapObjectHashtable.get(x+""+y);
                if(Math.abs(rand.nextInt()%this.columns) < this.columns/3){
                    temp.setSymbol(Symbol.WALL);
                    availablePositions--;
                }else{
                    tempAvailableEmptySpaces.add(temp);
                }
            }
        }


        int playerRandomPosition;
        int exitRandomPosition;
//        while(true){
        //Set a random position for player and the exit
            playerRandomPosition = Math.abs(rand.nextInt()%availablePositions);
            exitRandomPosition = Math.abs(rand.nextInt()%availablePositions);
            if(playerRandomPosition==exitRandomPosition){
//                continue;
            }

            player = new Player(tempAvailableEmptySpaces.get(playerRandomPosition));
            tempAvailableEmptySpaces.get(exitRandomPosition).setSymbol(Symbol.EXIT);
            tempAvailableEmptySpaces.get(playerRandomPosition).setSymbol(Symbol.PLAYER);

        //Verify if there is a path between the player and the exit
//            if(pathExists()){
//                return;
//            }
//        }
    }

    public void printMap(){
        for(int x = 0; x < this.rows; x++){
            for(int y = 0; y < this.columns; y++){
                System.out.print((mapObjectHashtable.get(x + "" + y)).getSymbol().getSymbolString());
            }
            System.out.println();
        }
    }

    public boolean foundExit(Directions direction){
        int playerX = player.getxPos();
        int playerY = player.getyPos();

        MapObject newPosition;
        if(direction.equals(Directions.W) && playerX>0){
            newPosition = mapObjectHashtable.get((playerX - 1) + "" + playerY);
            if(newPosition.getSymbol().getSymbolString().equals(Symbol.SPACE.getSymbolString())){
                switchPositions(player, newPosition);
            }
        }else if (direction.equals(Directions.S) && (playerX<this.rows-1)){
            newPosition = mapObjectHashtable.get((playerX + 1) + "" + playerY);
            if(newPosition.getSymbol().getSymbolString().equals(Symbol.SPACE.getSymbolString())){
                switchPositions(player, newPosition);
            }
        }else if (direction.equals(Directions.A) && playerY>0){
            newPosition = mapObjectHashtable.get(playerX + "" + (playerY-1));
            if(newPosition.getSymbol().getSymbolString().equals(Symbol.SPACE.getSymbolString())){
                switchPositions(player, newPosition);
            }
        }else if (direction.equals(Directions.D) && (playerY<this.columns-1)){
            newPosition = mapObjectHashtable.get(playerX + "" + (playerY+1));
            if(newPosition.getSymbol().getSymbolString().equals(Symbol.SPACE.getSymbolString())){
                switchPositions(player, newPosition);
            }
        }else{
            return false;
        }
        return newPosition.getSymbol().equals(Symbol.EXIT);
    }

    public void switchPositions(MapObject obj1, MapObject obj2){

        mapObjectHashtable.put(obj1.getMapPositionCode(), obj2);
        mapObjectHashtable.put(obj2.getMapPositionCode(), obj1);

        int tempX = obj1.getxPos();
        int tempY = obj1.getyPos();
        String tempMapCode = obj1.getMapPositionCode();

        obj1.setxPos(obj2.getxPos());
        obj1.setyPos(obj2.getyPos());
        obj1.setMapPositionCode(obj2.getMapPositionCode());

        obj2.setxPos(tempX);
        obj2.setyPos(tempY);
        obj2.setMapPositionCode(tempMapCode);
    }

    private boolean pathExists(Player playerCurrentPosition){

        return false;
    }
}
