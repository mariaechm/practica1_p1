package com.unl.practica.base.controller.data_struct.list;

public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = null;
    }

    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    public Node (Node<E> next) {
        this.data = null;
        this.next = next;
    }

     //getter and setter 

    public E getData() {
        return this.data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

}
