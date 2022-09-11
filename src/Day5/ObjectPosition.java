package Day5;

public class ObjectPosition {
    private MapObject mapObject;
    private boolean visited;
    private ObjectPosition upPosition;
    private ObjectPosition downPosition;
    private ObjectPosition leftPosition;
    private ObjectPosition rightPosition;

    public ObjectPosition(MapObject mapObject) {
        this.mapObject = mapObject;
        this.visited = false;
    }

    public MapObject getMapObject() {
        return mapObject;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setMapObject(MapObject mapObject) {
        this.mapObject = mapObject;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
