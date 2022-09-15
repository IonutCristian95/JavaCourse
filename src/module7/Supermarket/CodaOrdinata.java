package module7.Supermarket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CodaOrdinata {
    private int size;
    private Cliente first;
    private Cliente last;

    public CodaOrdinata() {
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

    //FIFO
    public void addClientQueue(Cliente cliente){
        if(first == null){
            first = cliente;
            last = first;
        }else{
            last.setNext(cliente);
            last = cliente;
        }
        size++;
    }


    //Ordered by age when adding a client
//    public void addClientQueue(Cliente cliente){
//        if(first == null){
//            first = cliente;
//            last = first;
//            size++;
//            return;
//        }
//        Cliente current = first.getNext();
//        Cliente previous = first;
//
//        if(first.getEta() < cliente.getEta()){
//            cliente.setNext(first);
//            first = cliente;
//        }else{
//            while(current!=null){
//                if (current.getEta()<cliente.getEta()){
//                    previous.setNext(cliente);
//                    cliente.setNext(current);
//                    size++;
//                    return;
//                }
//                current = current.getNext();
//                previous = previous.getNext();
//            }
//            if (current == null){
//                last.setNext(cliente);
//                last = cliente;
//            }
//        }
//        size++;
//    }

    public boolean removeClient(Cliente cliente){

        if(cliente.getId() == first.getId()){
            first = first.getNext();
            size--;
            return true;
        }
        Cliente temp = first.getNext();
        Cliente previous = first;
        while(temp!= null){
            if(temp.getId()==cliente.getId()){
                previous.setNext(temp.getNext());
                size--;
                return true;
            }
            temp = temp.getNext();
            previous = previous.getNext();
        }
        return false;
    }


    public Cliente getNextClient(){
        if(first != null){
            System.out.println(first);
            Cliente clientTemp = first;
            first = first.getNext();
            size--;
            return clientTemp;
        }
        return null;
    }

    public int size(){
        return size;
    }

    public void orderCoda(){
        if(first==null){
            return;
        }
        System.out.println("Coda Ordinata");
        //Store elements inside the arraylist
        Cliente temp = first;
        List<Cliente> li = new ArrayList<>();
        while (temp!=null){
            li.add(temp);
            temp = temp.getNext();
        }

        //Order the list
        li.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente o1, Cliente o2) {
                return Integer.compare(o2.getEta(), o1.getEta());
            }
        });
        
        first = li.get(0);
        last = first;

        for (int i = 1; i < li.size(); i++) {
            last.setNext(li.get(i));
            last = last.getNext();
        }

        printCoda();

    }

    public void printCoda(){
        System.out.println("Print Coda");
        Cliente current = first;
        while (current!=null){
            System.out.println(current);
            current = current.getNext();
        }
        System.out.println();
    }
}
