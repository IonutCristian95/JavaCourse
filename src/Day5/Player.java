package Day5;

public class Player extends MapObject {
    public Player(int xPos, int yPos, Symbol symbol) {
        super(xPos, yPos, symbol);
    }

    public Player(MapObject mapObject){
        super(mapObject.getxPos(), mapObject.getyPos(), Symbol.PLAYER);
    }
}
