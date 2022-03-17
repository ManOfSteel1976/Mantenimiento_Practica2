package org.mps2022.practica2;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{

    DequeNode<T> nodeFirst, nodeLast;

    @Override
    public void append(DequeNode<T> node) {
        if(node==null){
            throw new RuntimeException("Empty Node");
        }else{
            // If Queue is empty
            if (nodeLast == null) {
                nodeFirst = node;
                nodeLast = node;
                // Inserts node at the rear end
            } else {
                DequeNode<T> last = new DequeNode<>(node.getItem(), null, nodeLast);
                nodeLast = last;
            }
        }
    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        if(node==null){
            throw new RuntimeException("Empty Node");
        }else{
            // If Queue is empty
            if (nodeFirst == null) {
                nodeFirst = node;
                nodeLast = node;
                // Inserts node at the front end
            } else {
                DequeNode<T> first = new DequeNode<>(node.getItem(), nodeFirst, null);
                nodeFirst = first;
            }
        }
    }

    @Override
    public void deleteFirst() {
        if(nodeFirst==null){
            throw new RuntimeException("Empty List");
        }else{
            // Deletes the node from the front end and makes
            // the adjustment in the links
            if (nodeFirst.getNext() != null) {
                // If more than one element was present
                DequeNode<T> temp = new DequeNode<>(nodeFirst.getNext().getItem(), nodeFirst.getNext().getNext(), null);
                nodeFirst = temp;
                if (nodeFirst.getNext() == null) {
                    nodeLast = temp;
                }
            }else{
                // If only one element was present
                nodeFirst = null;
                nodeLast = null;
            }
        }
    }

    @Override
    public void deleteLast() {
        if(nodeLast==null){
            throw new RuntimeException("Empty List");
        }else {
            // Deletes the node from the rear end and makes
            // the adjustment in the links
            if (nodeLast.getPrevious() != null) {
                // If more than one element was present
                DequeNode<T> temp = new DequeNode<>(nodeLast.getPrevious().getItem(), null, nodeLast.getPrevious().getPrevious());
                nodeLast = temp;
                if (nodeLast.getPrevious() == null) {
                    nodeFirst = temp;
                }
            } else {
                // If only one element was present
                nodeLast = null;
                nodeFirst = null;
            }
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
        int size = 0;
        while (nodeFirst.getNext()!=null){
            size++;
        }
        return size;
    }
}
