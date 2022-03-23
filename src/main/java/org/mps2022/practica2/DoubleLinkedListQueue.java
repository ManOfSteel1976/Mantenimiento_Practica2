package org.mps2022.practica2;

import java.util.Comparator;

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
        if (position<0){
            throw new IllegalArgumentException("Error: Negative position");
        }
        if (position>=this.size()){
            throw new IllegalArgumentException("Error: Position greater than list size");
        }
        DequeNode<T> res;
        DequeNode<T> aux = this.peekFirst();
        int index = 0;
        while (index<position){
            aux = aux.getNext();
            index++;
        }
        res = aux;
        return res;
    }

    @Override
    public DequeNode<T> find (T item) {return null;} ;

    @Override
    public void delete(DequeNode<T> node) {};

    @Override
    public void sort(Comparator<DequeNode<T>> comparator){} ;
}
