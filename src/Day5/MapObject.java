package Day5;

public class MapObject {
    private String mapPositionCode;
    private int xPos;
    private int yPos;
    private Symbol symbol;

    public MapObject(int xPos, int yPos, Symbol symbol) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.symbol = symbol;
        mapPositionCode = xPos + "" + yPos;
    }

    public void setMapPositionCode(String mapPositionCode) {
        this.mapPositionCode = mapPositionCode;
    }

    public String getMapPositionCode() {
        return mapPositionCode;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
