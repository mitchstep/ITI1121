public class Cashier {

    // Constant

    private static final String nl = System.getProperty( "line.separator" );

    // Instance variables

    private Queue<Customer> queue;
    private Customer currentCustomer;

    private int totalCustomerWaitTime;
    private int customersServed;
    private int totalItemsServed;

    // constructor

    public Cashier(){
        this.queue = new ArrayQueue<>();
        this.currentCustomer = null;
        this.totalCustomerWaitTime = 0;
        this.customersServed = 0;
        this.totalItemsServed = 0;
    }

    public void addCustomer( Customer c ) {
        this.queue.enqueue(c);
    }

    public int getQueueSize() {
        return this.queue.size();
    }

    public void serveCustomers( int currentTime ){
        if (this.queue.size()>0) {
            this.currentCustomer = queue.dequeue();
            totalCustomerWaitTime +=   this.currentCustomer.getArrivalTime() - currentTime ;
            while (currentCustomer.getNumberOfItems()>0) {
                currentCustomer.serve();
            }
            totalItemsServed += currentCustomer.getNumberOfServedItems();
            customersServed++;
        }
    }


    public int getTotalCustomersServed() {
        return customersServed;
    }

    public int getTotalCustomerWaitTime(){
        return totalCustomerWaitTime;
    }

    public int getTotalItemsServed() {
        return totalItemsServed;
    }


    public String toString() {

        StringBuffer results = new StringBuffer();

        results.append( "The total number of customers served is " );
        results.append( customersServed );
        results.append( nl );

        results.append( "The average number of items per customer was " );
        results.append( totalItemsServed / customersServed );
        results.append( nl );

        results.append( "The average waiting time (in seconds) was " );
        results.append( totalCustomerWaitTime / customersServed );
        results.append( nl );

        return results.toString();
    }
}