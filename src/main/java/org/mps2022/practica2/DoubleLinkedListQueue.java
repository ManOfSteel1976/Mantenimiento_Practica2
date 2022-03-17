package org.mps2022.practica2;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{

    DequeNode<T> nodeFirst, nodeLast = null;
    int size = 0;

    @Override
    public void append(DequeNode<T> node) {
        if(node==null){
            throw new RuntimeException("Empty Node");
        }else{
            // If Queue is empty
            if (nodeLast == null) {
                nodeFirst = node;
                //nodeLast = node;
                // Inserts node at the rear end
            } else {
                node.setPrevious(nodeLast);
            }
            nodeLast = node;
            size++;
        }
    }

    @Override
    public void appendLeft(DequeNode<T> node) {
        if(node==null){
            throw new RuntimeException("Empty Node");
        }else{
            // If Queue is empty
            if (nodeFirst == null) {
                nodeLast = node;
                // Inserts node at the front end
            } else {
                node.setNext(nodeLast);
            }
            nodeFirst = node;
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
            if (nodeFirst.getNext() != null) {
                // If more than one element was present
                nodeFirst = nodeFirst.getNext();
                nodeFirst.setPrevious(null);
                // If only one element was present
                if (nodeFirst == null) {
                    nodeLast = null;
                }
            }
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
            if (nodeLast.getPrevious() != null) {
                // If more than one element was present
                nodeLast = nodeLast.getPrevious();
                nodeLast.setNext(null);
                // If only one element was present
                if (nodeLast == null) {
                    nodeFirst = null;
                }
            }
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
}
