import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @org.junit.jupiter.api.Test
    void isEmptyTest() {
        // Create a linked list. For instance, 1-> 3-> 5-> 7
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addEnd(1);
        doublyLinkedList.addEnd(3);
        doublyLinkedList.addEnd(5);
        doublyLinkedList.addEnd(7);
        assertFalse(doublyLinkedList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void returnStringListTest() {
        // Create a linked list. For instance, 1-> 3-> 5-> 7
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addEnd(1);
        doublyLinkedList.addEnd(3);
        doublyLinkedList.addEnd(5);
        doublyLinkedList.addEnd(7);
        assertEquals("1-> 3-> 5-> 7", doublyLinkedList.returnStringList());
    }


    // This test is similar to the test of string representation of the linked list by adding nodes to the end of the end of the linked list.
    @org.junit.jupiter.api.Test
    void addEndTest() {
        // Create a linked list. For instance, 1-> 3-> 5-> 7
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addEnd(1);
        doublyLinkedList.addEnd(3);
        doublyLinkedList.addEnd(5);
        doublyLinkedList.addEnd(7);
        assertEquals("1-> 3-> 5-> 7", doublyLinkedList.returnStringList());
    }

    @org.junit.jupiter.api.Test
    void addFrontTest() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFront(7);
        doublyLinkedList.addFront(5);
        doublyLinkedList.addFront(3);
        doublyLinkedList.addFront(1);

        assertEquals("1-> 3-> 5-> 7", doublyLinkedList.returnStringList());
    }


    @Test
    void removeFirst() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addEnd(1);
        doublyLinkedList.addEnd(3);
        doublyLinkedList.addEnd(5);
        doublyLinkedList.addEnd(7);
        assertEquals(1, doublyLinkedList.removeFirst());
    }

    @Test
    void removeLast() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addEnd(1);
        doublyLinkedList.addEnd(3);
        doublyLinkedList.addEnd(5);
        doublyLinkedList.addEnd(7);
        assertEquals(7, doublyLinkedList.removeLast());
    }
}