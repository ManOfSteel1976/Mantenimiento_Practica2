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

    @Test
    public void testDeletingFirstOfAnEmptyListShouldRaiseAnException() {
        assertThrows(RuntimeException.class, () -> list.deleteFirst());
    }

    @Test
    public void testDeletingLastOfAnEmptyListShouldRaiseAnException() {
        assertThrows(RuntimeException.class, () -> list.deleteLast());
    }

    @Test
    public void testByDeletingFirstTheValuesOfSecondNodeAndNewFirstNodeShouldBeEqual() {
        DequeNode<Integer> expectedValue = new DequeNode<>(10, null, null);
        list.append(new DequeNode<Integer>(5, null, null));
        list.append(expectedValue);
        list.append(new DequeNode<Integer>(15, null, null));
        list.append(new DequeNode<Integer>(20, null, null));

        list.deleteFirst();
        DequeNode<Integer> obtainedValue = list.peekFirst();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testByDeletingLastTheValuesOfSecondToLastNodeAndNewLastNodeShouldBeEqual() {
        DequeNode<Integer> expectedValue = new DequeNode<>(15, null, null);
        list.append(new DequeNode<>(5, null, null));
        list.append(new DequeNode<>(10, null, null));
        list.append(expectedValue);
        list.append(new DequeNode<>(20, null, null));

        list.deleteLast();
        DequeNode<Integer> obtainedValue = list.peekLast();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testIfAppendEmptyListValueIsPeekFrist(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = queue.peekFirst();

        assertEquals(obtainedValue,expectedValue);
    }
    @Test
    public void testIfAppendEmptyListValueIsPeekLast(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = queue.peekLast();

        assertEquals(obtainedValue,expectedValue);
    }

    @Test
    public void testIfAppendLeftEmptyListValueIsPeekFrist(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = queue.peekFirst();

        assertEquals(obtainedValue,expectedValue);
    }
    @Test
    public void testIfAppendLeftEmptyListValueIsPeekLast(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = queue.peekLast();

        assertEquals(obtainedValue,expectedValue);
    }
}