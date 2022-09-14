package module7;

public class Coda {
    private int size;
    private Cliente first;
    private Cliente last;

    public Coda() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * - inserimento in coda di un cliente
     * - rimozione dalla coda di un cliente
     * - ottenere prossimo cliente da servire
     * - ottenere il numero di clienti attualmente in coda
     */
    public void addClientQueue(Cliente cliente){
        if(this.first == null){
            this.first = cliente;
            this.last = this.first;
        }else{
            this.last.setNext(cliente);
            this.last = cliente;
        }
        this.size++;
    }

    public boolean removeClient(Cliente cliente){
        if(cliente.getId() == this.first.getId()){
            this.first = this.first.getNext();
            this.size--;
            return true;
        }
        Cliente temp = this.first.getNext();
        Cliente previous = this.first;
        while(temp!= null){
            if(temp.getId()==cliente.getId()){
                previous.setNext(temp.getNext());
                this.size--;
                return true;
            }
            temp = temp.getNext();
            previous = previous.getNext();
        }
        return false;
    }


    public Cliente getNextClient(){
        if(this.first != null){
            System.out.println(this.first);
            Cliente clientTemp = this.first;
            this.first = this.first.getNext();
            this.size--;
            return clientTemp;
        }
        return null;
    }

    public int getSizeCoda(){
        return this.size;
    }



}
