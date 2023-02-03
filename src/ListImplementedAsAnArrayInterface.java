public interface ListImplementedAsAnArrayInterface<E> {
    public E set(int index, E element);


    public E get(int index);

    public boolean append(E e);

    public void add(int index, E element);

    public E remove(int index);

    public int search(E element);

    public boolean rangeCheck();
}
