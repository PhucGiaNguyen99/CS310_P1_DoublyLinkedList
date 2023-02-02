/**
 * Class to represent a doubly linked list.
 */
public class DoublyLinkedList {
    // Initialize the linked list with head and tail are set to null
    DLLNode head, tail;


    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Check if the linked list is empty by checking if head is null.
     *
     * @return true if the linked list is empty. Otherwise, return false.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Print out the linked list.
     */
    public String returnStringList() {
        // create a pointer pointing to head.
        DLLNode current = head;
        if (isEmpty()) {
            System.out.println("Doubly linked list is empty!");
            return null;
        } else {
            // print out the linked list in the format: A-> B-> C
            String resString = "";
            while (current != null) {
                resString += current.getData();
                if (current.getNext() != null) {
                    resString += "-> ";
                }
                // increment current node to the next node
                current = current.getNext();
            }
            return resString;
        }
    }

    /**
     * Add a new node to the end of the linked list.
     *
     * @param newData data of the new node
     */
    public void addEnd(int newData) {
        // create a new node with the given data
        DLLNode newNode = new DLLNode(newData);

        // if the linked list is empty, point head and tail to the new node
        if (isEmpty()) {
            head = tail = newNode;

            // set prev of head and next of tail to null
            head.setPrev(null);
            tail.setNext(null);
        }
        // otherwise, set new node next to tail
        else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
            tail.setNext(null);
        }
    }

    /**
     * Add a new node to the front of the linked list.
     *
     * @param newData data of the new node
     */
    public void addFront(int newData) {
        // create a new node with the given data
        DLLNode newNode = new DLLNode(newData);

        // if the linked list is empty, point head and tail to the new node
        if (isEmpty()) {
            head = tail = newNode;

            // set prev of head and next of tail to null
            head.setPrev(null);
            tail.setNext(null);
        }
        // otherwise, set new node to the prev of the head
        else {
            head.setPrev(newNode);
            newNode.setNext(head);
            head = newNode;
            head.setPrev(null);
        }
    }

    /**
     * Remove the first node of the linked list.
     *
     * @return data of firstNode the old head of the linked list. If the linked list is empty, return -1
     */
    public int removeFirst() {
        if (isEmpty()) {
            System.out.println("The linked list is empty!");
            return -1;
        } else {
            DLLNode firstNode = head;
            DLLNode newHead = head.getNext();
            head.setNext(null);
            head = newHead;
            head.setPrev(null);
            return firstNode.getData();
        }
    }

    /**
     * Remove the last node of the linked list.
     *
     * @return data of lastNode the old tail of the linked list
     */
    public int removeLast() {
        if (isEmpty()) {
            System.out.println("The linked list is empty!");
            return -1;
        } else {
            DLLNode lastNode = tail;
            DLLNode newTail = tail.getPrev();
            tail.setPrev(null);
            tail = newTail;
            tail.setNext(null);
            return lastNode.getData();
        }
    }

    public static void main(String[] args) {

    }

}
