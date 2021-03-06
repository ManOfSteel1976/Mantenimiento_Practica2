package org.mps2022.practica2;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{

    DequeNode<T> nodeFirst = null;
    DequeNode<T> nodeLast = null;
    int size = 0;

    @Override
    public void appendLeft(DequeNode<T> node) {
        if(node==null){
            throw new IllegalStateException("Empty Node");
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
            throw new IllegalStateException("Empty Node");
        }else{
            // If deque is empty
            if (nodeLast == null) {
                nodeFirst = node;
                // Inserts node at the rear end
            }else{
                node.setPrevious(nodeLast);
                nodeLast.setNext(node);
            }
            nodeLast = node;
            size++;
        }
    }

    @Override
    public void deleteFirst() {
        if(nodeFirst==null){
            throw new IllegalStateException("Empty List");
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
            throw new IllegalStateException("Empty List");
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

    //D??a 2: Operaciones complejas

    @Override
    public DequeNode<T> getAt(int position) {
        if (size == 0){
            throw new IllegalStateException("Error: Empty List");
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
        if (node == null) {
            throw new IllegalArgumentException("Error: Input node is null");
            // If input node is null
        }
        if (this.size == 0) {
            // If list is empty
            throw new IllegalStateException("Error: Empty list");
        }
        if (node==this.peekFirst()){
            // node is the first node of the list
            this.deleteFirst();
        }else if (node==this.peekLast()){
            // node is the last node of the list
            this.deleteLast();
        }else {
            // node isn't in the list or it's between the first node and the last node of the list
            DequeNode<T> current = this.peekFirst();
            DequeNode<T> previous = null;
            while (current != null && node != current) {
                previous = current;
                current = current.getNext();
            }
            if (current == null) {
                // node isn't in the list
                throw new NoSuchElementException("Error: Node not found");
            } else {
                // Deletes the node and makes
                // the adjustment in the links
                if (previous!=null) {
                    previous.setNext(current.getNext());
                }
                current.getNext().setPrevious(previous);
                current.setNext(null);
                current.setPrevious(null);
                size--;
            }
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
                       insertNodeInOrder(res, current, comparator);
                   }
               }else{
                   res.append(current);
               }
           }
           nodeFirst = res.peekFirst();
           nodeLast = res.peekLast();
           size = res.size();
        }else{
            throw new IllegalStateException("Yo can't sort an empty list");
        }
    }
    
    private void insertNodeInOrder(DoubleLinkedListQueue<T> list, DequeNode<T> node, Comparator<DequeNode<T>> comparator){
        DequeNode<T> aux = list.peekFirst();
        DequeNode<T> previous = null;
        while (aux!=null && (comparator.compare(aux, node) <= 0)){
            previous = aux;
            aux = aux.getNext();
        }
        node.setNext(aux);
        node.setPrevious(previous);
        if(previous!=null){
            previous.setNext(node);
        }
        if(aux!=null) {
            aux.setPrevious(node);
        }
    }
}
