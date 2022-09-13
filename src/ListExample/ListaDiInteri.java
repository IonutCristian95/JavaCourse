package ListExample;

public class ListaDiInteri implements Lista {

    private int currentSize;
    private int[] elements;

    @Override
    public Object get(int i) {
        if (i < this.size()){
            return elements[i];
        }
        return null;
    }

    @Override
    public boolean contains(Object object) {
        for (Integer element : elements){
            if (element.equals(object)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public void add(Object object) {
    }

    @Override
    public boolean remove(int i) {
        return false;
    }

    @Override
    public void clear() {

    }
}
