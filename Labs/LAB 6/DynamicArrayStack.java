public class DynamicArrayStack<E> implements Stack<E> {

    // Instance variables

    private E[] elems;  // Used to store the elements of this ArrayStack
    private int top;    // Designates the first free cell
    private static final int DEFAULT_INC = 25;   //Used to store default increment / decrement

    @SuppressWarnings( "unchecked" )

    // Constructor
    public DynamicArrayStack( int capacity ) {
        capacity = DEFAULT_INC*(capacity/DEFAULT_INC+1);
        elems = (E[]) new Object[ capacity ];
        top = 0;
    }

    // Gets current capacity of the array
    public int getCapacity() {
        return elems.length;
    }

    // Returns true if this DynamicArrayStack is empty
    public boolean isEmpty() {
        return ( top == 0 );
    }

    // Returns the top element of this ArrayStack without removing it
    public E peek() {
        return elems[ top-1 ];
    }

    @SuppressWarnings( "unchecked" )

    // Removes and returns the top element of this stack
    public E pop() {
        E pop = peek();
        top--;
        if (top%DEFAULT_INC==0){
            downSize(top);
        }
        return pop;
    }

    @SuppressWarnings( "unchecked" )

    // Puts the element onto the top of this stack.
    public void push( E element ) {
        if(top+1>getCapacity()){
            upSize();
        }
        elems[top]= element;
        top++;
    }

    @SuppressWarnings( "unchecked" )

    public void clear() {
        top = 0;
        downSize(DEFAULT_INC);
    }

    @SuppressWarnings( "unchecked" )
    private void upSize(){
        E[] temp = elems;
        elems = (E[]) new Object[top+DEFAULT_INC];
        for (int i = 0; i < top; i++){
            elems[i]=temp[i];
        }
    }

    @SuppressWarnings( "unchecked" )
    private void downSize(int size){
        E[] temp = elems;
        elems = (E[]) new Object[size];
        for (int i = 0; i < top; i++){
            elems[i]=temp[i];
        }
    }

}