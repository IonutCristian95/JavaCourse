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

    public ObjectPosition getUpPosition() {
        return upPosition;
    }

    public void setUpPosition(ObjectPosition upPosition) {
        this.upPosition = upPosition;
    }

    public ObjectPosition getDownPosition() {
        return downPosition;
    }

    public void setDownPosition(ObjectPosition downPosition) {
        this.downPosition = downPosition;
    }

    public ObjectPosition getLeftPosition() {
        return leftPosition;
    }

    public void setLeftPosition(ObjectPosition leftPosition) {
        this.leftPosition = leftPosition;
    }

    public ObjectPosition getRightPosition() {
        return rightPosition;
    }

    public void setRightPosition(ObjectPosition rightPosition) {
        this.rightPosition = rightPosition;
    }
}
