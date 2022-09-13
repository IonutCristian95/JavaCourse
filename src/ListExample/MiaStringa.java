package ListExample;

public class MiaStringa implements Lista {
    private int maxSize;
    private int currentSize;
    private Character[] string;

    public MiaStringa() {
        this.currentSize = 0;
        this.maxSize = 10;
        this.string = new Character[this.maxSize];
    }

    @Override
    public Object get(int i) {
        if (i < this.currentSize){
            return string[i];
        }
        return null;
    }

    @Override
    public boolean contains(Object object) {
        for (Character element : string){
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
            Character[] temp = this.string;
            this.maxSize *= 2;
            this.string = new Character[this.maxSize];
            for (int i = 0; i < this.currentSize; i++){
                this.string[i] = temp[i];
            }
        }
        this.string[currentSize] = (Character) object;
        this.currentSize++;
    }

    @Override
    public boolean remove(int i) {
        if (i < this.currentSize){
            this.string[i] = null;
            while(true){
                if(this.string[i+1]==null || (i+1)==this.maxSize){
                    this.string[i] = null;
                    break;
                }
                this.string[i]=this.string[i+1];
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
            string[counter] = null;
        }
        this.currentSize = 0;
    }
}
