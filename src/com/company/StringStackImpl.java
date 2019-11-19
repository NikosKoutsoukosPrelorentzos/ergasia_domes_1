package com.company;

import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl<T> implements StringStack<T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    @Override
    public boolean isEmpty() {
            return head == null;
        }

    @Override
    public void push(T item) {

        Node<T> n =new Node<>(item);

        if (isEmpty()){
            head = n;
            tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
    }

    @Override
    public T pop() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = head.getData();

        if (head == tail) {
            head = tail = null;
        } else{
            head = head.getNext();
        }
        return data;
    }



    @Override
    public T peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = head.getData();
        return data;
    }

    @Override
    public void printStack(PrintStream stream) {

    }

    @Override
    public int size() {
        return 0;
    }
}