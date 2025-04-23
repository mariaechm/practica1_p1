package com.unl.practica.base.controller.data_struct.list;


import org.checkerframework.checker.units.qual.t;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
import com.unl.practica.base.controller.ControllerDatos;
import com.unl.practica.base.controller.excepcion.ListEmptyException;


public class LinkendList <E> {
    private Node<E> head;
    private Node<E> last;
    private Integer length;

    // getter and setter
    public Integer getLength() {
        return length;
    }

    public void setLength(Integer lenth) {
        this.length = lenth;
    }

    public LinkendList() {
        this.head = null;
        this.last = null;
        this.length = 0;
    }

    public Boolean isEmpty() {
        return head == null || length == 0;
    }

    private Node <E> getNode (Integer pos) throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Indice fuera de rango");
        }else if (pos < 0 || pos >= length){
            throw new ListEmptyException("Indice fuera de rango");
        }else if (pos == 0){
            return head;
        }else if((length.intValue() - 1) == pos.intValue()){
            return last;
        }else{
            Node<E> search = head;
            Integer cont = 0;
            while (cont < pos) {
                search = search.getNext();
                cont++;
            }
            return search;
        }
    }

    private E getDataFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("La lista esta vacia");
        } else {
            return last.getData();
        }
    }

    public E get(Integer pos) throws ListEmptyException {
        return getNode(pos).getData();
    }

    private void addFirst(E data) {
        if (isEmpty()) {
            Node<E> aux = new Node<>(data);
            head = aux;
            last = aux;
            length++;
        } else {
            Node<E> head_old = head;
            Node<E> aux = new Node<>(data, head_old);
            head = aux;

        }
        length++;
    }

    private void addLast(E data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node<E> aux = new Node<>(data);
            last.setNext(aux);
            last = aux;
            length++;
        }
    }

    public void add(E data, Integer pos) throws ListEmptyException {
        if (pos == 0) {
            addFirst(data);
        } else if (length.intValue() == pos.intValue()) {
            addLast(data);
        } else {
            Node<E> search_preview = getNode(pos - 1);
            Node<E> search = getNode(pos);
            Node<E> aux = new Node<>(data, search);
            search_preview.setNext(aux);
            length++;
        }
    }

    public void add(E data) {
        addLast(data);
    }

    public String print() {
        if (isEmpty()) {
            return "La lista esta vacia";

        } else {
            StringBuilder resp = new StringBuilder();
            Node<E> help = head;
            while (help != null) {
                resp.append(help.getData()).append(" -> ");
                help = help.getNext();
            }
            resp.append("\n");
            return resp.toString();
        }
    }

    public void update(E data, Integer pos) throws ListEmptyException {
        getNode(pos).setData(data);
    }

    public void clear() {
        head = null;
        last = null;
        length = 0;

    }

    public static void main(String[] args) throws ListEmptyException {
    
        //LinkendList<Double> lista = new LinkendList<>();
        int[] datos = ControllerDatos.cargarDatos("/home/maria/Escritorio/Estructura/unl-practica/src/data.txt");

            //Arreglo
            long InicioArr = System.nanoTime();
            numerosIgualesArreglo(datos);
            long tFinalArr = System.nanoTime();
            long duracionArreglo = tFinalArr - InicioArr;

            //Lista
            long InicioLis = System.nanoTime();
            numerosIgualesLista(datos);
            long tFinalLista = System.nanoTime();
            long duracionLista = tFinalLista - InicioLis;

            System.out.println("Tiempo usando Arreglo: " + duracionArreglo + " nanosegundos");
            System.out.println("Tiempo usando Lista Enlazada: " + duracionLista + " nanosegundos");
            System.out.println();
        }
    }
