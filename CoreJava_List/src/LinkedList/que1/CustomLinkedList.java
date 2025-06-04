package LinkedList.que1;

import org.w3c.dom.Node;

public class CustomLinkedList<E> {
    private Node<E>head;
    private Node<E>tail;

    private static class Node<E>{
        E data;
        Node<E>next;
        Node<E>prev;

        Node(E data){
            this.data=data;

        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + (next!=null?next.data:"null") +
                    ", prev=" + (prev!=null?prev.data:"null") +
                    '}';
        }
    }
    public void add(E data){
        Node<E>newNode=new Node<>(data);
        if(head==null) {
            head = tail = newNode;
        }
        else {
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }

    }
    public void printStructure(){
        Node<E>current=head;
        while (current!=null){
            System.out.println(current);
            current=current.next;
        }
    }





}
