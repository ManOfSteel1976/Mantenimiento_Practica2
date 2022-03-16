package org.mps2022.practica2;

public class DoubleLinkedListQueue<T> implements DoubleEndedQueue<T>{

    DequeNode<T> nodeFirst, nodeLast;

    @Override
    public void append(DequeNode<T> node) {
        if(node==null){
            throw new RuntimeException("Empty Node");
        }else{
            // If Queue is empty
            if (nodeFirst == null) {
                nodeFirst = node;
                nodeLast = node;
                // Inserts node at the rear end
            } else {
                DequeNode last = peekLast();
                nodeLast = new DequeNode(node.getItem(), null, last);
                last = new DequeNode(last.getItem(), nodeLast, last.getPrevious());
            }
        }
    }

    @Override
    public void appendLeft(DequeNode node) {
        if(node==null){
            throw new RuntimeException("Empty Node");
        }else{
            // If Queue is empty
            if (nodeFirst == null) {
                nodeFirst = node;
                nodeLast = node;
                // Inserts node at the front end
            } else {
                DequeNode first = peekFirst();
                nodeFirst = new DequeNode(node.getItem(), first, null);
                first = new DequeNode(first.getItem(), first.getNext(), nodeFirst);
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
                DequeNode temp = new DequeNode(nodeFirst.getNext().getItem(), nodeFirst.getNext().getNext(), null);
                DequeNode aux = nodeFirst;
                nodeFirst = nodeFirst.getNext();
            // If only one element was present
                if(nodeFirst == null){
                    nodeLast = null;
                }else {
                    nodeFirst = temp;
                }
        }
    }

    @Override
    public void deleteLast() {
        if(nodeLast==null){
            throw new RuntimeException("Empty List");
        }else{
            // Deletes the node from the rear end and makes
            // the adjustment in the links
                DequeNode temp = new DequeNode(nodeLast.getPrevious().getItem(), null, nodeLast.getPrevious().getPrevious());
                DequeNode aux = nodeLast;
                nodeLast = nodeLast.getPrevious();
            // If only one element was present
                if(nodeLast == null){
                    nodeFirst = null;
                }else {
                    nodeLast = temp;
                }
        }
    }

    @Override
    public DequeNode peekFirst() {
        return nodeFirst;
    }

    @Override
    public DequeNode peekLast() {
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
