package com.company;

public class StringQueueWithOnePointer<T>  {

    private Node<T> tail = null;

    public boolean isEmptyC(){
        return tail == null;
    }

    public void putC(T data){

        Node<T> n = new Node<>(data);

        if (isEmptyC()){
            tail = n;
            tail.setNext(tail);
        } else {
            n.setNext(tail.getNext());
            tail.setNext(n);
        }
    }

    public T getC() throws EmptyListException {
        if (isEmptyC()) {
            throw new EmptyListException();
        }
        T data = tail.getData();

        if (tail.next == tail){
            tail =null;
        } else {
            Node<T> iterator = tail;
            while (iterator.getNext() != tail){
                iterator = iterator.getNext();
            }
            iterator.setNext(tail.getNext());
            tail = iterator;
        }
        return data;
    }

    public T peekC() throws EmptyListException {
        if (isEmptyC()) {
            throw new EmptyListException();
        }
        T data = tail.getData();
        return data;
    }


}
