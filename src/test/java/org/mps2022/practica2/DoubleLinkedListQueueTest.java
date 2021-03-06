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
    void testAppendShouldInsertNodeAtEnd() {
        DequeNode<Integer> node = new DequeNode<>(5, null, null);
        DequeNode<Integer> expectedValue = new DequeNode<>(10, null, null);

        list.append(node);
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();

        assertEquals(obtainedValue, expectedValue);
    }

    @Test
    void testAppendNullNodeRaiseAnException(){
        DequeNode<Integer> node = null;
        assertThrows(RuntimeException.class, () -> list.append(node));
    }

    @Test
    void testAppendLeftShouldInsertNodeAtStart() {
        DequeNode<Integer> node = new DequeNode<>(5, null, null);
        DequeNode<Integer> expectedValue = new DequeNode<>(10, null, null);

        list.append(node);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekFirst();

        assertEquals(obtainedValue, expectedValue);
    }

    @Test
    void testAppendLeftNullNodeRaiseAnException(){
        DequeNode<Integer> node = null;
        assertThrows(RuntimeException.class, () -> list.appendLeft(node));
    }

    @Test
    void testSizeOfQueueWithFourAppendsAndTwoDeletesShouldReturnTwo() {
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
    void testDeletingFirstOfAnEmptyListShouldRaiseAnException() {
        assertThrows(RuntimeException.class, () -> list.deleteFirst());
    }

    @Test
    void testDeletingLastOfAnEmptyListShouldRaiseAnException() {
        assertThrows(RuntimeException.class, () -> list.deleteLast());
    }

    @Test
    void testByDeletingFirstTheValuesOfSecondNodeAndNewFirstNodeShouldBeEqual() {
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
    void testByDeletingLastTheValuesOfSecondToLastNodeAndNewLastNodeShouldBeEqual() {
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
    void testIfAppendEmptyListValueIsPeekFirst(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekFirst();

        assertEquals(obtainedValue,expectedValue);
    }
    @Test
    void testIfAppendEmptyListValueIsPeekLast(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.append(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();

        assertEquals(obtainedValue,expectedValue);
    }

    @Test
    void testIfAppendLeftEmptyListValueIsPeekFirst(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekFirst();

        assertEquals(obtainedValue,expectedValue);
    }
    @Test
    void testIfAppendLeftEmptyListValueIsPeekLast(){
        DequeNode<Integer> expectedValue = new DequeNode<>(5,null,null);
        list.appendLeft(expectedValue);
        DequeNode<Integer> obtainedValue = list.peekLast();

        assertEquals(obtainedValue,expectedValue);
    }

    @Test
    void testDeletingFirstOfOneItemListShouldReturnEmptyList(){
        int expectedValue = 0;
        list.appendLeft(new DequeNode<>(5,null,null));
        list.deleteFirst();
        int obtainedValue = list.size();

        assertEquals(obtainedValue,expectedValue);
    }

    @Test
    void testDeletingLastOfOneItemListShouldReturnEmptyList(){
        int expectedValue = 0;
        list.appendLeft(new DequeNode<>(5,null,null));
        list.deleteLast();
        int obtainedValue = list.size();

        assertEquals(obtainedValue,expectedValue);
    }

    @Test
    void testGettingAtItemBeforeFirstShouldRaiseAnException(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);

        assertThrows(IllegalArgumentException.class, () -> list.getAt(-1));
    }

    @Test
    void testGettingAtItemAfterLastShouldRaiseAnException(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);

        assertThrows(IllegalArgumentException.class, () -> list.getAt(3));
    }

    @Test
    void testGettingAtItemOfAnEmptyListShouldRaiseAnException(){
        assertThrows(RuntimeException.class, () -> list.getAt(1));
    }

    @Test
    void testGettingAtItemWithIndexZeroShouldReturnFirstElementOfTheList(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);

        assertEquals(list.peekFirst(),list.getAt(0));
    }

    @Test
    void testGettingAtItemWithIndexLostSizeMinusOneShouldReturnLastElementOfTheList(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);

        assertEquals(list.peekLast(),list.getAt(list.size()-1));
    }

    @Test
    void testGettingAtItemWithIndexBetweenZeroAndListSizeMinusOneShouldReturnTheElementWithSameIndexOfTheList(){
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
    void testFindingANullItemAtANonEmptyListShouldRaiseAnException(){
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);

        assertThrows(IllegalArgumentException.class, () -> list.find(null));
    }

    @Test
    void testFindingAnItemAtAnEmptyListShouldReturnNull(){
        assertNull(list.find(5));
    }

    @Test
    void testFindingAnItemThatDoesNotExistInAListShouldReturnNull(){
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
    void testFindingAnItemThatExistsInAListShouldReturnAnElementWithSameItemOfTheList(){
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
    void testSortingAListWithNullComparatorShouldRaiseAnException() {
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
    void testSortingAnEmptyListShouldRaiseAnException() {
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

    @Test
    void testDeletingANullElementFromAListShouldRaiseAnException() {
        list.append(new DequeNode<>(3, null, null));
        assertThrows(RuntimeException.class, () -> list.delete(null));
    }

    @Test
    void testDeletingAnElementFromAnEmptyListShouldRaiseAnException() {
        DequeNode<Integer> node = new DequeNode<>(12, null, null);
        assertThrows(RuntimeException.class, () -> list.delete(node));
    }

    @Test
    void testDeletingAnElementThatDoesNotExistInAListShouldRaiseAnException() {
        list.append(new DequeNode<>(1, null, null));
        list.append(new DequeNode<>(2, null, null));
        list.append(new DequeNode<>(3, null, null));
        list.append(new DequeNode<>(4, null, null));
        DequeNode<Integer> node = new DequeNode<>(5, null, null);

        assertThrows(RuntimeException.class, () -> list.delete(node));
    }

    @Test
    void testDeletingAnElementThatIsTheFirstOfAListShouldDeleteTheFirstElement() {
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        DequeNode<Integer> node4 = new DequeNode<>(4, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);
        list.append(node4);

        list.delete(node1);

        assertEquals(node2, list.peekFirst());
        assertEquals(node3, list.peekFirst().getNext());
        assertEquals(node4, list.peekFirst().getNext().getNext());
        assertEquals(node4, list.peekLast());
        assertEquals(node3, list.peekLast().getPrevious());
        assertEquals(node2, list.peekLast().getPrevious().getPrevious());
    }

    @Test
    void testDeletingAnElementThatIsTheLastOfAListShouldDeleteTheLastElement() {
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        DequeNode<Integer> node4 = new DequeNode<>(4, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);
        list.append(node4);

        list.delete(node4);

        assertEquals(node1, list.peekFirst());
        assertEquals(node2, list.peekFirst().getNext());
        assertEquals(node3, list.peekFirst().getNext().getNext());
        assertEquals(node3, list.peekLast());
        assertEquals(node2, list.peekLast().getPrevious());
        assertEquals(node1, list.peekLast().getPrevious().getPrevious());
    }

    @Test
    void testDeletingAnElementThatIsNonTerminalOfAListShouldDeleteThatElement() {
        DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
        DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
        DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
        DequeNode<Integer> node4 = new DequeNode<>(4, null, null);
        list.append(node1);
        list.append(node2);
        list.append(node3);
        list.append(node4);

        list.delete(node2);

        assertEquals(node1, list.peekFirst());
        assertEquals(node3, list.peekFirst().getNext());
        assertEquals(node4, list.peekFirst().getNext().getNext());
        assertEquals(node4, list.peekLast());
        assertEquals(node3, list.peekLast().getPrevious());
        assertEquals(node1, list.peekLast().getPrevious().getPrevious());
    }

    @Test
    void testDeletingLastItemOfListShouldResultEmptyList() {
        DequeNode<Integer> node = new DequeNode<>(1, null, null);

        list.append(node);

        list.delete(node);

        assertNull(list.peekFirst());
        assertNull(list.peekLast());
        assertEquals(0, list.size());
    }

}
