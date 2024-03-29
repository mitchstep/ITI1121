/**
 * A doubly linked list. This implementation uses a dummy node. We use
 * a linked list to store matches in the class Pastiche.
 *
 * @author Marcel Turcotte (marcel.turcotte@uottawa.ca)
 */

import java.util.NoSuchElementException;

public class LinkedList<E> {

    private static class Elem<T> {
        
        private T value;
        private Elem<T> previous, next;

        public Elem(T value, Elem<T> previous, Elem<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
        
    }

    private final Elem<E> head;
    private int size;

    /**
     * Constructs an empty list.
     */

    public LinkedList() {
        head = new Elem<E>(null, null, null);
        head.previous = head.next = head;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements int this list
     */
    
    public int size() {
        return size;
    }

    // Helper method, adds an element after the specified node
    
    private void addAfter(Elem<E> before, E value) {
        Elem<E> after = before.next;
        before.next = new Elem<E>(value, before, after);
        after.previous = before.next;
        size++;
    }

    // Helper method, removes the element after the specified node
    
    private void removeAfter(Elem<E> before) {
        Elem<E> after = before.next.next;
        before.next = after;
        after.previous = before;
        size--;
    }

    /**
     * Adds an element at the begining of this list.
     *
     * @param value the value to be added
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public void addFirst(E value) {

        if (value == null) {
            throw new NullPointerException();
        }
        
        addAfter(head, value);
    }
    
    /**
     * Adds an element at the end of this list.
     *
     * @param value the value to be added
     * @throws NullPointerException if the value of the parameter is null
     */
    
    public void addLast(E value) {

        if (value == null) {
            throw new NullPointerException();
        }
        
        addAfter(head.previous, value);
    }

    /**
     * Adds an element at the specified of this list.
     *
     * @param pos the specified position
     * @param value the value to be added
     * @throws NullPointerException if the value of the parameter is null
     * @throws IndexOutOfBoundsException if the position is out of range
     */
    
    public void add(int pos, E value) {

        if (value == null) {
            throw new NullPointerException();
        }
        
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        Elem<E> before = head;
        
        for (int i=0; i<pos; i++) {
            addAfter(before, value);
        }

    }

    /**
     * Removes the first element of the list.
     *
     * @throws NoSuchElementException if the list is empty
     */
    
    public void removeFirst() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        removeAfter(head);
    }
    
    /**
     * Removes the last element of the list.
     *
     * @throws NoSuchElementException if the list is empty
     */
    
    public void removeLast() {

        if (size == 0) {
            throw new NoSuchElementException();
        }

        removeAfter(head.previous.previous);
    }

    /**
     * Returns the element at the specified position
     *
     * @param pos the specified position
     * @return the value found at the specified position
     * @throws IndexOutOfBoundsException if the specified position is out of range
     */
    
    public E get(int pos) {
        
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        Elem<E> current = head.next;

        for (int i=0; i<pos; i++) {
            current = current.next;
        }

        return current.value;
    }

    /**
     * Returns an array containing all of the elements in this list in
     * proper sequence (from first to last element). As you know, we
     * cannot create arrays of generic types. Here we circumvent the
     * problem by asking the caller to create the array for us. The
     * caller knows both the runtime type and the number of
     * elements. See Pastiche.allPairs for an example.
     *
     * @param elems the reference of array where the elements will be stored.
     * @return the reference of the array
     * @throws IllegalArgumentException if the size of the array is not exactly the same as the size of this list
     */
    
    public E[] toArray(E[] elems) {

        if (elems.length != size) {
            throw new IllegalArgumentException("the length of the array should be: " + Integer.toString(size));
        }

        Elem<E> current = head.next;

        for (int i=0; i<size; i++) {
            elems[i] = current.value;
            current = current.next;
        }

        return elems;
    }

    /**
     * Returns a String representation of this list.
     *
     * @return a String representation of this list
     */

    @Override
    
    public String toString() {

        StringBuilder buffer;
        buffer = new StringBuilder("[");
        
        Elem<E> current = head.next;

        while (current != head) {
            if (buffer.length() > 1) {
                buffer.append(", ");
            }
            buffer.append(current.value.toString());
            current = current.next;
        }

        buffer.append("]");
        
        return buffer.toString();
    }

}
