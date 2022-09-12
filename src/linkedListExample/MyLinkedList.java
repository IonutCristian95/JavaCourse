package linkedListExample;

public class MyLinkedList<T> {
    private Node head;
    private Node currentNode;

    public MyLinkedList() {
        this.head = null;
        this.currentNode = null;
    }

    public MyLinkedList(Node head) {
        this.head = head;
        this.currentNode = this.head;
    }

    public void add(Node node){
        if(this.head == null){
            this.head = node;
            this.currentNode = this.head;
        }else{
            this.currentNode.setNext(node);
            this.currentNode = node;
        }
    }

    public void printMyLinkedList(){
        Node temp = this.head;
        while(temp!=null){
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public Node lookup(T value){
        Node temp = this.head;
        while(temp!=null){
            if(temp.getValue().equals(value))
                return temp;
            temp = temp.getNext();
        }
        return null;
    }

    public void insert(int position, T value){
        Node<T> temp = new Node<>(value);
        if(position == 0){
            temp.setNext(this.head);
            this.head = temp;
            return;
        }
        Node currentNode = this.head.getNext();
        Node previousNode = this.head;
        int currentPosition = 1;
        while(currentNode!=null){
            if(currentPosition == position){
                previousNode.setNext(temp);
                temp.setNext(currentNode);
                return;
            }
            currentPosition++;
            currentNode = currentNode.getNext();
            previousNode = previousNode.getNext();
        }
        //happens only if position is bigger than the size of myLinkedList
        add(temp);
    }

    public void delete(T value){
        Node currNode = this.head.getNext();
        Node previousNode = this.head;
        if(this.head.getValue().equals(value)){
            this.head = this.head.getNext();
            return;
        }

        while(currNode!=null){
            if(currNode.getValue().equals(value)){
                if(currNode.getNext()==null){
                    this.currentNode = previousNode;
                }
                previousNode.setNext(currNode.getNext());
            }
            previousNode = previousNode.getNext();
            currNode = currNode.getNext();
        }
    }
}
