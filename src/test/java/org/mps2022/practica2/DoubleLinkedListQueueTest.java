package org.mps2022.practica2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class DoubleEndedQueueTest {

    public DoubleEndedQueue<Integer> list;
    private final Comparator<DequeNode<Integer>> comparator = Comparator.comparingInt(DequeNode::getItem);

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
        list.append(new DequeNode<>(5, null, null));
        list.append(expectedValue);
        list.append(new DequeNode<>(15, null, null));
        list.append(new DequeNode<>(20, null, null));

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
    public void testIfAppendEmptyListValueIsPeekFirst(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekFirst();

        assertEquals(obtainedValue,expectedValue);
    }
    @Test
    public void testIfAppendEmptyListValueIsPeekLast(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();

        assertEquals(obtainedValue,expectedValue);
    }

    @Test
    public void testIfAppendLeftEmptyListValueIsPeekFirst(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekFirst();

        assertEquals(obtainedValue,expectedValue);
    }
    @Test
    public void testIfAppendLeftEmptyListValueIsPeekLast(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();

        assertEquals(obtainedValue,expectedValue);
    }

    @Test
    public void testDeletingFirstOfOneItemListShouldReturnEmptyList(){
        int expectedValue = 0;
        list.appendLeft(new DequeNode<>(5,null,null));
        list.deleteFirst();
        int obtainedValue = list.size();

        assertEquals(obtainedValue,expectedValue);
    }

    @Test
    public void testDeletingLastOfOneItemListShouldReturnEmptyList(){
        int expectedValue = 0;
        list.appendLeft(new DequeNode<>(5,null,null));
        list.deleteLast();
        int obtainedValue = list.size();

        assertEquals(obtainedValue,expectedValue);
    }

    @Test
    public void testGettingAtItemBeforeFirstShouldRaiseAnException(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);

        assertThrows(IllegalArgumentException.class, () -> list.getAt(-1));
    }

    @Test
    public void testGettingAtItemAfterLastShouldRaiseAnException(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);

        assertThrows(IllegalArgumentException.class, () -> list.getAt(3));
    }

    @Test
    public void testGettingAtItemOfAnEmptyListShouldRaiseAnException(){
        assertThrows(RuntimeException.class, () -> list.getAt(1));
    }

    @Test
    public void testGettingAtItemWithIndexZeroShouldReturnFirstElementOfTheList(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);

        assertEquals(list.peekFirst(),list.getAt(0));
    }

    @Test
    public void testGettingAtItemWithIndexLostSizeMinusOneShouldReturnLastElementOfTheList(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);

        assertEquals(list.peekLast(),list.getAt(list.size()-1));
    }

    @Test
    public void testGettingAtItemWithIndexBetweenZeroAndListSizeMinusOneShouldReturnTheElementWithSameIndexOfTheList(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        DequeNode<Integer> node4 = new DequeNode<>(4, null, null);

        list.append(node1);
        list.append(node2);
        list.append(node3);
        list.append(node4);

        assertEquals(node2,list.getAt(1));
        assertEquals(node3,list.getAt(2));
    }

    @Test
    public void testFindingANullItemAtANonEmptyListShouldRaiseAnException(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);

        assertThrows(IllegalArgumentException.class, () -> list.find(null));
    }

    @Test
    public void testFindingAnItemAtAnEmptyListShouldReturnNull(){
        assertNull(list.find(5));
    }

    @Test
    public void testFindingAnItemThatDoesNotExistInAListShouldReturnNull(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);

        DequeNode<Integer> obtainedValue = list.find(5);

        assertNull(obtainedValue);
    }

    @Test
    public void testFindingAnItemThatExistsInAListShouldReturnAnElementWithSameItemOfTheList(){
        DequeNode<Integer> node1 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(11, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(5, null, null);

        list.append(node1);
        list.append(node2);
        list.append(node3);

        DequeNode<Integer> obtainedValue = list.find(5);
        assertEquals(obtainedValue,node3);
    }

    @Test
    public void testSortingAListWithNullComparatorShouldRaiseAnException() {
        assertThrows(IllegalArgumentException.class, () -> list.sort(null));
    }

    @Test
    void testSortingAListOfOneElementShouldNotChangeThatList(){
        DequeNode<Integer> node1 = new DequeNode<>(5, null, null);
        list.append(node1);
        list.sort(comparator);
        assertEquals(node1,list.peekFirst());
        assertEquals(node1,list.peekLast());
    }

    @Test
    public void testSortingAnEmptyListShouldRaiseAnException() {
        assertThrows(RuntimeException.class, () -> list.sort(comparator));
    }

    @Test
    void sortOfADisorderedQueueShouldOrderIt(){
        DequeNode<Integer> node1 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(3, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(11, null, null);
        DequeNode<Integer> node4 = new DequeNode<>(4, null, null);
        DequeNode<Integer> node5 = new DequeNode<>(8, null, null);
        DequeNode<Integer> node6 = new DequeNode<>(1, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);
        list.append(node4);
        list.append(node5);
        list.append(node6);

        list.sort(comparator);
        assertEquals(node6,list.peekFirst());
        assertEquals(node1,list.peekFirst().getNext());
        assertEquals(node2,list.peekFirst().getNext().getNext());
        assertEquals(node4,list.peekFirst().getNext().getNext().getNext());
        assertEquals(node5,list.peekFirst().getNext().getNext().getNext().getNext());
        assertEquals(node3,list.peekFirst().getNext().getNext().getNext().getNext().getNext());
        assertEquals(node3,list.peekLast());
        assertEquals(node5,list.peekLast().getPrevious());
        assertEquals(node4,list.peekLast().getPrevious().getPrevious());
        assertEquals(node2,list.peekLast().getPrevious().getPrevious().getPrevious());
        assertEquals(node1,list.peekLast().getPrevious().getPrevious().getPrevious().getPrevious());
        assertEquals(node6,list.peekLast().getPrevious().getPrevious().getPrevious().getPrevious().getPrevious());
    }

    @Test
    void testSortOfAnOrderedQueueShouldKeepOrdered(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        DequeNode<Integer> node4 = new DequeNode<>(4, null, null);
        DequeNode<Integer> node5 = new DequeNode<>(5, null, null);
        DequeNode<Integer> node6 = new DequeNode<>(6, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);
        list.append(node4);
        list.append(node5);
        list.append(node6);

        list.sort(comparator);
        assertEquals(node1,list.peekFirst());
        assertEquals(node2,list.peekFirst().getNext());
        assertEquals(node3,list.peekFirst().getNext().getNext());
        assertEquals(node4,list.peekFirst().getNext().getNext().getNext());
        assertEquals(node5,list.peekFirst().getNext().getNext().getNext().getNext());
        assertEquals(node6,list.peekFirst().getNext().getNext().getNext().getNext().getNext());
        assertEquals(node6,list.peekLast());
        assertEquals(node5,list.peekLast().getPrevious());
        assertEquals(node4,list.peekLast().getPrevious().getPrevious());
        assertEquals(node3,list.peekLast().getPrevious().getPrevious().getPrevious());
        assertEquals(node2,list.peekLast().getPrevious().getPrevious().getPrevious().getPrevious());
        assertEquals(node1,list.peekLast().getPrevious().getPrevious().getPrevious().getPrevious().getPrevious());
    }

    @Test
    void testSortOfAReverseOrderedQueueShouldOrderIt(){
        DequeNode<Integer> node1 = new DequeNode<>(6, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(5, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(4, null, null);
        DequeNode<Integer> node4 = new DequeNode<>(3, null, null);
        DequeNode<Integer> node5 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node6 = new DequeNode<>(1, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);
        list.append(node4);
        list.append(node5);
        list.append(node6);

        list.sort(comparator);
        assertEquals(node6,list.peekFirst());
        assertEquals(node5,list.peekFirst().getNext());
        assertEquals(node4,list.peekFirst().getNext().getNext());
        assertEquals(node3,list.peekFirst().getNext().getNext().getNext());
        assertEquals(node2,list.peekFirst().getNext().getNext().getNext().getNext());
        assertEquals(node1,list.peekFirst().getNext().getNext().getNext().getNext().getNext());
        assertEquals(node1,list.peekLast());
        assertEquals(node2,list.peekLast().getPrevious());
        assertEquals(node3,list.peekLast().getPrevious().getPrevious());
        assertEquals(node4,list.peekLast().getPrevious().getPrevious().getPrevious());
        assertEquals(node5,list.peekLast().getPrevious().getPrevious().getPrevious().getPrevious());
        assertEquals(node6,list.peekLast().getPrevious().getPrevious().getPrevious().getPrevious().getPrevious());
    }

    @Test
    void testSortOfListWithRepeatedItemsKeepThemInInputOrder() {
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        DequeNode<Integer> node4 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node5 = new DequeNode<>(5, null, null);
        DequeNode<Integer> node6 = new DequeNode<>(2, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);
        list.append(node4);
        list.append(node5);
        list.append(node6);

        list.sort(comparator);
        assertEquals(node1, list.peekFirst());
        assertEquals(node2, list.peekFirst().getNext());
        assertEquals(node4, list.peekFirst().getNext().getNext());
        assertEquals(node6, list.peekFirst().getNext().getNext().getNext());
        assertEquals(node3, list.peekFirst().getNext().getNext().getNext().getNext());
        assertEquals(node5, list.peekFirst().getNext().getNext().getNext().getNext().getNext());
        assertEquals(node5, list.peekLast());
        assertEquals(node3, list.peekLast().getPrevious());
        assertEquals(node6, list.peekLast().getPrevious().getPrevious());
        assertEquals(node4, list.peekLast().getPrevious().getPrevious().getPrevious());
        assertEquals(node2, list.peekLast().getPrevious().getPrevious().getPrevious().getPrevious());
        assertEquals(node1, list.peekLast().getPrevious().getPrevious().getPrevious().getPrevious().getPrevious());
    }
}
