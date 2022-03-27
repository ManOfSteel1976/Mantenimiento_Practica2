package org.mps2022.practica2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DequeNodeTest {

    private DequeNode<Integer> dequeInt, dequeFirst, dequeLast;

    @BeforeEach
    public void setup(){
        dequeInt = new DequeNode<>(5,null,null);
        dequeFirst = new DequeNode<>(1, dequeLast, null);
        dequeLast = new DequeNode<>(2, null, dequeFirst);
    }

    @AfterEach
    public void finish(){
        dequeInt = null;
    }

    @Test
    void testDequeNodeConstructorShouldReturnSameValueItem(){
        int expectedValue = 5;
        int obtainedValue = dequeInt.getItem();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void testDequeNodeConstructorShouldReturnSameValueNext(){
        DequeNode<Integer> obtainedValue = dequeInt.getNext();

        assertNull(obtainedValue);
    }

    @Test
    void testDequeNodeConstructorShouldReturnSameValuePrevious(){
        DequeNode<Integer> obtainedValue = dequeInt.getPrevious();

        assertNull(obtainedValue);
    }

    @Test
    void IfisNotATerminalNodeTheNextsNodeIsNotNull(){
        DequeNode<Integer> previousV = new DequeNode<>(5,null,null);
        dequeInt = new DequeNode<>(5,null,previousV);
        boolean obtainedValue =dequeInt.isNotATerminalNode();

        assertFalse(obtainedValue);
    }

    @Test
    void IfisNotATerminalNodeThePreviousNodeIsNotNull(){
        DequeNode<Integer> nextV = new DequeNode<>(5,null,null);
        dequeInt = new DequeNode<>(5,nextV,null);
        boolean obtainedValue =dequeInt.isNotATerminalNode();

        assertFalse(obtainedValue);
    }
    @Test
    void IfisNotATerminalNodeThePreviousNodeAndTheNextAreNotNull(){
        DequeNode<Integer> nextV = new DequeNode<>(5,null,null);
        DequeNode<Integer> previousV = new DequeNode<>(5,null,null);
        dequeInt = new DequeNode<>(5,nextV,previousV);
        boolean obtainedValue = dequeInt.isNotATerminalNode();

        assertTrue(obtainedValue);
    }

    @Test
    void testGetItemShouldReturnItemValue(){
        int expectedValue = 5;
        dequeInt = new DequeNode<>(expectedValue, null, null);
        int obtainedValue = dequeInt.getItem();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void testGetNextShouldReturnNextNode(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5, null, null);
        dequeInt = new DequeNode<>(4, expectedValue,null);
        DequeNode<Integer> obtainedValue= dequeInt.getNext();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void testGetNextReturnsNullIfNextNodeIsNull(){
        dequeInt = new DequeNode<>(5,null,null);
        DequeNode<Integer> obtainedValue = dequeInt.getNext();

        assertNull(obtainedValue);
    }

    @Test
    void testGetPreviousShouldReturnPreviousNode(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5, null, null);
        dequeInt = new DequeNode<>(4, null, expectedValue);
        DequeNode<Integer> obtainedValue= dequeInt.getPrevious();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void testGetPreviousReturnsNullIfPreviousNodeIsNull(){
        dequeInt = new DequeNode<>(5,null,null);
        DequeNode<Integer> obtainedValue = dequeInt.getPrevious();

        assertNull(obtainedValue);
    }

    @Test
    void testSetItemShouldChangeItemValue(){
        int expectedValue = 3;
        dequeInt = new DequeNode<>(5,null,null);
        dequeInt.setItem(expectedValue);
        int obtainedValue = dequeInt.getItem();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    void testSetNextShouldChangeNextNode(){
        DequeNode<Integer> expectedValue=  new DequeNode<>(5,null,null);
        dequeInt = new DequeNode<>(1,null,null);
        dequeInt.setNext(expectedValue);

        DequeNode<Integer> obtainedValue = dequeInt.getNext();

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    void testSetPreviousShouldChangePreviousNode(){
        DequeNode<Integer> expectedValue=  new DequeNode<>(5,null,null);
        dequeInt = new DequeNode<>(1,null,null);
        dequeInt.setPrevious(expectedValue);

        DequeNode<Integer> obtainedValue = dequeInt.getPrevious();

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    void testPreviousNodeToFirstShouldReturnNull() {
        DequeNode<Integer> obtainedValue = dequeFirst.getPrevious();

        assertNull(obtainedValue);
    }

    @Test
    void testNextNodeToLastShouldReturnNull() {
        DequeNode<Integer> obtainedValue = dequeLast.getNext();

        assertNull(obtainedValue);
    }
}
