package org.mps2022.practica2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DequeNodeTest {

    private DequeNode<Integer> dequeInt;

    @BeforeEach
    public void setup(){
        dequeInt = new DequeNode<>(5,null,null);
    }

    @AfterEach
    public void finish (){
        dequeInt = null;
    }

    @Test
    public void testDequeNodeConstructorShouldReturnSameValueItem(){
        int expectedValue = 5;
        int obtainedValue = dequeInt.getItem();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testDequeNodeConstructorShouldReturnSameValueNext(){
        DequeNode<Integer> obtainedValue = dequeInt.getNext();

        assertNull(obtainedValue);
    }

    @Test
    public void testDequeNodeConstructorShouldReturnSameValuePrevious(){
        DequeNode<Integer> obtainedValue = dequeInt.getPrevious();

        assertNull(obtainedValue);
    }

    @Test
    public void IfisNotATerminalNodeTheNextsNodeIsNotNull(){
        DequeNode<Integer> previousV = new DequeNode<>(5,null,null);
        dequeInt = new DequeNode<>(5,null,previousV);
        boolean obtainedValue =dequeInt.isNotATerminalNode();

        assertFalse(obtainedValue);
    }

    @Test
    public void IfisNotATerminalNodeThePreviousNodeIsNotNull(){
        DequeNode<Integer> nextV = new DequeNode<>(5,null,null);
        dequeInt = new DequeNode<>(5,nextV,null);
        boolean obtainedValue =dequeInt.isNotATerminalNode();

        assertFalse(obtainedValue);
    }
    @Test
    public void IfisNotATerminalNodeThePreviousNodeAndTheNextAreNotNull(){
        DequeNode<Integer> nextV = new DequeNode<>(5,null,null);
        DequeNode<Integer> previousV = new DequeNode<>(5,null,null);
        dequeInt = new DequeNode<>(5,nextV,previousV);
        boolean obtainedValue = dequeInt.isNotATerminalNode();

        assertTrue(obtainedValue);
    }

    @Test
    public void testGetItemShouldReturnItemValue(){
        int expectedValue = 5;
        dequeInt = new DequeNode<>(expectedValue, null, null);
        int obtainedValue = dequeInt.getItem();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testGetNextShouldReturnNextNode(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5, null, null);
        dequeInt = new DequeNode<>(4, expectedValue,null);
        DequeNode<Integer> obtainedValue= dequeInt.getNext();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testGetNextReturnsNullIfNextNodeIsNull(){
        dequeInt = new DequeNode<>(5,null,null);
        DequeNode<Integer> obtainedValue = dequeInt.getNext();

        assertNull(obtainedValue);
    }

    @Test
    public void testGetPreviousShouldReturnPreviousNode(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5, null, null);
        dequeInt = new DequeNode<>(4, null, expectedValue);
        DequeNode<Integer> obtainedValue= dequeInt.getPrevious();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testGetPreviousReturnsNullIfPreviousNodeIsNull(){
        dequeInt = new DequeNode<>(5,null,null);
        DequeNode<Integer> obtainedValue = dequeInt.getPrevious();

        assertNull(obtainedValue);
    }

    @Test
    public void testSetItemShouldChangeItemValue(){
        int expectedValue = 3;
        dequeInt = new DequeNode<>(5,null,null);
        dequeInt.setItem(expectedValue);
        int obtainedValue = dequeInt.getItem();

        assertEquals(expectedValue, obtainedValue);
    }

    @Test
    public void testSetNextShouldChangeNextNode(){
        DequeNode<Integer> expectedValue=  new DequeNode<>(5,null,null);
        dequeInt = new DequeNode<>(1,null,null);
        dequeInt.setNext(expectedValue);

        DequeNode<Integer> obtainedValue = dequeInt.getNext();

        assertEquals(expectedValue,obtainedValue);
    }

    @Test
    public void testSetPreviousShouldChangePreviousNode(){
        DequeNode<Integer> expectedValue=  new DequeNode<>(5,null,null);
        dequeInt = new DequeNode<>(1,null,null);
        dequeInt.setPrevious(expectedValue);

        DequeNode<Integer> obtainedValue = dequeInt.getPrevious();

        assertEquals(expectedValue,obtainedValue);
    }
}
