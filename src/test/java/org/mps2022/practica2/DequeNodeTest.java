package org.mps2022.practica2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
}
