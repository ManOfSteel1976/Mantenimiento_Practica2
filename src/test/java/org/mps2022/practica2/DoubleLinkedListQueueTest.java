package org.mps2022.practica2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleEndedQueueTest {

    public DoubleEndedQueue<Integer> list;
    @BeforeEach
    public void setup() {
        list = new DoubleLinkedListQueue<>();
    }

    @AfterEach
    public void finish() {
        list = null;
    }

    @Test
    public void testAppendShouldInsertNodeAtEnd() {
        DequeNode<Integer> node = new DequeNode<>(5, null, null);
        DequeNode<Integer> expectedValue = new DequeNode<>(10, null, null);

        list.append(node);
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();

        assertEquals(obtainedValue, expectedValue);
    }

    @Test
    public void testAppendNullNodeRaiseAnException(){
        DequeNode<Integer> node = null;
        assertThrows(RuntimeException.class, () -> list.append(node));
    }

    @Test
    public void testAppendLeftShouldInsertNodeAtStart() {
        DequeNode<Integer> node = new DequeNode<>(5, null, null);
        DequeNode<Integer> expectedValue = new DequeNode<>(10, null, null);

        list.append(node);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekFirst();

        assertEquals(obtainedValue, expectedValue);
    }

    @Test
    public void testAppendLeftNullNodeRaiseAnException(){
        DequeNode<Integer> node = null;
        assertThrows(RuntimeException.class, () -> list.appendLeft(node));
    }

    @Test
    public void testSizeOfQueueWithFourAppendsAndTwoDeletesShouldReturnTwo() {
        list.appendLeft(new DequeNode<>(5, null, null));
        list.append(new DequeNode<>(10, null, null));
        list.appendLeft(new DequeNode<>(15, null, null));
        list.append(new DequeNode<>(20, null, null));

        list.deleteFirst();
        list.deleteLast();

        int expectedValue = 2;
        int obtainedValue = list.size();
        assertEquals(obtainedValue, expectedValue);
    }

}
