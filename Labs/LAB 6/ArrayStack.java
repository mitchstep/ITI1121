/**
 * ITI 1121. Introduction à l'informatique II (Hiver 2008).
 * ITI 1521. Introduction to Computer Science II (Winter 2008).
 *
 * @author Marcel Turcotte, Université d'Ottawa/University of Ottawa
 */

public class ArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell

    @SuppressWarnings( "unchecked" )

    // Constructor

    public ArrayStack( int capacity ) {
        elems = (E[]) new Object[ capacity ];
        top = 0;
    }

    public int getTop() {
        return top;
    }

    // Returns true if this ArrayStack is empty

    public boolean isEmpty() {

        // Same as:
        // if ( top == 0 ) {
        //     return true;
        // } else {
        //     return false;
        // }

        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it

    public E peek() {

        // pre-conditions: ! isEmpty()

        return elems[ top-1 ];
    }

    // Removes and returns the top element of this stack

    public E pop() {

        // pre-conditions: ! isEmpty()

        // *first* decrements top, then access the value!
        E saved = elems[ --top ];

        elems[ top ] = null; // scrub the memory!

        return saved;
    }

    // Puts the element onto the top of this stack.

    public void push( E element ) {

        // Pre-condition: the stack is not full

        // *first* stores the element at position top, then increments top

        elems[ top++ ] = element;
    }

    @Override
    public void clear() {
        this.top = 0;
    }
}