public class Customer {

    // Constant

    private static final int MAX_NUM_ITEMS = 25;

    // Instance variables

    private int arrivalTime;
    private int numberOfItems;
    private int initialNumberOfItems;

    // Constructor

    public Customer( int arrivalTime ) {
        this.arrivalTime = arrivalTime;
        this.numberOfItems = (int) ( ( MAX_NUM_ITEMS - 1 ) * Math.random() ) + 1;;
        this.initialNumberOfItems = numberOfItems;
    }

    // Access methods

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getNumberOfServedItems() {
        return initialNumberOfItems - numberOfItems;
    }

    public void serve() {
        numberOfItems--;
    }
}