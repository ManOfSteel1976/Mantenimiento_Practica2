package org.mps2022.practica2;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{

    DequeNode<T> nodeFirst, nodeLast = null;
    int size = 0;

    @Override
    public void appendLeft(DequeNode<T> node) {
        if(node==null){
            throw new RuntimeException("Empty Node");
        }else {
            // If deque is empty
            if (nodeFirst == null){
                nodeFirst = node;
                nodeLast = node;
            // Inserts node at the front end
            }else{
                node.setNext(nodeFirst);
                nodeFirst.setPrevious(node);
                nodeFirst = node;
            }
            // Increments count of elements by 1
            size++;
        }
    }

    @Override
    public void append(DequeNode<T> node) {
        if(node==null){
            throw new RuntimeException("Empty Node");
        }else{
            // If deque is empty
            if (nodeLast == null) {
                nodeFirst = node;
                nodeLast = node;
                // Inserts node at the rear end
            }else{
                node.setPrevious(nodeLast);
                nodeLast.setNext(node);
                nodeLast = node;
            }
            size++;
        }
    }

    @Override
    public void deleteFirst() {
        if(nodeFirst==null){
            throw new RuntimeException("Empty List");
        }else{
            // Deletes the node from the front end and makes
            // the adjustment in the links
            nodeFirst = nodeFirst.getNext();
            // If only one element was present
            if (nodeFirst == null) {
                nodeLast = null;
            }else {
                nodeFirst.setPrevious(null);
            }
            // Decrements count of elements by 1
            size--;
        }
    }

    @Override
    public void deleteLast() {
        if(nodeLast==null){
            throw new RuntimeException("Empty List");
        }else {
            // Deletes the node from the front end and makes
            // the adjustment in the links
            nodeLast = nodeLast.getPrevious();
            // If only one element was present
            if (nodeLast == null) {
                nodeFirst = null;
            }else {
                nodeLast.setNext(null);
            }
            // Decrements count of elements by 1
            size--;
        }
    }

    @Override
    public DequeNode<T> peekFirst() {
        return nodeFirst;
    }

    @Override
    public DequeNode<T> peekLast() {
        return nodeLast;
    }

    @Override
    public int size() {
        return this.size;
    }

    //Día 2: Operaciones complejas

    @Override
    public DequeNode<T> getAt(int position) {
        if (size <= 0){
            throw new RuntimeException("Error: Empty List");
        }
        if (position < 0){
            throw new IllegalArgumentException("Error: Negative position");
        }
        if (position >= size){
            throw new IllegalArgumentException("Error: Position greater than list size");
        }
        DequeNode<T> res;
        DequeNode<T> aux = this.peekFirst();
        int index = 0;
        while (index < position){
            aux = aux.getNext();
            index++;
        }
        res = aux;
        return res;
    }

    @Override
    public DequeNode<T> find (T item) {
        if (item == null) {
            throw new IllegalArgumentException("Error: Input item is null");
        }
        DequeNode<T> res = nodeFirst;
        while (res != null && !item.equals(res.getItem())) {
            res = res.getNext();
        }
        return res;
    }

    @Override
    public void delete(DequeNode<T> node) {
        if (node == null) { // Si el nodo no ha sido proporcionado
            throw new IllegalArgumentException("Error: Input node is null");
        }
        if (this.size <= 0) { // Si la lista está vacía
            throw new RuntimeException("Error: Empty list");
        }
        DequeNode<T> current = this.peekFirst();
        DequeNode<T> previous = null;
        while (current != null && node != current) {
            previous = current;
            current = current.getNext();
        }
        if (current == null) { // Si no se ha encontrado el nodo
            throw new NoSuchElementException("Error: Node not found");
        } else {
            if (previous == null && current.getNext() == null) { // Si la lista es de un solo elemento
                nodeFirst = null;
                nodeLast = null;
            } else if (previous == null && current.getNext() != null) { // Si es el primer elemento de una lista de dos elementos o más
                current.getNext().setPrevious(null);
                nodeFirst = current.getNext();
                current.setNext(null);
            } else if (previous != null && current.getNext() == null) { // Si es el último elemento de una lista de dos elementos o más
                previous.setNext(null);
                nodeLast = previous;
                current.setPrevious(null);
            } else { // Si es un nodo no terminal de una lista de dos elementos o más
                previous.setNext(current.getNext());
                current.getNext().setPrevious(previous);
                current.setNext(null);
                current.setPrevious(null);
            }
            size--;
        }
    }

    @Override
    public void sort(Comparator<DequeNode<T>> comparator) {
        if (comparator==null){
            throw new IllegalArgumentException("Error: comparator is null");
        }
        if (size>0){
           DoubleLinkedListQueue<T> res = new DoubleLinkedListQueue<>();
           while (size>0){
               DequeNode<T> current = nodeFirst;
               this.deleteFirst();
               current.setNext(null);
               current.setPrevious(null);
               if (res.size()>0){
                   if (comparator.compare(current, res.peekFirst()) < 0){
                       res.appendLeft(current);
                   }else if(comparator.compare(current, res.peekLast()) >= 0){
                       res.append(current);
                   }else{
                       DequeNode<T> aux = res.peekFirst();
                       DequeNode<T> previous = null;
                       while (aux!=null && (comparator.compare(aux, current) <= 0)){
                           previous = aux;
                           aux = aux.getNext();
                       }
                       current.setNext(aux);
                       current.setPrevious(previous);
                       previous.setNext(current);
                       aux.setPrevious(current);
                   }
               }else{
                   res.append(current);
               }
           }
           nodeFirst = res.peekFirst();
           nodeLast = res.peekLast();
           size = res.size();
        }else{
            throw new RuntimeException("Yo can't sort an empty list");
        }
    }
}
