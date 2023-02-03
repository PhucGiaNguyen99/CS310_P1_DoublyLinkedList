import java.util.Arrays;

public class ListImplementedAsAnArray<E> {
    /**
     * Default initial capacity of the array.
     */
    private final int DEFAULT_CAPACITY = 10;

    /**
     * The size of the list ( the number of elements in the list).
     **/
    private int size = 0;
    /**
     * Array to store data.
     */
    private E[] elementsData;

    /**
     * Shared empty array instance used for default sized empty instances to know how much to inflate when first element is added.
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * Construct and empty list with an initial capacity of ten.
     */
    public ListImplementedAsAnArray() {
        this.elementsData = (E[]) DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * Initial the array with given initial capacity.
     *
     * @param initialCap given initial capacity
     * @throw IllegalArgumentException if the given initial capacity is smaller than or equal to 0
     */
    public ListImplementedAsAnArray(int initialCap) {
        if (initialCap > 0) {
            this.elementsData = (E[]) new Object[initialCap];
        } else {
            throw new IllegalArgumentException("Illegal capacity: " + initialCap);
        }
    }
    /**
     * Initialize the array with the DEFAULT_CAPACITY.
     */
    //public ListImplementedAsAnArray() {
    //  this.elementsData = (E[]) new Object[DEFAULT_CAPACITY];
    //}

    /**
     * Increase the capacity of the list, if necessary, to ensure that it can hold at least the number
     * of elements specified by the minimum capacity argument.
     * If the list is not equal to the empty list, then we don't need to expand anything. Otherwise, we need to expand
     * the list to the desired minimum capacity.
     *
     * @param minCapacity the desired minimum capacity
     */
    public void ensureCapacity(int minCapacity) {
        int minExpand = (elementsData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) ? 0 : DEFAULT_CAPACITY;

        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementsData.length > 0)
            grow(minCapacity);
    }


    /**
     * Set given element at given index.
     *
     * @param index   given index to set element into
     * @param element given element to set
     * @return old element at this index
     */
    public E set(int index, Object element) {
        // do range check for the given index
        rangeCheck(index);
        E oldElement = elementsData[index];
        return oldElement;
    }

    /**
     * Return element at given index of the array.
     *
     * @param index given index to return the element at
     * @return element at given index of the array
     */
    public Object get(int index) {
        rangeCheck(index);
        return elementsData[index];
    }

    /**
     * Append given element to the end of the list.
     *
     * @param e element to be appended to the list
     * @return true if append successfully
     */
    public boolean append(E e) {
        ensureCapacityInternal(size + 1);
        elementsData[size++] = e;
        return true;
    }

    /**
     * Insert given element at given index of the array.
     * Shifts the element currently at that index (if any) and any subsequent elements to the right (adds one to their indices).
     *
     * @param index   index at which the given eleement to be inserted
     * @param element given element to be inserted
     * @throw IndexOutOfBoundsException if the index is out of range O ( index < 0 || index > size)
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);

        // shift the part from the element at index to the element at the index size-1 to one position to the right
        System.arraycopy(elementsData, index, elementsData, index + 1, size - index);
        elementsData[index] = element;
        size++;
    }

    public void ensureCapacityInternal(int minCapacity) {
        // if the minCapacity > the length of the list
        if (minCapacity - elementsData.length > 0) {
            grow(minCapacity);
        }
    }

    /**
     * Increase the capacity to ensure that it can hold at least the number of elements specified by
     * the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementsData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity > 0) {
            newCapacity = minCapacity;
        }
        elementsData = Arrays.copyOf(elementsData, newCapacity);
    }


    /**
     * Remove the element at the specified position in the list. Shift any subsequent to the left.
     *
     * @param index given index of the element to be removed
     * @return the element at the given index
     */
    public E remove(int index) {
        rangeCheck(index);

        E oldElement = elementsData[index];
        int numShifted = size - index - 1;
        if (numShifted > 0) {
            System.arraycopy(elementsData, index + 1, elementsData, index, numShifted);
        }
        elementsData[--size] = null;
        return oldElement;
    }

    public int search(Object element) {
        return 0;
    }

    /**
     * Check if the given index in the range (smaller than size and not negative).
     *
     * @param index given index to check
     * @throw IndexOutOfBoundsException if index >= size || index < 0
     */
    public void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsIndexMsg(index));
        }
    }

    /**
     * A version of rangeCheck used by add and addAll.
     *
     * @param index given index to check
     */
    public void rangeCheckForAdd(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsIndexMsg(index));
        }
    }

    /**
     * Create a string with given index and size of the array.
     *
     * @param index given out of bound index
     * @return String of index out of boound
     */
    public String outOfBoundsIndexMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


}
