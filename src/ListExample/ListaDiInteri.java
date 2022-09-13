package ListExample;

public class ListaDiInteri implements Lista {

    private int currentSize;
    private int maxSize;
    private Integer[] elements;

    public ListaDiInteri() {
        this.currentSize = 0;
        this.maxSize = 2;
        this.elements = new Integer[this.maxSize];
    }

    @Override
    public Object get(int i) {
        if (i < this.currentSize){
            return elements[i];
        }
        return null;
    }

    @Override
    public boolean contains(Object object) {
        for (Integer element : elements){
            if (element!=null && element.equals(object)){
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
        if((this.currentSize+1) >= this.maxSize){
            Integer[] temp = this.elements;
            this.maxSize *= 2;
            this.elements = new Integer[this.maxSize];
            for (int i = 0; i < this.currentSize; i++){
                this.elements[i] = temp[i];
            }
        }
        this.elements[currentSize] = (Integer) object;
        this.currentSize++;
    }

    @Override
    public boolean remove(int i) {
        if (i < this.currentSize){
            this.elements[i] = null;
            while(true){
                if(this.elements[i+1]==null || (i+1)==this.maxSize){
                    this.elements[i] = null;
                    break;
                }
                this.elements[i]=this.elements[i+1];
                i++;
            }
            this.currentSize--;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int counter = 0; counter < this.currentSize; counter++){
            elements[counter] = null;
        }
        this.currentSize = 0;
    }
}
