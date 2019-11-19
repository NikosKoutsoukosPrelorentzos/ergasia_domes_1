package com.company;


import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringQueueImpl<T> implements StringQueue<T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void put(T data){
        Node<T> n =new Node<>(data);

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head=n;
        }
    }

    @Override
    public T get() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException();
        }
        T data = tail.getData();

        if (head == tail) {
            head = tail = null;
        } else {
            Node<T> iterator = head;
            while (iterator.getNext() != tail) {
                iterator = iterator.getNext();
            }
            iterator.setNext(null);
            tail = iterator;
        }
        return data;
    }


    @Override
    public T peek() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException();
        }
        T data = tail.getData();
        return data;

    }

    @Override
    public void printQueue(PrintStream stream) {


    }

    @Override
    public int size() {
        return 0;
    }
}
